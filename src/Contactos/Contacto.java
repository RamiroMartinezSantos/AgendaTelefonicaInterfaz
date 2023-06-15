package Contactos;
    public class Contacto {
        public String nombreContacto;
        public String direccion;
        public String numeroTelefono;
        public String apodo;
        public String correo;

        public Contacto(String nombreContacto,String direccion, String numeroTelefono, String apodo, String correo) {
            this.nombreContacto = nombreContacto;
            this.numeroTelefono = numeroTelefono;
            this.apodo = apodo;
            this.correo = correo;
            this.direccion = direccion;
        }

        @Override
        public String toString() {
            return "nombre: " + nombreContacto + "Direccion" + direccion + "Telefono: " + numeroTelefono + "Apodo: " + apodo + "Correo" + correo;
        }

        public String getNombreContacto() {
            return nombreContacto;
        }

        public String getDireccion() {
            return direccion;
        }

        public String getNumeroTelefono() {
            return numeroTelefono;
        }

        public String getApodo() {
            return apodo;
        }

        public String getCorreo() {
            return correo;
        }
    }

