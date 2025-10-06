public class Solution {

	public static long fibonacci(long n) {
		if (n <= 1) {
			return n;
		}
		long a = 0, b = 1;
        for (long i = 2; i <= n; i++) {
            long next = a + b;
            a = b;
            b = next;
        }
        return b;
	}

	public static void main(String[] args) {
		long n = Long.parseLong(args[0]);
		System.out.println(fibonacci(n));
	}
}  