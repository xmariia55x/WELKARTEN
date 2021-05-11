<%-- 
    Document   : InfoEvento
    Created on : 20-abr-2021, 12:17:36
    Author     : yeray
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="GestorEventos2021.entity.Evento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>WELKARTEN</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link href="stylesInfoEvento.css" rel="stylesheet">
        <script>
            document.addEventListener("DOMContentLoaded", function() {
                var comprarEntradas = document.querySelector('#comprarEntradas');
                var selectorEntradas = document.querySelector('#nEntradas');
                var nEntradas;

                /* Almacenar cuantas entradas quiere comprar */
                comprarEntradas.addEventListener('click', function(){
                    nEntradas = Number(selectorEntradas.value);
                    localStorage.setItem("nEntradas",nEntradas);
                });

            });
        </script>
    </head>
    <%
        Evento evento = (Evento) request.getAttribute("evento");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = formato.format(evento.getFechaInicio());
        DecimalFormat moneyFormat1 = new DecimalFormat("#.00");
        String precio = moneyFormat1.format(evento.getCosteEntrada());
    %>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        
        <!-- BARRA DE NAVEGACION -->
        <jsp:include page="Navbar.jsp"></jsp:include>
        <!-- FIN BARRA DE NAVEGACION -->
        <br>
        <br>
        <br>
        <br>

        <h1 class="display-4"><strong> <%=evento.getTitulo()%> </strong></h1>


        <!-- IMAGEN DEL EVENTO -->
        <img src="images/teatro.jpg" class="img-fluid image-info" alt="">

        <!-- APARTADO DE COMPRA DEL EVENTO -->
        <!-- 3 CASOS -->
        <!-- 1. Si el usuario no ha iniciado sesión, al pulsar el botón de comprar le redirige a iniciar sesión -->
        <!-- 2. Si el evento no tiene asientos, aparece un selector del número de tickets.
        <!-- 3. Si el evento tiene asientos, no aparece el selector del número de tickets y le redirige a una ventana de selección de asientos -->
        <div class="comprarTicket">
            <div class ="infoEvento">
                <form action="ServletReservarTicketEvento">
                    <input type="hidden" name="idEvento" value="<%=evento.getId()%>" />
                    <strong>Fecha:  </strong><label><%=fecha%></label></br></br>
                    <strong>Hora:  </strong><label></label></br></br>
                    <strong>Lugar:  </strong><label></label></br></br>
                    <strong>Precio:  </strong><label><%=precio%>&euro;</label></br></br>
                    <strong>Nº de entradas: </strong>
                    <input type="number" min="1" max="<%=evento.getEntradasMax()%>" id ="nEntradas" name="nEntradas" value="1"/></br></br>

                    <input type="submit" id="comprarEntradas" class="btn btn-primary btn-lg" value="Comprar"/>
                </form>
            </div>
        </div>

        <div class="descripcion_evento">
            <h2><strong>Descripción</strong></h2>
            <p><%=evento.getDescripcion()%></p>        
        </div>

        <div class="pie_pagina">
            <div class="row pie_pagina_texto">
                <div class="col-12 col-md">
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="d-block mb-2" role="img" viewBox="0 0 24 24"><title>Product</title><circle cx="12" cy="12" r="10"/><path d="M14.31 8l5.74 9.94M9.69 8h11.48M7.38 12l5.74-9.94M9.69 16L3.95 6.06M14.31 16H2.83m13.79-4l-5.74 9.94"/></svg>
                    <small class="d-block mb-3 text-muted">&copy; 2017–2021</small>
                </div>
                <div class="col-6 col-md">
                    <h5>Features</h5>
                    <ul class="list-unstyled text-small">
                        <li><a class="link-secondary" href="#">Cool stuff</a></li>
                        <li><a class="link-secondary" href="#">Random feature</a></li>
                        <li><a class="link-secondary" href="#">Team feature</a></li>
                        <li><a class="link-secondary" href="#">Stuff for developers</a></li>
                        <li><a class="link-secondary" href="#">Another one</a></li>
                        <li><a class="link-secondary" href="#">Last time</a></li>
                    </ul>
                </div>
                <div class="col-6 col-md">
                    <h5>Resources</h5>
                    <ul class="list-unstyled text-small">
                        <li><a class="link-secondary" href="#">Resource name</a></li>
                        <li><a class="link-secondary" href="#">Resource</a></li>
                        <li><a class="link-secondary" href="#">Another resource</a></li>
                        <li><a class="link-secondary" href="#">Final resource</a></li>
                    </ul>
                </div>
                <div class="col-6 col-md">
                    <h5>Resources</h5>
                    <ul class="list-unstyled text-small">
                        <li><a class="link-secondary" href="#">Business</a></li>
                        <li><a class="link-secondary" href="#">Education</a></li>
                        <li><a class="link-secondary" href="#">Government</a></li>
                        <li><a class="link-secondary" href="#">Gaming</a></li>
                    </ul>
                </div>
                <div class="col-6 col-md">
                    <h5>About</h5>
                    <ul class="list-unstyled text-small">
                        <li><a class="link-secondary" href="#">Team</a></li>
                        <li><a class="link-secondary" href="#">Locations</a></li>
                        <li><a class="link-secondary" href="#">Privacy</a></li>
                        <li><a class="link-secondary" href="#">Terms</a></li>
                    </ul>
                </div>
            </div>
        </div>

    </body>
</html>
