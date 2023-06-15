package MostrarContactos;
        import Contactos.Contacto;
        import Contactos.Titulos;
        import MenuPrincipal.MenuPrincipal;

        import javax.swing.*;
        import javax.swing.JFrame;
        import javax.swing.table.DefaultTableModel;
        import java.awt.*;
        import java.util.ArrayList;

public class Mostrar extends JFrame {
    private JTable jTable;
    private JPanel panelContainer, panelButton;
    private JButton btnQuery;
    private DefaultTableModel modelo;

    public Mostrar (){
        initControl();
        configTable();
        setControl();
        configPanel();
        configFrame();
        query();
        add(panelContainer);
    }
    private void query(){
        btnQuery.addActionListener(e -> {
            MenuPrincipal menuPrincipal = new MenuPrincipal();
            menuPrincipal.setVisible(true);
            this.setVisible(false);
        });
    }

    private void initControl(){

        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(Titulos.contactos);
        String [] fila = new String[modelo.getColumnCount()];
        ArrayList<Contacto> lista = MenuPrincipal.getElemento();
        for (Contacto userTable : lista) {
            fila[0] = userTable.getNombreContacto();
            fila[1] = userTable.getDireccion();
            fila[2] = userTable.getNumeroTelefono();
            fila[3] = userTable.getApodo();
            fila[4] = userTable.getCorreo();
            modelo.addRow(fila);
        }

        panelButton = new JPanel();
        panelContainer = new JPanel();
        btnQuery = new JButton();
        jTable = new JTable(modelo);
    }

    private void setControl(){
        btnQuery.setText("Regresar");
    }
    private void configPanel(){

        panelButton.setLayout(new FlowLayout());
        panelButton.setPreferredSize(new Dimension(150, 50));
        panelButton.add(btnQuery);

        panelContainer.setLayout(new GridLayout(4, 0));
        panelContainer.add(panelButton);

        add(panelContainer);
    }

    private void configFrame(){
        setTitle("Tabla de usuarios");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(600, 200);
    }

    private void configTable(){
        jTable.setGridColor(new Color(88, 214, 141));
        jTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
        JScrollPane scrollPane = new JScrollPane(jTable);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }
}
