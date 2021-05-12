<%-- 
    Document   : ImprimirTicket
    Created on : 11-may-2021, 9:08:40
    Author     : yeray
--%>

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
    %>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="jsComprarTicket.js" defer></script>

        <!-- BARRA DE NAVEGACION -->
        <jsp:include page="Navbar.jsp"></jsp:include>
        <!-- FIN BARRA DE NAVEGACION -->
        <br>
        <br>
        <br>
        <br>
            
        <!-- TICKETS -->
        <div class="cardWrap">
            <div class="card cardLeft">
                <img src="images/logo_pequeno.png" width="200" height="45" id="titulo">
                <div class="title">
                    <h2>How I met your Mother</h2>
                    <span>evento</span>
                </div>
                <div class="name">
                    <h2>Vladimir Kudinov</h2>
                    <span>nombre</span>
                </div>
                <div class="name">
                    <h2>Lugar</h2>
                    <span>lugar</span>
                </div>
                <div class="informacion_mini">
                    <div class="time">
                        <h2>00/00/0000</h2>
                        <span>fecha</span>
                    </div>
                    <div class="time">
                        <h2>12:00</h2>
                        <span>hora</span>
                    </div>
                    <div class="time">
                        <h2>5</h2>
                        <span>fila</span>
                    </div>
                    <div class="time">
                        <h2>156</h2>
                        <span>asiento</span>
                    </div>
                </div>

            </div>
            <div class="card cardRight">
                <div class="number">
                    <img src="images/ticket.png" width="80" height="80">
                </div>
                <div class="precio">3€</div>
                <div class="barcode"></div>
            </div>

        </div>

    </body>
</html>
