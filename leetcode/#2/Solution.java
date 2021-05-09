// Add Two Numbers
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode curR = result;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        
        int sum = 0;
        int overflow = 0;
        do {
            sum = cur1.val + cur2.val;
            
            curR.next = new ListNode((sum + overflow) % 10);
            overflow = (sum + overflow) / 10;
                
            cur1 = cur1.next;
            cur2 = cur2.next;
            curR = curR.next;
        } while(cur1 != null && cur2 != null);
        
        if(cur2 != null) {
            cur1 = cur2;
        }
        
        while(cur1 != null) {
            curR.next = new ListNode((cur1.val + overflow) % 10);
            overflow = (cur1.val + overflow) / 10;
            curR = curR.next;
            
            cur1 = cur1.next;
        }
        if(overflow == 1) {
            curR.next = new ListNode(overflow);
        }
            
        return result.next;
    }
}
/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
*/
