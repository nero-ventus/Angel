package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.angel.modelo.notificacion;
import com.angel.impdao.impnotificacion;
import com.angel.dao.Inotificaciondao;
import com.angel.modelo.config_linterna;
import com.angel.impdao.impconfig_linterna;
import com.angel.dao.Iconfig_linternadao;
import com.angel.modelo.sensores;
import java.util.ArrayList;
import com.angel.impdao.impsensores;
import com.angel.dao.Isensoresdao;
import com.angel.impdao.impusuario;
import com.angel.modelo.cuenta_usuario;
import com.angel.modelo.usuario;
import com.angel.dao.Iusuariodao;
import com.angel.seguridad.encriptador;

public final class simulacion_005fcasa_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <script>\n");
      out.write("            function presiona2(){\n");
      out.write("                setTimeout(function (){\n");
      out.write("                    window.location.replace('AngelLogIn.html');\n");
      out.write("                },0);\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        ");

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
                    
      out.write("\n");
      out.write("                    <script>\n");
      out.write("                        function sonido(){\n");
      out.write("                            var mp3Source = '<source src=\"sonidos/");
out.print(noti.getTono());
      out.write(".mp3\" type=\"audio/mpeg\">';\n");
      out.write("                            var oggSource = '<source src=\"sonidos/");
out.print(noti.getTono());
      out.write(".ogg\" type=\"audio/ogg\">';\n");
      out.write("                            var embedSource = '<embed hidden=\"true\" autostart=\"true\" loop=\"false\"  src=\"");
out.print(noti.getTono());
      out.write(".mp3\">';\n");
      out.write("                            document.getElementById(\"sound\").innerHTML='<audio id=\"sonidoo\" autoplay=\"autoplay\">' + mp3Source + oggSource + embedSource + '</audio>';\n");
      out.write("                            document.getElementById(\"sonidoo\").volume=");
out.print(new Float(noti.getVolumen())/10);
      out.write(";\n");
      out.write("                        } \n");
      out.write("                        function verificar(event){\n");
      out.write("                            var x=event.pageX;\n");
      out.write("                            var y=event.pageY;\n");
      out.write("                            var altoo=document.getElementById(\"mapa\").offsetHeight;\n");
      out.write("                            var anchoo=document.getElementById(\"mapa\").offsetWidth;\n");
      out.write("                            var ancho=anchoo/100;\n");
      out.write("                            var alto=altoo/100;\n");
      out.write("                            ");

                            for (int i=0;i<lista_sesores.size();i++){
                                if(lista_sesores.get(i).getEstado_permiso()==2){
                                    if(lista_sesores.get(i).getId_cuarto()==1){
                                        
      out.write("\n");
      out.write("                                            if((ancho*(725/128))<=x && x<=(ancho*(3125/128)) && (alto*(1060/141))<=y && y<=(alto*(5800/141))){\n");
      out.write("                                                sonido();\n");
      out.write("                                                setTimeout(function(){alert(\"Activiada en: Dormitorio\");},1000);\n");
      out.write("                                            }\n");
      out.write("                                        ");

                                    }
                                    if(lista_sesores.get(i).getId_cuarto()==2){
                                        
      out.write("\n");
      out.write("                                            if((ancho*(1625/64))<=x && x<=(ancho*(3025/64)) && (alto*(320/47))<=y && y<=(alto*(5800/141))){\n");
      out.write("                                                sonido();\n");
      out.write("                                                setTimeout(function(){alert(\"Activiada en: Estudio\");},1000);\n");
      out.write("                                            }\n");
      out.write("                                        ");

                                    }
                                    if(lista_sesores.get(i).getId_cuarto()==3){
                                        
      out.write("\n");
      out.write("                                            if((ancho*(12275/256))<=x && x<=(ancho*(16125/256)) && (alto*(620/47))<=y && y<=(alto*(5800/141))){\n");
      out.write("                                                sonido();\n");
      out.write("                                                setTimeout(function(){alert(\"Activiada en: Baño\");},1000);\n");
      out.write("                                            }\n");
      out.write("                                        ");

                                    }
                                    if(lista_sesores.get(i).getId_cuarto()==4){
                                        
      out.write("\n");
      out.write("                                            if((ancho*(4075/64))<=x && x<=(ancho*(21125/256)) && (alto*(620/47))<=y && y<=(alto*(5800/141))){\n");
      out.write("                                                sonido();\n");
      out.write("                                                setTimeout(function(){alert(\"Activiada en: Cocina\");},1000);\n");
      out.write("                                            }\n");
      out.write("                                        ");

                                    }
                                    if(lista_sesores.get(i).getId_cuarto()==5){
                                        
      out.write("\n");
      out.write("                                            if((ancho*(21075/256))<=x && x<=(ancho*(12625/128)) && (alto*(60/47))<=y && y<=(alto*(500/47))){\n");
      out.write("                                                sonido();\n");
      out.write("                                                setTimeout(function(){alert(\"Activiada en: Cuarto de Lavado\");},1000);\n");
      out.write("                                            }\n");
      out.write("                                        ");

                                    }
                                    if(lista_sesores.get(i).getId_cuarto()==6){
                                        
      out.write("\n");
      out.write("                                            if((ancho*(10625/128))<=x && x<=(ancho*(25175/256)) && (alto*(620/47))<=y && y<=(alto*(10280/141))){\n");
      out.write("                                                sonido();\n");
      out.write("                                                setTimeout(function(){alert(\"Activiada en: Comedor\");},1000);\n");
      out.write("                                            }\n");
      out.write("                                        ");

                                    }
                                    if(lista_sesores.get(i).getId_cuarto()==7){
                                        
      out.write("\n");
      out.write("                                            if((ancho*(425/256))<=x && x<=(ancho*(375/8)) && (alto*(6040/141))<=y && y<=(alto*(4580/47))){\n");
      out.write("                                                sonido();\n");
      out.write("                                                setTimeout(function(){alert(\"Activiada en: Sala\");},1000);\n");
      out.write("                                            }\n");
      out.write("                                        ");

                                    }
                                }
                            }
                            
      out.write("\n");
      out.write("                        }\n");
      out.write("                        function iniciopagina(){\n");
      out.write("                            var map = document.getElementById('mapa');\n");
      out.write("                            var context=map.getContext('2d');\n");
      out.write("                        ");

                            if(configura.getEstado_servicio()==1){
                        
      out.write("\n");
      out.write("                            map.addEventListener('mousedown',verificar,false);\n");
      out.write("                        ");

                            }
                            else{
                        
      out.write("\n");
      out.write("                            alert(\"Servicio Desactivado\");\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("                        }\n");
      out.write("                    </script>\n");
      out.write("                    ");

                        }
        
      out.write("\n");
      out.write("    <body onload=\"iniciopagina();\">\n");
      out.write("        <img src=\"imagenes/plano_simulacion.jpg\" id=\"imagen\" style=\"height: 100%; width: 100%; visibility: hidden; position: absolute; top: 0px; left: 0px; z-index: 1\">\n");
      out.write("        <div id=\"sound\" style=\"position: absolute; top: 0px; left: 0px; visibility: hidden;\"></div>\n");
      out.write("        <div id=\"contenedor1\" style=\"height: 100%; width: 100%; position: absolute; top: 0px; left: 0px;\">\n");
      out.write("            <canvas id=\"mapa\" style=\"height: 100%; width: 100%; z-index: 2; top: 0px; left: 0px; position: absolute;\"></canvas>\n");
      out.write("            <img src=\"imagenes/plano_simulacion.jpg\" id=\"imagen\" style=\"height: 100%; width: 100%; position: absolute; top: 0px; left: 0px; z-index: 1;\">\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("        ");

                }
                else{
                    
      out.write("\n");
      out.write("                    <script>alert(\"Inicia Sesion primero\");</script>\n");
      out.write("                    <script>presiona2();</script>\n");
      out.write("                    ");

                }
            }
            else{
        
      out.write("\n");
      out.write("        <script>alert(\"Datos erroneos\");</script>\n");
      out.write("        <script>presiona2();</script>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
