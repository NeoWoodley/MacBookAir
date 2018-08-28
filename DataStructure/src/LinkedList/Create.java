package LinkedList;

import java.util.Scanner;

/**
 * 链表的建立是将每一个节点一次串联起来
 * <p>
 * 使用数组来建立链表，必须先查出数组中可用的空间来存储节点数据，经过Node构造方法将Node中next数组的元素值皆设为-2（可用空间）的过程后，只要再从数组索引为0的位置开始查找next数组的元素值为-2，即可找出可用的空间，来存储新的节点数据
 * <p>
 * 程序目的
 * 设计一个将输入的数据建立成链表，输出链表数据的程序
 * <p>
 * 程序构思
 * 1、链表的建立：先声明一个节点，并记录其位置于head，并且将newList[head]设为-1。每输一笔数据就把原链表尾端的next数组只设为新数据的位置。并且将新数据的next数组值设为-2
 * 2、链表中可用空间的查找：从链表数组中查找一个未用空间，并将该空间的下标值返回
 * 3、链表数据的输出：先将pointer设为head的值，将pointer节点（即第一个节点）的数据输出。然后再找出pointer节点的下一个节点位置，将pointer设为下一个节点的位置，再将pointer节点的数据输出。重复执行此步骤直到pointer指针指向-2为止
 */

public class Create {
	public static void main(String[] args) {
		Node newList = new Node();
		int head = 0;
		int dataNum = 0;
		String dataName;
		int dataPhone;
		int freeNode;

		while (true) {
			freeNode = newList.findFree();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please input the data:");
			// 输入格式：
			// int
			// String
			// int

			String temp=scanner.nextLine();
			if (temp.equals("quit"))
				break;

			dataNum = Integer.parseInt(temp);
			dataName = scanner.nextLine();
			dataPhone = Integer.parseInt(scanner.nextLine());

			newList.create(head,freeNode,dataNum,dataName,dataPhone);
		}
		newList.printList(head);
	}

}

