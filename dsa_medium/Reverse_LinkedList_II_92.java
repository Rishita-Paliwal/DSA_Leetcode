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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 1: Move `prev` to the node before the `left`th node
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // `start` is the first node to reverse, `then` is the node after it
        ListNode start = prev.next;
        ListNode then = start.next;

        // Step 2: Reverse the sublist using the head insertion method
        for (int i = 0; i < right - left; i++) {
            start.next = then.next;   // Remove `then`
            then.next = prev.next;    // Insert `then` right after `prev`
            prev.next = then;         // Connect `prev` to `then`
            then = start.next;        // Move `then` forward
        }

        // Return the new head
        return dummy.next;
    }
}
