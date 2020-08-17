package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.angel.modelo.cuenta_usuario;
import com.angel.modelo.usuario;
import com.angel.impdao.impusuario;
import com.angel.dao.Iusuariodao;
import com.angel.seguridad.encriptador;

public final class simula_005fexterna_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
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
        
      out.write("\n");
      out.write("          <div id=\"map\"></div>\n");
      out.write("        <script>\n");
      out.write("            function inicia(){\n");
      out.write("                if(navigator.geolocation){\n");
      out.write("                    navigator.geolocation.getCurrentPosition(initMap);\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function initMap(position) {\n");
      out.write("                var lati=position.coords.latitude;\n");
      out.write("                var longi=position.coords.longitude;\n");
      out.write("                var posi = {lat: lati, lng: longi};\n");
      out.write("                var map = new google.maps.Map(document.getElementById('map'), {zoom: 18, center: posi});\n");
      out.write("                var marker = new google.maps.Marker({position: posi, map: map});\n");
      out.write("                var circ = new google.maps.Circle();\n");
      out.write("                circ.setRadius(10);\n");
      out.write("                circ.setCenter(posi);\n");
      out.write("                map.setCenter(posi);\n");
      out.write("                map.fitBounds(circ.getBounds());\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <script async defer\n");
      out.write("            src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyCFPKaKfsROx1V0gzxcSnSScF5CqkJc4qY&callback=initMap\">\n");
      out.write("        </script>      \n");
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
      out.write("    </body>\n");
      out.write("</html>\n");
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
