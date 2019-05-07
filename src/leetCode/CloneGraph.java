package leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/clone-graph/
 * Time complexity - O(n)
 * Space complexity - O(n)
 *
 */
public class CloneGraph {

    public static Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> nodesMap = new HashMap<>();
        Queue<Node> actualQueue  = new ArrayDeque<>();
        actualQueue.add(node);

        Node current = new Node(node.val, new ArrayList<>());
        nodesMap.put(node, current);

        while(!actualQueue.isEmpty()) {
            Node currentActual = actualQueue.poll();

            for (Node adj: currentActual.neighbors) {
                if (!nodesMap.containsKey(adj)) {
                    nodesMap.put(adj, new Node(adj.val, new ArrayList<>()));
                    actualQueue.add(adj);
                }
                nodesMap.get(currentActual).neighbors.add(nodesMap.get(adj));
            }
        }

        return current;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };

    public static void main(String[] args) {
        Node root = new Node(1, new ArrayList<>());

        Node current = root;
        Node val2 = new Node(2, new ArrayList<>());
        Node val3 = new Node(3, new ArrayList<>());
        Node val4 = new Node(4, new ArrayList<>());

        current.neighbors.add(val2);
        current.neighbors.add(val4);

        val2.neighbors.add(current);
        val2.neighbors.add(val3);

        val3.neighbors.add(val2);
        val3.neighbors.add(val4);

        val4.neighbors.add(current);
        val4.neighbors.add(val3);

        Node result = cloneGraph(root);

        System.out.println(result.val);
    }
}
