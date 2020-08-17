<%-- 
    Document   : simula_externa
    Created on : 19/11/2018, 07:18:45 PM
    Author     : devil
--%>

<%@page import="com.angel.modelo.notificacion"%>
<%@page import="com.angel.impdao.impnotificacion"%>
<%@page import="com.angel.dao.Inotificaciondao"%>
<%@page import="com.angel.modelo.config_lexterna"%>
<%@page import="com.angel.impdao.impconfig_lexterna"%>
<%@page import="com.angel.dao.Iconfig_lexternadao"%>
<%@page import="com.angel.modelo.cuenta_usuario"%>
<%@page import="com.angel.modelo.usuario"%>
<%@page import="com.angel.impdao.impusuario"%>
<%@page import="com.angel.dao.Iusuariodao"%>
<%@page import="com.angel.seguridad.encriptador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Localizacion Externa</title>
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
             [type="checkbox"].filled-in:checked + span:not(.lever):after {
                top: 0;
                width: 20px;
                height: 20px;
                border: 2px solid #1565c0 ;
                background-color: #90caf9 ;
                z-index: 0;
            }
            ul.dropdown-content.select-dropdown li span {
                color: #03a9f4; /* no need for !important :) */
            }   
            .input-field input[type=number]:focus + label {
                color: black! important;
            }
            /* label underline focus color */
            .input-field input[type=number]:focus {
                border-bottom: 1px solid #0d47a1! important;
                box-shadow: 0 1px 0 0 #0d47a1 ! important;
            }

            .input-field input[type=number].valid {
                border-bottom: 1px solid #76ff03!important;
                box-shadow: 0 1px 0 0 #76ff03!important;
            }

            .input-field input[type=number].invalid {
                border-bottom: 1px solid red !important;
                box-shadow: 0 1px 0 0 red!important;
            }
            /* icon prefix focus color */
            .input-field .prefix.active {
                color: #000;
            }   
        </style>
        <style>
            /* Set the size of the div element that contains the map */
            #map {
              height: 650px;  /* The height is 400 pixels */
              width: 100%;  /* The width is the width of the web page */
              top: 0px;
            }
        </style>
    </head>
    
    <body onload="inicia()">
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
                    Iconfig_lexternadao controla_configle=new impconfig_lexterna();
                    config_lexterna confi=controla_configle.traeconfig_lexterna(correo);
                    Inotificaciondao controla_noti=new impnotificacion();
                    notificacion noti=controla_noti.traenotificacion(correo);
        %>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
       <script>
            $(document).ready(function () {
                $('.tap-target').tapTarget();
                $('.fixed-action-btn').floatingActionButton();
                $('select').formSelect();
                $('.modal').modal();
            });
        </script>

        <div class="row">

            <div class="fixed-action-btn">
                <a class="btn-floating btn-large blue darken-4">
                    <i class="large material-icons">add</i>
                </a>
                <ul>
                    <li><a class="btn-floating blue darken-2" href="AngelGestionInfantil.jsp"><i class="material-icons">child_friendly</i></a></li>
                    <li><a class="btn-floating blue darken-2" href="AngelUsuario.jsp"><i class="material-icons">account_circle</i></a></li>
                    <li><a class="btn-floating blue darken-2 modal-trigger" href="#modal1"><i class="material-icons">build</i></a></li>
                    <li><a class="btn-floating  blue darken-2" href="Home.jsp"><i class="material-icons">home</i></a></li>
                </ul>
            </div>

            <div id="modal1" class="modal modal-fixed-footer" style="z-index: 3;"> 
                <div class="modal-content" style="text-align: center">
                    <div class="col s12">
                        <h4>Configuracion</h4>
                        <i class="material-icons">build</i><br><br>
                    </div>
                    <form action="actualiza_configuracion_le" method="post">
                        <div style="text-align: center">
                            <label>
                                <input type="checkbox" class="blue filled-in" value="1" name="estado_servicio" id="estado_servicio">
                                <span>Estado del servicio</span>
                            </label>
                            <script>
                                function cambiaestado(){
                                    <%
                                        if(confi.getEstado_servicio()==1){
                                    %>
                                            document.getElementById("estado_servicio").checked=true;
                                    <%
                                    }
                                    else{
                                    %>
                                            document.getElementById("estado_servicio").checked=false;
                                    <%
                                    }
                                    %>
                                }
                                cambiaestado();
                            </script>
                        </div>
                        <div class="col s12">
                            <div class="input-field col s2 offset-s5">
                                <input type="number" name="volumen" id="volumen" value="<%out.print(noti.getVolumen());%>"  required>
                                <label for="volumen">Vol.</label>
                            </div>
                        </div>
                        <br><br><br>

                        <div>
                            <div class="input-field col s4 offset-s4" style="text-align: center">
                                <select name="tono" id="tono" required>
                                    <option value="0" selected disabled>Selecciona un tono</option>
                                    <option value="predeterminado1">Predeterminado 1</option>
                                    <option value="predeterminado2">Predeterminado 2</option>
                                    <option value="predeterminado3">Predeterminado 3</option>
                                </select>
                            </div>
                            <script>
                                function cambiatono(){
                                    <%
                                        if(noti.getTono().equals("predeterminado1")){
                                    %>
                                           document.getElementById("tono").selectedIndex="1";
                                    <%
                                    }
                                    %>
                                    <%
                                        if(noti.getTono().equals("predeterminado2")){
                                    %>
                                           document.getElementById("tono").selectedIndex="2";
                                    <%
                                    }
                                    %>
                                    <%
                                        if(noti.getTono().equals("predeterminado3")){
                                    %>
                                           document.getElementById("tono").selectedIndex="3";
                                    <%
                                    }
                                    %>
                                }
                                cambiatono();
                            </script>
                        </div>
                        
                        <br><br><br>
                        <div class="input-field col s2 offset-s5">
                            <input type="number" name="distap" id="distap" value="<%out.print(confi.getDistancia_permitida());%>"  required>
                            <label for="distap">Dista.Permitida</label>
                        </div>
                        <br><br><br> <br><br><br>

                        <button class="btn blue" type="submit" id="ajustar" name="action">Ajustar<i class="material-icons right">check</i>
                        </button>
                    </form>

                </div>

            </div>
        
          <div id="map"></div>
        <script>
            function sonido(){
                var mp3Source = '<source src="sonidos/<%out.print(noti.getTono());%>.mp3" type="audio/mpeg">';
                var oggSource = '<source src="sonidos/<%out.print(noti.getTono());%>.ogg" type="audio/ogg">';
                var embedSource = '<embed hidden="true" autostart="true" loop="false"  src="<%out.print(noti.getTono());%>.mp3">';
                document.getElementById("sound").innerHTML='<audio id="sonidoo" autoplay="autoplay">' + mp3Source + oggSource + embedSource + '</audio>';
                document.getElementById("sonidoo").volume=<%out.print(new Float(noti.getVolumen())/10);%>;
            }
            function inicia(){
                if(navigator.geolocation){
                    navigator.geolocation.getCurrentPosition(initMap);
                }
            }
            function initMap(position) {
                var lati=position.coords.latitude;
                var longi=position.coords.longitude;
                var posi = {lat: lati, lng: longi};
                var map = new google.maps.Map(document.getElementById('map'), {zoom: 22, center: posi});
                var marker = new google.maps.Marker({position: posi, map: map});
                
                <%
                    if(confi.getEstado_servicio()==1){
                %>  
                    var circ = new google.maps.Circle({map: map,center: posi,radius: <%out.print(confi.getDistancia_permitida());%>});
                    google.maps.event.addListener(map, 'click',function(){
                        sonido();
                        setTimeout(function(){alert("Fuera de los limites (Limite: "+<%out.print(confi.getDistancia_permitida());%>+" metros)");},1000);
                    });
                    google.maps.event.clearListeners(circ, 'click');
                <%
                    }
                    else{
                %>
                        alert("Servicio desactivado");
                <%
                    }
                %>
            }
        </script>
        <script async defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCFPKaKfsROx1V0gzxcSnSScF5CqkJc4qY&callback=initMap">
        </script>
        <div id="sound" style="position: absolute; top: 0px; left: 0px; visibility: hidden;"></div>
        <%
                }
                else{
                    %>
                    <script>alert("Inicia Sesion primero");</script>
                    <script>presiona2();</script>
                    <%
                }
            }
            else{
        %>
        <script>alert("Datos erroneos");</script>
        <script>presiona2();</script>
        <%
            }
        %>
    </body>
</html>
