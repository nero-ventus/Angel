/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.controlador;

import com.angel.dao.Iinfantedao;
import com.angel.dao.Iusuariodao;
import com.angel.impdao.impinfante;
import com.angel.impdao.impusuario;
import com.angel.modelo.cuenta_usuario;
import com.angel.modelo.infante;
import com.angel.modelo.usuario;
import com.angel.seguridad.encriptador;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "elimina_infante", urlPatterns = {"/elimina_infante"})
public class elimina_infante extends HttpServlet {

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
            out.println("<title>Servlet elimina_infante</title>");
            out.println("<script>\n" +
"            function presiona1(){\n" +
"                setTimeout(function (){\n" +
"                    window.location.replace('AngelGestionInfantil.jsp');\n" +
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
            HttpSession datos_sesion = request.getSession();
            String correo, contra;
            encriptador descripta = new encriptador();
            correo = descripta.desencriptar((String) (datos_sesion.getAttribute("correo")));
            contra = descripta.desencriptar((String) (datos_sesion.getAttribute("contra")));
            int valida1 = 0;
            Iusuariodao user1 = new impusuario();
            usuario usua = null;
            cuenta_usuario cuenta = null;
            infante infan=null;
            Iinfantedao controla_infan=new impinfante();
            int id=0;
            try {
                cuenta = new cuenta_usuario(correo, contra, 0, "0");
                id=Integer.parseInt(request.getParameter("infan"));
                valida1 = 1;
            } catch (Exception e) {
                out.println("<script>alert('Datos erroneos');</script>");
                out.print("<Script>presiona2();</Script>");
            }
            if (valida1 == 1) {
                usua = user1.traeusuario(cuenta);
                infan=controla_infan.traeinfante(id, correo);
                if (!(usua == null)) {
                    if(!(infan == null)){
                        try{
                            int validador=controla_infan.borrainfante(id);
                            if(validador==1){
                                out.println("<script>alert('Infante Borrado');</script>");
                                out.print("<Script>presiona1();</Script>");
                            }
                            else{
                                out.println("<script>alert('Error, intentelo de nuevo');</script>");
                                out.print("<Script>presiona2();</Script>");
                            }
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                            out.println("<script>alert('Error, intentelo de nuevo');</script>");
                            out.print("<Script>presiona2();</Script>");
                        }
                    }
                    else{
                        out.println("<script>alert('Error, intentelo de nuevo');</script>");
                        out.print("<Script>presiona2();</Script>");
                    }
                }
                else{
                    out.println("<script>alert('Error, intentelo de nuevo');</script>");
                    out.print("<Script>presiona2();</Script>");
                }
            }
            else{
                out.println("<script>alert('Error, intentelo de nuevo');</script>");
                out.print("<Script>presiona2();</Script>");
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