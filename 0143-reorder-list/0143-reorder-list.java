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
    public void reorderList(ListNode head) {
        ListNode temp = head;
        int size = 0;

        while(temp != null){
            size++;
            temp = temp.next;
        }
        if(size == 1) return;
        temp = head;
        ListNode ll1 = new ListNode(-1);
        ListNode t1 = ll1;
        ListNode ll2 = new ListNode(-1);
        ListNode t2 = ll2;
        int i=1;
        while(temp != null){
            if(i <= size/2){
                ListNode node = new ListNode(temp.val);
                t1.next = node;
                t1 = node;
            }else{
                ListNode node = new ListNode(temp.val);
                ListNode x = t2.next;
                t2.next = node;
                node.next = x;
            }
            temp = temp.next;
            i++;
        }

        ListNode t = head;
        t1 = ll1.next;
        t2 = ll2.next;
        i = 1;
        while(t2 != null){
            if(i%2 != 0){
                if(t1 != null){
                    t.val = t1.val;
                    t = t.next;
                    // ListNode node = new ListNode(t1.val);
                    // t.next = node;
                    // t = node;
                    t1 = t1.next;
                }else{
                    t.val = t2.val;
                    t = t.next;
                    // ListNode node = new ListNode(t2.val);
                    // t.next = node;
                    // t = node;
                    t2 = t2.next;
                }
                
            }else{
                    t.val = t2.val;
                    t = t.next;
                    // ListNode node = new ListNode(t2.val);
                    // t.next = node;
                    // t = node;
                    t2 = t2.next;
            }
            i++;
        }

    }
}