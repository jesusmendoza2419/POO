package UN2_AGENDA;

/**
 * @author jesusMendoza Ing. TIC'S
 *
 */
public class Telefono {

    private String codigoPais;
    private String telefono;
    private char tipo;

    public Telefono(String codigoPais, String telefono, char tipo) {
        this.codigoPais = codigoPais;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String CodigoPais) {
        codigoPais = CodigoPais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String Telefono) {
        telefono = Telefono;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    // Otros métodos
    public String toString() {
        return "Telefono: " + codigoPais + telefono + "\tTipo: " + tipo;
    }

    //Metodos auxiliares
    //Comprueba si una cadena contiene solo números
    public static boolean esUnNumero(String c) {
        for (int i = 0; i < c.length(); i++) {
            if (c.charAt(i) >= 48 && c.charAt(i) <= 57) {
                return c != null;
            }
        }
        return c != null;
    }

    //Comprueba si el codigo de pais es valido
    public static boolean comprobarCodigo(String c) {
        boolean codigoPaisC = false;
        if (esUnNumero(c) && c.length() == 2) {
            codigoPaisC = true;
        }
        return codigoPaisC;
    }

    //Comprueba si el telefono es valido
    public static boolean comprobarTelefono(String c) {
        boolean telefonoC = false;
        if (esUnNumero(c) && c.length() == 10) {
            telefonoC = true;
        }
        return telefonoC;

    }
}
