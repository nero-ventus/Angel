<%@page import="org.owasp.esapi.ESAPI"%>
<%@page import="com.angel.impdao.impusuario"%>
<%@page import="com.angel.dao.Iusuariodao"%>
<%@page import="com.angel.modelo.usuario"%>
<%@page import="com.angel.modelo.cuenta_usuario"%>
<%@page import="com.angel.seguridad.encriptador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Angel-Estimulación Temprana 2</title>
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
                background: url(imagenes/fondousable.jpg) no-repeat center center fixed;
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
            <li class="blue"><a href="AngelLocalizacion.jsp"><i class="material-icons left">my_location</i>Ubicación</a></li>
            <li class="blue"><a href="badges.html"><i class="material-icons left">help</i>Ayuda</a></li>
            <li class="blue"><a href="cerrar_sesion"><i class="material-icons left">power_settings_new</i>Salir</a></li>
        </ul>
        <nav class="blue" style="z-index: 99999">
            <div class="nav-wrapper ">
                <a class="brand-logo flow-text center"><i class="material-icons t">extension</i>Estimulación Temprana 2</a>
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
            <li class="blue white-text"><a href="AngelLocalizacion.jsp" class="white-text"><i class="material-icons left white-text">my_location</i>Localización</a></li>
            <li class="blue white-text"><a href="badges.html" class="white-text"><i class="material-icons left white-text">help</i>Ayuda</a></li>
            <li class="blue white-text"><a href="cerrar_sesion" class="white-text"><i class="material-icons left white-text">power_settings_new</i>Cerrar Sesión</a></li>
        </ul>

        <div class="contenedor-principal">
            <div class="container">
                <div class="row white">
                    <h3 style="text-align: center">Estimulación Temprana 2</h3>
                    <h5 style="text-align: center"><u>Cognición</u></h5>
                    <div class="card-panel">
                        <p class="flow-text" style="text-align: center">u bebé ya ha empezado a mostrar signos de que entiende que ciertas acciones traerán ciertos resultados. Ahora repite estas acciones una y otra vez con una mirada de satisfacción y una gran sonrisa en su rostro, se está dando cuenta lentamente de que  tiene el control sobre las cosas.

                            Ahora tu bebé procesa la información más compleja y recuerda durante períodos más prolongados y utiliza esos recuerdos para aprender cosas nuevas más rápidamente. 

                            Otro logro cognitivo importante es la comprensión de la permanencia del objeto: el conocimiento de que incluso si un objeto ya no está a la vista, continúa existiendo. Esta es la base de todos los procesos mentales superiores - el recuerdo, la imaginación, o la capacidad de pensar en algo o alguien que no está físicamente allí.
                            <br><b>¡Por eso aqui en Angel te traemos un rompecabezas para que puedas jugar!</b><br>
                            <a class="btn-large blue white-text" href="AngelET2Rompecabezas.jsp"><i class="material-icons right">play_circle_outline</i>¡JUGAR!</a>

                        </p>

                    </div>
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
