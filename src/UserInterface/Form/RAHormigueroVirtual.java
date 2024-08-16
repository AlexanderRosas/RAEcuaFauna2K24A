package UserInterface.Form;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DataAccess.SQLiteDataHelper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;


public class RAHormigueroVirtual extends JFrame {

    private JTextField ratxtCedula;
    private JTextField ratxtNombres;
    private JButton rabtnCrearHormigaLarva;
    private JTable ratabla;
    private JComboBox<String> racomboIngestaNativa;
    private JComboBox<String> racomboGenoAlimento;
    private JButton rabtnAlimentarIngestaNativa;
    private JButton rabtnAlimentarGenoAlimento;
    private JButton rabtnGuardar;
    private JButton rabtnEliminar;
    private int raultimoSecuencial = 0;

    public RAHormigueroVirtual() {
        // Configuración básica de la ventana
        setTitle("Hormiguero Virtual");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear e inicializar componentes
        initComponents();

        // Agregar ActionListener al botón "Crear Hormiga Larva"
        rabtnCrearHormigaLarva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearHormigaLarva();
            }
        });

        rabtnAlimentarGenoAlimento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alimentarConGenoAlimento();
            }
        });

        rabtnAlimentarIngestaNativa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alimentarConIngestaNativa();
            }
        });

        rabtnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarRegistro();
            }
        });

        rabtnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
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
        ratxtCedula = new JTextField("1728907567");
        ratxtCedula.setEditable(false);
        panelSuperior.add(ratxtCedula);

        panelSuperior.add(new JLabel("Nombres:"));
        ratxtNombres = new JTextField("Ariel Alexander Rosas Borja");
        ratxtNombres.setEditable(false);
        panelSuperior.add(ratxtNombres);

        add(panelSuperior, BorderLayout.NORTH);

        // Panel central con la ratabla y botones
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout(10, 10));

        JLabel lblTitulo = new JLabel("Hormiguero Virtual", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        panelCentral.add(lblTitulo, BorderLayout.NORTH);

        rabtnCrearHormigaLarva = new JButton("Crear Hormiga Larva");
        panelCentral.add(rabtnCrearHormigaLarva, BorderLayout.SOUTH);

        // Configuración de la ratabla
        String[] columnNames = {"RegNro", "TipoHormiga", "Ubicación", "Sexo","GenoAlimento","IngestaNativa", "Estado"};
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, columnNames);
        ratabla = new JTable(model);
        ratabla.setRowHeight(20); // Ajuste de altura de las filas
        ratabla.setFont(new Font("Arial", Font.PLAIN, 14)); // Fuente más grande

        JScrollPane scrollPane = new JScrollPane(ratabla);
        panelCentral.add(scrollPane, BorderLayout.CENTER);

        add(panelCentral, BorderLayout.CENTER);

        // Panel inferior con opciones de alimentación y botones
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado entre componentes

        // Añadir componentes al panel inferior
        // Sección de Geno Alimento
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1; // Reestablecer el ancho de la celda
        panelInferior.add(new JLabel("Geno Alimento:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        racomboGenoAlimento = new JComboBox<>(new String[]{"X", "XX", "XY"});
        panelInferior.add(racomboGenoAlimento, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        rabtnAlimentarGenoAlimento = new JButton("Alimentar con GenoAlimento");
        panelInferior.add(rabtnAlimentarGenoAlimento, gbc);

        // Sección de Ingesta Nativa
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelInferior.add(new JLabel("Ingesta Nativa:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        racomboIngestaNativa = new JComboBox<>(new String[]{"Carnívoro", "Herbívoro", "Omnívoro", "Insectívoros"});
        panelInferior.add(racomboIngestaNativa, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        rabtnAlimentarIngestaNativa = new JButton("Alimentar con Ingesta Nativa");
        panelInferior.add(rabtnAlimentarIngestaNativa, gbc);

        // Botones de Guardar y Eliminar
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1; // Ancho de una celda
        rabtnEliminar = new JButton("Eliminar");
        panelInferior.add(rabtnEliminar, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Ocupa dos columnas
        rabtnGuardar = new JButton("Guardar");
        panelInferior.add(rabtnGuardar, gbc);

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
            String GenoAlimento= null;
            String IngestaNativa = null;
            String sexo = "Asexual";
            String raestado = "VIVA";

            Object[] nuevoRegistro = { rasecuencial, rahormiga, raubicacion, sexo, GenoAlimento,IngestaNativa , raestado };
            agregarRegistroATabla(nuevoRegistro);
        }
    }

    private int obtenerNuevoSecuencial() {
        return (++raultimoSecuencial); // Incrementa el rasecuencial
    }

    private void agregarRegistroATabla(Object[] registro) {
        DefaultTableModel model = (DefaultTableModel) ratabla.getModel();
        model.addRow(registro);
    }
    private void alimentarConGenoAlimento() {
        int filaSeleccionada = ratabla.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String genoAlimentoSeleccionado = (String) racomboGenoAlimento.getSelectedItem();
            DefaultTableModel model = (DefaultTableModel) ratabla.getModel();
            String estado = (String) model.getValueAt(filaSeleccionada, 6); // Obtener estado actual
    
            // Caso de estudio: Cambios basados en el GenoAlimento y estado
            if (genoAlimentoSeleccionado.equals("XY") && estado.equals("VIVA")) {
                model.setValueAt("Zangano", filaSeleccionada, 1); // Cambiar TipoHormiga a "Zangano"
                model.setValueAt(genoAlimentoSeleccionado, filaSeleccionada, 4); // Cambiar TipoHormiga a "Zangano"
                model.setValueAt("Macho", filaSeleccionada, 3);    // Cambiar Sexo a "Macho"
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila en la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void alimentarConIngestaNativa() {
        int filaSeleccionada = ratabla.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String ingestaNativaSeleccionada = (String) racomboIngestaNativa.getSelectedItem();
            DefaultTableModel model = (DefaultTableModel) ratabla.getModel();
            String estadoActual = (String) model.getValueAt(filaSeleccionada, 4); // Obtener estado actual
    
            if (ingestaNativaSeleccionada.equals("Omnívoro") || ingestaNativaSeleccionada.equals("Carnívoro") || ingestaNativaSeleccionada.equals("Herbívoro")) {
                model.setValueAt(ingestaNativaSeleccionada, filaSeleccionada, 5); // Cambiar IngestaNativa
            } else {
                model.setValueAt("Muerta", filaSeleccionada, 6);  // Cambiar Estado a "Muerta"
                model.setValueAt(ingestaNativaSeleccionada, filaSeleccionada, 5); // Cambiar IngestaNativa
               
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila en la ratabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        
    }
    private void eliminarRegistro() {
        int filaSeleccionada = ratabla.getSelectedRow();
        if (filaSeleccionada >= 0) {
            String tipoHormiga = (String) ratabla.getValueAt(filaSeleccionada, 1); // Obtener el TipoHormiga de la fila seleccionada
    
            int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar la " + tipoHormiga + "?", "Confirmación", JOptionPane.YES_NO_OPTION);
    
            if (opcion == JOptionPane.YES_OPTION) {
                DefaultTableModel model = (DefaultTableModel) ratabla.getModel();
                model.removeRow(filaSeleccionada); // Eliminar la fila de la ratabla
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila en la ratabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void guardarDatos() {
        int opcion = JOptionPane.showConfirmDialog(this, "¿Está seguro de guardar todo el hormiguero en la base de datos?", "Confirmación", JOptionPane.YES_NO_OPTION);
    
        if (opcion == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) ratabla.getModel();
            Connection connection = null;
            PreparedStatement pstmt = null;
    
            try {
                // Abrir conexión a la base de datos usando SQLiteDataHelper
                connection = SQLiteDataHelper.openConnection();
                
                // Preparar la consulta SQL para insertar datos
                String sql = "INSERT INTO RAHormigueroVirtual (IdHormiga, TipoHormiga, Ubicacion, Sexo, GenoAlimento, IngestaNativa, Estado, FechaCreacion) VALUES (?, ?, ?, ?, ?, ?, ?, datetime('now','localtime'))";
                pstmt = connection.prepareStatement(sql);
    
                // Iterar sobre las filas de la ratabla y guardar los datos
                for (int i = 0; i < model.getRowCount(); i++) {
                    pstmt.setInt(1, (Integer) model.getValueAt(i, 0)); // IdHormiga
                    pstmt.setString(2, (String) model.getValueAt(i, 1)); // TipoHormiga
                    pstmt.setString(3, (String) model.getValueAt(i, 2)); // Ubicacion
                    pstmt.setString(4, (String) model.getValueAt(i, 3)); // Sexo
                    pstmt.setString(5, (String) model.getValueAt(i, 4)); // GenoAlimento
                    pstmt.setString(6, (String) model.getValueAt(i, 5)); // IngestaNativa
                    pstmt.setString(7, (String) model.getValueAt(i, 6)); // Estado
                    
                    pstmt.addBatch(); // Agregar al batch
                }
    
                pstmt.executeBatch(); // Ejecutar el batch
                JOptionPane.showMessageDialog(this, "Datos guardados exitosamente en la base de datos.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar los datos en la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error inesperado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    if (pstmt != null) pstmt.close();
                    SQLiteDataHelper.closeConnection(); // Cerrar la conexión usando SQLiteDataHelper
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RAHormigueroVirtual().setVisible(true);
        });
    }
}
