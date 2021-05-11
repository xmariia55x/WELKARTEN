<%-- 
    Document   : navbarSesionIniciada
    Created on : 27-abr-2021, 16:57:15
    Author     : maria
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
    </head>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

        <!-- BARRA DE NAVEGACION -->
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light" >
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">
                        <img src="images/logo_pequeno.png" alt="" width="200" height="50">
                    </a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" href="index.jsp">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="conocenos.jsp">Conócenos</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="contactanos.jsp">Contáctanos</a>
                            </li>
                        </ul>
                        <form class="d-flex" style="margin-right: 2em">
                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-primary" type="submit">Buscar</button>
                        </form>
<<<<<<< Updated upstream
                        <br/>
<<<<<<< Updated upstream
                        <input type="button" class="btn btn-primary btn-lg" id="mi_perfil_button" value="Mi perfil" name="mi_perfil_button"
                               onclick="location.href = ''" /> <!-- POR INCLUIR EL SERVLET ADECUADO -->
=======
                        <br/>  
                                                  
                        <button type="button" class="btn btn-primary" name="mi_perfil" id="mi_perfil" onclick="location.href = 'VerPerfil.jsp'">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
                            <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                            </svg>
                            Mi perfil
                        </button>
>>>>>>> Stashed changes
=======
                        <input type="button" class="btn btn-primary btn-lg" id="mi_perfil_button" value= "Mi perfil" name="mi_perfil_button"
                               onclick="location.href = ''" /> <!-- POR INCLUIR EL SERVLET ADECUADO --> 
                        
                        
>>>>>>> Stashed changes
                    </div>
                </div>
            </nav>
        </header>
    </body>
</html>
