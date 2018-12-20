package arith.integer.signed;

public class TestAlign {
	public static void main(String[] args) {
		char[] num1 = "101010".toCharArray();
		char[] num2 = "11".toCharArray();
		align(num1, num2);
		for (char c : num1) {
			System.out.print(c);
		}
		System.out.println();
		for (char c : num2) {
			System.out.print(c);
		}
	}
	/**
	 * 将两个长度不同的二进制补码数进行对齐，即符号扩展
	 * 这个方法不能用，java按值传递参数！！！
	 *
	 * @param num1
	 * @param num2
	 */
//	@Deprecated
	public static void align(char[] num1, char[] num2) {
		if (num1.length < num2.length) {
//			num1 = new char[3];
			align(num1, num2.length);
		} else if (num1.length > num2.length) {
			align(num2, num1.length);
		}
	}

	/**
	 * 将一个数符号扩展成指定长度
	 *
	 * @param num
	 * @param length
	 * @return
	 */
	static void align(char[] num, int length) {
//		lengthOfOperand = length;
		char signBit = num[0];
		char[] newNum = new char[length];
		int oldLength = num.length;
		for (int i = 0; i < length; i++) {
			if (i < length - oldLength) {
				newNum[i] = signBit;
			} else {
				newNum[i] = num[i - (length - oldLength)];
			}
		}
		num = newNum;
//		return num;
	}

}
