<%-- 
    Document   : form_ticket
    Created on : 3/03/2019, 10:57:35 PM
    Author     : devil
--%>

<%@page import="org.owasp.esapi.ESAPI"%>
<%@page import="com.angel.modelo.cuenta_usuario"%>
<%@page import="com.angel.modelo.usuario"%>
<%@page import="com.angel.impdao.impusuario"%>
<%@page import="com.angel.dao.Iusuariodao"%>
<%@page import="com.angel.seguridad.encriptador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Angel-Ticket</title>
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

        <style>
            body{
                background: url(imagenes/backtick.jpg) no-repeat center center fixed;
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;      
                background-size: cover;
            }   
            tab a.active {
                color:#4fc3f7!important;
                background-color:#4fc3f7!important;
            }
            .tabs .tab a:hover {
                background-color: #4fc3f7!important;
                color:#FFFFFF!important;
            }
            .tabs .tab a {
                color: #FFFFFF!important;
            }
            .tabs .indicator{
                background-color:black!important;
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


            .dropdown-content li>a {
                color: white !important;
            }
            .preloader-background {
                display: flex;
                align-items: center;
                justify-content: center;
                background-color: #eee;
                position: fixed;
                z-index: 2;
                top: 0;
                left: 0;
                right: 0;
                bottom: 0;
                p {
                    padding-top:240px;
                    margin-left: -60px;
                    opacity: 0.8;
                } 
            }


            .blinking {
                animation: blinker 0.5s linear infinite;
            }
            @keyframes blinker {  
                50% { opacity: 0; }
            }
            .input-field label {
                color: black!important;
            }
            /* label focus color */
            .input-field input[type=text]:focus + label {
                color: black! important;
            }
            /* label underline focus color */
            .input-field input[type=text]:focus {
                border-bottom: 1px solid #0d47a1! important;
                box-shadow: 0 1px 0 0 #0d47a1 ! important;
            }

            .input-field input[type=text].valid {
                border-bottom: 1px solid #76ff03!important;
                box-shadow: 0 1px 0 0 #76ff03!important;
            }

            .input-field input[type=text].invalid {
                border-bottom: 1px solid red !important;
                box-shadow: 0 1px 0 0 red!important;
            }
            /* icon prefix focus color */
            .input-field .prefix.active {
                color: #000;
            }
            .input-field input[type=password]:focus + label {
                color: black! important;
            }
            /* label underline focus color */
            .input-field input[type=password]:focus {
                border-bottom: 1px solid #0d47a1! important;
                box-shadow: 0 1px 0 0 #0d47a1 ! important;
            }

            .input-field input[type=password].invalid {
                border-bottom: 1px solid red !important;
                box-shadow: 0 1px 0 0 red!important;

            }

            .input-field input[type=password].valid {
                border-bottom: 1px solid #76ff03!important;
                box-shadow: 0 1px 0 0 #76ff03!important;
            }
            ul.dropdown-content.select-dropdown li span {
                color: #03a9f4; /* no need for !important :) */
            }   
            
            .input-field input[type=number]:focus + label {
                color: black! important;
            }
            /* label underline focus color */
            .input-field input[type=number]:focus {
                border-bottom: 1px solid #0d47a1! important;
                box-shadow: 0 1px 0 0 #0d47a1 ! important;
            }

            .input-field input[type=number].invalid {
                border-bottom: 1px solid red !important;
                box-shadow: 0 1px 0 0 red!important;

            }

            .input-field input[type=number].valid {
                border-bottom: 1px solid #76ff03!important;
                box-shadow: 0 1px 0 0 #76ff03!important;
            }
            ul.dropdown-content.select-dropdown li span {
                color: #03a9f4; /* no need for !important :) */
            }   
            *::-webkit-input-placeholder {
                /* Google Chrome y Safari */
                color: #757575;
            }


        </style>
        <script>
            function presiona2() {
                setTimeout(function () {
                    window.location.replace('AngelLogIn.html');
                }, 0);
            }
        </script>
    </head>
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

            });
        </script>
        <script>
            $(document).ready(function () {
                $('.sidenav').sidenav();
                $('select').formSelect();
                $('.fixed-action-btn').floatingActionButton();
            });
        </script>
        <script>

            document.addEventListener("DOMContentLoaded", function () {
                $('.preloader-background').delay(1700).fadeOut('slow');

                $('.preloader-wrapper')
                        .delay(1700)
                        .fadeOut();
            });
        </script>
        <!-- Preloader and it's background. -->
        <div class="preloader-background">
            <div class="preloader-wrapper big active">
                <div class="spinner-layer spinner-blue">
                    <div class="circle-clipper left">
                        <div class="circle"></div>
                    </div><div class="gap-patch">
                        <div class="circle"></div>
                    </div><div class="circle-clipper right">
                        <div class="circle"></div>
                    </div>
                </div>

                <div class="spinner-layer spinner-red">
                    <div class="circle-clipper left">
                        <div class="circle"></div>
                    </div><div class="gap-patch">
                        <div class="circle"></div>
                    </div><div class="circle-clipper right">
                        <div class="circle"></div>
                    </div>
                </div>

                <div class="spinner-layer spinner-yellow">
                    <div class="circle-clipper left">
                        <div class="circle"></div>
                    </div><div class="gap-patch">
                        <div class="circle"></div>
                    </div><div class="circle-clipper right">
                        <div class="circle"></div>
                    </div>
                </div>

                <div class="spinner-layer spinner-green">
                    <div class="circle-clipper left">
                        <div class="circle"></div>
                    </div><div class="gap-patch">
                        <div class="circle"></div>
                    </div><div class="circle-clipper right">
                        <div class="circle"></div>
                    </div>
                </div>
            </div>

        </div>

        <ul id="dropdown1" class="dropdown-content">
            <li class="blue"><a href="AngelUsuario.jsp"><i class="material-icons left">edit</i>Usuario</a></li>
            <li class="blue"><a href="AngelGestionInfantil.jsp"><i class="material-icons left">child_friendly</i>Niños</a></li>
            <li class="blue"><a href="AngelLocalizacion.jsp"><i class="material-icons left">my_location</i>Ubicación</a></li>
            <li class="blue"><a href="FAQS.html"><i class="material-icons left">help</i>Ayuda</a></li>
            <li class="blue"><a href="cerrar_sesion"><i class="material-icons left">power_settings_new</i>Salir</a></li>
        </ul>
        <nav class="" style="z-index: 99999; background-color: #0976b7">
            <div class="nav-wrapper ">
                <a href="AngelAcercadeNosotros.html" class="brand-logo flow-text center"><i class="material-icons t">cloud</i>Angel</a>
                <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons right">menu</i></a>
                <ul class="right hide-on-med-and-down">
                    <li><a class="dropdown-trigger" href="#!" data-target="dropdown1"><i class="material-icons right">arrow_drop_down</i><i class="material-icons right">account_box</i><% out.print(ESAPI.encoder().decodeForHTML(usua.getNombre()));%></a></li>
                </ul>
            </div>
        </nav> 


        <ul class="sidenav" id="mobile-demo"style="margin-top: 4.5em; background-color: #0976b7" >
            <li class=""><a  class="white-text"><i class="material-icons left white-text">person_pin</i></a></li>
            <li class="white-text"><a href="AngelUsuario.jsp" class="white-text"><i class="material-icons left white-text">edit</i>Editar Información</a><% out.print("Bienvenido: " + ESAPI.encoder().decodeForHTML(usua.getNombre())); %></li>
            <li class="white-text"><a href="AngelGestionInfantil.jsp" class="white-text"><i class="material-icons left white-text">child_friendly</i>Gestión Infantil</a></li>
            <li class="white-text"><a href="" class="white-text"><i class="material-icons left white-text">my_location</i>Localización</a></li>
            <li class="white-text"><a href="FAQS.html" class="white-text"><i class="material-icons left white-text">help</i>Ayuda</a></li>
            <li class="white-text"><a href="cerrar_sesion" class="white-text"><i class="material-icons left white-text">power_settings_new</i>Cerrar Sesión</a></li>
        </ul>
        <div class="contenedor-principal">
            <div class="container row white" style="margin-top: 7em;text-align: center" >
                <br>
                <h4><u>¿Ya hiciste una pregunta?</u></h4>
                <h5>Busca el estado de respuesta con tu número de Ticket</h5>
                <div class="col s12 l12 m12">
                    <form action="buscar_ticket" method="post">
                        <div class="input-field col s6 l4 m4 offset-l4 offset-m4 offset-s3">   
                            <input type="number" class=" validate" required id="ticket" name="ticket" placeholder="Numero de ticket">
                        </div>

                        <button  class="btn col s8 offset-s2  l4 offset-l4 white-text waves-effect waves-light" type="submit" name="action" style="background-color: #0976b7">Buscar<i class="white-text material-icons right">search</i>
                        </button>    
                    </form>
                </div>
                <div class="col s12 m12 l12">
                    <h4><u>¿Tienes una duda?</u></h4>
                    <h5>Ingresa el módulo de tu duda y tu pregunta</h5>
                    <form action="registra_ticket" method="post">
                        <div class="input-field col s12 m4 l4 offset-l4 offset-m4">
                            <select name="modulo" class=" blue-text validate flow-text" required>
                                <option value="0" disabled selected>Seleccione el modulo del problema</option>
                                <option value="1">Localizacion</option>
                                <option value="2">Seguimiento medico</option>
                                <option value="3">Estimulacion temprana</option>
                                <option value="4">Consejos y directorio</option>
                                <option value="5">Usuario</option>
                                <option value="6">FAQS</option>
                            </select>
                        </div>
                        <div class="input-field col s12 m6 l6 offset-l3 offset-m3">
                            <input type="text"  class="validate" required id="pregunta"  name="pregunta" placeholder="Pregunta personal">
                        </div>
                        <button  class="btn-large col s8 offset-s2  l4 offset-l4 white-text waves-effect waves-light" type="submit" name="action" style="background-color: #0976b7">Enviar<i class="white-text material-icons right">send</i>
                        </button><br><br><br><br><br><br><br><br><br><br><br><br>
                    </form>
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