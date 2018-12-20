package arith.integer.signed;

import java.util.Arrays;

/**
 * 所有的减法转换为加法
 */
public class SignedIntegerManger {
	private int carry1;  // 向高位的进位
	private int carry0;  // 向低位的进位
	private int sum;  // 和
	private int presentBit1;  // 当前位
	private int presentBit2;
	private char[] result;  // 记录运算结果
	int isPositive;  // 最后结果是否是正数
	private boolean isOverflow;
	private final String OVERFLOW = "Overflow";
	private int lengthOfOperand;  // 记录操作数长度
	// 寄存器组
	private char[] registerQ;  // 乘数-->乘法结果2；被除数-->商
	private char[] registerM;  // 被乘数；除数
	private char[] registerA;  // 乘法结果1；余数
	private int markQ;  // markQ-1标志位
	private char signOfA;  // 记录被除数的符号
	private char signOfB;  // 记录除数的符号
	private char Qn='0';  // 用于暂存商，等到联合左移后，就把商寄存器的最低位置为Qn；初始化为'0'

	// 两个操作数
	private char[] A;  // 前一个操作数
	private char[] B;  // 后一个操作数
	private char[] complementOfOperand;  // 在乘法运算时，记录被乘数的补码值;在除法运算时，记录除数的补码值
	// 循环计数器
	@Deprecated
	private int count;  // 这个变量可能不需要

	public String add(String num1, String num2) {
		// 对两个成员变量：操作数赋值
		this.A = num1.toCharArray();
		this.B = num2.toCharArray();
		add();
		return isOverflow ? OVERFLOW : String.valueOf(result);
	}

	public String minus(String num1, String num2) {
		// 对两个成员变量：操作数赋值
		this.A = num1.toCharArray();
		this.B = num2.toCharArray();
		minus();
//		this.A = num1.toCharArray();
//		this.B = toComplement(num2.toCharArray());
//		add();
		return isOverflow ? OVERFLOW : String.valueOf(result);
	}

	public String multiply(String num1, String num2) {
		this.A = num1.toCharArray();
		this.B = num2.toCharArray();
		multiply();
		return isOverflow ? OVERFLOW : String.valueOf(registerA) + String.valueOf(registerQ);
	}

	/**
	 * @param num1
	 * @param num2
	 * @return 返回值是余数与商共同构成的String
	 */
	public String recoverDivide(String num1, String num2) {
		this.A = num1.toCharArray();
		this.B = num2.toCharArray();
		recoverDivide();
		return isOverflow ? OVERFLOW : String.valueOf(registerA)+String.valueOf(registerQ);
	}

	public String unrecoverDivide(String num1, String num2) {
		this.A = num1.toCharArray();
		this.B = num2.toCharArray();
		unrecoverDivide();
		return isOverflow ? OVERFLOW : String.valueOf(registerA) + String.valueOf(registerQ);
	}

	private void unrecoverDivide() {
		// 两个操作数长度对齐，进行符号扩展
		align();
		init();
		// 初始化，被除数进行符号扩展，扩展n位，将它储存在余数寄存器和商寄存器中
		initDivide();

		// 如果被除数和除数符号相同，做减法；否则做加法
		// 如果新的部分余（余数寄存器）和除数有相同的符号，则Q_n=1；否则，Q_n=0
		if (signOfA == signOfB) {
			minusRegisterM();
		} else {
			addRegisterM();
		}
		if (registerA[0] == registerM[0]) {
			Qn = '1';
		} else {
			Qn = '0';
		}

		for (int i = 0; i < lengthOfOperand; i++) {
			// A、Q联合左移，为接下来上商在寄存器Q的最低位空出一个位置
			shiftLeftArithmeticRegister();

			// 如果被除数（即部分余）和除数符号相同，做减法；否则做加法
			if (registerA[0]==registerM[0]) {
				minusRegisterM();
			} else {
				addRegisterM();
			}
			// 如果新的部分余和除数有相同的符号，则Q_n=1；否则，Q_n=0
			if (registerA[0] == registerM[0]) {
				Qn= '1';
			} else {
				Qn= '0';
			}
		}
		// 调整商：左移商，如果商是负的（被除数和除数符号不同），商就加一
		shiftLeftRegisterQ();  // Q、Qn联合左移
		if (registerQ[0] == '1') {
			registerQ = addOne(registerQ);
		}
		// 调整余数：保证余数与被除数符号相同
		// 如果余数和被除数符号不同：
		// 1、如果被除数和除数符号相同，那么余数就加上除数；
		// 2、否则余数就减去除数
		if (registerA[0] != signOfA) {
			if (signOfA==signOfB) {
				addRegisterM();
			} else {
				minusRegisterM();
			}
		}
	}

	/**
	 * 将寄存器A、Q、markQ-1算术右移
	 */
	private void shiftRightArithmeticRegister() {
		String temp = String.valueOf(registerA) + String.valueOf(registerQ) + markQ;
		temp = temp.charAt(0) + temp.substring(0, temp.length() - 1);
		registerA = temp.substring(0, lengthOfOperand).toCharArray();
		registerQ = temp.substring(lengthOfOperand, 2 * lengthOfOperand).toCharArray();
		markQ = Integer.valueOf(String.valueOf(temp.charAt(2 * lengthOfOperand)));  // 或者减去'0'来进行char转int
	}

	/**
	 * 将寄存器Q（商寄存器）左移一位，右边补Qn
	 */
	private void shiftLeftRegisterQ() {
		String temp = String.valueOf(registerQ);
		registerQ = (temp.substring(1) + Qn).toCharArray();
	}

	/**
	 * 将寄存器A、Q左移，Q最低位补'0'
	 */
	 void shiftLeftArithmeticRegister() {
		String temp = String.valueOf(registerA) + String.valueOf(registerQ);
		temp = temp.substring(1, temp.length()) + Qn;
		registerA = temp.substring(0, lengthOfOperand).toCharArray();
		registerQ = temp.substring(lengthOfOperand, 2 * lengthOfOperand).toCharArray();
	}

	private char[] add() {
		align();
		init();
		for (int i = lengthOfOperand - 1; i >= 0; i--) {
			presentBit1 = Integer.valueOf(String.valueOf(A[i]));
			presentBit2 = Integer.valueOf(String.valueOf(B[i]));
			carry1 = presentBit1 & presentBit2 | presentBit1 & carry0 | presentBit2 & carry0;  // 逻辑与运算后，再求逻辑和
			sum = presentBit1 ^ presentBit2 ^ carry0;
			result[i] = Character.forDigit(sum, 10);
			// 为下一次运算做准备
			if (i != 0) {
				carry0 = carry1;
			}
		}
		isOverflow();
		return result;
	}

	private char[] minus() {
		B = toComplement(B);
		return add();
	}

	/**
	 * 最后结果保存在寄存器A、Q中
	 */
	private void multiply() {
		align();
		init();
		initMultiply();

		// sign=-1，A=A-M
		// sign=1，A=A+M
		// sign=0，无操作
		int sign;
		for (int i = 0; i < lengthOfOperand; i++) {
			sign = markQ - Integer.valueOf(String.valueOf(registerQ[lengthOfOperand - 1]));  // 或者通过减去'0'来进行char转int的操作
			switch (sign) {
				case -1:
					minusRegisterM();
					break;
				case 1:
					addRegisterM();
					break;
				default:
					break;
			}
			shiftRightArithmeticRegister();
		}
	}

	private char[] recoverDivide() {
		// 两个操作数长度对齐，进行符号扩展
		align();
		init();
		// 初始化
		initDivide();

		char signOfRegisterA;  // 用于记录在寄存器A在加减寄存器M前，寄存器A中的值最初的符号
		// 判断余数寄存器中的值是否足够大（根据余数、除数符号是否相同，来选择是做加法还是做减法来判断），即看寄存器A、M中的值
		for (int i = 0; i < lengthOfOperand; i++) {
			// 左移余数寄存器、商寄存器
			shiftLeftArithmeticRegister();
			signOfRegisterA = registerA[0];
			if (registerA[0] == registerM[0]) {
				minusRegisterM();
				if (registerA[0] == signOfRegisterA) {
					registerQ[lengthOfOperand - 1] = '1';
				} else {
					addRegisterM();  // 恢复
					registerQ[lengthOfOperand - 1] = '0';
				}
			} else {
				addRegisterM();
				if (registerA[0] == signOfRegisterA) {
					registerQ[lengthOfOperand - 1] = '1';
				} else {
					minusRegisterM();  // 恢复
					registerQ[lengthOfOperand - 1]='0';
				}
			}
		}
		// 如果被除数和除数符号不同，就用商的补码取代计算出的商
		// 若被除数与除数符号不同，商为负
		// 若被除数与除数符号相同，商为正
		// 余数的符号始终与被除数的符号保持一致
		if (A[0] != B[0]) {
			registerQ=toComplement(registerQ);
		}
		return null;
	}

	private void align() {
		if (A.length < B.length) {
			A = align(A, B.length);
		} else {
			B = align(B, A.length);
		}
	}

	/**
	 * 将一个数符号扩展成指定长度
	 *
	 * @param num
	 * @return
	 */
	private char[] align(char[] num, int length) {
		lengthOfOperand = length;
		char signBit = num[0];
		char[] newNum = new char[lengthOfOperand];
		int oldLength = num.length;
		for (int i = 0; i < lengthOfOperand; i++) {
			if (i < lengthOfOperand - oldLength) {
				newNum[i] = signBit;
			} else {
				newNum[i] = num[i - (lengthOfOperand - oldLength)];
			}
		}
		return newNum;
	}

	/**
	 * 将一个数转换为它的补码形式
	 * 算法：取反加一
	 *
	 * @param num 要转换的数
	 * @return 返回补码形式
	 */
	char[] toComplement(char[] num) {
		return addOne(toNegation(num));
	}

	/**
	 * 取反操作
	 *
	 * @param num 要取反的char[]
	 * @return 返回取反结果
	 */
	char[] toNegation(char[] num) {
		char[] newNum = new char[num.length];
		for (int i = 0; i < num.length; i++) {
			if (num[i] == '1') {
				newNum[i] = '0';
			} else if (num[i] == '0') {
				newNum[i] = '1';
			}
		}
		return newNum;
	}

	char[] addOne(char[] num) {
		char[] newNum = new char[num.length];
		int carry1 = 0;  // 向高位的进位
		int carry0 = 1;  // 来自低位的进位，可以看作是加一的一的来源
		int presentBit = 0;
		for (int i = num.length - 1; i >= 0; i--) {
			if (num[i] == '0') {
				presentBit = 0;
			} else if (num[i] == '1') {
				presentBit = 1;
			}
			newNum[i] = Character.forDigit(presentBit ^ carry0, 10);  // 亦或运算;
			// 设置向高位的进位
			carry1 = presentBit & carry0;
			// 设置下一次运算中来自低位的进位
			carry0 = carry1;
		}
		return newNum;
	}

	private void isOverflow() {
		isOverflow = carry0 != carry1;
	}

	private void init() {
		carry0 = 0;
		carry1 = 0;
		sum = 0;
		result = new char[lengthOfOperand];
		isOverflow = false;
	}

	private void initMultiply() {
//		count = lengthOfOperand;  // 循环计数器赋初值为操作数长度
		markQ = 0;  // markQ-1标志位赋初值为0
		registerA = new char[lengthOfOperand];
		Arrays.fill(registerA, '0');  // 寄存器A赋初值为'0'
		registerM = A;  // 寄存器M赋初值为被乘数
		registerQ = B;  // 寄存器Q赋初值为乘数
		complementOfOperand = toComplement(A);
	}

	/**
	 * 初始化：被除数进行符号扩展，扩展n位，将它储存在余数寄存器A和商寄存器Q中
	 * 即余数寄存器中初始值为全00或全11，这取决于被除数的符号
	 * 而商寄存器Q则初始化为被除数
	 */
	private void initDivide() {
		registerA = new char[lengthOfOperand];
		Arrays.fill(registerA, A[0]);  // A寄存器（余数寄存器）初始化为被除数的符号位
		registerM = B;  // 除数
		registerQ = A;  // 被除数
		complementOfOperand = toComplement(B);
		signOfA = A[0];
		signOfB = B[0];
	}

	@Deprecated
	private void shiftRightArithmetic(char[] register) {
		for (int i = register.length - 1; i > 0; i--) {
			register[i] = register[i - 1];
		}
		register[0] = '0';
	}

	private void addRegisterM() {
		init();
		for (int i = lengthOfOperand - 1; i >= 0; i--) {
			presentBit1 = Integer.valueOf(String.valueOf(registerA[i]));
			presentBit2 = Integer.valueOf(String.valueOf(registerM[i]));
			carry1 = presentBit1 & presentBit2 | presentBit1 & carry0 | presentBit2 & carry0;  // 逻辑与运算后，再求逻辑和
			sum = presentBit1 ^ presentBit2 ^ carry0;
			registerA[i] = Character.forDigit(sum, 10);
			// 为下一次运算做准备
			if (i != 0) {
				carry0 = carry1;
			}
		}
	}

	/**
	 * 寄存器A中的值减去寄存器M中的值（M的补码），并将结果存储在寄存器A中
	 */
	private void minusRegisterM() {
		init();
		for (int i = lengthOfOperand - 1; i >= 0; i--) {
			presentBit1 = Integer.valueOf(String.valueOf(registerA[i]));
			presentBit2 = Integer.valueOf(String.valueOf(complementOfOperand[i]));
			carry1 = presentBit1 & presentBit2 | presentBit1 & carry0 | presentBit2 & carry0;  // 逻辑与运算后，再求逻辑和
			sum = presentBit1 ^ presentBit2 ^ carry0;
			registerA[i] = Character.forDigit(sum, 10);
			// 为下一次运算做准备
			if (i != 0) {
				carry0 = carry1;
			}
		}
//		return registerA;
	}

//	private void assignRegister() {
//
//	}

	public char[] getRegisterA() {
		return registerA;
	}

	public char[] getRegisterQ() {
		return registerQ;
	}

	public int getMarkQ() {
		return markQ;
	}

	public void setRegisterA(String num) {
		registerA = num.toCharArray();
	}

	public void setRegisterQ(String num) {
		registerQ = num.toCharArray();
	}

	public void setMarkQ(int num) {
		markQ = num;
	}

	public void setLengthOfOperand(int length) {
		lengthOfOperand = length;
	}
}
