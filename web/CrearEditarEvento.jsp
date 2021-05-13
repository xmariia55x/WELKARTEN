<%@page import="GestorEventos2021.entity.Usuario"%>
<%@page import="GestorEventos2021.entity.Etiqueta"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Evento</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link href="styles.css" rel="stylesheet">
    </head>
    <%
        List<Etiqueta> listaEtiquetas = (List<Etiqueta>) request.getAttribute("listaEtiquetas");
        String error = (String) request.getAttribute("error");
        //Usuario usuario = (Usuario)session.getAttribute("usuario");
    %>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <jsp:include page="navbarSesionIniciada.jsp" />
        <br>
        <br>
        <br>
        <!-- FORMULARIO PARA CREAR UN NUEVO EVENTO -->
        <div class="global_nuevo_evento">

            <form action="ServletCrearEditarEvento">
                
                <%
                    if (error != null && error.equals("etiquetasIncorrectas")) {
                %>

                <div class="alert alert-danger" role="alert">
                    Seleccione como mínimo 1 etiqueta y como máximo 2 etiquetas.
                </div>
                <%
                    } else if (error != null && error.equals("fechasIncorrectas")) {
                %>
                <div class="alert alert-danger" role="alert">
                    ERROR: La fecha límite para comprar entradas debe ser anterior a la fecha del evento.
                </div>
                <% 
                    }
                %>
                <div class="mb-3" style="text-align: left">
                    <label for="exampleDropdownFormEmail2" class="form-label">Nombre del evento</label>
                    <input type="text" name="nombre_evento" class="form-control" id="nombre_evento" required>
                </div>
                <div class="mb-3" style="text-align: left">
                    <label for="exampleDropdownFormEmail2" class="form-label">Descripción del evento</label>
                    <input type="text" name="descripcion_evento" class="form-control" id="descripcion_evento" required>
                </div>

                <div class="mb-3" style="text-align: left">
                    <label for="birthday" class="form-label">Fecha del evento</label>
                    <input type="date" class="form-control" id="fecha_evento" name="fecha_evento" required>
                </div> 

                <div class="mb-3" style="text-align: left">
                    <label for="inputMDEx1" class="form-label">Hora del evento</label>
                    <input type="time" name="hora_evento" id="inputMDEx1" class="form-control" required>

                </div>

                <div class="mb-3" style="text-align: left">
                    <label for="exampleDropdownFormEmail2" class="form-label">Lugar del evento</label>
                    <input type="text" name="lugar_evento" class="form-control" required>
                </div>

                <div class="mb-3" style="text-align: left">
                    <label for="birthday" class="form-label">Fecha límite para comprar entradas</label>
                    <input type="date" class="form-control" id="fecha_limite_entradas" name="fecha_limite_entradas" required>
                </div> 

                <div class="mb-3" style="text-align: left">
                    <label for="exampleDropdownFormEmail2" class="form-label">Coste de la entrada</label>
                    <input type="text" name="coste_entrada_evento" class="form-control" id="coste_entrada_evento" required>
                </div>

                <div class="mb-3" style="text-align: left">
                    <label for="exampleDropdownFormEmail2" class="form-label">Número máximo de entradas por persona</label>
                    <input type="text" name="maximo_entradas" class="form-control" required >
                </div>

                <div class="mb-3" style="text-align: left">
                    <label for="exampleDropdownFormEmail2" class="form-label">Aforo máximo del evento</label>
                    <input type="text" name="aforo_evento" class="form-control" id="aforo_evento" required >
                </div>

                <div style="text-align: left">
                    <label>Selecciona las etiquetas del evento</label> <br>
                </div>

                <%
                    for (Etiqueta etiqueta : listaEtiquetas) {
                %>
                <div class="form-check" style="text-align: left">
                    <input class="form-check-input"  type="checkbox" name="etiquetas_evento" value="<%=etiqueta.getId()%>" id="defaultCheck1">
                    <label class="form-check-label"  for="defaultCheck1"><%=etiqueta.getNombre()%></label>
                </div> 
                <%
                    }
                %>

                <br>
                <div class="mb-3" style="text-align: left">
                    <label for="exampleDropdownFormEmail2" class="form-label">Asientos</label> <br/>
                    <input class="form-check-input" type="radio" name="seleccion_asientos" value="S" />Sí<br>
                    <input class="form-check-input" type="radio" name="seleccion_asientos" value="N" />No<br>
                </div>

                <div class="mb-3" style="text-align: left">
                    <label for="exampleDropdownFormEmail2" class="form-label">Número de filas de asientos</label>
                    <input type="text" name="filas_evento" class="form-control" id="filas_evento">
                </div> 

                <div class="mb-3" style="text-align: left">
                    <label for="exampleDropdownFormEmail2" class="form-label">Número de asientos por fila del evento</label>
                    <input type="text" name="asientos_fila_evento" class="form-control" id="asientos_fila_evento">
                </div> 

                <div class="d-grid gap-2 col-6 mx-auto">
                    <button type="submit" class="btn btn-primary btn-lg">Crear evento</button>
                </div>
            </form>
        </div>
    </body>
</html>
