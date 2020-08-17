<%-- 
    Document   : mostrar_ticket
    Created on : 4/03/2019, 12:06:32 AM
    Author     : devil
--%>

<%@page import="com.angel.modelo.administrador"%>
<%@page import="com.angel.impdao.impadministrador"%>
<%@page import="com.angel.dao.Iadministradordao"%>
<%@page import="com.angel.modelo.tickets"%>
<%@page import="com.angel.impdao.imptickets"%>
<%@page import="com.angel.dao.Iticketsdao"%>
<%@page import="com.angel.modelo.cuenta_usuario"%>
<%@page import="com.angel.modelo.usuario"%>
<%@page import="com.angel.impdao.impusuario"%>
<%@page import="com.angel.dao.Iusuariodao"%>
<%@page import="com.angel.seguridad.encriptador"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>Angel-ConsultaTicket</title>
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
                background: url(imagenes/walltick.jpg) no-repeat center center fixed;
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
            <li class="blue white-text"><a href="" class="white-text"><i class="material-icons left white-text">my_location</i>Localización</a></li>
            <li class="blue white-text"><a href="FAQS.html" class="white-text"><i class="material-icons left white-text">help</i>Ayuda</a></li>
            <li class="blue white-text"><a href="cerrar_sesion" class="white-text"><i class="material-icons left white-text">power_settings_new</i>Cerrar Sesión</a></li>
        </ul>
        <div class="contenedor-principal">
            <br>
            <div class="col s12 m12 l12 white row container flow-text" style="text-align: center">
                
                <h3><u>¡Aqui está tu ticket!</u></h3>
                <h1><i class="material-icons large black-text">confirmation_number</i></h1>
                <h5><i>¡Esperamos haber sido de ayuda!</i></h5>
                	
		 <%
                    Iticketsdao controla_ticket=new imptickets();
                    int id=Integer.parseInt(String.valueOf(datos_sesion.getAttribute("id_ticket")));
                    tickets boleto=controla_ticket.traeticket(id);
                    Iadministradordao controla_administrador=new impadministrador();
                    administrador admin=controla_administrador.traeadministrador2(boleto.getCorreo_admin());
                %>
                    <p>Numero de ticket: <%out.print(boleto.getId_ticket());%></p>
                    <%
                        if(!(admin==null)){
                    %>
                        <p>Nombre Administrador: <%out.print(admin.getNombre());%></p>
                    <%
                        }
                        else{
                    %>
                        <p>Nombre Administrador: Pendiente la asignacion</p>
                    <%
                        }
                    %>
                    <%
                        if(!(boleto.getCorreo_admin()==null)){
                    %>
                        <p>Correo Administrador: <%out.print(boleto.getCorreo_admin());%></p>
                    <%
                        }
                        else{
                    %>
                        <p>Correo Administrador: Pendiente la asignacion</p>
                    <%
                        }
                    %>
                    <%
                        if(boleto.getEstado()==1){
                    %>
                        <p>Estado de ticket: Pendiente</p>
                    <%
                        }
                    %>
                    <%
                        if(boleto.getEstado()==2){
                    %>
                        <p>Estado de ticket: En proceso</p>
                    <%
                        }
                    %>
                    <%
                        if(boleto.getEstado()==3){
                    %>
                        <p>Estado de ticket: Solucionado</p>
                    <%
                        }
                    %>
                    <%
                        if(boleto.getModulo()==1){
                    %>
                        <p>Modulo: Localizacion</p>
                    <%
                        }
                    %>
                    <%
                        if(boleto.getModulo()==2){
                    %>
                        <p>Modulo: Seguimiento Medico</p>
                    <%
                        }
                    %>
                    <%
                        if(boleto.getModulo()==3){
                    %>
                        <p>Modulo: Estimulacion temprana</p>
                    <%
                        }
                    %>
                    <%
                        if(boleto.getModulo()==4){
                    %>
                        <p>Modulo: Consejos y directorio</p>
                    <%
                        }
                    %>
                    <%
                        if(boleto.getModulo()==5){
                    %>
                        <p>Modulo: Usuario</p>
                    <%
                        }
                    %>
                    <%
                        if(boleto.getModulo()==6){
                    %>
                        <p>Modulo: FAQS</p>
                    <%
                        }
                    %>
                    <p>Pregunta: <%out.print(boleto.getPregunta());%></p>
                    <p>Respuesta: <%out.print(boleto.getRespuesta());%></p>

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