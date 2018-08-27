//package Sort;
//
//public class DuiPaiXu {
//	public static void sort(Comparable[] a) {
//		int N=a.length;
//
//		for (int k = N / 2; k >= 1; k--)
//			sink(a,k,N);
//
//		while (N > 1) {
//			exch(a,1,N--);
//			sink(a, 1, N);
//		}
//	}
//
//	private static void exch(Comparable[] a,int i, int j) {
//		Comparable t = a[i];
//		a[i] = a[j];
//		a[j] = t;
//	}
//
//	private static void sink(Comparable[] a,int i,int j) {
//		int N = a.length+1;
//		while (2 * k <= N) {
//			int j = 2 * k;  // 左子结点
//			if (j < N && less(j, j + 1))
//				j++;  // 保证交换时，是将两个子结点中较大的那个和指定元素交换
//			if (!less(a,k, j))
//				break;
//			exch(k, j);
//			k = j;
//		}
//	}
//
//	private static boolean less(Comparable[] a,int i, int j) {
//		return a[i].compareTo(a[j]) < 0;
//	}
//
//
//}
