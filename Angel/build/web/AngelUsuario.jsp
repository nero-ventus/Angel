<%@page import="com.angel.impdao.impcuenta_usuario"%>
<%@page import="com.angel.dao.Icuenta_usuario"%>
<%@page import="com.angel.impdao.impdireccion"%>
<%@page import="com.angel.dao.Idirecciondao"%>
<%@page import="com.angel.modelo.direccion"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%@page import="com.angel.impdao.impusuario"%>
<%@page import="com.angel.dao.Iusuariodao"%>
<%@page import="com.angel.modelo.usuario"%>
<%@page import="com.angel.modelo.cuenta_usuario"%>
<%@page import="com.angel.seguridad.encriptador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Angel-Usuario</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="icon" type="image/png" href="imagenes/icono.png" />
        <link rel="shortcut icon" href="favicon.ico"> 

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="css/materialize.min.css" media="screen,projection">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/css/materialize.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <script type="text/javascript" src="js/validaciones.js"></script>

        <style>
            body{
                background: url(imagenes/fondouserchange.jpg) no-repeat center center fixed;
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;      
                background-size: cover;
            }

            .switch label input[type=checkbox]:checked+.lever {
                background-color: #64b5f6;
            }

            .switch label input[type=checkbox]:checked+.lever:after {
                background-color: #1565c0;
            }

            .input-field input[type=file].disabled {
                border-bottom: 1px solid grey!important;
                box-shadow: 0 1px 0 0 grey!important;
            } 

            .input-field label {
                color: black!important;
            }
            /* label focus color */
            .input-field input[type=text]:focus + label {
                color: black! important;
            }
            /* label underline focus color */
            .input-field input[type=text]:focus {
                border-bottom: 1px solid #0d47a1! important;
                box-shadow: 0 1px 0 0 #0d47a1 ! important;
            }

            .input-field input[type=text].valid {
                border-bottom: 1px solid #76ff03!important;
                box-shadow: 0 1px 0 0 #76ff03!important;
            }

            .input-field input[type=text].invalid {
                border-bottom: 1px solid red !important;
                box-shadow: 0 1px 0 0 red!important;
            }
            /* icon prefix focus color */
            .input-field .prefix.active {
                color: #000;
            }
            .input-field input[type=password]:focus + label {
                color: black! important;
            }
            /* label underline focus color */
            .input-field input[type=password]:focus {
                border-bottom: 1px solid #0d47a1! important;
                box-shadow: 0 1px 0 0 #0d47a1 ! important;
            }

            .input-field input[type=password].invalid {
                border-bottom: 1px solid red !important;
                box-shadow: 0 1px 0 0 red!important;

            }

            .input-field input[type=password].valid {
                border-bottom: 1px solid #76ff03!important;
                box-shadow: 0 1px 0 0 #76ff03!important;
            }
            ul.dropdown-content.select-dropdown li span {
                color: #03a9f4; /* no need for !important :) */

            }  
            nav{
                position: fixed;
                top: 0;
                z-index: 1;
            }

            .contenedor-principal{
                margin-top: 4.5em;
                position: relative;
                z-index: 0;
            }
        </style>
        <script>

            function revelarContra1() {
                var x = document.getElementById("contra");
                if (x.type === "password") {
                    x.type = "text";
                } else {
                    x.type = "password";
                }
            }
            function revelarContra2() {
                var x = document.getElementById("contra");
                if (x.type === "password") {
                    x.type = "text";
                } else {
                    x.type = "password";
                }
            }
            function revelarContra3() {
                var x = document.getElementById("ccontra");
                if (x.type === "password") {
                    x.type = "text";
                } else {
                    x.type = "password";
                }
            }
            function check() {
                document.getElementById("switch1").checked = false;
            }
            function hab() {
                if (document.getElementById('switch1').checked)
                {
                    document.getElementById("enviar1").disabled = false;
                    document.getElementById("correo").disabled = false;
                    document.getElementById("nombre").disabled = false;
                    document.getElementById("apellido_p").disabled = false;
                    document.getElementById("apellido_m").disabled = false;
                    document.getElementById("contra").disabled = false;
                    document.getElementById("contra").disabled = false;
                    document.getElementById("ccontra").disabled = false;
                    document.getElementById("nex").disabled = false;
                    document.getElementById("calle").disabled = false;
                    document.getElementById("municipio").disabled = false;
                    document.getElementById("selectedenable").removeAttribute("style");
                    document.getElementById("selectdisabled").setAttribute("style", "display:none");

                } else {
                    document.getElementById("correo").disabled = true;
                    document.getElementById("enviar1").disabled = true;
                    document.getElementById("nombre").disabled = true;
                    document.getElementById("apellido_p").disabled = true;
                    document.getElementById("apellido_m").disabled = true;
                    document.getElementById("contra").disabled = true;
                    document.getElementById("nex").disabled = true;
                    document.getElementById("calle").disabled = true;
                    document.getElementById("municipio").disabled = true;
                    document.getElementById("contra").disabled = true;
                    document.getElementById("ccontra").disabled = true;
                    document.getElementById("selectdisabled").removeAttribute("style");
                    document.getElementById("selectedenable").setAttribute("style", "display:none");
                }


            }

        </script>
    </head>

    <script>
        function presiona2() {
            setTimeout(function () {
                window.location.replace('AngelLogIn.html');
            }, 0);
        }

    </script>

    <body>
        <%
            HttpSession datos_sesion = request.getSession();
            String correo, contra;
            encriptador descripta = new encriptador();
            correo = descripta.desencriptar((String) (datos_sesion.getAttribute("correo")));
            contra = descripta.desencriptar((String) (datos_sesion.getAttribute("contra")));
            int valida = 0;
            Iusuariodao user = new impusuario();
            usuario usua = null;

            cuenta_usuario cuenta = null;
            try {
                cuenta = new cuenta_usuario(correo, contra, 0, "0");
                valida = 1;
            } catch (Exception e) {
                out.println("<script>alert('Datos erroneos');</script>");
                out.print("<Script>presiona2();</Script>");
            }
            if (valida == 1) {
                usua = user.traeusuario(cuenta);

                if (!(usua == null)) {
                    Idirecciondao gdirec = new impdireccion();
                    Icuenta_usuario gcuenta = new impcuenta_usuario();
                    direccion direc = gdirec.traedireccion(usua.getId_direccion());
                    cuenta = gcuenta.traecuenta_usuario(correo);
        %>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
        <script>
        $(document).ready(function () {
            $('select').formSelect();
            $('.modal').modal();
            $('.sidenav').sidenav();
            $(".dropdown-trigger").dropdown();
        });
        </script>
        <script>

        </script>
        <ul id="dropdown1" class="dropdown-content blue">
            <li class="white "><a href="Home.jsp" class="light-blue-text"><i class="material-icons left">home</i>Inicio</a></li>
            <li class="white "><a href="AngelGestionInfantil.jsp" class="light-blue-text"><i class="material-icons left">child_friendly</i>Niños</a></li>
            <li class="white "><a href="AngelLocalizacion.jsp" class="light-blue-text"><i class="material-icons left">my_location</i>Ubicación</a></li>
            <li class="white "><a href="badges.html" class="light-blue-text"><i class="material-icons left">help</i>Ayuda</a></li>
            <li class="white "><a href="cerrar_sesion" class="light-blue-text"><i class="material-icons left">power_settings_new</i>Salir</a></li>
        </ul>
        <nav class="white" style="z-index: 99999">
            <div class="nav-wrapper ">
                <a  class="brand-logo light-blue-text flow-text center"><i class="material-icons light-blue-text">person_pin</i>Usuario</a>
                <a href="#" data-target="mobile-demo" class="sidenav-trigger light-blue-text">Menú<i class="material-icons left light-blue-text">menu</i></a>
                <ul class="right hide-on-med-and-down">
                    <li><a class="dropdown-trigger light-blue" href="#!" data-target="dropdown1"><i class="material-icons right">arrow_drop_down</i><i class="material-icons right">account_box</i><% out.print(ESAPI.encoder().decodeForHTML(usua.getNombre())); %></a></li>
                </ul>
            </div>
        </nav> 


        <ul class="sidenav" id="mobile-demo"style="margin-top: 4.5em" >
            <li><a class="white light-blue-text"><i class="material-icons left light-blue-text">person_pin</i><% out.print(ESAPI.encoder().decodeForHTML(usua.getNombre())); %></a></li>
            <li><a href="Home.jsp" class="white light-blue-text"><i class="material-icons left light-blue-text">home</i>Regresar a Inicio</a></li>
            <li><a href="AngelGestionInfantil.jsp" class="white light-blue-text"><i class="material-icons left light-blue-text">child_friendly</i>Gestión Infantil</a></li>
            <li><a href="AngelLocalizacion.jsp" class="white light-blue-text"><i class="material-icons left light-blue-text">my_location</i>Localización</a></li>
            <li><a href="badges.html" class="white light-blue-text"><i class="material-icons left light-blue-text">help</i>Ayuda</a></li>
            <li><a href="cerrar_sesion" class="white light-blue-text"><i class="material-icons left light-blue-text">power_settings_new</i>Cerrar Sesión</a></li>
        </ul>
        <div class="row" style="text-align: center">

            <br><br>
            <div class="contenedor-principal">
                <div class="container">
                    <div class=" flow-text col s12 m12 12  white" style="text-align: center">

                        <h5>Tu información</h5>   
                        <div class="col s12">

                            <div class="switch col s12  ">
                                Editar:<br>
                                <label>
                                    No
                                    <input id="switch1" type="checkbox" onclick="hab()">
                                    <span class="lever"></span>
                                    Si
                                </label>          
                            </div>

                            <div class="col s12  center-align" style="text-align: center">
                                <p>
                                    <i class="small material-icons red-text ">delete_forever</i>  
                                    <a class="waves-effect waves-light btn-large red modal-trigger flow-text" href="#modal1">Dar De Baja</a>
                                </p>

                                <div id="modal1" class="modal">
                                    <div class="modal-content">
                                        <h4>Dar de Baja</h4>
                                        <p>¿Está seguro de eliminar su cuenta?</p>
                                    </div>
                                    <div class="modal-footer">
                                        <div class="col s12">
                                            <div class="col s6">
                                                <a href="#!" class="modal-close waves-effect red waves-red btn-flat col s12 white-text" style="text-align: center">Cancelar</a>
                                            </div>
                                            <div class="col s6">

                                                <form action="elimina_usuario" method="post">
                                                    <input value="<%out.print(ESAPI.encoder().decodeForHTML(usua.getCorreo()));  %>" type="text" id="correo_eliminar" name="correo_eliminar" disabled readonly style="display: none">
                                                    <button class="col s12 btn-flat waves-effect green darken-1 waves-light white-text" id="eliminar"  type="submit" name="action">Eliminar
                                                        <i class="material-icons white-text right">check</i>
                                                    </button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <form action="cambiar_usuario" method="post">

                            <div class="input-field col s6 m2 l2 flow-text">   

                                <input value="<%out.print(ESAPI.encoder().decodeForHTML(usua.getNombre()));%>" disabled type="text" onkeypress="letras()" pattern="^[A-Z a-z 0-9 \u00E0-\u00FC À-ÿ]+$" name="nombre" class="validate" id="nombre" required placeholder="Nombre(s)">
                                <label class="active" for="nombre">Nombre</label>

                            </div>
                            <div class="input-field col s6 m2 l2">   
                                <input value="<%out.print(ESAPI.encoder().decodeForHTML(usua.getApellido_p()));%>" disabled  type="text" onkeypress="letras()" pattern="^[A-Z a-z 0-9 \u00E0-\u00FC À-ÿ]+$" name="apellido_p" class="validate" id="apellido_p" required placeholder="Apellido Paterno">
                                <label for="apellido_p">Primer Apellido</label>

                            </div>
                            <div class="input-field col s6 m2 l2">
                                <input value="<%out.print(ESAPI.encoder().decodeForHTML(usua.getApellido_m()));%>" disabled type="text" onkeypress="letras()" pattern="^[A-Z a-z 0-9 \u00E0-\u00FC À-ÿ]+$" name="apellido_m" class="validate" id="apellido_m" required placeholder="Apellido Materno">
                                <label class="flow-text" for="apellido_m">Segundo Apellido</label>

                            </div>
                            <div class="input-field col s6 m2 l2">
                                <input value="<%out.print(ESAPI.encoder().decodeForHTML(cuenta.getContra()));%>" disabled  onchange="if (this.checkValidity())
                                            form.ccontra.pattern = this.value;" type="password" onkeypress="alfanumerico()" pattern="^[A-Z a-z 0-9 \u00E0-\u00FC À-ÿ]+$" class="validate col s10" name="contra" id="contra" required placeholder="Ingresa nueva contraseña">
                                <label for="contra">Nueva Contraseña:</label><a id="ver1"  class="btn-floating  btn-small col s2 transparent" onclick="revelarContra2()" style="text-align: center;padding: 0"><i class="material-icons black-text left">remove_red_eye</i></a>

                            </div>

                            <div class="input-field col s6 m2 l2">
                                <input value="<%out.print(ESAPI.encoder().decodeForHTML(cuenta.getContra()));%>" disabled onchange="this.setCustomValidity(this.vaidity.patternMismatch ? '¡Por favor ingrese contraseñas que coincidan!' : '');" type="password" oninput="check(this)" onkeypress="alfanumerico()" pattern="^[A-Z a-z 0-9 \u00E0-\u00FC À-ÿ]+$" class=" col s10 validate" name="ccontra" id="ccontra" required placeholder="Confirma tu contraseña">
                                <label for="ccontra">Confirma Nueva Contraseña</label><a id="ver2"  class="btn-floating btn-small col s2 transparent" onclick="revelarContra3()" style="text-align: center; padding: 0"><i class="material-icons black-text left">remove_red_eye</i></a>

                            </div>
                            <div class="input-field col s6 m1 l1">
                                <input value="<%out.print(direc.getN_exterior());%>" disabled type="text" onkeypress="numerico()" pattern="^[0-9]+$" class="validate" name="nex" id="nex" required placeholder="N°Exterior">
                                <label for="nex">Núm. Ext.</label>

                            </div>
                            <div class="input-field col s6 m1 l1">
                                <input value="<%out.print(cuenta.getCodigo());%>" disabled type="text" onkeypress="alfanumerico()" name="codigo" pattern="^[A-Z a-z 0-9 \u00E0-\u00FC À-ÿ]+$" class="validate" id="codigo" required placeholder="Tu Código">
                                <label for="codigo">Cod. Prod.:</label>
                            </div>
                            <div class="input-field col s12 m4 l4">
                                <input value="<%out.print(ESAPI.encoder().decodeForHTML(usua.getCorreo()));%>" disabled type="text" onkeypress="email()" name="correo" id="correo" class="validate" pattern="^(([^<>()\[\]\\.,;:\s@']+(\.[^<>()\[\]\\.,;:\s@']+)*)|('.+'))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$" required placeholder="Correo electronico">
                                <label for="correo">Email(Permanente):</label>

                            </div>

                            <div class="input-field col s6 m2 l2">
                                <input value="<%out.print(ESAPI.encoder().decodeForHTML(direc.getCalle()));%>" disabled  type="text" onkeypress="alfanumerico()" pattern="^[A-Z a-z 0-9 \u00E0-\u00FC À-ÿ]+$" class="validate" name="calle" id="calle" required placeholder="Calle">
                                <label for="calle">Calle:</label>

                            </div>
                            <div class="input-field col s12 m2 l2">
                                <input value="<%out.print(ESAPI.encoder().decodeForHTML(direc.getMunicipio()));%>" disabled type="text" onkeypress="alfanumerico()" pattern="^[A-Z a-z 0-9 \u00E0-\u00FC À-ÿ]+$" class="validate" name="municipio" id="municipio" required placeholder="Municipio">
                                <label for="municipio">Municipio:</label>
                            </div>
                            <div class="input-field col s12 m4 l4  flow-text " id="selectdisabled">
                            </div>
                            <div class="input-field col s12 m4 l4 blue-text flow-text " id="selectedenable" style="display: none">
                                <select class="flow-text" required name="estado" id="estados" >
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
                                    <option value="14">Hvaluealgo</option>
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
                                <script>
                                    function cambiaselected() {
                                        document.getElementById("estados").selectedIndex =<%out.print(direc.getId_estado());%>;
                                        document.getElementById("selectdisabled").innerHTML = document.getElementById("estados").options[<%out.print(direc.getId_estado());%>].text;
                                    }
                                </script>
                                <script>cambiaselected();</script>
                            </div>
                                  
                            <button class=" col s6 m4 l4 offset-l4 offset-m1 btn-large waves-effect blue darken-1 waves-light" id="enviar1" disabled type="submit" name="action">Cambiar
                                <i class="material-icons right">send</i>
                            </button>  <br><br><br><br><br><br><br><br><br><br><br>

                        </form>

                    </div>


                </div>
            </div>
        </div>
        <%
                } else {
                    out.println("<script>alert('Inicia sesion primero');</script>");
                    out.print("<Script>presiona2();</Script>");
                }
            }
        %>
    </body>
</html>
<!--
<div class="file-field input-field col s12 m3 l3 ">
                                    <div class="btn disabled waves-effect blue darken-1 waves-light" id="fotoperfil">
                                        <span>Nueva Foto:</span>
                                        <input  type="file">
                                    </div>
                                    <div class="file-path-wrapper">
                                        <input class="file-path validate" id="nombrearchivofoto" disabled name="foto" type="text">
                                    </div>
                                </div>
                    document.getElementById("fotoperfil").classList.remove('disabled');
