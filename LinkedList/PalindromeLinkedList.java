// Approach:
// 1. Use recursion to reach the end of the list
// 2. Maintain a pointer (curr) from the start
// 3. While backtracking, compare current node with curr
// 4. Move curr forward after each comparison
// 5. If all values match, it's a palindrome

class Solution {

    ListNode curr;

    boolean recur(ListNode head) {
        if (head == null) {
            return true;
        }

        boolean ans = recur(head.next);
        if (!ans) return false;

        if (curr.val != head.val) {
            return false;
        }

        curr = curr.next;
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        curr = head;
        return recur(head);
    }
}
