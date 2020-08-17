<%@page import="com.angel.modelo.notificacion"%>
<%@page import="com.angel.impdao.impnotificacion"%>
<%@page import="com.angel.dao.Inotificaciondao"%>
<%@page import="com.angel.modelo.config_linterna"%>
<%@page import="com.angel.impdao.impconfig_linterna"%>
<%@page import="com.angel.dao.Iconfig_linternadao"%>
<%@page import="com.angel.modelo.sensores"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.angel.impdao.impsensores"%>
<%@page import="com.angel.dao.Isensoresdao"%>
<%@page import="com.angel.impdao.impusuario"%>
<%@page import="com.angel.modelo.cuenta_usuario"%>
<%@page import="com.angel.modelo.usuario"%>
<%@page import="com.angel.dao.Iusuariodao"%>
<%@page import="com.angel.seguridad.encriptador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Angel-Localizacion</title>
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
            
    </head>
    <script>
            function presiona2(){
                setTimeout(function (){
                    window.location.replace('AngelLogIn.html');
                },0);
            }
        </script>
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
                    Isensoresdao controla_sensores=new impsensores();
                    ArrayList<sensores> lista_sesores=controla_sensores.traeSensores(correo);
                    Iconfig_linternadao controla_config=new impconfig_linterna();
                    config_linterna configura=controla_config.traeconfig_linterna(correo);
                    Inotificaciondao controla_noti=new impnotificacion();
                    notificacion noti=controla_noti.traenotificacion(correo);
                        if(!(lista_sesores==null)){
                    %>
                    <script>
                        function sonido(){
                            var mp3Source = '<source src="sonidos/<%out.print(noti.getTono());%>.mp3" type="audio/mpeg">';
                            var oggSource = '<source src="sonidos/<%out.print(noti.getTono());%>.ogg" type="audio/ogg">';
                            var embedSource = '<embed hidden="true" autostart="true" loop="false"  src="<%out.print(noti.getTono());%>.mp3">';
                            document.getElementById("sound").innerHTML='<audio id="sonidoo" autoplay="autoplay">' + mp3Source + oggSource + embedSource + '</audio>';
                            document.getElementById("sonidoo").volume=<%out.print(new Float(noti.getVolumen())/10);%>;
                        } 
                        function verificar(event){
                            var x=event.pageX;
                            var y=event.pageY;
                            var altoo=document.getElementById("mapa").offsetHeight;
                            var anchoo=document.getElementById("mapa").offsetWidth;
                            var ancho=anchoo/100;
                            var alto=altoo/100;
                            <%
                            for (int i=0;i<lista_sesores.size();i++){
                                if(lista_sesores.get(i).getEstado_permiso()==2){
                                    if(lista_sesores.get(i).getId_cuarto()==1){
                                        %>
                                            if((ancho*(725/128))<=x && x<=(ancho*(3125/128)) && (alto*(1060/141))<=y && y<=(alto*(5800/141))){
                                                sonido();
                                                setTimeout(function(){alert("Activada en: Dormitorio");},1000);
                                            }
                                        <%
                                    }
                                    if(lista_sesores.get(i).getId_cuarto()==2){
                                        %>
                                            if((ancho*(1625/64))<=x && x<=(ancho*(3025/64)) && (alto*(320/47))<=y && y<=(alto*(5800/141))){
                                                sonido();
                                                setTimeout(function(){alert("Activada en: Estudio");},1000);
                                            }
                                        <%
                                    }
                                    if(lista_sesores.get(i).getId_cuarto()==3){
                                        %>
                                            if((ancho*(12275/256))<=x && x<=(ancho*(16125/256)) && (alto*(620/47))<=y && y<=(alto*(5800/141))){
                                                sonido();
                                                setTimeout(function(){alert("Activada en: Baño");},1000);
                                            }
                                        <%
                                    }
                                    if(lista_sesores.get(i).getId_cuarto()==4){
                                        %>
                                            if((ancho*(4075/64))<=x && x<=(ancho*(21125/256)) && (alto*(620/47))<=y && y<=(alto*(5800/141))){
                                                sonido();
                                                setTimeout(function(){alert("Activada en: Cocina");},1000);
                                            }
                                        <%
                                    }
                                    if(lista_sesores.get(i).getId_cuarto()==5){
                                        %>
                                            if((ancho*(21075/256))<=x && x<=(ancho*(12625/128)) && (alto*(60/47))<=y && y<=(alto*(500/47))){
                                                sonido();
                                                setTimeout(function(){alert("Activada en: Cuarto de Lavado");},1000);
                                            }
                                        <%
                                    }
                                    if(lista_sesores.get(i).getId_cuarto()==6){
                                        %>
                                            if((ancho*(10625/128))<=x && x<=(ancho*(25175/256)) && (alto*(620/47))<=y && y<=(alto*(10280/141))){
                                                sonido();
                                                setTimeout(function(){alert("Activada en: Comedor");},1000);
                                            }
                                        <%
                                    }
                                    if(lista_sesores.get(i).getId_cuarto()==7){
                                        %>
                                            if((ancho*(425/256))<=x && x<=(ancho*(375/8)) && (alto*(6040/141))<=y && y<=(alto*(4580/47))){
                                                sonido();
                                                setTimeout(function(){alert("Activada en: Sala");},1000);
                                            }
                                        <%
                                    }
                                }
                            }
                            %>
                        }
                        function iniciopagina(){
                            var map = document.getElementById('mapa');
                            var context=map.getContext('2d');
                        <%
                            if(configura.getEstado_servicio()==1){
                        %>
                            map.addEventListener('mousedown',verificar,false);
                        <%
                            }
                            else{
                        %>
                            alert("Servicio Desactivado");
                        <%
                            }
                        %>
                        }
                    </script>
                    <%
                        }
        %>
    <body onload="iniciopagina();">
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
                    <form action="actualiza_configuracion_li" method="post">
                        <div style="text-align: center">
                            <label>
                                <input type="checkbox" class="blue filled-in" value="1" name="estado_servicio" id="estado_servicio">
                                <span>Estado del servicio</span>
                            </label>
                            <script>
                                function cambiaestado(){
                                    <%
                                        if(configura.getEstado_servicio()==1){
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
                        <div class="col s6 offset-s3">
                            <a href="AngelConfigSensores.jsp">
                                ¡Configura tus sensores!
                            </a>
                        </div>
                        <br><br><br> <br><br><br>

                        <button class="btn blue" type="submit" id="ajustar" name="action">Ajustar<i class="material-icons right">check</i>
                        </button>
                    </form>

                </div>

            </div>
        
        <img src="imagenes/plano_simulacion.jpg" id="imagen" style="height: 100%; width: 100%; visibility: hidden; position: absolute; top: 0px; left: 0px; z-index: 1">
        <div id="sound" style="position: absolute; top: 0px; left: 0px; visibility: hidden;"></div>
        <div id="contenedor1" style="height: 100%; width: 100%; position: absolute; top: 0px; left: 0px;">
            <canvas id="mapa" style="height: 100%; width: 100%; z-index: 2; top: 0px; left: 0px; position: absolute;"></canvas>
            <img src="imagenes/plano_simulacion.jpg" id="imagen" style="height: 100%; width: 100%; position: absolute; top: 0px; left: 0px; z-index: 1;">
        </div>
        </div>
    </body>
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
</html>