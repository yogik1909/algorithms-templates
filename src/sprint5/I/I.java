package sprint5.I;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class I {
    public static void main(String[] args) throws IOException {
        int n;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            n = Integer.parseInt(reader.readLine());
        }

        List<Node> listTreeNode = generateTrees(n);
        System.out.println(listTreeNode.size());
    }

    public static List<Node> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<Node>();
        }
        return generateTrees(1, n);
    }

    private static List<Node> generateTrees(int start, int end) {
        List<Node> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i++) {
            List<Node> leftTrees = generateTrees(start, i - 1);
            List<Node> rightTrees = generateTrees(i + 1, end);

            for (Node l : leftTrees) {
                for (Node r : rightTrees) {
                    Node currentTree = new Node(i);
                    currentTree.left = l;
                    currentTree.right = r;
                    allTrees.add(currentTree);
                }
            }
        }
        return allTrees;
    } 
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

}
