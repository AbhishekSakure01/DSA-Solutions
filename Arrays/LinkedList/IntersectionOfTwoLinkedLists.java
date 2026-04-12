// Approach:
// 1. Use two pointers for both lists
// 2. Traverse both lists; when one reaches null, switch to other list
// 3. This aligns both pointers for equal distance
// 4. They will meet at intersection or null
// 5. Return the meeting node

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }
        return a;
    }
}
