<%@page import="com.angel.impdao.impadministrador"%>
<%@page import="com.angel.modelo.administrador"%>
<%@page import="com.angel.dao.Iadministradordao"%>
<%@page import="com.angel.modelo.preguntas"%>
<%@page import="com.angel.impdao.imppreguntas"%>
<%@page import="com.angel.dao.Ipreguntasdao"%>
<%@page import="com.angel.impdao.impafecciones"%>
<%@page import="com.angel.dao.Iafeccionesdao"%>
<%@page import="com.angel.modelo.afecciones"%>
<%@page import="com.angel.modelo.infante"%>
<%@page import="com.angel.impdao.impinfante"%>
<%@page import="com.angel.dao.Iinfantedao"%>
<%@page import="com.angel.modelo.dispositivo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.angel.impdao.impdispositivo"%>
<%@page import="com.angel.dao.Idispositivodao"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%@page import="com.angel.impdao.impusuario"%>
<%@page import="com.angel.dao.Iusuariodao"%>
<%@page import="com.angel.modelo.usuario"%>
<%@page import="com.angel.modelo.cuenta_usuario"%>
<%@page import="com.angel.seguridad.encriptador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Angel-Preguntas de usuarios</title>
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
                background: url(imagenes/wallcode.jpg) no-repeat center center fixed;
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
                border-bottom: 1px solid #795548! important;
                box-shadow: 0 1px 0 0 #795548! important;
            }

            .input-field input[type=text].valid {
                border-bottom: 1px solid #76ff03!important;
                box-shadow: 0 1px 0 0 #76ff03!important;
            }

            .input-field input[type=text].invalid {
                border-bottom: 1px solid red !important;
                box-shadow: 0 1px 0 0 red!important;
            }


            .input-field input[type=search]:focus + label {
                color: black! important;
            }
            .input-field input[type=search]:focus {
                border-bottom: 1px solid #795548! important;
                box-shadow: 0 1px 0 0 #795548! important;
            }

            .input-field input[type=search].valid {
                border-bottom: 1px solid #76ff03!important;
                box-shadow: 0 1px 0 0 #76ff03!important;
            }

            .input-field input[type=search].invalid {
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
            Iadministradordao controla_admi = new impadministrador();
            administrador admi = controla_admi.traeadministrador1(correo, contra);
            if (!(admi == null)) {

        %>

        <nav>
            <div class="nav-wrapper grey darken-1">
                <a  class="brand-logo center flow-text"><i class="material-icons">cloud</i>"Angel"</a>
                <a data-target="mobile-demo" class="sidenav-trigger" href="administrador_home.jsp"><i class="material-icons left white-text">arrow_back</i>Regresar</a>
                <ul id="nav-mobile" class="left hide-on-med-and-down">
                    <li><a href="administrador_home.jsp"><i class="material-icons left">arrow_back</i>Regresar al inicio</a></li>                </ul>
            </div>
        </nav>

        <div class="contenedor-principal">
            <div class="container">
                <div class="row">
                    <div class="responsive-table table-status-sheet"style="margin-top: 5em">
                        <table class="bordered white">
                            <thead>
                                <tr>

                                    <th class="center flow-text"><H5>Preguntas recibidas</H5></th>
                                </tr>
                            </thead>
                            <tbody id="milista">
                                <tr>

                                    <%                                        Ipreguntasdao controla_preguntas = new imppreguntas();
                                        ArrayList<preguntas> lista_preguntas = controla_preguntas.traepreguntass();
                                        for (int i = 0; i < lista_preguntas.size(); i++) {
                                    %>
                                    <td>
                                        <ul class="collection">

                                            <li class="collection-item avatar">
                                                <i class="material-icons circle grey darken-1 large" style="position: absolute; top: 60%">help</i>
                                                <span class="title">Id usuario: <%out.print(lista_preguntas.get(i).getId_usuario());%></span>
                                                <p>Id Pregunta: <%out.print(lista_preguntas.get(i).getId_pregunta());%></p>
                                                <p>Pregunta: <%out.print(lista_preguntas.get(i).getTexto());%> </p>
                                                <form action="registra_respuesta" method="post">
                                                    <div class="input-field col s12 m12 l12">
                                                        <input type="text" onkeypress="alfanumerico()" class="validate"  name="respuesta" id="respuesta" required placeholder="Respuesta">
                                                    </div>
                                                    <input type="text" name="id_pregun" readonly style="visibility: hidden; position: absolute; float: top; z-index: 0" value="<%out.print(lista_preguntas.get(i).getId_pregunta());%>">
                                                    <input class=" secondary-content btn modal-trigger grey darken-1" type="submit" value="Responder y subir">
                                                </form>
                                                <form action="elimina_pregunta" method="post">
                                                    <input type="text" name="id_pregun" readonly style="visibility: hidden; position: absolute; float: top; z-index: 0" value="<%out.print(lista_preguntas.get(i).getId_pregunta());%>">
                                                    <input class=" secondary-content btn modal-trigger grey darken-1" type="submit" style="margin-top: 7%;" value="Eliminar">
                                                </form>
                                            </li>
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
                out.println("<script>alert('Inicia sesion');</script>");
                out.print("<Script>presiona2();</Script>");
            }
        %>
    </body>
</html>