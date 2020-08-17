package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class form_005freporte_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"registra_reporte\" method=\"post\">\n");
      out.write("            <input type=\"date\" id=\"fecha_r\" name=\"fecha_r\" required readonly>\n");
      out.write("            <input type=\"text\" id=\"nombre\" name=\"nombre\" required placeholder=\"Nombre\" readonly>\n");
      out.write("            <input type=\"text\" id=\"edad\" name=\"edad\" required placeholder=\"Edad\" readonly>\n");
      out.write("            <input type=\"text\" id=\"talla\" name=\"talla\" required placeholder=\"Talla\">\n");
      out.write("            <input type=\"text\" id=\"peso\" name=\"peso\" required placeholder=\"Peso\">\n");
      out.write("            <input type=\"text\" id=\"temperatura\" name=\"temperatura\" required placeholder=\"Temperatura\">\n");
      out.write("            <input type=\"text\" id=\"frecuencia_c\" name=\"frecuencia_c\" required placeholder=\"Frecuencia Cardiaca\">\n");
      out.write("            <select id=\"color_p\" name=\"color_p\" required>\n");
      out.write("                <option value=\"0\" selected disabled>Seleccione alguna coloracion de la piel</option>\n");
      out.write("                <option value=\"1\">Normal</option>\n");
      out.write("                <option value=\"2\">Palido</option>\n");
      out.write("                <option value=\"3\">Colorado</option>\n");
      out.write("            </select>\n");
      out.write("            <select id=\"cansancio\" name=\"cansancio\" required>\n");
      out.write("                <option value=\"0\" selected disabled>Seleccione si hay cansancio</option>\n");
      out.write("                <option value=\"1\">Si</option>\n");
      out.write("                <option value=\"2\">No</option>\n");
      out.write("            </select>\n");
      out.write("            <select id=\"dolor_g\" name=\"dolor_g\" required>\n");
      out.write("                <option value=\"0\" selected disabled>Seleccione si hay dolor en la garganta</option>\n");
      out.write("                <option value=\"1\">Si</option>\n");
      out.write("                <option value=\"2\">No</option>\n");
      out.write("            </select>\n");
      out.write("            <select id=\"flema\" name=\"flema\" required>\n");
      out.write("                <option value=\"0\" selected disabled>Seleccione si hay flema</option>\n");
      out.write("                <option value=\"1\">No</option>\n");
      out.write("                <option value=\"2\">Si: Transparente</option>\n");
      out.write("                <option value=\"3\">Si: Verde</option>\n");
      out.write("                <option value=\"4\">Si: Blanca</option>\n");
      out.write("                <option value=\"5\">Si: Sangrienta</option>\n");
      out.write("            </select>\n");
      out.write("            <select id=\"escurrimiento_n\" name=\"escurrimiento_n\" required>\n");
      out.write("                <option value=\"0\" selected disabled>Seleccione si hay escurimiento nasal</option>\n");
      out.write("                <option value=\"1\">Si</option>\n");
      out.write("                <option value=\"2\">No</option>\n");
      out.write("            </select>\n");
      out.write("            <select id=\"dolor_a\" name=\"dolor_a\" required>\n");
      out.write("                <option value=\"0\" selected disabled>Seleccione si hay dolor abdominal</option>\n");
      out.write("                <option value=\"1\">No</option>\n");
      out.write("                <option value=\"2\">Leve</option>\n");
      out.write("                <option value=\"3\">Moderado</option>\n");
      out.write("                <option value=\"4\">Intenso</option>\n");
      out.write("            </select>\n");
      out.write("            <select id=\"nausea\" name=\"nausea\" required>\n");
      out.write("                <option value=\"0\" selected disabled>Seleccione si hay nausea</option>\n");
      out.write("                <option value=\"1\">Si</option>\n");
      out.write("                <option value=\"2\">No</option>\n");
      out.write("            </select>\n");
      out.write("            <select id=\"vomito\" name=\"votimo\" required>\n");
      out.write("                <option value=\"0\" selected disabled>Seleccione si hay vomito</option>\n");
      out.write("                <option value=\"1\">Si</option>\n");
      out.write("                <option value=\"2\">No</option>\n");
      out.write("            </select>\n");
      out.write("            <select id=\"dolor_c\" name=\"dolor_c\" required>\n");
      out.write("                <option value=\"0\" selected disabled>Seleccione si hay dolor de cabeza</option>\n");
      out.write("                <option value=\"1\">Si</option>\n");
      out.write("                <option value=\"2\">No</option>\n");
      out.write("            </select>\n");
      out.write("            <select id=\"diarrea\" name=\"diarrea\" required>\n");
      out.write("                <option value=\"0\" selected disabled>Seleccione si hay diarrea</option>\n");
      out.write("                <option value=\"1\">Si</option>\n");
      out.write("                <option value=\"2\">No</option>\n");
      out.write("            </select>\n");
      out.write("            <input type=\"submit\">\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
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
