package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.owasp.esapi.ESAPI;
import java.sql.Date;
import com.angel.modelo.reporte;
import java.util.ArrayList;
import com.angel.impdao.impreporte;
import com.angel.dao.Ireportedao;
import com.angel.impdao.impusuario;
import com.angel.modelo.cuenta_usuario;
import com.angel.modelo.usuario;
import com.angel.dao.Iusuariodao;
import com.angel.seguridad.encriptador;

public final class lista_005freportes_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Angel-Gestión Reportes</title>\n");
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
      out.write("                background: url(imagenes/wallrep.jpg) no-repeat center center fixed;\n");
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
      out.write("                border-bottom: 1px solid #0d47a1! important;\n");
      out.write("                box-shadow: 0 1px 0 0 #0d47a1 ! important;\n");
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
      out.write("                border-bottom: 1px solid #0d47a1! important;\n");
      out.write("                box-shadow: 0 1px 0 0 #0d47a1 ! important;\n");
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
      out.write("            .input-field input[type=search]:focus + label {\n");
      out.write("                color: black! important;\n");
      out.write("            }\n");
      out.write("            /* label underline focus color */\n");
      out.write("            .input-field input[type=search]:focus {\n");
      out.write("                border-bottom: 1px solid #0d47a1! important;\n");
      out.write("                box-shadow: 0 1px 0 0 #0d47a1 ! important;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .input-field input[type=search].invalid {\n");
      out.write("                border-bottom: 1px solid red !important;\n");
      out.write("                box-shadow: 0 1px 0 0 red!important;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .input-field input[type=search].valid {\n");
      out.write("                border-bottom: 1px solid #76ff03!important;\n");
      out.write("                box-shadow: 0 1px 0 0 #76ff03!important;\n");
      out.write("            }\n");
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
            System.out.println(config.getServletContext().getRealPath("/")+"aaa");
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
      out.write("        <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-3.2.1.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/materialize.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/script.js\"></script>\n");
      out.write("        <script>\n");
      out.write("        $(document).ready(function () {\n");
      out.write("            $('.sidenav').sidenav();\n");
      out.write("            $(\".dropdown-trigger\").dropdown();\n");
      out.write("            $('.modal').modal();\n");
      out.write("            $('select').formSelect();\n");
      out.write("\n");
      out.write("\n");
      out.write("        });\n");
      out.write("        </script>\n");
      out.write("        <ul id=\"dropdown1\" class=\"dropdown-content\">\n");
      out.write("            <li class=\"blue flow-text\"><a href=\"Home.jsp\"><i class=\"material-icons left\">home</i>Inicio</a></li>\n");
      out.write("            <li class=\"blue flow-text\"><a href=\"AngelUsuario.jsp\"><i class=\"material-icons left\">edit</i>Usuario</a></li>\n");
      out.write("            <li class=\"blue flow-text\"><a href=\"AngelLocalizacion.jsp\"><i class=\"material-icons left\">my_location</i>Ubicación</a></li>\n");
      out.write("            <li class=\"blue flow-text\"><a href=\"badges.html\"><i class=\"material-icons left\">help</i>Ayuda</a></li>\n");
      out.write("            <li class=\"blue flow-text\"><a href=\"cerrar_sesion\"><i class=\"material-icons left\">power_settings_new</i>Salir</a></li>\n");
      out.write("        </ul>\n");
      out.write("        <nav class=\"blue\" style=\"z-index: 99999\">\n");
      out.write("            <div class=\"nav-wrapper \">\n");
      out.write("                <a class=\"brand-logo flow-text center\"><i class=\"material-icons t\">picture_as_pdf</i>Gestión de reportes</a>\n");
      out.write("                <a href=\"#\" data-target=\"mobile-demo\" class=\"sidenav-trigger\"><i class=\"material-icons right\">menu</i></a>\n");
      out.write("                <ul class=\"right hide-on-med-and-down\">\n");
      out.write("                    <li><a class=\"dropdown-trigger\" href=\"#!\" data-target=\"dropdown1\"><i class=\"material-icons right\">arrow_drop_down</i><i class=\"material-icons right\">account_box</i>");
 out.print(ESAPI.encoder().decodeForHTML(usua.getNombre())); 
      out.write("</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav> \n");
      out.write("\n");
      out.write("\n");
      out.write("        <ul class=\"sidenav blue\" id=\"mobile-demo\"style=\"margin-top: 4.5em\" >\n");
      out.write("            <li class=\"blue white-text flow-text\"><a  class=\"white-text\"><i class=\"material-icons left white-text\">person_pin</i>");
 out.print("Bienvenido: " + ESAPI.encoder().decodeForHTML(usua.getNombre()));
      out.write("</a></li>\n");
      out.write("            <li class=\"blue white-text flow-text\" ><a href=\"Home.jsp\" class=\" white-text\"><i class=\"material-icons left white-text\">home</i>Regresar a Inicio</a></li>\n");
      out.write("            <li class=\"blue white-text flow-text\"><a href=\"AngelUsuario.jsp\" class=\"white-text\"><i class=\"material-icons left white-text\">edit</i>Editar Información</a></li>\n");
      out.write("            <li class=\"blue white-text flow-text\"><a href=\"AngelLocalizacion.jsp\" class=\"white-text\"><i class=\"material-icons left white-text\">my_location</i>Localización</a></li>\n");
      out.write("            <li class=\"blue white-text flow-text\" ><a href=\"badges.html\" class=\"white-text\"><i class=\"material-icons left white-text\">help</i>Ayuda</a></li>\n");
      out.write("            <li class=\"blue white-text flow-text\"><a href=\"cerrar_sesion\" class=\"white-text\"><i class=\"material-icons left white-text\">power_settings_new</i>Cerrar Sesión</a></li>\n");
      out.write("        </ul>\n");
      out.write("\n");
      out.write("        <div class=\"contenedor-principal\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"responsive-table table-status-sheet\"style=\"margin-top: 5em\">\n");
      out.write("                        <table class=\"bordered white\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("\n");
      out.write("                                    <th class=\"center flow-text\"><H5>Selecciona un reporte</H5></th>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th class=\"hide-on-med-and-up\" colspan=\"2\">\n");
      out.write("                                        <form>\n");
      out.write("                                            <div class=\"input-field\" style=\"padding: 0\">\n");
      out.write("                                                <input id=\"search\" type=\"search\" required>\n");
      out.write("                                                <label  for=\"search\"><i class=\"material-icons\">search</i></label>\n");
      out.write("                                                <i class=\"material-icons\">close</i>\n");
      out.write("                                            </div>\n");
      out.write("                                        </form>\n");
      out.write("                                    </th>\n");
      out.write("                                </tr>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody id=\"milista\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        <ul class=\"collection\">\n");
      out.write("                                            ");

                                                Ireportedao controla_reporte = new impreporte();
                                                int id_infan = Integer.parseInt(request.getParameter("id_infa"));
                                                datos_sesion.setAttribute("id_infante", id_infan);
                                                ArrayList<reporte> lista_reporte = controla_reporte.trereportes(id_infan);
                                                for (int i = 0; i < lista_reporte.size(); i++) {
                                                    Date realizado_en = lista_reporte.get(i).getFecha();
                                                    String fecha_realizado_en = (realizado_en.getYear() + 1900) + "-";
                                                    if ((realizado_en.getMonth() + 1) < 10) {
                                                        fecha_realizado_en += "0" + (realizado_en.getMonth() + 1) + "-";
                                                    } else {
                                                        fecha_realizado_en += (realizado_en.getMonth() + 1) + "-";
                                                    }
                                                    if ((realizado_en.getDate()) < 10) {
                                                        fecha_realizado_en += "0" + (realizado_en.getDate());
                                                    } else {
                                                        fecha_realizado_en += (realizado_en.getDate());
                                                    }
                                            
      out.write("\n");
      out.write("\n");
      out.write("                                            <li class=\"collection-item avatar\">\n");
      out.write("                                                <i class=\"material-icons circle blue large\" style=\"position: absolute; top: 40%;\">library_books</i>\n");
      out.write("                                                <span class=\"title\"><h4>Reporte: ");
out.print((i + 1));
      out.write("</h4></span>\n");
      out.write("                                                <p>Id reporte: ");
out.print(lista_reporte.get(i).getId_reporte());
      out.write("</p>\n");
      out.write("                                                <p>Hecho en: ");
out.print(fecha_realizado_en);
      out.write(" </p>\n");
      out.write("                                                <form action=\"generador_reporte_pdf\" method=\"post\">\n");
      out.write("                                                    <input type=\"text\" name=\"id_infa\" readonly style=\"visibility: hidden; position: absolute; float: top; z-index: 0\" value=\"");
out.print(lista_reporte.get(i).getId_reporte());
      out.write("\">\n");
      out.write("                                                    <button  class=\"btn-large blue secondary-content  \" type=\"submit\" name=\"action\"  style=\"position: absolute; top: 40%;\">Ver<i class=\"white-text material-icons right\">picture_as_pdf</i>\n");
      out.write("                                                    </button> \n");
      out.write("                                                </form>\n");
      out.write("                                            </li>\n");
      out.write("\n");
      out.write("                                            ");

                                                }
                                            
      out.write("\n");
      out.write("                                        </ul>  \n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");

                } else {
                    out.println("<script>alert('Inicia sesion primero');</script>");
                    out.print("<Script>presiona2();</Script>");
                }
            }
        
      out.write("\n");
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
