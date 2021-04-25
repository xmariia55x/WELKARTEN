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

        <style>
            #myBtn {
                display: none;
                position: fixed;
                bottom: 20px;
                right: 30px;
                z-index: 99;
                font-size: 18px;
                border: none;
                outline: none;
                background-color: red;
                color: white;
                cursor: pointer;
                padding: 15px;
                border-radius: 4px;
            }
            #myBtn:hover {
                background-color: #555;
            }
            .row {
                display: flex;
                margin-left:-5px;
                margin-right:-5px;
                justify-content: center

            }

            .column {
                flex: 50%;
                padding: 5px;

            }

            

          

            </style>



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
                <br>
                <br>
                <br>
                <br>

                <!--<button onclick="location.href='InicioSesion.html'">Iniciar sesión</button> -->


                <!-- CONTENIDO -->








                <div class="column">
                    <div class="row">
                        <h1 class="display-4">Eventos próximos</h1>
                        <br>
                        <div class="proximos">
                            <div class="carta">
                                <div class="card" style="width: 18rem;">
                                <img src="images/chatbot.png" class="card-img-top" alt="Evento">
                                <div class="card-body">
                                    <h5 class="card-title">Titulo de la tarjeta</h5>
                                    <p class="card-text">Facebook organiza un evento de chatbots.</p>
                                    <a href="#" class="btn btn-primary">Ver evento</a>
                                    <a href="#" class="btn btn-primary">Borrar</a>
                                    <a href="#" class="btn btn-primary">Editar</a>
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
                                    <a href="#" class="btn btn-primary">Borrar</a>
                                    <a href="#" class="btn btn-primary">Editar</a>
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
                                    <a href="#" class="btn btn-primary">Borrar</a>
                                    <a href="#" class="btn btn-primary">Editar</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">

                    <h1 class="display-4">Eventos finalizados</h1>

                    <div class="finalizados">

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
                </div>
            </div>

            <div>
                <button  id="myBtn" title="NuevoEvento">Crear nuevo Evento</button>
            </div>
        </body>
    </html>
