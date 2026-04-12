// Approach:
// 1. Use two pointers (slow and fast)
// 2. Slow moves one step, fast moves two steps
// 3. When fast reaches end, slow will be at middle
// 4. Return slow pointer

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
