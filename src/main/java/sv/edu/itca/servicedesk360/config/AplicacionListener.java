/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.itca.servicedesk360.config;

/**
 *
 * @author vilic
 */

import javax.servlet.ServletContext; 
import javax.servlet.ServletContextEvent; 
import javax.servlet.ServletContextListener; 
import javax.servlet.annotation.WebListener; 
import sv.edu.itca.servicedesk360.service.Autenticador; 
import sv.edu.itca.servicedesk360.service.ServicioAutenticacion; 
import sv.edu.itca.servicedesk360.service.ServicioRegistro; 
import sv.edu.itca.servicedesk360.service.ValidadorRegistro; 
import sv.edu.itca.servicedesk360.storage.DirectorioCuentasEnMemoria; 
 
@WebListener 
public class AplicacionListener implements ServletContextListener { 
 
    @Override 
    public void contextInitialized(ServletContextEvent evento) { 
        DirectorioCuentasEnMemoria directorio = 
                new DirectorioCuentasEnMemoria(); 
 
        ServicioRegistro registro = new ServicioRegistro( 
                directorio, directorio, new ValidadorRegistro()); 
        Autenticador autenticador = 
                new ServicioAutenticacion(directorio); 
 
        ServletContext contexto = evento.getServletContext(); 
        contexto.setAttribute("servicioRegistro", registro); 
        contexto.setAttribute("autenticador", autenticador); 
    } 
} 