// Approach:
// 1. Use slow and fast pointers to detect cycle
// 2. If they meet, cycle exists
// 3. Initialize another pointer at head
// 4. Move both pointers one step at a time
// 5. The meeting point is the start of the cycle

public class Solution {
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (slow != fast) {
            return null;
        }

        ListNode p = head;

        while (p != slow) {
            p = p.next;
            slow = slow.next;
        }
        return p;
    }
}
