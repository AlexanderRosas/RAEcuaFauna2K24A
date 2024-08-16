import UserInterface.Form.RAHormigueroVirtual;
import UserInterface.Form.RALoginWindow;
import UserInterface.Form.RASplashScreenForm;

public class App {
    public static void main(String[] args) throws Exception {
        RASplashScreenForm.show();
        Thread.sleep(3500);
        new RALoginWindow();
        
        //EN CASO DE FALLAR EL LOGIN DESCOMENTAR ESTA LINEA
        //new RAHormigueroVirtual();
    }
}
