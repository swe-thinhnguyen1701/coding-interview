import ArraysAndStrings.*;
import LinkedLists.Node;
import LinkedLists.Partition;
import LinkedLists.RemoveDups;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       var head = new Node(4);
       var install = head;
       install.next = new Node(5);
       install = install.next;
       install.next = new Node(4);
       install = install.next;
       install.next = new Node(3);
       install = install.next;
       install.next = new Node(5);
       install = install.next;
       install.next = new Node(3);
       install = install.next;
       install.next = new Node(1);


       var test =new Partition();
       var newHead = test.partition(head, 4);
       while(newHead!=null){
           System.out.print(newHead.val + " ");
           newHead = newHead.next;
       }
    }
}