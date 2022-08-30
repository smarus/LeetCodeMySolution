package abstractData;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {

        search(0);
        System.out.println(list.size());
    }

    public static void search(int k) {
        if (k == 7) {
            System.out.println(list);
        } else {
            search(k + 1);
            list.add(k);
            search(k + 1);
            list.remove(list.size() - 1);
        }
    }
}
