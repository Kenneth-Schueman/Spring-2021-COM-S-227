package lab6;

public class Mason {
	public static void main(String[] args) {
		System.out.println(countPatterns(5));
	}

	public static int countPatterns(int n) {
		if (n < 3) {
			return 1;
		} else if (n == 3) {
			return 2;
		} else {
			return (1 + countPatterns(n - 1));
		}
	}
}

