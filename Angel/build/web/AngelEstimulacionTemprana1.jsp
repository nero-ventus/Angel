<%@page import="org.owasp.esapi.ESAPI"%>
<%@page import="com.angel.impdao.impusuario"%>
<%@page import="com.angel.dao.Iusuariodao"%>
<%@page import="com.angel.modelo.usuario"%>
<%@page import="com.angel.modelo.cuenta_usuario"%>
<%@page import="com.angel.seguridad.encriptador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Angel-Estimulación Temprana 1</title>
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
                <a class="brand-logo flow-text center"><i class="material-icons t">extension</i>Estimulación Temprana 1</a>
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
                    <h3 style="text-align: center">Estimulación Temprana 1</h3>
                    <h5 style="text-align: center"><u>Memoria</u></h5>
                    <div class="card-panel">
                        <p class="flow-text" style="text-align: center">El desarrollo de la memoria es fundamental en la vida, es lo que nos ayuda a orientarnos en el tiempo y espacio, a crear hábitos, a relacionarnos con los demás. 

                            Las neuronas encargadas de la memoria se desarrollan desde el tercer trimestre de gestación, por lo que al nacer el bebé ya tiene memoria. El olor favorito es el de su madre y el de la leche materna. Empieza a reconocer voces y algunas caras familiares. Recuerda las voces y los olores, pero no es consciente de qué son o cuándo lo ha percibido antes. Es la memoria inconsciente. Esto le ayuda a entender las rutinas, según pasan las semanas, y es capaz de orientarse en el día, de saber cuándo tiene que dormir o comer, cuándo es de noche o de día. - El lenguaje se desarrolla sobre todo a partir de los dos años, recuerdan nombres de personas, de objetos, colores, formas, puedes leerle cuentos y él se da cuenta si te saltas páginas (porque recuerda la historia), expresa sus sentimientos básicos y los relaciona con situaciones, y parece que en este momento empieza a desarrollar la memoria a largo plazo.
                            <br>
                            - A los tres meses puede identificar sus juguetes. A los seis meses está completamente familiarizado con las personas más cercanas a él: padre, madre, abuelos, hermanos, cuidadoras, por lo que empiezan a extrañar a la gente que no conocen. También son capaces de seguir las costumbres, como qué se hace cuando se cambia el pañal, cómo es la rutina del baño o de ir a dormir. Comprende la relación entre acciones distintas porque las recuerda, por ejemplo si preparas el carrito o le pones el abrigo saben que van a salir a pasear. Si le quitas la ropa creen que se van a bañar. 
                            <br>
                            - A los nueve meses puede saber en qué parte de la casa dejó los juguetes e ir a buscarlos. 
                            <br>
                            - Hacia el año de edad comienza a emplear el lenguaje o sonidos más concretos para señalar y demostrar lo que quiere, y puede relacionar algunos sonidos con situaciones. Puede hacer algún sonido reconocible para nosotros cuando hace algo que reconoce como habitual (ir a casa de los abuelos, ir al parque…) 
                            <br>
                            - A partir de los 3 años de edad el niño tiene una memoria consciente desarrollada, que le permitirá recordar alguna cosa o situación importantes incluso hasta la edad adulta. 
                            <br>
                            <b style="text-align: center">¿Qué podemos hacer para mejorar la memoria del niño?</b><br>
                            Como sugiere Tomás Andrés (profesor de Psicología del desarrollo y de la Educación de la Universidad Complutense de Madrid) podemos potenciarla desde los primeros días de vida. Lo mejor es empezar por los sonidos, música, diálogo, hablarles mucho, aunque el niño aún no lo entienda, pero lo escucha. 

                            Es muy importante acariciar al bebé, le ayuda a reconocer los límites de su propio cuerpo y las distintas sensaciones, roce, presión, caricia. Todo su cuerpecito está lleno de miles de terminaciones nerviosas que se deben estimular. 

                            A partir de los seis meses se pueden mostrar cuentos, describiendo las imágenes y las caras de los personajes. Podemos explicarles cómo se sienten, si están contentos, tristes, enfadados, para que reconozcan los sentimientos (base de la inteligencia emocional). 

                            Desde los ocho meses se reconoce a sí mismo, por lo que podemos enseñarle su imagen en un espejo, y también fotos de familiares, diciéndoles los nombres, quiénes son, dónde estáis, si era un cumpleaños, vacaciones…

                            Desde los 12 meses puedes esconder objetos y que él los encuentre, así como encajables y puzles sencillos, juguetes causa-efecto (si aprieto el botón del león suena un rugido, si pulso la bombilla se enciende la luz). También los juegos tipo 'memory' para desarrollar la memoria visual.
                            <br>
                            <b>¡Por eso aqui en Angel te traemos un memorama para que puedas jugar!</b><br>
                            <a class="btn-large blue white-text" href="AngelET1Memorama.html"><i class="material-icons right">play_circle_outline</i>¡JUGAR!</a>

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
