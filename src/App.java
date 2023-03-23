import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import binaries.Association;
import binaries.BinarySearchTree;

public class App {




    BinarySearchTree treeEnglish = new BinarySearchTree();
    BinarySearchTree treeFrench = new BinarySearchTree();


    public static void main(String[] args) throws Exception {
        App app = new App();
        app.start();
    }

    public void start(){
        readFile();
    }

    public void readFile(){
        File file = new File("src/dictionary.txt");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            
            String st;
            while ((st = br.readLine()) != null){
                setInTree(st);
            }
            
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("ARCHIVO NO ENCONTRADO");
        }
    }


    public void setInTree(String txt){
        String[] values = txt.split(",");

        String wordEnglish = values[0];
        String wordSpanish = values[1];
        String wordFrench = values[2];

        Association<String, String> spanishEnglish = new Association<String,String>(wordEnglish, wordSpanish);
        treeEnglish.insert(spanishEnglish);

        Association<String, String> spanishFrench = new Association<String,String>(wordFrench, wordSpanish);
        treeFrench.insert(spanishFrench);

    }



}
