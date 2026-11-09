package BaseDatos.EjercicioCompleto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String RUTA = "/BaseDatos.EjercicioCompleto/ConexionBD";
    private static String host;
    private static String port;
    private static String bd;
    private static String user;
    private static String password;
    private static boolean configuracionCargada = false;

    private static boolean cargarConfiguracion() {
        String linea;
        String[] partes;

        try (InputStream is = ConexionBD.class.getResourceAsStream(RUTA)) {
            // Validar si el archivo de recursos realmente existe
            if (is == null) {
                System.err.println("Error: No se encontró el archivo de configuración en " + RUTA);
                return false;
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                while ((linea = br.readLine()) != null) {
                    partes = linea.split(":");
                    if (partes.length != 2) {
                        continue; // Ignora líneas mal formadas o vacías
                    }
                    String clave = partes[0].trim();
                    String valor = partes[1].trim();

                    switch (clave) {
                        case "SERVER": host = valor; break;
                        case "PORT": port = valor; break;
                        case "BD": bd = valor; break;
                        case "USER": user = valor; break;
                        case "PASSWORD": password = valor; break;
                    }
                }
                return true; // Configuración cargada con éxito
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de configuración: " + e.getMessage());
            return false;
        }
    }

    public static Connection conectar(){
        Connection conexion = null;
        if(!configuracionCargada){
            cargarConfiguracion();
            configuracionCargada = true;
        }
        String cadenaConexion = "jdbc:mariadb://" + host + ":" + port + "/" + bd;
        try{
            conexion = DriverManager.getConnection(cadenaConexion, user, password);
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        return conexion;
    }

    public static void desconectar(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }


}
