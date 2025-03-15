import ArraysAndStrings.PalindromePermutation;
import ArraysAndStrings.URLify;

public class Main {
    public static void main(String[] args) {
        String s = "aabc";
        var test = new PalindromePermutation();
        System.out.println(test.palindromePermutation(s.toLowerCase()));
    }
}