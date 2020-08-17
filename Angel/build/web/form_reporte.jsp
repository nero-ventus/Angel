
<%@page import="org.owasp.esapi.ESAPI"%>

<%@page import="com.angel.modelo.infante"%>
<%@page import="com.angel.impdao.impinfante"%>
<%@page import="com.angel.dao.Iinfantedao"%>
<%@page import="java.util.Date"%>
<%@page import="com.angel.impdao.impusuario"%>
<%@page import="com.angel.modelo.cuenta_usuario"%>
<%@page import="com.angel.modelo.usuario"%>
<%@page import="com.angel.dao.Iusuariodao"%>
<%@page import="com.angel.seguridad.encriptador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Angel-Formulario Médico</title>
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
                background: url(imagenes/walldoc.jpg) no-repeat center center fixed;
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
            *::-webkit-input-placeholder {
                /* Google Chrome y Safari */
                color: #757575;
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
                    int id_infan = Integer.parseInt(request.getParameter("id_infa"));
                    datos_sesion.setAttribute("id_infante", id_infan);
                    Date fecha = new Date();
                    Iinfantedao controla_ninos = new impinfante();
                    infante infan = controla_ninos.traeinfante(id_infan, correo);
                    Date naci = infan.getFecha_naci();
                    Date hoy = new Date();
                    long cuanto = (hoy.getTime() - naci.getTime());
                    cuanto = cuanto / 1000 / 60 / 60 / 24 / 365;
                    String fecha_hoy = (hoy.getYear() + 1900) + "-";
                    if ((hoy.getMonth() + 1) < 10) {
                        fecha_hoy += "0" + (hoy.getMonth() + 1) + "-";
                    } else {
                        fecha_hoy += (hoy.getMonth() + 1) + "-";
                    }
                    if ((hoy.getDate()) < 10) {
                        fecha_hoy += "0" + (hoy.getDate());
                    } else {
                        fecha_hoy += (hoy.getDate());
                    }
        %>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
        <script>
        $(document).ready(function () {
            $('.sidenav').sidenav();
            $(".dropdown-trigger").dropdown();
            $('.modal').modal();
            $('select').formSelect();
            $('.fixed-action-btn').floatingActionButton();
        });
        </script>

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
            <a class="brand-logo flow-text center hide-on-small-only"><i class="material-icons t">local_hospital</i>Reporte Médico</a>
            <a class="brand-logo flow-text center hide-on-med-and-up"><i class="material-icons t">local_hospital</i>Reporte</a>
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
                <h3 style="text-align: center">Formulario Médico</h3>
                <h5 style="text-align: center">Coloca aquí los datos médicos de tu bebé</h5>
                <form action="registra_reporte" method="post">
                    <div class="input-field col s6 m3 l2">
                        <input type="date" id="fecha_r" name="fecha_r" required readonly value="<%out.print(fecha_hoy);%>">
                        <label for="fecha_r">Fecha reporte:</label>
                    </div>
                    <div class="input-field col s6 m3 l2">
                        <input type="text" id="nombre" name="nombre"  required placeholder="Nombre" value="<%out.print(infan.getNombre());%>" readonly>
                        <label for="nombre">Nombre:</label>
                    </div>
                    <div class="input-field col s6 m1 l1">
                        <input type="text" id="edad" name="edad" required placeholder="Edad" readonly value="<%out.print((int) (cuanto));%>">
                        <label for="edad">Edad:</label>
                    </div>
                    <div class="input-field col s6 m1 l1">
                        <input type="text" id="temperatura" onkeypress="numerico()" name="temperatura" required placeholder="Temperatura">
                        <label for="temperatura">Temp.°C:</label>
                    </div>
                    <div class="input-field col s6 m2 l2">
                        <input type="text" id="talla" name="talla" onkeypress="numerico()" required placeholder="Altura">
                        <label for="talla">Altura(cm):</label>
                    </div>
                    <div class="input-field col s6 m2 l2">
                        <input type="text" id="peso" name="peso" onkeypress="numerico()" required placeholder="Peso">
                        <label for="peso">Peso(kg):</label>
                    </div>

                    <div class="input-field col s6 m2 l2">
                        <input type="text" id="frecuencia_c" onkeypress="numerico()" name="frecuencia_c" required placeholder="Frecuencia Cardiaca">
                        <label class="hide-on-small-only" for="frecuencia_c">Frecuencia Cardíaca(lat/min):</label>
                        <label class="hide-on-med-and-up" for="frecuencia_c">Frec. Card.:</label>
                    </div>  

                    <div class="input-field col s6 m2 l2">
                        <select id="color_p" name="color_p" required>
                            <option value="0" selected disabled>Coloración de Piel</option>
                            <option value="1">Normal</option>
                            <option value="2">Palido</option>
                            <option value="3">Colorado</option>
                        </select>
                    </div> 
                    <div class="input-field col s6 m2 l2">
                        <select id="cansancio" name="cansancio" required>
                            <option value="0" selected disabled>Cansancio</option>
                            <option value="1">Si</option>
                            <option value="2">No</option>
                        </select>
                    </div> 
                    <div class="input-field col s6 m2 l2">
                        <select id="dolor_g" name="dolor_g" required>
                            <option value="0" selected disabled>Dolor de Garganta</option>
                            <option value="1">Si</option>
                            <option value="2">No</option>
                        </select>
                    </div> 
                    <div class="input-field col s6 m2 l2">
                        <select id="flema" name="flema" required>
                            <option value="0" selected disabled>Flema</option>
                            <option value="1">No</option>
                            <option value="2">Si: Transparente</option>
                            <option value="3">Si: Verde</option>
                            <option value="4">Si: Blanca</option>
                            <option value="5">Si: Sangrienta</option>
                        </select>
                    </div> 
                    <div class="input-field col s6 m2 l2">
                        <select id="escurrimiento_n" name="escurrimiento_n" required>
                            <option value="0" selected disabled>Escurrimiento Nasal</option>
                            <option value="1">Si</option>
                            <option value="2">No</option>
                        </select>
                    </div> 
                    <div class="input-field col s6 m2 l2">
                        <select id="dolor_a" name="dolor_a" required>
                            <option value="0" selected disabled>Dolor Abdominal</option>
                            <option value="1">No</option>
                            <option value="2">Leve</option>
                            <option value="3">Moderado</option>
                            <option value="4">Intenso</option>
                        </select>
                    </div> 

                    <div class="input-field col s6 m2 l2 offset-l2 offset-m2">
                        <select id="nausea" name="nausea" required>
                            <option value="0" selected disabled>Nauseas</option>
                            <option value="1">Si</option>
                            <option value="2">No</option>
                        </select>
                    </div> 
                    <div class="input-field col s6 m2 l2">
                        <select id="vomito" name="votimo" required>
                            <option value="0" selected disabled>Vómito</option>
                            <option value="1">Si</option>
                            <option value="2">No</option>
                        </select>
                    </div>
                    <div class="input-field col s6 m2 l2">
                        <select id="dolor_c" name="dolor_c" required>
                            <option value="0" selected disabled>Dolor de Cabeza</option>
                            <option value="1">Si</option>
                            <option value="2">No</option>
                        </select>
                    </div> 
                    <div class="input-field col s6 m2 l2">
                        <select id="diarrea" name="diarrea" required>
                            <option value="0" selected disabled>Diarrea</option>
                            <option value="1">Si</option>
                            <option value="2">No</option>
                        </select>
                    </div>          

                    <button  class="btn-large blue  white-text waves-effect waves-light col s6 m2 l2 offset-l5 offset-m5" type="submit" name="action">Guardar<i class="white-text material-icons right">save</i>
                    </button> 
                    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

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