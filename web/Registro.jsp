<%-- 
    Document   : Registro
    Created on : 10-abr-2021, 13:02:12
    Author     : yeray
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link href="styles.css" rel="stylesheet">
    </head>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <div class="global_registro">
            <img src="images/logo_pequeno.png" width="400" height="100">

            <form action="ServletCrearUsuario" method="POST">
                <div class="mb-3">
                    <label for="exampleDropdownFormEmail2" class="form-label">Nombre</label>
                    <input type="text" name="nombre_usuario" class="form-control" id="nombre_usuario_registrado" placeholder="Escribe tu nombre aquí" required>
                </div>
                <div class="mb-3">
                    <label for="exampleDropdownFormEmail2" class="form-label">Apellidos</label>
                    <input type="text" name="apellidos_usuario" class="form-control" id="apellidos_usuario_registrado" placeholder="Escribe tus apellidos aquí" required>
                </div>
                <div class="mb-3">
                    <label for="exampleDropdownFormEmail2" class="form-label">NIF</label>
                    <input type="text" name="nif_usuario" class="form-control" id="nif_usuario_registrado" placeholder="Escribe tu NIF aquí" required size="9" maxlength="9">
                </div> 

                <div class="mb-3">
                    <label for="exampleDropdownFormEmail2" class="form-label">Sexo</label> <br/>
                    <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
                        <input type="radio" class="btn-check" name="radio_sexo" id="hombre" value="H" autocomplete="off"/>
                        <label class="btn btn-outline-primary" for="hombre">Hombre</label>

                        <input type="radio" class="btn-check" name="radio_sexo" id="mujer" value="M" autocomplete="off"/>
                        <label class="btn btn-outline-primary" for="mujer">Mujer</label>

                        <input type="radio" class="btn-check" name="radio_sexo" id="otro" value="O" autocomplete="off"/>
                        <label class="btn btn-outline-primary" for="otro">Otro</label>
                    </div> 
                    <!--Sexo: <br/>
                <input type="radio" name="sexo" value="H" />
                <label class="btn btn-outline-primary" for="btnradio1">Hombre</label><br/>
                <input type="radio" name="sexo" value="M" />
                <label class="btn btn-outline-primary" for="btnradio2">Mujer</label><br/>
                <br/> -->
                </div>
                <div class="mb-3">
                    <label for="birthday" class="form-label">Fecha de nacimiento</label>
                    <input type="date" class="form-control" id="fecha_nacimiento" name="fecha_nacimiento_usuario" required>
                </div> 

                <div class="mb-3">
                    <label for="exampleDropdownFormEmail2" class="form-label">Domicilio</label>
                    <input type="text" name="domicilio_usuario" class="form-control" id="domicilio_usuario_registrado" placeholder="Escribe tu domicilio aquí" required>
                </div> 

                <div class="mb-3">
                    <label for="exampleDropdownFormEmail2" class="form-label">Ciudad</label>
                    <input type="text" name="ciudad_usuario" class="form-control" id="ciudad_usuario_registrado" placeholder="Escribe tu ciudad aquí" required>
                </div> 

                <div class="mb-3">
                    <label for="exampleDropdownFormEmail2" class="form-label">Correo electrónico</label>
                    <input type="email" name="correo_usuario" class="form-control" id="email_usuario_registrado" placeholder="email@example.com" required>
                </div>
                <div class="mb-3">
                    <label for="exampleDropdownFormPassword2" class="form-label">Contraseña</label>
                    <input type="password" name="contrasena1_usuario" class="form-control" id="contrasenia_usuario_registrado" placeholder="Contraseña" required>
                </div>

                <div class="mb-3">
                    <label for="exampleDropdownFormPassword2" class="form-label">Repetir contraseña</label>
                    <input type="password" name="contrasena2_usuario" class="form-control" id="contrasenia_usuario_registrado_repetida" placeholder="Repetir contraseña" required>
                </div>
                <div class="d-grid gap-2 col-6 mx-auto">
                    <button type="submit" class="btn btn-primary btn-lg">Regístrate</button>
                </div>
            </form>

        </div>
    </body>
</html>
