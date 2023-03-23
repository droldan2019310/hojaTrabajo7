package binaries;

public class Node<T> {
    Association<String, String> palabra = new Association<String,String>();
    Node left, right;
    // Constructor
    public Node(Association<String, String> word)
    {
        palabra = word;
        left = right = null;
    }
}
