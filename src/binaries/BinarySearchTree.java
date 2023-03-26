package binaries;

/**
 * @author Davis Roldan
 */
public class BinarySearchTree  {
    
    Node root;

    public BinarySearchTree() {
        root = null;
    }
    public BinarySearchTree(Association<String, String> word) {
        root = new Node(word);
    }

 
    public void insert(Association<String, String> word) {
        root = insertRec(root, word);
    }


    public Node insertRec(Node root, Association<String, String> word){
        
        if (root == null) {
            root = new Node(word);
            return root;
        }

        if(word.getK().compareTo((String) root.word.getK())==0){
            root.word = word;
        }
        else{
            if (word.getK().compareTo((String) root.word.getK())<0)
                root.left = insertRec(root.left, word);
            else{
                root.right = insertRec(root.right, word);
            }
        }
        return root;
    }

    public void inorder() {
        inorderRec(root);
    }


    public void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.word.getK() + " = " + root.word.getV());
            inorderRec(root.right);
        }
    }


    public void deleteKey(Association<String, String> word){
        root = deleteRec(root, word);
    }

    
    public Node deleteRec(Node root, Association<String, String> word)
    {
        if (root == null)
            return root;

        if (word.getK().compareTo((String)root.word.getK())<0)
            root.left = deleteRec(root.left, word);
        else if (word.getK().compareTo((String)root.word.getK())>0)
            root.right = deleteRec(root.right, word);

        
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            word = minValue(root.right);

            root.right = deleteRec(root.right, word);
        }

        return root;
    }

   
    public Association<String, String> minValue(Node root){
        Association<String, String> minv = root.word;
        while (root.left != null)
        {
            minv = root.left.word;
            root = root.left;
        }
        return minv;
    }
  

    public String searchWithWord(String word){
        Node newNode= null;
        newNode = root;
        newNode = search(newNode, word);
        if(newNode==null){
            return "*"+word+"*";
        }
        else{
            return (String)newNode.word.getV();
        }
    }


    public Node search(Node root, String key){
        if (root==null || ((String) root.word.getK()).toUpperCase().compareTo(key.toUpperCase())==0)
            return root;
        if (((String) root.word.getK()).toUpperCase().compareTo(key.toUpperCase())<0)
        return search(root.right, key);

        return search(root.left, key);
    }
}
