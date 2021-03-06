package DynamicProgramming;

public class LadderProblem {
	public int fibonacciSeries(int n) {
		int n1 = 0, n2 = 1;
		int sum;

		if (n == n1 || n == n2) {
			return n;
		}

		for (int i = 2; i <= n; i++) {
			sum = n1 + n2;
			n1 = n2;
			n2 = sum;
		}
		return n2;
	}

	public static void main(String args[]) {
		LadderProblem fs = new LadderProblem();
		System.out.println(fs.fibonacciSeries(15));

	}
}
