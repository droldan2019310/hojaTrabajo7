package binaries;

/**
 * @author Davis Roldan
 */
public class Node<T> {
    Association<String, String> word = new Association<String,String>();
    Node left, right;
    // Constructor
    public Node(Association<String, String> word)
    {
        this.word = word;
        left = right = null;
    }
}
