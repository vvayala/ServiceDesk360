package sv.edu.itca.servicedesk360.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cerrar-sesion") 
public class CerrarSesionServlet extends HttpServlet { 
 
    @Override 
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
            throws ServletException, IOException { 

        try {
            HttpSession sesion = request.getSession(false); 
            if (sesion != null) { 
                sesion.invalidate(); 
            } 

            response.sendRedirect( 
                    request.getContextPath() + "/acceso?estado=cerrada"); 

        } catch (RuntimeException ex) {
            getServletContext().log(
                    "Error al cerrar la sesión", ex);
            request.setAttribute("mensajeError",
                    "Ocurrió un error inesperado al cerrar la sesión. Intente nuevamente.");
            request.getRequestDispatcher("/WEB-INF/views/error.jsp")
                   .forward(request, response);
        }
    } 
}
