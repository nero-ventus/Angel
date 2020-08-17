/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.angel.extras;

import java.sql.Date;

/**
 *
 * @author devil
 */
public class String_a_Date {
    public Date covertir(String texto){
        int ano=Integer.parseInt(texto.substring(0,4));
        int mes=Integer.parseInt(texto.substring(5,7));
        int dia=Integer.parseInt(texto.substring(8));
        Date fecha=new Date((ano-1900),(mes-1),dia);
        return fecha;
    }
}
