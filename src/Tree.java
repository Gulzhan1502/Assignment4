public interface Tree <K extends Comparable <K>>{
    Tree<K> put (K data);
    void delete(K data);
    void traverse();
    K getMax();
    K getMin ();
    boolean isEmpty();

}
