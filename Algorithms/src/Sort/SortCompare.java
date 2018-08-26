package Sort;

import AlgorithmAnalyse.Stopwatch;

/**
 * P161 比较两种排序算法
 *
 * SortCompare这类程序对于渐进式的算法研究十分重要。
 * 每一步，我们都能用过这类程序来了解新的或是改进后的算法的性能是否产生了预期的进步
 */

public class SortCompare {
	public static double time(String alg, Double[] a) {
		Stopwatch timer = new Stopwatch();
		if (alg.equals("Insertion"))
			Insertion.sort(a);
		if (alg.equals("Selection"))
			Selection.sort(a);
		if (alg.equals("Shell"))
			Shell.sort(a);
		if (alg.equals("Merge"))
			Merge.sort(a);
		return timer.elapsedTime();
	}

	public static double timeRandomInput(String alg, int N, int T) {
		// 使用算法alg将T个长度为N的数组排序
		double total = 0.0;
		Double[] a = new Double[N];

		// 用命令行参数指定重复次数T的好处：运行大量的测试、减小系统本身的影响
		for (int t = 0; t < T; t++) {
			// 进行一次测试（生成一个数组并排序）
			for (int i = 0; i < N; i++)
				a[i]=Math.random()*10;
			total += time(alg, a);
		}
		return total;
	}

	public static void main(String[] args) {
		// 奇怪，按道理应该是Insertion比较快啊
		String alg1 = args[0];
		String alg2 = args[1];
		int N = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);
		double t1 = timeRandomInput(alg1, N, T);  // 算法1的总时间
		double t2 = timeRandomInput(alg2, N, T);  // 算法2的总时间
		System.out.printf("For %d random Doubles %s is %.1f times faster than %s\n", N, alg1, t2 / t1, alg2);
	}
}
