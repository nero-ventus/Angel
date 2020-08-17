<%-- 
    Document   : maneja_reporte_evento
    Created on : 27/03/2019, 02:49:38 PM
    Author     : devil
--%>

<%@page import="org.owasp.esapi.ESAPI"%>
<%@page import="com.angel.modelo.ingeniero"%>
<%@page import="com.angel.impdao.impingeniero"%>
<%@page import="com.angel.dao.Iingenierodao"%>
<%@page import="com.angel.modelo.etiquetas"%>
<%@page import="com.angel.impdao.impetiquetas"%>
<%@page import="com.angel.dao.Ietiquetasdao"%>
<%@page import="com.angel.modelo.reporte_evento"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.angel.impdao.impreporte_evento"%>
<%@page import="com.angel.dao.Ireporte_eventodao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            <div class="nav-wrapper grey darken-1">
                <a  class="brand-logo center flow-text"><i class="material-icons">cloud</i>"Angel"</a>
                <a data-target="mobile-demo" class="sidenav-trigger" href="administrador_home_operador.jsp"><i class="material-icons left white-text">arrow_back</i>Regresar</a>
                <ul id="nav-mobile" class="left hide-on-med-and-down">
                    <li><a href="administrador_home_todos.jsp"><i class="material-icons left">arrow_back</i>Regresar al inicio</a></li>                </ul>
            </div>
        </nav>

        <div class="contenedor-principal">
            <div class="container">
                <div class="row">
                    <div class="responsive-table table-status-sheet"style="margin-top: 5em">
                        <table class="bordered white">
                            <thead>
                                <tr>
                                    <th class="center flow-text"><H5>Manejo de Reportes de evento</H5></th>
                                </tr>
                            </thead>
                            <tbody id="milista">
                                <tr>
                                    <td>
                                        <ul class="collection">
                                            <%
                                                try{                                                
                                                    Ireporte_eventodao controla_reporte=new impreporte_evento();
                                                    ArrayList<reporte_evento> lista=controla_reporte.trae_reportes_evento_abiertos_sin_asignar();
                                                    for(int i=0;i<lista.size();i++){
                                            %>
                                            <li class="collection-item avatar">
                                                <i class="material-icons circle grey darken-1 large" style="position: absolute; top:25%">confirmation_number</i>
                                                <span class="title">Descripcion: <%out.print(lista.get(i).getDescripcion());%></span>
                                                <p>Solucion: <%out.print(lista.get(i).getSolucion());%></p>
                                                <p>Fecha: <%out.print(lista.get(i).getFecha());%></p>
                                                <p>Correo usuario: <%out.print(lista.get(i).getCorreo_usua());%></p>
                                                <%
                                                    if(lista.get(i).getCorreo_inge()==null){
                                                %>
                                                    <p>Correo ingeniero: Sin asignar</p>    
                                                    <form action="asigna_reporte_evento_inge" method="post">
                                                        <select class="validate flow-text" name="inge">
                                                            <option value="0" selected disabled>Seleccione algun ingeniero</option>
                                                            <%
                                                                Iingenierodao controla_ingeniero=new impingeniero();
                                                                ArrayList<ingeniero> lista_ingenieros=controla_ingeniero.trae_ingenieros();
                                                                for(int j=0;j<lista_ingenieros.size();j++){
                                                            %>
                                                                <option value="<%out.print(ESAPI.encoder().decodeForHTML(lista_ingenieros.get(j).getCorreo()));%>"><%out.print(lista_ingenieros.get(j).getApellidos()+" "+lista_ingenieros.get(j).getNombre());%></option>
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                        <input type="text" name="id_repor" class="hide" value="<%out.print(lista.get(i).getId_repor_evento());%>">
                                                        <input type="submit" class="grey rounded" value="Asignar ingeniero">
                                                    </form>
                                                <%
                                                    }
                                                    else{
                                                        Iingenierodao controla_ingeniero=new impingeniero();
                                                        ingeniero inge=controla_ingeniero.traeingeniero_sin_contra(lista.get(i).getCorreo_inge());
                                                %>
                                                    <p>Correo ingeniero: <%out.print(lista.get(i).getCorreo_inge());%></p>
                                                    <p>Nombre ingeniero: <%out.print(inge.getApellidos()+" "+inge.getNombre());%></p>
                                                <%
                                                    }
                                                    if(lista.get(i).getEstado()==1){
                                                %>
                                                    <p>Estado: Abierto</p>    
                                                <%
                                                    }
                                                    else{
                                                %>
                                                    <p>Estado: Cerrado</p>
                                                <%
                                                    }
                                                    Ietiquetasdao controla_etiquetas=new impetiquetas();
                                                    etiquetas eti=controla_etiquetas.traeetiqueta(lista.get(i).getId_repor_evento());
                                                    if(!(eti==null)){
                                                        int cantidad=controla_etiquetas.traecantidad(eti.getId_etiqueta());
                                                %>
                                                    <p>Etiqueta: <%out.print(eti.getNombre());%></p>
                                                    <p>Etiquetas similares: <%out.print(cantidad);%></p>
                                                <%
                                                    }
                                                    else{
                                                %>
                                                <p>Etiqueta: Sin asignar</p> 
                                                <form action="asigna_etiqueta" method="post">
                                                    <input type="text" name="nombre" placeholder="Crear nueva etiqueta">
                                                    <input type="text" name="id_repor" class="hide" value="<%out.print(lista.get(i).getId_repor_evento());%>">
                                                    <input type="submit" class="grey rounded" value="Crear nueva etiqueta">
                                                </form>
                                                <form action="relaciona_reporte" method="post">
                                                    <select class="validate flow-text" name="etiqueta">
                                                        <option value="0" selected disabled>Seleccione alguna etiqueta existente</option>
                                                        <%
                                                            ArrayList<etiquetas> lista_etiquetas=controla_etiquetas.traeetiquetas();
                                                            for(int j=0;j<lista_etiquetas.size();j++){
                                                        %>
                                                            <option value="<%out.print(lista_etiquetas.get(j).getId_etiqueta());%>"><%out.print(lista_etiquetas.get(j).getNombre());%></option>
                                                        <%
                                                            System.out.println(j+"________"+lista_etiquetas.get(j).getId_etiqueta());
                                                            }
                                                        %>
                                                    </select>
                                                    <input type="text" name="id_repor" class="hide" value="<%out.print(lista.get(i).getId_repor_evento());%>">
                                                    <input type="submit" class="grey rounded" value="Etiqueta ya existente">
                                                </form>
                                                <%
                                                    }
                                                %>
                                            </li>
                                            <%
                                                }
                                            }
                                            catch(Exception e){
                                                e.printStackTrace();
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
</html>
