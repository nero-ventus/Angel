package com.angel.dao;

import com.angel.modelo.tickets;
import java.util.ArrayList;

public interface Iticketsdao {
    int altaticket(tickets a);
    
    tickets traeticket(int id_ticket);
    
    int actualizaticketestado(int modulo);
    
    int actualizaticket(int id_ticket,String correo_admi,String respuesta);
    
    int borratickets(int id_ticket);
    
    ArrayList<tickets> traeTickets(int modulou);
}