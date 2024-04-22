// <template>
package sprint2.C;
class Node<V> {  
    public V value;  
    public Node<V> next;  
 
    public Node(V value, Node<V> next) {  
        this.value = value;  
        this.next = next;  
    }  
}
// <template>

public class Solution {
    public static Node<String> solution(Node<String> head, int idx) {
        int curIndNode = 0;

        Node<String> pr = null, curNode = head, curHead = head;
        while (curNode != null || curIndNode > idx){
            if (curIndNode == idx){
                if (curHead == curNode) {curHead = curNode.next; break;}
                pr.next = curNode.next;
                break;
            }
            pr = curNode;
            curNode = curNode.next;
            curIndNode++;

        }
        return curHead;
    }

    public static void main(String[] args) {
        test();
    }
    public static void printNode(Node<String> head) {
        // Your code
        // ヽ(´▽`)/
        Node<String> curNode = head;
        while (curNode != null){
            System.out.println(curNode.value);
            curNode = curNode.next;
        }
    }
    private static void test() {
        Node<String> node3 = new Node<>("node3", null);
        Node<String> node2 = new Node<>("node2", node3);
        Node<String> node1 = new Node<>("node1", node2);
        Node<String> node0 = new Node<>("node0", node1);
        Node<String> newHead = solution(node0, 1);
        printNode(newHead);
        assert newHead == node0;
        assert newHead.next == node2;
        assert newHead.next.next == node3;
        assert newHead.next.next.next == null;
        // result is : node0 -> node2 -> node3
    }
}
