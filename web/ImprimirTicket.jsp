<%-- 
    Document   : ImprimirTicket
    Created on : 11-may-2021, 9:08:40
    Author     : yeray
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="GestorEventos2021.entity.Entrada"%>
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
        <link href="stylesImprimirTicket.css" rel="stylesheet">
    </head>
    <%
        List<Entrada> listaEntradas = (List<Entrada>) request.getAttribute("listaEntradas");
        Integer compra = (Integer) request.getAttribute("compra");
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        String strEtiqueta = "";
    %>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="jsComprarTicket.js" defer></script>

        <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
            <symbol id="check-circle-fill" fill="currentColor" viewBox="0 0 16 16">
                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
            </symbol>
        </svg>

        <!-- BARRA DE NAVEGACION -->
        <jsp:include page="Navbar.jsp"></jsp:include>
            <!-- FIN BARRA DE NAVEGACION -->
            <br>
            <br>
            <br>
            <br>

        <% if (compra == 1) { %>
        <div class="alert alert-success d-flex align-items-center" role="alert">
            <svg class="bi flex-shrink-0 me-2" width="24" height="24"><use xlink:href="#check-circle-fill"/></svg>
            <div>
                ¡Compra completada con éxito! Pulsa click derecho e imprimir para imprimir tus entradas.
            </div>
        </div>
        <% }%>

        <!-- TICKETS -->
        <% for (Entrada e : listaEntradas) { %>
        <div class="cardWrap">
            <div class="card cardLeft">
                <img src="images/logo_pequeno.png" width="200" height="45" id="titulo">
                <div class="title">
                    <h2><%=e.getEvento().getTitulo()%></h2>
                    <span>evento</span>
                </div>
                <div class="name">
                    <h2><%=e.getUsuario().getNombre() + " " + e.getUsuario().getUsuarioeventos().getApellidos()%></h2>
                    <span>nombre</span>
                </div>
                <div class="name">
                    <h2><%=e.getEvento().getLugar()%></h2>
                    <span>lugar</span>
                </div>
                <div class="informacion_mini">
                    <div class="time">
                        <h2><%=formatoFecha.format(e.getEvento().getFechaInicio())%></h2>
                        <span>fecha</span>
                    </div>
                    <div class="time">
                        <h2><%=formatoHora.format(e.getEvento().getHora())%></h2>
                        <span>hora</span>
                    </div>
                    
                    <% if (e.getFila() != null){ 
                        strEtiqueta = "asiento";
                    %>
                    <div class="time">
                        <h2><%=e.getFila()%></h2>
                        <span>fila</span>
                    </div>
                    <% } else {
                        strEtiqueta = "numero";
                    }%>
                    <div class="time">
                        <h2><%=e.getNumero()%></h2>
                        <span><%=strEtiqueta%></span>
                    </div>
                </div>
            </div>
            <div class="card cardRight">
                <div class="number">
                    <img src="images/ticket.png" width="80" height="80">
                </div>
                <div class="precio"><%=String.format("%.2f",e.getEvento().getCosteEntrada())%>€</div>
                <div class="barcode"></div>
            </div>

        </div>
        
        <% } %>

</body>
</html>
