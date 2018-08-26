package BagQueueStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

/**
 * P84
 *
 * BagQueueStack.FixedCapacityStack<Item>可以理解为某种元素的栈
 * Item是一个类型参数，用于表示用例将会使用的某种具体类型的象征性的占位符
 *
 * ⚠️注意：
 * 1、在Java中不能创建泛型数组
 *    a = new Item[cap];  // 这是不允许的
 *    a = (Item[]) new Object[cap];  // 应当使用类型转换，但Java编译器会给出一条警告，可以忽略
 *
 * 2、避免对象游离（游离：保存一个不需要的对象的引用）
 *    Java的垃圾收集策略是回收所有无法被访问的对象的内存
 *    我们在对pop()的实现中，被弹出的元素的引用仍然存在于数组中
 *    处理办法：只需要将弹出的数组元素的值设为null
 */

public class FixedCapacityStack<Item> {
	private Item[] a;
	private int N;

	public FixedCapacityStack(int cap) {
		a = (Item[]) new Object[cap];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void push(Item item) {
		if (N == a.length)
			resize(2*a.length);
		a[N++] = item;  // 等价于a[N] = item;N++;
	}

	public Item pop() {
		Item item = a[--N];  // 等价于N--;return a[N];
		a[N] = null;  // 避免对象游离
		if (N > 0 && N == a.length/4)
			resize(a.length / 2);
		return item;
	}

	public void resize(int max) {
		// 将大小为N <= max 的栈移动到一个新的大小为max的数组中
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < N; i++)
			temp[i] = a[i];
		a = temp;  // 改变a的引用指向
	}

	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	/**
	 * 使用嵌套类实现迭代器
	 * 嵌套类可以访问它的类的实例变量
	 *
	 * 迭代器：一个实现了hasNext()、next()方法的类的对象，有以下接口所定义
	 * public interface Iterator<Item> {
	 *     boolean hasNext();
	 *     Item next();
	 *     void remove();
	 * }
	 */

	public class ReverseArrayIterator implements Iterator<Item> {
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

	/**
	 * 测试用例
	 * @param args  参数
	 * @throws IOException  异常处理
	 */
	public static void main(String[] args) throws IOException {
		FixedCapacityStack<String> s = new FixedCapacityStack<>(100);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String string;
		while (!(string = reader.readLine()).equals("")) {
			if (!string.equals("-"))
				s.push(string);
			else if (!s.isEmpty())
				System.out.println(s.pop());
		}
		System.out.println("("+s.size()+" left on stack)");
	}
}
