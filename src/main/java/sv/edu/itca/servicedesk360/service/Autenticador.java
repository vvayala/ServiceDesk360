/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sv.edu.itca.servicedesk360.service;

/**
 *
 * @author vilic
 */
 
import java.util.Optional; 
import sv.edu.itca.servicedesk360.model.Usuario; 
 
public interface Autenticador { 
    Optional<Usuario> autenticar(String correo, String clave); 
} 