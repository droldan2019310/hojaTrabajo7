package binaries;

public class Association<k,v> {
    k key; 
    v value; 

    public Association(){
        key=null;
        value = null;
    }
    public Association(k key, v value){
        this.key=key;
        this.value = value;
    }
    
  
    public k getK(){
        return key;
    }
    
   
    public v getV(){
        return value;
    }
}
