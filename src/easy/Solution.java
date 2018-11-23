package easy;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[]  widths = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String S = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(Arrays.toString(numberOfLines(widths, S)));
    }


    public static int [] numberOfLines(int [] widths, String s){
        int currentLineCount = 0;
        int line = 1;
        for(char c : s.toCharArray()){
            int currentWidth = widths[c - 'a'];
            if (currentLineCount + currentWidth > 100){
                line++;
                currentLineCount = currentWidth;
            }else {
                currentLineCount += currentWidth;
            }
        }

        return new int[]{line,currentLineCount};
    }
}
