package One;

public class Exercise2 {
	public void permute(String str) {
		char[] arr = new char[str.length()];
		for (int i = 0; i < str.length(); i++)
			arr[i] = str.charAt(i);
		permute(arr, 0, arr.length - 1);
	}

	private void permute(char[] str, int low, int high) {
		if (low == high) {
			for (int i = 0; i <= high; i++)
				System.out.print(str[i]);
			System.out.println();
		} else {
			for (int i = low; i <= high; i++) {
				exchange(str,low,i);
				permute(str, ++low, high);
				exchange(str,--low,i);
			}
		}
	}

	private void exchange(char[] str,int x,int y) {
		char temp=str[x];
		str[x] = str[y];
		str[y]=temp;
	}

	public static void main(String[] args) {
		new Exercise2().permute("abcd");
	}
}
