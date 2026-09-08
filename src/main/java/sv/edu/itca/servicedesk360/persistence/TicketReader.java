/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.itca.servicedesk360.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;/**
 *
 * @author vilic
 */

class TicketVista {

    public TicketVista(long id_ticket, String titulo, String prioridad, String estado, LocalDateTime fecha_creacion, String cliente, String categoria) {
        this.id_ticket = id_ticket;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.estado = estado;
        this.fecha_creacion = fecha_creacion;
        this.cliente = cliente;
        this.categoria = categoria;
    }
        private long id_ticket;
        private String titulo;
        private String prioridad;
        private String estado;
        private LocalDateTime fecha_creacion;
        private String cliente;
        private String categoria;
    }
public class TicketReader {
    
    public List<TicketVista> listarTickets() throws SQLException { 
    String sql = "SELECT t.id_ticket, t.titulo, t.prioridad, t.estado, " 
               + "t.fecha_creacion, c.nombre AS cliente, " 
               + "cat.nombre AS categoria " 
               + "FROM tickets t " 
               + "JOIN clientes c ON c.id_cliente = t.id_cliente " 
               + "JOIN categorias cat ON cat.id_categoria = t.id_categoria " 
               + "ORDER BY t.fecha_creacion DESC"; 
 
    List<TicketVista> salida = new ArrayList<>(); 
    try (Connection cn = ConexionBD.abrir(); 
         PreparedStatement ps = cn.prepareStatement(sql); 
         ResultSet rs = ps.executeQuery()) { 
        while (rs.next()) { 
            salida.add(new TicketVista( 
                rs.getLong("id_ticket"), 
                rs.getString("titulo"), 
                rs.getString("prioridad"), 
                rs.getString("estado"), 
                rs.getTimestamp("fecha_creacion").toLocalDateTime(), 
                rs.getString("cliente"), 
                rs.getString("categoria"))); 
        } 
    } 
    return salida; 
}
    
}