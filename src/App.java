import UserInterface.Form.RAHormigueroVirtual;
import UserInterface.Form.RASplashScreenForm;

public class App {
    public static void main(String[] args) throws Exception {
        RASplashScreenForm.show();
        Thread.sleep(7000);
        RAHormigueroVirtual frmMain = new RAHormigueroVirtual();
        frmMain.setVisible(true);
    }
}
