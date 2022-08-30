package leetcode.easy.arrays;

public class Leet1221 {
    public static void main(String[] args) {

    }

    public int balancedStringSplit(String s) {
        int balance = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L')
                balance++;
            else
                balance--;

            if (balance == 0)
                count++;
        }
        return count;

    }
}
