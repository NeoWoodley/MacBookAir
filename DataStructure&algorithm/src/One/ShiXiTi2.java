package One;

public class ShiXiTi2 {
	private static void moveMore(int N, char from, char temp, char to) {
		if(N==0)
			return;
		if (N == 1) {
			System.out.println("1 from" + from + " to " + to);
		} else {
			moveMore(N-1, from, to, temp);
			moveOne(N,from,to);
			moveMore(N-1, temp, from, to);
		}
	}

	private static void moveOne(int N, char from, char to) {
		System.out.println(N + " from " + from + " to " + to);
	}

	public static void main(String[] args) {
		int N = 3;
		moveMore(N, 'A', 'B', 'C');
	}
}
