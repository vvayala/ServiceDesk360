<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Panel | ServiceDesk 360</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>

<body class="bg-light">

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow-sm">
        <div class="container">
            <a class="navbar-brand fw-bold" href="#">
                ServiceDesk 360
            </a>

            <form action="${pageContext.request.contextPath}/cerrar-sesion"
                  method="post">
                <button type="submit" class="btn btn-outline-light">
                    Cerrar sesión
                </button>
            </form>
        </div>
    </nav>

    <div class="container my-5">

        <div class="card shadow border-0 mb-4">
            <div class="card-body">

                <h1 class="h3 fw-bold mb-3">
                    Bienvenido,
                    ${sessionScope.usuarioAutenticado.nombreCompleto}
                </h1>

                <div class="row">

                    <div class="col-md-4">
                        <div class="border rounded p-3 bg-light">
                            <small class="text-muted">Correo</small>
                            <div class="fw-semibold">
                                ${sessionScope.usuarioAutenticado.correo}
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="border rounded p-3 bg-light">
                            <small class="text-muted">Rol</small>
                            <div class="fw-semibold">
                                ${sessionScope.usuarioAutenticado.rol}
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4">
                        <div class="border rounded p-3 bg-light">
                            <small class="text-muted">Estado</small>
                            <div class="fw-semibold text-success">
                                Activo:
                                ${sessionScope.usuarioAutenticado.activo}
                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </div>

        <div class="row g-4">

            <div class="col-md-4">
                <div class="card h-100 shadow-sm border-0">
                    <div class="card-body">
                        <h4 class="card-title">
                            Tickets
                        </h4>

                        <p class="text-muted">
                            Registrar, consultar y administrar solicitudes de soporte.
                        </p>

                        <a href="${pageContext.request.contextPath}/ticket?accion=listar"
                           class="btn btn-warning fw-bold">
                            Gestionar tickets
                        </a>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card h-100 shadow-sm border-0">
                    <div class="card-body">
                        <h4 class="card-title">
                            Equipos
                        </h4>

                        <p class="text-muted">
                            Control de equipos y activos tecnológicos de clientes.
                        </p>

                        <button class="btn btn-outline-secondary" disabled>
                            Próximamente
                        </button>
                    </div>
                </div>
            </div>

            <div class="col-md-4">
                <div class="card h-100 shadow-sm border-0">
                    <div class="card-body">
                        <h4 class="card-title">
                            Reportes
                        </h4>

                        <p class="text-muted">
                            Indicadores y estadísticas de atención de tickets.
                        </p>

                        <button class="btn btn-outline-secondary" disabled>
                            Próximamente
                        </button>
                    </div>
                </div>
            </div>

        </div>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>