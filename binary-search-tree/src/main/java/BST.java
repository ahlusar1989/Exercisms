/**
 * Created by saranahluwalia on 7/2/17.
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST<T extends Comparable<T>> {

    public static class Node<T> {

        private T data;
        private Node<T> left = null;
        private Node<T> right = null;

        public Node(T data) {
            this.data = data;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public T getData() {
            return data;
        }

    }

    private Node<T> root;

    private int count = 0;

    public void insert(T value) {
        if (root == null) {
            root = new Node<>(value);
        } else {
            this.insert(this.root, value);
        }
        this.count++;
    }

    public List<T> getAsSortedList() {
        List<T> result = new ArrayList<>(this.count);
        this.constructInSortedOrderToList(this.root, result);
        return Collections.unmodifiableList(result);
    }

    public List<T> getAsLevelOrderList() {
        List<T> result = new ArrayList<>(this.count);
        this.constructLevelOrderToList(this.root, result);
        return Collections.unmodifiableList(result);
    }

    public Node<T> getRoot() {
        return root;
    }

    private void insert(Node<T> node, T value) {
        if (value.compareTo(node.getData()) <= 0) {
            if (node.getLeft() == null) {
                node.setLeft(new Node<T>(value));
            } else {
                insert(node.getLeft(), value);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new Node<T>(value));
            } else {
                insert(node.getRight(), value);
            }
        }
    }

    private void constructInSortedOrderToList(Node<T> node, List<T> list) {
        if (node == null || list == null) {
            return;
        }
        if (node.getLeft() != null) {
            constructInSortedOrderToList(node.getLeft(), list);
        }
        list.add(node.getData());
        if (node.getRight() != null) {
            constructInSortedOrderToList(node.getRight(), list);
        }
    }

    private void constructLevelOrderToList(Node<T> node, List<T> list) {
        if (node == null || list == null) {
            return;
        }
        final Queue<Node<T>> queue = new LinkedList<>();
        Node<T> myNode;
        Node<T> left;
        Node<T> right;
        queue.add(node);
        while (!queue.isEmpty()) {
            myNode = queue.poll();
            list.add(myNode.getData());
            left = myNode.getLeft();
            right = myNode.getRight();
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
        }
    }
}