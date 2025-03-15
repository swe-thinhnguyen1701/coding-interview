import ArraysAndStrings.URLify;

public class Main {
    public static void main(String[] args) {
        var urlify = new URLify();
        String s = "            ";
        String[] tests = {"abc", "            ", "a b", "  abc ", "a b c    "}
        System.out.println(urlify.urlify("Mr John Smith    ", 13));;
        System.out.println(urlify.urlify("a   ", 2));
//        char[] array = urlify.urlify(s.toCharArray(), 13);
        System.out.println(new String(urlify.urlify(s.toCharArray(), 4)));
    }
}