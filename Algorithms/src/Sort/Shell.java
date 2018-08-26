package Sort;

import java.util.Scanner;

/**
 * P163 算法23 希尔排序
 * <p>
 * 这是一种基于插入排序的快速的排序算法
 * 对于大规模乱序数组，插入排序很慢，因为它只会交换相邻的元素，因此元素只能一点一点地从数组的一端移动到另一端
 * 希尔排序为了加快速度简单地改进了插入排序，交换不相邻的元素以对数组的局部进行排序，并最终用插入排序将局部有序的数组排序
 * <p>
 * 希尔排序的思想：使数组中任意间隔为h的元素都是有序的。这样的数组称为"h有序数组"
 * 即，一个"h有序数组"就是h个相互独立的有序数组编织在一起组成的一个数组
 * 在进行排序时，如果h很大，我们就能将元素移动到很远的地方，为实现更小的h有序创造方便
 * 用这种方式，对于任意以1结尾的h，我们都能将数组排序
 *
 * 实现希尔排序的一种方法是对于每个h，用插入排序将h个子数组独立地排序。但因为子数组相互独立，一个更简单的方法是在h-子数组中将每个元素交换到比它大的元素之前去（将比它大的元素向右移动一格）。只需要在插入排序的代码中将移动元素的距离由1改为h即可。
 * 这样希尔排序的实现就转化为了一个类似于插入排序但使用不同增量的过程
 *
 * 希尔排序更高效的原因是它权衡了子数组的规模和有序性。排序之初，各个子数组都很短，排序之后子数组都是部分有序的，这两种情况都很适合插入排序。子数组部分有序的程度取决于递增序列的选择
 *
 * 透彻理解希尔排序的性能至今仍然是一项挑战。实际上，该算法是我们唯一无法准确描述其对于乱序的数组的性能特征的排序方法
 *
 * 希尔排序也可用于大型数组，它对任意排序（不一定是随机的）的数组表现也很好。实际上，对于一个给定的递增序列，构造一个使希尔排序运行缓慢的数组并不容易。希尔排序比选择排序和插入排序要快得多，并且数组越大，优势越大。希尔排序能够解决一些初级排序算法无法解决的问题。通过提升速度来解决其他方式无法解决的问题是研究算法设计和性能的主要原因之一
 *
 * 它的代码量很小，且不需要使用额外的内存空间。如果我们需要解决一个排序问题而有没有系统排序函数可用（例如直接接触硬件或是运行于嵌入式系统中的代码），可以先用希尔排序，然后再考虑是否值得将它替换为更加复杂的排序算法
 *
 * 使用递增序列1，4，13，40，121，364……的希尔排序所需的比较次数不会超出N的若干倍乘以递增序列的长度
 */

public class Shell {
	public static void sort(Comparable[] a) {
		// 升序
		int N = a.length;
		int h = 1;
		while (h < N / 3)
			h = 3 * h + 1;  // 1，4，13，40，121，364，1093，……增幅h的初始值是数组的长度乘以一个常数因子，最小为1
		while (h >= 1) {
			// 将数组变为h有序
			for (int i = h; i < N; i++)
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
					exch(a, j, j - h);
			h = h / 3;
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
