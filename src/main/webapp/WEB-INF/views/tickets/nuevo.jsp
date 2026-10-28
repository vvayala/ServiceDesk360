<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Nuevo Ticket | ServiceDesk360</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body class="bg-light">

<div class="container py-4">

    <div class="card shadow">
        <div class="card-header">
            <h3 class="mb-0">Registrar Ticket</h3>
        </div>

        <div class="card-body">

            <c:if test="${not empty error}">
                <div class="alert alert-danger">
                    ${error}
                </div>
            </c:if>

            <form method="post"
                  action="${pageContext.request.contextPath}/ticket">

                <input type="hidden"
                       name="accion"
                       value="guardar">

                <div class="mb-3">
                    <label class="form-label">
                        Cliente
                    </label>

                    <select id="idCliente" name="idCliente"
                            class="form-select"
                            required>

                        <option value="">
                            Seleccione un cliente
                        </option>

                        <c:forEach var="cliente"
                                   items="${clientes}">

                            <option value="${cliente.idCliente}">
                                ${cliente.nombre}
                            </option>

                        </c:forEach>

                    </select>
                </div>

                <div class="mb-3">
                    <label class="form-label">
                        Equipo
                    </label>

                    <select id="idEquipo" name="idEquipo"
                            class="form-select"
                            required>

                        <option value="">
                            Equipos asignados
                        </option>

                    </select>
                </div>

                <div class="mb-3">
                    <label class="form-label">
                        Categoría
                    </label>

                    <select name="idCategoria"
                            class="form-select"
                            required>

                        <option value="">
                            Seleccione una categoría
                        </option>

                        <c:forEach var="categoria"
                                   items="${categorias}">

                            <option value="${categoria.idCategoria}">
                                ${categoria.nombre}
                            </option>

                        </c:forEach>

                    </select>
                </div>

                <div class="mb-3">
                    <label class="form-label">
                        Técnico asignado
                    </label>

                    <select name="idTecnico"
                            class="form-select"
                            required>

                        <option value="">
                            Seleccione un técnico
                        </option>

                        <c:forEach var="tecnico"
                                   items="${tecnicos}">

                            <option value="${tecnico.idTecnico}">
                                ${tecnico.nombre}
                                (${tecnico.especialidad})
                            </option>

                        </c:forEach>

                    </select>
                </div>

                <div class="mb-3">
                    <label class="form-label">
                        Título
                    </label>

                    <input type="text"
                           name="titulo"
                           maxlength="100"
                           class="form-control"
                           required>
                </div>

                <div class="mb-3">
                    <label class="form-label">
                        Descripción
                    </label>

                    <textarea name="descripcion"
                              rows="5"
                              class="form-control"
                              required></textarea>
                </div>

                <div class="mb-3">
                    <label class="form-label">
                        Prioridad
                    </label>

                    <select name="prioridad"
                            class="form-select"
                            required>

                        <option value="">
                            Seleccione
                        </option>

                        <option value="BAJA">
                            BAJA
                        </option>

                        <option value="MEDIA">
                            MEDIA
                        </option>

                        <option value="ALTA">
                            ALTA
                        </option>

                        <option value="CRÍTICA">
                            CRÍTICA
                        </option>

                    </select>
                </div>

                <div class="mb-3">
                    <label class="form-label">
                        Seguimiento inicial
                    </label>

                    <textarea name="detalleInicial"
                              rows="4"
                              class="form-control"
                              required></textarea>
                </div>

                <div class="d-flex gap-2">

                    <button type="submit"
                            class="btn btn-primary">
                        Guardar Ticket
                    </button>

                    <a href="${pageContext.request.contextPath}/ticket?accion=listar"
                       class="btn btn-secondary">
                        Cancelar
                    </a>

                </div>

            </form>

        </div>
    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>


<script>

document.getElementById("idCliente")
        .addEventListener("change", function () {

    const idCliente = this.value;

    const comboEquipo =
            document.getElementById("idEquipo");

    comboEquipo.innerHTML =
            "<option>Cargando...</option>";

    fetch(
        "${pageContext.request.contextPath}/ticket?accion=equipos&idCliente="
        + idCliente
    )
    .then(response => response.json())
    .then(data => {

        comboEquipo.innerHTML =
                "<option value=''>Seleccione un equipo</option>";

        data.forEach(equipo => {

            comboEquipo.innerHTML +=
                "<option value='" +
                equipo.id +
                "'>"
                + equipo.texto +
                "</option>";
        });
    })
    .catch(error => {

        comboEquipo.innerHTML =
                "<option value=''>No disponible</option>";
    });

});

</script>

</body>
</html>