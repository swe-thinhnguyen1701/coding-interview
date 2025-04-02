package StacksAndQueues;

import java.util.HashMap;
import java.util.Stack;

/**
 * Problem description:
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would
 * likely start a new stack when the previous stack exceeds some threshold. Implement a data structure SetOfStacks that
 * mimics  this. SetOfStacks should be composed of several stacks and should create a new stack one the previous one
 * exceeds capacity. SetOfStacks.push() and SetOfStack.pop() should behave identically to a single stack (that is, pop()
 * should return the same values as it would if there were just a single stack.
 *
 * With this problem, I will use HashMap to store all stacks because the accessing and adding time is constant.
 * I will need 4 variables:
 * idx: is used to access a stack from hashmap
 * capacity: determine the maximum number of elements of each stack.
 * hm: is a hashmap that store Stack as a value and key as an idx.
 *
 * Time Complexity:
 * Since the adding new stack and accessing a stack from hashmap is constant, it takes O(1).
 * Push and pop method from stack also takes O(1).
 * Therefore, the total time complexity is O(1).
 *
 * Space Complexity:
 * The total space complexity is O(N), where N is the number of elements.
 */

public class SetOfStacks {
    private int idx;
    private final int capacity;
    private HashMap<Integer, Stack<Integer>> hm;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
        this.idx = -1;
        this.hm = new HashMap<>();
    }

    public int pop() {
        if (idx == -1 || !hm.containsKey(idx))
            throw new IllegalArgumentException("Stack is empty");

        int val = hm.get(idx).pop();

        if(hm.get(idx).isEmpty())
            hm.remove(idx--);

        return val;
    }

    public void push(int val) {
        if(idx == -1 || hm.get(idx).size() == capacity){
            Stack<Integer> tmp = new Stack<>();
            tmp.push(val);
            hm.put(++idx, tmp);
            return;
        }

        hm.get(idx).push(val);
    }
}
