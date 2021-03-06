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

public final class AngelContactosDeConfianza_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Angel-Contactos de Confianza</title>\n");
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
      out.write("                background: url(imagenes/fondousable.jpg) no-repeat center center fixed;\n");
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
      out.write("\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("            function hab() {\n");
      out.write("                if (document.getElementById('switch1').checked)\n");
      out.write("                {\n");
      out.write("                    document.getElementById(\"fotoperfil\").classList.remove('disabled');\n");
      out.write("                    document.getElementById(\"enviar1\").disabled = false;\n");
      out.write("                    document.getElementById(\"nombre\").disabled = false;\n");
      out.write("                    document.getElementById(\"apellido_p\").disabled = false;\n");
      out.write("                    document.getElementById(\"apellido_m\").disabled = false;\n");
      out.write("                    document.getElementById(\"contra\").disabled = false;\n");
      out.write("                    document.getElementById(\"ncontra\").disabled = false;\n");
      out.write("                    document.getElementById(\"nccontra\").disabled = false;\n");
      out.write("                    document.getElementById(\"nex\").disabled = false;\n");
      out.write("                    document.getElementById(\"calle\").disabled = false;\n");
      out.write("                    document.getElementById(\"municipio\").disabled = false;\n");
      out.write("                    document.getElementById(\"selectedenable\").removeAttribute(\"style\");\n");
      out.write("                    document.getElementById(\"selectdisabled\").setAttribute(\"style\", \"display:none\");\n");
      out.write("\n");
      out.write("                } else {\n");
      out.write("                    document.getElementById(\"fotoperfil\").classList.add('disabled');\n");
      out.write("                    document.getElementById(\"enviar1\").disabled = true;\n");
      out.write("                    document.getElementById(\"nombre\").disabled = true;\n");
      out.write("                    document.getElementById(\"apellido_p\").disabled = true;\n");
      out.write("                    document.getElementById(\"apellido_m\").disabled = true;\n");
      out.write("                    document.getElementById(\"contra\").disabled = true;\n");
      out.write("                    document.getElementById(\"nex\").disabled = true;\n");
      out.write("                    document.getElementById(\"calle\").disabled = true;\n");
      out.write("                    document.getElementById(\"municipio\").disabled = true;\n");
      out.write("                    document.getElementById(\"ncontra\").disabled = true;\n");
      out.write("                    document.getElementById(\"nccontra\").disabled = true;\n");
      out.write("                    document.getElementById(\"selectdisabled\").removeAttribute(\"style\");\n");
      out.write("                    document.getElementById(\"selectedenable\").setAttribute(\"style\", \"display:none\");\n");
      out.write("                }\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("        </script>\n");
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
      out.write("\n");
      out.write("        });\n");
      out.write("        </script>\n");
      out.write("        <ul id=\"dropdown1\" class=\"dropdown-content\">\n");
      out.write("            <li class=\"blue\"><a href=\"Home.jsp\"><i class=\"material-icons left\">home</i>Regresar a Inicio</a></li>\n");
      out.write("            <li class=\"blue\"><a href=\"AngelUsuario.jsp\"><i class=\"material-icons left\">edit</i>Editar Información</a></li>\n");
      out.write("            <li class=\"blue\"><a href=\"\"><i class=\"material-icons left\">child_friendly</i>Gestión Infantil</a></li>\n");
      out.write("            <li class=\"blue\"><a href=\"\"><i class=\"material-icons left\">my_location</i>Localización</a></li>\n");
      out.write("            <li class=\"blue\"><a href=\"badges.html\"><i class=\"material-icons left\">help</i>Ayuda</a></li>\n");
      out.write("            <li class=\"blue\"><a href=\"cerrar_sesion\"><i class=\"material-icons left\">power_settings_new</i>Cerrar Sesión</a></li>\n");
      out.write("        </ul>\n");
      out.write("        <nav class=\"blue\" style=\"z-index: 99999\">\n");
      out.write("            <div class=\"nav-wrapper \">\n");
      out.write("                <a class=\"brand-logo flow-text center\"><i class=\"material-icons t\">contact_mail</i>Contactos</a>\n");
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
      out.write("            <li class=\"blue white-text\"><a  class=\"white-text\"><i class=\"material-icons left white-text\">person_pin</i>");
 out.print("Bienvenido: " + ESAPI.encoder().decodeForHTML(usua.getNombre()));
      out.write("</a></li>\n");
      out.write("            <li class=\"blue white-text\" ><a href=\"Home.jsp\" class=\" white-text\"><i class=\"material-icons left white-text\">home</i>Regresar a Inicio</a></li>\n");
      out.write("            <li class=\"blue white-text\"><a href=\"AngelUsuario.jsp\" class=\"white-text\"><i class=\"material-icons left white-text\">edit</i>Editar Información</a></li>\n");
      out.write("            <li class=\"blue white-text\"><a href=\"\" class=\"white-text\"><i class=\"material-icons left white-text\">child_friendly</i>Gestión Infantil</a></li>\n");
      out.write("            <li class=\"blue white-text\"><a href=\"\" class=\"white-text\"><i class=\"material-icons left white-text\">my_location</i>Localización</a></li>\n");
      out.write("            <li class=\"blue white-text\"><a href=\"badges.html\" class=\"white-text\"><i class=\"material-icons left white-text\">help</i>Ayuda</a></li>\n");
      out.write("            <li class=\"blue white-text\"><a href=\"cerrar_sesion\" class=\"white-text\"><i class=\"material-icons left white-text\">power_settings_new</i>Cerrar Sesión</a></li>\n");
      out.write("        </ul>\n");
      out.write("\n");
      out.write("        <div class=\"contenedor-principal\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"responsive-table table-status-sheet\"style=\"margin-top: 5em\">\n");
      out.write("                        <table class=\"bordered white\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th colspan=\"2\" class=\"center flow-text\"><H5>Agrega aqui tus contactos de confianza</H5></th>\n");
      out.write("                                    <th class=\"center flow-text\">\n");
      out.write("                                        <a class=\" btn modal-trigger right blue flow-text\" href=\"#agregarcontacto\">  <i class=\"material-icons right\">group_add</i>Añadir Contacto</a>\n");
      out.write("\n");
      out.write("                                        <!-- Modal Structure -->\n");
      out.write("                                        <div id=\"agregarcontacto\" class=\"modal \" style=\"margin-top: 1em\">\n");
      out.write("                                            <div class=\"modal-content\">\n");
      out.write("                                                <h4>¡Agrega un contacto!</h4>\n");
      out.write("                                                <form action=\"agregar_contact\" method=\"post\">\n");
      out.write("                                                    <div class=\"input-field col s12 m4 l4\">\n");
      out.write("                                                        <input placeholder=\"Nombre del Contacto\" pattern=\"^[A-Za-z ]+$\"  onkeypress=\"letras()\" id=\"nombre\" name=\"nombre\" type=\"text\" class=\"validate\" required>\n");
      out.write("                                                        <label for=\"nombre\">Nombre</label>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"input-field col s12 m4 l4\">\n");
      out.write("                                                        <input placeholder=\"Apellido P. del Contacto\" pattern=\"^[A-Za-z ]+$\" onkeypress=\"letras()\" id=\"apellido_p\" name=\"apellido_p\" type=\"text\" class=\"validate\" required>\n");
      out.write("                                                        <label for=\"apellido_p\">Apellido Paterno</label>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"input-field col s12 m4 l4\">\n");
      out.write("                                                        <input placeholder=\"Apellido M. del Contacto\" pattern=\"^[A-Za-z ]+$\" onkeypress=\"letras()\" id=\"apellido_m\" name=\"apellido_m\" type=\"text\" class=\"validate\" required>\n");
      out.write("                                                        <label for=\"apellido_m\">Apellido Materno</label>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"input-field col s6\">\n");
      out.write("                                                        <input placeholder=\"Num. Telefónico\" pattern=\"^[0-9]+$\" onkeypress=\"numerico()\" id=\"telefono\" name=\"telefono\" type=\"text\" class=\"validate\">\n");
      out.write("                                                        <label for=\"telefono\">Teléfono</label>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <div class=\"input-field col s6\">\n");
      out.write("                                                        <input placeholder=\"E-mail\" id=\"correo\" onkeypress=\"email()\" pattern=\"^(([^<>()\\[\\]\\\\.,;:\\s@']+(\\.[^<>()\\[\\]\\\\.,;:\\s@']+)*)|('.+'))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$\" name=\"correo\" type=\"text\" class=\"validate\">\n");
      out.write("                                                        <label for=\"correo\">Correo</label>\n");
      out.write("                                                    </div>\n");
      out.write("                                                    <button class=\"btn blue\" type=\"submit\" name=\"action\">Guardar<i class=\"material-icons right\">save</i>\n");
      out.write("                                                    </button>\n");
      out.write("\n");
      out.write("                                                </form>\n");
      out.write("                                            </div>\n");
      out.write("\n");
      out.write("                                        </div></th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody id=\"milista\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        <ul class=\"collection\">\n");
      out.write("                                            <li class=\"collection-item avatar\">\n");
      out.write("                                                <i class=\"material-icons circle blue\">account_circle</i>\n");
      out.write("                                                <span class=\"title\">Número de contacto: id_contacto</span>\n");
      out.write("                                                <p>Nombre: nombrecompleto_obtenido</p>\n");
      out.write("                                                <p>Celular: celular_obtenido </p>\n");
      out.write("                                                <p>Correo: correo_obtenido </p>\n");
      out.write("\n");
      out.write("                                                <a class=\" secondary-content btn modal-trigger blue\" href=\"#editarnumerodeusuario_obtenido\"><i class=\"material-icons right\">edit</i>Editar</a>\n");
      out.write("                                                <!-- Modal Structure -->\n");
      out.write("                                                <div id=\"editarnumerodeusuario_obtenido\" class=\"modal\" style=\"margin-top: 1em\">\n");
      out.write("                                                    <div class=\"modal-content\" style=\"text-align: center\">\n");
      out.write("                                                        <h4 class=\"center\">Contacto numcontacto_obtenido:</h4>\n");
      out.write("                                                        <h5>Edita tu contacto</h5>\n");
      out.write("                                                        <div class=\"switch col s12 m12 l12 \">\n");
      out.write("                                                            Editar:<br>\n");
      out.write("                                                            <label>\n");
      out.write("                                                                No\n");
      out.write("                                                                <input id=\"switch_numcontact_obtenido\" type=\"checkbox\" onclick=\"hab_numcontact_obtenido()()\">\n");
      out.write("                                                                <span class=\"lever\"></span>\n");
      out.write("                                                                Si\n");
      out.write("                                                            </label>          \n");
      out.write("                                                        </div>\n");
      out.write("                                                        <form action=\"\" method=\"post\">\n");
      out.write("                                                            <div class=\"input-field col s12 m4 l4\">\n");
      out.write("                                                                <input disabled value=\"nombre_obtenido\" placeholder=\"Nombre del Contacto\" pattern=\"^[A-Za-z ]+$\"  onkeypress=\"letras()\" id=\"nombre_numcontac_obtenido\" name=\"nombre_numcontac_obtenido\" type=\"text\" class=\"validate\" required>\n");
      out.write("                                                                <label for=\"nombre\">Nombre</label>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            <div class=\"input-field col s12 m4 l4\">\n");
      out.write("                                                                <input disabled value=\"apellidop_obtenido\" placeholder=\"Apellido P. del Contacto\" pattern=\"^[A-Za-z ]+$\" onkeypress=\"letras()\" id=\"apellido_p_numcontac_obtenido\" name=\"apellido_p_numcontac_obtenido\" type=\"text\" class=\"validate\" required>\n");
      out.write("                                                                <label for=\"apellido_p\">Apellido Paterno</label>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            <div class=\"input-field col s12 m4 l4\">\n");
      out.write("                                                                <input disabled value=\"apellidom_obtenido\" placeholder=\"Apellido M. del Contacto\" pattern=\"^[A-Za-z ]+$\" onkeypress=\"letras()\" id=\"apellido_m_numcontac_obtenido\" name=\"apellido_m_numcontac_obtenido\" type=\"text\" class=\"validate\" required>\n");
      out.write("                                                                <label for=\"apellido_m\">Apellido Materno</label>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            <div class=\"input-field col s6\">\n");
      out.write("                                                                <input disabled value=\"num_obtenido\" placeholder=\"Num. Telefónico\" pattern=\"^[0-9]+$\" onkeypress=\"numerico()\" id=\"telefono_numcontac_obtenido\" name=\"telefono_numcontac_obtenido\" type=\"text\" class=\"validate\">\n");
      out.write("                                                                <label for=\"telefono\">Teléfono</label>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            <div class=\"input-field col s6\">\n");
      out.write("                                                                <input disabled value=\"correo_obtenido\" placeholder=\"E-mail\" id=\"correo_numcontac_obtenido\" onkeypress=\"email()\" pattern=\"^(([^<>()\\[\\]\\\\.,;:\\s@']+(\\.[^<>()\\[\\]\\\\.,;:\\s@']+)*)|('.+'))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$\" name=\"correo_numcontac_obtenido\" type=\"text\" class=\"validate\">\n");
      out.write("                                                                <label for=\"correo\">Correo</label>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            <div class=\"col s6\">\n");
      out.write("                                                                <button class=\"btn blue\" type=\"submit\" id=\"btn_numcontact_obtenido\" name=\"action\">Guardar<i class=\"material-icons right\">save</i>\n");
      out.write("                                                                </button>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            <div class=\"col s6  m6 l6 center-align\" style=\"text-align: center\">\n");
      out.write("                                                                <a class=\"waves-effect waves-light btn red modal-trigger\" href=\"#dardebaja_numcontact_obtenido\">Dar De Baja<i class=\"material-icons right\">delete_forever</i>  </a>\n");
      out.write("\n");
      out.write("                                                            </div>\n");
      out.write("                                                            <br><br><br><br><br><br><br><br><br><br><br>\n");
      out.write("                                                        </form>\n");
      out.write("                                                        <div id=\"dardebaja_numcontact_obtenido\" class=\"modal\">\n");
      out.write("                                                            <div class=\"modal-content\" style=\"text-align: center\">\n");
      out.write("                                                                <h4>Dar de Baja</h4>\n");
      out.write("                                                                <p>¿Está seguro de eliminar este contacto?</p>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            <div class=\"modal-footer\">\n");
      out.write("                                                                <div class=\"col s6\">\n");
      out.write("                                                                    <a href=\"\" class=\"modal-close waves-effect red waves-red btn\">Cancelar</a>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                <div class=\"col s6\">\n");
      out.write("                                                                    <form>\n");
      out.write("                                                                        <input type=\"text\" value=\"numcontact_obtenido\" style=\"display: none\">\n");
      out.write("                                                                        <button class=\"btn green\" type=\"submit\" id=\"btnbaja_numcontact_obtenido\" name=\"action\">Eliminar<i class=\"material-icons right\">check</i>\n");
      out.write("                                                                        </button>\n");
      out.write("                                                                    </form>\n");
      out.write("                                                                </div>\n");
      out.write("                                                            </div>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        <script>\n");
      out.write("                                                            function hab_numcontact_obtenido() {\n");
      out.write("                                                                if (document.getElementById('switch_numcontact_obtenido').checked)\n");
      out.write("                                                                {\n");
      out.write("                                                                    document.getElementById(\"nombre_numcontac_obtenido\").disabled = false;\n");
      out.write("                                                                    document.getElementById(\"apellido_p_numcontac_obtenido\").disabled = false;\n");
      out.write("                                                                    document.getElementById(\"apellido_m_numcontac_obtenido\").disabled = false;\n");
      out.write("                                                                    document.getElementById(\"telefono_numcontac_obtenido\").disabled = false;\n");
      out.write("                                                                    document.getElementById(\"correo_numcontac_obtenido\").disabled = false;\n");
      out.write("                                                                    document.getElementById(\"btn_numcontact_obtenido\").disabled = false;\n");
      out.write("\n");
      out.write("                                                                } else {\n");
      out.write("                                                                    document.getElementById(\"nombre_numcontac_obtenido\").disabled = true;\n");
      out.write("                                                                    document.getElementById(\"apellido_p_numcontac_obtenido\").disabled = true;\n");
      out.write("                                                                    document.getElementById(\"apellido_m_numcontac_obtenido\").disabled = true;\n");
      out.write("                                                                    document.getElementById(\"telefono_numcontac_obtenido\").disabled = true;\n");
      out.write("                                                                    document.getElementById(\"correo_numcontac_obtenido\").disabled = true;\n");
      out.write("                                                                    document.getElementById(\"btn_numcontact_obtenido\").disabled = true;\n");
      out.write("                                                                }\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                            }\n");
      out.write("                                                        </script>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("                                            </li>\n");
      out.write("                                        </ul>  \n");
      out.write("                                    </td>           \n");
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
