<%@page import="com.angel.impdao.impafecciones"%>
<%@page import="com.angel.dao.Iafeccionesdao"%>
<%@page import="com.angel.modelo.afecciones"%>
<%@page import="com.angel.modelo.infante"%>
<%@page import="com.angel.impdao.impinfante"%>
<%@page import="com.angel.dao.Iinfantedao"%>
<%@page import="com.angel.modelo.dispositivo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.angel.impdao.impdispositivo"%>
<%@page import="com.angel.dao.Idispositivodao"%>
<%@page import="org.owasp.esapi.ESAPI"%>
<%@page import="com.angel.impdao.impusuario"%>
<%@page import="com.angel.dao.Iusuariodao"%>
<%@page import="com.angel.modelo.usuario"%>
<%@page import="com.angel.modelo.cuenta_usuario"%>
<%@page import="com.angel.seguridad.encriptador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Angel-Gestión Infantil</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/png" href="imagenes/icono.png" />

        <link rel="shortcut icon" href="favicon.ico"> 
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link rel="stylesheet" href="css/materialize.min.css" media="screen,projection">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/css/materialize.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.1/js/materialize.min.js"></script>
        <script type="text/javascript" src="js/validaciones.js"></script>

        <style>
            body{
                background: url(imagenes/fondous4.jpg) no-repeat center center fixed;
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;      
                background-size: cover;
            }  
            .dropdown-content li>a {
                color: white !important;
            }

            tbody {
                display:block;
                height:500px;
                overflow:auto;
            }
            thead, tbody tr {
                display:table;
                width:100%;
                table-layout:fixed;
            }
            thead {
                width: calc( 100% - 1em )
            }
            table {
                width:100%;
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
            .input-field label {
                color: #2196f3!important;
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
            *::-webkit-input-placeholder {
                /* Google Chrome y Safari */
                color: #757575;
            }
            .switch label input[type=checkbox]:checked+.lever {
                background-color: #64b5f6;
            }

            .switch label input[type=checkbox]:checked+.lever:after {
                background-color: #1565c0;
            }
            ul.dropdown-content.select-dropdown li span {
                color: #03a9f4; /* no need for !important :) */
            }   
            *::-webkit-input-placeholder {
                /* Google Chrome y Safari */
                color: #757575;
            }
            .input-field input[type=date]:focus + label {
                color: black! important;
            }
            /* label underline focus color */
            .input-field input[type=date]:focus {
                border-bottom: 1px solid #0d47a1! important;
                box-shadow: 0 1px 0 0 #0d47a1 ! important;
            }

            .input-field input[type=date].invalid {
                border-bottom: 1px solid red !important;
                box-shadow: 0 1px 0 0 red!important;

            }

            .input-field input[type=date].valid {
                border-bottom: 1px solid #76ff03!important;
                box-shadow: 0 1px 0 0 #76ff03!important;
            }
            .input-field input[type=search]:focus + label {
                color: black! important;
            }
            /* label underline focus color */
            .input-field input[type=search]:focus {
                border-bottom: 1px solid #0d47a1! important;
                box-shadow: 0 1px 0 0 #0d47a1 ! important;
            }

            .input-field input[type=search].invalid {
                border-bottom: 1px solid red !important;
                box-shadow: 0 1px 0 0 red!important;

            }

            .input-field input[type=search].valid {
                border-bottom: 1px solid #76ff03!important;
                box-shadow: 0 1px 0 0 #76ff03!important;
            }
            [type="checkbox"].filled-in:checked + span:not(.lever):after {
                top: 0;
                width: 20px;
                height: 20px;
                border: 2px solid #1565c0 ;
                background-color: #90caf9 ;
                z-index: 0;
            }
        </style>

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
        %>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
        <script>
        $(document).ready(function () {
            $('.sidenav').sidenav();
            $(".dropdown-trigger").dropdown();
            $('.modal').modal();
            $('select').formSelect();


        });
        </script>
        <ul id="dropdown1" class="dropdown-content">
            <li class="blue flow-text"><a href="Home.jsp"><i class="material-icons left">home</i>Inicio</a></li>
            <li class="blue flow-text"><a href="AngelUsuario.jsp"><i class="material-icons left">edit</i>Usuario</a></li>
            <li class="blue flow-text"><a href="AngelLocalizacion.jsp"><i class="material-icons left">my_location</i>Ubicación</a></li>
            <li class="blue flow-text"><a href="badges.html"><i class="material-icons left">help</i>Ayuda</a></li>
            <li class="blue flow-text"><a href="cerrar_sesion"><i class="material-icons left">power_settings_new</i>Salir</a></li>
        </ul>
        <nav class="blue" style="z-index: 99999">
            <div class="nav-wrapper ">
                <a class="brand-logo flow-text center"><i class="material-icons t">child_friendly</i>Gestión Infantil</a>
                <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons right">menu</i></a>
                <ul class="right hide-on-med-and-down">
                    <li><a class="dropdown-trigger" href="#!" data-target="dropdown1"><i class="material-icons right">arrow_drop_down</i><i class="material-icons right">account_box</i><% out.print(ESAPI.encoder().decodeForHTML(usua.getNombre())); %></a></li>
                </ul>
            </div>
        </nav> 


        <ul class="sidenav blue" id="mobile-demo"style="margin-top: 4.5em" >
            <li class="blue white-text flow-text"><a  class="white-text"><i class="material-icons left white-text">person_pin</i><% out.print("Bienvenido: " + ESAPI.encoder().decodeForHTML(usua.getNombre()));%></a></li>
            <li class="blue white-text flow-text" ><a href="Home.jsp" class=" white-text"><i class="material-icons left white-text">home</i>Regresar a Inicio</a></li>
            <li class="blue white-text flow-text"><a href="AngelUsuario.jsp" class="white-text"><i class="material-icons left white-text">edit</i>Editar Información</a></li>
            <li class="blue white-text flow-text"><a href="AngelLocalizacion.jsp" class="white-text"><i class="material-icons left white-text">my_location</i>Localización</a></li>
            <li class="blue white-text flow-text" ><a href="badges.html" class="white-text"><i class="material-icons left white-text">help</i>Ayuda</a></li>
            <li class="blue white-text flow-text"><a href="cerrar_sesion" class="white-text"><i class="material-icons left white-text">power_settings_new</i>Cerrar Sesión</a></li>
        </ul>

        <div class="contenedor-principal">
            <div class="container">
                <div class="row">
                    <div class="responsive-table table-status-sheet"style="margin-top: 5em">
                        <table class="bordered white">
                            <thead>
                                <tr>

                                    <th class="center flow-text"><H5>Agrega aqui los datos de tus bebés</H5></th>

                                    <th class="center flow-text"> <a class=" btn modal-trigger right blue flow-tex col s12" href="#agregarcontacto">  <i class="material-icons right">group_add</i>Añadir Bebé</a>

                                        <!-- Modal Structure -->
                                        <div id="agregarcontacto" class="modal " style="margin-top: 1em">
                                            <div class="modal-content">
                                                <h4>¡Agrega un bebé!</h4>
                                                <form action="registra_infante" method="post">
                                                    <div class="input-field col s12 m3 l3">
                                                        <input placeholder="Nombre del Bebé" pattern="^[A-Za-z ]+$"  onkeypress="letras()" id="nombre" name="nombre" type="text" class="validate" required>
                                                        <label for="nombre">Nombre</label>
                                                    </div>

                                                    <div class="input-field col s12 m3 l3">
                                                        <input placeholder="Apellido P. del Bebé" pattern="^[A-Za-z ]+$" onkeypress="letras()" id="apellido_p" name="apellido_p" type="text" class="validate" required>
                                                        <label for="apellido_p">Apellido Paterno</label>
                                                    </div>
                                                    <div class="input-field col s12 m3 l3">
                                                        <input placeholder="Apellido M. del Bebé" pattern="^[A-Za-z ]+$" onkeypress="letras()" id="apellido_m" name="apellido_m" type="text" class="validate" required>
                                                        <label for="apellido_m">Apellido Materno</label>
                                                    </div>
                                                    <div class="input-field col s12 m3 l3">
                                                        <select id="dispositivo" name="dispositivo" required>
                                                            <option value="0" selected disabled>Seleccione algun dipositivo</option>
                                                            <%
                                                                Idispositivodao dispos = new impdispositivo();
                                                                ArrayList<dispositivo> libre = dispos.tredispositivosLibres(correo);
                                                                for (int i = 0; i < libre.size(); i++) {
                                                            %>
                                                            <option value="<%out.print(libre.get(i).getId_dispositivo());%>"><%out.print(libre.get(i).getId_dispositivo());%></option>
                                                            <%
                                                                }
                                                            %>
                                                        </select>
                                                    </div>
                                                    <div class="input-field col s6 m3 l3">
                                                        <input placeholder="Peso" pattern="^[0-9]+$" required onkeypress="numerico()" id="peso" name="peso" type="text" class="validate">
                                                        <label for="Peso">Peso:</label>
                                                    </div>
                                                    <div class="input-field col s6 m3 l3">
                                                        <input placeholder="Cm." id="altura" required onkeypress="numerico()" pattern="^[0-9]+$" name="altura" type="text" class="validate">
                                                        <label for="altura">Altura en cm.</label>
                                                    </div>

                                                    <div class="input-field col s6 m3 l3">
                                                        <select id="sexo" name="sexo" required>
                                                            <option value="0" selected disable>Selecciona un sexo</option>
                                                            <option value="1" >Masculino</option>
                                                            <option value="2" >Femenino</option>
                                                        </select>
                                                    </div>
                                                    <div class="input-field col s6 m3 l3">
                                                        <input id="fecha_n" required  pattern="^[0-9]+$" name="fecha_n" type="date">
                                                        <label for="fecha_n">Fecha</label>
                                                    </div>
                                                    <div class="s12" id="diagnosticodisponible">
                                                        <div class="col s6 m3 l3">
                                                            <p>
                                                                <label>
                                                                    <input type="checkbox" class="filled-in"  value="1" name="a1" id="a1" />
                                                                    <span>Asma</span>
                                                                </label>
                                                            </p>
                                                            <p>
                                                                <label>
                                                                    <input type="checkbox" class="filled-in" value="2" name="a2" id="a2" />
                                                                    <span>Fibrosis Quística</span>
                                                                </label>
                                                            </p>
                                                        </div>
                                                        <div class="col s6 m3 l3">
                                                            <p>    
                                                                <label>
                                                                    <input type="checkbox" class="filled-in" value="3" name="a3" id="a3" />
                                                                    <span>Diabetes</span>
                                                                </label>
                                                            </p>
                                                            <p>
                                                                <label>
                                                                    <input type="checkbox" class="filled-in" value="4" name="a4" id="a4" />
                                                                    <span>Hipoglucemia</span>
                                                                </label>
                                                            </p>
                                                        </div> 
                                                        <div class="col s6 m3 l3" >
                                                            <p>
                                                                <label>
                                                                    <input type="checkbox" class="filled-in" value="5" name="a5" id="a5" />
                                                                    <span>Parálisis cerebral</span>
                                                                </label>
                                                            </p>
                                                            <p>
                                                                <label>
                                                                    <input type="checkbox" class="filled-in"value="6" name="a6" id="a6" />
                                                                    <span>Autismo</span>
                                                                </label>
                                                            </p>
                                                        </div>
                                                        <div class="col s6 m3 l3" >
                                                            <p>
                                                                <label>
                                                                    <input type="checkbox" class="filled-in" value="7" name="a7" id="a7" />
                                                                    <span>Déficit de Atención</span>
                                                                </label>
                                                            </p>
                                                            <p>
                                                                <label>
                                                                    <input type="checkbox" class="filled-in" value="8" name="a8" id="a8" />
                                                                    <span>Hiperactividad</span>
                                                                </label>
                                                            </p>
                                                        </div>
                                                    </div>

                                                    <br><br><br><br><br><br><br><br><br><br><br>
                                                    <button class="btn blue" type="submit" name="action">Guardar<i class="material-icons right">save</i>
                                                    </button>

                                                </form>
                                            </div>

                                        </div></th>
                                </tr>
                                <tr>
                                <tr>
                                    <th class="hide-on-med-and-up" colspan="2">
                                        <form>
                                            <div class="input-field" style="padding: 0">
                                                <input id="search" type="search" required>
                                                <label  for="search"><i class="material-icons">search</i></label>
                                                <i class="material-icons">close</i>
                                            </div>
                                        </form>
                                    </th>
                                </tr>
                                </tr>
                            </thead>
                            <tbody id="milista">
                                <tr>
                                    <td>
                                        <ul class="collection">
                                            <%
                                                Iinfantedao control_infante = new impinfante();
                                                ArrayList<infante> lista_infantes = control_infante.treinfantes(correo);
                                                for (int i = 0; i < lista_infantes.size(); i++) {
                                                    Iafeccionesdao controla_afecciones = new impafecciones();
                                                    ArrayList<afecciones> lista_afecciones = controla_afecciones.traeafeccionesInfante(lista_infantes.get(i).getId_infante());
                                                    Idispositivodao controla_dispositivo = new impdispositivo();
                                                    dispositivo dispo = controla_dispositivo.traedispositivo(lista_infantes.get(i).getId_infante());
                                                    infante infan = lista_infantes.get(i);
                                            %>

                                            <li class="collection-item avatar">
                                                <i class="large material-icons circle blue" style="position: absolute; top: 40%;">child_friendly</i>
                                                <span class="title"><h4><%out.print(infan.getNombre());%></h4></span>
                                                <p>Bebé: <%out.print((i + 1));%></p>
                                                <p>Peso: <%out.print(infan.getPeso());%> kg.</p>
                                                <p>Estatura: <%out.print(infan.getAltura());%> cm.</p>

                                                <a class=" secondary-content btn modal-trigger blue" style="position: absolute; top: 40%;"href="#editarnumerodebebe_obtenido<%out.print((i + 1));%>"><i class="material-icons right">edit</i>Editar</a>
                                                <!-- Modal Structure -->
                                                <div id="editarnumerodebebe_obtenido<%out.print((i + 1));%>" class="modal" style="margin-top: 1em">
                                                    <div class="modal-content" style="text-align: center">
                                                        <h4 class="center">Bebé <%out.print((i + 1));%>:</h4>
                                                        <h5>Edita la información de tu bebé</h5>
                                                        <div class="switch col s12 m12 l12 ">
                                                            Editar:<br>
                                                            <label>
                                                                No
                                                                <input id="switch_numbebe_obtenido<%out.print((i + 1));%>" type="checkbox" onclick="hab_numbebe_obtenido<%out.print((i + 1));%>()">
                                                                <span class="lever"></span>
                                                                Si
                                                            </label>          
                                                        </div>
                                                        <form action="cambiar_infante" id="form<%out.print((i + 1));%>" method="post">
                                                            <div class="hide">
                                                                <input type="text" value="<%out.print(infan.getId_infante());%>" required name="infan" id="infan">
                                                            </div>
                                                            <div class="input-field col s12 m3 l3">
                                                                <input value="<%out.print(infan.getNombre());%>" disabled placeholder="Nombre del Bebé" pattern="^[A-Za-z ]+$"  onkeypress="letras()" id="nombre_numbebe_obtenido" name="nombre" type="text" class="validate" required>
                                                                <label for="nombre_numbebe_obtenido">Nombre</label>
                                                            </div>
                                                            <div class="input-field col s12 m3 l3">
                                                                <input value="<%out.print(infan.getApellido_p());%>" disabled placeholder="Apellido P. del Bebé" pattern="^[A-Za-z ]+$" onkeypress="letras()" id="apellido_p_numbebe_obtenido" name="apellido_p" type="text" class="validate" required>
                                                                <label for="apellido_p_numbebe_obtenido">Apellido Paterno</label>
                                                            </div>
                                                            <div class="input-field col s12 m3 l3">
                                                                <input value="<%out.print(infan.getApellido_m());%>" disabled placeholder="Apellido M. del Bebé" pattern="^[A-Za-z ]+$" onkeypress="letras()" id="apellido_m_numbebe_obtenido" name="apellido_m" type="text" class="validate" required>
                                                                <label for="apellido_m_numbebe_obtenido">Apellido Materno</label>
                                                            </div>
                                                            <div class="input-field col s12 m3 l3">
                                                                <select id="dispositivo" name="dispositivo" required>
                                                                    <option value="0" disabled>-Selecciona-</option>
                                                                    <option  selected value="<%out.print(dispo.getId_dispositivo());%>"><%out.print(dispo.getId_dispositivo());%></option>
                                                                    <%
                                                                        for (int j = 0; j < libre.size(); j++) {
                                                                    %>
                                                                    <option value="<%out.print(libre.get(j).getId_dispositivo());%>"><%out.print(libre.get(j).getId_dispositivo());%></option>
                                                                    <%
                                                                        }
                                                                    %>
                                                                </select>
                                                            </div>
                                                            <div class="input-field col s6 m3 l3">
                                                                <input value="<%out.print(infan.getPeso());%>" disabled placeholder="Peso" pattern="^[0-9]+$" required onkeypress="numerico()" id="peso_numbebe_obtenido" name="peso" type="text" class="validate">
                                                                <label for="Peso_numbebe_obtenido">Peso:</label>
                                                            </div>
                                                            <div class="input-field col s6 m3 l3">
                                                                <input value="<%out.print(infan.getAltura());%>" disabled placeholder="Cm." id="altura_numbebe_obtenido" required onkeypress="numerico()" pattern="^[0-9]+$" name="altura" type="text" class="validate">
                                                                <label for="altura">Altura en cm.</label>
                                                            </div>

                                                            <div class="input-field col s6 m3 l3" style="display: none" id="sexo_disponible_numbebe_obtenido<%out.print((i + 1));%>">
                                                                <select id="sexo_numbebe_obtenido"  name="sexo" required>
                                                                    <option value="0" selected disable>Selecciona un sexo</option>
                                                                    <option value="1" >Masculino</option>
                                                                    <option value="2" >Femenino</option>
                                                                </select>
                                                            </div>
                                                            <div class="col s6 m3 l3" id="sexo_indisponible__id<%out.print((i + 1));%>">
                                                                <br> Sexo: sexoobtenido
                                                            </div>
                                                            <script>
                                                                function cambiasexo<%out.print((i + 1));%>() {
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("sexo_numbebe_obtenido").selectedIndex =<%out.print(infan.getSexo());%>;
                                                                    document.getElementById("sexo_indisponible__id<%out.print((i + 1));%>").innerHTML = document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("sexo_numbebe_obtenido").options[<%out.print(infan.getSexo());%>].text;
                                                                }
                                                            </script>
                                                            <script>cambiasexo<%out.print((i + 1));%>();</script>
                                                            <div class="input-field col s6 m3 l3">
                                                                <input value="<%out.print(infan.getFecha_naci());%>" disabled id="fecha_n_numbebe_obtenido" required  pattern="^[0-9]+$" name="fecha_n" type="date">
                                                                <label for="fecha_n">Fecha</label>
                                                            </div>
                                                            <div class="s12" id="diagnosticodisponible_numbebe_obtenido<%out.print((i + 1));%>" >

                                                                <div class="col s6 m3 l3">
                                                                    <p>
                                                                        <label>
                                                                            <input type="checkbox" class="filled-in"  value="1" name="a1" id="a1" />
                                                                            <span class="flow-text">Asma</span>
                                                                        </label>
                                                                    </p>
                                                                    <p>
                                                                        <label>
                                                                            <input type="checkbox" class="filled-in" value="2" name="a2" id="a2" />
                                                                            <span class="flow-text">Fibrosis Quística</span>
                                                                        </label>
                                                                    </p>
                                                                </div>
                                                                <div class="col s6 m3 l3">
                                                                    <p>    
                                                                        <label>
                                                                            <input type="checkbox" class="filled-in" value="3" name="a3" id="a3" />
                                                                            <span class="flow-text">Diabetes</span>
                                                                        </label>
                                                                    </p>
                                                                    <p>
                                                                        <label>
                                                                            <input type="checkbox" class="filled-in" value="4" name="a4" id="a4" />
                                                                            <span class="flow-text">Hipoglucemia</span>
                                                                        </label>
                                                                    </p>
                                                                </div> 
                                                                <div class="col s6 m3 l3" >
                                                                    <p>
                                                                        <label>
                                                                            <input type="checkbox" class="filled-in" value="5" name="a5" id="a5" />
                                                                            <span class="flow-text"> Parálisis cerebral</span>
                                                                        </label>
                                                                    </p>
                                                                    <p>
                                                                        <label>
                                                                            <input type="checkbox" class="filled-in"value="6" name="a6" id="a6" />
                                                                            <span class="flow-text">Autismo</span>
                                                                        </label>
                                                                    </p>
                                                                </div>
                                                                <div class="col s6 m3 l3" >
                                                                    <p>
                                                                        <label>
                                                                            <input type="checkbox" class="filled-in" value="7" name="a7" id="a7" />
                                                                            <span class="flow-text">Déficit Atención</span>
                                                                        </label>
                                                                    </p>
                                                                    <p>
                                                                        <label>
                                                                            <input type="checkbox" class="filled-in" value="8" name="a8" id="a8" />
                                                                            <span class="flow-text">Hiperactividad</span>
                                                                        </label>
                                                                    </p>
                                                                </div>
                                                            </div>

                                                            <button class="btn blue" type="submit" disabled id="cambiar_numbebe_obtenido" name="action">Guardar<i class="material-icons right">save</i>
                                                            </button>

                                                            <div class="col s6  m6 l6 center-align" style="text-align: center">
                                                                <a class="waves-effect waves-light btn red modal-trigger" href="#dardebaja_numbebe_obtenido">Dar De Baja<i class="material-icons right">delete_forever</i>  </a>

                                                            </div>
                                                        </form>
                                                        <script>
                                                            function cambiarafec<%out.print((i + 1));%>() {
                                                            <%
                                                                for (int k = 0; k < lista_afecciones.size(); k++) {
                                                            %>
                                                                document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("a<%out.print(lista_afecciones.get(k).getId_afeccion());%>").checked = true;
                                                            <%
                                                                }
                                                            %>
                                                            }
                                                        </script>
                                                        <script>cambiarafec<%out.print((i + 1));%>();</script>
                                                        <div id="dardebaja_numbebe_obtenido" class="modal">
                                                            <div class="modal-content" style="text-align: center">
                                                                <h4>Dar de Baja</h4>
                                                                <p>¿Está seguro de eliminar este contacto?</p>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <div class="col s6">
                                                                    <a href="" class="modal-close waves-effect red waves-red btn">Cancelar</a>
                                                                </div>
                                                                <div class="col s6">
                                                                    <form method="post" action="elimina_infante">
                                                                        <div class="hide">
                                                                            <input type="text" value="<%out.print(infan.getId_infante());%>"name="infan">
                                                                        </div>
                                                                        <button class="btn green" type="submit" id="btnbaja_numbebe_obtenido" name="action">Eliminar<i class="material-icons right">check</i>
                                                                        </button>
                                                                    </form>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <script>
                                                            function hab_numbebe_obtenido<%out.print((i + 1));%>() {
                                                                if (document.getElementById('switch_numbebe_obtenido<%out.print((i + 1));%>').checked)
                                                                {
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("cambiar_numbebe_obtenido").disabled = false;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("nombre_numbebe_obtenido").disabled = false;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("apellido_p_numbebe_obtenido").disabled = false;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("apellido_m_numbebe_obtenido").disabled = false;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("peso_numbebe_obtenido").disabled = false;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("altura_numbebe_obtenido").disabled = false;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("fecha_n_numbebe_obtenido").disabled = false;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("a1").disabled = false;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("a2").disabled = false;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("a3").disabled = false;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("a3").disabled = false;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("a4").disabled = false;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("a5").disabled = false;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("a6").disabled = false;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("a7").disabled = false;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("a8").disabled = false;
                                                                    document.getElementById("sexo_disponible_numbebe_obtenido<%out.print((i + 1));%>").removeAttribute("style");
                                                                    document.getElementById("sexo_indisponible__id<%out.print((i + 1));%>").setAttribute("style", "display: none");
                                                                } else {
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("cambiar_numbebe_obtenido").disabled = true;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("nombre_numbebe_obtenido").disabled = true;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("apellido_p_numbebe_obtenido").disabled = true;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("apellido_m_numbebe_obtenido").disabled = true;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("peso_numbebe_obtenido").disabled = true;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("altura_numbebe_obtenido").disabled = true;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("fecha_n_numbebe_obtenido").disabled = true;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("a1").disabled = true;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("a2").disabled = true;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("a3").disabled = true;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("a3").disabled = true;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("a4").disabled = true;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("a5").disabled = true;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("a6").disabled = true;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("a7").disabled = true;
                                                                    document.getElementById("form<%out.print((i + 1));%>").elements.namedItem("a8").disabled = true;
                                                                    document.getElementById("sexo_disponible_numbebe_obtenido<%out.print((i + 1));%>").setAttribute("style", "display: none");
                                                                    document.getElementById("sexo_indisponible__id<%out.print((i + 1));%>").removeAttribute("style");
                                                                }


                                                            }
                                                        </script>
                                                    </div>
                                                </div>

                                            </li>

                                            <%
                                                }
                                            %>
                                        </ul>  
                                    </td>
                                </tr>

                            </tbody>
                        </table>
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

