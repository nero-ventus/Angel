<%@page import="org.owasp.esapi.ESAPI"%>
<%@page import="com.angel.impdao.impusuario"%>
<%@page import="com.angel.dao.Iusuariodao"%>
<%@page import="com.angel.modelo.usuario"%>
<%@page import="com.angel.modelo.cuenta_usuario"%>
<%@page import="com.angel.seguridad.encriptador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Angel-Ubicación</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/png" href="imagenes/icono.png" />

        <link rel="shortcut icon" href="favicon.ico"> 
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link rel="stylesheet" href="css/materialize.min.css" media="screen,projection">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/css/materialize.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/js/materialize.min.js"></script>
        <script type="text/javascript" src="js/validaciones.js"></script>

        <style>
            body{
                background: url(imagenes/fondoubicacion.jpg) no-repeat center center fixed;
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;      
                background-size: cover;
            }  
            .dropdown-content li>a {
                color: white !important;
            }
            nav{
                position: fixed;
                top: 0;
                z-index: 1;
            }

            .contenedor-principal{
                margin-top: 4.5em;
                position: relative;
                z-index: 0;
            }

        </style>
    </head>
    <script>
        function presiona2() {
            setTimeout(function () {
                window.location.replace('AngelLogIn.html');
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
            int valida = 0;
            Iusuariodao user = new impusuario();
            usuario usua = null;

            cuenta_usuario cuenta = null;
            try {
                cuenta = new cuenta_usuario(correo, contra, 0, "0");
                valida = 1;
            } catch (Exception e) {
                out.println("<script>alert('Datos erroneos');</script>");
                out.print("<Script>presiona2();</Script>");
            }
            if (valida == 1) {
                usua = user.traeusuario(cuenta);

                if (!(usua == null)) {
        %>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
        <script>
        $(document).ready(function () {
            $('.sidenav').sidenav();
            $(".dropdown-trigger").dropdown();
            $('.modal').modal();

        });
        </script>
        <ul id="dropdown1" class="dropdown-content">
            <li class="blue"><a href="Home.jsp"><i class="material-icons left">home</i>Inicio</a></li>
            <li class="blue"><a href="AngelUsuario.jsp"><i class="material-icons left">edit</i>Usuario</a></li>
            <li class="blue"><a href="AngelGestionInfantil.jsp"><i class="material-icons left">child_friendly</i>Niños</a></li>
            <li class="blue"><a href=""><i class="material-icons left">help</i>Ayuda</a></li>
            <li class="blue"><a href="cerrar_sesion"><i class="material-icons left">power_settings_new</i>Salir</a></li>
        </ul>
        <nav class="blue" style="z-index: 99999">
            <div class="nav-wrapper ">
                <a class="brand-logo flow-text center hide-on-small-only"><i class="material-icons t">my_location</i>Angel Ubicación</a>
                <a class="brand-logo flow-text center hide-on-med-and-up"><i class="material-icons t">my_location</i>Ubicacion</a>
                <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons right">menu</i></a>
                <ul class="right hide-on-med-and-down">
                    <li><a class="dropdown-trigger" href="#!" data-target="dropdown1"><i class="material-icons right">arrow_drop_down</i><i class="material-icons right">account_box</i><% out.print(ESAPI.encoder().decodeForHTML(usua.getNombre())); %></a></li>
                </ul>
            </div>
        </nav> 


        <ul class="sidenav blue" id="mobile-demo"style="margin-top: 4.5em" >
            <li class="blue white-text"><a  class="white-text"><i class="material-icons left white-text">person_pin</i><% out.print("Bienvenido: " + ESAPI.encoder().decodeForHTML(usua.getNombre()));%></a></li>
            <li class="blue white-text" ><a href="Home.jsp" class=" white-text"><i class="material-icons left white-text">home</i>Regresar a Inicio</a></li>
            <li class="blue white-text"><a href="AngelUsuario.jsp" class="white-text"><i class="material-icons left white-text">edit</i>Editar Información</a></li>
            <li class="blue white-text"><a href="AngelGestionInfantil.jsp" class="white-text"><i class="material-icons left white-text">child_friendly</i>Gestión Infantil</a></li>
            <li class="blue white-text"><a href="AngelAyuda.jsp" class="white-text"><i class="material-icons left white-text">help</i>Ayuda</a></li>
            <li class="blue white-text"><a href="cerrar_sesion" class="white-text"><i class="material-icons left white-text">power_settings_new</i>Cerrar Sesión</a></li>
        </ul>

        <div class="contenedor-principal">
            <div class="row">
                <div class="blue accent-3 card-panel col s12 m6 l6 white-text flow-text" style="text-align: center">
                    <h4><u>Ubicación en exteriores <i class="material-icons small">language</i></u></h4>
                    <p>Con esta opción podrás ver la ubicación de tu infante en cualquier parte del mundo, en cualquier instante con solo un click. ¡Asi de fácil!</p>
                    <div class="col offset-s3 s6">
                        <img class="responsive-img" src="https://image.flaticon.com/icons/png/512/183/183595.png">
                    </div>
                    <a href="simula_externa.jsp" class="waves-effect waves-light btn-large white blue-text col s2 offset-s5"><h5>¡Ir!</h5></a>

                </div>
                <div class="darken-4 blue card-panel col s12 m6 l6 white-text flow-text" style="text-align: center">
                    <h4><u>Ubicación en casa <i class="material-icons small">home</i></u></h4>
                    <p>Al elegir esta opción podrás observar los movimientos de tu bebé en casa a través del paquete de sensores que Angel te proporcionará al contratar su servicio.</p>
                    <div class="col offset-s3 s6">
                        <img class="responsive-img" src="http://mybankmantra.com/images/backgrounds/home-loan-section1.png">
                    </div>
                    <a href="AngelLocalCasa.jsp" class="waves-effect waves-light btn-large white blue-text col s2 offset-s5"><h5>¡Ir!</h5></a>

                </div>
            </div>
        </div>

        <%
                } else {
                    out.println("<script>alert('Inicia sesion primero');</script>");
                    out.print("<Script>presiona2();</Script>");
                }
            }
        %>
    </body>
</html>
