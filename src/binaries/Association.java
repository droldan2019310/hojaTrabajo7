package binaries;

public class Association<k,v> {
    k llave; 
    v valor; 

    Association(){
        llave=null;
        valor = null;
    }
    Association(k key, v value){
        llave=key;
        valor = value;
    }
    
  
    k getK(){
        return llave;
    }
    
   
    v getV(){
        return valor;
    }
}
