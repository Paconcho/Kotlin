package com.ejercicios.ejercicio06.copy;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Arbol {
    private int id;
    private int altura;
    private String nombre;
    private LocalDate fechaPlantacion;
    
    public Arbol(int id, int altura, String nombre, LocalDate fechaPlantacion) {
        this.id = id;
        this.altura = altura;
        this.nombre = nombre;
        this.fechaPlantacion = fechaPlantacion;
    }
    
    public Arbol() {        
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getAltura() { return altura; }
    public void setAltura(int altura) { this.altura = altura; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public LocalDate getFechaPlantacion() { return fechaPlantacion; }
    public void setFechaPlantacion(LocalDate fechaPlantacion) { this.fechaPlantacion = fechaPlantacion; }

    @Override
    public String toString() {
        String fechaStr = (fechaPlantacion != null) ? fechaPlantacion.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "No asignada";
        return String.format("Código: %d. Nombre: %s. Altura: %d m. Plantado en: %s", 
                this.id, this.nombre, this.altura, fechaStr);
    }

    public void crearTabla() {
        Connection con = ConexionBD.conectar();
        if (con == null) return;
        try {
            String sql = """
                    CREATE TABLE IF NOT EXISTS arbol(
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        altura INT NOT NULL,
                        nombre VARCHAR(30) NOT NULL,
                        fecha_plantacion DATE NULL
                    )
                    """;
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error en CrearTabla: " + e.getMessage());
        } finally {
            ConexionBD.desconectar(con);
        }
    }
    
    public void eliminarTabla() {
        Connection con = ConexionBD.conectar();
        if (con == null) return;
        try {
            String sql = "DROP TABLE IF EXISTS arbol";
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Error en EliminarTabla: " + e.getMessage());
        } finally {
            ConexionBD.desconectar(con);
        }
    }
    
    public void saveTree(Arbol arbol) {
        Connection con = ConexionBD.conectar();
        if (con == null) return;
        try {
            String sql = """
                    INSERT INTO arbol(altura, nombre, fecha_plantacion)
                    VALUES(?, ?, ?)
                    """;
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, arbol.getAltura());
            st.setString(2, arbol.getNombre());
            
            if (arbol.getFechaPlantacion() != null) {
                st.setDate(3, Date.valueOf(arbol.getFechaPlantacion()));
            } else {
                st.setNull(3, Types.DATE);
            }
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en saveTree: " + e.getMessage());
        } finally {
            ConexionBD.desconectar(con);
        }
    }
    
    public ArrayList<Arbol> getAll() {
        Connection con = ConexionBD.conectar();
        ArrayList<Arbol> lista = new ArrayList<>();
        if (con == null) return lista;
        try {
            String sql = """
                    SELECT id, altura, nombre, fecha_plantacion
                    FROM arbol
                    ORDER BY nombre
                    """;
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Arbol a = new Arbol();
                a.setId(rs.getInt("id"));
                a.setNombre(rs.getString("nombre"));
                a.setAltura(rs.getInt("altura"));
                Date fecha = rs.getDate("fecha_plantacion");
                if(fecha != null) {
                    a.setFechaPlantacion(fecha.toLocalDate());
                }
                lista.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Error en GetAll: " + e.getMessage());
        } finally {
            ConexionBD.desconectar(con);
        }
        return lista;
    }

    public void deleteByAlturaMenorQue(int altura) {
        Connection con = ConexionBD.conectar();
        if (con == null) return;
        try {
            String sql = "DELETE FROM arbol WHERE altura < ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, altura);            
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en deleteByAlturaMenorQue: " + e.getMessage());
        } finally {
            ConexionBD.desconectar(con);
        }
    }

    public List<Arbol> getByNombreEmpiezaPor(String comienzo) {
        Connection con = ConexionBD.conectar();
        ArrayList<Arbol> lista = new ArrayList<>();
        if (con == null) return lista;
        try {
            String sql = """
                    SELECT id, altura, nombre, fecha_plantacion
                    FROM arbol
                    WHERE nombre LIKE ?
                    ORDER BY nombre
                    """;
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, comienzo + "%");
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Arbol a = new Arbol();
                a.setId(rs.getInt("id"));
                a.setNombre(rs.getString("nombre"));
                a.setAltura(rs.getInt("altura"));
                Date fecha = rs.getDate("fecha_plantacion");
                if(fecha != null) {
                    a.setFechaPlantacion(fecha.toLocalDate());
                }
                lista.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Error en getByNombreEmpiezaPor: " + e.getMessage());
        } finally {
            ConexionBD.desconectar(con);
        }
        return lista;
    }
}