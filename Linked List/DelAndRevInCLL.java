class DelAndRevInCLL {
    // Node class representing each element of the circular linked list
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null; // Reference to the head node of the circular linked list

    // Function to insert nodes into the circular linked list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head; // Making it circular by pointing it to itself
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head; // Maintain circular property
        }
    }

    // Function to display the circular linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Function to reverse a circular linked list
    public Node reverse() {
        if (head == null || head.next == head) {
            return head; // if list is empty or contains only 1 node
        }

        Node prev = null;
        Node curr = head;
        Node next = null;
        Node tail = head; // Save the original head (as tail after reversal)

        // Traverse until we reach the head again
        do {
            next = curr.next; // Store next node
            curr.next = prev; // Reverse pointer
            prev = curr; // Move prev to current
            curr = next; // Move current to next
        } while (curr != head);

        // After loop, 'prev' is now the new head
        // Restore the circular nature
        tail.next = prev; // Make the original head (now the last node) point to the new head
        head = prev; // Update the head to the new head (prev)

        return head;
    }

    // Function to delete a node from the circular linked list
    public Node deleteNode(int key) {
        // If the list is empty
        if (head == null) {
            return null;
        }

        // If the key to delete is the head node
        if (head.data == key) {
            // Case 1: If the list has only one node
            if (head.next == head) {
                head = null; // Make the list empty
                return null;
            }

            // Case 2: More than one node in the circular linked list
            Node tail = head; // Find the last node
            while (tail.next != head) {
                tail = tail.next;
            }

            head = head.next; // Move head to the next node
            tail.next = head; // Update the tail's next pointer

            return head;
        }

        // If the key is present somewhere other than the head
        Node temp = head;
        while (temp.next != head) {
            if (temp.next.data == key) {
                temp.next = temp.next.next; // Remove the node by skipping it
                break;
            }
            temp = temp.next;
        }

        return head;
    }

    // Main function to test the circular linked list
    public static void main(String[] args) {
        DelAndRevInCLL cll = new DelAndRevInCLL();

        // Insert elements into the circular linked list
        cll.insertAtEnd(10);
        cll.insertAtEnd(20);
        cll.insertAtEnd(30);
        cll.insertAtEnd(40);
        cll.insertAtEnd(50);

        System.out.println("Original Circular Linked List:");
        cll.display(); // Display original list

        // Delete a node (e.g., 30)
        cll.deleteNode(30);
        System.out.println("List after deleting node with value 30:");
        cll.display(); // Display list after deletion

        // Reverse the circular linked list
        cll.reverse();
        System.out.println("Reversed Circular Linked List:");
        cll.display(); // Display reversed list
    }
}
