/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sv.edu.itca.servicedesk360.dao;

import java.sql.Connection;
import java.util.List;
import sv.edu.itca.servicedesk360.model.Seguimiento;

/**
 *
 * @author vilic
 */
public interface SeguimientoDAO {
    
    int registrar(Connection cn, Seguimiento seguimiento) throws DAOException; 
    List<Seguimiento> listarPorTicket(int idTicket) throws DAOException; 
    
}
