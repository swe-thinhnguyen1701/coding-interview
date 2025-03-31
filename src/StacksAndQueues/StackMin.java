package StacksAndQueues;

import java.util.Stack;

/**
 * Problem description:
 * How would you design a stack which, in addition to push a pop, has a function min which returns the minimum element?
 * Push, pop and min should all operate in O(1) time.
 *
 * With this problem I will use 2 stacks: One is for tracking the minimum value, and the other is for general stack.
 * For the stack tracking minimum value, it only pushes values if a value is <= peek().
 *
 * Time Complexity:
 * pop, push and min are all remain O(1) time complexity. Therefore, the total time is O(1).
 *
 * Space complexity:
 * Total space complexity cost O(N), where N is the number of elements.
 */

public class StackMin {
    Stack<Integer> minStack;
    Stack<Integer> stack;

    public StackMin() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int val) {
        if(minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }

        stack.push(val);
    }

    public int pop() {
        if(stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int val = stack.pop();

        if(val == minStack.peek()) {
            minStack.pop();
        }

        return val;
    }

    public int min() {
        if(stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return minStack.peek();
    }
}
