import java.util.*;
/*
 * Queue : FIFO (First In First Out)
 * Having 2 fields front and rear 
 * Insertion <- from the rear
 * Deletion <- from the front
 * Implementation := Array
 * Time Complexity:
    enqueue(),dequeue(),front() can be perfromed in constant time. So time Complexity of enqueue, dequeue() , front() are O(1) but display will print all the elements of queue. So its time complexity is O(N). Overall worst case time complexity of implementation of queue using array is O(N).
 */

class QueueUsingArray {

    int size;
    int rear, front;
    int[] queue;

    QueueUsingArray(int size) {
        this.size = size;
        this.rear = -1;
        this.front = -1;
        this.queue = new int[size];
    }

    boolean isEmpty() {
        return ((front == -1) || (front == rear));
    }

    boolean isFull() {
        return (rear >= size - 1);
    }

    void insert(int element) {
        if (isFull())
            System.out.println("Queue is full It will get Overflow!");
        else {
            if (front == -1)
                front++;
            rear++;
            queue[rear] = element;
            System.out.println("The element " + element + " get inserted");
        }
    }

    void delete() {
        if (isEmpty())
            System.out.println("Queue is empty.");
        else {
            int element = queue[front];
            front++;
            if (front == rear) {
                front = rear = 0;
            }
            System.out.println("The firstly inserted element get deleted");
            System.out.println("The deleted element is : " + element);
        }
    }

    void display() {
        for (int i = front; i <= rear; i++) {
            System.out.println(queue[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of queue : ");
        int size = sc.nextInt();
        System.out.println();
        QueueUsingArray Q1 = new QueueUsingArray(size);
        // Insertion
        Q1.insert(10);
        Q1.insert(20);
        Q1.insert(30);
        System.out.println();
        System.out.println("The queue is : ");
        Q1.display();
        System.out.println();
        // Deletion
        Q1.delete();
        System.out.println("The queue after deletion is : ");
        Q1.display();
        Q1.insert(40);
        Q1.display();
        System.out.println();
        System.out.println("---------------------------");
        System.out.println("Thank you !!");
        System.out.println("---------------------------");
    }
}
