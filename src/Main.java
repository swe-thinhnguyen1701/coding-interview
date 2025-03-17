import ArraysAndStrings.*;
import LinkedLists.Node;
import LinkedLists.RemoveDups;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       var head = new Node(3);
       var install = head;
       install.next = new Node(1);
       install = install.next;
       install.next = new Node(1);

       var test =new RemoveDups();
       test.removeDups(head);
       while(head!=null){
           System.out.print(head.val + " ");
           head = head.next;
       }
    }
}