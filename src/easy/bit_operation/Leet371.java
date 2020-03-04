package easy.bit_operation;

public class Leet371 {
    public static void main(String[] args) {
        System.out.println(getSum(3, 1));
        System.out.println(getSum(3, -1));
    }

    public static int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
