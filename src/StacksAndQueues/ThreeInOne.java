package StacksAndQueues;


/**
 * Problem description:
 * Describe how you could use a single array to implement three stacks.
 *
 * ANALYSIS:
 * Suppose data type is int
 * The size must be at least 3 to implement three stacks, so I will throw an illegal argument exception when user
 * initialize a size < 3.
 * I need 3 indexes and sizes for 3 stacks to keep track.
 *
 * size1 = [0, totalSize / 3)
 * size2 = [(totalSize / 3), (totalSize 2/3))
 * size3 = [(totalSize 2 / 3) , totalSize)
 *
 * pop, peek, and push method will throw exception:
 * WHEN user enters invalid stack
 * WHEN user tries to get/remove value from an empty stack
 * WHEN user tries to push value to a full stack
 *
 * Time Complexity:
 * Push, Pop, and Peek method cost O(1).
 *
 * Space Complexity:
 * It cost O(N), where N is the number of elements.
 */

public class ThreeInOne {
    private final int[] array;
    private final int size1;
    private final int size2;
    private final int size3;
    private int idx1;
    private int idx2;
    private int idx3;

    public ThreeInOne(int size) {
        if(size < 3)
            throw new IllegalArgumentException("size must be at lest 3 to implement three stacks");
        this.array = new int[size];
        this.size1 = size / 3;
        this.size2 = size * 2 / 3;
        this.size3 = size;
        this.idx1 = 0;
        this.idx2 = size / 3;
        this.idx3 = size * 2 / 3;
    }

    public void push(int stack, int value) {
        if(stack > 3)
            throw  new IllegalArgumentException("Select a stack between 1 and 3 to push value");

        if(stack == 1) {
            pushFirstStack(value);
        } else if(stack == 2) {
            pushSecondStack(value);
        } else {
            pushThirdStack(value);
        }
    }

    public int peek(int stack) {
        if(stack > 3)
            throw  new IllegalArgumentException("Select a stack between 1 and 3 to peek value");

        int idx = stack == 1 ? idx1 : stack == 2 ? idx2 : idx3;
        return this.array[idx - 1];
    }

    public int pop(int stack) {
        if(stack > 3)
            throw  new IllegalArgumentException("Select a stack between 1 and 3 to pop value");

        return stack == 1 ? popStack1() : stack == 2 ? popStack2() : popStack3();
    }

    private int popStack1() {
        if (this.idx1 == 0)
            throw new IllegalArgumentException("Stack 1 is empty");

        return this.array[--idx1];
    }

    private int popStack2() {
        if (this.idx2 == this.size1)
            throw new IllegalArgumentException("Stack 2 is empty");

        return this.array[--idx2];
    }

    private int popStack3() {
        if (this.idx3 == this.size2)
            throw new IllegalArgumentException("Stack 3 is empty");

        return this.array[--idx3];
    }

    private void pushFirstStack(int value) {
        if(this.idx1 == this.size1)
            throw  new IllegalArgumentException("Stack 1 overflow");
        this.array[idx1++] = value;
    }

    private void pushSecondStack(int value) {
        if(this.idx2 == this.size2)
            throw  new IllegalArgumentException("Stack 2 overflow");

        this.array[idx2++] = value;
    }

    private void pushThirdStack(int value) {
        if(this.idx3 == this.size3)
            throw  new IllegalArgumentException("Stack 3 overflow");

        this.array[idx3++] = value;
    }
}
