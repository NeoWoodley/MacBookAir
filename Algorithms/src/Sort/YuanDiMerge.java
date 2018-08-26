package Sort;

/**
 * P170 原地归并的抽象方法
 * <p>
 * 它将涉及的所有元素复制到一个辅助数组中，再把归并结果放回原数组中
 * <p>
 * 该方法先将所有元素复制到aux[]中，然后再归并回a[]中。方法在归并时（第二个for循环）进行了4个条件判断：左半边用尽（取右半边的元素）、右半边用尽（取左半边的元素）、右半边的当前元素小于左半边的当前元素（取右半边的元素）以及右半边的当前元素大于等于左半边的当前元素（取左半边的元素）
 *
 * todo:这个类并不完整！！！
 */

public class YuanDiMerge {
	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		// 将a[lo..mid]和a[mid..hi]归并
		int i = lo, j = mid + 1;
		Comparable aux[] = new Comparable[a.length];

		// 将a[lo..hi]复制到aux[lo..hi]
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];

		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}

	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
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
}
