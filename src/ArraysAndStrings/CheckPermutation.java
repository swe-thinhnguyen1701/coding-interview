package ArraysAndStrings;

import java.util.HashMap;

/**
 * Problem description:
 * Given two strings (s1, s2), write a method to decide if one is permutation of the other.
 *
 * s1 is considered a permutation of s2 if:
 * 1. s1.length == s2.length
 * 2. The number of occurrences of each character in s1 must match the number of occurrences of the corresponding
 * character in s2.
 *
 * SOLUTION:
 * I can use a HashMap to keep track of the number of occurrences of each character, where the key is the character and
 * the value is its count.
 *
 * The first loop will either install or update the count of each character.
 * IF a character does not exist in the HashMap, add it with a value of 1.
 * OTHERWISE, increment the value by 1 for each subsequence occurrence of that character.
 *
 * The second loop will :
 * 1. IF a character does not exist in the HashMap, return false.
 * 2. IF a character exists but its value is < 0, return false.
 * 3. OTHERWISE, return true.
 */

public class CheckPermutation {

    public boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char key = s1.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            char key = s2.charAt(i);
            if (!map.containsKey(key) || map.get(key) == 0) {
                return false;
            }
            map.put(key, map.get(key) - 1);
        }

        return true;
    }
}
