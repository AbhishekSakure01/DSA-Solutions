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

/*
Iterative Approach:
1. Use three pointers: prev, curr, next
2. Traverse the list and reverse links one by one
3. Move pointers forward
4. Return prev as new head

public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;

    while (curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}
*/
