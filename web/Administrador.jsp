<%-- 
    Document   : Administrador
    Created on : 25-abr-2021, 13:29:58
    Author     : maria
--%>

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
        <!-- BARRA DE NAVEGACION 
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
        FIN BARRA DE NAVEGACION -->

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
                <!-- TABLA DE USUARIOS -->
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
                        <tr>
                            <th scope="row">Pepe</th>
                            <td>777777p</td>
                            <td>pepito@gmail.com</td>
                            <td>Creador de eventos</td>
                            <td><button class="btn btn-outline-primary" type="submit">Editar</button></td>
                            <td><button class="btn btn-outline-danger" type="submit">Eliminar</button></td>
                        </tr>
                        <tr>
                            <th scope="row">Mario</th>
                            <td>88888p</td>
                            <td>mario@gmail.com</td>
                            <td>Analista</td>
                            <td><button class="btn btn-outline-primary" type="submit">Editar</button></td>
                            <td><button class="btn btn-outline-danger" type="submit">Eliminar</button></td>
                        </tr>
                        <tr>
                            <th scope="row">Antonia</th>
                            <td>11111X</td>
                            <td>antoredes@gmail.com</td>
                            <td>Creador de eventos</td>
                            <td><button class="btn btn-outline-primary" type="submit">Editar</button></td>
                            <td><button class="btn btn-outline-danger" type="submit">Eliminar</button></td>
                        </tr>
                    </tbody>
                </table>
                <!-- BOTONACO DE CREAR USUARIOS -->
                <div class="d-grid gap-2 col-6 mx-auto">
                    <button type="submit" class="btn btn-primary btn-lg">Crear nuevo usuario</button>
                </div>
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
                        <tr>
                            <th scope="row">Recogida de alimentos</th>
                            <td>11/04/2021</td>
                            <td>9/04/2021</td>
                            <td>9 euros</td>
                            <td>20</td>
                            <td><button class="btn btn-outline-primary" type="submit">Editar</button></td>
                            <td><button class="btn btn-outline-danger" type="submit">Eliminar</button></td>
                        </tr>
                        <tr>
                            <th scope="row">Concierto</th>
                            <td>25/04/2021</td>
                            <td>20/04/2021</td>
                            <td>10 euros</td>
                            <td>20</td>
                            <td><button class="btn btn-outline-primary" type="submit">Editar</button></td>
                            <td><button class="btn btn-outline-danger" type="submit">Eliminar</button></td>
                        </tr>
                        <tr>
                            <th scope="row">Carrera</th>
                            <td>1/06/2021</td>
                            <td>30/05/2021</td>
                            <td>Gratis</td>
                            <td>100</td>
                            <td><button class="btn btn-outline-primary" type="submit">Editar</button></td>
                            <td><button class="btn btn-outline-danger" type="submit">Eliminar</button></td>
                        </tr>
                    </tbody>
                </table>
                <!-- BOTONACO DE CREAR EVENTOS -->
                <div class="d-grid gap-2 col-6 mx-auto">
                    <button type="submit" class="btn btn-primary btn-lg">Crear nuevo evento</button>
                </div>
            </div>
        </div>







    </body>
</html>
