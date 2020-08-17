/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.dao;

import com.angel.modelo.programador;

/**
 *
 * @author Jesus Abraham
 */
public interface Iprogramadordao {

    int altaprogramador(programador a);

    programador traeprogramador(programador a);

    int actualizaprogramador(String correo_programador, programador a);

    int borraprogramador(String correo_programador);

    int subir_solucion(String solucion, int id_reporte_e);

}
