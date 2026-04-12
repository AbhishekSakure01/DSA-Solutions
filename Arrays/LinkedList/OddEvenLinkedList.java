// Approach:
// 1. Separate nodes into odd and even indexed lists
// 2. Maintain two pointers: odd and even
// 3. Link odd nodes together and even nodes together
// 4. Connect end of odd list to start of even list
// 5. Return head

class Solution {
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenStart = head.next;

        while (even != null && even.next != null) {
            odd.next = even.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenStart;

        return head;
    }
}
