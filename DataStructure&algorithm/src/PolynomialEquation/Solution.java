package PolynomialEquation;

public class Solution {
	/**
	 * array1、array2中分别存放两个要相加的多项式
	 * @param args
	 */
	public static void main(String[] args) {
		double[] array1 = {1.2, 2, 0, 4, -6, 9, 0, 1};  // f(x)=1+2x+0x^2+4x^3-6x^4+9x^5+x^7
		double[] array2 = {2, -3, 4, 5, 6};  // g(x)=2-3x+4x^2+5x^3+6x^4
		LinkedList linkedList1 = new LinkedList().createLink(array1);
		LinkedList linkedList2 = new LinkedList().createLink(array2);
		linkedList1.printEquation();
		linkedList2.printEquation();

		// 进行多项式相加
		LinkedList newLinkedList = linkedList1.add(linkedList2);
		System.out.print("多项式相加的结果是：");
		newLinkedList.printEquation();
	}
}
