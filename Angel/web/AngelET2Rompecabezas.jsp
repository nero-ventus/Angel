<%@page import="org.owasp.esapi.ESAPI"%>
<%@page import="com.angel.impdao.impusuario"%>
<%@page import="com.angel.dao.Iusuariodao"%>
<%@page import="com.angel.modelo.usuario"%>
<%@page import="com.angel.modelo.cuenta_usuario"%>
<%@page import="com.angel.seguridad.encriptador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Angel-Estimulación Temprana 1</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/png" href="imagenes/icono.png" />

        <link rel="shortcut icon" href="favicon.ico"> 
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <style>
            body{background:#1e88e5; margin:0; padding:0; font-family:Helvetica;}

            span{color:#FFF;}

            div#content{margin-top:2%;}

            div#conf{padding-bottom:1%;}

            table{border:2px solid blue; box-shadow:1px 1px 8px lightblue,-1px -1px 8px lightblue, 1px -1px 8px lightblue, -1px 1px 8px lightblue; -webkit-box-shadow:1px 1px 8px lightblue,-1px -1px 8px lightblue, 1px -1px 8px lightblue, -1px 1px 8px lightblue; border-collapse:collapse;}

            td.pieza{background:url(imagenes/rompecabezas/<%int numero; numero = (int) (Math.random() * 9) + 1; out.print(numero);%>.jpg); transition:.3s ease-in-out; -moz-transition:.3s ease-in-out; -webkit-transition:.3s ease-in-out; -o-transition:.3s ease-in-out; cursor:pointer;}

            div.posic{display: none; background:#FFF; padding:5px; border:1px solid #00e800; width:150px; position:absolute; top:70px; overflow:auto; min-height:200px; max-height:250px}


            div#titulo{color:#FFF; font-size:30px; font-weight:bold; text-shadow:1px 1px 8px lightblue , -1px -1px 8px lightblue, 1px -1px 8px lightblue, -1px 1px 8px lightblue;}

            .boton_personalizado{
                text-decoration: none;
                padding: 10px;
                font-weight: 600;
                font-size: 20px;
                color: #ffffff;
                background-color: #1883ba;
                border-radius: 6px;
                border: 2px solid #0016b0;
            }
            ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #90caf9;
            }

            li {
                float: left;

                border-right:2px solid #1e88e5;
                border-left: 2px solid #1e88e5;
            }

            li:last-child {
                border-right: none;
            }

            li a {
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            li a:hover:not(.active) {
                background-color: #90caf9;
            }

            .active {
                background-color: #90caf9;
            }
            a  {


                font-size: 200%;
            }
        </style>
        <script>

            var select = false;
            var c = "inc";
            var pos_s = "";
            var id_s = "";


            var rompecabezas = {
                _arr_pos_r: new Array(),
                _arr_pos_a: new Array(),

                _mostrar: function () {
                    rompecabezas._arr_pos_r.length = 0;
                    var piezas = rompecabezas._get("piezas").value;
                    var tb = document.createElement('table');
                    tb.border = 1;
                    tb.align = 'center';
                    tb.cellPadding = 0;
                    tb.cellSpacing = 0;
                    var dp = document.createElement('div');
                    dp.id = 'posiciones';
                    dp.className = 'posic';
                    var ar = Math.sqrt(piezas);
                    var c = 0;
                    var tam_img = 300;
                    var pos_img = tam_img / ar;
                    for (var fil = 1; fil <= ar; fil++) {
                        var tr = document.createElement('tr');
                        for (var cel = 1; cel <= ar; cel++) {
                            c++;
                            var td = document.createElement('td');
                            td.className = 'pieza';
                            td.id = 'pos_' + c;
                            td.style.width = pos_img + 'px';
                            td.style.height = pos_img + 'px';
                            var dbp = document.createElement('div');
                            dbp.id = 'val_bp_' + c;
                            var p = Math.round(((pos_img * cel) - pos_img) * -1) + 'px ' + Math.round(((fil * pos_img) - pos_img) * -1) + 'px';
                            td.style.backgroundPosition = p;
                            rompecabezas._arr_pos_r.push(p);
                            dbp.innerHTML = p;
                            dp.appendChild(dbp);
                            td.onclick = function () {
                                rompecabezas._cambiaBGP(this.id);
                                rompecabezas._compruebaFin();
                            };
                            tr.appendChild(td);
                        }
                        tb.appendChild(tr);
                    }
                    if (!rompecabezas._get("div_content")) {
                        var cont = document.createElement('div');
                        cont.id = 'div_content';
                        cont.appendChild(tb);
                        cont.appendChild(dp);
                        document.body.appendChild(cont);
                    } else {
                        rompecabezas._get("div_content").innerHTML = '';
                        rompecabezas._get("div_content").appendChild(tb);
                        rompecabezas._get("div_content").appendChild(dp);
                        rompecabezas._get("posiciones").removeClass('posic');
                        rompecabezas._get("posiciones").innerHTML = '';
                        rompecabezas._get("posiciones").className = 'posic';
                    }
                },

                _barajar: function () {
                    var num_alt = null;
                    var arr = new Array();
                    var resp = "no";
                    var i = -1;
                    var repite = "no";
                    var pie = parseInt(rompecabezas._get("piezas").value);
                    var pie1 = pie + 1;
                    while (arr.length < pie) {
                        repite = "no";
                        num_alt = Math.floor(Math.random() * pie1);
                        if (num_alt !== 0) {
                            if (arr.length === 0) {
                                i++;
                                arr[i] = num_alt;
                            } else {
                                for (j = 0; j <= arr.length - 1; j++) {
                                    if (arr[j] === num_alt) {
                                        repite = "si";
                                    }
                                }
                                if (repite !== "si") {
                                    i++;
                                    arr[i] = num_alt;
                                }
                            }
                        }
                    }

                    var id = 0;
                    for (k = 0; k <= arr.length - 1; k++) {
                        id = k - (-1);
                        rompecabezas._get("pos_" + id).style.backgroundPosition = rompecabezas._get("val_bp_" + arr[k]).innerHTML;
                    }
                },

                _cambiaBGP: function (id) {
                    if (select === false) {
                        pos_s = rompecabezas._get(id).style.backgroundPosition;
                        id_s = id;
                        select = true;
                        rompecabezas._get(id_s).style.boxShadow = '1px 1px 14px #FFF,-1px -1px 14px #FFF, 1px -1px 14px #FFF,-1px 1px 14px #FFF';
                    } else {
                        var pos_n = rompecabezas._get(id).style.backgroundPosition;
                        var id_n = id;
                        c = "com";
                        select = false;
                    }

                    if (c === "com") {
                        rompecabezas._get(id_n).style.backgroundPosition = pos_s;
                        rompecabezas._get(id_s).style.backgroundPosition = pos_n;
                        c = "inc";
                        rompecabezas._get(id_s).style.boxShadow = '';
                    }
                },

                _compruebaFin: function () {
                    var pie = parseInt(rompecabezas._get("piezas").value);
                    var fin = false;
                    rompecabezas._arr_pos_a.length = 0;
                    for (var i = 1; i <= pie; i++) {
                        rompecabezas._arr_pos_a.push(rompecabezas._get("pos_" + i).style.backgroundPosition);
                    }
                    for (var j = 0; j < rompecabezas._arr_pos_r.length; j++) {
                        if (rompecabezas._arr_pos_r[j] !== rompecabezas._arr_pos_a[j]) {
                            fin = false;
                            break;
                        } else {
                            fin = true;
                        }
                    }

                    setTimeout(function () {
                        if (fin) {
                            alert("¡Bien hecho!");
                        }
                    }, 600);
                },

                _get: function (id) {
                    return document.getElementById(id);
                }
            };


            window.onload = function () {
                rompecabezas._mostrar();
                rompecabezas._barajar();
                rompecabezas._get("piezas").onchange = function () {
                    rompecabezas._mostrar();
                };
                rompecabezas._get("barajar").onclick = function () {
                    rompecabezas._barajar();
                };
            };
            function presiona2() {
                setTimeout(function () {
                    window.location.replace('AngelLogIn.html');
                }, 0);
            }
            
                
            
        </script>
    </head>


    <body >
      

        <ul>
            <li><a class="active" href="AngelEstimulacionTemprana2.jsp"><i class="material-icons md-48">keyboard_backspace</i>Regresar</a></li>
            <li style="float:right"><a href="cerrar_sesion">Salir &nbsp;<i class="material-icons md-48">power_settings_new</i> </a></li>
        </ul>



        <div id='content' align='center'>
            <div id="titulo">Rompecabezas Interactivo</div>
            <div id='conf'>
                <span style="display: none">Nro de piezas:</span>
                <select id='piezas' style="display: none">
                    <option  value='4'>4</option>
                    <option selected value='9'>9</option>
                    <option value='16'>16</option>
                    <option value='25'>25</option>
                    <option value='36'>36</option>
                    <option value='0' disabled>..</option>
                    <option value='0' disabled>..</option>
                    <option value='100'>100</option>
                </select><input class="boton_personalizado" type='button' id='barajar' value='Revolver' />
                <div><span>Pulsa en un cuadro y luego en otro para intercambiar sus posiciones!!</span></div>
            </div>
        </div>
       
    </body>
</html>
