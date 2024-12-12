import java.util.*;

/**
 * Basic of stack: - Two types
 * Implicit stack: - made by memory at the time of recursion
 * Explicit statck: - made by programer
 * Operations: - i)Push O(1) ii)Pop O(1) iii)Peek O(1)
 * LIFO: - Last in first out
 * Implementation: - ArrayList , LinkedList
 * 
 */
public class stackUsingArraylist {
    // Stack using arraylist

    public static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            return list.size() == 0;
        }

        // push
        public static void push(int data) {
            list.add(data);
        }

        // pop
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

        // direcly using stack collection framework
        // push(), pop(), peek() functions are direcly available

        // Stack<Interger> stack1 = new Stack<>();

        // stack1.push(1);
        // stack1.push(2);
        // stack1.push(3);
        // stack1.push(4);
        // stack1.push(5);

        // while (!s.isEmpty()) {
        //     System.out.println(stack1.peek());
        //     stack1.pop();
        // }
    }
}