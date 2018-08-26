package AlgorithmAnalyse;

/**
 * P110
 *
 * 一种表示计时的抽象数据类型
 */
public class Stopwatch {
	private final long start;

	public Stopwatch() {
		start = System.currentTimeMillis();
	}

	public double elapsedTime() {
		long now = System.currentTimeMillis();
		return (now - start) / 1000.0;
	}

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int[] a = new int[N];

//		for (int i = 0; i < N; i++)
//			a[i] = StdRan
		// TODO: 2018/8/18 这里不太对，有报错

	}
}
