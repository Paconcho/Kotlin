package gal.acarballeira.bd.ejemplo07;

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

public class Usuario {
	private int id;
	private String email;
	private String password;
	private String nombre;
	private LocalDate fechaNacimiento;
	
	

	public Usuario(int id, String email, String password, String nombre, LocalDate fechaNacimiento) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Usuario() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return String.format("Código: %d. Nombre: %s. E-mail: %s m. Nacido en: %s", 
				this.id, 				
				this.nombre,
				this.email, 
				fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}

	public void crearTabla() {
		
		Connection con = ConexionBD.conectar();
		String sql;
		
		//""" indica text-block
		try {
			sql = """
					CREATE TABLE IF NOT EXISTS usuario(
								id INT AUTO_INCREMENT PRIMARY KEY,
								email VARCHAR(100) NOT NULL,
								password VARCHAR(100) NOT NULL,
								nombre VARCHAR(100) NOT NULL,
								fechaNacimiento DATE NULL
								 )
					""";
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			ConexionBD.desconectar(con);
		} catch (SQLException e) {
			System.out.println("Error en CrearTabla: " + e.getMessage());
			
		}
		
	}
	
	public void eliminarTabla() {
		Connection con = ConexionBD.conectar();
		String sql;
		
		//""" indica text-block
		try {
			sql = """
					DROP TABLE IF EXISTS usuario
					""";
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			ConexionBD.desconectar(con);
		} catch (SQLException e) {
			System.out.println("Error en EliminarTabla: " + e.getMessage());
			
		}
		
	}
	
	public void save(Usuario usuario) {
		
		Connection con = ConexionBD.conectar();
		String sql;
		
		try {
			sql = """
					INSERT INTO usuario(email, password, nombre, fechaNacimiento)
					VALUES(?, ?, ?, ?)
					""";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, usuario.getEmail());
			st.setString(2, usuario.getPassword());
			st.setString(3, usuario.getNombre());			
			
			//st.setDate(3, Date.valueOf(arbol.getFechaPlantacion()));
			if (usuario.getFechaNacimiento() != null) {
	            st.setDate(4, Date.valueOf(usuario.getFechaNacimiento()));
	        } else {
	            st.setNull(4, Types.DATE);
	        }
			
			st.executeUpdate();
			ConexionBD.desconectar(con);
		} catch (SQLException e) {
			System.out.println("Error en saveTree: " + e.getMessage());
			
		}
		
	}
	
	public ArrayList<Usuario> getAll() {
		
		Connection con = ConexionBD.conectar();
		String sql;
		ArrayList<Usuario> lista = new ArrayList();
		Usuario a;
		
		try {
			sql = """
					SELECT id, nombre, email, fechaNacimiento
					FROM usuario
					ORDER BY nombre
					""";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				a = new Usuario();
				a.setId(rs.getInt("id"));
				a.setNombre(rs.getString("nombre"));
				a.setEmail(rs.getString("email"));
				Date fecha = rs.getDate("fechaNacimiento");
				if(fecha != null) {
					a.setFechaNacimiento(fecha.toLocalDate());
				}
				
				lista.add(a);
			}
			
			ConexionBD.desconectar(con);
		} catch (SQLException e) {
			System.out.println("Error en GetAll: " + e.getMessage());
			
		}
		return lista;
		
	}

	public Usuario get(int id) {
		
		Connection con = ConexionBD.conectar();
		String sql;
		Usuario usuario = null;
		
		try {
			sql = """
					SELECT id, nombre, email, fechaNacimiento
					FROM usuario
					WHERE id = ?
					ORDER BY nombre
					""";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setEmail(rs.getString("email"));
				Date fecha = rs.getDate("fechaNacimiento");
				if(fecha != null) {
					usuario.setFechaNacimiento(fecha.toLocalDate());
				}
			}
			
			ConexionBD.desconectar(con);
		} catch (SQLException e) {
			System.out.println("Error en GetAll: " + e.getMessage());
			
		}
		return usuario;
		
	}
	
	public void eliminarUsuario(int id) {
		Connection con = ConexionBD.conectar();
		String sql;
		
		//""" indica text-block
		try {
			sql = """
					DELETE 
					FROM usuario
					WHERE id = ?
					""";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate(sql);
			ConexionBD.desconectar(con);
		} catch (SQLException e) {
			System.out.println("Error en EliminarUsuario: " + e.getMessage());
			
		}
		
	}
	
	public Usuario comprobarCredenciales(String email, String password) {
		Connection con = ConexionBD.conectar();
		String sql;
		Usuario usuario = null;
		
		try {
			sql = """
					SELECT id, nombre, email
					FROM usuario
					WHERE email = ? AND password = ?					
					""";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setEmail(rs.getString("email"));
			}
				
			ConexionBD.desconectar(con);
		} catch (SQLException e) {
			System.out.println("Error en GetAll: " + e.getMessage());			
		}
		return usuario;
	}
	
	
}
