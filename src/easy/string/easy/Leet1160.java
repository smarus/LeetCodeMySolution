package easy.string.easy;

public class Leet1160 {
    public static void main(String[] args) {
        String[] array = new String[]{"cat", "bt", "hat", "tree"};
        String chars = "atach";
        System.out.println(countCharacters(array, chars));
        String[] array1 = new String[]{"hello", "world", "leetcode"};
        String chars2 = "welldonehoneyr";
        System.out.println(countCharacters(array1, chars2));

        String[] array3 = new String[]{"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin", "ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb", "ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl", "boygirdlggnh", "xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx", "nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop", "hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx", "juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr", "lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo", "oxgaskztzroxuntiwlfyufddl", "tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp", "qnagrpfzlyrouolqquytwnwnsqnmuzphne", "eeilfdaookieawrrbvtnqfzcricvhpiv", "sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz", "yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue", "hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv", "cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo", "teyygdmmyadppuopvqdodaczob", "qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs", "qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"};
        String chars3 = "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp";
        System.out.println(countCharacters(array3, chars3));
    }

    public static int countCharacters(String[] words, String chars) {
        int[] alfabet = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            alfabet[chars.charAt(i) - 'a']++;
        }

        int counter = 0;
        for (String word : words) {
            int[] alf = new int[26];
            System.arraycopy(alfabet, 0, alf, 0, 26);
            boolean isContains = true;
            for (int i = 0; i < word.length(); i++) {
                if (--alf[word.charAt(i) - 'a'] < 0) {
                    isContains = false;
                    break;
                }
            }
            if (isContains)
                counter += word.length();
        }
        return counter;
    }
}
