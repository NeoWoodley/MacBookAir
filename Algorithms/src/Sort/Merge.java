package Sort;

import java.util.Scanner;

/**
 * P171 算法2.4 自顶向下的归并排序
 * <p>
 * 归并排序：将两个有序的数组归并成一个更大的有序数组
 * 要将一个数组排序，可以先（递归地）将它分成两半分别排序，然后将结果归并起来
 * 归并排序最吸引人的性质是它能够保证将任意长度为N的数组排序所需时间和NlogN成正比
 * 它的主要缺点是它所需的额外空间和N成正比
 *
 * 对于长度为N的任意数组，自顶向下的归并排序需要1/2NlgN至NlgN次比较，最多需要访问数组6NlgN次
 * 每次归并最多需要访问数组6N次（2N次用来复制，2N次用来将排好序的元素移动回去（N次将原数组复制到aux中，N次将aux中的元素复制回原数组中），另外最多比较2N次）
 *
 * 可以用归并排序处理数百万甚至更大规模的数组，这是插入排序或者选择排序做不到的
 *
 * 通过细致的思考，我们能够大幅度缩短归并排序的运行时间P174：
 * 1、对小规模子数组使用插入排序
 * 用不同的方法处理小规模问题能改进大多数递归算法的性能，因为递归会使小规模问题种方法的调用国语频繁，所以改进对他们的处理方法就能改进整个算法
 * 对于排序来说，插入排序（或者选择排序）非常简单，因此可能在小数组上比归并排序更快。使用插入排序处理小规模的子数组（eg.长度小于15）一般可以将归并排序的运行时间缩短10%～15%
 * 2、测试数组数否已经有序
 * 添加判断条件，如果a[mid]小于等于a[mid+1]，我们就认为数组已经是有序的并跳过merge()方法。这个改动不应惜那个排序的递归调用，但是任意有序的子数组算法的运行时间就变为线性的了
 * 3、不讲元素复制到辅助数组
 * 我们可以节省将数组元素复制到用于归并到辅助数组所用的时间（但空间不行）。要做到这一点，需要调用两种排序方法，一种将数据从输入数组排序到辅助数组，一种将数据从辅助数组排序到输入数组。这种方法需要一些技巧，我们要在递归调用的每个层次交换输入数组和辅助数组的角色
 */

public class Merge {
	private static Comparable[] aux;  // 归并所需的辅助数组

	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		// 将数组a[lo..ji]排序
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);  // 左半边排序，递归
		sort(a, mid + 1, hi);  // 右半边排序，递归
		merge(a,lo,mid,hi);
	}

	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		// 将a[lo..mid]和a[mid+1..hi归并
		int i = lo, j = mid + 1;

		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];

		for (int k = lo; k <= hi; k++)
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j],aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
	}

	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void show(Comparable[] a) {
		for (Comparable anA : a)
			System.out.print(anA + " ");
		System.out.println();
	}

	public static boolean isSorted(Comparable[] a) {
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
