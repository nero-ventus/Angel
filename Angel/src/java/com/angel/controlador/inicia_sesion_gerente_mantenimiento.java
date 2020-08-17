/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.controlador;

import com.angel.dao.Igerente_mantenimientodao;
import com.angel.impdao.impgerente_mantenimiento;
import com.angel.modelo.gerente_mantenimiento;
import com.angel.seguridad.encriptador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.owasp.esapi.ESAPI;

/**
 *
 * @author Jesus Abraham
 */
@WebServlet(name = "inicia_sesion_gerente_mantenimiento", urlPatterns = {"/inicia_sesion_gerente_mantenimiento"})
public class inicia_sesion_gerente_mantenimiento extends HttpServlet {

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
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Iniciando sesión...</title>");            
            out.println("</head>");
             out.println("<script>\n" +
"            function presiona1(){\n" +
"                setTimeout(function (){\n" +
"                    window.location.replace('administrador_home_gerente_mantenimiento.jsp');\n" +
"                },0);\n" +
"            }\n" +
"            function presiona2(){\n" +
"                setTimeout(function (){\n" +
"                    window.history.back();\n" +
"                },0);\n" +
"            }\n" +
"        </script>");
            out.println("<body>");
            Igerente_mantenimientodao controla_administrador=new impgerente_mantenimiento();
            String correo=ESAPI.encoder().encodeForHTML(request.getParameter("correo"));
            String contra=ESAPI.encoder().encodeForHTML(request.getParameter("contra"));
            gerente_mantenimiento geren=controla_administrador.traegerente_mantenimiento(new gerente_mantenimiento(correo, contra, "", ""));
            if(!(geren==null)){
                encriptador encripta=new encriptador();
                out.println("<script>alert('Sesion Iniciada');</script>");
                HttpSession datos_sesion=request.getSession();
                datos_sesion.setAttribute("correo", encripta.encriptar(correo));
                datos_sesion.setAttribute("contra", encripta.encriptar(contra));
                out.print("<Script>presiona1();</Script>");
            }
            else{
                out.println("<script>alert('Datos erroneos');</script>");
                out.print("<Script>presiona2();</Script>");
            }            out.println("</body>");
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
