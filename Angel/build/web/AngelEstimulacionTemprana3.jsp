<%@page import="org.owasp.esapi.ESAPI"%>
<%@page import="com.angel.impdao.impusuario"%>
<%@page import="com.angel.dao.Iusuariodao"%>
<%@page import="com.angel.modelo.usuario"%>
<%@page import="com.angel.modelo.cuenta_usuario"%>
<%@page import="com.angel.seguridad.encriptador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Angel-Estimulación Temprana 3</title>
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
            <li class="blue"><a href="AngelGestionInfantil.jsp"><i class="material-icons left">my_location</i>Ubicación</a></li>
            <li class="blue"><a href="badges.html"><i class="material-icons left">help</i>Ayuda</a></li>
            <li class="blue"><a href="cerrar_sesion"><i class="material-icons left">power_settings_new</i>Salir</a></li>
        </ul>
        <nav class="blue" style="z-index: 99999">
            <div class="nav-wrapper ">
                <a class="brand-logo flow-text center"><i class="material-icons t">extension</i>Estimulación Temprana 3</a>
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
                    <h3 style="text-align: center">Estimulación Temprana 3</h3>
                    <h5 style="text-align: center"><u>¡Colores!</u></h5>
                    <div class="card-panel">
                        <p class="flow-text" style="text-align: center">La ciencia está de acuerdo en que los colores ejercen un poder sobre el estado de ánimo de las personas. Y que también pueden mejorar la concentración, disminuir o aumentar la agresividad, ayudar a conciliar el sueño o estimular la memoria.  Los colores pueden influir también en la conducta de los niños. Te explicamos de qué forma.
                            <br>
                            El <b>blanco</b>: Tal vez pienses que el color más ligado al a creatividad sea el amarillo, o el naranja, por eso de que es vital y transmite energía y optimismo. Pues la realidad es que no es ese color el mejor aliado de la creatividad infantil. Según la interiorista Susana Cots (Girona, España), el color blanco es el mejor color para decorar las habitaciones de nuestros hijos, ya que es el que transmite pureza, calma y orden visual, y por tanto, es el mejor para incentivar la creatividad.  
                            <br>
                            El <b>rojo</b>: Aporta energía y vitalidad, pero también puede producir algo de agresividad. Es recomendable para niños más retraídos o tímidos, y debe evitarse sin embargo en el caso de niños muy movidos, niños con hiperactividad o aquellos niños que tienden a exteriorizar su enfado por medio de rabietas. 
                            <br>

                            El <b>amarillo</b>: Es un color ligado al estímulo intelectual. Como el color rojo, es un color muy vital. También es muy beneficioso para estimular la concentración de los niños. También muy útil para niños con depresión, ya que transmite mucho optimismo.
                            <br>
                            El <b>azul</b>: Se trata de un color relajante que transmite serenidad y paz. Muy indicado para niños con problemas para dormir, ya que beneficia el sueño. Es bueno para niños muy activos, pero no está indicado para niños tranquilos, ya que su exceso puede producir somnolencia.


                            <br>
                            <b>¡Por eso aqui en Angel te traemos un tangram para que puedas jugar!</b><br>
                            <a class="btn-large blue white-text" href="AngelET3Tangram.html"><i class="material-icons right">play_circle_outline</i>¡JUGAR!</a>

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
