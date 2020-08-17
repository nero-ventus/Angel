/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.controlador;

import com.angel.dao.Ireporte_mantenimientodao;
import com.angel.extras.String_a_Date;
import com.angel.impdao.impreporte_mantenimiento;
import com.angel.modelo.reporte_mantenimiento;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.owasp.esapi.ESAPI;

/**
 *
 * @author Jesus Abraham
 */
@WebServlet(name = "registra_reporte_mantenimiento", urlPatterns = {"/registra_reporte_mantenimiento"})
public class registra_reporte_mantenimiento extends HttpServlet {

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
            out.println("<title>Subiendo...</title>");
            out.println("<script>\n"
                    + "            function presiona1(){\n"
                    + "                setTimeout(function (){\n"
                    + "                    window.history.back();\n"
                    + "                },0);\n"
                    + "            }\n"
                    + "            function presiona2(){\n"
                    + "                setTimeout(function (){\n"
                    + "                    window.history.back();\n"
                    + "                },0);\n"
                    + "            }\n"
                    + "        </script>");
            out.println("</head>");
            out.println("<body>");
            Ireporte_mantenimientodao controla_reportes=new impreporte_mantenimiento();
            String_a_Date getdata=new String_a_Date();
            Date fecha_re=getdata.covertir(request.getParameter("fecha_r"));
            String descrip=request.getParameter("descripcion");
            String tipo = request.getParameter("tipo");
            String correo_geren=ESAPI.encoder().encodeForHTML(request.getParameter("correo_geren"));
            reporte_mantenimiento repor=new reporte_mantenimiento(0, fecha_re, 0, descrip, "", tipo, correo_geren);
            int valida=controla_reportes.altareporte_mantenimiento(repor);
            if(valida==1){
                out.println("<script>alert('Hecho');</script>");
                out.print("<Script>presiona1();</Script>");
            }
            else{
                out.println("<script>alert('No se registró el reporte');</script>");
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