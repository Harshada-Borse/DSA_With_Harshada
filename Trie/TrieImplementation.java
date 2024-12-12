/* 
 * Trie (also called as prefix tree / digital tree / retrieval tree): use to search the word in big dictonary
 * Each node has 26 childern (a to z / A to Z) 
 * Imp: if string contains capital, small letters and some special character(a to z, A to Z, @!#$%^&*......, etc.) then take the array size as 256 which includes all special characters.
 * initially set all children to null (by default we assume the at index 0->a, 1->b, ....., 25->z)
 * index = char - 'a' for lower case and 'A' for upper case
 * 
 * operations: i) search: T.C. -> O(l) where l is the length of longest string in array
 * 
 */

import java.util.*;

public class TrieImplementation {
    static class Node {
        Node[] children;
        boolean endOfWord;

        Node() {
            children = new Node[26]; // a to z
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            endOfWord = false;
        }
    }

    static Node root = new Node();

    public static void insertWord(String word) {
        Node current = root; // to store the root value
        for (int i = 0; i < word.length(); i++) {
            // first find index
            int index = word.charAt(i) - 'a';

            if (current.children[index] == null) {
                // if not present then create a new node
                current.children[index] = new Node();
            }

            // if word get end make endOfWord to true
            if (i == word.length() - 1)
                current.children[index].endOfWord = true;

            // if already present then just update the current to the children at respective
            // index
            current = current.children[index];
        }
    }

    public static boolean searchWord(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (current.children[index] == null)
                return false; // not present

            if (i == word.length() - 1 && current.children[index].endOfWord == false)
                return false; // word get end but we cant reach to the end of string i.e. not present its
                              // small substring is present

            current = current.children[index];
        }
        return true;
    }

    public static boolean wordBreak(String key) {
        // base case
        if (key.length() == 0)
            return true;

        // break the string into 2 parts
        for (int i = 1; i <= key.length(); i++) {
            String firstPart = key.substring(0, i);
            String secondPart = key.substring(i, key.length());

            if (searchWord(firstPart) && wordBreak(secondPart))
                return true;
        }
        return false;
    }

    // if the key and arraylist is given
    public static boolean wordBreak(String key, ArrayList<String> B) {
        // base case
        if (key.length() == 0)
            return true;

        for (int i = 1; i <= key.length(); i++) {
            String firstPart = key.substring(0, i);
            String secondPart = key.substring(i);

            if (B.contains(firstPart) && wordBreak(secondPart, B))
                return true;
        }
        return false;
    }

    // same as that of search function but here, we don't need to check the end of
    // the word
    // here, we are checking that word is present or not with given prefix
    public static boolean startWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';

            if (curr.children[index] == null)
                return false; // char not present

            curr = curr.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // String words[] = { "the", "a", "there", "harshada", "their", "any" };
        // System.out.print("The given array of string is : " + "[ ");
        // for (String word : words) {
        // System.out.print(word + ", ");
        // }
        // System.out.print("]");
        // System.out.println();

        // for (int i = 0; i < words.length; i++) {
        // insertWord(words[i]);
        // }

        // System.out.println("Check for string 'the' (if present return true else
        // false): " + searchWord("the"));
        // System.out
        // .println("Check for string 'harshada' (if present return true else false): "
        // + searchWord("harshada"));
        // System.out.println("Check for string 'they' (if present return true else
        // false): " + searchWord("they"));
        // System.out.println("Check for string 'sun' (if present return true else
        // false): " + searchWord("sun"));

        // word break
        // Create an empty ArrayList to store strings
        ArrayList<String> str = new ArrayList<>();

        // Input words into the ArrayList
        System.out.print("Enter the words for arraylist : ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        for (int i = 0; i < n; i++) {
            String s1 = sc.nextLine();
            str.add(s1);
            insertWord(s1);
        }

        // Check if all parts of a given key are present in the ArrayList
        System.out.println("Enter the key : ");
        String key = sc.nextLine();
        if (wordBreak(key, str))
            System.out.println("All parts of the key are present in the arraylist.");
        else
            System.out.println("Some part are missing in the arraylist.");

        // starts with
        String words[] = { "apple", "app", "mango", "man", "woman" };
        String prefix = "app";

        for (int i = 0; i < words.length; i++) {
            insertWord(words[i]);
        }
    }
}
