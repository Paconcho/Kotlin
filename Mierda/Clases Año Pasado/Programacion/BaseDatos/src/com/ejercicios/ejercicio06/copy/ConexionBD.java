package com.ejercicios.ejercicio06.copy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String RUTA = "/com/ejercicios/sources/datosConexion";
    private static String host;
    private static String port;
    private static String bd;
    private static String user;
    private static String password;
    private static boolean configuracionCargada = false;

    private static void cargarConfiguracion() {
        String linea;
        String[] partes;

        InputStream is = ConexionBD.class.getResourceAsStream(RUTA);
        if (is == null) {
            System.out.println("Error: No se encontró el archivo de configuración en " + RUTA);
            return;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((linea = br.readLine()) != null) {
                partes = linea.split(":");
                if (partes.length != 2) {
                    continue;
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
        } catch (IOException e) {
            System.out.println("Error leyendo configuración de conexión: " + e.getMessage());
        }
    }

    public static Connection conectar() {
        Connection conexion = null; 
        if (!configuracionCargada) {
            cargarConfiguracion();
            configuracionCargada = true;
        }

        if (host == null || port == null || bd == null) {
            System.out.println("Error: Datos de conexión incompletos. Revisa el archivo de configuración.");
            return null;
        }

        String cadenaConexion = "jdbc:mariadb://" + host + ":" + port + "/" + bd;
        try {
            conexion = DriverManager.getConnection(cadenaConexion, user, password);
        } catch (SQLException e) {
            System.out.println("Error conectando con base de datos: " + e.getMessage());
        }
        return conexion;
    }

    public static void desconectar(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Error desconectando de base de datos: " + e.getMessage());
        }
    }
}