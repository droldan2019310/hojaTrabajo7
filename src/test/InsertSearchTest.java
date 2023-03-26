package test;
import static org.junit.Assert.*;
import org.junit.Test;

import binaries.Association;
import binaries.BinarySearchTree;
public class InsertSearchTest {
    @Test 
    public void testInsert(){
        Association<String, String> value =  new Association<String,String> ("hello","hola");
        BinarySearchTree treeEnglish = new BinarySearchTree();
        treeEnglish.insert(value);

        assertEquals("hola",treeEnglish.searchWithWord("hello"));

    }

    @Test 
    public void testSearch(){
        BinarySearchTree treeEnglish = new BinarySearchTree();
        Association<String, String> value =  new Association<String,String> ("hello","hola");
        Association<String, String> value1 =  new Association<String,String> ("how","como");
        treeEnglish.insert(value);
        treeEnglish.insert(value1);
        assertEquals("como",treeEnglish.searchWithWord("how"));

    }

}
