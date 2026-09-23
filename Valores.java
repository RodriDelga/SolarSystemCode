package sistemasolar;

public class Valores {
    boolean Open[] = new boolean[1];
     boolean Puerta;
    
    public boolean getPuerta(){
        return(Puerta);
    }
    
    public void setPuerta(boolean p){
        Open[0]=p;
        Puerta=p;
    }
    
    
    
}
