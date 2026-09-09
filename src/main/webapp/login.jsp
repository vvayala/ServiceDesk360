<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Acceso | ServiceDesk 360</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Paleta ITCA -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body class="bg-light">

<main class="container my-5" style="max-width: 480px;">
    <div class="card shadow-sm">
        <div class="card-body">
            <h1 class="h3 mb-3 fw-bold text-center text-primary">Iniciar acceso</h1>
            <p class="text-muted text-center">Ingrese con la cuenta temporal creada en esta práctica.</p>

            <!-- Alertas solo si hay mensaje -->
            <c:if test="${not empty mensajeExito}">
                <div class="alert alert-success">${mensajeExito}</div>
            </c:if>
            <c:if test="${not empty mensajeError}">
                <div class="alert alert-danger">${mensajeError}</div>
            </c:if>

            <!-- Formulario -->
            <form action="${pageContext.request.contextPath}/acceso" method="post">
                <div class="mb-3">
                    <label for="correo" class="form-label">Correo</label>
                    <input id="correo" name="correo" type="email" maxlength="100"
                           value="${ultimoUsuario}" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label for="clave" class="form-label">Contraseña</label>
                    <input id="clave" name="clave" type="password" maxlength="64"
                           class="form-control" required>
                </div>

                <div class="form-check mb-3">
                    <input type="checkbox" class="form-check-input" id="recordar" name="recordar" value="si">
                    <label class="form-check-label" for="recordar">
                        Recordar únicamente mi correo en este navegador
                    </label>
                </div>

                <div class="d-flex gap-2 flex-wrap">
                    <button type="submit" class="btn btn-warning fw-bold">
                        Ingresar
                    </button>
                    <a href="${pageContext.request.contextPath}/registro" class="btn btn-secondary">
                        Crear cuenta
                    </a>
                    <a href="${pageContext.request.contextPath}/" class="btn btn-outline-primary">
                        Volver al inicio
                    </a>
                </div>
            </form>
        </div>
    </div>
</main>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
