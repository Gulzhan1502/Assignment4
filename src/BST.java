import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class BST<K extends Comparable<K>, V> {
    private Node<K,V> root;
    private int size;

    private class Node <K,V>{
        public int size;
        private K key;
        private V value;
        private Node<K, V> left, right;


        public Node(K key, V val) {
            this.key = key;
            this.value = value;
            left=right=null;
            size = 1;
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(K key, V value){
        root = insert(root, key, value);
    }
    private Node<K, V>  insert(Node<K,V> node, K key, V value){
        if (node==null){
            size++;
            return new Node<>(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0){
            node.left = insert(node.left, key, value);
        }
        else if (cmp > 0){
            node.right = insert(node.right, key, value);
        }
        else {
            node.value = value;
        }
        return node;
    }

    public V get(K key) {
        Node<K, V> node = getNode(root, key);
        if (node == null) {
            return null;
        }
        return node.value;
    }

    private Node<K, V> getNode(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node;
        } else if (cmp < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }


    public void deleteKey(K key) {
        root = deleteRec(root, key);
    }

    private Node<K, V> deleteRec(Node<K, V> root, K key) {

        if (root == null) { //If the tree is empty
            return null;
        }
        int cmp = key.compareTo(root.key);
        if (cmp < 0){
            root.left = deleteRec(root.left, key);
        }
        else if (cmp > 0) {
            root.right = deleteRec(root.right, key);
        }

        else {
            if (root.left == null) {// Node with only one child or no child
                size--;
                return root.right;
            }
            else if (root.right == null) {
                size--;
                return root.left;
            }

            Node<K, V> minRight = getMin(root.right);
            root.key = minRight.key;
            root.value = minRight.value;
            root.right = deleteRec(root.right, minRight.key);
        }
        return root;
    }
    public K getMin() {
        if (isEmpty()) {
            return null;
        }
        return getMin(root).key;
    }

    private Node<K, V> getMin(Node<K, V> temp) {
        if (temp.left == null) {
            return temp;
        }
        return getMin(temp.left);
    }

    public K getMax() {
        if (isEmpty()) {
            return null;
        }
        return getMax(root).key;
    }

    private Node<K, V> getMax(Node<K, V> node) {
        if (node.right == null){
            return node;
        }
        return getMax(node.right);
    }

    private int size(Node<K, V> node) {
        if (node == null){
            return 0;
        }
        else return node.size;
    }

    void inOrderTraversal() {
        inOrderTraversalRec(root);
    }

    void inOrderTraversalRec(Node root)
    {
        if (root != null) {
            inOrderTraversalRec(root.left);
            System.out.print(root.key + " ");
            inOrderTraversalRec(root.right);
        }
    }
}