import UserInterface.Form.RAHormigueroVirtual;
import UserInterface.Form.RALoginWindow;
import UserInterface.Form.RASplashScreenForm;

//ARIEL ALEXANDER ROSAS BORJA
//CEDULA: 1728907567
//CARRERA: INGENIERIA EN SOFTWARE
//FECHA DE CREACION: 2024-08-16
//lINK DE Git : https://github.com/AlexanderRosas/RAEcuaFauna2K24A

public class App {
    public static void main(String[] args) throws Exception {
        RASplashScreenForm.show();
        Thread.sleep(3500);
        new RALoginWindow();
        
        //EN CASO DE FALLAR EL LOGIN DESCOMENTAR ESTA LINEA Y COMENTAR LA ANTERIOR
        //new RAHormigueroVirtual();
    }
}
