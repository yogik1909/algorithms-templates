package sprint5.K;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Solution {
    public static void main(String[] args) throws IOException {
        Node node1 = new Node(null, null, 2);
        Node node2 = new Node(null, node1, 1);
        Node node3 = new Node(null, null, 8);
        Node node4 = new Node(null, node3, 8);
        Node node5 = new Node(node4, null, 9);
        Node node6 = new Node(node5, null, 10);
        Node node7 = new Node(node2, node6, 5);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write("Начало");

        printRange(node7, 2, 8, writer);
        writer.newLine();
        writer.write("Конец");
        writer.close();

    }

    public static void printRange(Node root, int L, int R, BufferedWriter writer) throws IOException {
        if (root.getLeft() != null) {
            printRange(root.getLeft(), L, R, writer);
        }
        if (L <= root.getValue() && root.getValue() <= R) {
            writer.write(String.valueOf(root.getValue()));
            writer.write(" ");
        }
        if (root.getRight() != null) {
            printRange(root.getRight(), L, R, writer);
        }
    }

    // <template>
    private static class Node {
        private int value;  
        private Node left;  
        private Node right;  
    
        Node(Node left, Node right, int value) {  
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    
        public Node getRight() {
            return right;
        }
    
        public void setRight(Node right) {
            this.right = right;
        }
    
        public Node getLeft() {
            return left;
        }
    
        public void setLeft(Node left) {
            this.left = left;
        }
    
        public void setValue(int value) {
            this.value = value;
        }
    }
    // <template>
    
    private static void test() throws IOException{
        Node node1 = new Node(null, null, 2);
        Node node2 = new Node(null, node1, 1);
        Node node3 = new Node(null, null, 8);
        Node node4 = new Node(null, node3, 8);
        Node node5 = new Node(node4, null, 9);
        Node node6 = new Node(node5, null, 10);
        Node node7 = new Node(node2, node6, 5);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        printRange(node7, 2, 8, writer);
        writer.flush();
        // expected output: 2 5 8 8
    }
}