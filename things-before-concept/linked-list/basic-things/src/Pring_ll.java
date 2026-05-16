public class Pring_ll {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node a = new Node(20);
        Node b = new Node(30);
        Node c = new Node(40);

        head.next = a;
        a.next = b;
        b.next = c;

        Node temp = head;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}
