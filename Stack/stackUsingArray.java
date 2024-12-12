import java.util.*;

class StackArray {
    int arr[];
    int size;
    int top;

    StackArray(int size) {
        this.size = size;
        this.arr = new int[size];
        this.top = -1;
    }

    boolean IsEmpty() {
        return (top == -1);
    }

    boolean IsFull() {
        return (top == size - 1);
    }

    void push(int element) {
        if (IsFull())
            System.out.println("Sorry! stack is full. Element cannot be inserted");
        else {
            top++;
            arr[top] = element;
            System.out.println("The element " + element + " get inserted on the stack");
        }
    }

    void pop() {
        if (IsEmpty())
            System.out.println("Stack is empty, so no element available for deletion");
        else {
            int element = arr[top];
            top--;
            System.out.println("The element " + element + " get deleted.");
        }

    }

    int GetTop() {
        return arr[top];
    }

    void DisplayStack() {
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}

class stackUsingArray {
    public static void main(String[] args) {
        System.out.println("\tImplementing Stack Using Array\t");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of Stack : ");
        int size = sc.nextInt();
        StackArray stack1 = new StackArray(size);
        while (true) {
            System.out.println("************* Operations Available ****************");
            System.out.println(
                    "1. Push the element on stack\n2. Pop the element from the stack\n3. Get the top element of the stack\n4. Display the stack\n5. Exit");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the element you want to push : ");
                    int element = sc.nextInt();
                    stack1.push(element);
                    System.out.println();
                    break;
                case 2:
                    stack1.pop();
                    System.out.println();
                    break;
                case 3:
                    System.out.print("the topmost element is : " + stack1.GetTop());
                    System.out.println();
                    break;
                case 4:
                    System.out.println("The Stack is : ");
                    stack1.DisplayStack();
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Thank You !!");
                    System.exit(0);
                default:
                    System.out.println("Sorry! Invalid choice please enter the choice again.");
            }
        }
    }
}
