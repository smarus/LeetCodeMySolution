package repeat.contest.route;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class LoginValidation {

    private static final char[] SUPPORT_SYMBOLS_CHAR = {'_', '-'};


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(reader.readLine());
        while (TC-- > 0) {
            int promts = Integer.parseInt(reader.readLine());
            Set<String> set = new HashSet<>();
            while (promts-- > 0) {
                String login = reader.readLine();
                if (isValid(login) && !set.contains(login.toLowerCase())) {
                    set.add(login.toLowerCase());
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }


    public static boolean isValid(final String username) {
        if (username.isEmpty())
            return false;
        if (username.length() < 2 || username.length() > 24)
            return false;

        if (username.startsWith("-"))
            return false;

        return isValidUsername(username.toCharArray());
    }

    private static boolean isValidUsername(final char[] username) {

        int currentPosition = 0;
        boolean valid = true;

        // check char by char
        for (char c : username) {

            if (!Character.isLetterOrDigit(c)) {

                if (!isSupportedSymbols(c)) {
                    valid = false;
                    break;
                }

//                if (username[0] == c || username[username.length - 1] == c) {
//                    valid = false;
//                    break;
//                }
//                if (isSupportedSymbols(username[currentPosition + 1])) {
//                    valid = false;
//                    break;
//                }

            }

            currentPosition++;
        }

        return valid;

    }

    private static boolean isSupportedSymbols(final char symbol) {
        for (char temp : SUPPORT_SYMBOLS_CHAR) {
            if (temp == symbol) {
                return true;
            }
        }
        return false;
    }
}
