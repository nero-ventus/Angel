<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function presiona1(){
                setTimeout(function (){
                    window.location.replace('index');
                },5000);
            }
            function presiona2(){
                setTimeout(function (){
                    window.location.replace('form_usuario.jsp');
                },5000);
            }
        </script>
    </head>
    <body>
        <form action="registra_usuario" method="post">
            <input type="text" name="nombre" id="nombre" required placeholder="Nombre(s)">
            <br>
            <br>
            <input type="text" name="apellido_p" id="apellido_p" required placeholder="Apellido Paterno">
            <br>
            <br>
            <input type="text" name="apellido_m" id="apellido_m" required placeholder="Apellido Materno">
            <br>
            <br>
            <input type="text" name="correo" id="correo" required placeholder="Correo electronico">
            <br>
            <br>
            <input type="password" name="contra" id="contra" required placeholder="Contraseña">
            <br>
            <br>
            <input type="password" name="ccontra" id="ccontra" required placeholder="Confirmar contraseña">
            <br>
            <br>
            <input type="text" name="codigo" id="codigo" required placeholder="Codigo de producto">
            <br>
            <br>
            <input type="text" name="nex" id="nex" required placeholder="N°Exterior">
            <br>
            <br>
            <input type="text" name="calle" id="calle" required placeholder="Calle">
            <br>
            <br>
            <input type="text" name="municipio" id="municipio" required placeholder="Municipio">
            <br>
            <br>
            <select name="estado" id="estado">
                <option value="0" selected disabled>Seleccione un estado</option>
                <option value="1">Ciudad de Mexico</option>
                <option value="2">Aguascalientes</option>
                <option value="3">Baja California</option>
                <option value="4">Baja California Sur</option>
                <option value="5">Campeche</option>
                <option value="6">Chiapas</option>
                <option value="7">Chihuahua</option>
                <option value="8">Coahuila</option>
                <option value="9">Colima</option>
                <option value="10">Durango</option>
                <option value="11">Estado de México</option>
                <option value="12">Guanajuato</option>
                <option value="13">Guerrero</option>
                <option value="14">Hidalgo</option>
                <option value="15">Jalisco</option>
                <option value="16">Michoacán</option>
                <option value="17">Morelos</option>
                <option value="18">Nayarit</option>
                <option value="19">Nuevo León</option>
                <option value="20">Oaxaca</option>
                <option value="21">Puebla</option>
                <option value="22">Querétaro</option>
                <option value="23">Quintana Roo</option>
                <option value="24">San Luis Potosí</option>
                <option value="25">Sinaloa</option>
                <option value="26">Sonora</option>
                <option value="27">Tabasco</option>
                <option value="28">Tamaulipas</option>
                <option value="29">Tlaxcala</option>
                <option value="30">Veracruz</option>
                <option value="31">Yucatán</option>
                <option value="32">Zacatecas</option>
            </select>
            <br>
            <br>
            <input type="submit">
        </form>
    </body>
</html>
