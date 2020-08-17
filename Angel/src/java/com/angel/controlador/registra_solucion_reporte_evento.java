/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.controlador;

import com.angel.dao.Iingenierodao;
import com.angel.impdao.impingeniero;
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
 * @author devil
 */
@WebServlet(name = "registra_solucion_reporte_evento", urlPatterns = {"/registra_solucion_reporte_evento"})
public class registra_solucion_reporte_evento extends HttpServlet {

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
            out.println("<title>Servlet registra_solucion_reporte_evento</title>");
            out.println("<script>\n" +
"            function presiona1(){\n" +
"                setTimeout(function (){\n" +
"                    window.location.replace('ver_reportes_ingeniero.jsp');\n" +
"                },0);\n" +
"            }\n" +
"            function presiona2(){\n" +
"                setTimeout(function (){\n" +
"                    window.history.back();\n" +
"                },0);\n" +
"            }\n" +
"            function presiona3(){\n" +
"                setTimeout(function (){\n" +
"                    window.location.replace('maneja_reporte_evento.jsp');\n" +
"                },0);\n" +
"            }\n" +   
"        </script>");
            out.println("</head>");
            out.println("<body>");
            int tipo=0;
            encriptador descripta = new encriptador();
            HttpSession datos_sesion = request.getSession();
            try{
                tipo=Integer.parseInt(descripta.desencriptar((String)(datos_sesion.getAttribute("tipo"))));
                System.out.println(tipo);
            }
            catch(Exception e){
                tipo=0;
                e.printStackTrace();
            }
            Iingenierodao controla_ingeniero=new impingeniero();
            String solucion=request.getParameter("solucion");
            int id_repor=Integer.parseInt(request.getParameter("id_repor"));
            int valida=controla_ingeniero.subir_solucion(solucion, id_repor);
            if(valida==1){
                if(tipo==2){
                    out.println("<script>alert('Registro Hecho');</script>");
                    out.print("<Script>presiona1();</Script>");
                }
                else{
                    if(tipo==3){
                        out.println("<script>alert('Registro Hecho');</script>");
                        out.print("<Script>presiona3();</Script>");
                    }
                }
            }
            else{
                out.println("<script>alert('Datos erroneos');</script>");
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
