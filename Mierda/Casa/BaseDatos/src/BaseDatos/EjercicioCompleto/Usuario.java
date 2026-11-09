import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;

import BaseDatos.EjercicioCompleto.ConexionBD;

// Importaciones de Lombok
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Usuario {

    private int id;
    private String email;
    private String nombre;
    private String password;
    private LocalDate fechaNacimiento;
}

public void crearTabla(){
    Connection con = ConexionBD.conectar();
    String sql;

    try{
        sql = """
                CREATE TABLE IF NOT EXIST usuario(
                id INT AUTO_INCREMENT PRIMARY KEY,
				email VARCHAR(20) NOT NULL,
				nombre VARCHAR(30) NOT NULL,
				password VARCHAR(30) NOT NULL,
				fecha_fechaNacimiento DATE NULL
				)
                """;

        PreparedStatement st = con.prepareStatement(sql);
        st.executeUpdate();
        ConexionBD.desconectar(con);
    }catch(SQLException e){
        System.out.println("Error: " + e.getMessage());
    }
}

void main() {
}




