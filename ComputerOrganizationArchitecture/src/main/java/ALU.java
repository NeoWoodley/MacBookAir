//public class ALU {
//	/**
//	 * @param number 十进制整数。若为负数;则第一位为“-”;若为正数或 0，则无 符号位
//	 * @param length 二进制补码表示的长度
//	 * @return number的二进制表示，长度为length
//	 */
//	public String integerRepresentation(String number, int length) {
//		char sign;  // 符号
//		int value;
//		if (number.substring(0, 1).equals("-")) {
//			sign = '1';
//			value = Integer.valueOf(number.substring(1), 10);
//		} else {
//			sign = '0';
//			value = Integer.valueOf(number, 10);
//		}
//		return exdendSign(decimalToBinary(sign, value), length);
//	}
//
//	/**
//	 * 将一个十进制数（可正可负）转成二进制补码
//	 *
//	 * @param value
//	 * @return
//	 */
//	private String decimalToBinary(char sign, int value) {
//		String result = Integer.toBinaryString(value);
//		if (sign == '0') {
//			return '0' + result;
//		} else {
//			// 求负数补码
//			// 取反加一
//			char[] temp = ('0' + result).toCharArray();
//			for (int i = 0; i < temp.length; i++) {
//				if (temp[i] == '0') {
//					temp[i] = '1';
//				} else {
//					temp[i] = '0';
//				}
//			}
//			return addOne(temp);
//		}
//	}
//
//	private String addOne(char[] value) {
//		char[] result = new char[value.length];
//		int presentBit = Integer.valueOf(String.valueOf(value[value.length - 1]), 2);
//		int carry0;
//		int carry1 = presentBit & 1;
//		int sum = presentBit ^ 1;
//		result[value.length - 1] = Character.forDigit(sum, 2);
//		carry0 = carry1;
//		for (int i = value.length - 2; i >= 0; i--) {
//			presentBit = Integer.valueOf(String.valueOf(value[i]));
//			sum = carry0 ^ presentBit;
//			result[i] = Character.forDigit(sum, 2);  // 亦或
//			carry1 = carry0 & presentBit;
//			carry0 = carry1;
//		}
//		return String.valueOf(result);
//	}
//
//	/**
//	 * 进行符号扩展
//	 *
//	 * @param num    要进行扩展的数字
//	 * @param length 要求扩展后数字的总长度
//	 * @return 扩展后的数字字符串
//	 */
//	private String exdendSign(String num, int length) {
//		assert length >= num.length();
//		int count = length - num.length();
//		if (count == 0) {
//			return num;
//		}
//		String result = null;
//		char sign = num.charAt(0);
//		for (int i = 0; i < count; i++) {
//			result = sign + num;
//		}
//		return result;
//	}
//
//	/**
//	 * 生成十进制浮点数的二进制表示。需要考虑 0、反规格化、正负无穷(“+Inf”和“-Inf”)、NaN 等因素，具体借鉴 IEEE 754。舍入策略为向 0 舍入。
//	 *
//	 * @param number  十进制浮点数(可能为不包含小数点的整数，例如5)。若为负数;则第一位为“-”;若为正数或 0，则无符号位
//	 * @param eLength 指数的长度，取值大于等于4
//	 * @param sLength 尾数的长度，取值大于等于4
//	 * @return number的二进制表示，长度为1+eLength+sLength。从左向右，依次为符号、指数(移码表示)、尾数(首位隐藏)
//	 */
//	public String floatRepresentation(String number, int eLength, int sLength) {
//		String sign;
//		String decimalValue;
//		String exponent;
//		String significand;
//		String finalString;
//		// 分理出：符号+数值
//		if (number.substring(0, 1).equals("-")) {
//			sign = "1";
//			decimalValue = number.substring(1);
//		} else {
//			sign = "0";
//			decimalValue = number;
//		}
//		// 特殊数值处理
//		if (isZeroFloatPoint(decimalValue)) {
//			return toZeroFloatPoint(decimalValue, eLength, sLength);
//		}
//
//		// 如果是一个小数，就必定含有"."小数点
//		int[] result = new int[2];  // [1.0101010,45] -> 1.0101010*2^45
//		if (decimalValue.contains(".")) {
//			// 小数部分的值，eg: 0.002316
//			double smallNum = Double.valueOf("0" + decimalValue.substring(decimalValue.indexOf(".")));
//			// 整数部分的值，eg: 12284
//			int bigNum = Integer.valueOf(decimalValue.substring(0, decimalValue.indexOf(".")));
//			String smallNum2 = smallNumTo2(smallNum, sLength);  // 10 To 2，精度设置为尾数长度
//			String bigNum2 = Integer.toBinaryString(bigNum);
//			String format2 = bigNum2 + smallNum2.substring(1);
//			result = normalize(format2);
//		} else {
//			result = normalize(Integer.toBinaryString(Integer.valueOf(decimalValue)));
//		}
////		int test = result[0] + (int) Math.pow(2, eLength - 1);
//		result[0] = Integer.valueOf(Integer.toBinaryString(result[0] + (int) (Math.pow(2, eLength - 1) - 1)));  //
//		// 加上移码，并使用二进制表示
//		String[] resultString = normalizeLength(result, eLength, sLength);
//		finalString = sign + resultString[0] + resultString[1].substring(1);  // 将隐藏位隐藏
//
//		// 处理非规格化数
//		if (isDenormalizedFloatPoint(finalString)) {
//			return toDenormalizedFloatPoint(finalString, eLength, sLength);
//		}
//	}
//
//	/**
//	 * 0.000234 -> 0.001101
//	 *
//	 * @return
//	 */
//	private String smallNumTo2(double smallNum, int accurate) {
//		int presentBit;
//		double temp = smallNum;
//		StringBuilder builder = new StringBuilder().append("0.");
//		for (int i = 0; i < accurate; i++) {
//			temp = 2 * temp;
//			presentBit = (int) Math.floor(temp);
//			builder.append(presentBit);
//			temp = temp - presentBit;
//		}
//		return builder.toString();
//	}
//
//	/**
//	 * 110101.0101 -> 1.101010101*2^5
//	 * <p>
//	 * 11010101 -> 1.1010101*2^7
//	 *
//	 * @return
//	 */
//	private int[] normalize(String format2) {
//		int[] result = new int[2];
//		int exponent;
//		String newFormat2;
//		if (format2.contains(".")) {
//			exponent = format2.indexOf(".") - 1;
//			newFormat2 = format2.replace(".", "");
//		} else {
//			newFormat2 = format2;
//			exponent = format2.length() - 1;
//		}
//		result[0] = exponent;
//		result[1] = Integer.valueOf(newFormat2);
//		return result;
//	}
//
//	/**
//	 * 将尾数、指数长度规格化
//	 *
//	 * @param result
//	 * @param eLength
//	 * @param sLength
//	 * @return
//	 */
//	private String[] normalizeLength(int[] result, int eLength, int sLength) {
//		String significand = String.valueOf(result[1]);
//		String exponent = String.valueOf(result[0]);
//		String[] newResult = new String[2];
//		while (significand.length() - 1 < sLength) {
//			significand = significand + "0";
//		}
//		if (significand.length() - 1 >= sLength) {
//			significand = significand.substring(0, sLength + 1);
//		}
//		while (exponent.length() < eLength) {
//			exponent = "0" + exponent;
//		}
//		newResult[0] = exponent;
//		newResult[1] = significand;
//		return newResult;
//	}
//
//	/**
//	 * 1.4375 -> 10111，-4
//	 *
//	 * @param decimal
//	 * @return
//	 */
//	private int[] decimalToBinarySmallPoint(String decimal) {
//		int[] result = new int[2];
//		int value;  // 记录二进制表示，转为整数
//		int exponent = decimal.length() - 1 - decimal.indexOf(".");  // 记录使一个小数转为整数所需要的指数
//		value = Integer.valueOf(integerRepresentation(decimal.replace(".", ""), decimal.length() - 1));
//		result[0] = value;
//		result[1] = exponent;
//		return result;
//	}
//
//	String toZeroFloatPoint(String number, int eLength, int sLength) {
//		// 这里不考虑符号，只处理数值
//		StringBuilder builder = new StringBuilder();
//		for (int i = 0; i < eLength + sLength; i++) {
//			builder.append("0");
//		}
//		return builder.toString();
//	}
//
//	/**
//	 * exponent=0
//	 * significand=0
//	 *
//	 * @param value
//	 * @return
//	 */
//	private boolean isZeroFloatPoint(String value) {
//		if (Integer.valueOf(value) == 0) {
//			return true;
//		}
//		return false;
//	}
//
//	private String toDenormalizedFloatPoint(String number, int eLength, int sLength) {
//
//	}
//
//	private boolean isDenormalizedFloatPoint(String finalString) {
//
//	}
////
////		private String toIniniteFloatPoint (String number,int eLength, int sLength){
////
////		}
////
////		private boolean isInfiniteFloatPoint () {
////
////		}
////
////		private String toNaN (String number,int eLength, int sLength){
////
////		}
////
////		private boolean isNaN () {
////
////		}
//
//
//	public static void main(String[] args) {
////		System.out.println(Integer.toBinaryString(0.0023));
//
//	}
//}
