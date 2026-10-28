package sv.edu.itca.servicedesk360.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sv.edu.itca.servicedesk360.dao.CategoriaDAO;
import sv.edu.itca.servicedesk360.dao.DAOException;
import sv.edu.itca.servicedesk360.model.Categoria;
import sv.edu.itca.servicedesk360.persistence.ConexionBD;

public class CategoriaDAOImpl implements CategoriaDAO {

    @Override
    public List<Categoria> listar() throws DAOException {

        List<Categoria> lista = new ArrayList<>();

        String sql = "SELECT id_categoria, nombre "
                   + "FROM categorias "
                   + "ORDER BY nombre";

        try (Connection cn = ConexionBD.abrir();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Categoria categoria = new Categoria();

                categoria.setIdCategoria(
                        rs.getInt("id_categoria"));

                categoria.setNombre(
                        rs.getString("nombre"));    

                lista.add(categoria);
            }

            return lista;

        } catch (SQLException e) {
            throw new DAOException(
                    "Error listando categorías.", e);
        }
    }
}