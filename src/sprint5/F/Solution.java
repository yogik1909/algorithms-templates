package sprint5.F;

public class Solution {
    public static void main(String[] args) {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(4, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(8, null, null);
        Node node5 = new Node(5, node3, node4);
        System.out.println( treeSolution(node5));
    }
    public static int treeSolution(Node head) {
        return getChildHeight(head);
    }

    private static int getChildHeight(Node node) {
        if (node == null) {
            return 0; // Высота пустого дерева равна 0
        }

        int leftHeight = getChildHeight(node.left);

        int rightHeight = getChildHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1; // Возвращаем высоту текущего узла
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

        Node(int value, Node left, Node right) {  
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    // <template>
    
    private static void test() {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(4, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(8, null, null);
        Node node5 = new Node(5, node3, node4);
        assert treeSolution(node5) == 3;
    }
}
