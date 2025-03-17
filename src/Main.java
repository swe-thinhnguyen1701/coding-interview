import ArraysAndStrings.*;
import LinkedLists.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       var head = new Node(1, new Node(2));
       var test =  new Palindrome();
       System.out.println(test.isPalindrome(head));
    }
}