public class LinkedListReverse {
    static class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    public static Node kReverse(Node head, int k) {
        // using recursion
        // base case
        if (head == null)
            return null;

        // first count the nodes up to k
        int count = 0;
        Node temp = head;
        while (count < k && temp != null) {
            temp = temp.next;
            count++;
        }

        // if the count and the number of nodes to reverse is the same, then reverse the
        // nodes
        if (count == k) {
            temp = kReverse(temp, k);

            // reverse the first k nodes
            Node current = head;
            Node pre = null;
            Node forward = null;

            while (count > 0) {
                forward = current.next;
                current.next = pre;
                pre = current;
                current = forward;
                count--;
            }

            // connect the reversed portion with the remaining nodes
            head.next = temp;
            head = pre;
        }

        return head;
    }

    // utility function to print a linked list
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // driver code
    public static void main(String[] args) {
        // Example usage
        int[] arr = { 5, 4, 3, 7, 9, 2 };
        int k = 4;

        // Creating a linked list
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }

        System.out.println("Original Linked List:");
        printList(head);

        head = kReverse(head, k);

        System.out.println("Linked List after reversing every " + k + " nodes:");
        printList(head);
    }
}