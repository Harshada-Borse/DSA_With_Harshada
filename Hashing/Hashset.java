import java.util.HashSet;
import java.util.Iterator;

/*
 * HashSet : use to reduced the time complexity
 * T.C. for insert : O(1)
 * T.C. for delete : O(1)
 * present in java.util package
 ** It is unordered data structure(no guess how the elements of set are print) 
 ** It will prints the duplicate only once

 ** Iterator : use to interate the set having 2 functions i) .next() -> print next element and ii) .hasNext() -> return true or false -> if set having no next element i.e. present at last element then it will return true otherwise false.
 */

public class Hashset {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();

        // inserting the element -> .add(element)
        set1.add(10);
        set1.add(30);
        set1.add(50);
        set1.add(30);
        set1.add(70);

        // print the set -> just using the name of set
        System.out.println("The set is : " + set1);

        // to check the element is contains or not -> .contains(element) : if element
        // contains return true, else false
        if (set1.contains(30))
            System.out.println("The set contains element 30.");

        if (!set1.contains(20))
            System.out.println("The set does not contains 20.");

        // deleting the element -> .remove(element)
        System.out.println("Deteting 50 from the set......");
        set1.remove(50);

        Iterator loop = set1.iterator();

        System.out.println();
        System.out.println("Printing the set using iterator : ");
        while (loop.hasNext()) {
            System.out.print(loop.next() + " ");
        }

        System.out.println();
        // size of set -> .size()
        System.out.println("The size of set is : " + set1.size());

        // .isEmpty() -> check whether the set is empty or not, returns true is empty
        // otherwise false
        System.out.println("The given set is empty or not?? : " + set1.isEmpty());

        // toArray() -> This method is used to form an array of the same elements as
        // that of the Set.
        // toString() -> The toString() method of Java HashSet is used to return a
        // string representation of the elements of the HashSet Collection.

        set1.toArray();
        System.out.println(set1);

        set1.toString();
        System.out.println(set1);

        // .clear() -> clears all the elements of set
        set1.clear();
        System.out.print(set1);
    }
}
