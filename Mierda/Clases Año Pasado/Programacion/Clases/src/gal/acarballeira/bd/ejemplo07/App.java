package gal.acarballeira.bd.ejemplo07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

public class App {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Usuario usuarioAutenticado;
	
	public static void main(String[] args) {
	
		int opcion;
		
		inicializarAplicacion();
		
		do {
            opcion = menu();
            try {
				ejecutarOpcion(opcion);
			} catch (NumberFormatException | IOException e) {
				System.out.println("Error ejecutando opción: " + e.getMessage());
			}

        } while (opcion != 5);
		
	}
	
	private static void inicializarAplicacion() {
		Usuario usuarioDAO = new Usuario();
		
		usuarioDAO.eliminarTabla();
		usuarioDAO.crearTabla();
		
		//Creo datos de ejemplo
		usuarioDAO.save(new Usuario(0, "julio@yahoo.es", "abc123.", "Julio", LocalDate.parse("1978-04-28")));
		usuarioDAO.save(new Usuario(0, "pepe@gmail.es", "abc123.", "Pepe", LocalDate.parse("1990-05-02")));
		usuarioDAO.save(new Usuario(0, "luisa@cifpacarballeira.gal", "abc123.", "Luisa", LocalDate.parse("1996-12-14")));
		
	}

	public static int menu() {

        int opcion;
        String textoUsuario;
        
        if(usuarioAutenticado == null) {
        	textoUsuario = "( Usuario sin autenticar )";
        } else {
        	textoUsuario = "( Usuario: " + usuarioAutenticado.getNombre() + ")";
        }

        do {
            try {
                System.out.println("\n===== MENÚ ===== " + textoUsuario );
                System.out.println("1. Listar usuarios ordenados por nombre");
                System.out.println("2. Dar de alta usuario");
                System.out.println("3. Eliminar usuario");
                System.out.println("4. Login");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe introducir un número.");
                opcion = -1;
            } catch (IOException e) {
                System.out.println("Error de lectura.");
                opcion = -1;
            }
        } while (opcion < 0 || opcion > 5);

        return opcion;
    }
	
	public static void ejecutarOpcion(int opcion) throws NumberFormatException, IOException {

		Usuario usuarioDAO = new Usuario();
		
        switch (opcion) {

        case 1 -> {
        	System.out.printf("Listando usuarios ordenados por nombre: \n");
        	ArrayList<Usuario> lista = usuarioDAO.getAll();
        	for (Usuario usuario : lista) {
				System.out.println(usuario);
			}
        }

        case 2 -> {
        	System.out.printf("Dando de alta usuario\n");
        	System.out.printf("Introduzca nombre: ");
        	String nombre = br.readLine();
        	System.out.printf("Introduzca email: ");
        	String email = br.readLine();
        	System.out.printf("Introduzca password: ");
        	String contrasenha = br.readLine();
        	System.out.printf("Introduzca fecha de nacimiento (yyyy-mm-dd): ");
        	String fechaNacimiento = br.readLine();
        	usuarioDAO.save(new Usuario(0, email, contrasenha, nombre, LocalDate.parse(fechaNacimiento)));
        }

        case 3 -> {
        	System.out.printf("Eliminar usuario. Indícame el id de usuario: ");
        	int id = Integer.parseInt(br.readLine());
        	usuarioDAO.eliminarUsuario(id);
        }
        
        case 4 -> {
        	System.out.printf("Hacer Login.\nIndícame el email: ");
        	String email = br.readLine().trim();
        	System.out.printf("Indícame la contraseña: ");
        	String password = br.readLine().trim();
        	if((usuarioAutenticado = usuarioDAO.comprobarCredenciales(email, password)) != null) {
        		System.out.println("Credenciales correctas");        		
        	} else {
        		System.out.println("Credenciales incorrectas");
        	}
        }

        case 5 -> System.out.println("Saliendo de la aplicación...");

        default -> System.out.println("Opción no válida.");
        }
    }

	
}
