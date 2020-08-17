package com.angel.controlador;
import com.angel.dao.Iusuariodao;
import com.angel.impdao.impusuario;
import com.angel.modelo.cuenta_usuario;
import com.angel.modelo.direccion;
import com.angel.modelo.usuario;
import com.angel.seguridad.encriptador;
import com.angel.seguridad.validadCaracteres;
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
@WebServlet(urlPatterns = {"/registra_usuario"})
public class registra_usuario extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<script>function presiona1(){\n" +
"                setTimeout(function (){\n" +
"                    window.location.replace('Home.jsp');\n" +
"                },0);\n" +
"            }\n" +
"            function presiona2(){\n" +
"                setTimeout(function (){\n" +
"                    window.history.back();\n" +
"                },0);\n" +
"            }</script>");
            out.println("<title>Servlet registra_usuario</title>");            
            out.println("</head>");
            out.println("<body>");
            usuario user=null;
            cuenta_usuario cuenta=null;
            direccion direc=null;
            int longitud=0;
            try {
                String[] listal={request.getParameter("nombre"), request.getParameter("apellido_p"), request.getParameter("apellido_m"),request.getParameter("correo"),request.getParameter("correo"), request.getParameter("contra"),request.getParameter("codigo"),request.getParameter("nex"),request.getParameter("calle"), request.getParameter("municipio"),request.getParameter("estado")};
                for (int i=0;i<listal.length;i++) {
                    if(listal[i].length()>40){
                        longitud=1;
                        break;
                    }
                }
            }
            catch (Exception e) {
                out.println("<script>alert('Varifica que los datos hallan sido bien introducidos, Intentalo de Nuevo');<alert>");
                out.println("<script>presiona2();</script>");
            }
            if(longitud==0){
                try {
                    user=new usuario(0, request.getParameter("nombre"), request.getParameter("apellido_p"), request.getParameter("apellido_m"), 0, request.getParameter("correo"));
                    cuenta=new cuenta_usuario(request.getParameter("correo"), request.getParameter("contra"), 2, request.getParameter("codigo"));
                    direc=new direccion(0, Integer.parseInt(request.getParameter("nex")), request.getParameter("calle"), request.getParameter("municipio"), Integer.parseInt(request.getParameter("estado")));
                }
                catch (Exception e) {
                    out.println("<script>alert('Varifica que los datos hallan sido bien introducidos, Intentalo de Nuevo');<alert>");
                    out.println("<script>presiona2();</script>");
                }
                validadCaracteres validador=new  validadCaracteres();
                int validacaracteres=validador.validaRegistroUsuario(user, cuenta, direc);
                if(validacaracteres==0){
                    String nombre=ESAPI.encoder().encodeForHTML(request.getParameter("nombre"));
                    String apellidop=ESAPI.encoder().encodeForHTML(request.getParameter("apellido_p"));
                    String apellidom=ESAPI.encoder().encodeForHTML(request.getParameter("apellido_m"));
                    String correo=ESAPI.encoder().encodeForHTML(request.getParameter("correo"));
                    String contra=ESAPI.encoder().encodeForHTML(request.getParameter("contra"));
                    String codigo=ESAPI.encoder().encodeForHTML(request.getParameter("codigo"));
                    int nex=Integer.parseInt(ESAPI.encoder().encodeForHTML(request.getParameter("nex")));
                    String calle=ESAPI.encoder().encodeForHTML(request.getParameter("calle"));
                    String municipio=ESAPI.encoder().encodeForHTML(request.getParameter("municipio"));
                    try {
                        user=new usuario(0, nombre, apellidop, apellidom, 0, correo);
                        cuenta=new cuenta_usuario(correo, contra, 2, codigo);
                        direc=new direccion(0, nex, calle, municipio, Integer.parseInt(request.getParameter("estado")));
                    }
                    catch (Exception e) {
                        out.println("<script>alert('Varifica que los datos hallan sido bien introducidos, Intentalo de Nuevo');<alert>");
                        out.println("<script>presiona2();</script>");
                    }
                    Iusuariodao usuario=new impusuario();
                    int correos_iguales=0;
                    if(request.getParameter("contra").equals(request.getParameter("ccontra"))){
                        correos_iguales=1;
                    }
                    if(correos_iguales==1){
                        int valida=usuario.altausuario(user, cuenta, direc);
                        if(valida==1){
                            out.println("<script>alert('Usuario Registrado, En breve se le enviara a la pagina de inicio');</script>");
                            HttpSession datos_sesion=request.getSession();
                            encriptador encripta=new encriptador();
                            datos_sesion.setAttribute("correo", encripta.encriptar(cuenta.getCorreo()));
                            datos_sesion.setAttribute("contra", encripta.encriptar(cuenta.getContra()));
                            out.println("<script>presiona1();</script>");
                        }
                        else{
                            if(valida==2){
                                out.println("<script>alert('Codigo de producto invalido o en uso');</script>");
                                out.println("<script>presiona2();</script>");
                            }
                            else{
                                if(valida==3){
                                    out.println("<script>alert('Correo ya en uso');</script>");
                                    out.println("<script>presiona2();</script>");
                                }
                                else{
                                    if(valida==0){
                                        out.println("<script>alert('Datos erroneos');</script>");
                                        out.println("<script>presiona2();</script>");
                                    }
                                }
                            }
                        }
                    }
                    else{
                        out.println("<script>alert('Las contraseñas no coindiden');</script>");
                        out.println("<script>presiona2();</script>");
                    }
                }
                else{
                    out.println("<script>alert('Verifica que los caracteres sean los permitidos, Intentalo de nuevo');</script>");
                    out.println("<script>presiona2();</script>");
                }
            }
            else{
                out.println("<script>alert('Los datos son demasiado largos,Varificalos');</script>");
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