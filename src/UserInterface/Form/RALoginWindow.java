package UserInterface.Form;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RALoginWindow extends JFrame {
    private JTextField ratxtUsuario;
    private JPasswordField ratxtClave;

    // Usuario y clave encriptados (ejemplo)
    private final String rausuarioEncriptado = "adadd3022f543efd3ea52413c6bb490f";
    private final String raclaveEncriptada = "e10adc3949ba59abbe56e057f20f883e";

    public RALoginWindow() {
        // Configuración de la ventana
        setTitle("Login");
        setSize(350, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(3, 3));
        setLocationRelativeTo(null); // Centrar la ventana

        // Crear panel con bordes para un mejor diseño
        JPanel panelCentral = new JPanel(new GridLayout(3, 2, 10, 10));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Crear componentes
        JLabel lblUsuario = new JLabel("Usuario:");
        ratxtUsuario = new JTextField();
        JLabel lblClave = new JLabel("Clave:");
        ratxtClave = new JPasswordField();
        JButton btnIngresar = new JButton("Ingresar");

        // Añadir componentes al panel central
        panelCentral.add(lblUsuario);
        panelCentral.add(ratxtUsuario);
        panelCentral.add(lblClave);
        panelCentral.add(ratxtClave);
        add(panelCentral, BorderLayout.CENTER);

        // Crear un panel para centrar el botón
        JPanel panelBoton = new JPanel();
        panelBoton.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelBoton.add(btnIngresar);
        add(panelBoton, BorderLayout.SOUTH);

        // Acción del botón de ingreso
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = ratxtUsuario.getText();
                String clave = new String(ratxtClave.getPassword());

                // Encriptar los valores ingresados
                String usuarioEncriptadoIngresado = encriptarMD5(usuario);
                String claveEncriptadaIngresada = encriptarMD5(clave);

                // Verificar los datos
                if (rausuarioEncriptado.equals(usuarioEncriptadoIngresado) && raclaveEncriptada.equals(claveEncriptadaIngresada)) {
                   // Abrir la ventana Hormiguero Virtual
                    new RAHormigueroVirtual();
                    dispose(); // Cerrar la ventana de login
                } else {
                    // Mostrar mensaje de error y cerrar el programa
                    JOptionPane.showMessageDialog(null, "Datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0); // Cerrar el programa
                }
            }
        });

        // Mostrar la ventana de login
        setVisible(true);
    }

    // Función para encriptar usando MD5
    private String encriptarMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new RALoginWindow();
    }
}
