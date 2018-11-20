package Three;

/**
 *
 */
public class SingleLinkedList {
	public SingleNode head = new SingleNode();
	public int size;

//	/**
//	 * 获取元素的值
//	 *
//	 * @param i 所在链表的位置
//	 * @return 返回一个Node的element的值
//	 */
//	public T get(int i) {
//		if (i < 1 || i > size) {
//			throw new ArrayIndexOutOfBoundsException("获取位置不合法");
//		} else {
//
//		}
//	}

	public int length() {
		return size;
	}

	/**
	 * 在链表的最后插入结点
	 * @param node  要插入的新结点
	 */
	public void addNode(SingleNode node) {
		SingleNode temp=head;
		while (temp.hasNext()) {
			temp=temp.next;
		}
		temp.next=node;
		size++;
	}

	/**
	 *
	 * @param index [1,length+1]；若index为1，则在第一个结点前面插入；若index为length+1，则在链表尾部增加一个结点
	 * @param newNode  要插入的新结点
	 */
	public void insertNodeByIndex(int index, SingleNode newNode) {
		if (index < 1 || index > length() + 1) {
			System.out.println("插入位置不合法");
			return;
		}
		int presentIndex=0;
		SingleNode temp=head;
		// 寻找要插入的位置
		while (presentIndex < index-1) {
			temp=temp.next;
			presentIndex++;
		}
		newNode.next=temp.next;
		temp.next=newNode;
		size++;
	}

	/**
	 *
	 * @param index  删除指定节点
	 */
	// TODO: 2018/9/21 删除结点怎么进行垃圾清理
	public void deleteNodeByIndex(int index) {
		if (size == 0) {
			System.out.println("链表为空，无法删除");
			return;
		}
		if (index < 1 || index > size) {
			System.out.println("删除结点的索引不合法");
			return;
		}
		int presentIndex=0;
		SingleNode temp=head;
		while (presentIndex < index - 1) {
			temp=temp.next;
			presentIndex++;
		}
		temp.next=temp.next.next;
	}

	public void print() {
		SingleNode temp=head;
		System.out.print("head");
		while (temp.hasNext()) {
			System.out.print(" -> " + temp.next.element);
			temp=temp.next;
		}
	}

	/**
	 * 通过改变link的方式，交换指定的相邻的两个结点
	 * @param node 要交换的结点
	 */
	public void swap(SingleNode node) {

	}

	public static void main(String[] args) {
		SingleNode one = new SingleNode(1);
		SingleNode two = new SingleNode(2);
		SingleNode three = new SingleNode(3);
		SingleNode four = new SingleNode(4);
		SingleNode five = new SingleNode(5);
		SingleNode six = new SingleNode(6);
		SingleNode seven = new SingleNode(7);
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		singleLinkedList.addNode(one);
		singleLinkedList.addNode(two);
		singleLinkedList.addNode(three);
		singleLinkedList.addNode(four);
		singleLinkedList.addNode(five);
		singleLinkedList.addNode(six);
		singleLinkedList.insertNodeByIndex(7,seven);
		singleLinkedList.deleteNodeByIndex(4);
		singleLinkedList.print();
	}
}
