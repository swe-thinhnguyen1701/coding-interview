import StacksAndQueues.SetOfStacks;
import StacksAndQueues.StackMin;
import StacksAndQueues.ThreeInOne;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var test = new SetOfStacks(3);
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        System.out.println(test.pop());
        System.out.println(test.pop());
    }
}