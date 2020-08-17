package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.angel.modelo.cuenta_usuario;
import com.angel.impdao.impusuario;
import com.angel.modelo.usuario;
import com.angel.dao.Iusuariodao;
import com.angel.seguridad.encriptador;
import org.owasp.esapi.ESAPI;
import java.util.ArrayList;
import com.angel.modelo.sensores;
import com.angel.impdao.impsensores;
import com.angel.dao.Isensoresdao;

public final class form_005fsensores_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Angel-Gestión Infantil</title>\n");
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
      out.write("                background: url(fondous4.jpg) no-repeat center center fixed;\n");
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
      out.write("            <li class=\"blue flow-text\"><a href=\"\"><i class=\"material-icons left\">my_location</i>Ubicación</a></li>\n");
      out.write("            <li class=\"blue flow-text\"><a href=\"badges.html\"><i class=\"material-icons left\">help</i>Ayuda</a></li>\n");
      out.write("            <li class=\"blue flow-text\"><a href=\"cerrar_sesion\"><i class=\"material-icons left\">power_settings_new</i>Salir</a></li>\n");
      out.write("        </ul>\n");
      out.write("        <nav class=\"blue\" style=\"z-index: 99999\">\n");
      out.write("            <div class=\"nav-wrapper \">\n");
      out.write("                <a class=\"brand-logo flow-text center\"><i class=\"material-icons t\">child_friendly</i>Gestión Infantil</a>\n");
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
      out.write("            <li class=\"blue white-text flow-text\"><a href=\"\" class=\"white-text\"><i class=\"material-icons left white-text\">my_location</i>Localización</a></li>\n");
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
      out.write("                                    <th class=\"center flow-text\"><H5>Agrega aqui los datos de tus bebés</H5></th>\n");
      out.write("                                    <th class=\"hide-on-small-only \">\n");
      out.write("                                        <form>\n");
      out.write("                                            <div class=\"input-field\" style=\"padding: 0\">\n");
      out.write("                                                <input id=\"search\" type=\"search\" required>\n");
      out.write("                                                <label  for=\"search\"><i class=\"material-icons\">search</i></label>\n");
      out.write("                                                <i class=\"material-icons\">close</i>\n");
      out.write("                                            </div>\n");
      out.write("                                        </form>\n");
      out.write("                                    </th>\n");
      out.write("                                    \n");
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
      out.write("                                    ");

                                        Isensoresdao control_sensores=new impsensores();
                                        ArrayList<sensores> lista_sensores=control_sensores.traeSensores(correo);
                                        if(lista_sensores.size()>0){
                                            for(int i=0;i<lista_sensores.size();i++){
                                    
      out.write("\n");
      out.write("                                    \n");
      out.write("                                            <li class=\"collection-item avatar\">\n");
      out.write("                                                <i class=\"material-icons circle blue large\">child_friendly</i>\n");
      out.write("                                                <span class=\"title\">Número de bebé: ");
out.print((i+1));
      out.write("</span>\n");
      out.write("                                                <p>Sensor: ");
out.print(lista_sensores.get(i).getId_sensor());
      out.write("</p>\n");
      out.write("                                                <p>Cuarto: ");

                                                    if(lista_sensores.get(i).getId_cuarto()==1){
                                                        out.print("Dormitorio");
                                                    }
                                                    if(lista_sensores.get(i).getId_cuarto()==2){
                                                        out.print("Estudio");
                                                    }
                                                    if(lista_sensores.get(i).getId_cuarto()==3){
                                                        out.print("Baño");
                                                    }
                                                    if(lista_sensores.get(i).getId_cuarto()==4){
                                                        out.print("Cocina");
                                                    }
                                                    if(lista_sensores.get(i).getId_cuarto()==5){
                                                        out.print("Cuarto de lavado");
                                                    }
                                                    if(lista_sensores.get(i).getId_cuarto()==6){
                                                        out.print("Comedor");
                                                    }
                                                    if(lista_sensores.get(i).getId_cuarto()==7){
                                                        out.print("Sala");
                                                    }
                                                    
      out.write("</p>\n");
      out.write("                                                <p>Permiso: ");

                                                    if(lista_sensores.get(i).getId_cuarto()==1){
                                                        out.print("Permitido");
                                                    }
                                                    if(lista_sensores.get(i).getId_cuarto()==2){
                                                        out.print("Prohibido");
                                                    }
                                                    
      out.write("</p>\n");
      out.write("\n");
      out.write("                                                <a class=\" secondary-content btn modal-trigger blue\" href=\"#editarnumerodebebe_obtenido");
out.print((i+1));
      out.write("\"><i class=\"material-icons right\">edit</i>Editar</a>\n");
      out.write("                                                <!-- Modal Structure -->\n");
      out.write("                                                <div id=\"editarnumerodebebe_obtenido");
out.print((i+1));
      out.write("\" class=\"modal\" style=\"margin-top: 1em\">\n");
      out.write("                                                    <div class=\"modal-content\" style=\"text-align: center\">\n");
      out.write("                                                        <h4 class=\"center\">Bebé numbebe_obtenido:</h4>\n");
      out.write("                                                        <h5>Edita la información del sensor</h5>\n");
      out.write("                                                        <div class=\"switch col s12 m12 l12 \">\n");
      out.write("                                                            Editar:<br>\n");
      out.write("                                                            <label>\n");
      out.write("                                                                No\n");
      out.write("                                                                <input id=\"switch_numbebe_obtenido");
out.print((i+1));
      out.write("\" type=\"checkbox\" onclick=\"hab_numbebe_obtenido");
out.print((i+1));
      out.write("()\">\n");
      out.write("                                                                <span class=\"lever\"></span>\n");
      out.write("                                                                Si\n");
      out.write("                                                            </label>          \n");
      out.write("                                                        </div>\n");
      out.write("                                                        <form action=\"cambiar_infante\" id=\"form");
out.print((i+1));
      out.write("\" method=\"post\">\n");
      out.write("                                                            <div class=\"input-field hide\">\n");
      out.write("                                                                <input type=\"text\" value=\"");
out.print(lista_sensores.get(i).getId_cuarto());
      out.write("\" name=\"sensor\" required>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            <div class=\"input-field col s12 m3 l3\">\n");
      out.write("                                                                <select id=\"permiso\" name=\"permiso\" required>\n");
      out.write("                                                                    <option value=\"0\" disabled>-Selecciona si el cuarto esta permitido-</option>\n");
      out.write("                                                                    <option value=\"1\">Permitido</option>\n");
      out.write("                                                                    <option value=\"2\">Prohibido</option>\n");
      out.write("                                                                </select>\n");
      out.write("                                                                <div class=\"col s6 m3 l3\" id=\"permiso_o");
out.print((i+1));
      out.write("\">\n");
      out.write("                                                                    <br> Sexo: sexoobtenido\n");
      out.write("                                                                </div>\n");
      out.write("                                                                <script>\n");
      out.write("                                                                    function cambiapermiso");
out.print((i+1));
      out.write("(){\n");
      out.write("                                                                        document.getElementById(\"form");
out.print((i+1));
      out.write("\").elements.namedItem(\"permiso\").selectedIndex=");
out.print(lista_sensores.get(i).getEstado_permiso());
      out.write(";\n");
      out.write("                                                                        document.getElementById(\"permiso_o");
out.print((i+1));
      out.write("\").innerHTML=document.getElementById(\"form");
out.print((i+1));
      out.write("\").elements.namedItem(\"permiso\").options[");
out.print(lista_sensores.get(i).getEstado_permiso());
      out.write("].text;\n");
      out.write("                                                                    }\n");
      out.write("                                                                </script>\n");
      out.write("                                                                <script>cambiapermiso");
out.print((i+1));
      out.write("();</script>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            <div class=\"input-field col s6 m3 l3\" style=\"display: none\" id=\"sexo_disponible_numbebe_obtenido");
out.print((i+1));
      out.write("\">\n");
      out.write("                                                                <select id=\"cuarto\"  name=\"cuarto\" required>\n");
      out.write("                                                                    <option value=\"0\" selected disabled>Selecciona un cuarto</option>\n");
      out.write("                                                                    <option value=\"1\">Dormitorio</option>\n");
      out.write("                                                                    <option value=\"2\">Estudio</option>\n");
      out.write("                                                                    <option value=\"3\">Baño</option>\n");
      out.write("                                                                    <option value=\"4\">Cocina</option>\n");
      out.write("                                                                    <option value=\"5\">Cuarto de lavado</option>\n");
      out.write("                                                                    <option value=\"6\">Comedor</option>\n");
      out.write("                                                                    <option value=\"7\">Sala</option>\n");
      out.write("                                                                </select>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            <div class=\"col s6 m3 l3\" id=\"cuarto_o");
out.print((i+1));
      out.write("\">\n");
      out.write("                                                                <br> Sexo: sexoobtenido\n");
      out.write("                                                            </div>\n");
      out.write("                                                                <script>\n");
      out.write("                                                                    function cambiacuarto");
out.print((i+1));
      out.write("(){\n");
      out.write("                                                                        document.getElementById(\"form");
out.print((i+1));
      out.write("\").elements.namedItem(\"cuarto\").selectedIndex=");
out.print(lista_sensores.get(i).getId_cuarto());
      out.write(";\n");
      out.write("                                                                        document.getElementById(\"cuarto_o");
out.print((i+1));
      out.write("\").innerHTML=document.getElementById(\"form");
out.print((i+1));
      out.write("\").elements.namedItem(\"cuarto\").options[");
out.print(lista_sensores.get(i).getId_cuarto());
      out.write("].text;\n");
      out.write("                                                                    }\n");
      out.write("                                                                </script>\n");
      out.write("                                                                <script>cambiasexo");
out.print((i+1));
      out.write("();</script>\n");
      out.write("                                                        </form>\n");
      out.write("                                                            <div class=\"modal-content\" style=\"text-align: center\">\n");
      out.write("                                                                <h4>Dar de Baja</h4>\n");
      out.write("                                                                <p>¿Está seguro de eliminar este contacto?</p>\n");
      out.write("                                                            </div>\n");
      out.write("                                                            <div class=\"modal-footer\">\n");
      out.write("                                                                <div class=\"col s6\">\n");
      out.write("                                                                    <a href=\"\" class=\"modal-close waves-effect red waves-red btn\">Cancelar</a>\n");
      out.write("                                                                </div>\n");
      out.write("                                                                <div class=\"col s6\">\n");
      out.write("                                                                    <form method=\"post\" action=\"elimina_infante\">\n");
      out.write("                                                                        <div class=\"hide\">\n");
      out.write("                                                                            <input type=\"text\" value=\"");
out.print(lista_sensores.get(i).getId_sensor());
      out.write("\"name=\"infan\">\n");
      out.write("                                                                        </div>\n");
      out.write("                                                                        <button class=\"btn green\" type=\"submit\" id=\"btnbaja_numbebe_obtenido\" name=\"action\">Eliminar<i class=\"material-icons right\">check</i>\n");
      out.write("                                                                        </button>\n");
      out.write("                                                                    </form>\n");
      out.write("                                                                </div>\n");
      out.write("                                                            </div>\n");
      out.write("                                                        </div>\n");
      out.write("                                                        <script>\n");
      out.write("                                                            function hab_numbebe_obtenido");
out.print((i+1));
      out.write("() {\n");
      out.write("                                                                if (document.getElementById('switch_numbebe_obtenido");
out.print((i+1));
      out.write("').checked)\n");
      out.write("                                                                {\n");
      out.write("                                                                    document.getElementById(\"form");
out.print((i+1));
      out.write("\").elements.namedItem(\"sensor\").disabled = false;\n");
      out.write("                                                                    document.getElementById(\"form");
out.print((i+1));
      out.write("\").elements.namedItem(\"permiso\").disabled = false;\n");
      out.write("                                                                    document.getElementById(\"permiso_o");
out.print((i+1));
      out.write("\").removeAttribute(\"style\");\n");
      out.write("                                                                    document.getElementById(\"cuarto_o");
out.print((i+1));
      out.write("\").removeAttribute(\"style\");\n");
      out.write("                                                                    document.getElementById(\"cuarto");
out.print((i+1));
      out.write("\").setAttribute(\"style\", \"display: none\");\n");
      out.write("                                                                    document.getElementById(\"permiso");
out.print((i+1));
      out.write("\").setAttribute(\"style\", \"display: none\");\n");
      out.write("                                                                } else {\n");
      out.write("                                                                    document.getElementById(\"form");
out.print((i+1));
      out.write("\").elements.namedItem(\"sensor\").disabled = true;\n");
      out.write("                                                                    document.getElementById(\"form");
out.print((i+1));
      out.write("\").elements.namedItem(\"permiso\").disabled = true;\n");
      out.write("                                                                    document.getElementById(\"cuarto_o");
out.print((i+1));
      out.write("\").setAttribute(\"style\", \"display: none\");\n");
      out.write("                                                                    document.getElementById(\"cuarto");
out.print((i+1));
      out.write("\").removeAttribute(\"style\");\n");
      out.write("                                                                    document.getElementById(\"permiso_o");
out.print((i+1));
      out.write("\").setAttribute(\"style\", \"display: none\");\n");
      out.write("                                                                    document.getElementById(\"permiso");
out.print((i+1));
      out.write("\").removeAttribute(\"style\");\n");
      out.write("                                                                }\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                            }\n");
      out.write("                                                        </script>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("\n");
      out.write("                                            </li>\n");
      out.write("                                        \n");
      out.write("                                    ");

                                            }
                                        }
                                        else{
                                        
      out.write("\n");
      out.write("                                        <ul class=\"text-accent-1\">\n");
      out.write("                                            <li class=\"text-accent-1\">No hay registros</li>\n");
      out.write("                                        </ul>\n");
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
