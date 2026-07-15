public class App {
    public static void main(String[] args) throws Exception {

        Maze maze = new Maze();
        
    }

        private static void runFibonaciEsp() {
        long startTime = System.nanoTime();
        int num = 48;
        int n2 = 0;
        int aux = 0;

        long resultado = getFibonacciEsp(num, n2, aux);

        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = executionTime / 1_000_000.0;

        System.out.println("Fibonacci de " + num + " es " + resultado + " en: " + milliseconds + " ms");
    }

    public static long getFibonacciEsp(int n, long n1, long n2) {
        n1 = 0;
        n2 = 1;

        if (n <= 1)
            return n;

        long aux = 0;

        for (int i = 2; i <= n; i++) {
            aux = n1 + n2;
            n1 = n2;
            n2 = aux;
        }

        return aux;
    }

    private static void runFibonaciIterativo() {
        long startTime = System.nanoTime();

        int num = 48;

        long resultado = getFibonacciTab(num);

        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = executionTime / 1_000_000.0;

        System.out.println("Fibonacci de " + num + " es " + resultado + " en: " + milliseconds + " ms");
    }

    public static long getFibonacciTab(int n) {
        if (n <= 1) 
            return n;
        long[] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    private static void runFibonaciRecPD() {
        long startTime = System.nanoTime();

        int num = 48;
        long[] cache = new long[num + 1];

        long resultado = getFibonacciPD(num, cache);

        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = executionTime / 1_000_000.0;

        System.out.println("Fibonacci de " + num + " es " + resultado + " en: " + milliseconds + " ms");
    }

    public static long getFibonacciPD(int num, long[] cache) {
        if (num <= 1) 
            return num;
        if(cache[num] != 0){
            return cache[num];
        } 
        cache[num] = getFibonacciPD(num-1, cache) + getFibonacciPD(num - 2, cache);
        return cache[num];
    }

    private static void runFibonaci() {
        long startTime = System.nanoTime();
        int num = 48;
        long i = getFibonacci(num);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Finbonaci de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");

    }

    private static long getFibonacci(int i) {
        if (i <= 1) {
            return i;
        }
        return getFibonacci(i - 1) + getFibonacci(i - 2);
    }

}