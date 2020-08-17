/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.controlador;

import com.angel.dao.Icodigo_ventadao;
import com.angel.extras.generador_codigos;
import com.angel.impdao.impcodigo_venta;
import com.angel.modelo.codigo_venta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author devil
 */
@WebServlet(name = "generar_codigo", urlPatterns = {"/generar_codigo"})
public class generar_codigo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>\n"
                    + "    <head>\n"
                    + "        <title>Angel-Generar Código</title>\n"
                    + "        <meta charset=\"UTF-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                    + "        <link rel=\"icon\" type=\"image/png\" href=\"imagenes/icono.png\" />\n"
                    + "\n"
                    + "        <link rel=\"shortcut icon\" href=\"favicon.ico\"> \n"
                    + "        <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\n"
                    + "        <!--Import materialize.css-->\n"
                    + "        <link rel=\"stylesheet\" href=\"css/materialize.min.css\" media=\"screen,projection\">\n"
                    + "        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/css/materialize.min.css\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n"
                    + "        <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-3.2.1.js\"></script>\n"
                    + "        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/js/materialize.min.js\"></script>\n"
                    + "\n"
                    + "        <style>\n"
                    + "            body{\n"
                    + "                background: url(imagenes/wallcode.jpg) no-repeat center center fixed;\n"
                    + "                -webkit-background-size: cover;\n"
                    + "                -moz-background-size: cover;\n"
                    + "                -o-background-size: cover;      \n"
                    + "                background-size: cover;\n"
                    + "                min-height: 100vh;\n"
                    + "                display: flex;\n"
                    + "                flex-direction: column;\n"
                    + "            }   \n"
                    + "            main {\n"
                    + "                flex: 1 0 auto;\n"
                    + "            }\n"
                    + "\n"
                    + "            footer {\n"
                    + "                background-color: black;\n"
                    + "                position: absolute;\n"
                    + "                bottom: 0;\n"
                    + "                width: 100%;\n"
                    + "\n"
                    + "            } .input-field label {\n"
                    + "                color: black!important;\n"
                    + "            }\n"
                    + "            /* label focus color */\n"
                    + "            .input-field input[type=email]:focus + label {\n"
                    + "                color: black! important;\n"
                    + "            }\n"
                    + "            /* label underline focus color */\n"
                    + "            .input-field input[type=email]:focus {\n"
                    + "                border-bottom: 1px solid #0d47a1! important;\n"
                    + "                box-shadow: 0 1px 0 0 #0d47a1 ! important;\n"
                    + "            }\n"
                    + "\n"
                    + "            .input-field input[type=email].valid {\n"
                    + "                border-bottom: 1px solid #76ff03!important;\n"
                    + "                box-shadow: 0 1px 0 0 #76ff03!important;\n"
                    + "            }\n"
                    + "\n"
                    + "            .input-field input[type=email].invalid {\n"
                    + "                border-bottom: 1px solid red !important;\n"
                    + "                box-shadow: 0 1px 0 0 red!important;\n"
                    + "            }\n"
                    + "            /* icon prefix focus color */\n"
                    + "            .input-field .prefix.active {\n"
                    + "                color: #000;\n"
                    + "            }\n"
                    + "        </style>\n"
                    + "        <script>\n"
                    + "\n"
                    + "            function email() {\n"
                    + "                var letras = \"@._-1234567890ABCDEFGHIKKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz\";\n"
                    + "                var x = event.keyCode;\n"
                    + "                var letra = String.fromCharCode(x);\n"
                    + "                var n = letras.indexOf(letra);\n"
                    + "                if (n === -1) {\n"
                    + "                    event.returnValue = false;\n"
                    + "                }\n"
                    + "            }\n"
                    + "        </script>\n"
                    + "    </head>\n"
                    + "\n"
                    + "\n"
                    + "    <body>");
            int valida = 0;
            codigo_venta modelo = null;
            while (valida == 0) {
                generador_codigos genera = new generador_codigos();
                Icodigo_ventadao controla = new impcodigo_venta();
                modelo = new codigo_venta(genera.obtenerCodigo(), 2);
                valida = controla.altacodigo_venta(modelo);
            }
            out.print("  <script type=\"text/javascript\" src=\"https://code.jquery.com/jquery-3.2.1.min.js\"></script>\n"
                    + "        <script type=\"text/javascript\" src=\"js/materialize.min.js\"></script>\n"
                    + "        <script type=\"text/javascript\" src=\"js/script.js\"></script>\n"
                    + "        <script>\n"
                    + "            $(document).ready(function () {\n"
                    + "                $('.sidenav').sidenav();\n"
                    + "            });\n"
                    + "        </script>\n"
                    + "\n"
                    + "\n"
                    + "        <nav>\n"
                    + "            <div class=\"nav-wrapper grey darken-1\">\n"
                    + "                <a  class=\"brand-logo center flow-text\"><i class=\"material-icons\">cloud</i>\"Angel\"</a>\n"
                    + "                <a data-target=\"mobile-demo\" class=\"sidenav-trigger\" href=\"administrador_home.jsp\"><i class=\"material-icons left white-text\">arrow_back</i>Regresar</a>\n"
                    + "                <ul id=\"nav-mobile\" class=\"left hide-on-med-and-down\">\n"
                    + "                    <li><a href=\"administrador_home.jsp\"><i class=\"material-icons left\">arrow_back</i>Regresar al inicio</a></li>                </ul>\n"
                    + "            </div>\n"
                    + "        </nav>\n"
                    + "\n"
                    + "        <div class=\"container\">\n"
                    + "            <div class=\"col s12 white\" style=\"text-align: center; margin-top: 7em\">\n"
                    + "                <h3>¡Aquí está tu código!</h3>\n"
                    + "                <h5>El código se generó de manera correcta, por lo que puede ser usado.</h5>\n"
                    + "                ¡Sin complicaciones!\n"
                    + "                <br>\n"
                    + " <h4><i class=\"material-icons large\">vpn_key</i></h4>" 
                    + "<h4>"+ modelo.getCodigo()+"</h4>\n"
                    + "                <br><br>\n"
                    + "            </div>\n"
                    + "        </div>                \n"
                    + "    </div>                           \n"
                    + "\n"
                    + "\n"
                    + "    <footer class=\"page-footer grey darken-1\">\n"
                    + "        <div class=\"container\" style=\"text-align: center\">\n"
                    + "            <h5>© 2018 Trinity Corps</h5>\n"
                    + "\n"
                    + "        </div>\n"
                    + "\n"
                    + "    </footer>\n"
                    + "");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
