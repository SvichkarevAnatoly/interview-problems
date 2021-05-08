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
