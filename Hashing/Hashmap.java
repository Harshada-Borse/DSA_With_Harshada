import java.util.*;

/*
 * Hashmap : Store the pair of key and value
 ** value maybe same for different keys but key is always unique
 * Oredred doesnot matter
 * All operations link put(), get(), remove(), search()... are completed with O(1) T.C.
 */

public class Hashmap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // creating the pair of subjects and correspounding marks
        // creation of hashmap
        HashMap<String, Integer> map = new HashMap<>();

        /*
         * inserting pair to map -> .put(key, value)
         * 1. if same pair is already present then it will puts only once
         * 2. if key is exits and value is different then it will puts the updated value
         * 3. if key doesnot exits then it will insert the new pair
         */

        map.put("English", 70);
        map.put("Marathi", 90);
        map.put("Physics", 90);
        map.put("English", 70);
        map.put("Chemistry", 95);
        map.put("Math", 99);
        map.put("Biology", 75);

        System.out.println("The map is : " + map); // map name for print
        map.put("English", 80); // english subject marks get updated
        System.out.println("The map is : " + map);

        /*
         * search(look up) : .containsKey(keyName) -> returns true if present else false
         * same for value -> .containsValue(value) -> return true if present else false
         */
        System.out.print("Enter the subject theta you want to search : ");
        String subject = sc.nextLine();
        if (map.containsKey(subject))
            System.out.println(subject + " subject is present in the map." + "\nIt's marks is : " + map.get(subject));
        else
            System.out.println(subject + " not present in the map.");

        // if (map.containsKey("History"))
        // System.out.println("The history subject is present in the map.");
        // else
        // System.out.println("You don't enter the history marks.");

        System.out.print("Enter the marks that you want to search : ");
        int marks = sc.nextInt();
        if (map.containsValue(marks))
            System.out.print("Yes, you got " + marks + " for some subject.");
        else
            System.out.println("you don't get " + marks + " for any subject");

        /*
         * getting value correspounding to key -> .get(keyName)
         * 1. if key is present then it will return it's correspounding value
         * 2. if key doesn't present it will returns "null"
         */
        System.out.println("Maths marks is : " + map.get("Math"));
        System.out.println("History marks is : " + map.get("History"));

        /*
         * Iteration in Hashmap : same as that of accessing the elements from the array
         * imp-> to accesing the the pair -> entrySet() is use
         * we can also acces the keys using keySet()
         */
        // Imp
        System.out.println("The map is : ");
        for (Map.Entry<String, Integer> element : map.entrySet()) {
            System.out.println(element.getKey() + " " + element.getValue());
        }
        System.out.println("---------------------------------");
        // through key set -> accessing the key and then the access the value using key
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + " " + map.get(key));
        }

        // remove pair from hashmap -> .remove()
        map.remove("English");
        System.out.println("English subject get removed fron map");
        System.out.println("The map is : " + map);

        // to get the size of hashmap -> .size()
        System.out.println("The size of map is : " + map.size());
    }
}
