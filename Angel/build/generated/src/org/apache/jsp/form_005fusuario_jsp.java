package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class form_005fusuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script>\n");
      out.write("            function presiona1(){\n");
      out.write("                setTimeout(function (){\n");
      out.write("                    window.location.replace('index.html');\n");
      out.write("                },5000);\n");
      out.write("            }\n");
      out.write("            function presiona2(){\n");
      out.write("                setTimeout(function (){\n");
      out.write("                    window.location.replace('form_usuario.jsp');\n");
      out.write("                },5000);\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"registra_usuario\" method=\"post\">\n");
      out.write("            <input type=\"text\" name=\"nombre\" id=\"nombre\" required placeholder=\"Nombre(s)\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"text\" name=\"apellido_p\" id=\"apellido_p\" required placeholder=\"Apellido Paterno\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"text\" name=\"apellido_m\" id=\"apellido_m\" required placeholder=\"Apellido Materno\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"text\" name=\"correo\" id=\"correo\" required placeholder=\"Correo electronico\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"password\" name=\"contra\" id=\"contra\" required placeholder=\"Contraseña\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"password\" name=\"ccontra\" id=\"ccontra\" required placeholder=\"Confirmar contraseña\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"text\" name=\"codigo\" id=\"codigo\" required placeholder=\"Codigo de producto\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"text\" name=\"nex\" id=\"nex\" required placeholder=\"N°Exterior\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"text\" name=\"calle\" id=\"calle\" required placeholder=\"Calle\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"text\" name=\"municipio\" id=\"municipio\" required placeholder=\"Municipio\">\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <select name=\"estado\" id=\"estado\">\n");
      out.write("                <option value=\"0\" selected disabled>Seleccione un estado</option>\n");
      out.write("                <option value=\"1\">Ciudad de Mexico</option>\n");
      out.write("                <option value=\"2\">Aguascalientes</option>\n");
      out.write("                <option value=\"3\">Baja California</option>\n");
      out.write("                <option value=\"4\">Baja California Sur</option>\n");
      out.write("                <option value=\"5\">Campeche</option>\n");
      out.write("                <option value=\"6\">Chiapas</option>\n");
      out.write("                <option value=\"7\">Chihuahua</option>\n");
      out.write("                <option value=\"8\">Coahuila</option>\n");
      out.write("                <option value=\"9\">Colima</option>\n");
      out.write("                <option value=\"10\">Durango</option>\n");
      out.write("                <option value=\"11\">Estado de México</option>\n");
      out.write("                <option value=\"12\">Guanajuato</option>\n");
      out.write("                <option value=\"13\">Guerrero</option>\n");
      out.write("                <option value=\"14\">Hidalgo</option>\n");
      out.write("                <option value=\"15\">Jalisco</option>\n");
      out.write("                <option value=\"16\">Michoacán</option>\n");
      out.write("                <option value=\"17\">Morelos</option>\n");
      out.write("                <option value=\"18\">Nayarit</option>\n");
      out.write("                <option value=\"19\">Nuevo León</option>\n");
      out.write("                <option value=\"20\">Oaxaca</option>\n");
      out.write("                <option value=\"21\">Puebla</option>\n");
      out.write("                <option value=\"22\">Querétaro</option>\n");
      out.write("                <option value=\"23\">Quintana Roo</option>\n");
      out.write("                <option value=\"24\">San Luis Potosí</option>\n");
      out.write("                <option value=\"25\">Sinaloa</option>\n");
      out.write("                <option value=\"26\">Sonora</option>\n");
      out.write("                <option value=\"27\">Tabasco</option>\n");
      out.write("                <option value=\"28\">Tamaulipas</option>\n");
      out.write("                <option value=\"29\">Tlaxcala</option>\n");
      out.write("                <option value=\"30\">Veracruz</option>\n");
      out.write("                <option value=\"31\">Yucatán</option>\n");
      out.write("                <option value=\"32\">Zacatecas</option>\n");
      out.write("            </select>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"submit\">\n");
      out.write("        </form>\n");
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
