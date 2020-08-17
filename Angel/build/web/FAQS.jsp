

<%@page import="com.angel.modelo.preguntas"%>
<%@page import="com.angel.impdao.imppreguntas"%>
<%@page import="com.angel.dao.Ipreguntasdao"%>
<%@page import="com.angel.impdao.imprespuestas"%>
<%@page import="com.angel.dao.Irespuestasdao"%>
<%@page import="com.angel.modelo.respuestas"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
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
        <title>Angel-FAQS</title>
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
            <div class="container">
                <div class="row">
                    <div class="col s12">
                        <ul class="collapsible z-depth-5">
                            <li>
                                <div class="collapsible-header blue white-text ">Ayuda personalizada (Hacer esto despues de verificar las preguntas siguientes)</div>
                                <div class="collapsible-body white"><a href="form_ticket.jsp">Chat</a></div>
                            </li>
                        </ul>
                        <ul class="collapsible z-depth-5">
                            <li>
                                <div class="collapsible-header blue white-text">¿Que es Angel?</div>
                                <div class="collapsible-body white">Es un programada diseñado para salvaguardar la seguridad infantil y servir de apoyo a padres primerizos en la crianza de sus infantes.</div>
                            </li>
                        </ul>
                        <ul class="collapsible z-depth-5">
                            <li>
                                <div class="collapsible-header blue white-text">¿En que me ayuda?</div>
                                <div class="collapsible-body white">Ayuda en muchos aspectos, desde a localizar donde esta el infante tanto dentro como fuera de la casa, a estimular la mente del infante de manera tempara, entro otros, hasta a prevenir una posible enfermedad del infante.</div>
                            </li>
                        </ul>
                        <ul class="collapsible z-depth-5">
                            <li>
                                <div class="collapsible-header blue white-text">¿Como puedo recuperar el acceso a mi cuenta?</div>
                                <div class="collapsible-body white">El acceso a la cuenta solo se puede recuperar teniendo el correo ligado a la cuenta disponible, de otra manera es imposible recuperarla, si se tiene el correo desde la pagina de iniciar sesion seleciona recuperar cuenta, ingresa el correo y asu correo electronico se le enviara el enlace para recuperar el acceso.</div>
                            </li>
                        </ul>
                        <ul class="collapsible z-depth-5">
                            <li>
                                <div class="collapsible-header blue white-text">¿Cuantos infantes puedo registar en el sistema?</div>
                                <div class="collapsible-body white">Se puede registrar el mismo numero de infantes que de dispositivos de seguimiento libres para su uso, en caso de ya no tener de estos libres, ya no se podra registrar a otro infante.</div>
                            </li>
                        </ul>
                        <ul class="collapsible z-depth-5">
                            <li>
                                <div class="collapsible-header blue white-text">¿Se pueden reutilizar los dispositivos de seguimiento?</div>
                                <div class="collapsible-body white">Si, cuando se desvincula uno de estos de algun infante y queda libre, se puede usar con otro infante.</div>
                            </li>
                        </ul>
                        <ul class="collapsible z-depth-5">
                            <li>
                                <div class="collapsible-header blue white-text">¿Angel es seguro?</div>
                                <div class="collapsible-body white">Si, contamos con la tecnologia de vanguardia en cuanto a seguridad se refiere ademas de nuestro algorito diseñado en casa, lo cual mantendra tus datos seguros.</div>
                            </li>
                        </ul>
                        <ul class="collapsible z-depth-5">
                            <li>
                                <div class="collapsible-header blue white-text">¿Como puedo eliminar mi cuenta?</div>
                                <div class="collapsible-body white">En la pantalla de usuario esta el boton para eliminar la cuenta, una vez hecho esta se borrara para siempre del sistema.</div>
                            </li>
                        </ul>
                        <ul class="collapsible z-depth-5">
                            <li>
                                <div class="collapsible-header blue white-text">¿Que pasa con mis datos depues de eliminar mi cuenta?</div>
                                <div class="collapsible-body white">Son eliminados de manera permanente del sistema para que no se les llegue a dar mal uso en cualquier situacion posible.</div>
                            </li>
                        </ul>
                        <ul class="collapsible z-depth-5">
                            <li>
                                <div class="collapsible-header blue white-text">¿Puedo cambiar un sensor de habitacion?</div>
                                <div class="collapsible-body white">Si, y todo lo puedes configurar en la pestaña de configuracion de sensores, ahi puedes asignar que cuarto custodiara que sensor.</div>
                            </li>
                        </ul>
                        <ul class="collapsible z-depth-5">
                            <li>
                                <div class="collapsible-header blue white-text">¿Es necesario un tecnico para configurar mi equipo?</div>
                                <div class="collapsible-body white">No dado que el mismo programa a traves de una interfaz amigable te permite hacerlo de manera eficiente y rapida.</div>
                            </li>
                        </ul>
                        <ul class="collapsible z-depth-5">
                            <li>
                                <div class="collapsible-header blue white-text">¿Necesito estar siempre conectado a internet?</div>
                                <div class="collapsible-body white">Si, para el funcionamiento correcto de Angel se necesita disponer de conexcion continua a internet.</div>
                            </li>
                        </ul>
                        <ul class="collapsible z-depth-5">
                            <li>
                                <div class="collapsible-header blue white-text">¿Solictar mas sensores/dispositivos genera costo extra?</div>
                                <div class="collapsible-body white">Si, pero solo el precio del sensores/dispositivos, de otra forma no tendriamos el capital para fabricarlo.</div>
                            </li>
                        </ul>
                        <ul class="collapsible z-depth-5">
                            <li>
                                <div class="collapsible-header blue white-text">¿Que hacer si un sesor/dispositivo deja de funcionar correctamente?</div>
                                <div class="collapsible-body white">En dado caso que el quipo deje de funcionar de manera correcta por razones ajenas al cliente, se le repondra la totalidad e este con otro sensor/dispositivo igual.</div>
                            </li>
                        </ul>
                        <ul class="collapsible z-depth-5">
                            <li>
                                <div class="collapsible-header blue white-text ">¿Hasta que edad se puede usar Angel en los infantes?</div>
                                <div class="collapsible-body white">Angel de manera general esta diseñada para infantes no mayores a 6 años, pero el dispositivo de seguimiento se puede usar de por vida.</div>
                            </li>
                        </ul>
                        <%
                            try {
                                ArrayList<respuestas> lista_respuestas = new ArrayList();
                                Irespuestasdao contra_respues = new imprespuestas();
                                Ipreguntasdao contra_pregun = new imppreguntas();
                                lista_respuestas = contra_respues.traerespuestas();
                                for (int i = 0; i < lista_respuestas.size(); i++) {
                                    preguntas pregun = contra_pregun.traepreguntas(lista_respuestas.get(i).getId_pregunta());
                        %>
                        <ul class="collapsible z-depth-5">
                            <li>
                                <div class="collapsible-header blue white-text"><%out.print(pregun.getTexto());%></div>
                                <div class="collapsible-body white"><%out.print(lista_respuestas.get(i).getTexto());%></div>
                            </li>
                        </ul>
                        <%
                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                e.printStackTrace();
                            }
                        %>
                        <ul class="collapsible z-depth-5">
                            <li>
                                <div class="collapsible-header blue white-text">Contactanos</div>
                                <div class="collapsible-body white">
                                    <form action="registra_pregunta" method="post">
                                        <div class="input-field col s12 m12 l12">
                                            <input type="text" id="texto_p" class="validate" required name="texto_p">
                                        </div>
                                        <input type="submit" value="Enviar Pregunta" class=" blue white-text btn">
                                    </form>
                                </div>
                            </li>
                        </ul>
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
