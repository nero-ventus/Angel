package com.angel.seguridad;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.filters.ESAPIFilter;

/**
 *
 * @author devil
 */
@WebServlet(name = "seguridad_inicio_sesion", urlPatterns = {"/seguridad_inicio_sesion"})
public class seguridad_inicio_sesion extends HttpServlet {

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
            out.println("<title>Servlet seguridad_inicio_sesion</title>");            
            out.println("</head>");
            out.println("<body>");
            encriptador encripta=new encriptador();
            String uncorreo="",uncontra="";
            try{
                uncorreo=request.getParameter("correo");
                uncontra=request.getParameter("contra");
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                out.println("<script>alert('Datos Erroneos');</script>");
                out.println("<script>presiona2();</script>");
            }
            validadCaracteres validac=new validadCaracteres();
            int validacaracteres=validac.validaInicio(uncorreo, uncontra);
            if(validacaracteres==0){
                String correo=ESAPI.encoder().encodeForHTML(uncorreo);
                String contra=ESAPI.encoder().encodeForHTML(uncontra);
                String encripcorreo=encripta.encriptar(correo);
                String encripcontra=encripta.encriptar(contra);
                request.setAttribute("correo", encripcorreo);
                request.setAttribute("contra", encripcontra);
                RequestDispatcher rd = request.getRequestDispatcher("inicia_sesion");
                rd.forward(request,response);
            }
            else{
                out.println("<script>alert('Varifica los caracteres que han sido introducidos');</script>");
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