import StacksAndQueues.StackMin;
import StacksAndQueues.ThreeInOne;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var test = new StackMin();
        test.push(1);
        test.push(2);
        test.push(0);

        System.out.println(test.min());

        test.pop();
        System.out.println(test.min());
    }
}