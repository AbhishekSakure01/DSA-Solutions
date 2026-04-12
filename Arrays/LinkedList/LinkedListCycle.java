// Approach:
// 1. Use two pointers (slow and fast)
// 2. Slow moves one step, fast moves two steps
// 3. If there is a cycle, they will meet
// 4. If fast reaches null, no cycle exists

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }
}
