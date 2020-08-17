/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.controlador;

import com.angel.dao.Ireporte_eventodao;
import com.angel.dao.Ireporte_mantenimientodao;
import com.angel.impdao.impreporte_evento;
import com.angel.impdao.impreporte_mantenimiento;
import com.angel.modelo.reporte_evento;
import com.angel.modelo.reporte_mantenimiento;
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
@WebServlet(name = "reporte_evento_to_mantenimiento", urlPatterns = {"/reporte_evento_to_mantenimiento"})
public class reporte_evento_to_mantenimiento extends HttpServlet {

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
            out.println("<title>Servlet reporte_evento_to_mantenimiento</title>");            
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
            int id_repor=Integer.parseInt(request.getParameter("id_repor"));
            Ireporte_mantenimientodao controla_reporte=new impreporte_mantenimiento();
            Ireporte_eventodao controla_evento=new impreporte_evento();
            reporte_evento evento=controla_evento.trae_reporte_evento(id_repor);
            reporte_mantenimiento repor=new reporte_mantenimiento(0, evento.getFecha(), 0, evento.getDescripcion(), "", "Correctivo", "Sin asignar");
            int valida=controla_reporte.registra_reporte_evento_to_mantenimiento_sin_asignar(repor,id_repor);
            if(valida==1){
                out.println("<script>alert('Enviado como reporte');</script>");
                if(tipo==2){
                    out.print("<Script>presiona1();</Script>");
                }
                else{
                    if(tipo==3){
                        out.print("<Script>presiona3();</Script>");
                    }
                }
            }
            else{
                out.println("<script>alert('No enviado');</script>");
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
