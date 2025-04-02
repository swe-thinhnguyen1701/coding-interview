package StacksAndQueues;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Problem description:
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would
 * likely start a new stack when the previous stack exceeds some threshold. Implement a data structure SetOfStacks that
 * mimics  this. SetOfStacks should be composed of several stacks and should create a new stack one the previous one
 * exceeds capacity. SetOfStacks.push() and SetOfStack.pop() should behave identically to a single stack (that is, pop()
 * should return the same values as it would if there were just a single stack.
 *
 * This is version 2 of Set of Stack focusing on solving the FOLLOW UP question.
 *
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 *
 * Data field is kind of similar to version 1, but I add trackingSetOfStacks to keep track a Stack when popping.
 * When a popAt(index) method is called (suppose index is valid), then it will make that stack available to push another
 * value. Therefore, I will store an index in trackingSetOfStacks, and when a push() method is called, it will make sure
 * trackingSetOfStacks is empty before pushing new value to the last Stack or a new Stack.
 * The reason I use PriorityQueue because I want a stack works exactly what it's designed.
 * For example, suppose I use Stack or Queue for trackingSetOfStacks instead. When popAt(index) is called with various
 * indices, the push() method cannot consistently add value into 1 stack. Therefore, to consist a stack for the next push,
 * using PriorityQueue is more efficient.
 *
 * Time Complexity:
 * Push & Pop: O(1) for stack operations, but O(log M) for PriorityQueue in some cases.
 * Total Time Complexity: O(log M) in the worst case, which simplifies to O(log N) when M approaches N.
 *
 * Space Complexity:
 * Stacks (hm): O(N), since we store all elements.
 * Tracking Set (PriorityQueue): At most O(N/capacity), which is much smaller than O(N).
 * Total Space Complexity: O(N) (because PriorityQueue is negligible compared to stored values).
 */

public class SetOfStacksV2 {
    private int idx;
    private final int capacity;
    private HashMap<Integer, Stack<Integer>> hm;
    private PriorityQueue<Integer> trackingSetOfStacks;

    public SetOfStacksV2(int capacity) {
        this.capacity = capacity;
        this.idx = -1;
        this.hm = new HashMap<>();
        this.trackingSetOfStacks = new PriorityQueue<>();
    }

    public int pop() {
        while(idx != -1) {
            if(!hm.containsKey(idx))
                idx--;
            else {
                int val = hm.get(idx).pop();

                if(hm.get(idx).isEmpty())
                    hm.remove(idx--);

                return val;
            }
        }

        throw new RuntimeException("Stack is empty");
    }

    public int popAt(int index) {
        if(index > this.idx || index < 0) throw new IndexOutOfBoundsException("Stack at " + index + " is out of bounds");

        if(!hm.containsKey(index)) throw new RuntimeException("Stack is empty");

        trackingSetOfStacks.offer(index);

        int val = hm.get(index).pop();

        if(hm.get(index).isEmpty())
            hm.remove(index);

        return val;
    }

    public void push(int val) {
        if(!trackingSetOfStacks.isEmpty()) {
            int idx = trackingSetOfStacks.poll();

            hm.putIfAbsent(idx, new Stack<>());
            hm.get(idx).push(val);

            return;
        }

        if(idx == -1 || hm.get(idx).size() == capacity){
            hm.put(++idx, new Stack<>());
        }

        hm.get(idx).push(val);
    }
}