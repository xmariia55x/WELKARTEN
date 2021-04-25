<%-- 
    Document   : Teleoperador
    Created on : 25-abr-2021, 12:20:13
    Author     : adric
--%>

<html>
    <head>
        <title>TELEOPERADOR</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
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
                <!-- FIN BARRA DE NAVEGACION -->
                
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
                            <tr>
                                <th scope="row">1</th>
                                <td>Conversación 1</td>
                                <td><button class="btn btn-outline-primary" type="submit">Info</button></td>
                                <td><button class="btn btn-outline-danger" type="submit">Eliminar</button></td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>Conversación 2</td>
                                <td><button class="btn btn-outline-primary" type="submit">Info</button></td>
                                <td><button class="btn btn-outline-danger" type="submit">Eliminar</button></td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td>Conversación 3</td>
                                <td><button class="btn btn-outline-primary" type="submit">Info</button></td>
                                <td><button class="btn btn-outline-danger" type="submit">Eliminar</button></td>
                            </tr>
                        </tbody>
                    </table>
                
                <!-- BOTONACO DE PETICIONES -->
                <div class="d-grid gap-2 col-6 mx-auto">
                    <button type="submit" class="btn btn-primary btn-lg">Peticiones</button>
                </div>
    </body>
</html>
