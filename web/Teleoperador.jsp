<%-- 
    Document   : Teleoperador
    Created on : 25-abr-2021, 12:20:13
    Author     : adric
--%>

<%@page import="java.util.List"%>
<%@page import="GestorEventos2021.entity.Conversacion"%>
<%@page import="GestorEventos2021.entity.Usuario"%>
<html>
    <head>
        <title>TELEOPERADOR</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link href="stylesTeleoperador.css" rel="stylesheet">  
    </head>
    
    <%
        Usuario user = (Usuario)session.getAttribute("usuario");
        List <Conversacion> conversaciones = (List) request.getAttribute("listaConversaciones");
    %>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
            <jsp:include page="navbarSesionIniciada.jsp" />
            <br/>
            <br/>
            <br/>
            <br/>
         
                
                <!-- TABLA DE CONVERSACIONES -->
                    <table class="table">
                        <thead class = "table-primary">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Conversación</th>
                                <th scope="col">Info</th>
                                <th scope="col">Eliminar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                int i = 1;
                                for(Conversacion c : conversaciones) {
                            %>
                                <tr>
                                    <th scope="row"><%= i %></th>
                                    <td><%= c.getId() %></td>
                                    <td><button class="btn btn-outline-primary" type="submit">Info</button></td>
                                    <td><button class="btn btn-outline-danger" type="submit">Eliminar</button></td>
                                </tr>
                            <%
                                i++;
                                }
                            %>
                            
                            
                        </tbody>
                    </table>
                
                <!-- BOTONACO DE PETICIONES -->
                <div class="d-grid gap-2 col-6 mx-auto">
                   
                <input type="button" class="btn btn-primary btn-lg" id="peticiones_teleoperador" value="Peticiones" name="peticiones_teleoperador"
                                       onclick="location.href = 'PeticionesTeleoperador.jsp'" />
                </div>
    </body>
</html>
