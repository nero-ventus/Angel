/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.controlador;

import com.angel.dao.Iinfantedao;
import com.angel.dao.Iusuariodao;
import com.angel.extras.String_a_Date;
import com.angel.impdao.impinfante;
import com.angel.impdao.impusuario;
import com.angel.modelo.cuenta_usuario;
import com.angel.modelo.infante;
import com.angel.modelo.usuario;
import com.angel.seguridad.encriptador;
import com.angel.seguridad.validadCaracteres;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
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
@WebServlet(name = "cambiar_infante", urlPatterns = {"/cambiar_infante"})
public class cambiar_infante extends HttpServlet {

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
            out.println("<title>Servlet cambiar_infante</title>");            
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
            String correo, contra,idS="";
            encriptador descripta = new encriptador();
            correo = descripta.desencriptar((String) (datos_sesion.getAttribute("correo")));
            contra = descripta.desencriptar((String) (datos_sesion.getAttribute("contra")));
            int valida1 = 0,id=0;
            Iusuariodao user = new impusuario();
            usuario usua = null;
            cuenta_usuario cuenta = null;
            infante infan=null;
            try {
                idS=request.getParameter("infan");
                id=Integer.parseInt(idS);
                cuenta = new cuenta_usuario(correo, contra, 0, "0");
                valida1 = 1;
            } catch (Exception e) {
                out.println("<script>alert('Datos erroneos');</script>");
                out.print("<Script>presiona2();</Script>");
            }

            if (valida1 == 1) {
                usua = user.traeusuario(cuenta);
                if (!(usua == null)) {
                    Iinfantedao controla=new impinfante();
                    infan=controla.traeinfante(id, correo);
                    if(!(infan == null)){
                        String unnombre,unapellido_p,unapellido_m,id_dispositivo;
                        Date fecha_nu;
                        int peso,altura,sexo;
                        ArrayList afecciones=new ArrayList();
                        encriptador encripta=new encriptador();
                        infan=null;
                        HttpSession sesion=request.getSession();
                        String_a_Date getfecha=new String_a_Date();
                        try{
                            unnombre=request.getParameter("nombre");
                            unapellido_p=request.getParameter("apellido_p");
                            unapellido_m=request.getParameter("apellido_m");
                            id_dispositivo=request.getParameter("dispositivo");
                            correo=encripta.desencriptar((String)(sesion.getAttribute("correo")));
                            peso=Integer.parseInt(request.getParameter("peso"));
                            altura=Integer.parseInt(request.getParameter("altura"));
                            sexo=Integer.parseInt(request.getParameter("sexo"));
                            fecha_nu=getfecha.covertir(request.getParameter("fecha_n"));
                            int i=0;
                            try{
                                if(Integer.parseInt(request.getParameter("a1"))==1){
                                    afecciones.add(1);
                                }
                            }
                            catch(Exception ee){
                                System.out.println(ee.getMessage());
                            }
                            try{
                                if(Integer.parseInt(request.getParameter("a2"))==2){
                                    afecciones.add(2);
                                }
                            }
                            catch(Exception ee){
                                System.out.println(ee.getMessage());
                            }
                            try{
                                if(Integer.parseInt(request.getParameter("a3"))==3){
                                    afecciones.add(3);
                                }
                            }
                            catch(Exception ee){
                                System.out.println(ee.getMessage());
                            }
                            try{
                                if(Integer.parseInt(request.getParameter("a4"))==4){
                                    afecciones.add(4);
                                }
                            }
                            catch(Exception ee){
                                System.out.println(ee.getMessage());
                            }
                            try{
                                if(Integer.parseInt(request.getParameter("a5"))==5){
                                    afecciones.add(5);
                                }
                            }
                            catch(Exception ee){
                                System.out.println(ee.getMessage());
                            }
                            try{
                                if(Integer.parseInt(request.getParameter("a6"))==6){
                                    afecciones.add(6);
                                }
                            }
                            catch(Exception ee){
                                System.out.println(ee.getMessage());
                            }
                            try{
                                if(Integer.parseInt(request.getParameter("a7"))==7){
                                    afecciones.add(7);
                                }
                            }
                            catch(Exception ee){
                                System.out.println(ee.getMessage());
                            }
                            try{
                                if(Integer.parseInt(request.getParameter("a8"))==8){
                                    afecciones.add(8);
                                }
                            }
                            catch(Exception ee){
                                System.out.println(ee.getMessage());
                            }
                            infan=new infante(id, unnombre, unapellido_p, unapellido_m, peso, altura, sexo, fecha_nu);
                            validadCaracteres valida=new validadCaracteres();
                            int validado=valida.validaRegistraInfante(infan);
                            if(validado==0){
                                String nombre=ESAPI.encoder().encodeForHTML(unnombre);
                                String apellido_p=ESAPI.encoder().encodeForHTML(unapellido_p);
                                String apellido_m=ESAPI.encoder().encodeForHTML(unapellido_m);
                                infan=new infante(id, nombre, apellido_p, apellido_m, peso, altura, sexo, fecha_nu);
                                int validado2=controla.actualizainfante(infan, id_dispositivo, afecciones);
                                if(validado2==1){
                                    out.println("<script>alert('Infante Actualizado');</script>");
                                    out.print("<Script>presiona1();</Script>");
                                }
                                else{
                                    out.println("<script>alert('Datos erroneos en base');</script>");
                                    out.print("<Script>presiona2();</Script>");
                                }
                            }
                            else{
                                out.println("<script>alert('Datos erroneos en metidos');</script>");
                                out.print("<Script>presiona2();</Script>");
                            }
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                            out.println("<script>alert('Datos erroneos en recuperar');</script>");
                            out.print("<Script>presiona2();</Script>");
                        }
                    }
                    else{
                        out.println("<script>alert('Esta intentando cambiar a un infante que no es suyo');</script>");
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
