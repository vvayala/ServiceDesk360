/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.itca.servicedesk360.service;

import com.google.protobuf.ServiceException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;
import sv.edu.itca.servicedesk360.dao.DAOException;
import sv.edu.itca.servicedesk360.dao.EquipoDAO;
import sv.edu.itca.servicedesk360.dao.SeguimientoDAO;
import sv.edu.itca.servicedesk360.dao.TicketDAO;
import sv.edu.itca.servicedesk360.dao.impl.EquipoDAOImpl;
import sv.edu.itca.servicedesk360.dao.impl.SeguimientoDAOImpl;
import sv.edu.itca.servicedesk360.dao.impl.TicketDAOImpl;
import sv.edu.itca.servicedesk360.model.Seguimiento;
import sv.edu.itca.servicedesk360.model.Ticket;
import sv.edu.itca.servicedesk360.persistence.ConexionBD;

/**
 *
 * @author vilic
 */
public class TicketService { 
 
    private final TicketDAO ticketDAO = new TicketDAOImpl(); 
    private final SeguimientoDAO seguimientoDAO = new SeguimientoDAOImpl(); 
    private final EquipoDAO equipoDAO = new EquipoDAOImpl(); 
 
    public int registrarTicketConSeguimiento( 
            Ticket ticket, String detalleInicial) throws ServiceException { 
 
        validar(ticket, detalleInicial); 
 
        if (!equipoDAO.perteneceACliente( 
                ticket.getIdEquipo(), ticket.getIdCliente())) { 
            throw new ServiceException( 
                "El equipo seleccionado no pertenece al cliente."); 
        } 
 
        try (Connection cn = ConexionBD.abrir()) { 
            cn.setAutoCommit(false); 
 
            try { 
                int idTicket = ticketDAO.registrar(cn, ticket); 
 
                Seguimiento s = new Seguimiento(); 
                s.setIdTicket(idTicket); 
                s.setDetalle(detalleInicial); 
 
                if (seguimientoDAO.registrar(cn, s) != 1) { 
                    throw new ServiceException( 
                        "No se registró el seguimiento inicial."); 
                } 
 
                cn.commit(); 
                return idTicket; 
 
            } catch (Exception e) { 
                cn.rollback(); 
                throw new ServiceException( 
                    "La operación fue revertida.", e); 
            } finally { 
                cn.setAutoCommit(true); 
            } 
 
        } catch (SQLException | DAOException e) { 
            throw new ServiceException( 
                "No fue posible completar el proceso.", e); 
        } 
    } 
    
    private void validar(Ticket t, String detalle) throws ServiceException { 
    if (t.getIdCliente() <= 0) throw new ServiceException("Cliente requerido."); 
    if (t.getIdEquipo() <= 0) throw new ServiceException("Equipo requerido."); 
    if (t.getIdTecnico() <= 0) throw new ServiceException("Técnico requerido."); 
    if (t.getIdCategoria() <= 0) throw new ServiceException("Categoría requerida."); 
 
    if (t.getTitulo() == null || t.getTitulo().trim().length() < 5) { 
        throw new ServiceException("El título debe contener al menos 5 caracteres."); 
    } 
 
    Set<String> prioridades = Set.of("BAJA", "MEDIA", "ALTA", "CRÍTICA"); 
    if (!prioridades.contains(t.getPrioridad())) { 
        throw new ServiceException("Prioridad no válida."); 
    } 
 
    if (detalle == null || detalle.isBlank()) { 
        throw new ServiceException("Seguimiento inicial requerido."); 
    } 
} 
}

