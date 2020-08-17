<%-- 
    Document   : administrador_home_gerente_mantenimiento
    Created on : 28/03/2019, 07:55:09 PM
    Author     : Jesus Abraham
--%>
<%@page import="com.angel.modelo.gerente_mantenimiento"%>
<%@page import="com.angel.impdao.impgerente_mantenimiento"%>
<%@page import="com.angel.dao.Igerente_mantenimientodao"%>
<%@page import="com.angel.seguridad.encriptador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME-Gerente de Mantenimiento</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="icon" type="image/png" href="imagenes/icono.png" />
        <link rel="shortcut icon" href="favicon.ico"> 

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="css/materialize.min.css" media="screen,projection">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/css/materialize.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/js/materialize.min.js"></script>
        <script type="text/javascript" src="js/validaciones.js"></script>
        <style>
            @import url("https://fonts.googleapis.com/css?family=Merienda");
            @import url("https://fonts.googleapis.com/css?family=Julius Sans One");
            body{
                background: url(imagenes/mantenhome1.jpg) no-repeat center center fixed;
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;      
                background-size: cover;
            }   
        </style>
    </head>
    <script>
        function presiona2() {
            setTimeout(function () {
                window.location.replace('AngelLogInGerenteMantenimiento.html');
            }, 0);
        }
    </script>
    <body>
        <%
            HttpSession datos_sesion = request.getSession();
            String correo, contra;
            encriptador descripta = new encriptador();
            correo = descripta.desencriptar((String) (datos_sesion.getAttribute("correo")));
            contra = descripta.desencriptar((String) (datos_sesion.getAttribute("contra")));
            Igerente_mantenimientodao controla_gerente_mantenimiento = new impgerente_mantenimiento();
            gerente_mantenimiento geren = new gerente_mantenimiento(correo, contra, "", "");
            geren = controla_gerente_mantenimiento.traegerente_mantenimiento(geren);
            if (!(geren == null)) {

        %>
        <nav>
            <div class="nav-wrapper yellow darken-2">
                <a href="#" class="brand-logo center"><i class="material-icons">cloud</i>Angel</a>
                <a href="cerrar_sesion_gerente_mantenimiento" data-target="mobile-demo" class="sidenav-trigger right"><i class="material-icons right">power_settings_new</i></a>

                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><a href="cerrar_sesion_gerente_mantenimiento"><i class="material-icons right">power_settings_new</i>Cerrar Sesión</a></li>
                </ul>
            </div>
        </nav><br>
        <div class="row flow-text" style="text-align: center">
            <h2 class="white-text" style="font-family: 'Merienda', cursive; font-size: 200%;">¡Bienvenido Gerente de Mantenimiento!</h2>
            <h5 class="white-text" style="font-family: 'Julius Sans One', monospace; font-weight: bold">¿Qué podemos hacer por ti <% out.print(geren.getNombre()); %>?</h5>
            <div class="row container">
                <div class="col s12 m4">
                    <div class="card">
                        <div class="card-image">
                            <img src="imagenes/mantenanceicon.jpg">
                            <a class="btn-floating halfway-fab waves-effect waves-light yellow darken-2" href="registra_reporte_mantenimiento_gerente.jsp"><i class="material-icons">add</i></a>
                        </div>
                        <div class="card-content blue-grey lighten-3 flow-text" >
                            <h5><a href="registra_reporte_mantenimiento_gerente.jsp" style="color:black; text-decoration:none">Nuevo Reporte</a></h5>
                        </div>
                    </div>
                    
                </div>
                <div class="col s12 m4">
                    <div class="card">
                        <div class="card-image">
                            <img src="imagenes/mantencesearchicon.png">
                            <a class="btn-floating halfway-fab waves-effect waves-light yellow darken-2" href="consulta_reportes_mantenimiento_gerente.jsp"><i class="material-icons">search</i></a>
                        </div>
                        <div class="card-content blue-grey lighten-3 flow-text" >
                            <h5><a href="consulta_reportes_mantenimiento_gerente.jsp" style="color:black; text-decoration:none">Consulta tus reportes</a></h5>
                        </div>
                    </div>
                    
                </div>
                <div class="col s12 m4">
                    <div class="card">
                        <div class="card-image">
                            <img src="imagenes/mantenanceassignicon.png">
                            <a class="btn-floating halfway-fab waves-effect waves-light yellow darken-2" href="asignar_programadores.jsp"><i class="material-icons">business_center</i></a>
                        </div>
                        <div class="card-content blue-grey lighten-3 flow-text" >
                            <h5><a href="asignar_programadores.jsp" style="color:black; text-decoration:none">Asigna reportes</a></h5>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
        <%            } else {
                out.println("<script>alert('Inicia sesion');</script>");
                out.print("<Script>presiona2();</Script>");
            }
        %>
    </body>
</html>
