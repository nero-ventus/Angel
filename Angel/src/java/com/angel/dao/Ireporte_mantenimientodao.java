/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.dao;

import com.angel.modelo.reporte_mantenimiento;
import java.util.ArrayList;

/**
 *
 * @author Jesus Abraham
 */
public interface Ireporte_mantenimientodao {

    int altareporte_mantenimiento(reporte_mantenimiento a);

    int registra_reporte_evento_to_mantenimiento_sin_asignar(reporte_mantenimiento a,int id_repor_evento);



    int registra_reporte_mantenimiento_sin_asignar(reporte_mantenimiento a);


    ArrayList<reporte_mantenimiento> trae_reportes_mantenimiento_abiertos_sin_asignar();

    ArrayList<reporte_mantenimiento> trae_reportes_mantenimiento_abiertos_asignados();

    ArrayList<reporte_mantenimiento> trae_reportes_mantenimiento_cerrados_resueltos();

    int asigna_programador(int id_reporte, String correo);

    int actualizareporte_mantenimiento_especial(int id_reporte, String solucion);

}
