/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.controlador;

import com.angel.dao.Igerentedao;
import com.angel.dao.Iingenierodao;
import com.angel.dao.Ioperadordao;
import com.angel.impdao.impgerente;
import com.angel.impdao.impingeniero;
import com.angel.impdao.impoperador;
import com.angel.modelo.ingeniero;
import com.angel.modelo.operador;
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
 * @author devil
 */
@WebServlet(name = "inicia_sesion_todos", urlPatterns = {"/inicia_sesion_todos"})
public class inicia_sesion_todos extends HttpServlet {

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
            out.println("<title>Servlet inicia_sesion_operador</title>");            
            out.println("<script>\n" +
"            function presiona1(){\n" +
"                setTimeout(function (){\n" +
"                    window.location.replace('administrador_home_todos.jsp');\n" +
"                },0);\n" +
"            }\n" +
"            function presiona2(){\n" +
"                setTimeout(function (){\n" +
"                    window.history.back();\n" +
"                },0);\n" +
"            }\n" +
"        </script>");
            out.println("</head>");
            out.println("<body>");
            Ioperadordao controla_administrador=new impoperador();
            String correo=ESAPI.encoder().encodeForHTML(request.getParameter("correo"));
            String contra=ESAPI.encoder().encodeForHTML(request.getParameter("contra"));
            operador opera=controla_administrador.traeoperador(new operador(correo, contra, "", ""));
            if(!(opera==null)){
                encriptador encripta=new encriptador();
                out.println("<script>alert('Sesion Iniciada');</script>");
                HttpSession datos_sesion=request.getSession();
                datos_sesion.setAttribute("correo", encripta.encriptar(correo));
                datos_sesion.setAttribute("contra", encripta.encriptar(contra));
                datos_sesion.setAttribute("tipo", encripta.encriptar("1"));
                out.print("<Script>presiona1();</Script>");
            }
            else{
                Igerentedao controla_gerente=new impgerente();
                ingeniero inge=controla_gerente.traegerente(new ingeniero(correo, contra, "", ""));
                if(!(inge==null)){
                    encriptador encripta=new encriptador();
                    out.println("<script>alert('Sesion Iniciada');</script>");
                    HttpSession datos_sesion=request.getSession();
                    datos_sesion.setAttribute("correo", encripta.encriptar(correo));
                    datos_sesion.setAttribute("contra", encripta.encriptar(contra));
                    out.print("<Script>presiona1();</Script>");
                    datos_sesion.setAttribute("tipo", encripta.encriptar("3"));
                }
                else{
                    Iingenierodao controla_ingeniero=new impingeniero();
                    ingeniero inge2=controla_ingeniero.traeingeniero(new ingeniero(correo, contra, "", ""));
                    if(!(inge2==null)){
                        encriptador encripta=new encriptador();
                        out.println("<script>alert('Sesion Iniciada');</script>");
                        HttpSession datos_sesion=request.getSession();
                        datos_sesion.setAttribute("correo", encripta.encriptar(correo));
                        datos_sesion.setAttribute("contra", encripta.encriptar(contra));
                        out.print("<Script>presiona1();</Script>");
                        datos_sesion.setAttribute("tipo", encripta.encriptar("2"));
                    }
                    else{
                        out.println("<script>alert('Datos Incorrectos');</script>");
                        out.print("<Script>presiona2();</Script>");
                    }
                }
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
