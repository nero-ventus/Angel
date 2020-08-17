package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.owasp.esapi.ESAPI;
import com.angel.impdao.impusuario;
import com.angel.dao.Iusuariodao;
import com.angel.modelo.usuario;
import com.angel.modelo.cuenta_usuario;
import com.angel.seguridad.encriptador;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Angel-HOME</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("          <link rel=\"icon\" type=\"image/png\" href=\"imagenes/icono.png\" />\n");
      out.write("        \n");
      out.write("      <link rel=\"shortcut icon\" href=\"favicon.ico\"> \n");
      out.write("      <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("      <!--Import materialize.css-->\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/materialize.min.css\" media=\"screen,projection\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/css/materialize.min.css\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n");
      out.write("    <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-3.2.1.js\"></script>\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/js/materialize.min.js\"></script>\n");
      out.write("    \n");
      out.write("     <style>\n");
      out.write("        \n");
      out.write("    .pin-top {\n");
      out.write("    position: relative;\n");
      out.write("  }\n");
      out.write("\n");
      out.write("  .pin-bottom {\n");
      out.write("    position: relative;\n");
      out.write("  }\n");
      out.write("\n");
      out.write("  .pinned {\n");
      out.write("    position: fixed !important;\n");
      out.write("  }\n");
      out.write("        \n");
      out.write("   body{\n");
      out.write("            background: url(imagenes/fondoangelhome.jpg) no-repeat center center fixed;\n");
      out.write("            -webkit-background-size: cover;\n");
      out.write("            -moz-background-size: cover;\n");
      out.write("            -o-background-size: cover;      \n");
      out.write("            background-size: cover;\n");
      out.write("        }   \n");
      out.write("         tab a.active {\n");
      out.write("                 color:#4fc3f7!important;\n");
      out.write("                background-color:#4fc3f7!important;\n");
      out.write("          }\n");
      out.write("          .tabs .tab a:hover {\n");
      out.write("            background-color: #4fc3f7!important;\n");
      out.write("            color:#FFFFFF!important;\n");
      out.write("          }\n");
      out.write("          .tabs .tab a {\n");
      out.write("            color: #FFFFFF!important;\n");
      out.write("          }\n");
      out.write("          .tabs .indicator{\n");
      out.write("            background-color:black!important;\n");
      out.write("          }\n");
      out.write("          \n");
      out.write("           nav{\n");
      out.write("                position: fixed;\n");
      out.write("                top: 0;\n");
      out.write("                z-index: 1;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .contenedor-principal{\n");
      out.write("                margin-top: 4.5em;\n");
      out.write("                position: relative;\n");
      out.write("                z-index: 0;\n");
      out.write("            }\n");
      out.write("    </style>\n");
      out.write("    <script>\n");
      out.write("        function presiona2(){\n");
      out.write("            setTimeout(function (){\n");
      out.write("                window.location.replace('AngelLogIn.html');\n");
      out.write("            },0);\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            HttpSession datos_sesion=request.getSession();
            String correo,contra;
            encriptador descripta=new encriptador();
            correo=descripta.desencriptar((String)(datos_sesion.getAttribute("correo")));
            contra=descripta.desencriptar((String)(datos_sesion.getAttribute("contra")));
            int valida=0;
            Iusuariodao user=new impusuario();
            usuario usua=null;
            cuenta_usuario cuenta=null;
            try {
                cuenta=new cuenta_usuario(correo, contra, 0, 0);
                valida=1;
            }
            catch (Exception e) {
                out.println("<script>alert('Datos erroneos');</script>");
                out.print("<Script>presiona2();</Script>");
            }
            if(valida==1){
                usua=user.traeusuario(cuenta);
                if(!(usua==null)){
        
      out.write("\n");
      out.write("           <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-3.2.1.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/materialize.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/script.js\"></script>\n");
      out.write("        <script>\n");
      out.write("       $(document).ready(function(){\n");
      out.write("           $('.pushpin').pushpin();\n");
      out.write("           $('.sidenav').sidenav();\n");
      out.write("\n");
      out.write("        });\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("      <nav class=\"blue\" style=\"z-index: 99999\">\n");
      out.write("            <div class=\"nav-wrapper \">\n");
      out.write("                <a>");

                    out.print("Bienvenido: "+ESAPI.encoder().decodeForHTML(usua.getNombre()));
                
      out.write("\n");
      out.write("                </a>\n");
      out.write("                <a href=\"#\" class=\"brand-logo flow-text center\"><i class=\"material-icons t\">cloud</i>Angel</a>\n");
      out.write("                <a href=\"#\" data-target=\"mobile-demo\" class=\"sidenav-trigger\"><i class=\"material-icons right\">build</i></a>\n");
      out.write("       <ul class=\"right hide-on-med-and-down\">\n");
      out.write("        <li><a href=\"AngelEditarUsuario.html\"><i class=\"material-icons left\">edit</i>Editar Información</a></li>\n");
      out.write("        <li><a href=\"badges.html\"><i class=\"material-icons right\">help</i>Ayuda</a></li>\n");
      out.write("        <li><a href=\"badges.html\"><i class=\"material-icons right\">power_settings_new</i>Cerrar Sesión</a></li>\n");
      out.write("      </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav> \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <ul class=\"sidenav\" id=\"mobile-demo\"style=\"margin-top: 4.5em\" >\n");
      out.write("         <li><a href=\"AngelEditarUsuario.html\"><i class=\"material-icons right\">edit</i>Editar Información</a></li>\n");
      out.write("        <li><a href=\"badges.html\"><i class=\"material-icons right\">help</i>Ayuda</a></li>\n");
      out.write("        <li><a href=\"badges.html\"><i class=\"material-icons right\">power_settings_new</i>Cerrar Sesión</a></li>\n");
      out.write("        </ul>\n");
      out.write("        <div class=\"contenedor-principal\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col s12\" style=\"text-align: center\"><h5>Estimulación Temprana</h5></div>\n");
      out.write("           <div class=\"col s12 m3\">\n");
      out.write("           <div class=\"card small\">\n");
      out.write("                 <div class=\"card-image waves-effect waves-block waves-light\">\n");
      out.write("                      <img  alt=\"bb1\" class=\"activator\" src=\"imagenes/c1.jpg\">\n");
      out.write("                 </div>\n");
      out.write("                  <div class=\"card-content\">\n");
      out.write("                        <span class=\"card-title activator grey-text text-darken-4\">Estimulación Temprana 1<i class=\"material-icons right\">more_vert</i></span>\n");
      out.write("                        <p><a href=\"#\">Ver más...</a></p>\n");
      out.write("                 </div>\n");
      out.write("                <div class=\"card-reveal\">\n");
      out.write("                     <span class=\"card-title grey-text text-darken-4\">Estimulación Temprana 1<i class=\"material-icons right\">close</i></span>\n");
      out.write("                       <p>Here is some more information about this product that is only revealed once clicked on.</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("      </div>   \n");
      out.write("      <div class=\"col s12 m3\">\n");
      out.write("           <div class=\"card small\">\n");
      out.write("                 <div class=\"card-image waves-effect waves-block waves-light\">\n");
      out.write("                      <img  alt=\"bb1\" class=\"activator\" src=\"imagenes/c2.jpg\">\n");
      out.write("                 </div>\n");
      out.write("                  <div class=\"card-content\">\n");
      out.write("                        <span class=\"card-title activator grey-text text-darken-4\">Estimulación Temprana 2<i class=\"material-icons right\">more_vert</i></span>\n");
      out.write("                        <p><a href=\"#\">Ver más...</a></p>\n");
      out.write("                 </div>\n");
      out.write("                <div class=\"card-reveal\">\n");
      out.write("                     <span class=\"card-title grey-text text-darken-4\">Estimulación Temprana 2<i class=\"material-icons right\">close</i></span>\n");
      out.write("                       <p>Here is some more information about this product that is only revealed once clicked on.</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("      </div>\n");
      out.write("        <div class=\"col s12 m3\">\n");
      out.write("           <div class=\"card small\">\n");
      out.write("                 <div class=\"card-image waves-effect waves-block waves-light\">\n");
      out.write("                      <img  alt=\"bb1\" class=\"activator\" src=\"imagenes/c3.jpg\">\n");
      out.write("                 </div>\n");
      out.write("                  <div class=\"card-content\">\n");
      out.write("                        <span class=\"card-title activator grey-text text-darken-4\">Estimulación Temprana 3<i class=\"material-icons right\">more_vert</i></span>\n");
      out.write("                        <p><a href=\"#\">Ver más...</a></p>\n");
      out.write("                 </div>\n");
      out.write("                <div class=\"card-reveal\">\n");
      out.write("                     <span class=\"card-title grey-text text-darken-4\">Estimulación Temprana 3<i class=\"material-icons right\">close</i></span>\n");
      out.write("                       <p>Here is some more information about this product that is only revealed once clicked on.</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("      </div>\n");
      out.write("        <div class=\"col s12 m3\">\n");
      out.write("           <div class=\"card small\">\n");
      out.write("                 <div class=\"card-image waves-effect waves-block waves-light\">\n");
      out.write("                      <img  alt=\"bb1\" class=\"activator\" src=\"imagenes/c4.jpg\">\n");
      out.write("                 </div>\n");
      out.write("                  <div class=\"card-content\">\n");
      out.write("                        <span class=\"card-title activator grey-text text-darken-4\">Estimulación Temprana 4<i class=\"material-icons right\">more_vert</i></span>\n");
      out.write("                        <p><a href=\"#\">Ver más...</a></p>\n");
      out.write("                 </div>\n");
      out.write("                <div class=\"card-reveal\">\n");
      out.write("                     <span class=\"card-title grey-text text-darken-4\">Estimulación Temprana 4<i class=\"material-icons right\">close</i></span>\n");
      out.write("                       <p>Here is some more information about this product that is only revealed once clicked on.</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col s12\" style=\"text-align: center\"><h5>Seguimiento Médico</h5>\n");
      out.write("            \n");
      out.write("             <div class=\"card\">\n");
      out.write("                         <div class=\"card-content\">\n");
      out.write("                            <p>Aquí podrás ver análisis médicos que ayudarán a tu bebé a desarrollarse mejor. ¿Qué podemos hacer por ti?</p>\n");
      out.write("                         </div>\n");
      out.write("                <div class=\"card-tabs\">\n");
      out.write("                    <ul class=\"tabs tabs-fixed-width light-blue\">\n");
      out.write("                        <li class=\"tab\"><a class=\"active\" href=\"#test4\">Historial</a></li>\n");
      out.write("                       <li class=\"tab\"><a href=\"#test5\">Nueva Entrada</a></li>\n");
      out.write("                       <li class=\"tab\"><a href=\"#test6\">Imprimir</a></li>\n");
      out.write("                     </ul>\n");
      out.write("             </div>\n");
      out.write("             <div class=\"card-content grey lighten-4\">\n");
      out.write("                 <div id=\"test4\">\n");
      out.write("                     <i class=\"material-icons large center\">search</i><H6>Checa tu Historial aquí.</H6>\n");
      out.write("                     <a class=\"waves-effect waves-light light-blue btn-large\"><i class=\"material-icons right\">send</i>Click!</a>\n");
      out.write("\n");
      out.write("                 </div>\n");
      out.write("                 <div id=\"test5\">\n");
      out.write("                     <i class=\"material-icons large center\">edit</i><H6>Edita tu Historial aquí.</H6>\n");
      out.write("                     <a class=\"waves-effect waves-light light-blue btn-large\"><i class=\"material-icons right\">send</i>Click!</a>\n");
      out.write("\n");
      out.write("                 </div>\n");
      out.write("                 <div id=\"test6\">\n");
      out.write("                      <i class=\"material-icons large center\">print</i><H6>Imprime tu Historial aquí.</H6>\n");
      out.write("                      <a class=\"waves-effect waves-light light-blue btn-large\"><i class=\"material-icons right\">send</i>Click!</a>\n");
      out.write("\n");
      out.write("                 </div>\n");
      out.write("             </div>\n");
      out.write("            </div>\n");
      out.write("                \n");
      out.write("            </div>\n");
      out.write("        \n");
      out.write("        </div>\n");
      out.write("     \n");
      out.write("                \n");
      out.write("        \n");
      out.write("    \n");
      out.write("        </div>\n");
      out.write("        ");

            }
                else{
                    out.println("<script>alert('Inicia sesion primero');</script>");
                    out.print("<Script>presiona2();</Script>");
                }
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
