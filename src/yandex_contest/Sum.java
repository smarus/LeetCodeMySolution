package yandex_contest;

import java.io.*;
import java.util.*;

public class Sum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int a = Integer.parseInt(in.nextLine());
        int b = Integer.parseInt(in.nextLine());
        out.println(a + b);

        out.flush();
    }
}
