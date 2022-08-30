package leetcode.easy.bit_operation;

public class Leet693 {
    public static void main(String[] args) {

        System.out.println(hasAlternatingBits(7));

    }


    public static boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);

        char c = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (c == s.charAt(i))
                return false;
            c = s.charAt(i);
        }
        return true;
    }
//    x & (x-1) will clear the lowest set bit of x
//    x & ~(x-1) extracts the lowest set bit of x (all others are clear). Pretty patterns when applied to a linear sequence.
//    x & (x + (1 << n)) = x, with the run of set bits (possibly length 0) starting at bit n cleared.
//    x & ~(x + (1 << n)) = the run of set bits (possibly length 0) in x, starting at bit n.
//    x | (x + 1) = x with the lowest cleared bit set.
//            x | ~(x + 1) = extracts the lowest cleared bit of x (all others are set).
//    x | (x - (1 << n)) = x, with the run of cleared bits (possibly length 0) starting at bit n set.
//    x | ~(x - (1 << n)) = the lowest run of cleared bits (possibly length 0) in x, starting at bit n are the only clear bits.

//    boolean hasAlternatingBits2(int n) {
//        /*
//        n =         1 0 1 0 1 0 1 0
//        n >> 1      0 1 0 1 0 1 0 1
//        n ^ n>>1    1 1 1 1 1 1 1 1
//        n           1 1 1 1 1 1 1 1
//        n + 1     1 0 0 0 0 0 0 0 0
//        n & (n+1)   0 0 0 0 0 0 0 0
//        */
//
//        n = n ^ (n>>1);
//        return (n & n+1) == 0;
//    }

}
