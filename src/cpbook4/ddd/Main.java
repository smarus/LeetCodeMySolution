package cpbook4.ddd;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = Integer.parseInt(sc.nextLine());
        while (TC-- > 0) {
            String line = sc.nextLine();
            if (isTwoAl(line)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    static boolean isTwoAl(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> pair : map.entrySet()) {
            if (pair.getValue() != 2) {
                return false;
            }
        }
        return true;
    }
}


//    public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n;
//        List<Integer> list = new ArrayList<>();
//         // stop when both integers are 0
//         while (true) {
//           n = sc.nextInt();
//           if ((n == 0)) break;
//           while (n > 9) {
//                n = getSumOfNumber(n);
//           }
//           list.add(n);
//        }
//        for (int i = 0; i <list.size() ; i++) {
//            System.out.println(list.get(i));
//        }
//    }
//
//    public static int getSumOfNumber(int n){
//        if (n == 0)
//            return 0;
//        if(n < 10)
//            return n;
//        return getSumOfNumber(n/10) + n % 10;
//
//    }
