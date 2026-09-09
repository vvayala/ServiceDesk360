<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Clientes | ServiceDesk 360</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Paleta ITCA -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body class="bg-light">

<div class="container my-5">
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h1 class="h3 fw-bold">Clientes</h1>
        <a href="${pageContext.request.contextPath}/clientes?accion=nuevo" class="btn btn-warning fw-bold">
            Nuevo cliente
        </a>
    </div>

    <!-- Alertas -->
    <c:if test="${not empty sessionScope.flash}">
        <div class="alert alert-success">${sessionScope.flash}</div>
        <c:remove var="flash" scope="session"/>
    </c:if>
    <c:if test="${not empty sessionScope.flashError}">
        <div class="alert alert-danger">${sessionScope.flashError}</div>
        <c:remove var="flashError" scope="session"/>
    </c:if>

    <!-- Tabla de clientes -->
    <div class="card shadow-sm">
        <div class="card-body">
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Correo</th>
                        <th>Estado</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="c" items="${clientes}">
                    <tr>
                        <td>${c.idCliente}</td>
                        <td>${c.nombre}</td>
                        <td>${c.correo}</td>
                        <td>
                            <span class="badge ${c.activo ? 'bg-success' : 'bg-secondary'}">
                                ${c.activo ? 'Activo' : 'Inactivo'}
                            </span>
                        </td>
                        <td class="d-flex gap-2">
                            <!-- Editar -->
                            <a href="${pageContext.request.contextPath}/clientes?accion=editar&id=${c.idCliente}"
                               class="btn btn-sm btn-primary">Editar</a>

                            <!-- Cambiar estado -->
                            <form method="post" action="${pageContext.request.contextPath}/clientes">
                                <input type="hidden" name="accion" value="estado"/>
                                <input type="hidden" name="id" value="${c.idCliente}"/>
                                <input type="hidden" name="activo" value="${!c.activo}"/>
                                <button type="submit" class="btn btn-sm btn-warning">
                                    ${c.activo ? 'Desactivar' : 'Activar'}
                                </button>
                            </form>

                            <!-- Eliminar -->
                            <form method="post" action="${pageContext.request.contextPath}/clientes"
                                  onsubmit="return confirm('¿Seguro que deseas eliminar este cliente?');">
                                <input type="hidden" name="accion" value="eliminar"/>
                                <input type="hidden" name="id" value="${c.idCliente}"/>
                                <button type="submit" class="btn btn-sm btn-danger">Eliminar</button>
                            </form>
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
