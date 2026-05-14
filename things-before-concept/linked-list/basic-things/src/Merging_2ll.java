public class Merging_2ll {
     public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        int size1=0, size2=0;
        while(temp1 != null){
            temp1 = temp1.next;
            size1++;
        }
        while(temp2 != null){
            temp2 = temp2.next;
            size2++;
        }
        temp1 = list1;
        temp2 = list2;
        while(temp1 != null && temp2 != null){
            if(temp1.val >= temp2.val){
                if(size1 >= size2){
                    ListNode t = temp2.next;
                    temp2.next = temp1;
                    temp1 = temp1.next;
                    temp2 = t;

                }else{
                    ListNode t = temp1.next;
                    temp1.next = temp2.next.next;
                    temp2.next = list1;
                    temp2 = temp1.next;
                    temp1 = t;
                }
            }else{
                if(size1 < size2){
                    ListNode t = temp1.next;
                    temp1.next = temp2;
                    temp2 = temp2.next;
                    temp1 = t;

                }else{
                    ListNode t = temp2.next;
                    temp2.next = temp1.next.next;
                    temp1.next = temp2;
                    temp1 = temp2.next;
                    temp2 = t;
                }
            }
        }
        if(size1 >= size2) return list1;
        return list2;
    }
}
