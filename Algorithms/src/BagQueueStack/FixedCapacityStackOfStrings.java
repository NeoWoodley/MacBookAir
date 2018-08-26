package BagQueueStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 实现一份API的第一步就是选择数据的表达方式，这里使用了String[]数组
 */

public class FixedCapacityStackOfStrings {
	private String[] a;
	private int N;

	public FixedCapacityStackOfStrings(int cap) {
		a = new String[cap];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void push(String item) {
		a[N++] = item;
	}

	public String pop() {
		return a[--N];  // 这里不是很懂改变N和取值的顺序
	}

	public static void main(String[] args) throws IOException {
		FixedCapacityStackOfStrings s;
		s = new FixedCapacityStackOfStrings(100);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String string;
		while (!(string = reader.readLine()).equals("")) {
			if (!string.equals("-"))
				s.push(string);
			else if (!s.isEmpty())
				System.out.println(s.pop());
		}
		System.out.println("(" + s.size() + " left on stack)");
	}
}
