package BagQueueStack;

import java.util.Iterator;

/**
 * P95 算法1.3 先进先出队列
 *
 * 队列：将队列表示为一条从最早插入的元素到最近插入的元素的链表
 * 实例变量first指向队列的开头，实例变量last指向队列的结尾
 * 元素入列（enqueue()）：将它添加到表尾。在链表为空时，需要将first和last都指向那个新结点
 * 元素出列（dequeue()）：删除表头的结点。当链表为空时，需要更新last的值
 *
 * 优点：
 *     可以处理任意类型的数据
 *     所需的空间总是和集合的大小成正比
 *     操作所需的时间总是和集合的大小无关
 *
 * 在结构化存储数据集时，链表是数组的一种重要的替代方式
 * 在现代编程语言中，安全指针、自动垃圾回收、抽象数据类型的使用使我们能够将链表处理的代码封装在若干个类中
 */

public class Queue<Item> implements Iterable<Item> {
	private Node first;  // 指向最早添加的结点的链接，初始化为null
	private Node last;  // 指向最近添加的结点的链接，初始化为null
	private int N;  // 队列中的元素数量，初始化为0

	private class Node {
		// 定义了结点的嵌套类
		Item item;
		Node next;
	}

	public boolean isEmpty() {
		return N==0;  // 或者 first == null;
	}

	public int size() {
		return N;
	}

	public void enqueue(Item item) {
		// 向表尾添加元素
		Node oldfirst = first;
		last = new Node();
		last.item = item;
		last.next = null;

		if (isEmpty())
			first = last;
		else
			oldfirst.next = last;
		N++;
	}

	public Item dequeue() {
		// 从表头删除元素
		Item item = first.item;
		first = first.next;
		if (isEmpty())
			last = null;
		N--;
		return item;
	}

	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {

		}
	}

}
