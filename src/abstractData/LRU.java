package abstractData;

import java.util.LinkedList;
import java.util.Queue;

public class LRU {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();
        queue.offer("0");
        int k = 0;
        while (!queue.isEmpty()) {
            k++;
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                String value = queue.poll();
                System.out.println(value);

                queue.offer(value + "0");
                queue.offer(value + "1");
            }

            if (k == 15) {
                break;
            }
        }

    }


}
