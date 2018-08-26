package BagQueueStack;

import java.util.Iterator;

/**
 * P88 算法1.1 下压（LIFO）栈（能够动态调整数组大小的实现）
 *
 * <p>
 * 在算法学习中，以下算法十分重要，因为它几乎（但还没有）达到了任意集合类型数据的实现的最佳性能
 * 1、每项操作的用时都与集合大小无关
 * 2、空间需求总是不超过集合大小乘以一个常数
 * <p>
 * 其缺点在于
 * 某些push()、pop()操作会调整数组的大小：这项操作的耗时和栈的大小成正比
 * <p>
 * 下面展示的是一种克服该缺陷的方法，使用一种完全不同的方法来组织数据
 * 这份泛型的可迭代的Stack API的实现是所有集合类抽象数据类型实现的模版。
 * 它将所有元素保存在数组中，并动态调整数组的大小以保持数组大小和栈大小之比小于一个常数
 *
 * 要使一个类可迭代，第一步就是在它的声明中加入 implements Iterable<Item>，对应的接口为：
 *     public interface Iterable<Item> {
 *         Iterator<Item> iterator();
 *     }
 */

public class ResizingArrayStack<Item> implements Iterable<Item> {
	private Item[] a = (Item[]) new Object[1];  // 栈元素
	private int N = 0;

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	private void resize(int max) {
		// 将栈移动到一个大小为max的新数组中
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++)
			temp[i] = a[i];
		a = temp;  // 改变a的引用指向
	}

	public void push(Item item) {
		if (N == a.length)
			resize(2 * a.length);
		a[N++] = item;
	}

	public Item pop() {
		Item item = a[--N];
		a[N] = null;  // 避免对象游离
		if (N > 0 && N == a.length / 4)
			resize(a.length / 2);
		return item;
	}

	/**
	 * @return 任意可迭代的数据类型必须实现一个iterator()方法，并返回一个Iterator对象（迭代器对象）
	 */
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	/**
	 * 私有嵌套类，实现迭代器
	 * 迭代器就是一个实现了hasNext()、next()方法的类的对象
	 * Iterator类必须实现Iterator接口，实现hasNext()、next()方法
	 */
	private class ReverseArrayIterator implements Iterator<Item> {
		// 支持后进后出的迭代
		private int i = N;

		public boolean hasNext() {
			return i > 0;
		}

		public Item next() {
			return a[--i];
		}

		public void remove() {

		}
	}

}
