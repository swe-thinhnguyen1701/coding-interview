package ArraysAndStrings;

/**
 * Problem description:
 * Write a method to replace all spaces in a string with "%20". You may assume that the string has sufficient space at
 * the end to hold the additional characters, and that you are given the "true" length of the string. (Note: If
 * implementing in Java, please use a character array so that you can perform this operation in place.)
 *
 * EXAMPLE:
 * Input:  "Mr John Smith    ", 13
 * Output: "Mr%20John%20Smith"
 *
 * ANALYZE:
 * Am I given a string? (Unsure)
 *
 * CASE 1: IF I am given a string
 * Time Complexity:
 * 1. Iterating through the string:
 * The right pointer loops through the string from 0 to trueLength, which is O(N), where N is the trueLength of the
 * string.
 *
 * 2. Substring operation:
 * Each time I encounter a space, I append a substring. s.substring(left, right) creates a new substring for the
 * characters between left and right.
 *
 * The substring operation itself is O(k) where k is the length of the substring. In the worst case, I may end up
 * creating a substring of size N when I reach the last part of the string.
 *
 * Since each substring operation involves copying a portion of the string, the total time spent on all the substring
 * operations is O(N) over the course of the loop.
 *
 * 3. Appending "%20":
 * The appending of "%20" is O(1) because it's a fixed-length string.
 *
 * Space Complexity:
 * The space complexity depends on the number of characters in the given string. Since I am replacing each space ' '
 * with the string "%20", I effectively add 2 extra characters for each space. Therefore, the space required for storing
 * the result is proportional to the number of characters in the string, and since I may end up adding additional
 * characters for every space, the total space complexity is O(N), where N is the true length of the string (not counting
 * the trailing spaces). This accounts for the new string being constructed in the StringBuilder.
 *
 * CASE 2: IF I am given a char array
 * Time Complexity:
 * 1. Iterate through the string:
 * The idx2 pointer starts at trueLength - 1 and moves backward to 0, iterating through the given characters. This takes
 * O(N) time, where N is trueLength.
 * The idx1 pointer tracks where the characters should be placed in the final modified array.
 * If idx2 encounters a space (' '), it replaces it with three characters: '0', '2', and '%'. Since writing three
 * characters is still an O(1) operation, it does not affect the overall time complexity.
 *
 * Space complexity:
 * The transformation is done in place, meaning it modifies the original char[] array rather than creating a new data
 * structure.
 * Because no additional space is used apart from a few pointers (idx1, idx2), the space complexity is O(1).
 *
 */

public class URLify {

    // CASE 1
    public String urlify(String s, int trueLength) {
        StringBuilder sb = new StringBuilder();
        int left = 0, right = 0;
        while(right < trueLength) {
            if(s.charAt(right) == ' ') {
                sb.append(s.substring(left, right));
                sb.append("%20");
                left = right + 1;
            }

            right++;

            if(right == trueLength) {
                sb.append(s.substring(left, right));
            }
        }

        return sb.toString();
    }

    // CASE 2
    public char[] urlify(char[] array, int trueLength) {
        int idx1 = array.length - 1;
        int idx2 = trueLength - 1;

        while(idx2 > -1) {
            if(array[idx2] == ' ') {
                array[idx1--] = '0';
                array[idx1--] = '2';
                array[idx1--] = '%';
            } else {
                array[idx1--] = array[idx2];
            }

            idx2--;
        }

        return array;
    }
}
