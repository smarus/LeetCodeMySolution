package java_udemy.recursion;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(sumIterative(3));
        System.out.println(sumRecursive(3));
    }

    public static int sumIterative(int n) {
        int sum = 0;


        for (int i = n; i > 0; i--) {
            sum = sum + i;
        }

        return sum;
    }

    public static int sumRecursive(int n) {
        if (n == 1)
            return 1;

        return n + sumRecursive(n - 1);
    }

    public static int fibonaci(int n, int fib1, int fib2) {
        if (n == 1)
            return fib1 + fib2;


        return fibonaci(n - 1, fib1, fib1);
    }
}
