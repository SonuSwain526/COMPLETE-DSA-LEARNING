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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode t = list1;
        ListNode x = new ListNode(-1);
        ListNode t1 = x;
        ListNode y = new ListNode();
        int i = 0;
        while(t != null){
            if(i >= b+1){
                ListNode node = new ListNode(t.val);
                t1.next = node;
                t1 = node;
            }
            i++;
            t = t.next;
        }

        

        t = list1;
        i = 0;
        while(t != null){
            if(i == a - 1){
                t.next = list2;
                break;
            }
            t = t.next;
            i++;
        }  


        t = list1;

        while(t.next != null){
            t = t.next;
        }
        t.next = x.next;

        return list1;

        
    }
}