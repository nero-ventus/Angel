<%-- 
    Document   : administrador_home_programador
    Created on : 28/03/2019, 09:17:43 PM
    Author     : Jesus Abraham
--%>

<%@page import="com.angel.modelo.programador"%>
<%@page import="com.angel.impdao.impprogramador"%>
<%@page import="com.angel.dao.Iprogramadordao"%>
<%@page import="com.angel.seguridad.encriptador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME-Programador</title>
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
            body{
                background: url(imagenes/wallprogram.png) no-repeat center center fixed;
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
                window.location.replace('AngelLogInProgramador.html');
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
            Iprogramadordao controla_programador = new impprogramador();
            programador program = new programador(correo, contra, "", "");
            program = controla_programador.traeprogramador(program);
            if (!(program == null)) {

        %>
        <nav>
            <div class="nav-wrapper green darken-3">
                <a href="#" class="brand-logo center"><i class="material-icons">cloud</i>Angel</a>
                <a href="cerrar_sesion_programador" data-target="mobile-demo" class="sidenav-trigger right"><i class="material-icons right">power_settings_new</i></a>

                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li><a href="cerrar_sesion_programador"><i class="material-icons right">power_settings_new</i>Cerrar Sesión</a></li>
                </ul>
            </div>
        </nav><br>
        <div class="row flow-text">
            <div class="row container">
                <div class="col s12 m5 offset-m1">
                    <div class="card">
                        <div class="card-image">
                            <img src="imagenes/programreport.png">
                            <a class="btn-floating halfway-fab waves-effect waves-light green darken-2" href="registra_reporte_mantenimiento_programador.jsp"><i class="material-icons">add</i></a>
                        </div>
                        <div class="card-content blue-grey lighten-3 flow-text" >
                            <h5><a href="registra_reporte_mantenimiento_programador.jsp" style="color:black; text-decoration:none">Genera Reporte</a></h5>
                        </div>
                    </div>
                </div>
                <div class="col s12 m5">
                    <div class="card">
                        <div class="card-image">
                            <img src="imagenes/programsearch.png">
                            <a class="btn-floating halfway-fab waves-effect waves-light green darken-2" href="consulta_reportes_mantenimiento_programador.jsp"><i class="material-icons">search</i></a>
                        </div>
                        <div class="card-content blue-grey lighten-3 flow-text" >
                            <h5><a href="consulta_reportes_mantenimiento_programador.jsp" style="color:black; text-decoration:none">Consulta tus reportes</a></h5>
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
