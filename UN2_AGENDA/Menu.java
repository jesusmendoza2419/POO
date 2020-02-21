package UN2_AGENDA;

import java.io.*;

/**
 * @author JesusMendoza
 *
 */
import java.util.Scanner;
import java.util.StringTokenizer;

public class Menu {

	static AgendaTelefonica agendaTelefonica = new AgendaTelefonica();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        
		int n = 0;
       
		leerArchivo(); //LLAMA AL METODO PARA ABRIR EL ARCHIVO DE TEXTO

		while (n != 11) {
            System.out.println("---------------------------- Menu ----------------------------"
                    + "\nOpción 1: Agregar una persona."
                    + "\nOpción 2: Buscar una persona."
                    + "\nOpción 3: Eliminar una contacto."
                    + "\nOpción 4: Consultar por nombre, apellido o alias."
                    + "\nOpción 5: Consultar por telefono."
                    + "\nOpción 6: Imprimir todo el directorio."
                    + "\nOpción 7: Imprimir por tipo de telefono."
                    + "\nOpción 8: Ordenar el directorio."
                    + "\nOpción 9: Agregar un nuevo telefono."
                    + "\nOpción 10: Eliminar telefono de un contacto."
                    + "\nOpción 11: Finalizar programa..."
                    + "\n¿QUÉ OPERACIÓN DESEA REALIZAR?"
                    + "\n");
            n = scan.nextInt();
            System.out.println("--------------------------------------------------------------");

            switch (n) {
                case 1:
                	int id;
                	String nombre, apellido, alias, lada, telefono;
                	char tipo;
                	boolean esFavorito;

                    System.out.println("Teclee el nombre de la persona: ");
                    nombre = scan.next();
                    System.out.println("Teclee el apellido de la persona: ");
                    apellido = scan.next();
                    System.out.println("Teclee el alias de la persona: ");
                    alias = scan.next();
                    System.out.println("Teclee el código de país de la persona: ");
                    lada = scan.next();
                    System.out.println("Teclee el telefono de la persona: ");
                    telefono = scan.next().trim();

                    // Validar teléfono
                    if (!Telefono.comprobarCodigo(lada)) {
                    	System.out.println("No fue posible registrar el número, el codigo de pais es inválido");
                        break;
                    }
                    if (!Telefono.comprobarTelefono(telefono)) {
                        System.out.println("No fue posible registrar el número, el número de teléfono es inválido");
                        break;
                    }
                    System.out.println("Teclee el tipo de telefono de la persona: "
                            + "\nO = Oficina | C = Casa | L= CELULAR");
                    tipo = scan.next().toUpperCase().charAt(0);

                    // Se crea el teléfono con los datos ingresados
                    Telefono telefonoPersona = new Telefono(lada, telefono, tipo);

                    // Agrega si el contacto es favorito
                    System.out.println("¿Desea agregar este contacto a Favoritos?"
                            + "\nS = Si | N = No");
                    char opcion = scan.next().toUpperCase().charAt(0);
                    while (opcion != 'S' && opcion != 'N') {
                        System.out.println("Favor de ingresar una opción del menú\n");
                        System.out.println("¿Desea agregar este contacto a Favoritos?"
                                + "\nS = Si | N = No");
                        opcion = scan.next().toUpperCase().charAt(0);
                    }

                    if (opcion == 'S') {
                        esFavorito = true;
                    } else {
                        esFavorito = false;
                    }

                    // Operador ternario
                    // esFavorito = opcion == 'S' ? true : false;
                    // Se crea el Contacto con todos los atributos
                    Contacto contacto = new Contacto(nombre, apellido, alias, telefonoPersona, esFavorito);
                    
                    // Se agrega el contacto a la agenda telefonica
                    agendaTelefonica.agregar(contacto);

                    // Test para comprobar el id
                    System.out.println("El id de la persona es: " + contacto.getId());
                    break;
                case 2:
                    System.out.println("Ingrese el id de la persona: ");
                    id = scan.nextInt();
                    if (agendaTelefonica.buscarContacto(id)) {
                        System.out.println(agendaTelefonica.getContactoPos(agendaTelefonica.buscarPosicion(id)).toString());
                    } else {
                        System.out.println("No se ha encontrado a la persona.");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese id del contacto a eliminar.");
                    id = scan.nextInt();
                    if (agendaTelefonica.buscarContacto(id)) {
                        agendaTelefonica.eliminarContacto(id);
                        System.out.println("Persona eliminada");
                    } else {
                        System.out.println("No se ha encontrado a la persona.");
                    }
                    break;
                case 4:
                    System.out.println("Ingrese un criterio de busqueda (nombre, apellido o alias): ");
                    String consulta = scan.next();
                    if (!(agendaTelefonica.consultarContacto(consulta)).equals(null)) {
                        System.out.println(agendaTelefonica.consultarContacto(consulta));
                    } else {
                        System.out.println("No se encontraron resultados según los criterios de busqueda...");
                    }
                    break;
                case 5:
                    System.out.println("Ingrese telefono");
                    telefono = scan.next();
                    if (agendaTelefonica.buscarTelefono(telefono)) {
                        if (!((agendaTelefonica.consultarContactoTelefono(telefono).equals(null)))) {
                            System.out.println(agendaTelefonica.consultarContactoTelefono(telefono));
                        }
                    } else {
                        System.out.println("No se encontraron resultados según los criterios de busqueda...");
                    }
                    break;
                case 6:
                    System.out.println(agendaTelefonica.toString());
                    System.out.println("El total de contactos en la agenda es " + agendaTelefonica.totalContactos());
                    break;
                case 7:
                    System.out.println("Ingrese el tipo de telefono a buscar: ");
                    tipo = scan.next().charAt(0);
                    System.out.println(agendaTelefonica.buscarTipoTel(tipo));
                    break;
                case 8:
                    agendaTelefonica.ordenarContactos();
                    System.out.println("La agenda a sido ordenada ");
                    break;
                case 9:
                    System.out.println("Ingrese el id de la persona: ");
                    id = scan.nextInt();
                    if (agendaTelefonica.buscarContacto(id)) {
                        System.out.println("Teclee la lada de la persona: ");
                        lada = scan.next();
                        System.out.println("Teclee el telefono de la persona: ");
                        telefono = scan.next();
                        if (agendaTelefonica.buscarTelefono(telefono)) {
                            System.out.println("No es posible agregar el telefono, el numero ya ha sido registrado");
                        } else {
                            if (!Telefono.comprobarCodigo(lada) || !Telefono.comprobarTelefono(telefono)) {
                                System.out.println("No fué posible registrar el número, el codigo de pais o telefono eran erroneos");
                            } else {
                                System.out.println("Teclee el tipo de telefono de la persona: "
                                        + "\nO = Oficina | C = Casa | L= CELULAR");
                                tipo = scan.next().toUpperCase().charAt(0);
                                int pos = agendaTelefonica.buscarPosicion(id);
                                agendaTelefonica.getContactoPos(pos).agregarTelefono(new Telefono(lada, telefono, tipo));
                            }
                        }
                    } else {
                        System.out.println("No se ha encontrado ningún contacto con ese ID");
                    }
                    break;
                case 10:
                    System.out.println("Ingrese el id de la persona: ");
                    id = scan.nextInt();
                    if (agendaTelefonica.buscarContacto(id)) {
                        System.out.println("Teclee el telefono de la persona: ");
                        telefono = scan.next();
                        if (!agendaTelefonica.buscarTelefono(telefono)) {
                            System.out.println("No es posible eliminar el telefono, el numero no ha sido registrado");
                        } else {
                            int pos = agendaTelefonica.buscarPosicion(id);
                            agendaTelefonica.getContactoPos(pos).quitarTelefono(telefono);
                            System.out.println("El telefono ha sido eliminado...");
                        }
                    } else {
                        System.out.println("No se ha encontrado ningún contacto con ese ID");
                    }
                    break;
                case 11:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Opcion no valida, teclee de nuevo...");
            }
        }

    }
   
	private static void leerArchivo() {
		File archivoContactos = new File("./archivo.txt");
		FileReader rd;
		BufferedReader br;
		try {
			rd = new FileReader(archivoContactos);
			br = new BufferedReader(rd);
		
			System.out.println("Se encontró el archivo en " + archivoContactos.getAbsolutePath());
    	
			String tupla;
			StringTokenizer tokenizer;
			Contacto contactoAux;
			String nombre, apellido, alias, codigoPais, numeroTelefono;
			char tipo;
			boolean esFavorito;
			Telefono telefono;
    	
			while((tupla = br.readLine()) != null) { //lee toda la linea hasta encontrar enter
				tokenizer = new StringTokenizer(tupla); //separa la linea por espacios
				nombre = tokenizer.nextToken();
				apellido = tokenizer.nextToken();
				alias = tokenizer.nextToken();
				codigoPais = tokenizer.nextToken();
				numeroTelefono = tokenizer.nextToken();				
				tipo = tokenizer.nextToken().charAt(0);
				telefono = new Telefono(codigoPais, numeroTelefono, tipo);
		
				esFavorito = Boolean.parseBoolean(tokenizer.nextToken());
				
				contactoAux = new Contacto(nombre, apellido, alias, telefono,  esFavorito);

                // Se agrega el contacto a la agenda telefonica
                agendaTelefonica.agregar(contactoAux);
				
			}
			//LANZA LAS EXCEPCIONES
		} catch (FileNotFoundException e) {
			System.out.println("NO se encontró el archivo");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
