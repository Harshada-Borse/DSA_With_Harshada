class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class reverseSLL {

    public Node InsertAtBegin(Node Head, int data) {
        Node new_node = new Node(data);
        new_node.next = Head;
        Head = new_node;
        return Head;
    }

    public Node InsertAtEnd(Node Tail, int data) {
        Node new_node = new Node(data);
        if (Tail == null) {
            Tail = new_node;
            return Tail;
        }
        Tail.next = new_node;
        Tail = Tail.next;
        return Tail;
    }

    public Node InsertAtPosition(Node Head, int position, int data) {
        Node temp = Head;
        int count = 1;
        while (count < position - 1) {
            temp = temp.next;
            count++;
        }

        Node new_node = new Node(data);
        new_node.next = temp.next;
        temp.next = new_node;
        return Head;
    }

    public void Insert(Node Head, Node Tail, int position, int data) {
        if (position == 1) {
            InsertAtBegin(Head, data);
            return;
        }

        Node temp = Head;
        int count = 1;
        while (count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp.next == null) {
            InsertAtEnd(Tail, data);
            return;
        }

        Node new_node = new Node(data);
        new_node.next = temp.next;
        temp.next = new_node;
    }

    public Node Reverse1(Node Head) {
        if (Head == null || Head.next == null)
            return Head;
        Node pre = null;
        Node current = Head;
        Node forward = null;
        while (current != null) {
            forward = current.next;
            current.next = pre;
            pre = current;
            current = forward;
        }
        return pre;
    }

    void print_node(Node Head) {
        Node temp = Head;
        System.out.println("The linked list is : ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        reverseSLL SLL1 = new reverseSLL();

        Node node1 = new Node(10);

        Node Head = node1;
        Node Tail = node1;

        SLL1.print_node(Head);

        SLL1.Insert(Head, Tail, 2, 20);
        SLL1.print_node(Head);

        SLL1.Insert(Head, Tail, 2, 30);
        SLL1.print_node(Head);

        SLL1.Insert(Head, Tail, 1, 50);
        SLL1.print_node(Head);

        SLL1.Insert(Head, Tail, 6, 60);
        SLL1.print_node(Head);
    }
}