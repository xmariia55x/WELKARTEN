<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates eee
and open the template in the editor.
-->
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link href="styles.css" rel="stylesheet">
        <title>Analista Eventos</title>
    </head>
    <body>     

        <!-- Optional JavaScript; choose one of the two! -->

        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

        <!-- Option 2: Separate Popper and Bootstrap JS -->
        <!--
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
        -->
        
        
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
                <br>
                <br>
                <br>
        
        
        <form>
            
            <div class ="analistaGlobal">
                <!-- TABLA DE CONVERSACIONES -->
                    <table class="table">
                        <thead class = "table-primary">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Nombre estudio</th>
                                <th scope="col">Hacer copia</th>
                                <th scope="col">Modificar estudio</th> 
                                <th scope="col">Info estudio</th>
                                <th scope="col">Eliminar estudio</th>                                
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Conversación 1</td>
                                <td><button class="btn btn-outline-primary copia" type="submit">Hacer copias</button></td>
                                <td><button class="btn btn-outline-primary modificar" type="submit">  Modifica</button></td>
                                <td><button class="btn btn-outline-primary info" type="submit">Info</button></td>
                                <td><button class="btn btn-outline-danger eliminar" type="submit">Eliminar</button></td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>Conversación 2</td>
                                <td><button class="btn btn-outline-primary copia" type="submit">  Hacer copia</button></td>
                                <td><button class="btn btn-outline-primary modificar" type="submit">  Modificar</button></td>
                                <td><button class="btn btn-outline-primary info" type="submit">Info</button></td>
                                <td><button class="btn btn-outline-danger eliminar" type="submit">Eliminar</button></td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td>Conversación 3</td>
                                <td><button class="btn btn-outline-primary copia" type="submit">  Hacer copia</button></td>
                                <td><button class="btn btn-outline-primary modificar" type="submit">  Modificar</button></td>
                                <td><button class="btn btn-outline-primary info" type="submit">Info</button></td>
                                <td><button class="btn btn-outline-danger eliminar" type="submit">Eliminar</button></td>>
                            </tr>
                        </tbody>
                    </table>

                <div class="d-grid gap-2 col-6 mx-auto">
                    <button type="submit" class="btn btn-primary btn-lg">Crear estudio</button>
                </div>
            </div>
        </form>
    </body>
</html>
