public class App {
    public static void main(String[] args) throws Exception {
        runFibonaci();
        runFibonaciRecursivo();
        runFibonaciDP();
        runFibonaciO1();
    }

    private static void runFibonaci() {
        long startTime = System.nanoTime();
        int num = 48;
        long i = getFibonacci(num);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Fibonacci de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");
    }

    private static long getFibonacci(int i) {
        if (i <= 1) {
            return i;
        }
        return getFibonacci(i - 1) + getFibonacci(i - 2);
    }

    private static void runFibonaciRecursivo() {
        long startTime = System.nanoTime();
        int num = 48;
        
        long[] memo = new long[num + 1]; 
        long i = fibonacci(num, memo); 
        
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Fibonacci recursivo (Memo) de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");
    }

    public static long fibonacci(int n, long[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        return memo[n];
    }

    private static void runFibonaciDP() {
        long startTime = System.nanoTime();
        int num = 48;
        
        long i = fibonacciDP(num); 
        
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Fibonacci DP (Bottom-up) de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");
    }

    public static long fibonacciDP(int n) {
        if (n <= 1) return n;
        long[] dp = new long[n + 1];
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private static void runFibonaciO1() {
        long startTime = System.nanoTime();
        int num = 48;
        
        long i = fibonacciO1(num); 
        
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Fibonacci O(1) de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");
    }

    public static long fibonacciO1(int n) {
        if (n <= 1) {
            return n;
        }
        long a = 0; 
        long b = 1; 
        long resultado = 0;

        for (int i = 2; i <= n; i++) {
            resultado = a + b;
            a = b;         
            b = resultado;
        }
        return resultado;
    }
}