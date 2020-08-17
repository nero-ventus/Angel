/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.controlador;

import com.angel.dao.Iconfig_linternadao;
import com.angel.dao.Inotificaciondao;
import com.angel.dao.Iusuariodao;
import com.angel.impdao.impconfig_linterna;
import com.angel.impdao.impnotificacion;
import com.angel.impdao.impusuario;
import com.angel.modelo.config_linterna;
import com.angel.modelo.cuenta_usuario;
import com.angel.modelo.notificacion;
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
 * @author devil
 */
@WebServlet(name = "actualiza_configuracion_li", urlPatterns = {"/actualiza_configuracion_li"})
public class actualiza_configuracion_li extends HttpServlet {

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
            out.println("<title>Servlet actualiza_configuracion_li</title>");            
            out.println("</head>");
            out.println("<script>\n" +
"            function presiona1(){\n" +
"                setTimeout(function (){\n" +
"                    window.location.replace('AngelLocalCasa.jsp');\n" +
"                },0);\n" +
"            }\n" +
"            function presiona2(){\n" +
"                setTimeout(function (){\n" +
"                    window.history.back();\n" +
"                },0);\n" +
"            }\n" +
"        </script>");
            out.println("<body>");
            HttpSession datos_sesion = request.getSession();
            String correo, contra;
            encriptador descripta = new encriptador();
            correo = descripta.desencriptar((String) (datos_sesion.getAttribute("correo")));
            contra = descripta.desencriptar((String) (datos_sesion.getAttribute("contra")));
            int valida1 = 0,id=0;
            Iusuariodao user = new impusuario();
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
                usua = user.traeusuario(cuenta);
                if (!(usua == null)) {
                    notificacion noti=null;
                    config_linterna config_li=null;
                    try{
                        int volumen=Integer.parseInt(request.getParameter("volumen")),estado_servicio=0;
                        String tono=request.getParameter("tono");
                        try{
                            estado_servicio=Integer.parseInt(request.getParameter("estado_servicio"));
                        }
                        catch(Exception ee){
                            System.out.println(ee.getMessage());
                            estado_servicio=2;
                        }
                        if(-1<volumen && volumen<11){
                            noti=new notificacion(0, volumen, tono, 0);
                            config_li=new config_linterna(0, estado_servicio, 0, 0);
                            Iconfig_linternadao controla_config=new impconfig_linterna();
                            int validac=controla_config.actualizaconfig_linterna(config_li, correo);
                            if(validac==1){
                                Inotificaciondao controla_noti=new impnotificacion();
                                int validan=controla_noti.actualizanotificacion(noti, correo);
                                if(validan==1){
                                    out.println("<script>alert('Cambios Guadados');</script>");
                                    out.print("<Script>presiona1();</Script>");
                                }
                                else{
                                    out.println("<script>alert('Cambios no guadados');</script>");
                                    out.print("<Script>presiona2();</Script>");
                                }
                            }
                            else{
                                out.println("<script>alert('Cambios no guadados');</script>");
                                out.print("<Script>presiona2();</Script>");
                            }
                        }
                        else{
                            out.println("<script>alert('Cambios no guadados');</script>");
                            out.print("<Script>presiona2();</Script>");
                        }
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                        out.println("<script>alert('Cambios no guadados');</script>");
                        out.print("<Script>presiona2();</Script>");
                    }
                }
                else{
                    out.println("<script>alert('Inicia Sesion primero');</script>");
                    out.print("<Script>presiona2();</Script>");
                }
            }
            else{
                out.println("<script>alert('Inicia Sesion primero');</script>");
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
