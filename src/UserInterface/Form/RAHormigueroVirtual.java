package UserInterface.Form;
import javax.swing.*;
import java.awt.*;

public class RAHormigueroVirtual extends JFrame {
    private JTextField txtCedula;
    private JTextField txtNombres;
    private JTable table;

    public RAHormigueroVirtual() {
        // Configurar el JFrame
        setTitle("EcuaFauna 2K24A");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10)); // Margen entre los componentes

        // Definir la fuente personalizada
        Font font = new Font("Arial", Font.PLAIN, 16);

        // Panel superior con cédula y nombres
        JPanel panelSuperior = new JPanel(new GridLayout(2, 2, 10, 10));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelSuperior.add(new JLabel("Cedula:")).setFont(font);
        txtCedula = new JTextField("1728907567");
        txtCedula.setEditable(false);
        txtCedula.setFont(font);
        panelSuperior.add(txtCedula);
        panelSuperior.add(new JLabel("Nombres:")).setFont(font);
        txtNombres = new JTextField("Ariel Alexander Rosas Borja");
        txtNombres.setEditable(false);
        txtNombres.setFont(font);
        panelSuperior.add(txtNombres);
        add(panelSuperior, BorderLayout.NORTH);

        // Panel medio con título y botón "Crear hormiga larva"
        JPanel panelMedio = new JPanel(new FlowLayout());
        panelMedio.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        JLabel lblTitulo = new JLabel("Hormiguero Virtual");
        lblTitulo.setFont(font.deriveFont(Font.BOLD, 18));
        panelMedio.add(lblTitulo);
        JButton btnCrearHormiga = new JButton("Crear hormiga larva");
        btnCrearHormiga.setFont(font);
        panelMedio.add(btnCrearHormiga);
        add(panelMedio, BorderLayout.CENTER);

        // Tabla para mostrar datos de la base de datos
        String[] columnNames = {"ID", "Nombre", "Especie", "Edad", "Ingesta", "Genotipo"};
        Object[][] data = {
            // Ejemplo de datos
            {"1", "Hormiga 1", "Especie A", "2", "Carnívoro", "X"},
            {"2", "Hormiga 2", "Especie B", "3", "Herbívoro", "XX"}
        };
        table = new JTable(data, columnNames);
        table.setFont(font);
        table.setRowHeight(24); // Altura de las filas
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        add(scrollPane, BorderLayout.SOUTH);

        // Panel inferior con botones y listas desplegables
        JPanel panelInferior = new JPanel(new GridLayout(3, 2, 10, 10));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

        // IngestaNativa
        JComboBox<String> cbIngestaNativa = new JComboBox<>(new String[]{"Carnívoro", "Herbívoro", "Omnívoro", "Insectívoros"});
        cbIngestaNativa.setFont(font);
        JButton btnIngestaNativa = new JButton("Alimentar con Ingesta Nativa");
        btnIngestaNativa.setFont(font);
        panelInferior.add(cbIngestaNativa);
        panelInferior.add(btnIngestaNativa);

        // GenoAlimento
        JComboBox<String> cbGenoAlimento = new JComboBox<>(new String[]{"X", "XX", "XY"});
        cbGenoAlimento.setFont(font);
        JButton btnGenoAlimento = new JButton("Alimentar con Geno-Alimento");
        btnGenoAlimento.setFont(font);
        panelInferior.add(cbGenoAlimento);
        panelInferior.add(btnGenoAlimento);

        // Botones Guardar y Eliminar
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(font);
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setFont(font);
        panelInferior.add(btnGuardar);
        panelInferior.add(btnEliminar);

        add(panelInferior, BorderLayout.SOUTH);

        // Mostrar el JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        new RAHormigueroVirtual();
    }
}
