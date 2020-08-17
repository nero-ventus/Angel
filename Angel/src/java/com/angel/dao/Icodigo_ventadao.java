/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.dao;

import com.angel.modelo.codigo_venta;

/**
 *
 * @author Alumno
 */
public interface Icodigo_ventadao {
    int altacodigo_venta(codigo_venta a);
    
    codigo_venta traecodigo_venta(String codigo);
    
    void actualizacodigo_venta(codigo_venta a);
    
    void borracodigo_venta(String codigo);
}
