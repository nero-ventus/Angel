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
@WebServlet(name = "registra_todos", urlPatterns = {"/registra_todos"})
public class registra_todos extends HttpServlet {

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
            out.println("<title>Servlet registra_todos</title>");
            out.println("<script>function presiona1(){\n" +
"                setTimeout(function (){\n" +
"                    window.location.replace('administrador_home_todos.jsp');\n" +
"                },0);\n" +
"            }\n" +
"            function presiona2(){\n" +
"                setTimeout(function (){\n" +
"                    window.history.back();\n" +
"                },0);\n" +
"            }</script>");
            out.println("</head>");
            out.println("<body>");
            int tipo_admin=Integer.parseInt(request.getParameter("admi"));
            String correo=ESAPI.encoder().encodeForHTML(request.getParameter("correo"));
            String contra=ESAPI.encoder().encodeForHTML(request.getParameter("contra"));
            String nombre=ESAPI.encoder().encodeForHTML(request.getParameter("nombre"));
            String apellidos=ESAPI.encoder().encodeForHTML(request.getParameter("apellidos"));
            if(tipo_admin==1){
                Ioperadordao controla_operador=new impoperador();
                operador opera=new operador(correo, contra, nombre, apellidos);
                int valida=controla_operador.altaoperador(opera);
                if(valida==1){
                    encriptador encripta=new encriptador();
                    HttpSession datos_sesion=request.getSession();
                    datos_sesion.setAttribute("correo", encripta.encriptar(correo));
                    datos_sesion.setAttribute("contra", encripta.encriptar(contra));
                    datos_sesion.setAttribute("tipo", encripta.encriptar("1"));
                    out.println("<script>alert('Registro Hecho');</script>");
                    out.println("<script>presiona1();</script>");
                }
                else{
                    out.println("<script>alert('Error en el registro');</script>");
                    out.println("<script>presiona2();</script>");
                }
            }
            else{
                if(tipo_admin==3){
                    Igerentedao controla_gerente=new impgerente();
                    ingeniero inge=new ingeniero(correo, contra, nombre, apellidos);
                    int valida=controla_gerente.altagerente(inge);
                    if(valida==1){
                        encriptador encripta=new encriptador();
                        HttpSession datos_sesion=request.getSession();
                        datos_sesion.setAttribute("correo", encripta.encriptar(correo));
                        datos_sesion.setAttribute("contra", encripta.encriptar(contra));
                        datos_sesion.setAttribute("tipo", encripta.encriptar("3"));
                        out.println("<script>alert('Registro Hecho');</script>");
                        out.println("<script>presiona1();</script>");
                    }
                    else{
                        out.println("<script>alert('Error en el registro');</script>");
                        out.println("<script>presiona2();</script>");
                    }
                }
                else{
                    if(tipo_admin==2){
                        Iingenierodao controla_ingeniero=new impingeniero();
                        ingeniero inge=new ingeniero(correo, contra, nombre, apellidos);
                        int valida=controla_ingeniero.altaingeniero(inge);
                        if(valida==1){
                            encriptador encripta=new encriptador();
                            HttpSession datos_sesion=request.getSession();
                            datos_sesion.setAttribute("correo", encripta.encriptar(correo));
                            datos_sesion.setAttribute("contra", encripta.encriptar(contra));
                            datos_sesion.setAttribute("tipo", encripta.encriptar("2"));
                            out.println("<script>alert('Registro Hecho');</script>");
                            out.println("<script>presiona1();</script>");
                        }
                        else{
                            out.println("<script>alert('Error en el registro');</script>");
                            out.println("<script>presiona2();</script>");
                        }
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
