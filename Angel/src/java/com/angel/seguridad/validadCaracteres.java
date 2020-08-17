package com.angel.seguridad;

import com.angel.modelo.cuenta_usuario;
import com.angel.modelo.direccion;
import com.angel.modelo.infante;
import com.angel.modelo.usuario;

/**
 *
 * @author Alumno
 */
public class validadCaracteres {     
    public int validaRegistroUsuario(usuario a,cuenta_usuario b,direccion c){
        int validado=0;
        try{
            String[] alfabeticos={a.getNombre(),a.getApellido_p(),a.getApellido_m()};
            String[] alfanumericos={b.getContra(),c.getCalle(),c.getMunicipio(),b.getCodigo()};
            for (int i=0;i<alfabeticos.length;i++) {
                for (int j=0;j<alfabeticos[i].length();j++) {
                    if((alfabeticos[i].charAt(j)<65 || 90<alfabeticos[i].charAt(j)) && (alfabeticos[i].charAt(j)<97 || 122<alfabeticos[i].charAt(j)) && !(alfabeticos[i].charAt(j)==32)){
                        validado=1;
                        break;
                    }
                }
                if(validado==1){
                    break;
                }
            }
            if(validado==0){
                for (int i=0;i<alfanumericos.length;i++) {
                    for (int j=0;j<alfanumericos[i].length();j++) {
                        if((alfanumericos[i].charAt(j)<48 || 57<alfanumericos[i].charAt(j)) && (alfanumericos[i].charAt(j)<65 || 90<alfanumericos[i].charAt(j)) && (alfanumericos[i].charAt(j)<97 || 122<alfanumericos[i].charAt(j)) && !(alfanumericos[i].charAt(j)==32)){
                            validado=1;
                            break;
                        }
                    }
                    if(validado==1){
                        break;
                    }
                }
                if(validado==0){
                    for (int i=0;i<Integer.toString(c.getN_exterior()).length();i++) {
                        if(Integer.toString(c.getN_exterior()).charAt(i)<48 || 57<Integer.toString(c.getN_exterior()).charAt(i)) {
                            validado=1;
                            break;
                        }
                    }
                    if(validado==0){
                        for (int i=0;i<b.getCorreo().length();i++) {
                            if((b.getCorreo().charAt(i)<48 || 57<b.getCorreo().charAt(i)) && (b.getCorreo().charAt(i)<64 || 90<b.getCorreo().charAt(i)) && (b.getCorreo().charAt(i)<97 || 122<b.getCorreo().charAt(i)) && !(b.getCorreo().charAt(i)==32 || b.getCorreo().charAt(i)==95 || b.getCorreo().charAt(i)==126 || b.getCorreo().charAt(i)==46)){
                                validado=1;
                                break;
                            }
                        }
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            validado=1;
        }
        return validado;
    }
    public int validaInicio(String correo,String contra){
        int validado=0;
        try{
            for (int i=0;i<correo.length();i++) {
                if((correo.charAt(i)<48 || 57<correo.charAt(i)) && (correo.charAt(i)<64 || 90<correo.charAt(i)) && (correo.charAt(i)<97 || 122<correo.charAt(i)) && !(correo.charAt(i)==32 || correo.charAt(i)==95 || correo.charAt(i)==126 || correo.charAt(i)==46)){
                    validado=1;
                    System.out.println(correo.charAt(i));
                    break;
                }
            }
            if(validado==0){
                for (int j=0;j<contra.length();j++) {
                    if((contra.charAt(j)<48 || 57<contra.charAt(j)) && (contra.charAt(j)<65 || 90<contra.charAt(j)) && (contra.charAt(j)<97 || 122<contra.charAt(j)) && !(contra.charAt(j)==32)){
                        validado=1;
                        System.out.println(contra.charAt(j));
                        break;
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            validado=1;
        }
        return validado;
    }
    public int validaRecupera(String correo){
        int validado=0;
        try{
            for (int i=0;i<correo.length();i++) {
                if((correo.charAt(i)<48 || 57<correo.charAt(i)) && (correo.charAt(i)<64 || 90<correo.charAt(i)) && (correo.charAt(i)<97 || 122<correo.charAt(i)) && !(correo.charAt(i)==32 || correo.charAt(i)==95 || correo.charAt(i)==126 || correo.charAt(i)==46)){
                    validado=1;
                    System.out.println(correo.charAt(i));
                    break;
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            validado=1;
        }
        return validado;
    }
    public int  validaRegistraInfante(infante a){
        int valida=0;
        try{
            String[] alfabeticos={a.getNombre(),a.getApellido_p(),a.getApellido_m()};
            for (int i=0;i<alfabeticos.length;i++) {
                for (int j=0;j<alfabeticos[i].length();j++) {
                    if((alfabeticos[i].charAt(j)<65 || 90<alfabeticos[i].charAt(j)) && (alfabeticos[i].charAt(j)<97 || 122<alfabeticos[i].charAt(j)) && !(alfabeticos[i].charAt(j)==32)){
                        valida=1;
                        break;
                    }
                }
                if(valida==1){
                    break;
                }
            }
            if(valida==0){
                if(a.getAltura()>200 || a.getAltura()<0){
                    valida=1;
                }
                if(a.getPeso()<0 || a.getPeso()>50000){
                    valida=1;
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            valida=0;
        }
        return valida;
    }
}