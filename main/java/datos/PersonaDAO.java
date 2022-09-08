package datos;

import static datos.Conexion.*;
import dominio.Persona;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PersonaDAO {
    private static final String SQL_SELECT = "SELECT id_persona, nombre, "
            + "apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre,apellido,email,telefono) VALUES(?,?,?,?)";

    public List<Persona> seleccionar(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList();
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                /*
                Hibernate va a hacer todo esto por nosotros
                */
                
                personas.add(persona);
                
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        
        
        return personas;
    }

    public int insertar(Persona persona){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getMail());
            stmt.setString(4, persona.getTelefono());
            registros = stmt.executeUpdate();
            /*
            este metodo executeUpdate hace updates, inserts y deletes
            */
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
            } catch (SQLException ex) {
              ex.printStackTrace(System.out);  
            }
            try {
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
        /*
        este return es el de los registros afectados
        */
        
        
    }
    
}
 
    /*
    Esta clase va a hacer las operaciones de select, update, delete
    sobre la tabla de la entidad persona
    Nota: DAO significa 'Data Access Object'
    */