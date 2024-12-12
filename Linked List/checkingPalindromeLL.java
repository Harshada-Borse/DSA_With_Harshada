public class checkingPalindromeLL {

    // Assuming ListNode is a class that represents a node in a linked list
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode reverseLL(ListNode head) {
        ListNode current = head;
        ListNode pre = null;
        ListNode forward = null;

        while (current != null) {
            forward = current.next;
            current.next = pre;
            pre = current;
            current = forward;
        }
        return pre;
    }

    public boolean isPalindrome(ListNode head) {
        // First, reverse the linked list
        ListNode reverseLL = reverseLL(head);

        // Compare each corresponding node in the original and reversed linked lists
        ListNode temp1 = head;
        ListNode temp2 = reverseLL;

        while (temp1 != null && temp2 != null) {
            if (temp1.val != temp2.val) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        // If all nodes are compared and match, it's a palindrome
        return true;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        checkingPalindromeLL solution = new checkingPalindromeLL();
        boolean isPalindrome = solution.isPalindrome(head);

        System.out.println("Is Palindrome: " + isPalindrome);
    }
}
