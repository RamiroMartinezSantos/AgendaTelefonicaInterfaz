package IngresarContactos;

import Contactos.Contacto;

import java.util.ArrayList;
public class IngresarContactos {
    public ArrayList<Contacto> contactos;
    public IngresarContactos(){contactos = new ArrayList<>();}
    public void ingresar(ArrayList<Contacto> contactos, String nombreContacto, String direccion, String numeroTelefono,String apodo,String correo){
        contactos.add(new Contacto(nombreContacto,direccion,numeroTelefono,apodo,correo));
    }
    public ArrayList<Contacto> getContactos() {
        return contactos;
    }
}

