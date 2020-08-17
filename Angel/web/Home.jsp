

<%@page import="org.owasp.esapi.ESAPI"%>
<%@page import="com.angel.impdao.impusuario"%>
<%@page import="com.angel.dao.Iusuariodao"%>
<%@page import="com.angel.modelo.usuario"%>
<%@page import="com.angel.modelo.cuenta_usuario"%>
<%@page import="com.angel.seguridad.encriptador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Angel-HOME</title>
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
                background: url(imagenes/fondoangelhome.jpg) no-repeat center center fixed;
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
            <li class="blue"><a href="FAQS.jsp"><i class="material-icons left">help</i>Ayuda</a></li>
            <li class="blue"><a href="cerrar_sesion"><i class="material-icons left">power_settings_new</i>Salir</a></li>
        </ul>
        <nav class="blue" style="z-index: 99999">
            <div class="nav-wrapper ">
                <a href="AngelAcercadeNosotros.html" class="brand-logo flow-text center"><i class="material-icons t">cloud</i>Angel</a>
                <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons right">menu</i></a>
                <ul class="right hide-on-med-and-down">
                    <li><a class="dropdown-trigger" href="#!" data-target="dropdown1"><i class="material-icons right">arrow_drop_down</i><i class="material-icons right">account_box</i><% out.print(ESAPI.encoder().decodeForHTML(usua.getNombre())); %></a></li>
                </ul>
            </div>
        </nav> 


        <ul class="sidenav blue" id="mobile-demo"style="margin-top: 4.5em" >
            <li class="blue"><a  class="white-text"><i class="material-icons left white-text">person_pin</i><% out.print("Bienvenido: " + ESAPI.encoder().decodeForHTML(usua.getNombre())); %></a></li>
            <li class="blue white-text"><a href="AngelUsuario.jsp" class="white-text"><i class="material-icons left white-text">edit</i>Editar Información</a></li>
            <li class="blue white-text"><a href="AngelGestionInfantil.jsp" class="white-text"><i class="material-icons left white-text">child_friendly</i>Gestión Infantil</a></li>
            <li class="blue white-text"><a href="AngelLocalizacion.jsp" class="white-text"><i class="material-icons left white-text">my_location</i>Localización</a></li>
            <li class="blue white-text"><a href="FAQS.jsp" class="white-text"><i class="material-icons left white-text">help</i>Ayuda</a></li>
            <li class="blue white-text"><a href="cerrar_sesion" class="white-text"><i class="material-icons left white-text">power_settings_new</i>Cerrar Sesión</a></li>
        </ul>
        <div class="contenedor-principal">
            <div class="container">
                <div class="row">
                    <div class="col s12 white" style="text-align: center"><h5>Estimulación Temprana</h5><p>Da click a cualquiera para ayudar a tu bebé a desarrollarse mejor</p></div>
                    <div class="col s6 m6 l3 ">
                        <div class="card small">
                            <div class="card-image waves-effect waves-block waves-light">
                                <img  alt="bb1" class="activator" src="imagenes/c1.jpg">
                            </div>
                            <div class="card-content">
                                <span class="card-title activator grey-text text-darken-4">Estimulación Temprana 1<i class="material-icons right">more_vert</i></span>
                                <p><a href="AngelEstimulacionTemprana1.jsp">¡Juega aquí!</a></p>
                            </div>
                            <div class="card-reveal">
                                <span class="card-title grey-text text-darken-4">Estimulación Temprana 1<i class="material-icons right">close</i></span>
                                <p style="text-align: center">Angel te brinda la oportunidad de jugar con tu bebé para mejorar las habilidades que el tiene. En el primer nivel desarrollaremos la <b>Memoria.</b></p>
                                <p style="text-align: center">Juego:<u> Memorama</u></p>
                            </div>
                        </div>

                    </div>   

                    <div class="col s6 m6 l3">
                        <div class="card small">
                            <div class="card-image waves-effect waves-block waves-light">
                                <img  alt="bb1" class="activator" src="imagenes/c2.jpg">
                            </div>
                            <div class="card-content">
                                <span class="card-title activator grey-text text-darken-4">Estimulación Temprana 2<i class="material-icons right">more_vert</i></span>
                                <p><a href="AngelEstimulacionTemprana2.jsp">¡Juega aquí!</a></p>
                            </div>
                            <div class="card-reveal">
                                <span class="card-title grey-text text-darken-4">Estimulación Temprana 2<i class="material-icons right">close</i></span>
                                <p style="text-align: center">En el segundo nivel de <i>Estimulación Temprana</i> tu bebé aprenderá a reconstruir una imagen antes vista, a partir de un rompecabezas muy sencillo.</p>
                                <p style="text-align: center">Juego:<u> Rompecabezas</u></p>
                            </div>
                        </div>
                    </div>
                    <div class="col s6 m6 l3">
                        <div class="card small">
                            <div class="card-image waves-effect waves-block waves-light">
                                <img  alt="bb1" class="activator" src="imagenes/c3.jpg">
                            </div>
                            <div class="card-content">
                                <span class="card-title activator grey-text text-darken-4">Estimulación Temprana 3<i class="material-icons right">more_vert</i></span>
                                <p><a href="AngelEstimulacionTemprana3.jsp">¡Juega aquí!</a></p>
                            </div>
                            <div class="card-reveal">
                                <span class="card-title grey-text text-darken-4">Estimulación Temprana 3<i class="material-icons right">close</i></span>
                                <p style="text-align: center">Para aumentar el nivel de desarrollo de tu bebé en el 3er. nivel podrá aprender a identificar formas y colores a través de un Tangram interactivo.</p>
                                <p style="text-align: center">Juego:<u> Tangram </u></p>
                            </div>
                        </div>
                    </div>
                    <div class="col s6 m6 l3">
                        <div class="card small">
                            <div class="card-image waves-effect waves-block waves-light">
                                <img  alt="bb1" class="activator" src="imagenes/c4.jpg">
                            </div>
                            <div class="card-content">
                                <span class="card-title activator grey-text text-darken-4">Estimulación Temprana 4<i class="material-icons right">more_vert</i></span>
                                <p><a href="AngelEstimulacionTemprana4.jsp">¡Juega aquí!</a></p>
                            </div>
                            <div class="card-reveal">
                                <span class="card-title grey-text text-darken-4">Estimulación Temprana 4<i class="material-icons right">close</i></span>
                                <p style="text-align: center">Como último nivel desarrollaremos la capacidad lógica para que el bebé gane un gato.</p>
                                <p style="text-align: center">Juego:<u>Gato </u></p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col s12" style="text-align: center"><h5>¿Qué deseas hacer?</h5>

                        <div class="card">
                            <div class="card-content">
                                <p>En Angel puedes consultar tu seguimiento médico y checar consejos para cuidar a tus niños.</p>
                            </div>
                            <div class="card-tabs">
                                <ul class="tabs tabs-fixed-width light-blue">
                                    <li class="tab col s4"><a class="active" href="#test4">Seguimiento Médico</a></li>
                                    
                                    <li class="tab col s4"><a href="#test6">Consejos</a></li>
                                </ul>
                            </div>
                            <div class="card-content grey lighten-4">
                                <div id="test4">
                                    <i class="material-icons large center">local_hospital</i><H6>Consulta el estado médico de tu bebé aqui.</H6>
                                    <a class="waves-effect waves-light light-blue btn-large" href="gestion_reporte.jsp"><i class="material-icons right">send</i>¡Consultar!</a>

                                </div>
                                
                                <div id="test6">
                                    <i class="material-icons large center">priority_high</i><H6>Ve consejos de gran ayuda para tu hijo.</H6>
                                    <a href="AngelConsejos.jsp" class="waves-effect waves-light light-blue btn-large"><i class="material-icons right">send</i>¡Ver!</a>

                                </div>
                            </div>
                        </div>

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
