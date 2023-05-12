
public class Main {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        bst.insert(50, "A");
        bst.insert(30, "B");
        bst.insert(20, "C");
        bst.insert(40, "D");
        bst.insert(70, "E");
        bst.insert(60, "F");
        bst.insert(80, "G");

        System.out.println("In-order traversal: ");
        bst.inOrderTraversal();
        System.out.println();

        System.out.println("Minimum key: " + bst.getMin());
        System.out.println("Maximum key: " + bst.getMax());

        bst.deleteKey(20);
        bst.deleteKey(30);
        bst.deleteKey(50);

        System.out.println("In-order traversal after deleting keys: ");
        bst.inOrderTraversal();





    }
}