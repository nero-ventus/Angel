package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.angel.modelo.tickets;
import java.util.ArrayList;
import com.angel.impdao.imptickets;
import com.angel.dao.Iticketsdao;
import com.angel.modelo.administrador;
import com.angel.impdao.impadministrador;
import com.angel.seguridad.encriptador;
import com.angel.dao.Iadministradordao;

public final class administrador_005fresponder_005ftickets_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Angel-Tickets A Responder</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" href=\"imagenes/icono.png\" />\n");
      out.write("\n");
      out.write("        <link rel=\"shortcut icon\" href=\"favicon.ico\"> \n");
      out.write("        <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n");
      out.write("        <!--Import materialize.css-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/materialize.min.css\" media=\"screen,projection\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/css/materialize.min.css\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n");
      out.write("        <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-3.2.1.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/js/materialize.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/validaciones.js\"></script>\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background: url(imagenes/wallcode.jpg) no-repeat center center fixed;\n");
      out.write("                -webkit-background-size: cover;\n");
      out.write("                -moz-background-size: cover;\n");
      out.write("                -o-background-size: cover;      \n");
      out.write("                background-size: cover;\n");
      out.write("            }  \n");
      out.write("            .dropdown-content li>a {\n");
      out.write("                color: white !important;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            tbody {\n");
      out.write("                display:block;\n");
      out.write("                height:500px;\n");
      out.write("                overflow:auto;\n");
      out.write("            }\n");
      out.write("            thead, tbody tr {\n");
      out.write("                display:table;\n");
      out.write("                width:100%;\n");
      out.write("                table-layout:fixed;\n");
      out.write("            }\n");
      out.write("            thead {\n");
      out.write("                width: calc( 100% - 1em )\n");
      out.write("            }\n");
      out.write("            table {\n");
      out.write("                width:100%;\n");
      out.write("            }\n");
      out.write("            nav{\n");
      out.write("                position: fixed;\n");
      out.write("                top: 0;\n");
      out.write("                z-index: 1;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .contenedor-principal{\n");
      out.write("                margin-top: 4.5em;\n");
      out.write("                position: relative;\n");
      out.write("                z-index: 0;\n");
      out.write("            }\n");
      out.write("            .input-field label {\n");
      out.write("                color: #2196f3!important;\n");
      out.write("            }\n");
      out.write("            /* label focus color */\n");
      out.write("            .input-field input[type=text]:focus + label {\n");
      out.write("                color: black! important;\n");
      out.write("            }\n");
      out.write("            /* label underline focus color */\n");
      out.write("            .input-field input[type=text]:focus {\n");
      out.write("                border-bottom: 1px solid #795548! important;\n");
      out.write("                box-shadow: 0 1px 0 0 #795548! important;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .input-field input[type=text].valid {\n");
      out.write("                border-bottom: 1px solid #76ff03!important;\n");
      out.write("                box-shadow: 0 1px 0 0 #76ff03!important;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .input-field input[type=text].invalid {\n");
      out.write("                border-bottom: 1px solid red !important;\n");
      out.write("                box-shadow: 0 1px 0 0 red!important;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            .input-field input[type=search]:focus + label {\n");
      out.write("                color: black! important;\n");
      out.write("            }\n");
      out.write("            .input-field input[type=search]:focus {\n");
      out.write("                border-bottom: 1px solid #795548! important;\n");
      out.write("                box-shadow: 0 1px 0 0 #795548! important;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .input-field input[type=search].valid {\n");
      out.write("                border-bottom: 1px solid #76ff03!important;\n");
      out.write("                box-shadow: 0 1px 0 0 #76ff03!important;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .input-field input[type=search].invalid {\n");
      out.write("                border-bottom: 1px solid red !important;\n");
      out.write("                box-shadow: 0 1px 0 0 red!important;\n");
      out.write("            }\n");
      out.write("            /* icon prefix focus color */\n");
      out.write("            .input-field .prefix.active {\n");
      out.write("                color: #000;\n");
      out.write("            }\n");
      out.write("            *::-webkit-input-placeholder {\n");
      out.write("                /* Google Chrome y Safari */\n");
      out.write("                color: #757575;\n");
      out.write("            }\n");
      out.write("            .switch label input[type=checkbox]:checked+.lever {\n");
      out.write("                background-color: #64b5f6;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .switch label input[type=checkbox]:checked+.lever:after {\n");
      out.write("                background-color: #1565c0;\n");
      out.write("            }\n");
      out.write("            ul.dropdown-content.select-dropdown li span {\n");
      out.write("                color: #03a9f4; /* no need for !important :) */\n");
      out.write("            }   \n");
      out.write("            *::-webkit-input-placeholder {\n");
      out.write("                /* Google Chrome y Safari */\n");
      out.write("                color: #757575;\n");
      out.write("            }\n");
      out.write("            .input-field input[type=date]:focus + label {\n");
      out.write("                color: black! important;\n");
      out.write("            }\n");
      out.write("            /* label underline focus color */\n");
      out.write("            .input-field input[type=date]:focus {\n");
      out.write("                border-bottom: 1px solid #757575 ! important;\n");
      out.write("                box-shadow: 0 1px 0 0 #757575  ! important;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .input-field input[type=date].invalid {\n");
      out.write("                border-bottom: 1px solid red !important;\n");
      out.write("                box-shadow: 0 1px 0 0 red!important;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .input-field input[type=date].valid {\n");
      out.write("                border-bottom: 1px solid #76ff03!important;\n");
      out.write("                box-shadow: 0 1px 0 0 #76ff03!important;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            [type=\"checkbox\"].filled-in:checked + span:not(.lever):after {\n");
      out.write("                top: 0;\n");
      out.write("                width: 20px;\n");
      out.write("                height: 20px;\n");
      out.write("                border: 2px solid #1565c0 ;\n");
      out.write("                background-color: #90caf9 ;\n");
      out.write("                z-index: 0;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <script>\n");
      out.write("        function presiona2() {\n");
      out.write("            setTimeout(function () {\n");
      out.write("                window.location.replace('AngelLogIn.html');\n");
      out.write("            }, 0);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        ");

            HttpSession datos_sesion = request.getSession();
            String correo, contra;
            encriptador descripta = new encriptador();
            correo = descripta.desencriptar((String) (datos_sesion.getAttribute("correo")));
            contra = descripta.desencriptar((String) (datos_sesion.getAttribute("contra")));
            Iadministradordao controla_admi = new impadministrador();
            administrador admi = controla_admi.traeadministrador1(correo, contra);
            if (!(admi == null)) {

        
      out.write("\n");
      out.write("\n");
      out.write("        <nav>\n");
      out.write("            <div class=\"nav-wrapper grey darken-1\">\n");
      out.write("                <a  class=\"brand-logo center flow-text\"><i class=\"material-icons\">cloud</i>\"Angel\"</a>\n");
      out.write("                <a data-target=\"mobile-demo\" class=\"sidenav-trigger\" href=\"administrador_home.jsp\"><i class=\"material-icons left white-text\">arrow_back</i>Regresar</a>\n");
      out.write("                <ul id=\"nav-mobile\" class=\"left hide-on-med-and-down\">\n");
      out.write("                    <li><a href=\"administrador_home.jsp\"><i class=\"material-icons left\">arrow_back</i>Regresar al inicio</a></li>                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"contenedor-principal\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"responsive-table table-status-sheet\"style=\"margin-top: 5em ;text-align: center\">\n");
      out.write("                        <table class=\"bordered white\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr style=\"text-align: center\">\n");
      out.write("\n");
      out.write("                                    <th class=\"center flow-text\"><H5>Preguntas recibidas</H5></th>\n");
      out.write("                                    <div class=\"input-field col s6 m5 l5 brown-text flow-text\">\n");
      out.write("                                        <select name=\"filtro\" class=\"validate flow-text\" required>\n");
      out.write("                                            <option value=\"1\" selected>Pendientes</option>\n");
      out.write("                                            <option value=\"2\">Respondidos</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </div>\n");
      out.write("                                </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody id=\"milista\">\n");
      out.write("                                <tr>\n");
      out.write("\n");
      out.write("                                    ");
                                        Iticketsdao controla_tickets = new imptickets();
                                        ArrayList<tickets> lista_tickets = controla_tickets.traeTickets(admi.getModulo());
                                        controla_tickets.actualizaticketestado(admi.getModulo());
                                        for (int i = 0; i < lista_tickets.size(); i++) {
                                    
      out.write("\n");
      out.write("                                    <td>\n");
      out.write("                                        <ul class=\"collection\">\n");
      out.write("                                            <li class=\"collection-item avatar\">\n");
      out.write("                                                <i class=\"material-icons circle grey darken-1 large\" style=\"position: absolute; top:75%\">confirmation_number</i>\n");
      out.write("                                                <span class=\"title\">Id usuario: ");
out.print(lista_tickets.get(i).getId_usuario());
      out.write("</span>\n");
      out.write("                                                <p>Id ticket: ");
out.print(lista_tickets.get(i).getId_ticket());
      out.write("</p>\n");
      out.write("                                                ");

                                                    if (lista_tickets.get(i).getModulo() == 1) {
                                                
      out.write("\n");
      out.write("                                                <p>Modulo: Localizacion</p>\n");
      out.write("                                                ");

                                                    }
                                                
      out.write("\n");
      out.write("                                                ");

                                                    if (lista_tickets.get(i).getModulo() == 2) {
                                                
      out.write("\n");
      out.write("                                                <p>Modulo: Seguimiento Medico</p>\n");
      out.write("                                                ");

                                                    }
                                                
      out.write("\n");
      out.write("                                                ");

                                                    if (lista_tickets.get(i).getModulo() == 3) {
                                                
      out.write("\n");
      out.write("                                                <p>Modulo: Estimulacion temprana</p>\n");
      out.write("                                                ");

                                                    }
                                                
      out.write("\n");
      out.write("                                                ");

                                                    if (lista_tickets.get(i).getModulo() == 4) {
                                                
      out.write("\n");
      out.write("                                                <p>Modulo: Consejos y directorio</p>\n");
      out.write("                                                ");

                                                    }
                                                
      out.write("\n");
      out.write("                                                ");

                                                    if (lista_tickets.get(i).getModulo() == 5) {
                                                
      out.write("\n");
      out.write("                                                <p>Modulo: Usuario</p>\n");
      out.write("                                                ");

                                                    }
                                                
      out.write("\n");
      out.write("                                                ");

                                                    if (lista_tickets.get(i).getModulo() == 6) {
                                                
      out.write("\n");
      out.write("                                                <p>Modulo: FAQS</p>\n");
      out.write("                                                ");

                                                    }
                                                
      out.write("\n");
      out.write("                                                <p>Pregunta: ");
out.print(lista_tickets.get(i).getPregunta());
      out.write(" </p>\n");
      out.write("                                                <form action=\"responde_ticket\" method=\"post\">\n");
      out.write("                                                    <div class=\"input-field col s12 m12 l12\">\n");
      out.write("                                                        <input type=\"text\" onkeypress=\"alfanumerico()\" class=\"validate\" name=\"respuesta\" id=\"respuesta\" required placeholder=\"Respuesta\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <input type=\"text\" name=\"id_ticket\" readonly style=\"visibility: hidden; position: absolute; float: top; z-index: 0\" value=\"");
out.print(lista_tickets.get(i).getId_ticket());
      out.write("\">\n");
      out.write("\n");
      out.write("                                                    <input class=\" secondary-content btn grey darken-1 modal-trigger\" style=\"position: absolute;top:75%\" type=\"submit\" value=\"Responder y subir\">\n");
      out.write("                                                </form>\n");
      out.write("                                            </li>\n");
      out.write("                                            ");

                                                }
                                            
      out.write("\n");
      out.write("                                        </ul>  \n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");

            } else {
                out.println("<script>alert('Inicia sesion');</script>");
                out.print("<Script>presiona2();</Script>");
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
