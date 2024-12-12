import java.util.*;
// Implementing stack using linked list
// isFull condition not exits <- since linked list has variable size
// push operation <- same as insertion at head
// pop operation <- same as deleting from head
// peek <- getting topmost element of stack
// display <- same as that of displaying the ll

class stackImplementation {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node top = null;

    //
    boolean isEmpty() {
        return (top == null);
    }

    void push(int element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            top = newNode;
            return;
        }

        newNode.next = top;
        top = newNode;

        System.out.println(element + " get successfully push on to the stack.");
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty cannot delete the element.");
            return;
        }

        int delete = top.data;
        top = top.next;
        System.out.println(delete + " get successfully deleted.");
    }

    int peek() {
        return top.data;
    }

    void displayStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("The stack is : ");
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}

public class stackUsingLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        stackImplementation s1 = new stackImplementation();

        while (true) {
            System.out.println("\tOperations Available :\n1.Push\n2.Pop\n3.Display\n4.Get top element\n5.Exit");
            System.out.print("Enter Your Choice : ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter the data : ");
                    int a = sc.nextInt();
                    s1.push(a);
                    System.out.println("------------------------------------");
                    break;
                case 2:
                    s1.pop();
                    System.out.println("------------------------------------");
                    break;
                case 3:
                    s1.displayStack();
                    System.out.println("------------------------------------");
                    break;
                case 4:
                    s1.peek();
                    System.out.println("------------------------------------");
                    break;
                case 5:
                    System.out.println("Thank You !!");
                    System.exit(0);
                default:
                    System.out.print("Invalid input");
            }
        }
    }
}
