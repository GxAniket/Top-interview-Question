// Given the head of a linked list, rotate the list to the right by k places.Example 1:

// Input: head = [1,2,3,4,5], k = 2
// Output: [4,5,1,2,3]
  
// Example 2:

// Input: head = [0,1,2], k = 4
// Output: [2,0,1]


 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;

        int length = 1;
        ListNode dummy = head;

        while (dummy.next != null) {
            dummy = dummy.next;
            length++;
        }

        int position = k % length;
        if (position == 0) return head;

        ListNode current = head;
        for (int i = 0; i < length - position - 1; i++) {
            current = current.next;
        }

        ListNode newHead = current.next;
        current.next = null;
        dummy.next = head;

        return newHead;        
    }
}
