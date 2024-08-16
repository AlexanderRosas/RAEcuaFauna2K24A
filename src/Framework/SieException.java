package Framework;

public class SieException extends Exception {
    String e;
    public SieException(String error, String clase, String metodo) {
        //grabar el log
        e = error;
        System.out.println("[ERROR APP --> LOG] " + clase +"."+ metodo +" : "+ e );
        System.out.println("Solo puede ingresar dos nombres");
    }

    @Override 
    public String getMessage(){
        return e;
    }    
}
