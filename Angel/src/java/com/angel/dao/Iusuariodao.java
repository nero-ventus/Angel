package com.angel.dao;
import com.angel.modelo.cuenta_usuario;
import com.angel.modelo.direccion;
import com.angel.modelo.usuario;
import java.util.List;
public interface Iusuariodao {
    int altausuario(usuario a,cuenta_usuario b,direccion c);
    
    usuario traeusuario(cuenta_usuario cuenta);
    
    int actualizausuario(usuario a,cuenta_usuario b,direccion c,String correoo);
    
    int borrausuario(String correo);
}