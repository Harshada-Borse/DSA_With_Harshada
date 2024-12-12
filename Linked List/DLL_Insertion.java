class DLL_Insertion {
    class Node {
        int data;
        Node next;
        Node pre;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.pre = null;
        }
    }

    Node head;

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head.pre = newNode;
        head = newNode;
    }

    public void insertAtLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.pre = temp;
    }

    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        Node temp = head;
        int count = 1;
        while (count < position - 1) {
            temp = temp.next;
            count++;
        }
        newNode.next = temp.next;
        temp.next.pre = newNode;
        temp.next = newNode;
        newNode.pre = temp;
    }

    public void printLL() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DLL_Insertion list1 = new DLL_Insertion();
        list1.insertAtHead(10);
        list1.printLL();

        list1.insertAtHead(20);
        list1.printLL();

        list1.insertAtPosition(30, 2);
        list1.printLL();

        list1.insertAtLast(40);
        list1.printLL();

        list1.insertAtPosition(50, 3);
        list1.printLL();
    }

}