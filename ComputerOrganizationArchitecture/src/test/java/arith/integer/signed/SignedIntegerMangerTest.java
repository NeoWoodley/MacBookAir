package arith.integer.signed;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SignedIntegerMangerTest {
	private SignedIntegerManger signedIntegerManger;
	private String num1;
	private String num2;
	private String expected;
	private String actual;
	private char[] numChar;
	final private String OVERFLOW = "Overflow";

	@Before
	public void setUp() {
		signedIntegerManger = new SignedIntegerManger();
	}

	@Test
	public void addOneTest1() {
		num1 = "1010";
		expected = "1011";
		numChar = num1.toCharArray();
		char[] n = signedIntegerManger.addOne(numChar);
		actual=String.valueOf(signedIntegerManger.addOne(numChar));
		assertEquals(expected,actual);
	}

	@Test
	public void addOneTest2() {
		num1 = "011111";
		expected = "100000";
		numChar = num1.toCharArray();
		actual = String.valueOf(signedIntegerManger.addOne(numChar));
		assertEquals(expected, actual);
	}

	@Test
	public void addOneTest3() {
		num1 = "001011";
		expected = "001100";
		numChar = num1.toCharArray();
		actual = String.valueOf(signedIntegerManger.addOne(numChar));
		assertEquals(expected,actual);
	}

	@Test
	public void toNegationTest1() {
		num1 = "001011";
		expected ="110100";
		numChar = num1.toCharArray();
		actual = String.valueOf(signedIntegerManger.toNegation(numChar));
		assertEquals(expected,actual);
	}

	@Test
	public void toNegationTest2() {
		num1 = "1010110";
		expected = "0101001";
		numChar = num1.toCharArray();
		actual = String.valueOf(signedIntegerManger.toNegation(numChar));
		assertEquals(expected,actual);
	}

	@Test
	public void toComplementTest1() {
		num1 = "10001010";
		expected = "01110110";
		numChar = num1.toCharArray();
		actual = String.valueOf(signedIntegerManger.toComplement(numChar));
		assertEquals(expected, actual);
	}

	@Test
	public void toComplementTest2() {
		num1 = "001010000";
		expected = "110110000";
		numChar = num1.toCharArray();
		actual = String.valueOf(signedIntegerManger.toComplement(numChar));
		assertEquals(expected,actual);
	}

//	@Test
//	public void alignTest1() {
//		num1 = "110101010";
//		expected ="1111110101010";
//		numChar = num1.toCharArray();
//		actual = String.valueOf(signedIntegerManger.align(numChar, 13));
//		assertEquals(expected,actual);
//	}
//
//	@Test
//	public void alignTest2() {
//		num1 = "0011010010001";
//		expected = "0011010010001";
//		numChar = num1.toCharArray();
//		actual = String.valueOf(signedIntegerManger.align(numChar, 13));
//		assertEquals(expected,actual);
//	}

	/**
	 * 以上是private方法的测试
	 */

	@Test
	public void addTest1() {
		num1 = "1100101110110";
		num2 = "01011101";
		expected = "1100111010011";
		actual = signedIntegerManger.add(num1, num2);
		assertEquals(expected,actual);
	}

	@Test
	public void addTest2() {
		num1 = "111111111";
		num2 = "111";
		expected = "111111110";
		actual = signedIntegerManger.add(num1, num2);
		assertEquals(expected, actual);
	}

	@Test
	public void addTest3() {
		num1 = "111110";
		num2 = "1011";
		expected = "111001";
		actual = signedIntegerManger.add(num1, num2);
		assertEquals(expected,actual);
	}

	@Test
	public void addTest4() {
		num1 = "100000";
		num2 = "1100";
		expected = OVERFLOW;
		actual = signedIntegerManger.add(num1, num2);
		assertEquals(expected, actual);
	}

	@Test
	public void minusTest1() {
		num1 = "1100101110110";
		num2 = "01011101";
		expected = "1100100011001";
		actual = signedIntegerManger.minus(num1, num2);
		assertEquals(expected,actual);
	}

	@Test
	public void minusTest2() {
		num1 = "111111111";
		num2 = "111";
		expected = "000000000";
		actual = signedIntegerManger.minus(num1, num2);
		assertEquals(expected, actual);
	}

	@Test
	public void minusTest3() {
		num1 = "111110";
		num2 = "1011";
		expected = "000011";
		actual = signedIntegerManger.minus(num1, num2);
		assertEquals(expected, actual);
	}

	@Test
	public void minusTest4() {
		num1 = "1100001001";
		num2 = "0111111";
		expected = "1011001010";
		actual = signedIntegerManger.minus(num1, num2);
		assertEquals(expected,actual);
	}

	@Test
	public void minusTest5() {
		num1 = "10000000000";
		num2 = "01000000";
		expected = OVERFLOW;
		actual = signedIntegerManger.minus(num1, num2);
		assertEquals(expected,actual);
	}

//	@Test
//	public void shiftRight() {
//		num1 = "1010111100010";
//		numChar = num1.toCharArray();
//		expected = "0101011110001";
//		actual = String.valueOf(signedIntegerManger.shiftRightArithmetic(numChar));
//		assertEquals(expected, actual);
//	}

//	@Test
//	public void shiftRight() {
//		signedIntegerManger.setLengthOfOperand(7);
//		signedIntegerManger.setMarkQ(0);
//		signedIntegerManger.setRegisterA("0011011");
//		signedIntegerManger.setRegisterQ("1100100");
//		signedIntegerManger.shiftRightArithmeticRegister();
//		assertEquals("0001101", String.valueOf(signedIntegerManger.getRegisterA()));
//		assertEquals("1110010", String.valueOf(signedIntegerManger.getRegisterQ()));
//		assertEquals(0,signedIntegerManger.getMarkQ());
//	}
//
//	@Test
//	public void shiftLeftTest1() {
//		signedIntegerManger.setLengthOfOperand(8);
//		signedIntegerManger.setRegisterA("11101010");
//		signedIntegerManger.setRegisterQ("01011101");
//		signedIntegerManger.shiftLeftArithmeticRegister();
//		assertEquals("11010100",String.valueOf(signedIntegerManger.getRegisterA()));
//		assertEquals("10111010",String.valueOf(signedIntegerManger.getRegisterQ()));
//	}

	@Test
	public void multiplyTest1() {
		num1 = "1001";
		num2 = "1010";
		expected = "00101010";
		actual=signedIntegerManger.multiply(num1, num2);
		assertEquals(expected,actual);
	}

	@Test
	public void multiplyTest2() {
		num1 = "11001010";
		num2 = "001011";
		expected = "1111110110101110";
		actual=signedIntegerManger.multiply(num1, num2);
		assertEquals(expected,actual);
	}

	@Test
	public void recoverDivideTest1() {
		num1 = "1001";
		num2 ="011";
		expected = "11111110";
		actual = signedIntegerManger.recoverDivide(num1, num2);
		assertEquals(expected, actual);
	}

	@Test
	public void unrecover1() {
		num1 = "1001";
		num2 = "011";
		expected = "11111110";
		actual = signedIntegerManger.unrecoverDivide(num1, num2);
		assertEquals(expected, actual);
	}

	@Test
	public void unrecover2() {
		num1 = "0111";
		num2 = "0011";
		expected = "00010010";
		actual = signedIntegerManger.unrecoverDivide(num1, num2);
		assertEquals(expected,actual);
	}

	@Test
	public void unrecover3() {
		num1 = "01110101";
		num2 = "1101";
		expected = "0000000011011001";
		actual = signedIntegerManger.unrecoverDivide(num1, num2);
		assertEquals(expected, actual);
	}

}