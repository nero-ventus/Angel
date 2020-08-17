<%-- 
    Document   : form_config_li
    Created on : 12/11/2018, 12:25:49 AM
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
        <form action="actualiza_configuracion_li" method="post">
            <input type="checkbox" value="1" name="estado_servicio" id="estado_servicio">Estado del servicio
            <br><br>
            <input type="number" name="volumen" id="volumen" required>
            <br><br>
            <select name="tono" id="tono" required>
                <option value="0" selected disabled>Selecciona un tono</option>
                <option value="predeterminado1">Predeterminado 1</option>
                <option value="predeterminado2">Predeterminado 2</option>
                <option value="predeterminado3">Predeterminado 3</option>
            </select>
            <br><br>
            <input type="submit">
        </form>
    </body>
</html>