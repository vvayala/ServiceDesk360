package sv.edu.itca.servicedesk360.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sv.edu.itca.servicedesk360.dao.DAOException;
import sv.edu.itca.servicedesk360.dao.TicketDAO;
import sv.edu.itca.servicedesk360.dto.TicketDetalleDTO;
import sv.edu.itca.servicedesk360.model.Ticket;
import sv.edu.itca.servicedesk360.persistence.ConexionBD;

public class TicketDAOImpl implements TicketDAO {

    @Override
    public int registrar(Connection cn, Ticket t) throws DAOException {

        String sql = "INSERT INTO tickets "
                + "(id_cliente, id_equipo, id_tecnico, id_categoria, "
                + "titulo, descripcion, prioridad, estado, fecha_creacion) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, 'ABIERTO', NOW())";

        try (PreparedStatement ps = cn.prepareStatement(
                sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, t.getIdCliente());
            ps.setInt(2, t.getIdEquipo());
            ps.setInt(3, t.getIdTecnico());
            ps.setInt(4, t.getIdCategoria());
            ps.setString(5, t.getTitulo());
            ps.setString(6, t.getDescripcion());
            ps.setString(7, t.getPrioridad());

            if (ps.executeUpdate() != 1) {
                throw new DAOException("No se insertó el ticket.");
            }

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }

            throw new DAOException("MySQL no devolvió el id del ticket.");

        } catch (SQLException e) {
            throw new DAOException("Error registrando ticket.", e);
        }
    }

    @Override
    public List<TicketDetalleDTO> listarDetalle(String estado,
            String prioridad,
            int limite,
            int offset) throws DAOException {

        List<TicketDetalleDTO> lista = new ArrayList<>();

        String sql = "SELECT t.id_ticket, "
                + "c.nombre AS cliente, "
                + "CONCAT(e.codigo_inventario, ' - ', e.marca, ' ', e.modelo) AS equipo, "
                + "cat.nombre AS categoria, "
                + "tec.nombre AS tecnico, "
                + "t.titulo, "
                + "t.prioridad, "
                + "t.estado, "
                + "t.fecha_creacion "
                + "FROM tickets t "
                + "INNER JOIN clientes c ON c.id_cliente = t.id_cliente "
                + "INNER JOIN equipos e ON e.id_equipo = t.id_equipo "
                + "INNER JOIN categorias cat ON cat.id_categoria = t.id_categoria "
                + "INNER JOIN tecnicos tec ON tec.id_tecnico = t.id_tecnico "
                + "WHERE (? IS NULL OR t.estado = ?) "
                + "AND (? IS NULL OR t.prioridad = ?) "
                + "ORDER BY t.fecha_creacion DESC "
                + "LIMIT ? OFFSET ?";

        try (Connection cn = ConexionBD.abrir();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, estado);
            ps.setString(2, estado);
            ps.setString(3, prioridad);
            ps.setString(4, prioridad);
            ps.setInt(5, limite);
            ps.setInt(6, offset);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    TicketDetalleDTO dto = new TicketDetalleDTO();

                    dto.setIdTicket(rs.getInt("id_ticket"));
                    dto.setCliente(rs.getString("cliente"));
                    dto.setEquipo(rs.getString("equipo"));
                    dto.setCategoria(rs.getString("categoria"));
                    dto.setTecnico(rs.getString("tecnico"));
                    dto.setTitulo(rs.getString("titulo"));
                    dto.setPrioridad(rs.getString("prioridad"));
                    dto.setEstado(rs.getString("estado"));
                    dto.setFechaCreacion(
                            rs.getTimestamp("fecha_creacion").toLocalDateTime());

                    lista.add(dto);
                }
            }

            return lista;

        } catch (SQLException e) {
            throw new DAOException("Error al listar tickets.", e);
        }
    }

    @Override
    public int contar(String estado, String prioridad) throws DAOException {

        String sql = "SELECT COUNT(*) "
                + "FROM tickets "
                + "WHERE (? IS NULL OR estado = ?) "
                + "AND (? IS NULL OR prioridad = ?)";

        try (Connection cn = ConexionBD.abrir();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, estado);
            ps.setString(2, estado);
            ps.setString(3, prioridad);
            ps.setString(4, prioridad);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getInt(1);
                }

                return 0;
            }

        } catch (SQLException e) {
            throw new DAOException("Error al contar tickets.", e);
        }
    }

    @Override
    public boolean actualizarEstado(int idTicket,
            String estadoEsperado,
            String nuevoEstado) throws DAOException {

        String sql = "UPDATE tickets "
                + "SET estado = ? "
                + "WHERE id_ticket = ? "
                + "AND estado = ?";

        try (Connection cn = ConexionBD.abrir();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, nuevoEstado);
            ps.setInt(2, idTicket);
            ps.setString(3, estadoEsperado);

            return ps.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new DAOException("No fue posible actualizar el estado.", e);
        }
    }
}