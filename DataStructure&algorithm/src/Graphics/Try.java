package Graphics;

public class Try {
	static int[] nums = {32, 4, 235, 34, 34345, 435, 1, 4};
	static int N = 8;

	public static void main(String[] args) {
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if (nums[i] > nums[j]) {
					swap(i, j);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print(nums[i]+" ");
		}
	}

	public static void swap(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
