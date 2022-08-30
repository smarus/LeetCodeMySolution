package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet811 {

    public static void main(String[] args) {

        String[] example = {"9001 discuss.leetcode.com"};
        String[] example2 = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(subdomainVisits(example));
        System.out.println(subdomainVisits(example2));

    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String domain : cpdomains) {
            String[] timesAndDomain = domain.split(" ");
            int times = Integer.parseInt(timesAndDomain[0]);
            String[] domains = timesAndDomain[1].split("\\.");
            if (domains.length == 3) {
                if (!hashMap.containsKey(domains[0] + "." + domains[1] + "." + domains[2])) {
                    hashMap.put(domains[0] + "." + domains[1] + "." + domains[2], times);
                } else {
                    Integer currentValue = hashMap.get(domains[0] + "." + domains[1] + "." + domains[2]);
                    currentValue += times;
                    hashMap.put(domains[0] + "." + domains[1] + "." + domains[2], currentValue);
                }
                if (!hashMap.containsKey(domains[1] + "." + domains[2])) {
                    hashMap.put(domains[1] + "." + domains[2], times);
                } else {
                    Integer currentValue = hashMap.get(domains[1] + "." + domains[2]);
                    currentValue += times;
                    hashMap.put(domains[1] + "." + domains[2], currentValue);
                }
                if (!hashMap.containsKey(domains[2])) {
                    hashMap.put(domains[2], times);
                } else {
                    Integer currentValue = hashMap.get(domains[2]);
                    currentValue += times;
                    hashMap.put(domains[2], currentValue);
                }
            } else {
                if (!hashMap.containsKey(domains[0] + "." + domains[1])) {
                    hashMap.put(domains[0] + "." + domains[1], times);
                } else {
                    Integer currentValue = hashMap.get(domains[0] + "." + domains[1]);
                    currentValue += times;
                    hashMap.put(domains[0] + "." + domains[1], currentValue);
                }
                if (!hashMap.containsKey(domains[1])) {
                    hashMap.put(domains[1], times);
                } else {
                    Integer currentValue = hashMap.get(domains[1]);
                    currentValue += times;
                    hashMap.put(domains[1], currentValue);
                }

            }

        }
        List<String> strings = new ArrayList<>();
        for (Map.Entry<String, Integer> map : hashMap.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(map.getValue());
            sb.append(" ");
            sb.append(map.getKey());
            strings.add(sb.toString());
        }
        return strings;
    }

}
