
public class Main {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        //test insertion
        bst.insert(50, "A");
        bst.insert(30, "B");
        bst.insert(20, "C");
        bst.insert(40, "D");
        bst.insert(70, "E");
        bst.insert(60, "F");
        bst.insert(80, "G");

        // Test in-order traversal
        System.out.println("In-order traversal: ");
        bst.inOrderTraversal();
        System.out.println();

        // Test minimum key
        System.out.println("Minimum key: " + bst.getMin());

        // Test maximum key
        System.out.println("Maximum key: " + bst.getMax());

        // Test get method
        System.out.println("Value for key 50: " + bst.get(50));
        System.out.println("Value for key 70: " + bst.get(70));
        System.out.println("Value for key 90: " + bst.get(90));

        // Test deleting keys
        bst.deleteKey(20);
        bst.deleteKey(30);
        bst.deleteKey(50);
        System.out.println("In-order traversal after deleting keys 20, 30, and 50: ");
        bst.inOrderTraversal();
    }
}