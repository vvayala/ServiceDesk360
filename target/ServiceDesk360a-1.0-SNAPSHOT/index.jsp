<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ServiceDesk 360</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Paleta ITCA -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body class="bg-light">

    <!-- Navbar con color institucional -->
    <nav class="navbar navbar-expand-lg navbar-dark" style="background: var(--rojo-itca);">
        <div class="container">
            <a class="navbar-brand fw-bold" href="${pageContext.request.contextPath}/">ServiceDesk 360</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/clientes?accion=listar">Clientes</a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/DiagnosticoServlet">Diagnóstico</a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/registro">Registro</a></li>
                    <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/acceso">Acceso</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Contenido principal -->
    <main class="container my-5">
        <div class="card shadow-sm mb-4">
            <div class="card-body">
                <h2 class="card-title">Primera aplicación web desplegada</h2>
                <p class="card-text">
                    Esta página confirma que el proyecto JSP fue publicado correctamente en Apache Tomcat.
                </p>
            </div>
        </div>

        <div class="card shadow-sm mb-4">
            <div class="card-body">
                <h3 class="card-title">Objetivos de la semana 1</h3>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Configurar el entorno Java Web</li>
                    <li class="list-group-item">Reconocer la arquitectura cliente-servidor</li>
                    <li class="list-group-item">Desplegar una aplicación inicial</li>
                    <li class="list-group-item">Documentar el proyecto integrador</li>
                </ul>
            </div>
        </div>

        <div class="d-flex gap-3">
            <a class="btn btn-info" href="${pageContext.request.contextPath}/DiagnosticoServlet">
                Ver diagnóstico del sistema
            </a>
            <a class="btn btn-success" href="${pageContext.request.contextPath}/registro">
                Crear cuenta temporal
            </a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/acceso">
                Iniciar acceso
            </a>
        </div>
    </main>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
