// Approach:
// 1. Use a dummy node pointing to head
// 2. Move fast pointer n+1 steps ahead
// 3. Move both slow and fast until fast reaches null
// 4. Slow will be before the node to delete
// 5. Remove the node and return dummy.next

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
