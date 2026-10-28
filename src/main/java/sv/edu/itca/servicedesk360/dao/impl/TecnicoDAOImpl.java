package sv.edu.itca.servicedesk360.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sv.edu.itca.servicedesk360.dao.DAOException;
import sv.edu.itca.servicedesk360.dao.TecnicoDAO;
import sv.edu.itca.servicedesk360.model.Tecnicos;
import sv.edu.itca.servicedesk360.persistence.ConexionBD;

public class TecnicoDAOImpl implements TecnicoDAO {

    @Override
    public List<Tecnicos> listar() throws DAOException {

        List<Tecnicos> lista = new ArrayList<>();

        String sql = "SELECT id_tecnico, nombre, correo, "
                   + "especialidad, activo "
                   + "FROM tecnicos "
                   + "WHERE activo = 1 "
                   + "ORDER BY nombre";

        try (Connection cn = ConexionBD.abrir();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Tecnicos tecnico = new Tecnicos();

                tecnico.setIdTecnico(
                        rs.getInt("id_tecnico"));

                tecnico.setNombre(
                        rs.getString("nombre"));

                tecnico.setCorreo(
                        rs.getString("correo"));

                tecnico.setEspecialidad(
                        rs.getString("especialidad"));

                tecnico.setActivo(
                        rs.getBoolean("activo"));

                lista.add(tecnico);
            }

            return lista;

        } catch (SQLException e) {
            throw new DAOException(
                    "Error listando técnicos.", e);
        }
    }
}
