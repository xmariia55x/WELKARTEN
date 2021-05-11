<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    <head>
        <title>WELKARTEN</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link href="styles2.css" rel="stylesheet">
    </head>
    <%
        Integer registrado = (Integer) request.getAttribute("registrado");
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
        <!-- FIN BARRA DE NAVEGACION -->
        <br>
        <br>
        <br>
        <br>        
        <%
            if (registrado == null) {
            } else if (registrado.equals(1)) {
        %>
        <div class="alert alert-success">Usuario registrado con éxito!</div>
        <%
            }
        %>
        <!--<button onclick="location.href='InicioSesion.html'">Iniciar sesión</button> -->
        <h1 class="display-4">Miles de tickets al instante</h1>

        <!--CARRUSEL-->
        <div class="carrusel">
            <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="images/concierto.jpg" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Eventos todas las semanas</h5>
                            <p>Disfruta de los mejores eventos de todas las categorías</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="images/futbol.jpg" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Eventos deportivos</h5>
                            <p>Si eres un amante del deporte, compra tus entradas</p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="images/teatro.jpg" class="d-block w-100" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Eventos artísticos</h5>
                            <p>Representaciones en cualquier parte del mundo</p>
                        </div>
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
        <!--FIN CARRUSEL-->


        <ul class="nav nav-tabs filtro">
            <li class="nav-item">
                <a class="nav-link" name="mostrar_todos_los_eventos">Todos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" name="mostrar_eventos_hoy">Hoy</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" name="mostrar_eventos_semana">Esta semana</a>
            </li>
        </ul>


        <!--
                <div class="mostrar_todos_los_eventos" style="visibility: hidden">
                    <h1 class="display-4">Eventos.</h1>
                </div>
        
                <div class="mostrar_eventos_hoy" style="visibility: hidden">
                    <h1 class="display-4">Eventos de hoy.</h1>
                </div>
        
                <div class="mostrar_eventos_semana" style="visibility: hidden">
                    <h1 class="display-4">Eventos de esta semana.</h1>
                </div>
        -->

        <!-- CONTENIDO -->

        <div class="contenido">
            <div class="carta">
                <div class="card" style="width: 18rem;">
                    <img src="images/chatbot.png" class="card-img-top" alt="Evento">
                    <div class="card-body">
                        <h5 class="card-title">Titulo de la tarjeta</h5>
                        <p class="card-text">Facebook organiza un evento de chatbots.</p>
                        <a href="#" class="btn btn-primary">Ver evento</a>
                    </div>
                </div>
            </div> 
            <div class="carta">
                <div class="card" style="width: 18rem;">
                    <img src="images/chatbot.png" class="card-img-top" alt="Evento"/> 
                    <div class="card-body">
                        <h5 class="card-title">Titulo de la tarjeta</h5>
                        <p class="card-text">Facebook organiza un evento de chatbots.</p>
                        <a href="#" class="btn btn-primary">Ver evento</a>
                    </div>
                </div>
            </div>

            <div class="carta">
                <div class="card" style="width: 18rem;">
                    <img src="images/chatbot.png" class="card-img-top" alt="Evento"/> 
                    <div class="card-body">
                        <h5 class="card-title">Titulo de la tarjeta</h5>
                        <p class="card-text">Facebook organiza un evento de chatbots.</p>
                        <!-- Cambiar id 1 por //evento.getEventoId()// -->
                        <a href="ServletEventoInfo?id=2" class="btn btn-primary">Ver evento</a>
                    </div>
                </div>
            </div>

            <div class="carta">
                <div class="card" style="width: 18rem;">
                    <img src="images/chatbot.png" class="card-img-top" alt="Evento"/> 
                    <div class="card-body">
                        <h5 class="card-title">Titulo de la tarjeta</h5>
                        <p class="card-text">Facebook organiza un evento de chatbots.</p>
                        <a href="ServletEventoInfo?id=6" class="btn btn-primary">Ver evento</a>
                    </div>
                </div>
            </div>

            <div class="carta">
                <div class="card" style="width: 18rem;">
                    <img src="images/chatbot.png" class="card-img-top" alt="Evento"/> 
                    <div class="card-body">
                        <h5 class="card-title">Titulo de la tarjeta</h5>
                        <p class="card-text">Facebook organiza un evento de chatbots.</p>
                        <a href="#" class="btn btn-primary">Ver evento</a>
                    </div>
                </div>
            </div>

            <div class="carta">
                <div class="card" style="width: 18rem;">
                    <img src="images/chatbot.png" class="card-img-top" alt="Evento"/> 
                    <div class="card-body">
                        <h5 class="card-title">Titulo de la tarjeta</h5>
                        <p class="card-text">Facebook organiza un evento de chatbots.</p>
                        <a href="#" class="btn btn-primary">Ver evento</a>
                    </div>
                </div>
            </div>
        </div>

        <!--<div class="row" >
        </div> -->


    </body>
</html>
