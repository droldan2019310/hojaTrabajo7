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
        readFileDictionary();
    }

    public void readFileDictionary(){
        File file = new File("src/dictionary.txt");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            
            String st;
            while ((st = br.readLine()) != null){
                setInTree(st);
            }


            showTreeInOrder();

            readFileText();
            
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

    public void showTreeInOrder(){
        System.out.println("BINARIO INGLES====================");
        treeEnglish.inorder();
        System.out.println("BINARIO FRANCES====================");
        treeFrench.inorder();
    }



    public void readFileText(){
        File file = new File("src/texto.txt");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            
            String st;
            while ((st = br.readLine()) != null){
                translate(st);
            }
            
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("ARCHIVO NO ENCONTRADO");
        }
    }


    public void translate(String string){
        String[] arraywords = string.split("\\s");
        String lineTranslated = "";
        for (String string2 : arraywords) {
            String wordTranslated = treeEnglish.searchWithWord(string2);
            if(lineTranslated.equals("")){
                lineTranslated = wordTranslated;
            }else{
                lineTranslated= lineTranslated+" "+wordTranslated;
            }
            
        }
        System.out.println("TRANSLATE: ===============");
        System.out.println(lineTranslated);
        
    }


}
