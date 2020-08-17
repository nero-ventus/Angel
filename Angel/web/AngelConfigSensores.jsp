

<%@page import="com.angel.modelo.cuenta_usuario"%>
<%@page import="com.angel.impdao.impusuario"%>
<%@page import="com.angel.modelo.usuario"%>
<%@page import="com.angel.dao.Iusuariodao"%>
<%@page import="com.angel.seguridad.encriptador"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.angel.modelo.sensores"%>
<%@page import="com.angel.impdao.impsensores"%>
<%@page import="com.angel.dao.Isensoresdao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Angel-Sensores</title>
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
                background: url(imagenes/fondosens.jpg) no-repeat center center fixed;
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
            ul.dropdown-content.select-dropdown li span {
                color: #03a9f4; /* no need for !important :) */
            }   
            *::-webkit-input-placeholder {
                /* Google Chrome y Safari */
                color: #757575;
            }
            .input-field input[type=date]:focus + label {
                color: black! important;
            }
            /* label underline focus color */
            .input-field input[type=date]:focus {
                border-bottom: 1px solid #0d47a1! important;
                box-shadow: 0 1px 0 0 #0d47a1 ! important;
            }

            .input-field input[type=date].invalid {
                border-bottom: 1px solid red !important;
                box-shadow: 0 1px 0 0 red!important;

            }

            .input-field input[type=date].valid {
                border-bottom: 1px solid #76ff03!important;
                box-shadow: 0 1px 0 0 #76ff03!important;
            }
            .input-field input[type=search]:focus + label {
                color: black! important;
            }
            /* label underline focus color */
            .input-field input[type=search]:focus {
                border-bottom: 1px solid #0d47a1! important;
                box-shadow: 0 1px 0 0 #0d47a1 ! important;
            }

            .input-field input[type=search].invalid {
                border-bottom: 1px solid red !important;
                box-shadow: 0 1px 0 0 red!important;

            }

            .input-field input[type=search].valid {
                border-bottom: 1px solid #76ff03!important;
                box-shadow: 0 1px 0 0 #76ff03!important;
            }
            [type="checkbox"].filled-in:checked + span:not(.lever):after {
                top: 0;
                width: 20px;
                height: 20px;
                border: 2px solid #1565c0 ;
                background-color: #90caf9 ;
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
            $('select').formSelect();
        });
        </script>
        <ul id="dropdown1" class="dropdown-content">
            <li class="blue flow-text"><a href="Home.jsp"><i class="material-icons left">home</i>Inicio</a></li>
            <li class="blue flow-text"><a href="AngelUsuario.jsp"><i class="material-icons left">edit</i>Usuario</a></li>
            <li class="blue"><a href="AngelGestionInfantil.jsp"><i class="material-icons left">child_friendly</i>Niños</a></li>
            <li class="blue"><a href="AngelAyuda.jsp"><i class="material-icons left">help</i>Ayuda</a></li>
            <li class="blue flow-text"><a href="cerrar_sesion"><i class="material-icons left">power_settings_new</i>Salir</a></li>
        </ul>
        <nav class="blue" style="z-index: 99999">
            <div class="nav-wrapper ">
                <a class="brand-logo flow-text center"><i class="material-icons t">center_focus_weak</i>Sensores</a>
                <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons right">menu</i></a>
                <ul class="right hide-on-med-and-down">
                    <li><a class="dropdown-trigger" href="#!" data-target="dropdown1"><i class="material-icons right">arrow_drop_down</i><i class="material-icons right">account_box</i><% out.print(ESAPI.encoder().decodeForHTML(usua.getNombre())); %></a></li>
                </ul>
            </div>
        </nav> 


        <ul class="sidenav blue" id="mobile-demo"style="margin-top: 4.5em" >
            <li class="blue white-text flow-text"><a  class="white-text"><i class="material-icons left white-text">person_pin</i><% out.print("Bienvenido: " + ESAPI.encoder().decodeForHTML(usua.getNombre()));%></a></li>
            <li class="blue white-text flow-text" ><a href="Home.jsp" class=" white-text"><i class="material-icons left white-text">home</i>Regresar a Inicio</a></li>
            <li class="blue white-text flow-text"><a href="AngelUsuario.jsp" class="white-text"><i class="material-icons left white-text">edit</i>Editar Información</a></li>
            <li class="blue white-text"><a href="AngelGestionInfantil.jsp" class="white-text"><i class="material-icons left white-text">child_friendly</i>Gestión Infantil</a></li>
            <li class="blue white-text flow-text" ><a href="AngelAyuda.jsp" class="white-text"><i class="material-icons left white-text">help</i>Ayuda</a></li>
            <li class="blue white-text flow-text"><a href="cerrar_sesion" class="white-text"><i class="material-icons left white-text">power_settings_new</i>Cerrar Sesión</a></li>
        </ul>

        <div class="contenedor-principal">
            <div class="container">
                <div class="row">
                    <div class="responsive-table table-status-sheet"style="margin-top: 5em">
                        <table class="bordered white">
                            <thead>
                                <tr>

                                    <th class="center flow-text"><H5>Consulta aqui tus sensores</H5></th>
                                </tr>
                                <tr>

                            </thead>
                            <tbody id="milista">
                                <tr>
                                    <td>
                                        <ul class="collection">
                                            <%
                                                Isensoresdao control_sensores = new impsensores();
                                                ArrayList<sensores> lista_sensores = control_sensores.traeSensores(correo);
                                                if (lista_sensores.size() > 0) {
                                                    for (int i = 0; i < lista_sensores.size(); i++) {
                                            %>

                                            <li class="collection-item avatar">
                                                <i class="material-icons circle blue large">cast_connected</i>
                                                <p>Sensor: <%out.print(lista_sensores.get(i).getId_sensor());%></p>
                                                <p>Cuarto: <%
                                                    if (lista_sensores.get(i).getId_cuarto() == 1) {
                                                        out.print("Dormitorio");
                                                    }
                                                    if (lista_sensores.get(i).getId_cuarto() == 2) {
                                                        out.print("Estudio");
                                                    }
                                                    if (lista_sensores.get(i).getId_cuarto() == 3) {
                                                        out.print("Baño");
                                                    }
                                                    if (lista_sensores.get(i).getId_cuarto() == 4) {
                                                        out.print("Cocina");
                                                    }
                                                    if (lista_sensores.get(i).getId_cuarto() == 5) {
                                                        out.print("Cuarto de lavado");
                                                    }
                                                    if (lista_sensores.get(i).getId_cuarto() == 6) {
                                                        out.print("Comedor");
                                                    }
                                                    if (lista_sensores.get(i).getId_cuarto() == 7) {
                                                        out.print("Sala");
                                                    }
                                                    %></p>
                                                <p>Permiso: <%
                                                    if (lista_sensores.get(i).getEstado_permiso() == 1) {
                                                        out.print("Permitido");
                                                    }
                                                    if (lista_sensores.get(i).getEstado_permiso() == 2) {
                                                        out.print("Prohibido");
                                                    }
                                                    %></p>

                                                <a class=" secondary-content btn modal-trigger blue" href="#editarnumerodebebe_obtenido<%out.print((i + 1));%>"><i class="material-icons right">edit</i>Editar</a>
                                                <!-- Modal Structure -->
                                                <div id="editarnumerodebebe_obtenido<%out.print((i + 1));%>" class="modal modal-fixed-footer" style="margin-top: 1em">
                                                    <div class="modal-content" style="text-align: center">
                                                        <h4 class="center">Sensor: <%out.print((i + 1));%></h4>
                                                        <h5>Edita la información del sensor</h5>
                                                        <div class="switch col s12 m12 l12 ">
                                                            Editar:<br>
                                                            <label>
                                                                No
                                                                <input id="cambia<%out.print((i + 1));%>" type="checkbox" onclick="hab_config<%out.print((i + 1));%>()">
                                                                <span class="lever"></span>
                                                                Si
                                                            </label>          
                                                        </div>
                                                        <form action="actualiza_sensores" id="form<%out.print((i + 1));%>" method="post">
                                                            <div class="hide">
                                                                <input type="text" value="<%out.print(lista_sensores.get(i).getId_cuarto());%>" name="sensor" required>
                                                            </div>
                                                            <div class="input-field col s6 m6 l6" style="display: none" id="cuarto<%out.print((i + 1));%>">
                                                                <select id="cuarto"  name="cuarto" required>
                                                                    <option value="0" selected disabled>Selecciona un cuarto</option>
                                                                    <option value="1">Dormitorio</option>
                                                                    <option value="2">Estudio</option>
                                                                    <option value="3">Baño</option>
                                                                    <option value="4">Cocina</option>
                                                                    <option value="5">Cuarto de lavado</option>
                                                                    <option value="6">Comedor</option>
                                                                    <option value="7">Sala</option>
                                                                </select>
                                                            </div>
                                                            <div class="input-field col s6 m6 l6" style="display: none" id="permiso<%out.print((i + 1));%>">
                                                                <select id="permiso" name="permiso" required>
                                                                    <option value="0" disabled>-Selecciona si el cuarto esta permitido-</option>
                                                                    <option value="1">Permitido</option>
                                                                    <option value="2">Prohibido</option>
                                                                </select>


                                                            </div>
                                                            <div class="col s6 m6 l6" id="cuarto_o<%out.print((i + 1));%>">
                                                                <script>
                                                                    function cambiacuarto<%out.print((i + 1));%>() {
                                                                        document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("cuarto").selectedIndex =<%out.print(lista_sensores.get(i).getId_cuarto());%>;
                                                                        document.getElementById("cuarto_o<%out.print((i + 1));%>").innerHTML = document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("cuarto").options[<%out.print(lista_sensores.get(i).getId_cuarto());%>].text;
                                                                    }
                                                                </script>
                                                                <script>cambiacuarto<%out.print((i + 1));%>();</script>

                                                            </div>
                                                            <div class="col s6 m6 l6" id="permiso_o<%out.print((i + 1));%>">
                                                                <script>
                                                                    function cambiapermiso<%out.print((i + 1));%>() {
                                                                        document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("permiso").selectedIndex =<%out.print(lista_sensores.get(i).getEstado_permiso());%>;
                                                                        document.getElementById("permiso_o<%out.print((i + 1));%>").innerHTML = document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("permiso").options[<%out.print(lista_sensores.get(i).getEstado_permiso());%>].text;
                                                                    }
                                                                </script>
                                                                <script>cambiapermiso<%out.print((i + 1));%>();</script>
                                                            </div>

                                                        
                                                        <button class="btn waves-effect waves-light blue" disabled type="submit"  id="cambiarestado<%out.print((i + 1));%>" name="action">Guardar
                                                            <i class="material-icons right">save</i>
                                                        </button>
                                                        </form>
                                                    </div>
                                                    <script>
                                                        function hab_config<%out.print((i + 1));%>() {
                                                            if (document.getElementById('cambia<%out.print((i + 1));%>').checked)
                                                            {
                                                                document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("sensor").disabled = false;
                                                                document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("permiso").disabled = false;
                                                                document.getElementById("cuarto_o<%out.print((i + 1));%>").setAttribute("style", "display: none");
                                                                document.getElementById("cuarto<%out.print((i + 1));%>").removeAttribute("style");
                                                                document.getElementById("permiso_o<%out.print((i + 1));%>").setAttribute("style", "display: none");
                                                                document.getElementById("permiso<%out.print((i + 1));%>").removeAttribute("style");
                                                                document.getElementById("cambiarestado<%out.print((i + 1));%>").disabled = false;
                                                            } else {

                                                                document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("sensor").disabled = true;
                                                                document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("permiso").disabled = true;
                                                                document.getElementById("permiso_o<%out.print((i + 1));%>").removeAttribute("style");
                                                                document.getElementById("cuarto_o<%out.print((i + 1));%>").removeAttribute("style");
                                                                document.getElementById("cuarto<%out.print((i + 1));%>").setAttribute("style", "display: none");
                                                                document.getElementById("permiso<%out.print((i + 1));%>").setAttribute("style", "display: none");
                                                                document.getElementById("cambiarestado<%out.print((i + 1));%>").disabled = true;
                                                            }

                                                        }
                                                    </script>
                                                </div>
                                                </div>

                                            </li>

                                            <%
                                                }
                                            } else {
                                            %>
                                            <ul class="text-accent-1">
                                                <li class="text-accent-1">No hay registros</li>
                                            </ul>
                                            <%
                                                }
                                            %>
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
