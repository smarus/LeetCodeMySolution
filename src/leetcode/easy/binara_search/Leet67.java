package leetcode.easy.binara_search;

public class Leet67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carryout = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int sum = carryout;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            sb.append(sum % 2);
            carryout = sum / 2;
        }
        if (carryout != 0) {
            sb.append(carryout);
        }
        return sb.reverse().toString();
    }
}
