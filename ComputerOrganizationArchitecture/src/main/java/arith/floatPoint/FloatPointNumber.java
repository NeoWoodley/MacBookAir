//package arith.floatPoint;
//
//public class FloatPointNumber {
//	char sign;  // 符号1bit
//	char[] falseSignificand;  // 有效数23bit
//	char[] realSignificand;  // 真实的有效数，会添加上隐藏的'1'
//	final static char base = '2';  // 基值，隐含的
//	char[] falseExponent;  // 带偏阶的指数8bit
//	int falseDecimalExponent;  // 带偏阶的指数十进制表示，范围是[0,255]
//	int realExponent;  // 记录真实的指数
//	final static int lengthOfSignificand = 23;
//	final static int lengthOfExponent = 8;
//	final static int baised = 127;  // 偏值，是一个固定值
//	final static int lengthOfFormat = 32;
//	final String zeroSignificand = "00000000";
//	int decimal;  // 记录十进制下的小数值
//	boolean isZero;  // falseExponent=0，falseSignificand=0
//	boolean isInfinite;  // falseExponent=全1，falseSignificand=0
//	boolean isDenormalized;  // falseExponent=0，falseSignificand!=0
//	boolean isNaN;  // falseExponent=全1，falseSignificand!=0
//	char[] tempSignificand;  // 记录对完阶后的有效数，包含了隐藏位；默认初始化为realSignificand
//	char[] tempExponent;  // 记录对完阶后的带偏阶的指数；默认初始化为falseExponent
//
//	public FloatPointNumber(char sign, char[] realSignificand, int falseDecimalExponent) {
//		this.sign = sign;
//		this.falseDecimalExponent = falseDecimalExponent;
//		this.falseExponent=
//	}
//
//	public String toString() {
//		return sign + String.valueOf(falseExponent) + String.valueOf(falseSignificand);
//	}
//
//}
