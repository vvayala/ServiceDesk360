<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Error controlado | ServiceDesk 360</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Paleta ITCA -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body class="bg-light">

<div class="container my-5" style="max-width: 600px;">
    <div class="card shadow-sm">
        <div class="card-body text-center">
            <h1 class="h4 fw-bold text-danger mb-3">No fue posible completar la operación</h1>

            <!-- Mensaje de error -->
            <c:if test="${not empty mensajeError}">
                <div class="alert alert-danger">${mensajeError}</div>
            </c:if>

            <!-- Botón para volver -->
            <a href="${pageContext.request.contextPath}/panel" class="btn btn-outline-primary mt-3">
                Volver al panel
            </a>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
