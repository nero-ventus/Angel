/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.dao;

import com.angel.modelo.gerente_mantenimiento;
import com.angel.modelo.programador;
import java.util.ArrayList;

/**
 *
 * @author devil
 */
public interface Igerente_mantenimientodao {
    int altagerente_mantenimiento(gerente_mantenimiento a);
    
    gerente_mantenimiento traegerente_mantenimiento(gerente_mantenimiento a);
    
    int actualizagerente_mantenimiento(String correo_gerente_mantenimiento,gerente_mantenimiento a);
       
    ArrayList<programador> trae_programadores();

    int borragerente_mantenimiento(String correo_gerente_mantenimiento);
    int subir_solucion(String solucion, int id_reporte_e);

}
