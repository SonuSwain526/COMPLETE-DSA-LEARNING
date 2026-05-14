public class dt_may_14 {
    public static void main(String[] args) {

    }
      public class ListNode {
          int val;
         ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA;
        ListNode t2 = headB;

        ListNode n = new ListNode(-1);
        while (t1 != null){
            ListNode x = n.next;
            ListNode newn = new ListNode(t1.val);
            n.next = newn;
            newn.next = x;
            t1 = t1.next;
        }

        ListNode n1 = new ListNode(-1);
        while (t2 != null){
            ListNode x = n1.next;
            ListNode newn = new ListNode(t2.val);
            n1.next = newn;
            newn.next = x;
            t2 = t2.next;
        }

        t1 = n.next;
        t2 = n1.next;
        while (t1 != null && t2 != null){
            if(t1.next.val != t2.next.val){
                return t1;
            }
        }

//        while()
        return t1;
    }
}
