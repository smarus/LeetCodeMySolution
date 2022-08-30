package foo;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class GearDestruction {

    public static void main(String[] args) {
        int[] pegs = new int[]{4, 30, 50};
        int[] pegs1 = new int[]{4, 17, 50};
        int[] pegs2 = new int[]{4, 17, 50};
        System.out.println(Arrays.toString(GearDestruction.solution(pegs)));
        System.out.println(Arrays.toString(GearDestruction.solution(pegs1)));
        System.out.println(Arrays.toString(GearDestruction.solution(pegs2)));
    }

    public static int[] solution(int[] pegs) {
        // Your code here

        int[] endRad = new int[]{-1, -1};
        List<Integer> allRad = new ArrayList<>();
        boolean isRadIn = true;

        int diffRad = pegs[1] - pegs[0];
        for (int rad = 1; rad < diffRad; rad++) {
            if (allRad.size() < 1) {
                allRad.add(rad);
            } else {
                allRad.set(0, rad);
            }

            for (int peg = 1; peg < pegs.length; peg++) {
                if (allRad.size() > peg) {
                    allRad.set(peg, pegs[peg] - pegs[peg - 1] - allRad.get(peg - 1));
                } else {
                    allRad.add(pegs[peg] - pegs[peg - 1] - allRad.get(peg - 1));
                }

                if (allRad.get(peg) < 1) {
                    isRadIn = false;
                }

            }

            if (isRadIn && allRad.get(allRad.size() - 1) > 0) {
                int size = allRad.get(allRad.size() - 1);

                if (size * 2 == allRad.get(0)) {
                    endRad[0] = allRad.get(0);
                    endRad[1] = 1;
                    break;
                }

                if (rad + 1 == 2 * size) {
                    endRad[0] = allRad.get(0) * 3 + 1;
                    endRad[1] = 3;
                    break;
                }

                if (rad + 2 == 2 * size) {
                    endRad[0] = allRad.get(0) * 3 + 2;
                    endRad[1] = 3;
                    break;
                }
            }

            isRadIn = true;
        }

        return endRad;

    }
}
