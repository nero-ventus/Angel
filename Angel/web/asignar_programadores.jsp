<%-- 
    Document   : consulta_reportes_mantenimiento
    Created on : 2/04/2019, 08:43:37 AM
    Author     : Alumno
--%>

<%@page import="com.angel.seguridad.encriptador"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%@page import="com.angel.modelo.gerente_mantenimiento"%>
<%@page import="com.angel.impdao.impgerente_mantenimiento"%>
<%@page import="com.angel.dao.Igerente_mantenimientodao"%>
<%@page import="com.angel.modelo.reporte_mantenimiento"%>
<%@page import="com.angel.modelo.gerente_mantenimiento"%>
<%@page import="com.angel.impdao.impgerente_mantenimiento"%>
<%@page import="com.angel.dao.Igerente_mantenimientodao"%>
<%@page import="com.angel.modelo.programador"%>
<%@page import="com.angel.impdao.impprogramador"%>
<%@page import="com.angel.dao.Iprogramadordao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.angel.impdao.impreporte_mantenimiento"%>
<%@page import="com.angel.dao.Ireporte_mantenimientodao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Angel-Asigna Programador</title>
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
                color: #2196f3!important;
            }
            /* label focus color */
            .input-field input[type=text]:focus + label {
                color: black! important;
            }
            /* label underline focus color */
            .input-field input[type=text]:focus {
                border-bottom: 1px solid #66bb6a! important;
                box-shadow: 0 1px 0 0 #66bb6a! important;
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
                color: #f9a825 ; /* no need for !important :) */
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
        <%
            HttpSession datos_sesion = request.getSession();
            String correo, contra;
            encriptador descripta = new encriptador();
            correo = descripta.desencriptar((String) (datos_sesion.getAttribute("correo")));
            contra = descripta.desencriptar((String) (datos_sesion.getAttribute("contra")));
            Igerente_mantenimientodao controla_gerente = new impgerente_mantenimiento();
            gerente_mantenimiento geren = new gerente_mantenimiento(correo, contra, "", "");
            geren = controla_gerente.traegerente_mantenimiento(geren);
            if (!(geren == null)) {

        %>
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
        <nav>
            <div class="nav-wrapper yellow darken-2">
                <a  class="brand-logo center flow-text"><i class="material-icons">cloud</i>"Angel"</a>
                <a data-target="mobile-demo" class="sidenav-trigger" href="administrador_home_operador.jsp"><i class="material-icons left white-text">arrow_back</i>Regresar</a>
                <ul id="nav-mobile" class="left hide-on-med-and-down">
                    <li><a href="administrador_home_gerente_mantenimiento.jsp"><i class="material-icons left">arrow_back</i>Regresar al inicio</a></li>                </ul>
            </div>
        </nav>

        <div class="contenedor-principal">
            <div class="container">
                <div class="row">
                    <div class="responsive-table table-status-sheet"style="margin-top: 5em">
                        <table class="bordered white">
                            <thead>
                                <tr>
                            <script>
                                function cambia_pag() {
                                    document.getElementById("filtro").submit();
                                }
                            </script>
                            <th class="center flow-text"><H5>Gestión de Reportes de Mantenimiento</H5></th>

                            </tr>
                            </thead>
                            <tbody id="milista">
                                <tr>
                                    <td>
                                        <%                                                try {

                                                Igerente_mantenimientodao controla_programadores = new impgerente_mantenimiento();
                                                ArrayList<programador> lista_programadores = new ArrayList<programador>();
                                                lista_programadores = controla_programadores.trae_programadores();

                                                Ireporte_mantenimientodao controla_reporte = new impreporte_mantenimiento();
                                                ArrayList<reporte_mantenimiento> lista = new ArrayList<reporte_mantenimiento>();
                                                lista = controla_reporte.trae_reportes_mantenimiento_abiertos_sin_asignar();

                                        %>

                                        <%                                                for (int i = 0; i < lista.size(); i++) {
                                        %>
                                        <ul class="collection">

                                            <li class="collection-item avatar">
                                                <i class="material-icons circle yellow darken-2 large" style="position: absolute; top:30%">assignment</i>
                                                <div class=" col s6">
                                                    <span class="title">Descripcion: <%out.print(lista.get(i).getDescripcion());%></span>
                                                    <p>Estado: Abierto</p>    


                                                    <p>Fecha: <%out.print(lista.get(i).getFecha());%></p>
                                                    <p>Reporte de mantenimiento: <%out.print(lista.get(i).getTipo());%></p>
                                                    <p>Correo del responsable: <u> <%out.print(lista.get(i).getCorreo_gere());%> </u></p>
                                                            <%                                                    if (lista.get(i).getEstado() == 3) {
                                                            %>
                                                    <p>Solucion: No posee solución</p>
                                                    <form action="asigna_programador" method="post">
                                                        <input type="text" name="programador" class="hide" value="<%out.print(geren.getCorreo());%>">
                                                        <input type="text" name="id_repor" class="hide" value="<%out.print(lista.get(i).getId_repor_mantenimiento());%>">
                                                        <br>
                                                        <button  class="btn-large yellow darken-2 col m6 s12 l6 white-text waves-effect waves-light" type="submit" name="action" >¡Hazlo tu mismo!<i class="white-text material-icons right">assignment</i>
                                                        </button> 
                                                        <br><br><br><br><br><br><br>

                                                    </form>
                                                </div>
                                                <form action="asigna_programador" method="post">
                                                    <h5>Asigna un programador a este reporte</h5>
                                                    <div class="input-field col s6">
                                                        <select class="validate flow-text" style="z-index: 999999999" required name="programador" >
                                                            <option value="0" selected disabled>Seleccione un programador</option>

                                                            <%                                                        for (int j = 0; j < lista_programadores.size(); j++) {
                                                            %>
                                                            <option value="<%out.print(lista_programadores.get(j).getCorreo()); %>"><% out.print(lista_programadores.get(j).getNombre() + " " + lista_programadores.get(j).getApellidos()); %></option>
                                                            <%     }
                                                            %>        
                                                        </select>  </div>

                                                    <input type="text" name="id_repor" class="hide" value="<%out.print(lista.get(i).getId_repor_mantenimiento());%>">
                                                    <button  class="btn-large yellow darken-2 col m6 s12 l6 white-text waves-effect waves-light" type="submit" name="action">Asigna<i class="white-text material-icons right">account_box</i>
                                                    </button> 
                                                    <br><br><br><br><br><br><br>
                                                </form>

                                                <%
                                                } else {
                                                %>
                                                <p>Solucion: <%out.print(lista.get(i).getSolucion());%></p>
                                                <%
                                                    }
                                                %>

                                            </li>
                                        </ul>  

                                        <%                                                    }
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        %>

                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
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