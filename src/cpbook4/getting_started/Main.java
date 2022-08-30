package cpbook4.getting_started;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap();
        map.put("HELLO", "ENGLISH");
        map.put("HOLA", "SPANISH");
        map.put("HALLO", "GERMAN");
        map.put("BONJOUR", "FRENCH");
        map.put("CIAO", "ITALIAN");
        map.put("ZDRAVSTVUJTE", "RUSSIAN");
        Character c = 'c';
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (true) {
            String line = sc.nextLine();
            if (line.equals("#")) {
                break;
            }
            list.add(line);


        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Case " + (i + 1) + ": " + map.getOrDefault(list.get(i), "UNKNOWN"));
        }
    }

}
