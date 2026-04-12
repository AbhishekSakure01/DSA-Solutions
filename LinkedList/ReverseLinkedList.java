// Approach:
// 1. Use recursion to reverse the list
// 2. Recursively go till last node
// 3. While returning, reverse the links
// 4. Set head.next.next = head and head.next = null
// 5. Return new head (last node)

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode last = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return last;
    }
}
