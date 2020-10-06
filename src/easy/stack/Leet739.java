package easy.stack;

import Linked_list.AuxUtils;

public class Leet739 {
    public static void main(String[] args) {
        // int [] daily = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
        int[] daily = new int[]{73, 73, 73, 74, 74, 74, 50, 50};


//       int [] temp = dailyTemperatures(daily);
//        for (int i = 0; i <temp.length ; i++) {
//            System.out.println(temp[i]);
//        }


    }

    public static int[] dailyTemperatures(int[] T) {
        int[] daily = new int[T.length];
        int index = 0;
        for (int i = 0; i < T.length - 1; i++) {
            int count = 0;
            for (int j = i + 1; j < T.length; j++) {

                if (T.length - 1 != j)
                    count += 1;

                if (T[j] > T[i]) {
                    break;
                }

            }
            daily[index] = count;
            index += 1;
        }
        return daily;
    }
}
