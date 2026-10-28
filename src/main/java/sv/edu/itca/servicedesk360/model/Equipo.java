/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.itca.servicedesk360.model;


/**
 *
 * @author vilic
 */
public class Equipo {
    
    private int idEquipo; 
    private int idCliente; 
    private String codigoInventario; 
    private String tipo; 
    private String marca; 
    private String modelo; 
    private boolean activo; 

    public Equipo() {
    }

    public Equipo(int idEquipo, int idCliente, String codigoInventario, String tipo, String marca, String modelo, boolean activo) {
        this.idEquipo = idEquipo;
        this.idCliente = idCliente;
        this.codigoInventario = codigoInventario;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.activo = activo;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCodigoInventario() {
        return codigoInventario;
    }

    public void setCodigoInventario(String codigoInventario) {
        this.codigoInventario = codigoInventario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    


    
}
