package LinkedLists;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem description:
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 *
 * ANALYSIS:
 * CASE 1: Suppose I am allowed to use temporary buffer.
 * I can use Set to keep track what number already existed. The reason I use Set because the time of finding element is
 * constant O(1) when using set while using List or ArrayList takes O(N)
 *
 * Time Complexity:
 * Iterate through linked list takes O(N).
 * Determining if a value exists takes O(1).
 *
 *
 * Space Complexity:
 * I use set to keep track what number already existed, so it takes O(N) space.
 *
 * CASE 2: Suppose I am not allowed to use a temporary buffer.
 * To remove duplicate nodes without using extra space, I need to use the current node
 * and compare it with all other nodes until the end.
 * If I find a node with the same value, I update current.next to skip the duplicate node.
 * I keep doing this until I reach the last node.
 *
 * Time Complexity:
 * - The outer loop takes O(N), where N is the number of nodes.
 * - The inner loop compares the current node with all remaining nodes, taking O(N - 1).
 * - Therefore, the total time complexity is O(N * (N - 1)) = O(N²).
 *
 * Space Complexity:
 * - Since I do not use any extra memory to track existing values, the space complexity remains O(1).
 */

public class RemoveDups {

    // CASE 1
    public void removeDups(Node head) {
        if(head == null)
            return;

        Set<Integer> set = new HashSet<>();
        set.add(head.val);

        while(head.next != null) {
           if(set.contains(head.next.val)) {
               head.next = head.next.next;
           } else {
               head = head.next;
               set.add(head.val);
           }
        }
    }

    // CASE 2
    public void removeDups2(Node head) {
        if(head == null)
            return;

        while(head != null) {
            Node copyHead = head;
            while(copyHead.next != null) {
                if (copyHead.next.val == head.val) {
                    head.next = head.next.next;
                } else {
                    copyHead = copyHead.next;
                }
            }

            head = head.next;
        }
    }
}
