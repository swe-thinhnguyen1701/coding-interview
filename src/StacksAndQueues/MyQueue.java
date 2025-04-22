package StacksAndQueues;

import java.util.Stack;

/**
 * Problem description:
 * Implement a MyQueue class which implements a queue using two stacks.
 *
 * Since I am allowed to use 2 stacks, the first stack is used to store all new values, while the second stack is
 * responsible for returning value.
 * offer() method maintains O(1) for adding new value
 * peek and poll method might take up to O(N) if and only if the second stack is empty, otherwise it remains O(1).
 *
 */

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;


    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void offer(int val){
        stack1.push(val);
    }

    public int poll() {
        if(stack1.isEmpty() && stack2.isEmpty())
            throw new IllegalArgumentException("Queue is empty");

        if(stack2.isEmpty())
            reverse();

        return stack2.pop();
    }

    public int peek() {
        if(stack1.isEmpty() && stack2.isEmpty())
            throw new IllegalArgumentException("Queue is empty");

        if(stack2.isEmpty())
            reverse();

        return stack2.peek();
    }

    private void reverse() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}
