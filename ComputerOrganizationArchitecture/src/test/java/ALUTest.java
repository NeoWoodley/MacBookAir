//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class ALUTest {
//	ALU alu = new ALU();
//
//	@Test
//	public void test1_1() {
//		assertEquals("01000",alu.integerRepresentation("8", 5));
//	}
//
//	@Test
//	public void test1_2() {
//		assertEquals("11000", alu.integerRepresentation("-8", 5));
//	}
//
//	@Test
//	public void test1_3() {
//		assertEquals("111000",alu.integerRepresentation("-8", 6));
//	}
////	@Test
////	public void test1() {
////		double smallNum = 0.4375;
////		assertEquals("0.0111", smallNumTo2(smallNum, 4));
////	}
////
////	@Test
////	public void test2() {
////		double smallNum = 0.056;
////		assertEquals("0.0000111001010110000001000001",smallNumTo2(smallNum,28));
////	}
////
////	private static String smallNumTo2(double smallNum, int accurate) {
////		int presentBit;
////		double temp = smallNum;
////		StringBuilder builder = new StringBuilder().append("0.");
////		for (int i = 0; i < accurate; i++) {
////			temp = 2 * temp;
////			presentBit = (int) Math.floor(temp);
////			builder.append(presentBit);
////			temp = temp - presentBit;
////		}
////		return builder.toString();
////	}
//
//	@Test
//	public void test2_1() {
//		String number = "1.4375";
//		int eLength = 6;
//		int sLength = 7;
//		assertEquals("00111110111000", alu.floatRepresentation(number, eLength, sLength));
//	}
//
//	@Test
//	public void test1() {
//		String number = "-0";
//		int eLength=6;
//		int sLength = 7;
//		assertEquals("10000000000000", alu.toZeroFloatPoint(number, 6, 7));
//	}
//
//}