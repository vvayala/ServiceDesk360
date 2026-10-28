/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sv.edu.itca.servicedesk360.dao;

import java.util.List;
import sv.edu.itca.servicedesk360.model.Equipo;

/**
 *
 * @author vilic
 */
public interface EquipoDAO {
     List<Equipo> listarPorCliente(int idCliente) throws DAOException; 
    boolean perteneceACliente(int idEquipo, int idCliente) throws DAOException; 
} 
