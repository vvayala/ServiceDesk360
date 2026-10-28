package sv.edu.itca.servicedesk360.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sv.edu.itca.servicedesk360.dao.CategoriaDAO;
import sv.edu.itca.servicedesk360.dao.ClienteDAO;
import sv.edu.itca.servicedesk360.dao.EquipoDAO;
import sv.edu.itca.servicedesk360.dao.TecnicoDAO;
import sv.edu.itca.servicedesk360.dao.TicketDAO;
import sv.edu.itca.servicedesk360.dao.impl.CategoriaDAOImpl;
import sv.edu.itca.servicedesk360.dao.impl.ClienteDAOImpl;
import sv.edu.itca.servicedesk360.dao.impl.EquipoDAOImpl;
import sv.edu.itca.servicedesk360.dao.impl.TecnicoDAOImpl;
import sv.edu.itca.servicedesk360.dao.impl.TicketDAOImpl;
import sv.edu.itca.servicedesk360.dto.TicketDetalleDTO;
import sv.edu.itca.servicedesk360.model.Equipo;
import sv.edu.itca.servicedesk360.model.Ticket;
import sv.edu.itca.servicedesk360.service.TicketService;

@WebServlet("/ticket")
public class TicketServlet extends HttpServlet {

    private final TicketDAO ticketDAO = new TicketDAOImpl();
    private final ClienteDAO clienteDAO = new ClienteDAOImpl();
    private final TecnicoDAO tecnicoDAO = new TecnicoDAOImpl();
    private final CategoriaDAO categoriaDAO = new CategoriaDAOImpl();    
    private final EquipoDAO equipoDAO = new EquipoDAOImpl();

    private final TicketService ticketService
            = new TicketService();

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {
            accion = "listar";
        }

        switch (accion) {

            case "listar":
                listar(request, response);
                break;

            case "nuevo":
                nuevo(request, response);
                break;

            case "equipos":
                equipos(request, response);
                break;                
            default:
                response.sendError(
                        HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {
            response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        switch (accion) {

            case "guardar":
                guardar(request, response);
                break;

            case "cambiarEstado":
                cambiarEstado(request, response);
                break;

            default:
                response.sendError(
                        HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void listar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String estado =
                    request.getParameter("estado");

            String prioridad =
                    request.getParameter("prioridad");

            if (estado != null && estado.isBlank()) {
                estado = null;
            }

            if (prioridad != null && prioridad.isBlank()) {
                prioridad = null;
            }

            int pagina = 1;
            int limite = 10;

            String paginaParam =
                    request.getParameter("pagina");

            if (paginaParam != null
                    && !paginaParam.isBlank()) {

                pagina = Integer.parseInt(paginaParam);
            }

            int offset = (pagina - 1) * limite;

            List<TicketDetalleDTO> tickets =
                    ticketDAO.listarDetalle(
                            estado,
                            prioridad,
                            limite,
                            offset);

            int totalRegistros =
                    ticketDAO.contar(
                            estado,
                            prioridad);

            int totalPaginas =
                    (int) Math.ceil(
                            (double) totalRegistros / limite);

            request.setAttribute("tickets", tickets);
            request.setAttribute("paginaActual", pagina);
            request.setAttribute("totalPaginas", totalPaginas);
            request.setAttribute("estado", estado);
            request.setAttribute("prioridad", prioridad);

            request.getRequestDispatcher(
                    "/WEB-INF/views/tickets/listado.jsp")
                    .forward(request, response);

        } catch (Exception e) {

            request.setAttribute(
                    "error",
                    e.getMessage());

            request.getRequestDispatcher(
                    "/views/error.jsp")
                    .forward(request, response);
        }
    }

    private void nuevo(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            request.setAttribute(
                    "clientes",
                    clienteDAO.listar());

            request.setAttribute(
                    "tecnicos",
                    tecnicoDAO.listar());

            request.setAttribute(
                    "categorias",
                    categoriaDAO.listar());

            request.getRequestDispatcher(
                    "/WEB-INF/views/tickets/nuevo.jsp")
                    .forward(request, response);

        } catch (Exception e) {

            request.setAttribute(
                    "error",
                    e.getMessage());

            request.getRequestDispatcher(
                    "/views/error.jsp")
                    .forward(request, response);
        }
    }

    private void guardar(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            Ticket t = new Ticket();

            t.setIdCliente(
                    Integer.parseInt(
                            request.getParameter("idCliente")));

            t.setIdEquipo(
                    Integer.parseInt(
                            request.getParameter("idEquipo")));

            t.setIdCategoria(
                    Integer.parseInt(
                            request.getParameter("idCategoria")));

            t.setIdTecnico(
                    Integer.parseInt(
                            request.getParameter("idTecnico")));

            t.setTitulo(
                    request.getParameter("titulo"));

            t.setDescripcion(
                    request.getParameter("descripcion"));

            t.setPrioridad(
                    request.getParameter("prioridad"));

            String detalleInicial =
                    request.getParameter("detalleInicial");

            int id =
                    ticketService
                            .registrarTicketConSeguimiento(
                                    t,
                                    detalleInicial);

            response.sendRedirect(
                    request.getContextPath()
                    + "/ticket?accion=listar&id="
                    + id);

        } catch (Exception e) {

            request.setAttribute(
                    "error",
                    e.getMessage());

            nuevo(request, response);
        }
    }

    private void ver(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            long idTicket =
                    Long.parseLong(
                            request.getParameter("id"));

            request.setAttribute(
                    "idTicket",
                    idTicket);

            request.getRequestDispatcher(
                    "/views/tickets/detalle.jsp")
                    .forward(request, response);

        } catch (Exception e) {

            request.setAttribute(
                    "error",
                    e.getMessage());

            request.getRequestDispatcher(
                    "/views/error.jsp")
                    .forward(request, response);
        }
    }

    private void cambiarEstado(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int idTicket =
                    Integer.parseInt(
                            request.getParameter("idTicket"));

            String estadoEsperado =
                    request.getParameter(
                            "estadoEsperado");

            String nuevoEstado =
                    request.getParameter(
                            "nuevoEstado");

            ticketDAO.actualizarEstado(
                    idTicket,
                    estadoEsperado,
                    nuevoEstado);

            response.sendRedirect(
                    request.getContextPath()
                    + "/ticket?accion=listar");

        } catch (Exception e) {

            request.setAttribute(
                    "error",
                    e.getMessage());

            request.getRequestDispatcher(
                    "/views/error.jsp")
                    .forward(request, response);
        }
    }
    
    private void equipos(HttpServletRequest request,
        HttpServletResponse response)
        throws IOException {

        try {

            int idCliente = Integer.parseInt(
                    request.getParameter("idCliente"));

            List<Equipo> equipos =
                    equipoDAO.listarPorCliente(idCliente);

            response.setContentType(
                    "application/json");

            response.setCharacterEncoding(
                    "UTF-8");

            StringBuilder json = new StringBuilder();

            json.append("[");

            for (int i = 0; i < equipos.size(); i++) {

                Equipo e = equipos.get(i);

                json.append("{")
                    .append("\"id\":")
                    .append(e.getIdEquipo())
                    .append(",")

                    .append("\"texto\":\"")
                    .append(e.getCodigoInventario())
                    .append(" - ")
                    .append(e.getMarca())
                    .append(" ")
                    .append(e.getModelo())
                    .append("\"")
                    .append("}");

                if (i < equipos.size() - 1) {
                    json.append(",");
                }
            }

            json.append("]");

            response.getWriter().write(
                    json.toString());

        } catch (Exception e) {

            response.setStatus(
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

            response.getWriter().write("[]");
        }
    }
}