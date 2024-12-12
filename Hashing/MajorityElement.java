import java.util.*;

/*
 * Majority element : the element whose occurence is more than (size of array / 3) or in some questions it is more than (size/3)
 */
public class MajorityElement {
    public List<Integer> majorityElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();

        // create the hashmap to store the element and it's occurance
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) { // true when already present then updated it's apperrance by 1
                map.put(arr[i], map.get(arr[i]) + 1);
            } else // not present then appreance = 1
                map.put(arr[i], 1);
        }

        // now if apprence is more than n / 3 then return
        for (int key : map.keySet()) {
            if (map.get(key) > (n / 3))
                ans.add(key);
        }

        if (ans.isEmpty())
            ans.add(-1);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MajorityElement m = new MajorityElement();
        System.out.print("Enter the size of array : ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter the array elements : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        List<Integer> ans = m.majorityElement(arr);
        System.out.println("The majority elements are : " + ans);
    }
}
