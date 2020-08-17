/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.controlador;

import com.angel.dao.Iafeccionesdao;
import com.angel.dao.Iinfantedao;
import com.angel.dao.Ireportedao;
import com.angel.dao.Iusuariodao;
import com.angel.impdao.impafecciones;
import com.angel.impdao.impinfante;
import com.angel.impdao.impreporte;
import com.angel.impdao.impusuario;
import com.angel.modelo.afecciones;
import com.angel.modelo.cuenta_usuario;
import com.angel.modelo.infante;
import com.angel.modelo.reporte;
import com.angel.modelo.usuario;
import com.angel.seguridad.encriptador;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import static com.itextpdf.kernel.pdf.PdfName.a;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet(name = "generador_reporte_pdf", urlPatterns = {"/generador_reporte_pdf"})
public class generador_reporte_pdf extends HttpServlet {

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
            out.println("<title>Servlet generador_reporte_pdf</title>");            
            out.println("</head>");
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
                idS=String.valueOf(datos_sesion.getAttribute("id_infante"));
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
                    Iinfantedao controla_infante=new impinfante();
                    infan=controla_infante.traeinfante(id, correo);
                    if(!(infan == null)){
                        try{
                            Ireportedao controla_reporte=new impreporte();
                            int id_repor=Integer.parseInt(request.getParameter("id_repor"));
                            reporte repor=controla_reporte.traereporte(id_repor);
                            PdfWriter escritor=new PdfWriter(getServletContext().getRealPath("/")+"pdf\\reporte_"+repor.getId_reporte()+".pdf");
                            PdfDocument repo=new PdfDocument(escritor);
                            Document documento=new Document(repo,PageSize.LETTER);
                            PdfFont fuente_documento=PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
                            documento.setFont(fuente_documento);
                            Table contenedor_princi=new Table(4);
                            contenedor_princi.setFixedLayout();
                            contenedor_princi.setHorizontalAlignment(HorizontalAlignment.CENTER);
                            contenedor_princi.setVerticalAlignment(VerticalAlignment.TOP);
                            contenedor_princi.setWidth(540);
                            contenedor_princi.setPadding(5);
                            
                            String auxr1=getServletContext().getRealPath("/");
                            String auxr2="";
                            auxr1+="img/";
                            int auxr3=0,auxr4=0;
                            for (int i=0;i<auxr1.length();i++) {
                                if(auxr1.charAt(i)==92){
                                    auxr2+="/";
                                }
                                else{
                                    auxr2+=auxr1.charAt(i);
                                }
                            }
                            auxr3=auxr2.indexOf("/build");
                            auxr4=auxr3+6;
                            String auxr5=auxr2.substring(0, auxr3)+auxr1.substring(auxr4);
                            String filePath = auxr5;
                            Image logo_img=new Image(ImageDataFactory.create(filePath+"Logo.jpg"));
                            logo_img.setAutoScale(true);
                            
                            Cell reporte_titulo=new Cell(1,3);
                            reporte_titulo.setFontSize(16);
                            reporte_titulo.add(new Paragraph("Reporte medico"));
                            reporte_titulo.setBold();
                            contenedor_princi.addCell(reporte_titulo);
                            
                            Cell logo=new Cell(2, 1);
                            logo.setFontSize(16);
                            logo.add(logo_img);
                            contenedor_princi.addCell(logo);
                            
                            Cell nume_reporte=new Cell(1,2);
                            nume_reporte.setFontSize(16);
                            nume_reporte.setBorderRight(Border.NO_BORDER);
                            nume_reporte.add(new Paragraph("Numero de Reporte: "+repor.getId_reporte()));
                            contenedor_princi.addCell(nume_reporte);
                            
                            Cell fecha=new Cell(1, 1);
                            fecha.setFontSize(16);
                            fecha.add(new Paragraph("Fecha : "+repor.getFecha().toLocaleString().substring(0,10)));
                            fecha.setBorderLeft(Border.NO_BORDER);
                            contenedor_princi.addCell(fecha);
                            
                            
                            Cell datos_personales_titulo=new Cell(1, 4);
                            datos_personales_titulo.setFontSize(16);
                            datos_personales_titulo.setBold();
                            datos_personales_titulo.setBorderBottom(Border.NO_BORDER);
                            datos_personales_titulo.add(new Paragraph("Datos Personales"));
                            contenedor_princi.addCell(datos_personales_titulo);
                            
                            Cell nombre=new Cell(1, 1);
                            nombre.setFontSize(16);
                            nombre.setBorderTop(Border.NO_BORDER);
                            nombre.setBorderRight(Border.NO_BORDER);
                            nombre.setBorderBottom(Border.NO_BORDER);
                            nombre.add(new Paragraph("Nombre: "+infan.getNombre()));
                            contenedor_princi.addCell(nombre);
                            
                            Cell apellido_p=new Cell(1, 1);
                            apellido_p.setFontSize(16);
                            apellido_p.setBorderTop(Border.NO_BORDER);
                            apellido_p.setBorderRight(Border.NO_BORDER);
                            apellido_p.setBorderBottom(Border.NO_BORDER);
                            apellido_p.setBorderLeft(Border.NO_BORDER);
                            apellido_p.add(new Paragraph("Apellido Paterno: "+infan.getApellido_p()));
                            contenedor_princi.addCell(apellido_p);
                            
                            Cell apellido_m=new Cell(1, 1);
                            apellido_m.setFontSize(16);
                            apellido_m.setBorderTop(Border.NO_BORDER);
                            apellido_m.setBorderRight(Border.NO_BORDER);
                            apellido_m.setBorderBottom(Border.NO_BORDER);
                            apellido_m.setBorderLeft(Border.NO_BORDER);
                            apellido_m.add(new Paragraph("Apellido Materno: "+infan.getApellido_m()));
                            contenedor_princi.addCell(apellido_m);
                            
                            Cell vacio1=new Cell(1, 1);
                            vacio1.setFontSize(16);
                            vacio1.setBorderTop(Border.NO_BORDER);
                            vacio1.setBorderBottom(Border.NO_BORDER);
                            vacio1.setBorderLeft(Border.NO_BORDER);
                            vacio1.add(new Paragraph(""));
                            contenedor_princi.addCell(vacio1);
                            
                            Cell sexo=new Cell(1, 1);
                            sexo.setFontSize(16);
                            sexo.setBorderTop(Border.NO_BORDER);
                            sexo.setBorderRight(Border.NO_BORDER);
                            if(infan.getSexo()==1){
                                sexo.add(new Paragraph("Sexo: Masculino"));
                            }
                            else{
                                sexo.add(new Paragraph("Sexo: Femenino"));
                            }
                            
                            contenedor_princi.addCell(sexo);
                            
                            Cell fecha_d=new Cell(1, 2);
                            fecha_d.setFontSize(16);
                            fecha_d.setBorderTop(Border.NO_BORDER);
                            fecha_d.setBorderRight(Border.NO_BORDER);
                            fecha_d.setBorderLeft(Border.NO_BORDER);
                            fecha_d.add(new Paragraph("Fecha de nacimiento: "+infan.getFecha_naci()));
                            contenedor_princi.addCell(fecha_d);
                            
                            Cell edad=new Cell(1, 1);
                            edad.setFontSize(16);
                            edad.setBorderTop(Border.NO_BORDER);
                            edad.setBorderLeft(Border.NO_BORDER);
                            Date naci=infan.getFecha_naci();
                            Date hoy=new Date();
                            long cuanto=(hoy.getTime()-naci.getTime());
                            cuanto=cuanto/1000/60/60/24/365;
                            edad.add(new Paragraph("Edad: "+(int)(cuanto)+" años"));
                            contenedor_princi.addCell(edad);
                            
                            Cell datos_medicos_titulo=new Cell(1, 4);
                            datos_medicos_titulo.setFontSize(16);
                            datos_medicos_titulo.setBold();
                            datos_medicos_titulo.setBorderBottom(Border.NO_BORDER);
                            datos_medicos_titulo.add(new Paragraph("Datos Medicos"));
                            contenedor_princi.addCell(datos_medicos_titulo);
                            
                            Cell altura=new Cell(1, 1);
                            altura.setFontSize(16);
                            altura.setBorderTop(Border.NO_BORDER);
                            altura.setBorderRight(Border.NO_BORDER);
                            altura.setBorderBottom(Border.NO_BORDER);
                            altura.add(new Paragraph("Altura: "+repor.getTalla()+" cm"));
                            contenedor_princi.addCell(altura);
                            
                            Cell peso=new Cell(1, 1);
                            peso.setFontSize(16);
                            peso.setBorderTop(Border.NO_BORDER);
                            peso.setBorderRight(Border.NO_BORDER);
                            peso.setBorderBottom(Border.NO_BORDER);
                            peso.setBorderLeft(Border.NO_BORDER);
                            peso.add(new Paragraph("Peso: "+repor.getPeso()+" g"));
                            contenedor_princi.addCell(peso);
                            
                            Cell tempe=new Cell(1, 1);
                            tempe.setFontSize(16);
                            tempe.setBorderTop(Border.NO_BORDER);
                            tempe.setBorderRight(Border.NO_BORDER);
                            tempe.setBorderBottom(Border.NO_BORDER);
                            tempe.setBorderLeft(Border.NO_BORDER);
                            tempe.add(new Paragraph("Temperatura: "+repor.getTemperatura()+"°C"));
                            contenedor_princi.addCell(tempe);
                                
                            Cell frecuencia_c=new Cell(1, 1);
                            frecuencia_c.setFontSize(16);
                            frecuencia_c.setBorderTop(Border.NO_BORDER);
                            frecuencia_c.setBorderBottom(Border.NO_BORDER);
                            frecuencia_c.setBorderLeft(Border.NO_BORDER);
                            frecuencia_c.add(new Paragraph("Frecuencia Cardiaca: "+repor.getFrecuencia_cardiaca()));
                            contenedor_princi.addCell(frecuencia_c);
                            
                            Cell coloracion_p=new Cell(1, 2);
                            coloracion_p.setFontSize(16);
                            if(repor.getId_colo_piel()==1){
                                coloracion_p.add(new Paragraph("Coloracion de piel: Normal"));
                            }
                            if(repor.getId_colo_piel()==2){
                                coloracion_p.add(new Paragraph("Coloracion de piel: Palido"));
                            }
                            if(repor.getId_colo_piel()==3){
                                coloracion_p.add(new Paragraph("Coloracion de piel: Colorado"));
                            }
                            contenedor_princi.addCell(coloracion_p);
                            
                            Cell cansancio=new Cell(1, 2);
                            cansancio.setFontSize(16);
                            if(repor.getId_cansa()==1){
                                cansancio.add(new Paragraph("Presenta cansancio: Si"));
                            }
                            if(repor.getId_cansa()==2){
                                cansancio.add(new Paragraph("Presenta cansancio: No presenta"));
                            }
                            contenedor_princi.addCell(cansancio);
                            
                            Cell dolor_ca=new Cell(1, 2);
                            dolor_ca.setFontSize(16);
                            if(repor.getId_dolor_ca()==1){
                                dolor_ca.add(new Paragraph("Presenta dolor de cabeza: Si"));
                            }
                            if(repor.getId_dolor_ca()==2){
                                dolor_ca.add(new Paragraph("Presenta dolor de cabeza: No presenta"));
                            }
                            contenedor_princi.addCell(dolor_ca);
                            
                            Cell dolor_ga=new Cell(1, 2);
                            dolor_ga.setFontSize(16);
                            if(repor.getId_dolor_g()==1){
                                dolor_ga.add(new Paragraph("Presenta dolor de garganta: Si"));
                            }
                            if(repor.getId_dolor_g()==2){
                                dolor_ga.add(new Paragraph("Presenta dolor de garganta: No presenta"));
                            }
                            contenedor_princi.addCell(dolor_ga);
                            
                            Cell dolor_ab=new Cell(1, 2);
                            dolor_ab.setFontSize(16);
                            if(repor.getId_dolor_ab()==1){
                                dolor_ab.add(new Paragraph("Presenta dolor de abdomen: No presenta"));
                            }
                            if(repor.getId_dolor_ab()==2){
                                dolor_ab.add(new Paragraph("Presenta dolor de abdomen: Leve"));
                            }
                            if(repor.getId_dolor_ab()==3){
                                dolor_ab.add(new Paragraph("Presenta dolor de abdomen: Moderado"));
                            }
                            if(repor.getId_dolor_ab()==4){
                                dolor_ab.add(new Paragraph("Presenta dolor de abdomen: Intenso"));
                            }
                            contenedor_princi.addCell(dolor_ab);
                            
                            Cell escuri_nasal=new Cell(1, 2);
                            escuri_nasal.setFontSize(16);
                            if(repor.getId_escuri_n()==1){
                                escuri_nasal.add(new Paragraph("Presenta escurimiento nasal: Si"));
                            }
                            if(repor.getId_escuri_n()==2){
                                escuri_nasal.add(new Paragraph("Presenta escurimiento nasal: No presenta"));
                            }
                            contenedor_princi.addCell(escuri_nasal);
                            
                            Cell flema=new Cell(1, 2);
                            flema.setFontSize(16);
                            if(repor.getId_flema()==1){
                                flema.add(new Paragraph("Presenta flemas: No presenta"));
                            }
                            if(repor.getId_flema()==2){
                                flema.add(new Paragraph("Presenta flemas: Transparente"));
                            }
                            if(repor.getId_flema()==3){
                                flema.add(new Paragraph("Presenta flemas: Verde"));
                            }
                            if(repor.getId_flema()==4){
                                flema.add(new Paragraph("Presenta flemas: Blanca"));
                            }
                            if(repor.getId_flema()==5){
                                flema.add(new Paragraph("Presenta flemas: Sangrienta"));
                            }
                            contenedor_princi.addCell(flema);
                            
                            Cell nauseas=new Cell(1, 2);
                            nauseas.setFontSize(16);
                            if(repor.getId_nauseas()==1){
                                nauseas.add(new Paragraph("Presenta nauseas: Si"));
                            }
                            if(repor.getId_nauseas()==2){
                                nauseas.add(new Paragraph("Presenta nauseas: No presenta"));
                            }
                            contenedor_princi.addCell(nauseas);
                            
                            Cell vomito=new Cell(1, 2);
                            vomito.setFontSize(16);
                            if(repor.getId_vomito()==1){
                                vomito.add(new Paragraph("Presenta vomito: Si"));
                            }
                            if(repor.getId_vomito()==2){
                                vomito.add(new Paragraph("Presenta vomito: No presenta"));
                            }
                            contenedor_princi.addCell(vomito);
                            
                            Cell diarrea=new Cell(1, 2);
                            diarrea.setFontSize(16);
                            if(repor.getId_diarrea()==1){
                                diarrea.add(new Paragraph("Presenta diarrea: Si"));
                            }
                            if(repor.getId_diarrea()==2){
                                diarrea.add(new Paragraph("Presenta diarrea: No presenta"));
                            }
                            contenedor_princi.addCell(diarrea);
                            
                            Cell observacion=new Cell(1, 4);
                            observacion.setFontSize(16);
                            observacion.add(new Paragraph("Observaciones"));
                            observacion.setBold();
                            observacion.setBorderBottom(Border.NO_BORDER);
                            contenedor_princi.addCell(observacion);
                            
                            Iafeccionesdao controla_afecciones=new impafecciones();
                            ArrayList<afecciones> lista_afecciones=controla_afecciones.traeafeccionesInfante(infan.getId_infante());
                            if(lista_afecciones.size()>0){
                                Cell observacion_prev=new Cell(1, 4);
                                observacion_prev.setFontSize(16);
                                observacion_prev.add(new Paragraph("El infante de manera previa padece de:"));
                                observacion_prev.setBorderBottom(Border.NO_BORDER);
                                observacion_prev.setBorderTop(Border.NO_BORDER);
                                contenedor_princi.addCell(observacion_prev);
                                for(int i=0;i<lista_afecciones.size();i++){
                                    Cell contenedor_afec=new Cell(1,2);
                                    contenedor_afec.setFontSize(16);
                                    contenedor_afec.setBorderTop(Border.NO_BORDER);
                                    if(lista_afecciones.size()%2==0){
                                        if(!((lista_afecciones.size()-2)<=i)){
                                            contenedor_afec.setBorderBottom(Border.NO_BORDER);
                                            if(i==0 || i%2==0){
                                                contenedor_afec.setBorderRight(Border.NO_BORDER);
                                            }
                                            else{
                                                contenedor_afec.setBorderLeft(Border.NO_BORDER);
                                            }
                                        }
                                        else{
                                            if(i==0 || i%2==0){
                                                contenedor_afec.setBorderRight(Border.NO_BORDER);
                                            }
                                            else{
                                                contenedor_afec.setBorderLeft(Border.NO_BORDER);
                                            }
                                        }
                                    }
                                    else{
                                        if(!((lista_afecciones.size()-1)<=i)){
                                            contenedor_afec.setBorderBottom(Border.NO_BORDER);
                                            if(i==0 || i%2==0){
                                                contenedor_afec.setBorderRight(Border.NO_BORDER);
                                            }
                                            else{
                                                contenedor_afec.setBorderLeft(Border.NO_BORDER);
                                            }
                                        }
                                        else{
                                            if(i==0 || i%2==0){
                                                contenedor_afec.setBorderRight(Border.NO_BORDER);
                                            }
                                            else{
                                                contenedor_afec.setBorderLeft(Border.NO_BORDER);
                                            }
                                        }
                                    }
                                    contenedor_afec.add(new Paragraph(lista_afecciones.get(i).getNombre()));
                                    contenedor_princi.addCell(contenedor_afec);
                                }
                            }
                            else{
                                Cell observacion_prev=new Cell(1, 4);
                                observacion_prev.setFontSize(16);
                                observacion_prev.add(new Paragraph("Ninguna"));
                                observacion_prev.setBorderTop(Border.NO_BORDER);
                                contenedor_princi.addCell(observacion_prev);
                            }
                            contenedor_princi.setBorder(new SolidBorder(1));
                            documento.add(contenedor_princi);
                            documento.close();
                            
                            response.sendRedirect("pdf/reporte_"+repor.getId_reporte()+".pdf");
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                    else{
                        out.println("<script>alert('Esta intentando obtener datos que no son suyos');</script>");
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
