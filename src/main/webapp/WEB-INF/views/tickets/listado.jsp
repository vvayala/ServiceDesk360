<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Tickets | ServiceDesk360</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-4">

    <div class="d-flex justify-content-between align-items-center mb-3">
        <h2>Listado de Tickets</h2>

        <a href="${pageContext.request.contextPath}/ticket?accion=nuevo"
           class="btn btn-primary">
            Nuevo Ticket
        </a>
    </div>

    <c:if test="${not empty error}">
        <div class="alert alert-danger">
            ${error}
        </div>
    </c:if>

    <div class="card">
        <div class="card-body">

            <table class="table table-striped table-hover">

                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Cliente</th>
                        <th>Equipo</th>
                        <th>Categoría</th>
                        <th>Técnico</th>
                        <th>Título</th>
                        <th>Prioridad</th>
                        <th>Estado</th>
                        <th>Fecha</th>
                        <th>Acciones</th>
                    </tr>
                </thead>

                <tbody>

                    <c:forEach var="ticket" items="${tickets}">

                        <tr>

                            <td>${ticket.idTicket}</td>

                            <td>${ticket.cliente}</td>

                            <td>${ticket.equipo}</td>

                            <td>${ticket.categoria}</td>

                            <td>${ticket.tecnico}</td>

                            <td>${ticket.titulo}</td>

                            <td>

                                <c:choose>

                                    <c:when test="${ticket.prioridad eq 'CRÍTICA'}">
                                        <span class="badge bg-danger">
                                            ${ticket.prioridad}
                                        </span>
                                    </c:when>

                                    <c:when test="${ticket.prioridad eq 'ALTA'}">
                                        <span class="badge bg-warning text-dark">
                                            ${ticket.prioridad}
                                        </span>
                                    </c:when>

                                    <c:when test="${ticket.prioridad eq 'MEDIA'}">
                                        <span class="badge bg-info">
                                            ${ticket.prioridad}
                                        </span>
                                    </c:when>

                                    <c:otherwise>
                                        <span class="badge bg-secondary">
                                            ${ticket.prioridad}
                                        </span>
                                    </c:otherwise>

                                </c:choose>

                            </td>

                            <td>

                                <c:choose>

                                    <c:when test="${ticket.estado eq 'ABIERTO'}">
                                        <span class="badge bg-success">
                                            ${ticket.estado}
                                        </span>
                                    </c:when>

                                    <c:when test="${ticket.estado eq 'EN_PROCESO'}">
                                        <span class="badge bg-warning text-dark">
                                            ${ticket.estado}
                                        </span>
                                    </c:when>

                                    <c:when test="${ticket.estado eq 'CERRADO'}">
                                        <span class="badge bg-dark">
                                            ${ticket.estado}
                                        </span>
                                    </c:when>

                                    <c:otherwise>
                                        <span class="badge bg-secondary">
                                            ${ticket.estado}
                                        </span>
                                    </c:otherwise>

                                </c:choose>

                            </td>

                            <td>${ticket.fechaCreacion}</td>

                            <td>

                                <a href="${pageContext.request.contextPath}/ticket?accion=ver&id=${ticket.idTicket}"
                                   class="btn btn-sm btn-info">
                                    Ver
                                </a>

                            </td>

                        </tr>

                    </c:forEach>

                </tbody>

            </table>

        </div>
    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>