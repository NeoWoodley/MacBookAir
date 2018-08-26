package BagQueueStack;

import java.util.Iterator;

/**
 * P98 算法1.4 背包
 * <p>
 * 后进先出的顺序，但顺序在这里并不重要
 * <p>
 * 实现接口Iterable，保证了类必然会提供一个iterator()方法
 * iterator()方法本身只是简单地从实现了Iterator接口的类中返回一个迭代器对象
 * <p>
 * 嵌套类实现了Iterator接口，保证实现hasNext()、next()方法
 * hasNext()方法会检测current是否为null
 * next()方法会保存当前元素的引用，将current变量指向链表中的下一个结点并返回所保存的引用
 */

public class Bag<Item> implements Iterable<Item> {
	private Node first;

	private class Node {
		Item item;
		Node next;
	}

	public void add(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}

	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		// TODO: 2018/8/18 为什么ListIterator后面不用加上<Item>
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
