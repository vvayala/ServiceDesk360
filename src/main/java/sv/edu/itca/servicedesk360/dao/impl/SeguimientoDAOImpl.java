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
import sv.edu.itca.servicedesk360.dao.SeguimientoDAO;
import sv.edu.itca.servicedesk360.model.Seguimiento;
import sv.edu.itca.servicedesk360.persistence.ConexionBD;

/**
 *
 * @author vilic
 */
public class SeguimientoDAOImpl implements SeguimientoDAO{

    @Override
    public int registrar(Connection cn, Seguimiento s) throws DAOException {

        String sql = "INSERT INTO seguimientos "
                   + "(id_ticket, detalle, fecha_registro) "
                   + "VALUES (?, ?, NOW())";

        try (PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, s.getIdTicket());
            ps.setString(2, s.getDetalle());

            return ps.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Error registrando seguimiento.", e);
        }
    }

    @Override
    public List<Seguimiento> listarPorTicket(int idTicket) throws DAOException {

        List<Seguimiento> lista = new ArrayList<>();

        String sql = "SELECT id_seguimiento, id_ticket, detalle, fecha_registro "
                   + "FROM seguimientos "
                   + "WHERE id_ticket = ? "
                   + "ORDER BY fecha_registro DESC";

        try (Connection cn = ConexionBD.abrir();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, idTicket);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Seguimiento seguimiento = new Seguimiento();

                    seguimiento.setIdSeguimiento(
                            rs.getInt("id_seguimiento"));
                    seguimiento.setIdTicket(
                            rs.getInt("id_ticket"));
                    seguimiento.setDetalle(
                            rs.getString("detalle"));

                    seguimiento.setFechaRegistro(
                            rs.getTimestamp("fecha_registro")
                              .toLocalDateTime());

                    lista.add(seguimiento);
                }
            }

            return lista;

        } catch (SQLException e) {
            throw new DAOException(
                    "Error listando seguimientos del ticket.", e);
        }
    }
    
}
