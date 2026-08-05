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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < lists.length; i++){
            ListNode cur = lists[i];

            while (cur != null){
                pq.add(cur.val);
                cur = cur.next;
            }
        }

        if (pq.isEmpty()) return null;

        ListNode ans = new ListNode(pq.poll());
        ListNode itrtr = ans;

        while (!pq.isEmpty()){
            ListNode cur = new ListNode(pq.poll());

            itrtr.next = cur;
            itrtr = itrtr.next;
        }

        return ans;


    }
}