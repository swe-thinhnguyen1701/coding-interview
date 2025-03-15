package ArraysAndStrings;

/**
 * Problem description:
 * Implement a method to perform basic string compression using the counts of repeated characters. For example, the
 * string "aabcccccaaa" would become "a2b1c5a3". If the "compressed" string would not become smaller than the original
 * string method should return the original string. You can assume the string has only uppercase and lowercase letters
 * (a - z).
 *
 * ANALYSIS:
 * Given:
 * A string consisting only of uppercase and lowercase alphabetic characters.
 * The goal is to return a compressed version of the string in the format:
 * <letter><count>, where:
 * The first character is a letter.
 * The second character (and onward) is the count of consecutive occurrences of that letter.
 * Compression Rule:
 * If the compressed string is shorter than the original string, return the compressed version.
 * Otherwise, return the original string.
 *
 * Solution:
 * I will iterate through the string. When I find a different character:
 * 1. append a letter and its frequency
 * 2. reset a frequency back to 1
 *
 * Time Complexity:
 * O(N), where N is the length of the string s, and the appending time cost O(1). Therefore, the total time complexity
 * is O(N).
 *
 * Space Complexity:
 * O(N) because I need to generate a new string when compressing the original string.
 */

public class StringCompression {
    public String compress(String s) {
        if(s.length() < 2) return s;

        int frequency = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i - 1) != s.charAt(i)){
                sb.append(s.charAt(i - 1)).append(frequency);
                frequency = 0;
            }

            frequency++;

            if(i == s.length() - 1){
                sb.append(s.charAt(i)).append(frequency);
            }
        }

        return sb.length() < s.length() ? sb.toString() : s;
    }
}
