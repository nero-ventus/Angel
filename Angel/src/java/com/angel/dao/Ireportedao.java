package com.angel.dao;

import com.angel.modelo.infante;
import com.angel.modelo.reporte;
import java.util.ArrayList;

public interface Ireportedao {    
    int altareporte(reporte a,int id_infante);
    
    reporte traereporte(int id_reporte);
    
    int actualizareporte(reporte a,infante b);
    
    int borrareporte(int id_reporte);
    
    ArrayList<reporte> trereportes(int id);
}