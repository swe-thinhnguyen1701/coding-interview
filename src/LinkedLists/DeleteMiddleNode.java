package LinkedLists;

/**
 * Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily
 * the exact middle) of a singly linked list, given only access to that node.
 *
 * EXAMPLE:
 * Input:  a → b → c → d → e → f
 * Output: a → b → d → e → f
 *
 * ANALYSIS:
 * I am given a node, and I need to remove this node.
 * First, I replace the value of the given node with the value of the node next to it. Then, I update its pointer to point to currentNode.next.next.
 * What if the given node is null? Then, I should throw an error or return.
 * What if node.next is null? Then, I should throw an error or return.
 *
 * Time Complexity:
 * Removing node does not take any extra time, so it remains constant O(1).
 *
 * Space Complexity:
 * Similarly, I do not use any extra memory, so it also remains constant O(1).
 */

public class DeleteMiddleNode {
    public void deleteMidNode(Node node){
        if(node == null || node.next == null){
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }
}

