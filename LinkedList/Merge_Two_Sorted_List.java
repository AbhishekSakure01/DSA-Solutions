/*
    LeetCode 21 - Merge Two Sorted Lists

    Approach:
    Use two pointers to compare the current nodes of both sorted lists.

    1. Create a dummy node.
    2. Use curr to build the merged list.
    3. Compare list1.val and list2.val.
    4. Attach the smaller node.
    5. Move that list pointer forward.
    6. Move curr forward.
    7. When one list becomes null, attach the remaining list.
    8. Return dummy.next.

    Time Complexity: O(n + m)
    Space Complexity: O(1) excluding the output list.
*/

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next;
        }

        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }

        return dummy.next;
    }
}
