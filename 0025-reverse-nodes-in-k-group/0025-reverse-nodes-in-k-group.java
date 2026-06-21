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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode t = head;
        int size = 0;

        while(t != null){
            size++;
            t = t.next;
        }

        int noOfG = size / k;
        int j = 1;

        ListNode ll = new ListNode(-1);
        ListNode t1 = ll;
        t = head;

        while (j <= noOfG){
            for(int i = 0; i < k; i++){
                ListNode node = new ListNode(t.val);
                ListNode x = t1.next;
                t1.next = node;
                node.next = x;
                t = t.next;
            }
            ListNode node = ll;
            while(node.next != null){
                node = node.next;
            }
            t1 = node;
            j++;
        }

        t1.next = t;

        // if(size % k != 0){
            
        // }

        return ll.next;
    }
}