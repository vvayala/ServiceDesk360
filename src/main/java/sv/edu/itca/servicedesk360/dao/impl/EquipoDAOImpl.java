/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.itca.servicedesk360.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sv.edu.itca.servicedesk360.dao.DAOException;
import sv.edu.itca.servicedesk360.dao.EquipoDAO;
import sv.edu.itca.servicedesk360.model.Equipo;
import sv.edu.itca.servicedesk360.persistence.ConexionBD;

/**
 *
 * @author vilic
 */
public class EquipoDAOImpl implements EquipoDAO {

    @Override
public List<Equipo> listarPorCliente(int idCliente) throws DAOException {

    List<Equipo> lista = new ArrayList<>();

    String sql = "SELECT id_equipo, id_cliente, codigo_inventario, " +
                 "tipo, marca, modelo, activo " +
                 "FROM equipos " +
                 "WHERE id_cliente = ? " +
                 "ORDER BY codigo_inventario";

    try (Connection cn = ConexionBD.abrir();
         PreparedStatement ps = cn.prepareStatement(sql)) {

        ps.setInt(1, idCliente);

        try (ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Equipo equipo = new Equipo();

                equipo.setIdEquipo(rs.getInt("id_equipo"));
                equipo.setIdCliente(rs.getInt("id_cliente"));
                equipo.setCodigoInventario(rs.getString("codigo_inventario"));
                equipo.setTipo(rs.getString("tipo"));
                equipo.setMarca(rs.getString("marca"));
                equipo.setModelo(rs.getString("modelo"));
                equipo.setActivo(rs.getBoolean("activo"));

                lista.add(equipo);
            }
        }

        return lista;

    } catch (SQLException e) {
        throw new DAOException("No fue posible listar los equipos del cliente.", e);
    }
}

    @Override
    public boolean perteneceACliente(int idEquipo, int idCliente) throws DAOException {
        String sql = "SELECT COUNT(*) " +
             "FROM equipos " +
             "WHERE id_equipo = ? " +
             "AND id_cliente = ?";
 
    try (Connection cn = ConexionBD.abrir(); 
         PreparedStatement ps = cn.prepareStatement(sql)) { 
        ps.setInt(1, idEquipo); 
        ps.setInt(2, idCliente); 
        try (ResultSet rs = ps.executeQuery()) { 
            return rs.next() && rs.getInt(1) == 1; 
        } 
    } catch (SQLException e) { 
        throw new DAOException("No fue posible validar el equipo.", e); 
    } 
    }
    
}
