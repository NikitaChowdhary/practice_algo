package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class BST {

    static class Node {
        int val;
        Node left;
        Node right;
        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

//        int value = Integer.parseInt(in.readLine());
        Node root = null;
        int[] keys = { 15, 10, 20, 8, 12, 16, 25, 11};
        System.out.println("Keys added to tree");
        for (int key: keys) {
            System.out.print(key + " ");
            root = insertBST(root, key);
        }


        System.out.println("\n\nSearch: " + search(root, 12).val);

        for (int succcessorFor: keys) {
            Node succ = successor(succcessorFor , root, null); // try with 15
            if (succ != null)
                System.out.println("Successor for " + succcessorFor + " is " + succ.val);
            else System.out.println("Successor for " + succcessorFor + " not found");
        }

        for (int predFor: keys) {
            Node pred = predecessor(predFor, root, null);
            if (pred != null)
                System.out.println("Predecessor for " + predFor + " is " + pred.val);
            else System.out.println("Predecessor for " + predFor + " not found");
        }

        System.out.println("\nDeleting node with no child: 8");
        printInorder(root);

        delete(root, null, 8);

        System.out.println("After deleting node: 8");
        printInorder(root);

        System.out.println("\nDeleting node with one child: 12");
        printInorder(root);

        delete(root, null, 12);

        System.out.println("After deleting node: 12");
        printInorder(root);

        System.out.println("\nDeleting node with two child: 20");
        printInorder(root);

        delete(root, null, 20);

        System.out.println("After deleting node: 20");
        printInorder(root);


    }

    private static void printInorder(Node root) {
        List<Integer> inorderL = new LinkedList<>();
        inorder(root, inorderL);
        for (int i : inorderL)
            System.out.print(i + " ");
        System.out.println();
    }

    private static Node insertBST(Node root, int value) {
        if (root == null) return new Node(value);
        if (value < root.val)
            root.left = insertBST(root.left, value);
        else
            root.right = insertBST(root.right, value);
        return root;
    }


    private static Node search(Node root, int key) {
        if (root == null || root.val == key) return root;
        else if (key < root.val) return search(root.left, key);
        else return search(root.right, key);

    }


    private static Node minimum(Node root) {
        while(root.left != null)
            root = root.left;
        return root;
    }

    private static Node maximum(Node root) {
        while(root.right != null)
            root = root.right;
        return root;
    }

    private static Node successor(int key, Node root, Node succ) {
        if (root == null) return succ;
        if (root.val == key ) {
            if (root.right != null)
                return minimum(root.right);
        }
        else if (key < root.val)
            return successor(key, root.left, root);
        else
            return successor(key, root.right, succ);
        return succ;
    }


    private static Node predecessor(int key, Node root, Node pred) {
        if (root == null) return pred;
        if (root.val == key) {
            if (root.left != null)
                pred = maximum(root.left);
        }
        else if (key < root.val)
            return predecessor(key, root.left, pred);
        else {
            pred = root;
            return predecessor(key, root.right, pred);
        }
        return pred;
    }

    private static void inorder(Node root, List<Integer> inorder) {
        if (root != null) {
            inorder(root.left, inorder);
            inorder.add(root.val);
            inorder(root.right, inorder);
        }

    }

    private static void delete(Node root, Node parent, int key) {
        if (root == null) return;
        if (root.val == key) {
            // Node has one or no children
            if (root.right == null)
                replace(root, parent, root.left);
            else if (root.left == null)
                replace(root, parent, root.right);

            // Node has two children
            else {
                Pair pair = getMinAndParent(root.right, root);
                if (pair.parent == root) {
                    Node left = root.left;
                    replace(root, parent, root.right);
                    pair.min.left = left;
                } else {
                    root.val = pair.min.val;
                    replace(pair.min, pair.parent, null);
                }
            }

        } else {
            parent = root;
            if (key < root.val) delete(root.left, parent,  key);
            else delete(root.right, parent, key);
        }


    }

    private static Pair getMinAndParent(Node root, Node parent) {
        Pair result = new Pair(root, parent);
        while(root.left != null) {
            result = new Pair(root.left, root);
        }
        return result;
    }

    private static class Pair {
        Node min;
        Node parent;
        Pair(Node min, Node parent) {
            this.min = min;
            this.parent = parent;
        }
    }

    private static void replace(Node root, Node parent, Node replaceNode) {
        if (parent.right == root) parent.right = replaceNode;
        else parent.left = replaceNode;
    }
}
