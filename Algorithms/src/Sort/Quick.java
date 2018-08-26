package Sort;

import java.util.Scanner;

/**
 * P182 算法2.5 快速排序
 * <p>
 * 快速排序可能是应用最广泛的排序算法了。它流行的原因是它实现简单适用于各种不同输入数据，且在一般应用中比其他排序算法都要快得多
 * <p>
 * 快速排序引人注目的特点：
 * 1、它是原地排序（只需要借助一个很小的辅助栈）
 * 2、将长度为N的数组排序所需的时间和NlgN成正比（我们已经学习过的排序算法都无法将这两个优点结合起来）
 * 3、快速排序的内循环比大多数排序算法都要短小，这意味着它无论是在理论上还是在实际中都要快
 * <p>
 * 它的主要缺点：非常脆弱，在实现时要非常小心才能避免低劣的性能。已经有无数例子显示许多错误都能致使它在实际中的性能只有平方级别
 * <p>
 * 快速排序是一种分治的排序算法。它将数组分成两个子数组，将两部分独立地排序
 * 快速排序和归并排序是互补的：归并排序将数组分成两个子数组分别排序，并将有序的子数组归并以将整个数组排序；而快速排序将数组排序的方式则是将两个子数组都有序时整个数组也就自然有序了
 * 在第一种情况中，递归调用发生在处理整个数组之前；在第二种情况中，递归调用发生在处理整个数组之后
 * 在归并排序中，一个数组被等分成两半；在快速排序中，切分的危重取决于数组的内容
 * <p>
 * 快速排序递归地将子数组a[lo..hi]排序，先用partition()方法将a[j]放到一个合适位置，然后再用递归调用将其他位置的元素排序
 * 该方法的关键在于"切分"，这个过程使得数组满足下面三个条件：
 * 1、对于某个j，a[j]已经排定
 * 2、a[lo]到a[j-1]中的所有元素都不大于（<=）a[j]
 * 3、a[j+1]到a[hi]中的所有元素都不小于（>=）a[j]
 * 通过递归地调用切分来排序
 * 因为切分的过程重视能排定一个元素，用归纳法不难证明递归能够正确地即那个数组排序：如果左子数组和右子数组都是有序的，那么由左子数组（有序且没有任何元素大于切分元素）、可分元素和右子数组（有序且没有任何元素小于切分元素）组成的结果数组也一定是有序的。它是一个随机化的算法，因为它在将数组排序之前会将其随机打乱。我们这么做的原因是希望能够预测（并依赖）该算法的性能特性
 * <p>
 * 切分方法的实现：
 * 先随意地取a[lo]作为切分元素，即那个将会被排定的元素，然后我们从数组的左端开始向右扫描直到找到一个大于等于它的元素，再从数组的右端开始向左扫描直到找到一个小于等于它的元素。这两个元素显然是没有排定的，因此我们交换它们的位置。如此继续，我们就可以保证左指针i的左侧元素都不大于切分元素，右指针j的右侧元素都不小于切分元素。当两指针相遇时，我们只需要将切分元素a[lo]和左子数组最右端的元素a[j]交换然后返回j即可
 */

public class Quick {
	public static void sort(Comparable[] a) {
//		StdRandom.shuffle(a);  // 消除对输入的依赖 todo: 有问题
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j + 1, hi);
	}

	public static int partition(Comparable[] a, int lo, int hi) {
		// 将数组切分成a[lo..i-1]，a[i]，a[i+1..hi]
		int i = lo, j = hi + 1;  // 左右扫描指针
		Comparable v = a[lo];  // 切分元素

		while (true) {
			// 扫描左右，检查扫描是否结束并交换元素
			while (less(a[++i], v))  // 在循环中，a[i] < v时，i++
				if (i == hi)
					break;
			while (less(v, a[--j]))  // 在循环中，a[j] > v时，j--
				if (j == lo)
					break;
			if (i >= j)  // 当指针i、j相遇时，主循环退出
				break;
			exch(a, i, j);  // 交换a[i]、a[j]，保证i左侧元素 <= v，j右侧元素 >= v
		}
		exch(a, lo, j);  // 将v = a[j]放入正确的位置（当指针相遇时，交换a[lo]、a[j]，切分结束，这样切分值就留在a[j]中了）
		return j;  // a[lp..j-1] <= a[j] <= a[j+1..hi]达成
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
