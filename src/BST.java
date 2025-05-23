import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;

// BST.java
// This class defines a generic Binary Search Tree (BST) data structure.
// It uses a nested TreeNode class to represent each node in the tree.
// The tree stores elements of any type E that implements Comparable<E>.
public class BST<E extends Comparable<E>> {
    protected TreeNode<E> root; // The root node of the BST
    protected int size = 0;     // Keeps track of the number of nodes in the tree

    // Default constructor for an empty tree
    public BST() {}

    public void insert(E element) {
        root = insert(root, element);
        size++;
    }

    private TreeNode<E> insert(TreeNode<E> node, E element) {
        if (node == null) return new TreeNode<>(element);

        if (element.compareTo(node.element) < 0) node.left = insert(node.left, element);
        else if (element.compareTo(node.element) > 0) node.right = insert(node.right, element);
        else {}
        return node;
    }

    // Public method to get the height of the tree
    public int height() {
        return height(root);
    }

    // Private helper method to compute the height recursively
    private int height(TreeNode<E> root) {
        if (root == null) return 0; // Base case: empty subtree
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Public method to perform inorder traversal
    public void inorder() {
        inorder(root);
        System.out.println(); // Print a newline after traversal output
    }

    // Recursive helper for inorder traversal
    private void inorder(TreeNode<E> root) {
        if (root != null) {
            inorder(root.left);
            inorder(root.right);
            System.out.println(root.element + " ");
        }
    }

    public boolean search(E element) {
        TreeNode<E> current = root;
        while (current != null) {
            int cmp = element.compareTo(current.element);
            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public void delete(E element) {
        if (search(element)) {
            root = delete(root, element);
            size--;
        }
    }

    private TreeNode<E> delete(TreeNode<E> node, E element) {
        if (node == null) return null;
        if (element.compareTo(node.element) < 0) {
            node.left = delete(node.left, element);
        } else if (element.compareTo(node.element) > 0) {
            node.right = delete(node.right, element);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            TreeNode<E> successor = findMin(node.right);
            node.element = successor.element;
            node.right = delete(node.right, successor.element);
        }
        return node;
    }

    private TreeNode<E> findMin(TreeNode<E> node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // Nested TreeNode class to represent each node in the tree
    public static class TreeNode<E> {
        protected E element;        // The data stored at this node
        protected TreeNode<E> left; // Reference to the left child
        protected TreeNode<E> right;// Reference to the right child

        // Constructor initializes the node with data
        public TreeNode(E e) {
            element = e;
        }
    }

    // Method to get the number of nodes in the BST
    public int size() {
        return size;
    }
}
