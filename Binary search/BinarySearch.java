public class BinarySearch {
    public static boolean binarySearch(int arr[], int key, int size) {
        int start = 0;
        int end = size - 1;
        int mid = start + (end - start) / 2;

        while (start <= end) {
            if (arr[mid] == key)
                return true;
            if (arr[mid] > key)
                start = mid - 1;
            else
                start = mid + 1;

            mid = start + (end - start) / 2;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 6, 8, 9, 12, 15, 19, 21, 25 };
        boolean result = binarySearch(arr, 100, 10);
        if (result)
            System.out.println("Element Found");
        else
            System.out.println("Element not found");
    }
}
