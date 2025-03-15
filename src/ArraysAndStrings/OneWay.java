package ArraysAndStrings;

/**
 * Problem description:
 * There are three types of edits that can be performed on strings: insert a character, remove a character, or replace
 * a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
 *
 * EXAMPLES:
 * pale, ple → true
 * pales, pale → true
 * pale, bale → true
 * pale, bake → false
 *
 * ANALYSIS:
 * To make sure obtaining 1 or 0 edit, the difference length between string s1 and s2 cannot exceed 2.
 *
 * Time Complexity:
 * O(Min(N, M)), where N is the length of string s1, and M is the length of string s2.
 *
 * Space Complexity:
 * O(1) since I do not use extra memory
 */

public class OneWay {

    public boolean oneWay(String s1, String s2) {
        if(Math.abs(s1.length() - s2.length()) > 1)
            return false;

        boolean flag = false;
        String longer = s1.length() > s2.length() ? s1 : s2;
        String shorter = s1.length() > s2.length() ? s2 : s1;
        int idx1 = 0, idx2 = 0;
        while (idx1 < longer.length() && idx2 < shorter.length()) {
            if(longer.charAt(idx1) != shorter.charAt(idx2)) {
                if(flag) {
                    return false;
                }
                flag = true;

                if(s1.length() == s2.length()) {
                    idx2++;
                }
            } else {
                idx2++;
            }

            idx1++;
        }

        return true;
    }
}
