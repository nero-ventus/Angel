/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.controlador;

import com.angel.dao.Ireportedao;
import com.angel.dao.Iusuariodao;
import com.angel.extras.String_a_Date;
import com.angel.impdao.impreporte;
import com.angel.impdao.impusuario;
import com.angel.modelo.cuenta_usuario;
import com.angel.modelo.reporte;
import com.angel.modelo.usuario;
import com.angel.seguridad.encriptador;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Profesor
 */
@WebServlet(name = "registra_reporte", urlPatterns = {"/registra_reporte"})
public class registra_reporte extends HttpServlet {

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
            out.println("<title>Servlet registra_infante</title>");
            out.println("<script>\n" +
"            function presiona1(){\n" +
"                setTimeout(function (){\n" +
"                    window.location.replace('gestion_reporte.jsp');\n" +
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
            try {
                cuenta = new cuenta_usuario(correo, contra, 0, "0");
                valida1 = 1;
            } catch (Exception e) {
                out.println("<script>alert('Datos erroneos');</script>");
                out.print("<Script>presiona2();</Script>");
            }
            if (valida1 == 1) {
                usua = user1.traeusuario(cuenta);
                if (!(usua == null)) {
                    Ireportedao controla_reporte=new impreporte();
                    try{
                        String_a_Date getdata=new String_a_Date();
                        Date fecha_re=getdata.covertir(request.getParameter("fecha_r"));
                        int id_infan=Integer.parseInt(String.valueOf(datos_sesion.getAttribute("id_infante")));
                        int talla=Integer.parseInt(request.getParameter("talla"));
                        int peso=Integer.parseInt(request.getParameter("peso"));
                        double temperatura=Double.valueOf(request.getParameter("temperatura"));
                        int frecuencia_c=Integer.parseInt(request.getParameter("frecuencia_c"));
                        int color_piel=Integer.parseInt(request.getParameter("color_p"));
                        int cansancio=Integer.parseInt(request.getParameter("cansancio"));
                        int dolor_g=Integer.parseInt(request.getParameter("dolor_g"));
                        int flema=Integer.parseInt(request.getParameter("flema"));
                        int escurrimiento_n=Integer.parseInt(request.getParameter("escurrimiento_n"));
                        int dolor_ad=Integer.parseInt(request.getParameter("dolor_a"));
                        int nauseas=Integer.parseInt(request.getParameter("nausea"));
                        int vomito=Integer.parseInt(request.getParameter("votimo"));
                        int dolor_ca=Integer.parseInt(request.getParameter("dolor_c"));
                        int diarrea=Integer.parseInt(request.getParameter("diarrea"));
                        reporte repor=new reporte(0, fecha_re, id_infan, talla, peso, temperatura, frecuencia_c, color_piel, cansancio, dolor_g, flema, escurrimiento_n, dolor_ad, nauseas, vomito, dolor_ca, diarrea);
                        int valida_correcto=controla_reporte.altareporte(repor, id_infan);
                        if(valida_correcto==1){
                            out.println("<script>alert('Hecho');</script>");
                            out.print("<Script>presiona1();</Script>");
                        }
                        else{
                            out.println("<script>alert('Datos erroneos');</script>");
                            out.print("<Script>presiona2();</Script>");
                        }
                    }
                    catch(Exception ex){
                        System.out.println(ex.getMessage());
                        ex.printStackTrace();
                        out.println("<script>alert('Datos erroneos');</script>");
                        out.print("<Script>presiona2();</Script>");
                    }
                }
                else{
                    out.println("<script>alert('Inicia sesion');</script>");
                    out.print("<Script>presiona2();</Script>");
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
