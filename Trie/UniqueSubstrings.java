import java.util.*;

/* 
 * Counting all possible unique substrings: Imp -> no. of unique substrings = all 
 * Step1 : 
 * 
 */
public class UniqueSubstrings {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "Check whether the words array contains the word starts with prefix 'app' : " + startWith(prefix));

        System.out.println("Enter the string who's unique no. of substring you want to count :");
        String str2 = sc.nextLine();

    }
}
