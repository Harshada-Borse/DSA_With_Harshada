import java.util.*;

public class unionAndintersectionOfArray {
    public static int unionOfArrays(int[] arr1, int[] arr2) {
        HashSet<Integer> ans = new HashSet<>();
        int n = arr1.length;
        int m = arr2.length;

        for (int i = 0; i < n; i++) {
            ans.add(arr1[i]);
        }
        for (int j = 0; j < m; j++) {
            ans.add(arr2[j]);
        }
        System.out.println("The union is : " + ans);
        return ans.size();
    }

    public static int intersectionOfArrays(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr1) {
            set.add(num);
        }

        HashSet<Integer> intersectionSet = new HashSet<>();
        for (int num : arr2) {
            if (set.contains(num)) {
                intersectionSet.add(num);
            }
        }
        System.out.println("The intersection is : " + intersectionSet);
        return intersectionSet.size();
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 6, 4, 8, 2 };
        int[] arr2 = { 8, 9, 10, 2, 1, 3 };

        System.out.print("Array 1 : ");
        for (int element : arr1) {
            System.out.print(element + " ");
        }

        System.out.println();

        System.out.print("Array 2 : ");
        for (int elements : arr2) {
            System.out.print(elements + " ");
        }

        System.out.println();

        System.out.println("Total no. of elements in union : " + unionOfArrays(arr1, arr2));
        System.out.println("Total no. of elements in intersection : " + intersectionOfArrays(arr1, arr2));
    }
}
