package One;

/**
 * 使用递归打印数字所有可能的组合
 */
public class SHiXITI1 {
	private int[] num;
	private boolean[] booleans;  // 用于指示哪几个位置的元素需要被打印

	/**
	 * 构造函数
	 *
	 * 在num[]数组中初始化所要使用的数字
	 * @param N  自然数的个数
	 */
	public SHiXITI1(int N) {
		num = new int[N];
		booleans = new boolean[N];

		for (int i = 0; i < N; i++)
			num[i] = i + 1;
	}

	/**
	 *
	 * @param requestNum  需要打印的数字的个数，也用于指示booleans数组中还有几个元素需要被置为true
	 * @param start  需要被重新设置true、false的起始位置
	 */
	private void combination(int requestNum, int start) {
		// 递归的基础条件
		// 如果booleans数组中true、false全都设置好了，就开始打印
		if (requestNum == 0) {
			for (int i = 0; i < start; i++) {
				if (booleans[i])
					System.out.print(num[i]);
			}
			System.out.println();
			return;
		}
		if(start==num.length)
			return;
		// 开始将问题分解，在num.length个数字中选出requestNum个数字，等价于
		// 1. 第start个数字选择，再在剩下的数字中选择requestNum-1个数字
		// 2. 第start个数字不选择，再在剩下的数字中选择requestNum个数字
		booleans[start]=true;
		combination(requestNum-1,start+1);
		booleans[start]=false;
		combination(requestNum,start+1);
	}

	public void combination(int requestNum) {
		combination(requestNum,0);
	}
	public static void main(String[] args) {
		new SHiXITI1(5).combination(3);
	}

}
