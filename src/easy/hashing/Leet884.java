package easy.hashing;

import java.util.*;

public class Leet884 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String A = "this apple is sweet", B = "this apple is sour";
        String[] un = uncommonFromSentences(A, B);
        for (String s : un)
            System.out.println(s);
    }

    public static String[] uncommonFromSentences(String A, String B) {
        String[] arr = A.split(" ");
        String[] brr = B.split(" ");
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSetB = new HashSet<>();

        hashSet.addAll(Arrays.asList(arr));
        hashSetB.addAll(Arrays.asList(brr));
        List<String> list = new ArrayList<>();
        for (String s : brr) {
            if (!hashSet.contains(s)) {
                list.add(s);
            }
        }

        for (String s : arr) {
            if (!hashSetB.contains(s)) {
                list.add(s);
            }
        }


        String[] array = new String[list.size()];
        array = list.toArray(array);
        return array;
    }
}
