package ArraysAndStrings;

/**
 * Problem description:
 * Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase
 * that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to
 * be limited to just dictionary words. You can ignore casing and non-letter characters.
 *
 * EXAMPLE:
 * Input: Tact Coa
 * Output: True (permutations: "taco cat", "atco cta", etc.)
 *
 * ANALYSIS:
 *
 * Assumptions:
 * Ignore case sensitivity (i.e., treat uppercase and lowercase letters as the same).
 * The string contains only alphabetic characters (no spaces, digits, or special symbols).
 *
 * Observations:
 * String length = 1 → Always true (a single character is always a palindrome).
 * String length = 2 → True if and only if both characters are the same (e.g., "aa" is valid, "ab" is not).
 * String length = 3 → True if it has at most one odd-count character (e.g., "aba" or "aaa" is valid, "abc" is not).
 *
 * General Rule:
 * A string can be rearranged into a palindrome if and only if it has at most one character with an odd frequency.
 * This applies to all cases:
 * If the string length is even, all characters must appear an even number of times.
 * If the string length is odd, only one character can appear an odd number of times (this will be the center character
 * in a potential palindrome).
 *
 * SOLUTION:
 * Count the number of occurrence of each character and store them in an array.
 * Iterate through the array to find whether it has more than 1 odd number of occurrence.
 * IF it finds odd occurrence but flag is false, then turn flag to true.
 * IF it finds odd occurrence and flag is true, return false.
 * OTHERWISE, return true.
 *
 */

public class PalindromePermutation {

    public boolean palindromePermutation(String string) {
        boolean flag = false;
        int[] occurrence = new int[26];
        for(char c : string.toCharArray()) {
            if(c >= 'a' && c <= 'z') {
                occurrence[c - 'a']++;
            }
        }

        for (int frequency : occurrence) {
            if(frequency % 2 != 0) {
                if(flag) {
                    return false;
                }

                flag = true;
            }
        }

        return true;
    }
}
