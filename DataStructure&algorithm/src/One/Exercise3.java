package One;

public class Exercise3 {
	public static int max(int[] a, int left, int right) {
		int max;
		int leftMax;
		int rightMax;
		int mid = (left + right) / 2;

		if (mid == left)
			return a[left];
		else if (mid - left <= 1)
			return (a[mid] - a[left]) >= 0 ? a[mid] : a[left];
		if ((mid + 1) == right)
			return a[right];
		else if (right - mid - 1 <= 1)
			return (a[right] - a[mid + 1]) >= 0 ? a[right] : a[mid + 1];

		leftMax = max(a, left, mid);
		rightMax = max(a, mid + 1, right);

		return (rightMax - leftMax) >= 0 ? rightMax : leftMax;
	}

	public static double average(int[] a,int index) {
		return sum(a,index)/a.length;
	}

	private static int sum(int[] a, int index) {
		if (index == a.length - 1) {
			return a[index];
		} else {
			return a[index] + sum(a, ++index);
		}
	}

	public static void main(String[] args) {
		int a[] = {8, 3, 4, 645};

		double average = average(a, 0);
		System.out.println(average);

		int sum = sum(a, 0);
		System.out.println(sum);
	}

}
