package UserInterface.Form;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RAHormigueroVirtual extends JFrame {

    private JTextField txtCedula;
    private JTextField txtNombres;
    private JButton btnCrearHormigaLarva;
    private JTable tabla;
    private JComboBox<String> comboIngestaNativa;
    private JComboBox<String> comboGenoAlimento;
    private JButton btnAlimentarIngestaNativa;
    private JButton btnAlimentarGenoAlimento;
    private JButton btnGuardar;
    private JButton btnEliminar;
    private int ultimoSecuencial = 0;

    public RAHormigueroVirtual() {
        // Configuración básica de la ventana
        setTitle("Hormiguero Virtual");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear e inicializar componentes
        initComponents();

        // Agregar ActionListener al botón "Crear Hormiga Larva"
        btnCrearHormigaLarva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearHormigaLarva();
            }
        });

        // Tamaño de la ventana y hacerla visible
        setSize(600, 400);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true);
    }

    private void initComponents() {
        // Panel superior con datos quemados
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new GridLayout(2, 2, 5, 5));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelSuperior.add(new JLabel("Cédula:"));
        txtCedula = new JTextField("1728907567");
        txtCedula.setEditable(false);
        panelSuperior.add(txtCedula);

        panelSuperior.add(new JLabel("Nombres:"));
        txtNombres = new JTextField("Ariel Alexander Rosas Borja");
        txtNombres.setEditable(false);
        panelSuperior.add(txtNombres);

        add(panelSuperior, BorderLayout.NORTH);

        // Panel central con la tabla y botones
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout(10, 10));

        JLabel lblTitulo = new JLabel("Hormiguero Virtual", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        panelCentral.add(lblTitulo, BorderLayout.NORTH);

        btnCrearHormigaLarva = new JButton("Crear Hormiga Larva");
        panelCentral.add(btnCrearHormigaLarva, BorderLayout.SOUTH);

        // Configuración de la tabla
        String[] columnNames = {"RegNro", "TipoHormiga", "Ubicación", "Sexo","GenoAlimento","IngestaNativa", "Estado"};
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, columnNames);
        tabla = new JTable(model);
        tabla.setRowHeight(20); // Ajuste de altura de las filas
        tabla.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente más grande

        JScrollPane scrollPane = new JScrollPane(tabla);
        panelCentral.add(scrollPane, BorderLayout.CENTER);

        add(panelCentral, BorderLayout.CENTER);

        // Panel inferior con opciones de alimentación y botones
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado entre componentes

        // Añadir componentes al panel inferior
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelInferior.add(new JLabel("Ingesta Nativa:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        comboIngestaNativa = new JComboBox<>(new String[]{"Carnívoro", "Herbívoro", "Omnívoro", "Insectívoros"});
        panelInferior.add(comboIngestaNativa, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        btnAlimentarIngestaNativa = new JButton("Alimentar con Ingesta Nativa");
        panelInferior.add(btnAlimentarIngestaNativa, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelInferior.add(new JLabel("Geno Alimento:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        comboGenoAlimento = new JComboBox<>(new String[]{"X", "XX", "XY"});
        panelInferior.add(comboGenoAlimento, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        btnAlimentarGenoAlimento = new JButton("Alimentar con GenoAlimento");
        panelInferior.add(btnAlimentarGenoAlimento, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Ocupa dos columnas
        btnGuardar = new JButton("Guardar");
        panelInferior.add(btnGuardar, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        btnEliminar = new JButton("Eliminar");
        panelInferior.add(btnEliminar, gbc);

        add(panelInferior, BorderLayout.SOUTH);
    }

    private void crearHormigaLarva() {
        int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de crear una Hormiga larva?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            int rasecuencial = obtenerNuevoSecuencial();
            String[] provincias = { "Azuay", "Bolívar", "Cañar", "Carchi", "Chimborazo", "Cotopaxi", "El Oro", "Esmeraldas", "Galápagos", 
                                    "Guayas", "Imbabura", "Loja", "Los Ríos", "Manabí", "Morona Santiago", "Napo", "Orellana", "Pastaza", 
                                    "Pichincha", "Santa Elena", "Santo Domingo de los Tsáchilas", "Sucumbíos", "Tungurahua", "Zamora Chinchipe" };
            Random rarandom = new Random();
            String raubicacion = provincias[rarandom.nextInt(provincias.length)];
            String rahormiga = "larva";
            String ragenoAlimento= " ";
            String raingestaNativa = " ";
            String sexo = "Asexual";
            String raestado = "VIVA";

            Object[] nuevoRegistro = { rasecuencial, rahormiga, raubicacion, sexo, ragenoAlimento,raingestaNativa , raestado };
            agregarRegistroATabla(nuevoRegistro);
        }
    }

    private int obtenerNuevoSecuencial() {
        return (++ultimoSecuencial); // Incrementa el rasecuencial
    }

    private void agregarRegistroATabla(Object[] registro) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.addRow(registro);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RAHormigueroVirtual().setVisible(true);
        });
    }
}
