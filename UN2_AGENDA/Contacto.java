package UN2_AGENDA;

import java.util.ArrayList;
/**
 * @author jesusMendoza
 * @Ing. TIC'S
 *
 */
public class Contacto extends Persona implements Comparable<Contacto> {

    private int id;
    private boolean esFavorito;
    private ArrayList<Telefono> telefonos;
    static int idPersona = 1;

    public Contacto(String nombre, String apellido, String alias, Telefono telefono) {
        super(nombre, apellido, alias); // Mando a llamar al constructor Padre
        this.id = idPersona;
        telefonos = new ArrayList<Telefono>();
        agregarTelefono(telefono);
        idPersona++; // Incrementamos el id

    }

    public Contacto(String nombre, String apellido, String alias, Telefono telefono, boolean esFavorito) {
        this(nombre, apellido, alias, telefono); // Mando a llamar al otro constructor en esta misma clase
        this.alias = alias;
        this.esFavorito = esFavorito;
    }

    public Telefono getTelefonosPos(int pos) {
        return telefonos.get(pos);
    }

    public void setTelefonosPos(Telefono telefono, int pos) {
        this.telefonos.set(pos, telefono);
    }

    public ArrayList<Telefono> getTelefonos() {
        return telefonos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void agregarTelefono(Telefono telefono) {
        telefonos.add(telefono);
    }

    public void quitarTelefono(String telefono) {
        int pos = buscarTelefonoPos(telefono);
        if (pos != -1) {
            telefonos.remove(pos);
        }
    }
    
   
//Realizamos Polimorfismo mas personalizado al Sobreescribir el toString de Persona y el de Object

    public String toString() {
        String formato = "ID: " + Integer.toString(id) + " | Nombre: " + nombre
                + " | Apellido: " + apellido + " | Alias: " + alias + " | Favorito: "
                + (esFavorito ? "FAVORITO" : "NO FAVORITO") + " | Teléfonos: ";//Operador ternario
        for (int i = 0; i < telefonos.size(); i++) {
            formato += telefonos.get(i).getTelefono();
            // Si hay más teléfonos, pone una coma
            if ((i + 1) < telefonos.size()) {
                formato += ", ";
            }
        }
        return formato;
    }
    //metodos auxiliares

    public int buscarTelefonoPos(String tel) {
        for (int i = 0; i < telefonos.size(); i++) {
            if (telefonos.get(i).getTelefono().equals(tel)) {
                return i; // Termina de iterar y regresa la posición
            }
        }
        return -1; // Si no encontró, retorna -1
    }

    public boolean buscarTelefonoBoolean(String tel) {
        for (int i = 0; i < telefonos.size(); i++) {
            if (this.telefonos.get(i).getTelefono().equals(tel)) {
                return true;
            }
        }
        return false;
    }


    public int compareTo(Contacto contacto) {
        return nombre.compareTo(contacto.getNombre());
    }

}
