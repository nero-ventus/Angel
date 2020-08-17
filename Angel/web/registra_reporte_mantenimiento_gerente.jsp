<%-- 
    Document   : registra_reporte_mantenimiento
    Created on : 28/03/2019, 11:05:06 PM
    Author     : Jesus Abraham
--%>
<%@page import="com.angel.modelo.gerente_mantenimiento"%>
<%@page import="com.angel.impdao.impgerente_mantenimiento"%>
<%@page import="com.angel.dao.Igerente_mantenimientodao"%>
<%@page import="com.angel.seguridad.encriptador"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registra reporte de mantenimiento</title>
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
                background: url(imagenes/mantenhome1.jpg) no-repeat center center fixed;
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
                color: #f9a825!important;
            }
            /* label focus color */
            .input-field input[type=text]:focus + label {
                color: black! important;
            }
            /* label underline focus color */
            .input-field input[type=text]:focus {
                border-bottom: 1px solid #f9a825! important;
                box-shadow: 0 1px 0 0 #f9a825! important;
            }

            .input-field input[type=text].valid {
                border-bottom: 1px solid #f9a825!important;
                box-shadow: 0 1px 0 0 #f9a825!important;
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
                color: #f9a825; /* no need for !important :) */
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
                window.location.replace('AngelLogInGerenteMantenimiento.html');
            }, 0);
        }

    </script>

    <body>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
        <script>
        $(document).ready(function () {
            $('.sidenav').sidenav();
            $('select').formSelect();
            $('.fixed-action-btn').floatingActionButton();
        });
        </script>
        <%
            HttpSession datos_sesion = request.getSession();
            String correo, contra;
            encriptador descripta = new encriptador();
            correo = descripta.desencriptar((String) (datos_sesion.getAttribute("correo")));
            contra = descripta.desencriptar((String) (datos_sesion.getAttribute("contra")));
            Igerente_mantenimientodao controla_gerente_mantenimiento = new impgerente_mantenimiento();
            gerente_mantenimiento geren = new gerente_mantenimiento(correo, contra, "", "");
            geren = controla_gerente_mantenimiento.traegerente_mantenimiento(geren);
            if (!(geren == null)) {

        %>
        <nav>
            <div class="nav-wrapper yellow darken-3">
                <a  class="brand-logo center flow-text"><i class="material-icons">cloud</i>"Angel"</a>
                <a data-target="mobile-demo" class="sidenav-trigger" href="javascript:history.back()"><i class="material-icons left white-text">arrow_back</i>Regresar</a>
                <ul id="nav-mobile" class="left hide-on-med-and-down">
                    <li><a href="javascript:history.back()"><i class="material-icons left">arrow_back</i>Regresar al inicio</a></li>                </ul>
            </div>
        </nav>

        <div class="contenedor-principal">
            <div class="row">

                <%                    Date hoy = new Date();
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
                <div class="row container white" style="margin-top: 7em; ">
                    <h3 style="text-align: center">Registra un reporte de mantenimiento</h3>
                    <h5 style="margin-left: 30px">Datos del reporte:</h5>
                    <p style="margin-left: 30px">Fecha: <u> <%out.print(fecha_hoy); %> </u> </p>
                    <p style="margin-left: 30px">Tu correo: <u> <%out.print(geren.getCorreo()); %> </u> </p>
                    <form action="registra_reporte_mantenimiento" method="post">
                        <div class="input-field col s12">
                            <input type="text" onkeypress="alfanumerico()" class="validate"  name="descripcion" id="descripcion" required placeholder="Descripcion del problema">
                        </div>
                        <div class="input-field col s6">
                            <select class="validate flow-text" required name="tipo" >
                                <option value="0" selected disabled>Seleccione tipo de mantenimiento</option>
                                <option value="Preventivo">Preventivo</option>
                                <option value="Correctivo">Correctivo</option>
                            </select>    
                        </div>
                        <input type="text" class="hide"  name="correo_geren" id="correo_geren" value="<%out.print(geren.getCorreo()); %>">
                        <input type="text" class="hide"  name="fecha_r" id="fecha_r" required value="<%out.print(fecha_hoy);%>">
                        <button class="btn btn-large col s6 yellow darken-3" type="submit" name="action">Genera el reporte
                            <i class="material-icons right">send</i>
                        </button>                  
                    </form>
                </div>
            </div>

        </div>
        <%            } else {
                out.println("<script>alert('Inicia sesion');</script>");
                out.print("<Script>presiona2();</Script>");
            }
        %>
    </body>
</html>
