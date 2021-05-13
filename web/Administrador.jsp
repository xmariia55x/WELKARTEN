<%-- 
    Document   : Administrador
    Created on : 25-abr-2021, 13:29:58
    Author     : maria
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="GestorEventos2021.entity.Evento"%>
<%@page import="java.util.List"%>
<%@page import="GestorEventos2021.entity.Usuario"%>
<html>
    <head>
        <title>Administrador</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link href="administradorStyles.css" rel="stylesheet">
    </head>

    <body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <jsp:include page="navbarSesionIniciada.jsp" />
        <br>
        <br>
        <br>
        <%
            Usuario administrador = (Usuario) session.getAttribute("usuario");
            List<Usuario> usuarios = (List<Usuario>) request.getAttribute("listaUsuarios");
            List<Evento> eventos = (List<Evento>) request.getAttribute("listaEventos");
        %>

        <div class="row">
            <div class="column">
                <form name="BuscarYFiltrarUsuarios" class="row g-3">
                    <div class="col-auto">
                        <label for="inputPassword2" class="visually-hidden">Buscar o filtrar</label>
                        <input type="text" class="form-control" id="buscar_usuario">
                    </div>
                    <div class="col-auto">
                        <button type="submit" class="btn btn-primary mb-3">Buscar usuarios</button>
                    </div>
                    <div class="col-auto">
                        <button type="submit" class="btn btn-primary mb-3">Filtrar usuarios</button>
                    </div>
                </form> 
                <!-- BOTONACO DE CREAR USUARIOS -->
                
                    <div class="d-grid gap-2 col-6 mx-auto">
                    <input type="submit" class="btn btn-primary btn-lg" value="Crear usuario" onclick="location.href = 'CrearUsuarioAdministrador.jsp'"/>
                    </div>
                
                <!-- TABLA DE USUARIOS -->
                <%
                    if (usuarios != null && !usuarios.isEmpty()) {
                %>
                <table class="table">
                    <thead class = "table-primary">
                        <tr>
                            <th scope="col">Nombre</th>
                            <th scope="col">NIF</th>
                            <th scope="col">Correo</th>
                            <th scope="col">Rol</th>
                            <th scope="col">Editar</th>
                            <th scope="col">Eliminar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Usuario user : usuarios) {
                        %>
                        <tr>
                            <th scope="row"><%=user.getNombre()%></th>
                            <td><%=user.getNif()%></td>
                            <td><%=user.getCorreo()%></td>
                            <td><%=user.getRol()%></td>
                            <td><input type="submit" class="btn btn-outline-primary" value="Editar" onclick="location.href = 'ServletCargarUsuarioEditarAdministrador?id=<%= user.getId()%>'"/></td>
                            <td><input type="submit" class="btn btn-outline-danger" value="Eliminar" onclick="location.href = 'ServletEliminarUsuarioAdministrador?id=<%= user.getId()%>'"/></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>

                <%
                } else { //no hay usuarios
                %>

                <div class="alert alert-warning" role="alert">
                    PRECAUCIÓN: ¡No hay usuarios en el sistema!
                </div>
                <%
                    }
                %>

            </div>
            <div class="column">
                <!-- TABLA DE EVENTOS -->
                <form name="BuscarYFiltrarEventos" class="row g-3">
                    <div class="col-auto">
                        <label for="inputPassword2" class="visually-hidden">Buscar o filtrar</label>
                        <input type="text" class="form-control" id="buscar_evento">
                    </div>
                    <div class="col-auto">
                        <button type="submit" class="btn btn-primary mb-3">Buscar eventos</button>
                    </div>
                    <div class="col-auto">
                        <button type="submit" class="btn btn-primary mb-3">Filtrar eventos</button>
                    </div>
                </form> 
                <!-- BOTONACO DE CREAR EVENTOS -->
                <form action="ServletCargarEtiquetasEventos">
                    <div class="d-grid gap-2 col-6 mx-auto">
                    <input type="submit" class="btn btn-primary btn-lg" value="Crear evento" />
                    </div>
                </form>

                <%
                    if (eventos != null && !eventos.isEmpty()) {
                        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                %>
                <table class="table">
                    <thead class = "table-primary">
                        <tr>
                            <th scope="col">Título</th>
                            <th scope="col">Fecha de inicio</th>
                            <th scope="col">Fecha límite para reservas</th>
                            <th scope="col">Coste entradas</th>
                            <th scope="col">Aforo</th>
                            <th scope="col">Editar</th>
                            <th scope="col">Eliminar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%      for (Evento event : eventos) {
                                String fechaInicio = formatter.format(event.getFechaInicio());
                                String fechaLimite = formatter.format(event.getFechaReserva());
                        %>
                        <tr>
                            <th scope="row"><%= event.getTitulo()%></th>
                            <td><%= fechaInicio%></td>
                            <td><%= fechaLimite%></td>
                            <td><%= event.getCosteEntrada()%></td>
                            <td><%= event.getAforo()%></td>
                            <td><button class="btn btn-outline-primary" type="submit">Editar</button></td>
                            <td><button class="btn btn-outline-danger" type="submit">Eliminar</button></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>

                <%
                } else { //no hay eventos
                %>
                <div class="alert alert-warning" role="alert">
                    PRECAUCIÓN: ¡No hay eventos en el sistema!
                </div>

                <%
                    }
                %>

            </div>
        </div>
    </body>
</html>
