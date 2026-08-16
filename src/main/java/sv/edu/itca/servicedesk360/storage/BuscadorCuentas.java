/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.itca.servicedesk360.storage;

/**
 *
 * @author vilic
 */

import java.util.Optional; 
import sv.edu.itca.servicedesk360.model.CuentaUsuario; 
 
public interface BuscadorCuentas { 
    Optional<CuentaUsuario> buscarPorCorreo(String correo); 
    boolean existeCorreo(String correo); 
} 