package easy.string.easy;

import java.util.Arrays;

public class Leet1189 {
    public static void main(String[] args) {
        String text = "nlaebolko";
        String text2 = "loonbalxballpoon";
        String text3 = "leetcode";
        String text4 = "krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw";
        System.out.println(maxNumberOfBalloons(text));
        System.out.println(maxNumberOfBalloons(text2));
        System.out.println(maxNumberOfBalloons(text3));
        System.out.println(maxNumberOfBalloons(text4));

    }

    public static int maxNumberOfBalloons(String text) {
        int count = 0;
        int[] alphabet = new int[26];

        for (char c : text.toCharArray()) {
            alphabet[c - 'a']++;
        }
        System.out.println(Arrays.toString(alphabet));
        int index = Math.max(alphabet[0], alphabet[1]);
        index = Math.max(index, alphabet[14]);
        index = Math.max(index, alphabet[11]);
        index = Math.max(index, alphabet[13]);
        while (index != 0) {
            if (alphabet[0] == 0 || alphabet[1] == 0 || alphabet[11] <= 1 || alphabet[14] <= 1 || alphabet[13] == 0) {
                break;
            }
            alphabet[0]--;
            alphabet[1]--;
            alphabet[11] -= 2;
            alphabet[14] -= 2;
            alphabet[13]--;


            count++;
            index--;

        }

        return count;
    }
}
