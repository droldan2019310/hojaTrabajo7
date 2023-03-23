package binaries;

public class Association<k,v> {
    k llave; 
    v valor; 

    public Association(){
        llave=null;
        valor = null;
    }
    public Association(k key, v value){
        llave=key;
        valor = value;
    }
    
  
    public k getK(){
        return llave;
    }
    
   
    public v getV(){
        return valor;
    }
}
