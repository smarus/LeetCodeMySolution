package learning.Recursion;

public class PrintN {

    public static void main(String[] args) {
        printRecursively(10);
        System.out.println("--------");
        reverse(10);
    }

    public static void printRecursively(int n) {
        if (0 == n)
            return;
        printRecursively(n - 1);
        System.out.println(n);
    }

    public static void reverse(int n) {
        if (n == 0)
            return;

        System.out.println(n);
        reverse(n - 1);
    }


}
