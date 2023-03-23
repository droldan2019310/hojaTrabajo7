package binaries;

public class BinarySearchTree  {
    
    Node root;

    BinarySearchTree() {
        root = null;
    }
    BinarySearchTree(Association<String, String> word) {
        root = new Node(word);
    }

 
    void insert(Association<String, String> word) {
        root = insertRec(root, word);
    }


    Node insertRec(Node root, Association<String, String> word){
        
        if (root == null) {
            root = new Node(word);
            return root;
        }

        if(word.getK().compareTo((String) root.palabra.getK())==0){
            root.palabra = word;
        }
        else{
            if (word.getK().compareTo((String) root.palabra.getK())<0)
                root.left = insertRec(root.left, word);
            else{
                root.right = insertRec(root.right, word);
            }
        }
        return root;
    }

    void inorder() {
        inorderRec(root);
    }


    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.palabra.getK() + "->" + root.palabra.getV());
            inorderRec(root.right);
        }
    }


    void deleteKey(Association<String, String> word){
        root = deleteRec(root, word);
    }

    
    Node deleteRec(Node root, Association<String, String> word)
    {
        if (root == null)
            return root;

        if (word.getK().compareTo((String)root.palabra.getK())<0)
            root.left = deleteRec(root.left, word);
        else if (word.getK().compareTo((String)root.palabra.getK())>0)
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

   
    Association<String, String> minValue(Node root){
        Association<String, String> minv = root.palabra;
        while (root.left != null)
        {
            minv = root.left.palabra;
            root = root.left;
        }
        return minv;
    }
  

    String translateKey(String word){
        Node newNode= null;
        newNode = root;
        newNode = search(newNode, word);
        if(newNode==null){
            return word;
        }
        else{
            return (String)newNode.palabra.getV();
        }
    }


    public Node search(Node root, String key){
        if (root==null || ((String) root.palabra.getK()).toUpperCase().compareTo(key.toUpperCase())==0)
            return root;
        if (((String) root.palabra.getK()).toUpperCase().compareTo(key.toUpperCase())<0)
        return search(root.right, key);

        return search(root.left, key);
    }
}
