package sprint5.B;

public class Solution {
    public static void main(String[] args) {
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.left = node2;
        node1.right = node0;
        System.out.println(treeSolution(node1));
    }
    public static boolean treeSolution(Node head) {
        return getChildHeightOrBalance(head) != -1;
    }
    private static int getChildHeightOrBalance(Node node) {
        if (node == null) {
            return 0; // Высота пустого дерева равна 0
        }

        int leftHeight = getChildHeightOrBalance(node.left);
        if (leftHeight == -1) return -1; // Левое поддерево не сбалансировано

        int rightHeight = getChildHeightOrBalance(node.right);
        if (rightHeight == -1) return -1; // Правое поддерево не сбалансировано

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Текущий узел не сбалансирован
        }

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
    }
    // <template>
    
    private static void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(-5);
        Node node3 = new Node(3);
        node3.left = node1;
        node3.right = node2;
        Node node4 = new Node(10);
        Node node5 = new Node(2);
        node5.left = node3;
        node5.right = node4;
        assert treeSolution(node5);
    }
}
