package One;

public class Exercise1 {
	public static int NNumber(int n) {
		if(n==0)
			return 0;
		else if(n%2==0)
			return NNumber(n / 2);
		else
			return NNumber(n/2)+1;
	}

	public static void main(String[] args) {
		System.out.println(NNumber(7));
	}
}
