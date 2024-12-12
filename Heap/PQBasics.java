/*
 * The PriorityQueue class provides the functionality of the heap data structure. 
 * Unlike normal queues, priority queue elements are retrieved in sorted order.
 * 
 * Suppose, we want to retrieve elements in the ascending order. In this case, the head of the priority queue will be the smallest element. Once  * this element is retrieved, the next smallest element will be the head of the queue.
 * 
 * NOTE: The elements of a priority queue may not be sorted. However, elements are always retrieved in sorted order.
 * 
 * PriorityQueue Methods:
 * add() method 
 * offer() method   // same as that of add
 * peek() method  // returns topmost element of queue 
 * remove() method  // remove the element from queue
 * poll() method  // return the topmost element of the queue and delete it from the queue
 * 
 * Using Iterator for PriorityQueue objects.
 * while adding the element's to pq it will get added as min heap
 * to implement max heap we used Comparator.reverseOrder() *See the implementation
 */

import java.util.*;

public class PQBasics {
    public static void main(String[] args) {
        System.out.println("\t***** Min Heap *****\t");
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(10);
        pq.add(21);
        pq.add(54);
        pq.add(65);
        pq.add(2);
        pq.add(43);
        pq.add(6);
        pq.offer(87);
        pq.add(98);
        pq.add(1);
        // by default it will implementing the min heap
        System.out.println(pq);

        // Printing the top element of PriorityQueue
        System.out.println("The size of priority queue is : " + pq.size());
        System.out.println("The topmost(Smallest) element is : " + pq.peek());

        System.out.println(pq.poll() + " which is the top and it get remove.");
        System.out.println(pq);

        pq.remove(87);
        System.out.println(pq);

        System.out.println("Check whether the queue is empty or not : " + pq.isEmpty());

        System.out.println("Check whethere 21 is present or not : " + pq.contains(21));

        // Iterating the pq

        Iterator<Integer> iterator = pq.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println("-----------------");

        // using polling -> get sorted pq
        Iterator<Integer> iterator2 = pq.iterator();
        System.out.print("Sorted queue is : ");
        while (iterator2.hasNext()) {
            System.out.print(pq.poll() + " ");
        }
        System.out.println();
        System.out.println("-----------------");

        System.out.println();
        System.out.println();
        System.out.println("\t***** Max Heap *****\t");

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        maxHeap.add(10);
        maxHeap.add(21);
        maxHeap.add(54);
        maxHeap.add(65);
        maxHeap.add(2);
        maxHeap.add(43);
        maxHeap.add(6);
        maxHeap.offer(87);
        maxHeap.add(98);
        maxHeap.add(1);
        // by default it will implementing the min heap
        System.out.println(maxHeap);

        // Printing the top element of PriorityQueue
        System.out.println("The size of priority queue is : " + maxHeap.size());
        System.out.println("The topmost(Smallest) element is : " + maxHeap.peek());

        System.out.println(maxHeap.poll() + " which is the top and it get remove.");
        System.out.println(maxHeap);

        maxHeap.remove(87);
        System.out.println(maxHeap);

        System.out.println("Check whether the queue is empty or not : " + maxHeap.isEmpty());

        System.out.println("Check whethere 21 is present or not : " + maxHeap.contains(21));

        // Iterating the maxHeap

        Iterator<Integer> iterator3 = maxHeap.iterator();
        while (iterator3.hasNext()) {
            System.out.print(iterator3.next() + " ");
        }
        System.out.println();
        System.out.println("-----------------");

        // using polling -> get sorted maxHeap
        Iterator<Integer> iterator4 = maxHeap.iterator();
        System.out.print("Reverse Sorted queue is(Desending order): ");
        while (iterator4.hasNext()) {
            System.out.print(maxHeap.poll() + " ");
        }
        System.out.println();
        System.out.println("-----------------");

        // another way multiply the numbers by -1
        // Creating a max heap using PriorityQueue
        PriorityQueue<Integer> maxHeap2 = new PriorityQueue<>();

        // Inserting elements into the max heap
        maxHeap2.offer(-30);
        maxHeap2.offer(-25);
        maxHeap2.offer(-45);
        maxHeap2.offer(-67);
        maxHeap2.offer(-13);
        maxHeap2.offer(-98);
        maxHeap2.offer(-43);
        maxHeap2.offer(-87);
        maxHeap2.offer(-54);
        maxHeap2.offer(-78);

        // Printing the max heap
        System.out.print("The max heap is: ");
        for (Integer num : maxHeap2) {
            System.out.print(-num + " ");
        }
        System.out.println();

        // Getting and removing the maximum element
        System.out.println("The maximum element is: " + (-maxHeap2.poll()));

        // Printing the max heap after removal
        System.out.print("After removal, the max heap is: ");
        for (Integer num : maxHeap2) {
            System.out.print(-num + " ");
        }
        System.out.println();
    }
}
