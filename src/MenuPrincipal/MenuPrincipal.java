package MenuPrincipal;

import Contactos.Contacto;
import IngresarContactos.IngresarContactos;
import MostrarContactos.Mostrar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuPrincipal extends JFrame{
    IngresarContactos ingresarContactos = new IngresarContactos();
    private static ArrayList<Contacto> lista = new ArrayList<>();
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton guardarButton;
    private JButton consultarButton;
    public MenuPrincipal(){
    configFrame();
    }
    private void configFrame(){
        setTitle("Tabla de usuarios");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(400, 300);
        query();
        addActionListeners();
        add(panel1);
    }

    private void addActionListeners(){
        guardarButton.addActionListener(new EventClick());
    }

    public class EventClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            String opcion = boton.getText();

            if (opcion.equals("Guardar")) {
                String nombreContacto = textField1.getText();
                String direccion = textField2.getText();
                String numeroTelefono = textField3.getText();
                String apodo = textField4.getText();
                String correo = textField5.getText();

                lista.add(new Contacto(nombreContacto, direccion, numeroTelefono, apodo, correo));

                ingresarContactos.ingresar(ingresarContactos.getContactos(), nombreContacto, direccion, numeroTelefono, apodo, correo);

                textField1.setText(" ");
                textField2.setText(" ");
                textField3.setText(" ");
                textField4.setText(" ");
                textField5.setText(" ");
            }
        }
    }

    private void query(){
        consultarButton.addActionListener(e -> {
            Mostrar mostrar = new Mostrar();
            mostrar.setVisible(true);
            this.setVisible(false);
        });
    }

    public static ArrayList<Contacto> getElemento(){
        return lista;
    }
}
