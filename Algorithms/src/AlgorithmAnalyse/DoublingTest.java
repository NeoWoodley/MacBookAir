package AlgorithmAnalyse;

/**
 * DoublingTest是Stopwatch的一个更加复杂的用例，并能够为ThreeSum产生实验数据
 * <p>
 * 它会产生一系列随机输入数组，在每一步中将数组长度加倍，并打印出ThreeSum.count()处理每种输入规模所需的运行时间
 */
public class DoublingTest {
	/**
	 * 为处理N个随机的六位整数的ThreeSum.count()计时
	 *
	 * @param N 整数的个数
	 * @return 返回所需的时间
	 */
	public static double timeTrial(int N) {
		int MAX = 1000000;
		int[] a = new int[N];

		// TODO: 2018/8/18 这里有问题
//		for (int i = 0; i < N; i++)
//			a[i] = StdRandom.uniform(-MAX, MAX);  // 生成随机数组

		Stopwatch timer = new Stopwatch();
		int cnt = ThreeSum.count(a);
		return timer.elapsedTime();
	}

	public static void main(String[] args) {
		// 打印运行时间的表格
		// TODO: 2018/8/18 这玩意儿不会死循环吗？？？
		for (int N = 250; true; N += N) {
			// 打印问题规模为N时程序的用时
			double time = timeTrial(N);
			System.out.println(N + "\t" + time);
		}
	}
}
