<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>${empty cliente.idCliente ? 'Nuevo' : 'Editar'} cliente</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Paleta ITCA -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body class="bg-light">

<div class="container my-5" style="max-width: 600px;">
    <div class="card shadow-sm">
        <div class="card-body">
            <h1 class="h4 fw-bold mb-3">
                ${empty cliente.idCliente ? 'Nuevo cliente' : 'Editar cliente'}
            </h1>

            <!-- Alerta de error solo si existe -->
            <c:if test="${not empty error}">
                <div class="alert alert-danger">${error}</div>
            </c:if>

            <!-- Formulario -->
            <form method="post" action="${pageContext.request.contextPath}/clientes">
                <input type="hidden" name="accion" value="guardar"/>
                <input type="hidden" name="idCliente" value="${cliente.idCliente}"/>

                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input id="nombre" type="text" name="nombre" value="${cliente.nombre}"
                           class="form-control" required maxlength="120"/>
                </div>

                <div class="mb-3">
                    <label for="correo" class="form-label">Correo</label>
                    <input id="correo" type="email" name="correo" value="${cliente.correo}"
                           class="form-control" required maxlength="160"/>
                </div>

                <div class="d-flex gap-2">
                    <button type="submit" class="btn btn-warning fw-bold">Guardar</button>
                    <a href="${pageContext.request.contextPath}/clientes" class="btn btn-secondary">Cancelar</a>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
