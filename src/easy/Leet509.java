package easy;

public class Leet509 {

    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
    }

    //recursive method but loop method more faster 
    public static int fib(int N) {
        if (N == 0)
            return 0;
        else if (N == 1)
            return 1;
        else {
            return fib(N - 1) + fib(N - 2);
        }
    }
}
