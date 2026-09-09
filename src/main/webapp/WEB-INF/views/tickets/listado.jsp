<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Tickets | ServiceDesk 360</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Paleta ITCA -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body class="bg-light">

<div class="container my-5">
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h1 class="h3 fw-bold">Tickets de soporte</h1>
        <a href="${pageContext.request.contextPath}/tickets/nuevo" class="btn btn-warning fw-bold">
            Abrir nuevo ticket
        </a>
    </div>

    <!-- Mensaje de éxito -->
    <c:if test="${not empty mensajeExito}">
        <div class="alert alert-success">${mensajeExito}</div>
    </c:if>

    <!-- Tabla de tickets -->
    <div class="card shadow-sm">
        <div class="card-body">
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Título</th>
                        <th>Solicitante</th>
                        <th>Prioridad</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ticket" items="${tickets}">
                        <tr>
                            <td><c:out value="${ticket.id}" /></td>
                            <td><c:out value="${ticket.titulo}" /></td>
                            <td><c:out value="${ticket.solicitante.nombreCompleto}" /></td>
                            <td>
                                <span class="badge 
                                    ${ticket.prioridad eq 'ALTA' ? 'bg-danger' : 
                                      ticket.prioridad eq 'MEDIA' ? 'bg-warning text-dark' : 
                                      'bg-secondary'}">
                                    <c:out value="${ticket.prioridad}" />
                                </span>
                            </td>
                            <td>
                                <span class="badge 
                                    ${ticket.estado eq 'ABIERTO' ? 'bg-success' : 'bg-secondary'}">
                                    <c:out value="${ticket.estado}" />
                                </span>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
