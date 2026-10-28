<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro | ServiceDesk 360</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>

<body class="bg-light">

<div class="container py-5">

    <div class="row justify-content-center">

        <div class="col-md-8 col-lg-6">

            <div class="card shadow border-0">

                <div class="card-body p-4">

                    <h1 class="h3 fw-bold text-center mb-3">
                        Crear cuenta temporal
                    </h1>

                    <p class="text-muted text-center mb-4">
                        Complete la información para ingresar al caso modelo.
                    </p>

                    <c:if test="${not empty mensajeError}">
                        <div class="alert alert-danger">
                            ${mensajeError}
                        </div>
                    </c:if>

                    <form action="${pageContext.request.contextPath}/registro"
                          method="post"
                          autocomplete="off">

                        <div class="mb-3">
                            <label for="nombre" class="form-label">
                                Nombre completo
                            </label>
                            <input id="nombre"
                                   name="nombre"
                                   type="text"
                                   maxlength="80"
                                   required
                                   class="form-control">
                        </div>

                        <div class="mb-3">
                            <label for="correo" class="form-label">
                                Correo electrónico
                            </label>
                            <input id="correo"
                                   name="correo"
                                   type="email"
                                   maxlength="100"
                                   required
                                   class="form-control">
                        </div>

                        <div class="mb-3">
                            <label for="rol" class="form-label">
                                Rol inicial
                            </label>

                            <select id="rol"
                                    name="rol"
                                    required
                                    class="form-select">

                                <option value="">
                                    Seleccione
                                </option>

                                <option value="SOLICITANTE">
                                    Solicitante
                                </option>

                                <option value="TECNICO">
                                    Técnico
                                </option>

                            </select>
                        </div>

                        <div class="mb-3">
                            <label for="clave" class="form-label">
                                Contraseña
                            </label>

                            <input id="clave"
                                   name="clave"
                                   type="password"
                                   minlength="8"
                                   maxlength="64"
                                   required
                                   class="form-control">
                        </div>

                        <div class="mb-4">
                            <label for="confirmarClave" class="form-label">
                                Confirmar contraseña
                            </label>

                            <input id="confirmarClave"
                                   name="confirmarClave"
                                   type="password"
                                   minlength="8"
                                   maxlength="64"
                                   required
                                   class="form-control">
                        </div>

                        <div class="d-grid gap-2">

                            <button type="submit"
                                    class="btn btn-warning fw-bold">
                                Crear cuenta
                            </button>

                            <a href="${pageContext.request.contextPath}/acceso"
                               class="btn btn-outline-secondary">
                                Ya tengo cuenta
                            </a>

                        </div>

                    </form>

                </div>

            </div>

        </div>

    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>