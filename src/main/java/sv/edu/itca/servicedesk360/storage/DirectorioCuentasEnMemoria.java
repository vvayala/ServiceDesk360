/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.itca.servicedesk360.storage;

/**
 *
 * @author vilic
 */

import java.util.Map; 
import java.util.Optional; 
import java.util.concurrent.ConcurrentHashMap; 
import sv.edu.itca.servicedesk360.model.CuentaUsuario; 
 
public class DirectorioCuentasEnMemoria 
        implements BuscadorCuentas, RegistradorCuentas { 
 
    private final Map<String, CuentaUsuario> cuentas = 
            new ConcurrentHashMap<>(); 
 
    @Override 
    public Optional<CuentaUsuario> buscarPorCorreo(String correo) { 
        return Optional.ofNullable(cuentas.get(normalizar(correo))); 
    } 
 
    @Override 
    public boolean existeCorreo(String correo) { 
        return cuentas.containsKey(normalizar(correo)); 
    } 
 
    @Override 
    public void guardar(CuentaUsuario cuenta) { 
        String correo = normalizar(cuenta.getUsuario().getCorreo()); 
        CuentaUsuario anterior = cuentas.putIfAbsent(correo, cuenta); 
        if (anterior != null) { 
            throw new IllegalStateException("El correo ya está registrado."); 
        } 
    } 
 
    private String normalizar(String correo) { 
        return correo == null ? "" : correo.trim().toLowerCase(); 
    } 
} 