package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class form_005fbebe_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <form action=\"registra_infante\">\n");
      out.write("            <input type=\"text\" id=\"nombre\" name=\"nombre\" placeholder=\"Nombre\" required>\n");
      out.write("            <input type=\"text\" id=\"apellido_p\" name=\"apellido_p\" placeholder=\"Apellido Paterno\" required>\n");
      out.write("            <input type=\"text\" id=\"apellido_m\" name=\"apellido_m\" placeholder=\"Apellido Materno\" required>\n");
      out.write("            <input type=\"text\" id=\"peso\" name=\"peso\" placeholder=\"Peso\" required>\n");
      out.write("            <input type=\"text\" id=\"altura\" name=\"altura\" placeholder=\"Altura\" required>\n");
      out.write("            <select id=\"sexo\" name=\"sexo\">\n");
      out.write("                <option value=\"0\" selected disabled>Selecione algun sexo</option>\n");
      out.write("                <option value=\"1\">Masculino</option>\n");
      out.write("                <option value=\"2\">Femenino</option>\n");
      out.write("            </select>\n");
      out.write("            <select id=\"dispositivo\" name=\"dispositivo\">\n");
      out.write("                <option value=\"0\" selected disabled>Selecione algun dispositivo</option>\n");
      out.write("                <option value=\"1\">1</option>\n");
      out.write("            </select>\n");
      out.write("            <input type=\"date\" id=\"fecha_n\" name=\"fecha_n\" required>\n");
      out.write("            <input type=\"checkbox\" id=\"a1\" name=\"a1\" value=\"1\" required>Asma\n");
      out.write("            <input type=\"checkbox\" id=\"a2\" name=\"a2\" value=\"2\" required>Fibrosis quística\n");
      out.write("            <input type=\"checkbox\" id=\"a3\" name=\"a3\" value=\"3\" required>Diabetes\n");
      out.write("            <input type=\"checkbox\" id=\"a4\" name=\"a4\" value=\"4\" required>Hipoglucemia\n");
      out.write("            <input type=\"checkbox\" id=\"a5\" name=\"a5\" value=\"5\" required>Parálisis cerebral\n");
      out.write("            <input type=\"checkbox\" id=\"a6\" name=\"a6\" value=\"6\" required>Autismo\n");
      out.write("            <input type=\"checkbox\" id=\"a7\" name=\"a7\" value=\"7\" required>Deficit de atencion\n");
      out.write("            <input type=\"checkbox\" id=\"a8\" name=\"a8\" value=\"8\" required>Hiperactiviadad\n");
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
