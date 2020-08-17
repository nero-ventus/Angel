package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.angel.modelo.preguntas;
import com.angel.impdao.imppreguntas;
import com.angel.dao.Ipreguntasdao;
import com.angel.impdao.imprespuestas;
import com.angel.dao.Irespuestasdao;
import com.angel.modelo.respuestas;
import java.util.ArrayList;
import java.util.ArrayList;
import org.owasp.esapi.ESAPI;
import com.angel.impdao.impusuario;
import com.angel.dao.Iusuariodao;
import com.angel.modelo.usuario;
import com.angel.modelo.cuenta_usuario;
import com.angel.seguridad.encriptador;

public final class FAQS_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Angel-FAQS</title>\n");
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
      out.write("\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background: url(imagenes/fondoangelhome.jpg) no-repeat center center fixed;\n");
      out.write("                -webkit-background-size: cover;\n");
      out.write("                -moz-background-size: cover;\n");
      out.write("                -o-background-size: cover;      \n");
      out.write("                background-size: cover;\n");
      out.write("            }   \n");
      out.write("            tab a.active {\n");
      out.write("                color:#4fc3f7!important;\n");
      out.write("                background-color:#4fc3f7!important;\n");
      out.write("            }\n");
      out.write("            .tabs .tab a:hover {\n");
      out.write("                background-color: #4fc3f7!important;\n");
      out.write("                color:#FFFFFF!important;\n");
      out.write("            }\n");
      out.write("            .tabs .tab a {\n");
      out.write("                color: #FFFFFF!important;\n");
      out.write("            }\n");
      out.write("            .tabs .indicator{\n");
      out.write("                background-color:black!important;\n");
      out.write("            }\n");
      out.write("\n");
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
      out.write("\n");
      out.write("\n");
      out.write("            .dropdown-content li>a {\n");
      out.write("                color: white !important;\n");
      out.write("            }\n");
      out.write("            .preloader-background {\n");
      out.write("                display: flex;\n");
      out.write("                align-items: center;\n");
      out.write("                justify-content: center;\n");
      out.write("                background-color: #eee;\n");
      out.write("                position: fixed;\n");
      out.write("                z-index: 2;\n");
      out.write("                top: 0;\n");
      out.write("                left: 0;\n");
      out.write("                right: 0;\n");
      out.write("                bottom: 0;\n");
      out.write("                p {\n");
      out.write("                    padding-top:240px;\n");
      out.write("                    margin-left: -60px;\n");
      out.write("                    opacity: 0.8;\n");
      out.write("                } \n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            .blinking {\n");
      out.write("                animation: blinker 0.5s linear infinite;\n");
      out.write("            }\n");
      out.write("            @keyframes blinker {  \n");
      out.write("                50% { opacity: 0; }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("            function presiona2() {\n");
      out.write("                setTimeout(function () {\n");
      out.write("                    window.location.replace('AngelLogIn.html');\n");
      out.write("                }, 0);\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
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
      out.write("        <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-3.2.1.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/materialize.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/script.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $('.sidenav').sidenav();\n");
      out.write("                $(\".dropdown-trigger\").dropdown();\n");
      out.write("\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("            document.addEventListener(\"DOMContentLoaded\", function () {\n");
      out.write("                $('.preloader-background').delay(1700).fadeOut('slow');\n");
      out.write("\n");
      out.write("                $('.preloader-wrapper')\n");
      out.write("                        .delay(1700)\n");
      out.write("                        .fadeOut();\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        <!-- Preloader and it's background. -->\n");
      out.write("        <div class=\"preloader-background\">\n");
      out.write("            <div class=\"preloader-wrapper big active\">\n");
      out.write("                <div class=\"spinner-layer spinner-blue\">\n");
      out.write("                    <div class=\"circle-clipper left\">\n");
      out.write("                        <div class=\"circle\"></div>\n");
      out.write("                    </div><div class=\"gap-patch\">\n");
      out.write("                        <div class=\"circle\"></div>\n");
      out.write("                    </div><div class=\"circle-clipper right\">\n");
      out.write("                        <div class=\"circle\"></div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"spinner-layer spinner-red\">\n");
      out.write("                    <div class=\"circle-clipper left\">\n");
      out.write("                        <div class=\"circle\"></div>\n");
      out.write("                    </div><div class=\"gap-patch\">\n");
      out.write("                        <div class=\"circle\"></div>\n");
      out.write("                    </div><div class=\"circle-clipper right\">\n");
      out.write("                        <div class=\"circle\"></div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"spinner-layer spinner-yellow\">\n");
      out.write("                    <div class=\"circle-clipper left\">\n");
      out.write("                        <div class=\"circle\"></div>\n");
      out.write("                    </div><div class=\"gap-patch\">\n");
      out.write("                        <div class=\"circle\"></div>\n");
      out.write("                    </div><div class=\"circle-clipper right\">\n");
      out.write("                        <div class=\"circle\"></div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"spinner-layer spinner-green\">\n");
      out.write("                    <div class=\"circle-clipper left\">\n");
      out.write("                        <div class=\"circle\"></div>\n");
      out.write("                    </div><div class=\"gap-patch\">\n");
      out.write("                        <div class=\"circle\"></div>\n");
      out.write("                    </div><div class=\"circle-clipper right\">\n");
      out.write("                        <div class=\"circle\"></div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <ul id=\"dropdown1\" class=\"dropdown-content\">\n");
      out.write("            <li class=\"blue\"><a href=\"AngelUsuario.jsp\"><i class=\"material-icons left\">edit</i>Usuario</a></li>\n");
      out.write("            <li class=\"blue\"><a href=\"AngelGestionInfantil.jsp\"><i class=\"material-icons left\">child_friendly</i>Niños</a></li>\n");
      out.write("            <li class=\"blue\"><a href=\"AngelLocalizacion.jsp\"><i class=\"material-icons left\">my_location</i>Ubicación</a></li>\n");
      out.write("            <li class=\"blue\"><a href=\"FAQS.html\"><i class=\"material-icons left\">help</i>Ayuda</a></li>\n");
      out.write("            <li class=\"blue\"><a href=\"cerrar_sesion\"><i class=\"material-icons left\">power_settings_new</i>Salir</a></li>\n");
      out.write("        </ul>\n");
      out.write("        <nav class=\"blue\" style=\"z-index: 99999\">\n");
      out.write("            <div class=\"nav-wrapper \">\n");
      out.write("                <a href=\"AngelAcercadeNosotros.html\" class=\"brand-logo flow-text center\"><i class=\"material-icons t\">cloud</i>Angel</a>\n");
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
      out.write("            <li class=\"blue\"><a  class=\"white-text\"><i class=\"material-icons left white-text\">person_pin</i>");
 out.print("Bienvenido: " + ESAPI.encoder().decodeForHTML(usua.getNombre())); 
      out.write("</a></li>\n");
      out.write("            <li class=\"blue white-text\"><a href=\"AngelUsuario.jsp\" class=\"white-text\"><i class=\"material-icons left white-text\">edit</i>Editar Información</a></li>\n");
      out.write("            <li class=\"blue white-text\"><a href=\"AngelGestionInfantil.jsp\" class=\"white-text\"><i class=\"material-icons left white-text\">child_friendly</i>Gestión Infantil</a></li>\n");
      out.write("            <li class=\"blue white-text\"><a href=\"\" class=\"white-text\"><i class=\"material-icons left white-text\">my_location</i>Localización</a></li>\n");
      out.write("            <li class=\"blue white-text\"><a href=\"FAQS.html\" class=\"white-text\"><i class=\"material-icons left white-text\">help</i>Ayuda</a></li>\n");
      out.write("            <li class=\"blue white-text\"><a href=\"cerrar_sesion\" class=\"white-text\"><i class=\"material-icons left white-text\">power_settings_new</i>Cerrar Sesión</a></li>\n");
      out.write("        </ul>\n");
      out.write("        <div class=\"contenedor-principal\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col s12\">\n");
      out.write("                        <ul class=\"collapsible z-depth-5\">\n");
      out.write("                            <li>\n");
      out.write("                                <div class=\"collapsible-header blue lighten-4\">Ayuda personalizada (Hacer esto despues de verificar las preguntas siguientes)</div>\n");
      out.write("                                <div class=\"collapsible-body white\"><a href=\"form_ticket.jsp\">Chat</a></div>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        <ul class=\"collapsible z-depth-5\">\n");
      out.write("                            <li>\n");
      out.write("                                <div class=\"collapsible-header blue lighten-4\">¿Que es Angel?</div>\n");
      out.write("                                <div class=\"collapsible-body white\">Es un programada diseñado para salvaguardar la seguridad infantil y servir de apoyo a padres primerizos en la crianza de sus infantes.</div>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        <ul class=\"collapsible z-depth-5\">\n");
      out.write("                            <li>\n");
      out.write("                                <div class=\"collapsible-header blue lighten-4\">¿En que me ayuda?</div>\n");
      out.write("                                <div class=\"collapsible-body white\">Ayuda en muchos aspectos, desde a localizar donde esta el infante tanto dentro como fuera de la casa, a estimular la mente del infante de manera tempara, entro otros, hasta a prevenir una posible enfermedad del infante.</div>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        <ul class=\"collapsible z-depth-5\">\n");
      out.write("                            <li>\n");
      out.write("                                <div class=\"collapsible-header blue lighten-4\">¿Como puedo recuperar el acceso a mi cuenta?</div>\n");
      out.write("                                <div class=\"collapsible-body white\">El acceso a la cuenta solo se puede recuperar teniendo el correo ligado a la cuenta disponible, de otra manera es imposible recuperarla, si se tiene el correo desde la pagina de iniciar sesion seleciona recuperar cuenta, ingresa el correo y asu correo electronico se le enviara el enlace para recuperar el acceso.</div>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        <ul class=\"collapsible z-depth-5\">\n");
      out.write("                            <li>\n");
      out.write("                                <div class=\"collapsible-header blue lighten-4\">¿Cuantos infantes puedo registar en el sistema?</div>\n");
      out.write("                                <div class=\"collapsible-body white\">Se puede registrar el mismo numero de infantes que de dispositivos de seguimiento libres para su uso, en caso de ya no tener de estos libres, ya no se podra registrar a otro infante.</div>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        <ul class=\"collapsible z-depth-5\">\n");
      out.write("                            <li>\n");
      out.write("                                <div class=\"collapsible-header blue lighten-4\">¿Se pueden reutilizar los dispositivos de seguimiento?</div>\n");
      out.write("                                <div class=\"collapsible-body white\">Si, cuando se desvincula uno de estos de algun infante y queda libre, se puede usar con otro infante.</div>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        <ul class=\"collapsible z-depth-5\">\n");
      out.write("                            <li>\n");
      out.write("                                <div class=\"collapsible-header blue lighten-4\">¿Angel es seguro?</div>\n");
      out.write("                                <div class=\"collapsible-body white\">Si, contamos con la tecnologia de vanguardia en cuanto a seguridad se refiere ademas de nuestro algorito diseñado en casa, lo cual mantendra tus datos seguros.</div>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        <ul class=\"collapsible z-depth-5\">\n");
      out.write("                            <li>\n");
      out.write("                                <div class=\"collapsible-header blue lighten-4\">¿Como puedo eliminar mi cuenta?</div>\n");
      out.write("                                <div class=\"collapsible-body white\">En la pantalla de usuario esta el boton para eliminar la cuenta, una vez hecho esta se borrara para siempre del sistema.</div>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        <ul class=\"collapsible z-depth-5\">\n");
      out.write("                            <li>\n");
      out.write("                                <div class=\"collapsible-header blue lighten-4\">¿Que pasa con mis datos depues de eliminar mi cuenta?</div>\n");
      out.write("                                <div class=\"collapsible-body white\">Son eliminados de manera permanente del sistema para que no se les llegue a dar mal uso en cualquier situacion posible.</div>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        <ul class=\"collapsible z-depth-5\">\n");
      out.write("                            <li>\n");
      out.write("                                <div class=\"collapsible-header blue lighten-4\">¿Puedo cambiar un sensor de habitacion?</div>\n");
      out.write("                                <div class=\"collapsible-body white\">Si, y todo lo puedes configurar en la pestaña de configuracion de sensores, ahi puedes asignar que cuarto custodiara que sensor.</div>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        <ul class=\"collapsible z-depth-5\">\n");
      out.write("                            <li>\n");
      out.write("                                <div class=\"collapsible-header blue lighten-4\">¿Es necesario un tecnico para configurar mi equipo?</div>\n");
      out.write("                                <div class=\"collapsible-body white\">No dado que el mismo programa a traves de una interfaz amigable te permite hacerlo de manera eficiente y rapida.</div>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        <ul class=\"collapsible z-depth-5\">\n");
      out.write("                            <li>\n");
      out.write("                                <div class=\"collapsible-header blue lighten-4\">¿Necesito estar siempre conectado a internet?</div>\n");
      out.write("                                <div class=\"collapsible-body white\">Si, para el funcionamiento correcto de Angel se necesita disponer de conexcion continua a internet.</div>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        <ul class=\"collapsible z-depth-5\">\n");
      out.write("                            <li>\n");
      out.write("                                <div class=\"collapsible-header blue lighten-4\">¿Solictar mas sensores/dispositivos genera costo extra?</div>\n");
      out.write("                                <div class=\"collapsible-body white\">Si, pero solo el precio del sensores/dispositivos, de otra forma no tendriamos el capital para fabricarlo.</div>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        <ul class=\"collapsible z-depth-5\">\n");
      out.write("                            <li>\n");
      out.write("                                <div class=\"collapsible-header blue lighten-4\">¿Que hacer si un sesor/dispositivo deja de funcionar correctamente?</div>\n");
      out.write("                                <div class=\"collapsible-body white\">En dado caso que el quipo deje de funcionar de manera correcta por razones ajenas al cliente, se le repondra la totalidad e este con otro sensor/dispositivo igual.</div>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        <ul class=\"collapsible z-depth-5\">\n");
      out.write("                            <li>\n");
      out.write("                                <div class=\"collapsible-header blue lighten-4\">¿Hasta que edad se puede usar Angel en los infantes?</div>\n");
      out.write("                                <div class=\"collapsible-body white\">Angel de manera general esta diseñada para infantes no mayores a 6 años, pero el dispositivo de seguimiento se puede usar de por vida.</div>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        ");

                            try{
                                ArrayList<respuestas> lista_respuestas=new ArrayList();
                                Irespuestasdao contra_respues=new imprespuestas();
                                Ipreguntasdao contra_pregun=new imppreguntas();
                                lista_respuestas=contra_respues.traerespuestas();
                                for (int i = 0; i < lista_respuestas.size(); i++) {
                                    preguntas pregun=contra_pregun.traepreguntas(lista_respuestas.get(i).getId_pregunta());
                        
      out.write("\n");
      out.write("                        <ul class=\"collapsible z-depth-5\">\n");
      out.write("                            <li>\n");
      out.write("                                <div class=\"collapsible-header blue lighten-4\">");
out.print(pregun.getTexto());
      out.write("</div>\n");
      out.write("                                <div class=\"collapsible-body white\">");
out.print(lista_respuestas.get(i).getTexto());
      out.write("</div>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                        ");

                            }
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                            e.printStackTrace();
                        }
                        
      out.write("\n");
      out.write("                        <ul class=\"collapsible z-depth-5\">\n");
      out.write("                            <li>\n");
      out.write("                                <div class=\"collapsible-header blue lighten-4\">Contactanos</div>\n");
      out.write("                                <div class=\"collapsible-body white\">\n");
      out.write("                                    <form action=\"registra_pregunta\" method=\"post\">\n");
      out.write("                                        <input type=\"text\" id=\"texto_p\" name=\"texto_p\">\n");
      out.write("                                        <input type=\"submit\" value=\"Enviar Pregunta\" class=\"waves-effect waves-light btn\">\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        ");

                } else {
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
