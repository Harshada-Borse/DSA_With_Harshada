public class CircularOrNot {
    static class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    public static boolean circularOrNot(Node head) {
        // list is empty
        if (head == null)
            return true;

        Node temp = head.next;
        while (temp != null && temp != head)
            temp = temp.next;

        // not circular
        if (temp == null)
            return false;

        // circular
        // if (temp == head)
        //     return true;
        return true;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage
        int[] arr = { 5, 4, 3, 7, 9, 2, 5 };

        // Creating a linked list
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }

        System.out.println("Linked List is : ");
        printList(head);

        if (circularOrNot(head))
            System.out.println("Given linked list is circular. ");
        else
            System.out.println("Given linked list is not circular. ");
    }
}