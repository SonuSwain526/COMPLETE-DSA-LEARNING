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
    public ListNode deleteMiddle(ListNode head) {
        ListNode t = head;
        int size = 0;

        while (t != null){
            size++;
            t = t.next;
        }

        int m = (size / 2) + 1;

        if(m == 1) return head.next;
        if(m == 0) return head;

        ListNode past = null;
        ListNode cur = head;
        ListNode fut = head.next;

        int i = 1;

        while(cur != null){
            if(i == m){
                // if(fut = null){
                //     past.next = 
                // }
                past.next = fut;
            }

            past = cur;
            cur = cur.next;
            if(fut != null)
                fut = fut.next;
            i++;
        }

        return head;
    }
}