/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.itca.servicedesk360.model;

import java.time.LocalDateTime;

/**
 *
 * @author vilic
 */
public class Seguimiento {
    
    private int idSeguimiento; 
    private int idTicket; 
    private String detalle; 
    private LocalDateTime fechaRegistro;

    public Seguimiento() {
    }

    public Seguimiento(int idSeguimiento, int idTicket, String detalle, LocalDateTime fechaRegistro) {
        this.idSeguimiento = idSeguimiento;
        this.idTicket = idTicket;
        this.detalle = detalle;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdSeguimiento() {
        return idSeguimiento;
    }

    public void setIdSeguimiento(int idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
    
}
