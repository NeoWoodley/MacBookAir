package BagQueueStack;

import java.util.Iterator;

/**
 * P94 算法1.2 下压堆栈（链表实现）：将栈保存为一条链表，栈的顶部为表头，实例变量first指向栈顶
 *
 * 链表：一种递归的数据结构，它或者为空（null），或者是指向一个结点（node）的引用
 *      该结点含有一个泛型元素和一个指向另一条链表的引用
 * 在这个定义中，结点是一个可能含有任意类型数据的抽象实体，它所包含的指向结点的应用显示了它在构造链表之中的作用
 * 这种类型的类有时也被称为"记录"
 * 在这里，数据结构和算法的实现相互作用
 *
 * 优点：
 *     它可以处理任意类型的数据
 *     所需的空间总是和集合的大小成正比
 *     操作所需的时间总是和集合的大小无关
 *
 * 实现任意插入和删除操作的标准解决方案是使用"双向链表"
 *
 * 术语：
 *     链接：表示对结点的引用
 */

public class Stack<Item> implements Iterable<Item> {
	private Node first;  // 栈顶（最近添加的元素）
	private int N;  // 元素数量

	/**
	 * 使用一个嵌套类来定义结点的抽象数据类型
	 */
	private class Node {
		Item item;  // 参数类型，初始化为null
		Node next;  // 初始化为null
	}

	public boolean isEmpty() {
		return N ==0;  // 或者 first == null;
	}

	public int size() {
		return N;
	}

	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}

	public Item pop() {
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	@Override
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
