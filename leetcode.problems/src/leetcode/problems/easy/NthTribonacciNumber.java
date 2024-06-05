package leetcode.problems.easy;

/**
 * The Tribonacci sequence Tn is defined as follows: T0 = 0, T1 = 1, T2 = 1, and
 * Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0. Given n, return the value of Tn.
 * 
 * @author gaochf
 *
 */

public class NthTribonacciNumber {

	public int tribonacci(int n) {
		int t0 = 0;
		int t1 = 1;
		int t2 = 1;
		if (n == 0) {
			return t0;
		}
		if (n == 1) {
			return t1;
		}
		if (n == 2) {
			return t2;
		}

		int result = 0;
		for (int index = 3; index <= n; index++) {
			result = t0 + t1 + t2;
			t0 = t1;
			t1 = t2;
			t2 = result;
		}

		return result;
	}

	public static void main(String[] args) {
		NthTribonacciNumber ntn = new NthTribonacciNumber();
		int param = 25;
		System.out.println("param " + param + ": " + ntn.tribonacci(param));
	}

}
