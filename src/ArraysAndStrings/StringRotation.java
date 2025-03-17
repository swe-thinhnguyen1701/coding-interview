package ArraysAndStrings;

/**
 * Problem description:
 * Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2
 * , write code to check if s2 is a rotation of s1 using only one call to isSubstring(e.g., "waterbottle" is rotation of
 * "erbottlewat".
 *
 * ANALYSIS:
 * s2 length must be equal to s1 length
 * if I split "erbottlewat" into 2 part, I will have "erbottle" and "wat". It's look like a substring of combination of
 * s1: "wat[erbottlewat]erbottle"
 * If so, I will duplicate s1 and iterate through s1.
 * I will get a substring from ith to i + s1.length and compare it with s2.
 * if they are equal, return true
 * otherwise, return false.
 *
 * Time complexity:
 * Iterate string s1, it takes O(N), where N is the number of characters in s1.
 *
 * Space complexity:
 * Since I duplicate s1, it takes O(N)
 *
 */

public class StringRotation {

    public boolean isSubstirng(String s1, String s2){
        if(s2.length() != s1.length()){
            return false;
        }

        StringBuilder sb = new StringBuilder(s1 + s1);
        for(int i = 0; i < s1.length(); i++){
            if(s2.equals(sb.substring(i, i + s1.length()))){
                return true;
            }
        }

        return false;
    }
}
