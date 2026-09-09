
package sv.edu.itca.servicedesk360.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import sv.edu.itca.servicedesk360.persistence.ConexionBD;


class ClienteRegistro {
    
    private Long id_cliente;
    private String nombre;
    private String correo;
    private boolean activo;

    public Long getId() {
        return id_cliente;
    }

    public void setId(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public ClienteRegistro(Long id_cliente, String nombre, String correo, boolean activo) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.correo = correo;
        this.activo = activo;
    }
        
} 

    public class ClienteDAOPrueba {
        
        public ClienteRegistro buscarClientePorCorreo(String correo) 
        throws SQLException { 
 
    String sql = "SELECT id_cliente, nombre, correo, activo " 
               + "FROM clientes WHERE correo = ?"; 
 
    try (Connection cn = ConexionBD.abrir(); 
         PreparedStatement ps = cn.prepareStatement(sql)) { 
 
        ps.setString(1, correo); 
        try (ResultSet rs = ps.executeQuery()) { 
            if (!rs.next()) { 
                return null; 
            } 
            return new ClienteRegistro( 
                    rs.getLong("id_cliente"), 
                    rs.getString("nombre"), 
                    rs.getString("correo"), 
                    rs.getBoolean("activo")); 
        } 
    } 
}
        public long insertarCliente(String nombre, String correo) 
        throws SQLException { 
 
    String sql = "INSERT INTO clientes(nombre, correo) VALUES (?, ?)"; 
 
    try (Connection cn = ConexionBD.abrir(); 
         PreparedStatement ps = cn.prepareStatement( 
                 sql, Statement.RETURN_GENERATED_KEYS)) { 
 
        ps.setString(1, nombre); 
        ps.setString(2, correo); 
        ps.executeUpdate(); 
 
        try (ResultSet keys = ps.getGeneratedKeys()) { 
            if (!keys.next()) { 
                throw new SQLException("MySQL no devolvió la clave generada."); 
            } 
            return keys.getLong(1); 
        } 
    } 
} 
     
        public static void main(String[] args){
            ClienteDAOPrueba dao = new ClienteDAOPrueba();
            
            try{
                //ClienteRegistro cliente = dao.buscarClientePorCorreo( "' OR '1'='1");
                ClienteRegistro cliente = dao.buscarClientePorCorreo( "ana.lopez@demo.local");

                System.out.println(cliente == null 
                ? "Entrada tratada como dato: sin coincidencias" 
                : "Revisar implementación");
                
            }
            catch(SQLException ex){
                ex.printStackTrace();
                
            }
            
    
    
}

        
    }


    
  

