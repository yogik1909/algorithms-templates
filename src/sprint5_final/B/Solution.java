/*
Задача: https://contest.yandex.ru/contest/24810/problems/B/
Посылка: https://contest.yandex.ru/contest/24810/run-report/114501007/

## Вычислительная сложность
Для определения вычислительной сложности удаления элемента из дерева поиска рассмотрим поиск элемента и
восстановление распадающегося дерева.

Вычислительная сложность поиска элемента для удаления асимптотична O(H), так как дерево хранит уникальные
ключи, это значит, что искомый элемент лежит либо в правом, либо в левом потомке дерева, в самом худшем
варианте искомый элемент будет находиться на последней вершине.

Вычислительная сложность восстановления дерева после удаления найденного элемента будет асимптотична
О(n - h), где h — высота элемента удаления относительно корневого элемента.

Итоговая вычислительная сложность асимптоматична O(H).

## Пространственая сложность
Так как используется рекурсивный обход дерева, потребуется обход дерева в глубину либо для получения элемента
для восстановления дерева, либо если искомый элемент будет располагаться на последнем узле дерева.

Поэтому пространственная сложность будет O(H).

 */

package sprint5_final.B;

// <template>
class Node {
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

public class Solution {
    public static Node remove(Node root, int key) {
        if (root == null) {
            return root;
        }

        // Если удаляемый ключ меньше корня рекурчивно уходим влево
        if (key < root.getValue()){
            root.setLeft(remove(root.getLeft(), key));
        }
        // Иначе переходим к правому потомку c установокй значения
         else if ( key > root.getValue()){
            root.setRight(remove(root.getRight(), key));
        }
         //Начинается обработка узла с ключе  раным улючу удаления
        // Сначала обрабатываем первый случай узла без потомков
        else {
        if (root.getLeft() == null)
            return root.getRight();
        else if (root.getRight() == null)
            return root.getLeft();

        Node maxValLeftChild = root.getLeft();
        while (maxValLeftChild != null){
            root.setValue(maxValLeftChild.getValue());
            maxValLeftChild = maxValLeftChild.getRight();
        }
        root.setLeft(remove(root.getLeft(), root.getValue()));

        }





        return root;
    }

    private static void test() {
        Node node1 = new Node(null, null, 2);
        Node node2 = new Node(node1, null, 3);
        Node node3 = new Node(null, node2, 1);
        Node node4 = new Node(null, null, 6);
        Node node5 = new Node(node4, null, 8);
        Node node6 = new Node(node5, null, 10);
        Node node7 = new Node(node3, node6, 5);
        Node newHead = remove(node7, 10);
        assert newHead.getValue() == 5;
        assert newHead.getRight() == node5;
        assert newHead.getRight().getValue() == 8;
    }
}
