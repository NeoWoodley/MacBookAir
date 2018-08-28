package LinkedList;

/**
 * 在使用链表前，必须先定义出节点的数据结构。在Java中使用数组来模拟链表可先定义一个节点的类，供链表结构使用
 */
public class Node {
	final int MAXLENGTH = 20;
	int[] data1 = new int[MAXLENGTH];  // 用来存储链表的数据1
	String[] data2 = new String[MAXLENGTH];  //用来存储链表的数据2
	int[] data3 = new int[MAXLENGTH];  // 用来存储链表的数据3
	int[] next = new int[MAXLENGTH];  // 用于存储下一个节点的位置

	/**
	 * 构造器
	 */
	public Node() {
		for (int i = 0; i < MAXLENGTH; i++)
			next[i] = -2;  // -2表示未用节点
	}

	/**
	 * 查找可用节点
	 *
	 * @return
	 */
	public int findFree() {
		int i;
		for (i = 0; i < MAXLENGTH; i++)
			if (next[i] == -2)
				break;
		return i;
	}

	/**
	 * 输出链表数据
	 * @param head
	 */
	public void printList(int head) {
		int pointer = head;

		while (pointer != -1) {
			System.out.println("Print List");
			System.out.println("DataNum: " + data1[pointer]);
			System.out.println("DataName: " + data2[pointer]);
			System.out.println("DataPhone: " + data3[pointer]);
			pointer = next[pointer];
		}
	}

	/**
	 * 建立链表
	 * @param head
	 * @param freeNode
	 * @param dataNum
	 * @param dataName
	 * @param dataPhone
	 */
	public void create(int head, int freeNode, int dataNum, String dataName, int dataPhone) {
		int pointer;

		if (head == freeNode) {
			data1[head]=dataNum;
			data2[head]=dataName;
			data3[head]=dataPhone;
			next[head]=-1;  // 设置下一个节点的位置，-1表示空节点
		} else {
			pointer=head;
			data1[freeNode]=dataNum;
			data2[freeNode]=dataName;
			data3[freeNode]=dataPhone;
			next[freeNode]=-1;

			while (next[pointer] != -1)
				pointer = next[pointer];
			next[pointer]=freeNode;
		}
	}
}
