/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.seguridad;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.owasp.esapi.ESAPI;

/**
 *
 * @author devil
 */
@WebServlet(name = "seguridad_recuperar", urlPatterns = {"/seguridad_recuperar"})
public class seguridad_recuperar extends HttpServlet {

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
            out.println("<title>Servlet seguridad_recuperar</title>");
            out.println("<script>function presiona1(){\n" +
            "                setTimeout(function (){\n" +
            "                    window.location.replace('AngelLogIn.html');\n" +
            "                },0);\n" +
            "            }\n" +
            "            function presiona2(){\n" +
            "                setTimeout(function (){\n" +
            "                    window.history.back();\n" +
            "                },0);\n" +
            "            }</script>");            
            out.println("</head>");
            out.println("<body>");
            encriptador encripta=new encriptador();
            String uncorreo="";
            try{
                uncorreo=request.getParameter("correo");
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                out.println("<script>alert('Datos Erroneos');</script>");
                out.println("<script>presiona2();</script>");
            }
            validadCaracteres validac=new validadCaracteres();
            int validacaracteres=validac.validaRecupera(uncorreo);
            System.out.println("1");
            if(validacaracteres==0){
                System.out.println("2");
                String correo=ESAPI.encoder().encodeForHTML(uncorreo);
                String encripcorreo=encripta.encriptar(correo);
                request.setAttribute("correo", encripcorreo);
                RequestDispatcher rd = request.getRequestDispatcher("recuperar_contra");
                rd.forward(request,response);
            }
            else{
                out.println("<script>alert('Varifica los caracteres que han sido introducidos');</script>");
                out.println("<script>presiona2();</script>");
            }
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