package MyTry;

public class Select {
	int[] num;
	boolean[] booleans;

	public Select(int N) {
		num = new int[N];
		booleans = new boolean[N];

		for (int i = 0; i < N; i++) {
			num[i] = i + 1;
		}
	}

	private void combination(int requestNum, int start) {
		if (requestNum == 0) {
			// 注意这里是从0到start-1
			for (int i = 0; i < start; i++) {
				if (booleans[i]) {
					System.out.print(num[i]);
				}
			}
			System.out.println();
			return;
		}
		if (start == num.length)
			return;

		// 设置true、false的顺序并不重要
		booleans[start] = false;
		combination(requestNum, start + 1);
		booleans[start] = true;
		combination(requestNum-1, start + 1);
	}

	public void combination(int requestNum) {
		combination(requestNum, 0);
	}

	public static void main(String[] args) {
		new Select(5).combination(3);
	}
}
