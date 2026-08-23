package sv.edu.itca.servicedesk360.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/panel")
public class PanelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession sesion = request.getSession(false);

            if (sesion == null
                    || sesion.getAttribute("usuarioAutenticado") == null) {
                response.sendRedirect(
                        request.getContextPath() + "/acceso?estado=sesion");
                return;
            }

            request.getRequestDispatcher("/WEB-INF/views/panel.jsp")
                   .forward(request, response);

        } catch (RuntimeException ex) {
            getServletContext().log("Error al cargar el panel", ex);
            request.setAttribute("mensajeError",
                    "Ocurrió un error inesperado al cargar el panel. Intente nuevamente.");
            request.getRequestDispatcher("/WEB-INF/views/error.jsp")
                   .forward(request, response);
        }
    }
}
