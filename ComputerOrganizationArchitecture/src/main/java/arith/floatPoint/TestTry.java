package arith.floatPoint;

public class TestTry {
	public static void main(String[] args) {
		String test = "001001011";
//		String test1 = "0000000000000001110";
//		System.out.println(Integer.valueOf(test) - Integer.valueOf(test1));
//
//		char[] falseExponent = test.toCharArray();
//		falseExponent =
//				String.valueOf(Integer.valueOf(String.valueOf(falseExponent),2)+Integer.valueOf("1",2)).toCharArray();
//		System.out.println(falseExponent);
		TestTry testTry = new TestTry();
		char[] test2="1010".toCharArray();
//		for (int i = 0; i < 10; i++) {
//			test2=testTry.alignExponent("10101001".toCharArray());
//		}
		System.out.println(Integer.valueOf(String.valueOf(test2),2)-9);
	}

	private char[] alignExponent(char[] num) {
		// 阶值++
		return String.valueOf(Integer.valueOf(String.valueOf(num),2)+Integer.valueOf("1",2)).toCharArray();
		// 有效值右移
//		shiftRightSignificand(num);
	}
}
