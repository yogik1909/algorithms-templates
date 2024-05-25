/*
Задача: https://contest.yandex.ru/contest/24810/problems/B/
Посылка: https://contest.yandex.ru/contest/24810/run-report/114501007/

## Вычислительная сложность

Лучший случай происходит, когда дерево является сбалансированным.
В таком случае высота дерева будет O(log n),
где ( n ) — количество узлов в дереве. Поиск удаляемого элемента и его удаление в таком дереве будет
иметь временную сложность O(log n).

Худший случай наступает, когда дерево вырождено в линейный список
(например, когда элементы были добавлены в строго возрастающем или убывающем порядке).
В этом случае высота дерева равна ( n ), и временная сложность поиска и удаления элемента также будет
O(n).

D среднем, если предположить случайное построение дерева, сложность удаления элемента будет приближаться
к O(log n), но это зависит от конкретной структуры дерева и распределения его элементов.

## Пространственая сложность
В рекурсивной реализации пространстенная сложность может достигать сложности O(h).

В худшем случае если дерево будет вырожденными и представляеся из себя линеный списко
тогда вычислительная сложность O(n)

В лучшем случай когда дерево является сбалансированным, пространственая сложность асимптоматичная O(log n)
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
