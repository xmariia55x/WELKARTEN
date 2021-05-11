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
        Boolean crear = true;
        String crearOEditar = "Crear evento";
        if(!crear){
            crearOEditar = "Editar evento";
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
            <form name="CrearEditarEventoForm">
                <div class="mb-3">
                    <label for="exampleDropdownFormEmail2" class="form-label">Nombre del evento</label>
                    <input type="text" name="nombre_evento" class="form-control" id="nombre_evento" required>
                </div>
                <div class="mb-3">
                    <label for="exampleDropdownFormEmail2" class="form-label">Descripción del evento</label>
                    <input type="text" name="descripcion_evento" class="form-control" id="descripcion_evento" required>
                </div>

                <div class="mb-3">
                    <label for="birthday" class="form-label">Fecha del evento</label>
                    <input type="date" class="form-control" id="fecha_evento" name="fecha_evento" required>
                </div> 

                <div class="mb-3">
                    <label for="birthday" class="form-label">Fecha límite para comprar entradas</label>
                    <input type="date" class="form-control" id="fecha_limite_entradas" name="fecha_limite_entradas" required>
                </div> 

                <div class="mb-3">
                    <label for="exampleDropdownFormEmail2" class="form-label">Coste de la entrada</label>
                    <input type="text" name="coste_entrada_evento" class="form-control" id="coste_entrada_evento" required>
                </div>

                <div class="mb-3">
                    <label for="exampleDropdownFormEmail2" class="form-label">Número máximo de entradas por persona</label>
                    <input type="text" name="aforo_evento" class="form-control" id="aforo_evento" required >
                </div>

                <div class="mb-3">
                    <label for="exampleDropdownFormEmail2" class="form-label">Aforo máximo del evento</label>
                    <input type="text" name="aforo_evento" class="form-control" id="aforo_evento" required >
                </div>

                <label>Selecciona las etiquetas del evento</label> <br>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                    <label class="form-check-label" for="defaultCheck1">
                        Etiqueta de parques
                    </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="defaultCheck2">
                    <label class="form-check-label" for="defaultCheck2">
                        Etiqueta 1
                    </label>
                </div>

                <br>
                <div class="mb-3">
                    <label for="exampleDropdownFormEmail2" class="form-label">Asientos</label> <br/>
                    <input class="form-check-input" type="radio" name="seleccion_asientos" value="" />Sí<br>
                    <input class="form-check-input" type="radio" name="seleccion_asientos" value="" />No<br>
                </div>

                <div class="mb-3">
                    <label for="exampleDropdownFormEmail2" class="form-label">Número de filas de asientos</label>
                    <input type="text" name="filas_evento" class="form-control" id="filas_evento">
                </div> 

                <div class="mb-3">
                    <label for="exampleDropdownFormEmail2" class="form-label">Número de asientos por fila del evento</label>
                    <input type="text" name="asientos_fila_evento" class="form-control" id="asientos_fila_evento">
                </div> 

                <div class="d-grid gap-2 col-6 mx-auto">
                    <button type="submit" class="btn btn-primary btn-lg"><%= crearOEditar %></button>
                </div>
            </form>
        </div>
    </body>

    
</html>