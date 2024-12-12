/*
 * Heap : Complete binary tree(all levels are filled except last level(levels are filled from left to right))
 * Types of heap:
 * 1. max heap : parent should have maximum value than it's children (root has maximum value)
 * 2. min heap : parent should hava minimum value than it's children (root has minimum value)
 * 1 based indexing 
 * root is present at index 1 (heap[1])
 * left child index of heap[i] -> heap[2 * i]
 * right child index of heap[i] -> heap[2*i + 1]
 * parent index of heap[i] -> heap[i / 2]
 *** leaf nodes -> heap[(n/2) + 1] to heap[n], where n is no. of nodes
 *** Insertion and deletion always at bottom level (T.C. -> O(log n))
 *** Heapify T.C = O(logn) and bulid heap T.C. = O(n)  --> total T.C = O(nlogn)
 */

class MaxHeap {
    int maxSize;
    int[] maxHeap;
    int size;

    MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        maxHeap = new int[maxSize];
        size = 0;
    }

    public int parent(int curr) {
        return (curr / 2);
    }

    public int leftChild(int curr) {
        return (2 * curr);
    }

    public int rightChild(int curr) {
        return (2 * curr + 1);
    }

    public void swap(int ind1, int ind2) {
        int temp = maxHeap[ind1];
        maxHeap[ind1] = maxHeap[ind2];
        maxHeap[ind2] = temp;
    }

    public void insertIntoMax(int element) {
        size++; // 1 based indexing (no element at 0 index)
        int index = size;
        maxHeap[index] = element;

        while (index > 1) {
            if (maxHeap[parent(index)] < maxHeap[index]) {
                swap(parent(index), index);
                index = parent(index);
            } else {
                return;
            }
        }
    }

    public void deleteFromMax() {
        if (size == 0) {
            System.out.println("The heap is empty.");
            return;
        }

        // step1 : exchange the root and last node
        maxHeap[1] = maxHeap[size];

        // step2 : delete the last node(by decrementing the size)
        size--;

        // step3 : propaget the root to it's correct position
        int index = 1;
        while (index < size) {
            if (leftChild(index) < size && (maxHeap[index] < maxHeap[leftChild(index)])) {
                swap(index, leftChild(index));
                index = leftChild(index);
            }

            else if (rightChild(index) < size && (maxHeap[index] < maxHeap[rightChild(index)])) {
                swap(index, rightChild(index));
                index = rightChild(index);
            }

            else {
                System.out.println("The root get deleted.");
                return;
            }
        }
    }

    public void heapify(int[] arr, int size, int index) {
        int largest = index; // assume
        int left = leftChild(index);
        int right = rightChild(index);

        if (left <= size && arr[largest] < arr[left])
            largest = left;

        if (right <= size && arr[largest] < arr[right])
            largest = right;

        if (largest != index) { // assume largest index is wrong swap it
            int temp = arr[largest];
            arr[largest] = arr[index];
            arr[index] = temp;
            heapify(arr, size, largest);
        }
    }

    public void heapSort(int[] arr, int n) {
        int size = n;

        while (size > 1) {
            // Step 1 : swap root and last node
            int temp = arr[1];
            arr[1] = arr[size];
            arr[size] = temp;

            // step 2 : 1st largest element is at it's current position
            size--;

            // Step 3 : put new root to it's correct position
            heapify(arr, size, 1);
        }
    }

    public void print() {
        for (int i = 1; i < size; i++) {
            System.out.print(maxHeap[i] + " ");
        }
    }

    public int getMax() {
        return maxHeap[1];
    }
}

public class HeapBasics {
    public static void main(String[] args) {
        MaxHeap heap1 = new MaxHeap(11);

        heap1.insertIntoMax(30);
        heap1.insertIntoMax(25);
        heap1.insertIntoMax(45);
        heap1.insertIntoMax(67);
        heap1.insertIntoMax(13);
        heap1.insertIntoMax(98);
        heap1.insertIntoMax(43);
        heap1.insertIntoMax(87);
        heap1.insertIntoMax(54);
        heap1.insertIntoMax(78);

        System.out.print("The heap is : ");
        heap1.print();
        System.out.println();
        System.out.println("The maximum element is : " + heap1.getMax());

        heap1.deleteFromMax();
        heap1.print();
        System.out.println();

        System.out.println("--------------------------------------------");
        System.out.println("\tBuilding heap from given array\t");
        int arr[] = { -1, 43, 23, 53, 66, 78 };
        int n = 5;
        System.out.println("Array before heapify : ");
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
        // build heap from given array
        for (int i = (n / 2); i > 0; i--) { // from (n/2) + 1 to n all are leaf node which already satisfies heap
            // property
            heap1.heapify(arr, n, i);
        }

        System.out.println();
        System.out.println("Array after heapify : ");
        // arr after heapify
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("--------------------------------------------");
        System.out.println("\tHeap Sort\t");
        heap1.heapSort(arr, n);
        System.out.println();
        System.out.println("Array after sorting : ");
        // arr after heapify
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
