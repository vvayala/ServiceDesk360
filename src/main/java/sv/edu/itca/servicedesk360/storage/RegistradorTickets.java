/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sv.edu.itca.servicedesk360.storage;

import sv.edu.itca.servicedesk360.model.TicketSoporte;

/**
 *
 * @author vilic
 */
public interface RegistradorTickets { 
    void guardar(TicketSoporte ticket); 
    long siguienteId(); 
} 
