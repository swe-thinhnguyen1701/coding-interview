package ArraysAndStrings;

/**
 * Problem description:
 * Implement an algorithm to determine if a string has all unique characters. What's if you cannot use additional data
 * structures.
 * <p>
 * Solution:
 * I can use a fixed-size array to keep track of which letters appear more than twice. However, I don't know in advance
 * what kind of characters are in the string.
 * Are they alphabetic (if so, are they all lowercase, uppercase, or mixed case?), numeric, alphanumeric, or special
 * characters?
 * </p>
 *
 * <p>
 * This solution has O(N) time complexity because I need to iterate over each character to determine whether it already
 * exists. Checking if a character exists in the array takes O(1) time, so the total time complexity is O(N).
 * </p>
 *
 * <p>
 *     CASE 1:
 * Suppose the characters are all alphabetic and either lowercase or uppercase.
 * In this case, there are 26 different characters to handle.
 * Since I'm using a fixed-size array, the space complexity is O(1). Regardless of the string length, the array will
 * always have a size of 26.
 * </p>
 *
 * <p>
 *     CASE 2:
 * SUPPOSE all characters are alphabetic, mixed between lowercase and uppercase.
 * There are 52 characters in total, but when checking a character, I don't know which group (lowercase or uppercase)
 * it belongs to.
 * SOLUTION:
 * Generate two fixed-size arrays: one for lowercase letters and one for uppercase letters.
 * Compute the index offset by subtracting 'a' from the character.
 * IF the value is in the range [0, 25], the character belongs to the lowercase group.
 * OTHERWISE, it belongs to the uppercase group.
 * </p>
 *
 * <p>
 *     CASE 3:
 * SUPPOSE: the English alphabet and other characters (including uppercase/lowercase letters, numbers, and special
 * characters) fit within 256 different values. Therefore, I can generate a fixed-size array to check for duplicate
 * characters.
 * </p>
 */

public class IsUnique {
    private final String string;

    public IsUnique(String string) {
        this.string = string;
    }

    /**
     * When a string contains only lowercase alphabet characters.
     *
     * @return true if they have a duplicate letter, otherwise false
     */
    public boolean isUnique1() {
        boolean[] occurrence = new boolean[26];

        for(int i = 0; i < string.length(); i++) {
            if(occurrence[string.charAt(i) - 'a']) {
                return true;
            }
            occurrence[string.charAt(i) - 'a'] = true;
        }

        return false;
    }

    /**
     * When a string contains only uppercase alphabet characters
     *
     * @return true if they have a duplicate letter, otherwise false
     */
    public boolean isUnique2() {
        boolean[] occurrence = new boolean[26];

        for(int i = 0; i < string.length(); i++) {
            if(occurrence[string.charAt(i) - 'A']) {
                return true;
            }
            occurrence[string.charAt(i) - 'A'] = true;
        }

        return false;
    }

    /**
     *
     * @return true if they have a duplicate letter, otherwise false
     */
    public boolean isUnique3() {
        boolean[] lowercase = new boolean[26];
        boolean[] uppercase = new boolean[26];

        for(int i = 0; i < string.length(); i++) {
            if(isLowercase(string.charAt(i))) {
                if(lowercase[string.charAt(i) - 'a']) {
                    return true;
                }
                lowercase[string.charAt(i) - 'a'] = true;
            } else {
                if(uppercase[string.charAt(i) - 'A']) {
                    return true;
                }

                uppercase[string.charAt(i) - 'A'] = true;
            }
        }

        return false;
    }

//    FINAL ANSWER
    public boolean isUnique() {
        boolean[] occurrence = new boolean[256];

        for(int i = 0; i < string.length(); i++) {
            if(occurrence[string.charAt(i) - 'a']) {
                return true;
            }
            occurrence[string.charAt(i) - 'a'] = true;
        }

        return false;
    }

    private boolean isLowercase(char c) {
        return c - 'a' > -1 && c - 'a' < 26;
    }
}
