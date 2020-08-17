<%-- 
    Document   : registra_bebe
    Created on : 2/11/2018, 08:17:56 PM
    Author     : devil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="registra_infante">
            <input type="text" id="nombre" name="nombre" placeholder="Nombre" required>
            <input type="text" id="apellido_p" name="apellido_p" placeholder="Apellido Paterno" required>
            <input type="text" id="apellido_m" name="apellido_m" placeholder="Apellido Materno" required>
            <input type="text" id="peso" name="peso" placeholder="Peso" required>
            <input type="text" id="altura" name="altura" placeholder="Altura" required>
            <select id="sexo" name="sexo">
                <option value="0" selected disabled>Selecione algun sexo</option>
                <option value="1">Masculino</option>
                <option value="2">Femenino</option>
            </select>
            <select id="dispositivo" name="dispositivo">
                <option value="0" selected disabled>Selecione algun dispositivo</option>
                <option value="1">1</option>
            </select>
            <input type="date" id="fecha_n" name="fecha_n" required>
            <input type="checkbox" id="a1" name="a1" value="1">Asma
            <input type="checkbox" id="a2" name="a2" value="2">Fibrosis quística
            <input type="checkbox" id="a3" name="a3" value="3">Diabetes
            <input type="checkbox" id="a4" name="a4" value="4">Hipoglucemia
            <input type="checkbox" id="a5" name="a5" value="5">Parálisis cerebral
            <input type="checkbox" id="a6" name="a6" value="6">Autismo
            <input type="checkbox" id="a7" name="a7" value="7">Deficit de atencion
            <input type="checkbox" id="a8" name="a8" value="8">Hiperactiviadad
            <input type="submit">
        </form>
    </body>
</html>