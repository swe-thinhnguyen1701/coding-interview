import ArraysAndStrings.*;
import LinkedLists.Node;
import LinkedLists.Partition;
import LinkedLists.RemoveDups;
import LinkedLists.SumLists;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       var num1 = new Node(8, new Node(7, new Node(9)));
       var num2 = new Node(5, new Node(8, new Node(6)));
       Node num3 = null;
       var test = new SumLists();
       var result = test.sumForward(num1, num2);

       while(result!=null){
          System.out.print(result.val + " ");
          result = result.next;
       }
    }
}