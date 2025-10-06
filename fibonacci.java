public class Solution {
    // Type your main code here
    /**
    * Tính số Fibonacci tại vị trí n.
    */
    
    public static long fibonacci(long n) {
        if (n == 1 || n == 0) {
            return n;
        }
        if (n < 0) {
            return -1;
        }
        long a = 0; 
        long b = 1;
        for (long i = 2; i <= n; i++) {
            if (Long.MAX_VALUE - b < a) {
                return Long.MAX_VALUE; 
            }
            long next = a + b;
            a = b;
            b = next;
        }
        return b;
    }
}  