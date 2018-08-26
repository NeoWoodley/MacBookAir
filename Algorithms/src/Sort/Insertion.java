package Sort;

import java.util.Scanner;

/**
 * P157 算法2.2 插入排序
 * <p>
 * 为了要给插入的元素腾出空间，需要将其余所有元素在插入之前都向右移动一位
 * 当前索引左边的所有元素都是有序的，但它们的最终位置还不确定，为了给更小的元素腾出空间，它们可能会被移动
 * 但是当索引到达数组的右端时，数组排序就完成了
 * <p>
 * 插入排序所需的时间取决于元素的初始顺序
 * <p>
 * 对于随机排列的长度为N且主键不重复的数组，平均情况下插入排序需要~N*N/4次比较、~N*N/4次交换。
 * 最坏情况下需要~N*N/2次比较、~N*N/2次交换
 * 最好情况下需要N-1次比较、0次交换
 * <p>
 * 插入排序对于实际应用中常见的某些类型的非随机数组（部分有序数组：数组中倒置的数量小于数组大小的某个倍数）很有效
 *
 * 插入排序需要的交换操作和数组中倒置的数量相同，需要的比较次数大于等于倒置的数量，小于等于倒置的数量加上数组的大小再减一
 * 因为每次交换都改变了两个顺序颠倒的元素的位置，相当于减少了一对倒置，当倒置数量为0时，排序就完成了
 * 每次交换都对应着一次比较，且1到N-1之间的每个i都可能需要一次额外的比较（在a[i]没有到达数组的左端时）
 *
 * todo 这句话没看懂？？？
 * 要想大幅提高插入排序的速度，只需要在内循环中将较大的元素都向右移动而不总是交换两个元素（这样访问数组的次数就能减半）
 */

public class Insertion {
	public static void sort(Comparable[] a) {
		// 升序
		int N = a.length;
		for (int i = 1; i < N; i++) {
			// 将a[i]插入到a[i-1]、a[i-2]、a[i-3]……之中
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
				exch(a, j, j - 1);
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
		for (Comparable anA : a) {
			System.out.print(anA + " ");
		}
		System.out.println();
	}

	public static boolean isSort(Comparable[] a) {
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str;
		while ((str = scanner.nextLine()) != null) {
			String[] a = str.split(" ");
			sort(a);
			assert isSort(a);
			show(a);
		}
	}
}
