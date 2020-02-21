package UN2_AGENDA;

/**
 * @author jesusMendoza
 *
 */
import java.util.*;

public class AgendaTelefonica {

	private ArrayList<Contacto> contactos = new ArrayList<Contacto>();

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}

	public Contacto getContactoPos(int pos) {
		return contactos.get(pos);
	}

	//otros metodos
	public void agregar(Persona persona) {
		contactos.add((Contacto) persona);
	}

	public void agregar(Contacto contacto) {
		contactos.add(contacto);
	}




	//elimina persona con id asignado 
	public void eliminarContacto(int id) {
		int pos = buscarPosicion(id);
		if (buscarContacto(id)) {
			contactos.remove(pos);
		}
	}

	public String consultarContacto(String nombrePersona) {
		String coincidencias = "";
		for (int i = 0; i < contactos.size(); i++) {
			if (contactos.get(i).getNombre().equals(nombrePersona) || contactos.get(i).getApellido().equals(nombrePersona) || contactos.get(i).getAlias().equals(nombrePersona)) {
				coincidencias += contactos.get(i).toString() + "\n";
			}
		}
		return coincidencias;
	}

	public String consultarContactoTelefono(String telefono) {
		if (buscarTelefono(telefono)) {
			return contactos.get(buscarPosTelefono(telefono)).toString();
		}
		return null;
	}

	public void ordenarContactos() {
		Collections.sort(contactos);
	}

	public String toString() {
		String directorio = "";
		for (int i = 0; i < contactos.size(); i++) {
			directorio += contactos.get(i).toString() + "\n";
		}
		return "Contactos: \n" + directorio;

	}

	public String buscarTipoTel(char tipo) {
		String coincidencias = " ";
		for (int i = 0; i < contactos.size(); i++) {
			for (int j = 0; j < contactos.get(i).getTelefonos().size(); j++) {
				if (contactos.get(i).getTelefonosPos(j).getTipo() == tipo) {
					coincidencias += contactos.get(i).getTelefonosPos(j).toString() + "\n";
				}
			}
		}
		return coincidencias;
	}

	//metodos auxiliares
	public boolean buscarContacto(int id) {
		boolean personab = false;
		for (int i = 0; i < contactos.size(); i++) {
			if (contactos.get(i).getId() == id) {
				personab = true;

			}
		}
		return personab;
	}


	/*
public boolean equals (Object o) {
	boolean personab= false;
	if (o instanceof Persona) {
		Persona p1 = (Persona )o;
	}
	return personab;
}
	 */


	public int buscarPosicion(int idp) {
		int pos = -1;
		for (int i = 0; i < contactos.size(); i++) {
			if (contactos.get(i).getId() == idp) {
				pos = i;
			}
		}
		return pos;
	}

	public boolean buscarTelefono(String telefono) {
		boolean r = false;
		for (int i = 0; i < contactos.size(); i++) {
			if (contactos.get(i).buscarTelefonoBoolean(telefono)) {
				r = true;
				break;
			}
		}
		return r;
	}

	public int buscarPosTelefono(String telefono) {
		int pos = -1;
		for (int i = 0; i < contactos.size(); i++) {
			if (contactos.get(i).buscarTelefonoBoolean(telefono)) {
				pos = i;
				break;
			}
		}
		return pos;
	}

	//TotaldeContactos
	public int totalContactos() {
		int total = 0;
		for (int i = 0; i < contactos.size(); i++) {
			if (contactos.get(i) != null) {
				total++;
			}
		}
		return total;
	}

}

