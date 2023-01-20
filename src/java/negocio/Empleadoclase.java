
package negocio;

public class Empleadoclase {
    String dni,nombre,usuario,contra;

    public Empleadoclase(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public Empleadoclase(String dni, String nombre, String usuario, String contra) {
        this.dni = dni;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contra = contra;
    }
    
    public Empleadoclase() {
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
}
