package One;

/**
 * 回环递归判定
 * 忽略空格、大小写、标点符号
 */
public class Exercise5 {
	public boolean isPalindromes(String str) {
		str = str.replaceAll("[\\pP\\p{Punct}\\s]","").toLowerCase();
		char[] arr = new char[str.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = str.charAt(i);
		}
		return isPalindromes(arr,0,arr.length-1);
	}

	private boolean isPalindromes(char[] arr,int start,int end) {
		while (start < end) {
			if (arr[start] != arr[end]) {
				return false;
			} else {
				isPalindromes(arr, ++start, --end);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new Exercise5().isPalindromes("Madam, I'm Adam."));
		System.out.println(new Exercise5().isPalindromes("Madam, iI'm Adam."));
	}

}
