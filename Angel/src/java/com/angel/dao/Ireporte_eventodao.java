/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.dao;

import com.angel.modelo.reporte_evento;
import java.util.ArrayList;


/**
 *
 * @author devil
 */
public interface Ireporte_eventodao {
    
    int valida_cerrado_evento_mantenimiento(int id_reporte_evento);
    
    int cerrar_de_mantenimiento(int id_reporte_evento);
    
    int verifica_si_hay_de_mantenimiento(int id_reporte_evento);
    
    int altareporte_evento(reporte_evento a);
    
    int altareporte_evento_ingeniero(reporte_evento a);
    
    reporte_evento trae_reporte_evento_abierto(reporte_evento a);
    
    reporte_evento trae_reporte_evento_cerrado(reporte_evento a);
    
    int actualizareporte_evento_asigna(int id_reporte,String correo_asignado);
    
    int actualizareporte_evento_cerrar(int id_reporte);
    
    int borrareporte_evento(int id_reporte);
    
    ArrayList<reporte_evento> trae_reportes_evento_abiertos_sin_asignar();
    
    ArrayList<reporte_evento> trae_reportes_evento_abiertos_asignados();
    
    ArrayList<reporte_evento> trae_reportes_evento_cerrados_resueltos();
    
    ArrayList<reporte_evento> trae_reportes_evento_sin_responder_ingeniero(String correo_inge);
    
    ArrayList<reporte_evento> trae_reportes_evento_respondidos_ingeniero(String correo_inge);
    
    reporte_evento trae_reporte_evento(int id);
}