import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class BST<K extends Comparable<K>, V> {
    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left, right;
        private int size;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            this.size = 1;
        }
    }
    public void put(K key, V val) {
        root = put(root, key, val);
    }
    public boolean isEmpty(){
        return root == null;
    }

    public K getMin() {
        if (isEmpty()) {
            System.out.println ("Tree is empty");
        }
        return getMin(root).key;
    }

    private Node getMin(Node temp) {
        if (temp.left == null) {
            return temp;
        }
        return getMin(temp.left);
    }

    public K getMax() {
        if (isEmpty()) {
            System.out.println ("Tree is empty");
        }
        return getMax(root).key;
    }

    private Node getMax(Node temp) {
        if (temp.right == null){
            return temp;
        }
        return getMax(temp.right);
    }

    private Node put(Node temp, K key, V val) {
        if (temp == null) {
            return new Node(key, val);
        }
        int cmp = key.compareTo(temp.key);
        if (cmp < 0){
            temp.left = put(temp.left, key, val);
        }
        else if (cmp > 0){
            temp.right = put(temp.right, key, val);
        }
        else {
            temp.val = val;
        }
        temp.size = 1 + size(temp.left) + size(temp.right);
        return temp;
    }

    private int size(Node temp) {
        if (temp == null){
            return 0;
        }
        else return temp.size;
    }


    public List<K> inOrderTraversal() {
        List<K> keys = new ArrayList<>();
        inOrderTraversal(root, keys);
        return keys;
    }

    private void inOrderTraversal(Node temp, List<K> keys) {
        if (temp == null){
            return;
        }
        inOrderTraversal(temp.left, keys);
        keys.add(temp.key);
        inOrderTraversal(temp.right, keys);
    }
}