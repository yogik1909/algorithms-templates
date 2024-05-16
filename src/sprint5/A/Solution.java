package sprint5.A;

public class Solution {
    public static int treeSolution(Node head) {
        int[] values = new int[3];
        values[0] = head.value;
        values[1] = head.left!=null?treeSolution(head.left): -1;
        values[2] = head.right!=null?treeSolution(head.right): -1;



        return values[0]>values[1]?
                values[0]>values[2]?values[0]:values[2]:values[1]>values[2]?values[1]:values[2];
    }

    // <template>
    private static class Node {
        int value;  
        Node left;  
        Node right;  
    
        Node(int value) {  
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    // <template>


    private static void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(-5);
        Node node3 = new Node(3);
        node3.left = node1;
        node3.right = node2;
        Node node4 = new Node(2);
        node4.left = node3;
        assert treeSolution(node4) == 3;
    }
}
