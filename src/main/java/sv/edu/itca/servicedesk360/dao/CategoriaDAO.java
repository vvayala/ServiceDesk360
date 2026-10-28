
package sv.edu.itca.servicedesk360.dao;

import java.util.List;
import sv.edu.itca.servicedesk360.model.Categoria;

public interface CategoriaDAO {

    List<Categoria> listar() throws DAOException;
}
