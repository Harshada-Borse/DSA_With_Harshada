class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

public class ReverseInKGroups {
    static Node kReverse(Node head, int k) {
        // base case
        if (head == null)
            return null;

        // step 1: reverse the first k nodes using normal reverse logic
        Node curr = head;
        Node pre = null;
        Node forward = null;
        // to reverse until k no. of nodes
        int count = 0;

        while (curr != null && count < k) {
            forward = curr.next;
            curr.next = pre;
            pre = curr;
            curr = forward;

            count++;
        }

        // step 2: now reverse the remaining list using recursion and connect that
        // reverse list to the head.next
        if (forward != null)
            head.next = kReverse(forward, k);

        // return the pre pointer
        return pre;
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
        // Sample Input 1
        int[] arr = { 5, 4, 3, 7, 9, 2 };
        int k = 4;

        // Creating a linked list
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }

        // Calling the kReverse function
        head = kReverse(head, k);

        // Printing the result
        printList(head);
    }
}
