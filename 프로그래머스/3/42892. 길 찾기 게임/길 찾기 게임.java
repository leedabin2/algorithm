import java.util.*;


class Solution {
    class Node {
        int x, y, value;
        Node left, right;
        Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }
    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodes = new ArrayList<>();
        
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        
        nodes.sort((a, b) -> b.y - a.y);
        
        Node root = nodes.get(0);
        
        for (int i = 1; i < nodes.size(); i++) {
            insert(root, nodes.get(i));
        }
        
        List<Integer> pree = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        
        preeorder(root, pree);
        postorder(root, post);
        return new int[][]{
            pree.stream().mapToInt(i -> i).toArray(),
            post.stream().mapToInt(i -> i).toArray(),
        };
        
    }
    static void insert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) parent.left = child;
            else insert(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }
    static void preeorder(Node node, List<Integer> pree) {
        if (node == null) return;
        pree.add(node.value);
        preeorder(node.left, pree);
        preeorder(node.right, pree);
    }
    static void postorder(Node node, List<Integer> post) {
        if (node == null) return;
        postorder(node.left, post);
        postorder(node.right, post);
        post.add(node.value);
    }
}