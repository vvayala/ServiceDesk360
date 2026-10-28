
package sv.edu.itca.servicedesk360.dao;

import java.util.List;
import sv.edu.itca.servicedesk360.model.Tecnicos;

public interface TecnicoDAO {

    List<Tecnicos> listar() throws DAOException;
}