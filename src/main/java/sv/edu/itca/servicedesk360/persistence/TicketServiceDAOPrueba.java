/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.itca.servicedesk360.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

/**
 *
 * @author vilic
 */
public class TicketServiceDAOPrueba {
    
    public long registrarTicketConSeguimiento( 
        long idCliente, Long idEquipo, Long idTecnico, 
        long idCategoria, String titulo, String descripcion, 
        String prioridad, String detalleInicial) throws SQLException { 
 
    String sqlTicket = "INSERT INTO tickets " 
        + "(id_cliente,id_equipo,id_tecnico,id_categoria,titulo,descripcion,prioridad) " 
        + "VALUES (?,?,?,?,?,?,?)"; 
    String sqlSeg = "INSERT INTO seguimientos(id_ticket, detalle) VALUES (?,?)"; 
 
    try (Connection cn = ConexionBD.abrir()) { 
        cn.setAutoCommit(false); 
        try { 
            long idTicket; 
            try (PreparedStatement ps = cn.prepareStatement( 
                    sqlTicket, Statement.RETURN_GENERATED_KEYS)) { 
                ps.setLong(1, idCliente); 
                if (idEquipo == null) ps.setNull(2, Types.BIGINT); 
                else ps.setLong(2, idEquipo); 
                if (idTecnico == null) ps.setNull(3, Types.BIGINT); 
                else ps.setLong(3, idTecnico); 
                ps.setLong(4, idCategoria); 
                ps.setString(5, titulo); 
                ps.setString(6, descripcion); 
                ps.setString(7, prioridad); 
                ps.executeUpdate(); 
                try (ResultSet k = ps.getGeneratedKeys()) { 
                    if (!k.next()) throw new SQLException("Sin id_ticket generado"); 
                    idTicket = k.getLong(1); 
                } 
            } 
 
            try (PreparedStatement ps = cn.prepareStatement(sqlSeg)) { 
                ps.setLong(1, idTicket); 
                ps.setString(2, detalleInicial); 
                ps.executeUpdate(); 
            } 
 
            cn.commit(); 
            return idTicket; 
        } catch (SQLException ex) { 
            cn.rollback(); 
            throw ex; 
        } finally { 
            cn.setAutoCommit(true); 
        } 
    } 
} 
    
    public static void main(String[] args){
            TicketServiceDAOPrueba ticket = new TicketServiceDAOPrueba();
            String detalleErroneo = "X".repeat(1000);
            
            try{
                long idGenerado = ticket.registrarTicketConSeguimiento(
                         1L, null, 1L, 1L, 
                        "Error al ingresar al portal", 
                        "El usuario recibe un mensaje al autenticar.", 
                        "MEDIA", 
                        //"Ticket registrado desde la Guía 5");
                        detalleErroneo);
                
                System.out.println("Ticket confirmado: " + idGenerado); 

            }
            catch(SQLException ex){
                ex.printStackTrace();
                
            }
            
    
    
}
    
    
}
