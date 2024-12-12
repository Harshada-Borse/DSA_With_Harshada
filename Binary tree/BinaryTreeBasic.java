import java.util.*;
// import java.util.Queue;

class Node {
    int data;
    Node right;
    Node left;

    Node(int data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }
}

public class BinaryTreeBasic {
    Scanner sc = new Scanner(System.in);

    public Node buildTree(Node root) {
        System.out.print("Enter the data : ");
        int data = sc.nextInt();

        root = new Node(data);
        if (data == -1)
            return null;

        System.out.println("Enter the data to insert left of " + data + " : ");
        root.left = buildTree(root.left);

        System.out.println("Enter the data to insert right of " + data + " : ");
        root.right = buildTree(root.right);

        return root;
    }

    public void levelOrderPrint(Node root) {
        if (root == null) {
            System.out.println("Tree does not exits.");
            return;
        }

        // null is add for seperator between the levels
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node temp = queue.poll(); // poll function return the front element of the queue and remove it from the
                                      // queue
            // Instead of poll we can use peek() + remove()
            // Node temp = queue.peek();
            // queue.remove();

            if (temp == null) {
                System.out.println();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                System.out.print(temp.data + " ");

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
    }

    public void inorderPrint(Node root) {
        if (root == null)
            return;

        inorderPrint(root.left);
        System.out.print(root.data + " ");
        inorderPrint(root.right);
    }

    public void preorderPrint(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preorderPrint(root.left);
        preorderPrint(root.right);
    }

    public void postorderPrint(Node root) {
        if (root == null)
            return;

        postorderPrint(root.left);
        postorderPrint(root.right);
        System.out.print(root.data + " ");
    }

    public void iterativeInorder(Node root) {
        if (root == null)
            return;

        Stack<Node> s = new Stack<Node>();
        Node currentNode = root;
        while (!s.empty() || currentNode != null) {
            if (currentNode != null) {
                s.push(currentNode);
                currentNode = currentNode.left;
            } else {
                Node n = s.pop();
                System.out.print(n.data + " ");
                currentNode = n.right;
            }
        }
    }

    /*
     * Height of BT / Depth of BT : It it the longest path between root and the
     * leaf node.
     * Here, first calculate the height of left subtree and then right subtree, find
     * the maximum of them and then add 1 for root node
     * Time complexity : O(n), where n - no. of nodes
     * Space complexity : O(height)
     * In the case of skewed tree (having only left or right node) -> space
     * complexity : O(n), n - no. of nodes
     */

    public int heightOrDepth(Node root) {
        // base case
        if (root == null)
            return 0;

        int leftHeight = heightOrDepth(root.left);
        int rightHeight = heightOrDepth(root.right);

        int height = Math.max(leftHeight, rightHeight) + 1;

        return height;
    }

    /*
     * Diameter of BT : It is the longest path between any 2 end nodes(end node may
     * be root node or leaf node)
     * // Approach 1
     * There are 3 options :
     * 1. diameter present in left subtree
     * 2. diameter present in right subtree
     * 3. present from left to right subtree (It can be calculated by -> height of
     * left subtree + height of right subtree + 1)
     * Here, at every node it will return the height of left subtree, right subtree
     * and the diameter (Drawback)
     * Time complexity : O(n^2) -> since we are calculating height while calculating
     * the diameter
     */

    public int diameter(Node root) {
        // base case
        if (root == null)
            return 0;

        int op1 = diameter(root.left);
        int op2 = diameter(root.right);
        int op3 = heightOrDepth(root.left) + heightOrDepth(root.right) + 1; // 1 for root

        int ans = Math.max(op1, Math.max(op2, op3));

        return ans;
    }

    /*
     * // Approach 2
     * Here, we are making the pair of height and the diameter
     * Time complexity : O(n)
     * Note : first study the hashmap and then try to implement the 2nd approach
     */

    // public Pair<Integer, Integer> fastDiameter(Node root) {
    // // base case
    // if (root == null)
    // return 0;

    // Pair<Integer, String> p = new Pair<Integer, String>();
    // }

    /*
     * Balanced tree : A tree is height balanced if difference between heights of
     * left and right subtrees is not more than one for all nodes of tree.
     * Time complexity : O(n^2)
     * It is also solve by using hashmap
     * Try it after studing hashmap
     */

    public boolean isBalanced(Node root) {
        // base case
        if (root == null)
            return true;

        boolean leftBalance = isBalanced(root.left);
        boolean rightBalance = isBalanced(root.right);

        boolean diff = Math.abs(heightOrDepth(root.left) - heightOrDepth(root.right)) <= 1;

        if (leftBalance && rightBalance && diff)
            return true;
        return false;
    }

    /*
     * Lowest Common Ancestor : it is the lowest common ancestor of given nodes
     * Time complexity : O(n);
     * Space Complexity : O(height of BT)
     * See the recursive tree
     */

    public Node lowestCommonAncestor(Node root, int n1, int n2) {
        // base case
        if (root == null)
            return null;
        if (root.data == n1 || root.data == n2)
            return root;

        Node leftAns = lowestCommonAncestor(root.left, n1, n2);
        Node rightAns = lowestCommonAncestor(root.right, n1, n2);

        // 4 cases
        // 1.
        if (leftAns != null && rightAns != null)
            return root;
        else if (leftAns != null && rightAns == null)
            return leftAns;
        else if (leftAns == null && rightAns != null)
            return rightAns;
        else
            return null;
    }

    public static void main(String[] args) {
        Node root = null;
        BinaryTreeBasic tree1 = new BinaryTreeBasic();

        root = tree1.buildTree(root);

        System.out.println("The tree is : ");
        tree1.levelOrderPrint(root);
        // 1 2 -1 5 -1 -1 4 3 -1 -1 6 -1 -1
        System.out.println("The Inorder Travelsal is : ");
        tree1.iterativeInorder(root);
        System.out.println();

        System.out.println("The Inorder Travelsal without recursion is : ");
        tree1.inorderPrint(root);
        System.out.println();

        System.out.println("The Preorder Travelsal is : ");
        tree1.preorderPrint(root);
        System.out.println();

        System.out.println("The Postorder Travelsal is : ");
        tree1.postorderPrint(root);
        System.out.println();

        System.out.println("The height of BT is : " + tree1.heightOrDepth(root));
        System.out.println();

        System.out.println("The diameter of BT is : " + tree1.diameter(root));
        System.out.println();

        if (tree1.isBalanced(root))
            System.out.println("Given tree is Balanced tree.");
        else
            System.out.println("Given tree is Balanced tree.");

        System.out.println("The lowest common anscentor of 3 and 6 is : " + tree1.lowestCommonAncestor(root, 3, 6));
        ;
    }
}
