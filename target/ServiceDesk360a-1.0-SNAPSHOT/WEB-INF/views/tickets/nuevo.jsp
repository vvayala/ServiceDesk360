<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Nuevo ticket | ServiceDesk 360</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Paleta ITCA -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body class="bg-light">

<div class="container my-5" style="max-width: 700px;">
    <div class="card shadow-sm">
        <div class="card-body">
            <h1 class="h4 fw-bold mb-3">Registrar ticket de soporte</h1>

            <!-- Errores -->
            <c:if test="${not empty errores}">
                <div class="alert alert-danger">
                    <ul class="mb-0">
                        <c:forEach var="error" items="${errores}">
                            <li><c:out value="${error}" /></li>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>

            <!-- Formulario -->
            <form method="post" action="${pageContext.request.contextPath}/tickets/nuevo">
                <div class="mb-3">
                    <label for="titulo" class="form-label">Título</label>
                    <input id="titulo" type="text" name="titulo" maxlength="100"
                           value="${tituloAnterior}" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label for="descripcion" class="form-label">Descripción</label>
                    <textarea id="descripcion" name="descripcion" rows="6"
                              class="form-control" required><c:out value="${descripcionAnterior}" /></textarea>
                </div>

                <div class="mb-3">
                    <label for="prioridad" class="form-label">Prioridad</label>
                    <select id="prioridad" name="prioridad" class="form-select" required>
                        <option value="">Seleccione</option>
                        <option value="BAJA" ${prioridadAnterior eq 'BAJA' ? 'selected' : ''}>Baja</option>
                        <option value="MEDIA" ${prioridadAnterior eq 'MEDIA' ? 'selected' : ''}>Media</option>
                        <option value="ALTA" ${prioridadAnterior eq 'ALTA' ? 'selected' : ''}>Alta</option>
                        <option value="CRITICA" ${prioridadAnterior eq 'CRITICA' ? 'selected' : ''}>Crítica</option>
                    </select>
                </div>

                <div class="d-flex gap-2">
                    <button type="submit" class="btn btn-warning fw-bold">Registrar ticket</button>
                    <a href="${pageContext.request.contextPath}/tickets" class="btn btn-secondary">Volver al listado</a>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
