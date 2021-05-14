<%-- 
    Document   : MisEventos
    Created on : 13-may-2021, 23:46:12
    Author     : yeray
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="GestorEventos2021.entity.Etiquetasevento"%>
<%@page import="GestorEventos2021.entity.Evento"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>WELKARTEN</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link href="styles2.css" rel="stylesheet">
    </head>
    <%
        List<Evento> listaEventosRecientes = (List<Evento>) request.getAttribute("listaEventosRecientes");
        List<Evento> listaEventosFinalizados = (List<Evento>) request.getAttribute("listaEventosFinalizados");

        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
    %>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <jsp:include page="Navbar.jsp" />
        <br>
        <br>
        <br>
        <br>

        <h1 class="display-4">Mis eventos</h1>

        <div class="eventosProximos">
            <h2 class="pb-2 border-bottom">Mis eventos próximos</h2>

            <div class="contenido">
                <% if (listaEventosRecientes == null || listaEventosRecientes.isEmpty()) { %>
                <h4>No hay resultados</h4>
                <% } else {
                    for (Evento e : listaEventosRecientes) {
                        List<Etiquetasevento> listaEtiquetas = e.getEtiquetaseventoList();
                        String etiquetas = "";
                        for (int i = 0; i < listaEtiquetas.size(); i++) {
                            etiquetas += listaEtiquetas.get(i).getEtiqueta().getNombre();
                            if (i < listaEtiquetas.size() - 1) {
                                etiquetas += ", ";
                            }
                        }
                %>
                <div class="carta">
                    <div class="card" style="width: 18rem;">
                        <img src="images/ticket.png" class="card-img-top" alt="Evento"/> 
                        <div class="card-body">
                            <h5 class="card-title"><%=e.getTitulo()%></h5>
                            <p class="card-text"><%=e.getLugar()%></p>
                            <p class="card-text"><%=formatoFecha.format(e.getFechaInicio()) + " " + formatoHora.format(e.getHora())%></p>
                            <p class="card-text"><%=etiquetas%></p>
                            <!-- Cambiar id 1 por //evento.getEventoId()// -->
                            <a href="ServletEventoInfo?id=<%=e.getId()%>" class="btn btn-primary">Mis entradas</a>
                        </div>
                    </div>
                </div>
                <%      }
                    }
                %>
            </div>
        </div>

        <div class="eventosFinalizados">
            <h2 class="pb-2 border-bottom">Mis eventos finalizados</h2>

            <div class="contenido">
                <% if (listaEventosFinalizados == null || listaEventosFinalizados.isEmpty()) { %>
                <h4>No hay resultados</h4>
                <% } else {
                    for (Evento e : listaEventosFinalizados) {
                        List<Etiquetasevento> listaEtiquetas = e.getEtiquetaseventoList();
                        String etiquetas = "";
                        for (int i = 0; i < listaEtiquetas.size(); i++) {
                            etiquetas += listaEtiquetas.get(i).getEtiqueta().getNombre();
                            if (i < listaEtiquetas.size() - 1) {
                                etiquetas += ", ";
                            }
                        }
                %>
                <div class="carta">
                    <div class="card" style="width: 18rem;">
                        <img src="images/ticket.png" class="card-img-top" alt="Evento"/> 
                        <div class="card-body">
                            <h5 class="card-title"><%=e.getTitulo()%></h5>
                            <p class="card-text"><%=e.getLugar()%></p>
                            <p class="card-text"><%=formatoFecha.format(e.getFechaInicio()) + " " + formatoHora.format(e.getHora())%></p>
                            <p class="card-text"><%=etiquetas%></p>
                            <!-- Cambiar id 1 por //evento.getEventoId()// -->
                            <a href="ServletEventoInfo?id=<%=e.getId()%>" class="btn btn-primary">Mis entradas</a>
                        </div>
                    </div>
                </div>
                <%      }
                    }
                %>
            </div>
        </div>
    </body>
</html>
