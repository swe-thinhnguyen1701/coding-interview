import StacksAndQueues.ThreeInOne;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var test = new ThreeInOne(5);
        test.push(1, 1);
        test.push(2, 2);
        test.push(2, 5);
        test.push(3, 3);
        System.out.println(test.peek(1));
        System.out.println(test.peek(2));
        System.out.println(test.peek(3));

        System.out.println(test.pop(2));
        test.push(2, 10);
        System.out.println(test.peek(2));
//        test.push(1, 2);
//        System.out.println(1 | 1);
    }
}