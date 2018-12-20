package arith.floatPoint;

/**
 * 单精度浮点数运算器，32位
 */
public class FloatPointManger {
	FloatPoint A;
	FloatPoint B;
	FloatPoint result;
	// 定义溢出异常
	final String EXPONENT_OVERFLOW = "Exponent overflow";
	final String EXPONENT_UNDERFLOW = "Exponent underflow";
	final String SIGNIFICAND_OVERFLOW = "Significand overflow";
	final String SIGNIFICAND_UNDERFLOW = "Significand underflow";
	boolean isExponentOverflow;
	boolean isExponentUnderflow;
	boolean isSignificandOverflow;
	boolean isSignificandUnderflow;
	char[] register1;
	char[] register2;
	private int lengthOfOperand;  // 记录将要在寄存器中相加的两个操作数的长度，这两个操作数长度必相等
	private int carry1;  // 向高位的进位
	private int carry0;  // 向低位的进位
	private int sum;  // 和
	private int presentBit1;
	private int presentBit2;
	private char[] registerResult;
	private boolean isOverflow;
	boolean isHighestBitCarried;  // 记录加法后，寄存器中最高位是否有进位





	// 内部类，用于表示浮点数对象
	class FloatPoint {

		char sign;  // 符号1bit
		char[] falseSignificand;  // 有效数23bit
		char[] realSignificand;  // 真实的有效数，会添加上隐藏的'1'
		final static char base = '2';  // 基值，隐含的
		char[] falseExponent;  // 带偏阶的指数8bit
		int realExponent;  // 记录真实的指数
		final static int lengthOfSignificand = 23;
		final static int lengthOfExponent = 8;
		final static int baised = 127;  // 偏值，是一个固定值
		final static int lengthOfFormat = 32;
		final String zeroSignificand = "00000000";
		int decimal;  // 记录十进制下的小数值
		boolean isZero;  // falseExponent=0，falseSignificand=0
		boolean isInfinite;  // falseExponent=全1，falseSignificand=0
		boolean isDenormalized;  // falseExponent=0，falseSignificand!=0
		boolean isNaN;  // falseExponent=全1，falseSignificand!=0
		char[] tempSignificand;  // 记录对完阶后的有效数，包含了隐藏位；默认初始化为realSignificand
		char[] tempExponent;  // 记录对完阶后的带偏阶的指数；默认初始化为falseExponent
		// TODO: 2018-12-11 保护位、粘贴位

		public FloatPoint(String format) {
			sign = format.charAt(0);
			falseSignificand = format.substring(9).toCharArray();
			falseExponent = format.substring(1, 9).toCharArray();
			realSignificand = ('1' + format.substring(9)).toCharArray();
			realExponent=Integer.valueOf(String.valueOf(falseExponent), 2)-baised;  // TODO: 2018-12-12 我不知道这里用什么类型比较好
			if (format.substring(9).equals(zeroSignificand)) {
				isZero = true;
			}
		}

		public FloatPoint() {

		}

		/**
		 * 该构造函数生成的"浮点数"不能保证是"规格化数"，需要进行检查、规格化
		 * @param sign
		 * @param falseExponent
		 * @param falseSignificand
		 */
		public FloatPoint(char sign, char[] falseExponent, char[] falseSignificand) {
			this.sign = sign;
			this.falseExponent = falseExponent;
			this.falseSignificand = falseSignificand;
		}

		@Override
		public String toString() {
			return sign + String.valueOf(falseExponent) + String.valueOf(falseSignificand);
		}

		/**
		 * falseExponent=0，falseSignificand=0
		 *
		 * @return
		 */
		public boolean isZero() {
			if (Integer.valueOf(String.valueOf(falseExponent)) == 0 && Integer.valueOf(String.valueOf(falseSignificand)) == 0) {
				isZero = true;
			} else {
				isZero = false;
			}
			return isZero;
		}

		/**
		 * falseExponent=全1，falseSignificand=0
		 *
		 * @return
		 */
		public boolean isInfinite() {
			if (Integer.valueOf(String.valueOf(falseExponent)) == 11111111 && Integer.valueOf(String.valueOf(falseSignificand)) != 0) {
				return isInfinite = true;
			} else {
				isInfinite = false;
			}
			return isInfinite;
		}

		/**
		 * falseExponent=0，falseSignificand!=0
		 *
		 * @return
		 */
		public boolean isDenormalized() {
			if (Integer.valueOf(String.valueOf(falseExponent)) == 0 && Integer.valueOf(String.valueOf(falseSignificand)) != 0) {
				isDenormalized = false;
			} else {
				isDenormalized = true;
			}
			return isDenormalized;
		}

		/**
		 * falseExponent=全1，falseSignificand!=0
		 *
		 * @return
		 */
		public boolean isNaN() {
			if (Integer.valueOf(String.valueOf(falseExponent)) == 11111111 && Integer.valueOf(String.valueOf(falseExponent)) != 0) {
				isNaN = true;
			} else {
				isNaN = false;
			}
			return isNaN;
		}

		public boolean canBeNormalized() {
			// TODO: 2018-12-11 判断是否可以规格化
			return false;
		}

		public void toNegative() {
			if (sign == '1') {
				sign = '0';
			}
			if (sign == '0') {
				sign = '1';
			}
		}
	}

	public void add(String num1, String num2) {
		A = new FloatPoint(num1);
		B = new FloatPoint(num2);
		add();
	}

	private void add() {
		// 检查零
		if (A.isZero) {
			result = B;
			return;
		}
		if (B.isZero) {
			result = A;
			return;
		}
		// 对阶
		matchExponents(A,B);
		// 带符号有效值相加
		addSignificands();


	}

	public void minus(String num1, String num2) {
		A = new FloatPoint(num1);
		B = new FloatPoint(num2);
		minus();
	}

	/**
	 * 减法转变成加法来做，只要把B操作数的符号为取反即可
	 */
	private void minus() {
		B.toNegative();
		add();
	}

	/**
	 * 完成对阶操作
	 * 设置对完阶后的有效数、带偏阶的指数
	 *
	 * @param A
	 * @param B
	 */
	private void matchExponents(FloatPoint A, FloatPoint B) {
		int result = A.realExponent - B.realExponent;
		if (result > 0) {
			shiftRightSignificand(B,result);
		} else if (result < 0) {
			shiftRightSignificand(A,-result);
		}
	}

	/**
	 * 右规
	 *
	 * @param shiftRightNumOfBit  需要右移的位数
	 */
	private void shiftRightSignificand(FloatPoint num, int shiftRightNumOfBit) {
		String temp = String.valueOf(num.realSignificand);
		for (int i = 0; i < shiftRightNumOfBit; i++) {
			temp = '0' + temp.substring(0, temp.length() - 1);
		}
		num.tempSignificand = temp.substring(0,23).toCharArray();
	}

	/**
	 * 初始化lengthOfOperand的长度
	 * 将寄存器1、2中的值相加，结果存放在registerResult变量中
	 */
	private void addRegister() {
		assert register1.length == register2.length;  // 此处寄存器1、2中存放的操作数长度应当要一致
		lengthOfOperand = register1.length;
		for (int i = lengthOfOperand - 1; i >= 0; i--) {
			presentBit1 = Integer.valueOf(String.valueOf(register1[i]));
			presentBit2 = Integer.valueOf(String.valueOf(register2[i]));
			carry1 = presentBit1 & presentBit2 | presentBit1 & carry0 | presentBit2 & carry0;  // 逻辑与运算后，再求逻辑和
			sum = presentBit1 ^ presentBit2 ^ carry0;
			registerResult[i] = Character.forDigit(sum, 10);
			// 为下一次运算做准备
			if (i != 0) {
				carry0 = carry1;
			}
		}
		isHighestBitCarried();
	}

	private void minusRegister() {
		register2 = toComplement(register2);
		addRegister();
	}

	private void isHighestBitCarried() {
		isHighestBitCarried = carry0 != carry1;
	}

	char[] toComplement(char[] num) {
		return addOne(toNegation(num));
	}

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

	/**
	 * 在对寄存器1、2进行相加操作前，先初始化
	 */
	private void initAddRegister() {
		carry0 = 0;
		carry1 = 0;
		sum = 0;
		registerResult = new char[lengthOfOperand];
		isOverflow = false;
	}

	private void shiftRightSignificand(FloatPoint num) {

	}

	public void addSignificands() {
		addSignificands(A.sign, A.realSignificand, B.sign, B.realSignificand,A.tempExponent);
	}

	/**
	 * 符号-幅值加法
	 * 算法：
	 * 1、两个操作数符号相同，做加法
	 * 加法：直接相加
	 * 若最高位有进位，则上溢
	 * 结果符号与两个操作数相同
	 * 2、两个操作数符号不同，做减法
	 * 减法：加上第二个操作数的补码
	 * 如果最高位有进位，则正确，符号和被减数保持一致
	 * 如果最高位没有进位，则计算该结果的补码，符号和被减数相反
	 *
	 * 结果存在registerResult中
	 */
	private void addSignificands(char sign1, char[] significand1, char sign2, char[] significand2, char[] falseExponent) {
		result = new FloatPoint();
		result.falseExponent = falseExponent;
		if (sign1 == sign2) {
			add(significand1, significand2);
			result.realSignificand = registerResult;  // 设置有效值
			result.sign = sign1;
			if (isHighestBitCarried) {
				handleSignificandOverflow(result);
			}
		} else {
			minus(significand1, significand2);
			result.realSignificand = registerResult;  // 设置有效值
			if (isHighestBitCarried) {
				result.sign = sign1;
			} else {
				registerResult = toComplement(registerResult);
				result.sign = sign2;
			}
		}
	}

	/**
	 * 如果有效值等于零，设置为"零浮点数"，即有效数为'0'，带偏阶的阶值为'0'
	 * @param num
	 */
	private void checkZeroSignificand(FloatPoint num) {
		boolean flag = true;
		for (char c : num.realSignificand) {
			if (c == '0') {
				flag = false;
			}
		}
		if (false) {
			num.falseExponent = "00000000".toCharArray();
		}

	}

	private void handleSignificandOverflow(FloatPoint num) {
		shiftRightSignificand(num, 1);
		add(num.falseExponent,"00000001".toCharArray());
		num.falseExponent = registerResult;
		if (isExponentOverflow(num)) {
			System.out.println(EXPONENT_OVERFLOW);
		}
	}

	private boolean isExponentOverflow(FloatPoint num) {
		char[] temp = num.falseExponent;
		if (String.valueOf(temp).equals("11111111")) {
			return true;
		}
		return false;
	}

	private void add(char[] num1, char[] num2) {
		register1 = num1;
		register2 = num2;
		addRegister();
	}

	private void minus(char[] num1, char[] num2) {
		register1 = num1;
		register2 = toComplement(num2);
		addRegister();
	}
	public void minusSignificands() {

	}

	public void NormalizeResult() {

	}
}
