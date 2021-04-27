<%-- 
    Document   : CrearEditarUsuario
    Created on : 25-abr-2021, 13:11:05
    Author     : maria
--%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Usuario</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link href="styles.css" rel="stylesheet">
    </head>
    <% 
        Boolean crear = true;
        String crearOEditar = "Crear usuario";
        if(!crear){
            crearOEditar = "Editar usuario";
        }
    %>
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
                                <a class="nav-link active" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="#">Conócenos</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="#">Contáctanos</a>
                            </li>
                        </ul>
                        <form class="d-flex" style="margin-right: 2em">
                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-primary" type="submit">Buscar</button>
                        </form>
                        <br/>
                        <input type="button" class="btn btn-primary btn-lg" id="inicio_sesion_principal_button" value="Iniciar sesión" name="inicio_sesion_principal_button"
                               onclick="location.href = 'InicioSesion.html'" /> 
                    </div>
                </div>
            </nav>
        </header>
        <br>
        <br>

        <!-- FORMULARIO PARA CREAR UN NUEVO EVENTO -->
        <div class="global_nuevo_evento">
            <form name="CrearEditarUsuarioForm">
                <div class="mb-3">
                    <label for="exampleDropdownFormEmail2" class="form-label">Nombre del usuario</label>
                    <input type="text" name="nombre_usuario" class="form-control" id="nombre_usuario" required>
                </div>
                <div class="mb-3">
                    <label for="exampleDropdownFormEmail2" class="form-label">NIF del usuario</label>
                    <input type="text" name="nif_usuario" class="form-control" id="nif_usuario" required>
                </div>

                <div class="mb-3">
                    <label for="exampleDropdownFormEmail2" class="form-label">Correo electrónico</label>
                    <input type="email" name="correo_usuario" class="form-control" id="email_usuario_registrado" placeholder="email@example.com" required>
                </div>

                <div class="mb-3">
                    <label for="exampleDropdownFormPassword2" class="form-label">Contraseña</label>
                    <input type="password" name="contrasena1_usuario" class="form-control" id="contrasenia_usuario_registrado" required>
                </div>

                <div class="mb-3">
                    <label for="exampleDropdownFormPassword2" class="form-label">Repetir contraseña</label>
                    <input type="password" name="contrasena2_usuario" class="form-control" id="contrasenia_usuario_registrado_repetida" required>
                </div>

                <div class="mb-3">
                    <label for="exampleDropdownFormEmail2" class="form-label">Rol usuario</label> <br/>
                    <input class="form-check-input" type="radio" name="seleccion_rol" value="2" />Creador de eventos<br>
                    <input class="form-check-input" type="radio" name="seleccion_rol" value="3" />Analista<br>
                    <input class="form-check-input" type="radio" name="seleccion_rol" value="5" />Teleoperador<br>

                </div>

                <div class="d-grid gap-2 col-6 mx-auto">
                    <button type="submit" class="btn btn-primary btn-lg"><%= crearOEditar %></button>
                </div>
            </form>
        </div>
    </body>

    
</html>
