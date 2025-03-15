import ArraysAndStrings.OneWay;
import ArraysAndStrings.PalindromePermutation;
import ArraysAndStrings.URLify;

public class Main {
    public static void main(String[] args) {
        var test = new OneWay();
        System.out.println(test.oneWay("abc", "abdc"));
        System.out.println(test.oneWay("a", " "));
    }
}