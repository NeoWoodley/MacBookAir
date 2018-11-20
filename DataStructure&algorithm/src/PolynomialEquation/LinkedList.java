package PolynomialEquation;

/**
 * 使用链表来完成多项式的相加
 */
public class LinkedList {
	private int length;
	private Node head;
	private static int count;

	/**
	 * 链表结点类
	 */
	class Node {
		private double coefficient;
		private int index;
		public Node next = null;

		public Node() {

		}

		/**
		 * @param coefficient 多项式系数
		 * @param index       指数
		 */
		public Node(double coefficient, int index) {
			this.coefficient = coefficient;
			this.index = index;
		}
	}

	public LinkedList() {

		head = new Node();
	}

	/**
	 * 创建链表类
	 *
	 * @param array 该数组中保存多项式的系数，数组的索引就是多项式的指数
	 * @return 返回一个链表
	 */
	public LinkedList createLink(double[] array) {
		LinkedList linkedList = new LinkedList();
		Node temp = linkedList.head;
		int index = 0;
		while (index < array.length) {
			// 如果多项式中有项的系数为0，那就不用创建这个结点了，防止空间浪费
			if (array[index] == 0) {
				index++;
				continue;
			}
			temp.next = new Node(array[index], index);
			index++;
			linkedList.length++;
			temp = temp.next;
		}
		return linkedList;
	}

	/**
	 * 计算两个多项式之和
	 *
	 * @param linkedList
	 * @return 返回一个含有结果的新链表
	 */
	public LinkedList add(LinkedList linkedList) {
		// 检查链表是否为空
		if (this.isEmpty() && linkedList.isEmpty()) {
			System.out.println("两个链表均为空链表，无法进行多项式相加");
			return new LinkedList();
		}
		if (this.isEmpty()) {
			return linkedList;
		}
		if (linkedList.isEmpty()) {
			return this;
		}
		// 两链表均不为空
		Node tempA = this.head.next;  // 指向第一个结点
		Node tempB = linkedList.head.next;  // 指向第一个结点
		double coefficientA, coefficientB;
		int indexA, indexB;
		LinkedList newLinkedList = new LinkedList();
		// 循环直到两个链表中有一个到达底端
		while (tempA != null && tempB != null) {
			indexA = tempA.index;
			indexB = tempB.index;
			coefficientA = tempA.coefficient;
			coefficientB = tempB.coefficient;
			if (indexA == indexB) {
				newLinkedList.addNode(coefficientA + coefficientB, indexA);
				tempA = tempA.next;
				tempB = tempB.next;
			}
			if (indexA < indexB) {
				newLinkedList.addNode(coefficientA, indexA);
				tempA = tempA.next;
			}
			if (indexA > indexB) {
				newLinkedList.addNode(coefficientB, indexB);
				tempB = tempB.next;
			}
		}
		while (tempA != null) {
			newLinkedList.addNode(tempA.coefficient, tempA.index);
			tempA = tempA.next;
		}
		while (tempB != null) {
			newLinkedList.addNode(tempB.coefficient, tempB.index);
			tempB = tempB.next;
		}
		return newLinkedList;
	}

	/**
	 * 在链表尾部添加结点
	 *
	 * @param coefficient 多项式的系数
	 * @param index       多项式的指数
	 */
	private void addNode(double coefficient, int index) {
		if (coefficient == 0)
			return;
		Node newNode = new Node(coefficient, index);
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;
		length++;
	}

	/**
	 * 打印多项式
	 */
	public void printEquation() {
		// 检查是否为空链表
		count++;
		if (this.isEmpty()) {
			System.out.println("该链表为空");
			return;
		}
		System.out.print("f" + count + "(x) = ");
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
			if (temp.coefficient > 0) {
				System.out.print(" + ");
			} else {
				System.out.print(" - ");
			}
			System.out.print(Math.abs(temp.coefficient));
			if (temp.index != 0)
				System.out.print("x^" + temp.index);
		}
		System.out.println();
	}

	public boolean isEmpty() {
		return this.length == 0;
	}
}
