// Floyd's cycle detection algorithm : (Hare - Tortoise algorithm) -> It is a pointer algorithm that uses only two pointers, moving through the sequence at different speeds. This algorithm is used to find a loop in a linked list. It uses two pointers one moving twice as fast as the other one. The faster one is called the fast pointer and the other one is called the slow pointer.

// Working 
// 1. The Fast pointer may reach the end (NULL) this shows that there is no loop in the linked list.
// 2. The Fast pointer again catches the slow pointer at some time therefore a loop exists in the linked list.

// use to detect the loop in ll also to find the middle of ll

public class FloydCycle {
    static class Node {
        int data;
        Node next;

        Node(int val) {
            data = val;
            next = null;
        }
    }

    public static boolean detectLoop(Node head) {
        Node Hare = head;
        Node Tortoise = head;

        while (Tortoise != null && Hare != null && Hare.next != null) {
            Tortoise = Tortoise.next;
            Hare = Hare.next.next;

            // loop detected
            if (Hare == Tortoise)
                return true;
        }
        // if loop not found
        return false;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 4, 5, 6 };
        Node head = new Node(arr[0]);
        Node temp = head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }

        System.out.println("The Linked List is : ");
        printList(head);

        if (detectLoop(head))
            System.out.println("Loop founded.");
        else
            System.out.println("Loop not found");
    }
}