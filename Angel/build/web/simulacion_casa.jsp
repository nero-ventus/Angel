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
        <title>JSP Page</title>
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
                                                setTimeout(function(){alert("Activiada en: Dormitorio");},1000);
                                            }
                                        <%
                                    }
                                    if(lista_sesores.get(i).getId_cuarto()==2){
                                        %>
                                            if((ancho*(1625/64))<=x && x<=(ancho*(3025/64)) && (alto*(320/47))<=y && y<=(alto*(5800/141))){
                                                sonido();
                                                setTimeout(function(){alert("Activiada en: Estudio");},1000);
                                            }
                                        <%
                                    }
                                    if(lista_sesores.get(i).getId_cuarto()==3){
                                        %>
                                            if((ancho*(12275/256))<=x && x<=(ancho*(16125/256)) && (alto*(620/47))<=y && y<=(alto*(5800/141))){
                                                sonido();
                                                setTimeout(function(){alert("Activiada en: Baño");},1000);
                                            }
                                        <%
                                    }
                                    if(lista_sesores.get(i).getId_cuarto()==4){
                                        %>
                                            if((ancho*(4075/64))<=x && x<=(ancho*(21125/256)) && (alto*(620/47))<=y && y<=(alto*(5800/141))){
                                                sonido();
                                                setTimeout(function(){alert("Activiada en: Cocina");},1000);
                                            }
                                        <%
                                    }
                                    if(lista_sesores.get(i).getId_cuarto()==5){
                                        %>
                                            if((ancho*(21075/256))<=x && x<=(ancho*(12625/128)) && (alto*(60/47))<=y && y<=(alto*(500/47))){
                                                sonido();
                                                setTimeout(function(){alert("Activiada en: Cuarto de Lavado");},1000);
                                            }
                                        <%
                                    }
                                    if(lista_sesores.get(i).getId_cuarto()==6){
                                        %>
                                            if((ancho*(10625/128))<=x && x<=(ancho*(25175/256)) && (alto*(620/47))<=y && y<=(alto*(10280/141))){
                                                sonido();
                                                setTimeout(function(){alert("Activiada en: Comedor");},1000);
                                            }
                                        <%
                                    }
                                    if(lista_sesores.get(i).getId_cuarto()==7){
                                        %>
                                            if((ancho*(425/256))<=x && x<=(ancho*(375/8)) && (alto*(6040/141))<=y && y<=(alto*(4580/47))){
                                                sonido();
                                                setTimeout(function(){alert("Activiada en: Sala");},1000);
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
        <img src="imagenes/plano_simulacion.jpg" id="imagen" style="height: 100%; width: 100%; visibility: hidden; position: absolute; top: 0px; left: 0px; z-index: 1">
        <div id="sound" style="position: absolute; top: 0px; left: 0px; visibility: hidden;"></div>
        <div id="contenedor1" style="height: 100%; width: 100%; position: absolute; top: 0px; left: 0px;">
            <canvas id="mapa" style="height: 100%; width: 100%; z-index: 2; top: 0px; left: 0px; position: absolute;"></canvas>
            <img src="imagenes/plano_simulacion.jpg" id="imagen" style="height: 100%; width: 100%; position: absolute; top: 0px; left: 0px; z-index: 1;">
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