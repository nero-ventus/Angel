/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.controlador;

import com.angel.dao.Icuenta_usuario;
import com.angel.impdao.impcuenta_usuario;
import com.angel.modelo.cuenta_usuario;
import com.angel.seguridad.encriptador;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
@WebServlet(name = "recuperar_contra", urlPatterns = {"/recuperar_contra"})
public class recuperar_contra extends HttpServlet {

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
            out.println("<title>Servlet recuperar_contra</title>");
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
            try{
                encriptador encripta=new encriptador();
                Icuenta_usuario controla=new impcuenta_usuario();
                cuenta_usuario cuenta=null;
                
                String correo=(String)(request.getAttribute("correo"));
                cuenta=controla.traecuenta_usuario(encripta.desencriptar(correo));
                if(!(cuenta==null)){
                    String from="trynitycorpsbussines@gmail.com";
                    String contra="trinitycorps18";
                    String to=ESAPI.encoder().decodeForHTML(cuenta.getCorreo());
                    String mensaje="Su contraseña es: "+ESAPI.encoder().decodeForHTML(cuenta.getContra());
                    String host="smtp.gmail.com";
                    String subject="Recuperacion de contraseña";
                    boolean sessionDebug=false;

                    Properties proper=System.getProperties();
                    proper.put("mail.smtp.starttls.enable", "true");
                    proper.put("mail.smtp.host", host);
                    proper.put("mail.smtp.port", "587");
                    proper.put("mail.smtp.auth", "true");
                    proper.put("mail.smtp.starttls.required", "true");

                    java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                    Session sesion=Session.getDefaultInstance(proper,null);
                    sesion.setDebug(sessionDebug);
                    Message msj=new MimeMessage(sesion);
                    msj.setFrom(new InternetAddress(from));
                    InternetAddress[] direccion={new InternetAddress(to)};
                    msj.setRecipients(Message.RecipientType.TO, direccion);
                    msj.setSubject(subject);
                    msj.setSentDate(new Date());
                    msj.setText(mensaje);

                    Transport transporte=sesion.getTransport("smtp");
                    transporte.connect(host,from,contra);
                    transporte.sendMessage(msj, msj.getAllRecipients());
                    transporte.close();
                    out.println("<script>alert('Correo enviado');</script>");
                    out.println("<script>presiona1();</script>");
                }
                else{
                    out.println("<script>alert('El correo no esta registrado, verificalo');</script>");
                    out.println("<script>presiona2();</script>");
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                out.println("<script>alert('Datos Erroneos');</script>");
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
