package Sort;

import java.util.Scanner;

/**
 * P56 算法2.1 选择排序（在不断地选择剩余元素之中的最小者）
 * <p>
 * 首先，找到数组中最小的元素
 * 其次，将它和数组的第一个元素交换位置（如果第一个元素就是最小元素那么它就和自己交换）
 * 再次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置
 * 循环，直到将整个数组排序
 *
 * 对于长度为N的数组，选择排序大约需要N*N/2（N*(N-1)/2）次比较、N次交换
 *
 * 特点
 * 1、运行时间和输入无关：为了找出最小的元素而扫描一遍数组并不能为下一遍扫描提供什么信息。这种性质在某种情况下是缺点
 * 2、数据移动是最少的：交换次数和数组的大小是线性关系（大部分的增长数量级都是线性对数或是平方级别）
 */

public class Selection {
	public static void sort(Comparable[] a) {
		// 升序，这里运用的是选择排序
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++)
				if (less(a[j], a[min]))
					min = j;
			exch(a, i, min);
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void show(Comparable[] a) {
		// 在单行中打印数组foreach
		for (Comparable anA : a) System.out.print(anA + " ");
		System.out.println();
	}

	public static boolean isSorted(Comparable[] a) {
		// 测试数组元素是否有序，排序后索引较大的主键大于等于索引较小的主键
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] a;
		String str;
		while ((str = scanner.nextLine()) != null) {
			a = str.split(" ");
			sort(a);
			assert isSorted(a);
			show(a);
		}
	}
}
