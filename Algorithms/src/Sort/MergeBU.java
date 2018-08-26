package Sort;

import java.util.Scanner;

/**
 * P175 自底向上的归并排序
 * <p>
 * 递归实现的归并排序是算法设计种"分治思想"的典型应用。我们将一个大问题分割成小问题分别解决，然后用所有小问题的答案来解决整个大问题
 * <p>
 * 实现归并排序的另一种方法是先归并那些卫星数组，然后再成对归并得到的子数组。
 * 这种实现方法比标准递归方法所需要的代码量更少
 * 首先，进行两两归并（把每个元素想像成一个大小为1的数组）
 * 然后，四四归并（将两个大小为2的数组归并成一个有4个元素的数组）
 * 接着，八八归并
 * ……循环
 * 在每一轮归并中，最后一次归并的第二个子数组的大小可能比第一个子数组要小（但这对merge()方法不是问题），如果不是的话所有的归并中两个数组大小都应该一样，而在下一轮中子数组的大小会翻倍
 *
 * 自底向上的归并排序会多次历遍整个数组，根据子数组大小进行两两加倍。子数组的大小sz的初始值为1，每次加倍。最后一个子数组的大小只有在数组大小是sz的偶数倍的时候才会等于sz（否则他会比sz小）
 *
 * 对于长度为N的任意数组，自底向上的归并排序需要1/2NlgN至NlgN次比较，最多访问数组6NlgN次 todo:不是很懂？？？
 * 处理一个数组的遍数是lgN向上取整。每一遍会访问数组6N次（2N次用来复制，2N次用来将排好序的元素移动回去，另外最多比较2N次），比较次数在N/2和N之间
 *
 * 当数组长度为2的幂时，自顶向下和自底向上的归并排序所用的比较次数和数组访问次数正好相同，只是顺序不同。其他时候，两种方法的比较和数组访问的次序会有所不同
 * 自底向上的归并排序比较适合链表组织的数据。这种方法只需要重新组织链表链接就能将链表原地排序（不需要创建任何新的链表结点）
 * 用自顶向下或是自底向上的方式实现任何分治类的算法都很自然。归并排序告诉我们，当能够用其中一种方法解决一个问题时，我们都应该尝试另一种
 * 我们是希望像Merge.sort()中那样化整为零（然后递归地解决它们）的方式解决问题，还是希望像MergeBU.sort()中那样循序渐进地解决问题呢？
 */

public class MergeBU {
	private static Comparable[] aux;  // 归并所需要的辅助数组，不将aux[]作为merge()方法的局部变量，是为了防止每次调用merge()方法时，都创建一个新数组，浪费时间

	public static void sort(Comparable[] a) {
		// 进行lgN次两两归并
		int N = a.length;
		aux = new Comparable[N];

		for (int sz = 1; sz < N; sz = sz + sz)
			for (int lo = 0; lo < N - sz; lo += sz + sz)
				merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
	}

	public static void merge(Comparable[] a, int lo, int mid, int hi) {
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
