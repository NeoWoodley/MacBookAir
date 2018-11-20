package Three;

import java.util.LinkedList;

/**
 * 在O(N)的时间复杂度内，完成单链表的逆序。借助Java的LinkedList接口
 */
public class ReverseSinglyLinkedList {
	LinkedList linkedList;
	LinkedList reverseLinkedList;

	public ReverseSinglyLinkedList(LinkedList linkedList) {
		this.linkedList=linkedList;
		reverseLinkedList = new LinkedList();
	}

	public LinkedList reverse() {
		for (Object node : this.linkedList) {
			this.reverseLinkedList.add(0, node);
		}
		return this.reverseLinkedList;
	}

	public static void print(LinkedList linkedList) {
		for (Object node : linkedList) {
			System.out.print(node + " ");
		}
	}

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		linkedList.add(6);
		linkedList.add(7);
		LinkedList newinkedList = new ReverseSinglyLinkedList(linkedList).reverse();
		print(newinkedList);
	}
}
