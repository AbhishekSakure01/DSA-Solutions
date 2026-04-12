// Approach:
// 1. Use slow and fast pointers to find middle node
// 2. Maintain a prev pointer for node before slow
// 3. When slow reaches middle, prev points to previous node
// 4. Delete middle node by updating prev.next
// 5. Return head

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode prevSlow = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prevSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prevSlow.next = slow.next;

        return head;
    }
}
