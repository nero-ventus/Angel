<%@page import="org.owasp.esapi.ESAPI"%>
<%@page import="com.angel.impdao.impusuario"%>
<%@page import="com.angel.dao.Iusuariodao"%>
<%@page import="com.angel.modelo.usuario"%>
<%@page import="com.angel.modelo.cuenta_usuario"%>
<%@page import="com.angel.seguridad.encriptador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Angel-Contactos Médicos</title>
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

            tbody {
                display:block;
                height:500px;
                overflow:auto;
            }
            thead, tbody tr {
                display:table;
                width:100%;
                table-layout:fixed;
            }
            thead {
                width: calc( 100% - 1em )
            }
            table {
                width:100%;
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
                color: #2196f3!important;
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
            *::-webkit-input-placeholder {
                /* Google Chrome y Safari */
                color: #757575;
            }
            .switch label input[type=checkbox]:checked+.lever {
                background-color: #64b5f6;
            }

            .switch label input[type=checkbox]:checked+.lever:after {
                background-color: #1565c0;
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
            <li class="blue"><a href="Home.jsp"><i class="material-icons left">home</i>Regresar a Inicio</a></li>
            <li class="blue"><a href="AngelUsuario.jsp"><i class="material-icons left">edit</i>Editar Información</a></li>
            <li class="blue"><a href=""><i class="material-icons left">child_friendly</i>Gestión Infantil</a></li>
            <li class="blue"><a href=""><i class="material-icons left">my_location</i>Localización</a></li>
            <li class="blue"><a href="badges.html"><i class="material-icons left">help</i>Ayuda</a></li>
            <li class="blue"><a href="cerrar_sesion"><i class="material-icons left">power_settings_new</i>Cerrar Sesión</a></li>
        </ul>
        <nav class="blue" style="z-index: 99999">
            <div class="nav-wrapper ">
                <a class="brand-logo flow-text center"><i class="material-icons t">contact_mail</i>Contactos Médicos</a>
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
            <li class="blue white-text"><a href="" class="white-text"><i class="material-icons left white-text">child_friendly</i>Gestión Infantil</a></li>
            <li class="blue white-text"><a href="" class="white-text"><i class="material-icons left white-text">my_location</i>Localización</a></li>
            <li class="blue white-text"><a href="badges.html" class="white-text"><i class="material-icons left white-text">help</i>Ayuda</a></li>
            <li class="blue white-text"><a href="cerrar_sesion" class="white-text"><i class="material-icons left white-text">power_settings_new</i>Cerrar Sesión</a></li>
        </ul>

        <div class="contenedor-principal">
            <div class="container">
                <div class="row">
                    <div class="responsive-table table-status-sheet"style="margin-top: 5em">
                        <table class="bordered white">
                            <thead>
                                <tr>
                                    <th class="center flow-text"><H5>Agrega aqui tus contactos médicos</H5></th>
                                    <th class="hide-on-small-only">
                                        <form>
                                            <div class="input-field" style="padding: 0">
                                                <input id="search" type="search" required>
                                                <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                                                <i class="material-icons">close</i>
                                            </div>
                                        </form>
                                    </th>
                                    <th class="center flow-text">
                                        <a class=" btn modal-trigger right blue flow-text" href="#agregarcontacto">  <i class="material-icons right">group_add</i>Añadir Contacto</a>

                                        <!-- Modal Structure -->
                                        <div id="agregarcontacto" class="modal " style="margin-top: 1em">
                                            <div class="modal-content">
                                                <h4>¡Agrega un contacto!</h4>
                                                <form action="agregar_contact" method="post">
                                                    <div class="input-field col s12 m4 l4">
                                                        <input placeholder="Nombre del Contacto" pattern="^[A-Za-z ]+$"  onkeypress="letras()" id="nombre" name="nombre" type="text" class="validate" required>
                                                        <label for="nombre">Nombre</label>
                                                    </div>
                                                    <div class="input-field col s12 m4 l4">
                                                        <input placeholder="Apellido P. del Contacto" pattern="^[A-Za-z ]+$" onkeypress="letras()" id="apellido_p" name="apellido_p" type="text" class="validate" required>
                                                        <label for="apellido_p">Apellido Paterno</label>
                                                    </div>
                                                    <div class="input-field col s12 m4 l4">
                                                        <input placeholder="Apellido M. del Contacto" pattern="^[A-Za-z ]+$" onkeypress="letras()" id="apellido_m" name="apellido_m" type="text" class="validate" required>
                                                        <label for="apellido_m">Apellido Materno</label>
                                                    </div>
                                                    <div class="input-field col s6">
                                                        <input placeholder="Num. Telefónico" pattern="^[0-9]+$" onkeypress="numerico()" id="telefono" name="telefono" type="text" class="validate">
                                                        <label for="telefono">Teléfono</label>
                                                    </div>
                                                    <div class="input-field col s6">
                                                        <input placeholder="E-mail" id="correo" onkeypress="email()" pattern="^(([^<>()\[\]\\.,;:\s@']+(\.[^<>()\[\]\\.,;:\s@']+)*)|('.+'))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$" name="correo" type="text" class="validate">
                                                        <label for="correo">Correo</label>
                                                    </div>
                                                    <button class="btn blue" type="submit" name="action">Guardar<i class="material-icons right">save</i>
                                                    </button>

                                                </form>
                                            </div>

                                        </div></th>
                                </tr>
                                <tr>
                                    <th class="hide-on-med-and-up" colspan="2">
                                        <form>
                                            <div class="input-field" style="padding: 0">
                                                <input id="search" type="search" required>
                                                <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                                                <i class="material-icons">close</i>
                                            </div>
                                        </form>
                                    </th>
                                </tr>
                            </thead>
                            <tbody id="milista">
                                <tr>
                                    <td>
                                        <ul class="collection">
                                            <li class="collection-item avatar">
                                                <i class="material-icons circle blue">account_circle</i>
                                                <span class="title">Número de contacto: id_contacto</span>
                                                <p>Nombre: nombrecompleto_obtenido</p>
                                                <p>Celular: celular_obtenido </p>
                                                <p>Correo: correo_obtenido </p>

                                                <a class=" secondary-content btn modal-trigger blue" href="#editarnumerodeusuario_obtenido"><i class="material-icons right">edit</i>Editar</a>
                                                <!-- Modal Structure -->
                                                <div id="editarnumerodeusuario_obtenido" class="modal" style="margin-top: 1em">
                                                    <div class="modal-content" style="text-align: center">
                                                        <h4 class="center">Contacto numcontacto_obtenido:</h4>
                                                        <h5>Edita tu contacto</h5>
                                                        <div class="switch col s12 m12 l12 ">
                                                            Editar:<br>
                                                            <label>
                                                                No
                                                                <input id="switch_numcontact_obtenido" type="checkbox" onclick="hab_numcontact_obtenido()()">
                                                                <span class="lever"></span>
                                                                Si
                                                            </label>          
                                                        </div>
                                                        <form action="" method="post">
                                                            <div class="input-field col s12 m4 l4">
                                                                <input disabled value="nombre_obtenido" placeholder="Nombre del Contacto" pattern="^[A-Za-z ]+$"  onkeypress="letras()" id="nombre_numcontac_obtenido" name="nombre_numcontac_obtenido" type="text" class="validate" required>
                                                                <label for="nombre">Nombre</label>
                                                            </div>
                                                            <div class="input-field col s12 m4 l4">
                                                                <input disabled value="apellidop_obtenido" placeholder="Apellido P. del Contacto" pattern="^[A-Za-z ]+$" onkeypress="letras()" id="apellido_p_numcontac_obtenido" name="apellido_p_numcontac_obtenido" type="text" class="validate" required>
                                                                <label for="apellido_p">Apellido Paterno</label>
                                                            </div>
                                                            <div class="input-field col s12 m4 l4">
                                                                <input disabled value="apellidom_obtenido" placeholder="Apellido M. del Contacto" pattern="^[A-Za-z ]+$" onkeypress="letras()" id="apellido_m_numcontac_obtenido" name="apellido_m_numcontac_obtenido" type="text" class="validate" required>
                                                                <label for="apellido_m">Apellido Materno</label>
                                                            </div>
                                                            <div class="input-field col s6">
                                                                <input disabled value="num_obtenido" placeholder="Num. Telefónico" pattern="^[0-9]+$" onkeypress="numerico()" id="telefono_numcontac_obtenido" name="telefono_numcontac_obtenido" type="text" class="validate">
                                                                <label for="telefono">Teléfono</label>
                                                            </div>
                                                            <div class="input-field col s6">
                                                                <input disabled value="correo_obtenido" placeholder="E-mail" id="correo_numcontac_obtenido" onkeypress="email()" pattern="^(([^<>()\[\]\\.,;:\s@']+(\.[^<>()\[\]\\.,;:\s@']+)*)|('.+'))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$" name="correo_numcontac_obtenido" type="text" class="validate">
                                                                <label for="correo">Correo</label>
                                                            </div>
                                                            <div class="col s6">
                                                                <button class="btn blue" type="submit" id="btn_numcontact_obtenido" name="action">Guardar<i class="material-icons right">save</i>
                                                                </button>
                                                            </div>
                                                            <div class="col s6  m6 l6 center-align" style="text-align: center">
                                                                <a class="waves-effect waves-light btn red modal-trigger" href="#dardebaja_numcontact_obtenido">Dar De Baja<i class="material-icons right">delete_forever</i>  </a>

                                                            </div>
                                                            <br><br><br><br><br><br><br><br><br><br><br>
                                                        </form>
                                                        <div id="dardebaja_numcontact_obtenido" class="modal">
                                                            <div class="modal-content" style="text-align: center">
                                                                <h4>Dar de Baja</h4>
                                                                <p>¿Está seguro de eliminar este contacto?</p>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <div class="col s6">
                                                                    <a href="" class="modal-close waves-effect red waves-red btn">Cancelar</a>
                                                                </div>
                                                                <div class="col s6">
                                                                    <form>
                                                                        <input type="text" value="numcontact_obtenido" style="display: none">
                                                                        <button class="btn green" type="submit" id="btnbaja_numcontact_obtenido" name="action">Eliminar<i class="material-icons right">check</i>
                                                                        </button>
                                                                    </form>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <script>
                                                            function hab_numcontact_obtenido() {
                                                                if (document.getElementById('switch_numcontact_obtenido').checked)
                                                                {
                                                                    document.getElementById("nombre_numcontac_obtenido").disabled = false;
                                                                    document.getElementById("apellido_p_numcontac_obtenido").disabled = false;
                                                                    document.getElementById("apellido_m_numcontac_obtenido").disabled = false;
                                                                    document.getElementById("telefono_numcontac_obtenido").disabled = false;
                                                                    document.getElementById("correo_numcontac_obtenido").disabled = false;
                                                                    document.getElementById("btn_numcontact_obtenido").disabled = false;

                                                                } else {
                                                                    document.getElementById("nombre_numcontac_obtenido").disabled = true;
                                                                    document.getElementById("apellido_p_numcontac_obtenido").disabled = true;
                                                                    document.getElementById("apellido_m_numcontac_obtenido").disabled = true;
                                                                    document.getElementById("telefono_numcontac_obtenido").disabled = true;
                                                                    document.getElementById("correo_numcontac_obtenido").disabled = true;
                                                                    document.getElementById("btn_numcontact_obtenido").disabled = true;
                                                                }


                                                            }
                                                        </script>
                                                    </div>
                                                </div>

                                            </li>
                                        </ul>  
                                    </td>           
                                </tr>

                            </tbody>
                        </table>
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
