package LinkedList;

import java.util.Scanner;

/**
 * 该程序现在还只有一个节点，节点之间的链接还没有串联起来
 */
public class AList {
	public static void main(String[] args) {
		Node newList = new Node();
		int dataNum;
		String dataName;
		int dataPhone;
		int head = 0;
		int i;

		System.out.println("Please inout the data number:");
		// 输入格式：
		// int
		// String
		// int

		Scanner scanner = new Scanner(System.in);
		dataNum = Integer.parseInt(scanner.nextLine());
		dataName = scanner.nextLine();
		dataPhone = Integer.parseInt(scanner.nextLine());
		scanner.close();

		// 给链表赋值
		newList.data1[head] = dataNum;
		newList.data2[head] = dataName;
		newList.data3[head] = dataPhone;
		newList.next[head] = -1;  // 设置下一个节点的位置，-1表示空节点

		// 打印链表
		int tempHead=0;
		System.out.println("Print linkedList");
		while (newList.next[tempHead] != -2) {
			System.out.println(newList.data1[tempHead]);
			System.out.println(newList.data2[tempHead]);
			System.out.println(newList.data3[tempHead]);
			tempHead++;
		}
	}
}
