package UN2_AGENDA;

/**
 * @author jesusMendoza Ing. TIC'S
 *
 */
public class Persona {

    protected String nombre;
    protected String apellido;
    protected String alias;

    public Persona(String nombre, String apellido, String alias) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.alias = alias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        nombre = Nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String Apellido) {
        apellido = Apellido;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
//Al sobreescribir el toString de Object realizamos polimorfismo de inclusion
    
    public String toString() {
        return  nombre +  apellido + alias;
    }
}
