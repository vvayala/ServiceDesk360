/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sv.edu.itca.servicedesk360.dao;

import java.sql.Connection;
import java.util.List;
import sv.edu.itca.servicedesk360.dto.TicketDetalleDTO;
import sv.edu.itca.servicedesk360.model.Ticket;

/**
 *
 * @author vilic
 */
public interface TicketDAO {
    
     int registrar(Connection cn, Ticket ticket) throws DAOException; 
    List<TicketDetalleDTO> listarDetalle(String estado, String prioridad, 
                                         int limite, int offset) throws DAOException; 
    int contar(String estado, String prioridad) throws DAOException; 
    boolean actualizarEstado(int idTicket, String estadoEsperado, 
                             String nuevoEstado) throws DAOException;
   
}
