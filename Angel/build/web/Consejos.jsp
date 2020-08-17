<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
        <script>
            document.addEventListener('DOMContentLoaded', function () {
                var elems = document.querySelectorAll('.collapsible');
                var instances = M.Collapsible.init(elems);
            });
        </script>
        <title>Consejos</title>
    </head>
    <style>
        .pin-top {
            position: relative;
        }

        .pin-bottom {
            position: relative;
        }

        .pinned {
            position: fixed !important;
        }

        body{
            background: url(imagenes/fondoangelhome.jpg) no-repeat center center fixed;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;      
            background-size: cover;
        }   
        tab a.active {
            color:#4fc3f7!important;
            background-color:#4fc3f7!important;
        }
        .tabs .tab a:hover {
            background-color: #4fc3f7!important;
            color:#FFFFFF!important;
        }
        .tabs .tab a {
            color: #FFFFFF!important;
        }
        .tabs .indicator{
            background-color:black!important;
        }
        #tarjeta{
            min-height: 50%;
            overflow: hidden;
        }
    </style>
    <body>
        <nav class="blue" style="z-index: 99999">
            <div class="nav-wrapper">
                <a href="#" class="brand-logo center"><i class="material-icons">cloud</i>Angel Security</a>
                <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons right">build</i></a>
                <ul class="right hide-on-med-and-down">
                    <li><a href="AngelUsuario.jsp"><i class="material-icons left">edit</i>Editar Información</a></li>
                    <li><a href="Consejos.jsp"><i class="material-icons right">help</i>Consejos</a></li>
                    <li><a href="badges.html"><i class="material-icons right">power_settings_new</i>Cerrar Sesión</a></li>
                </ul>
            </div>
        </nav>   
        <ul class="sidenav" id="mobile-demo">
            <li><a href="AngelUsuario.jsp"><i class="material-icons right">edit</i>Editar Información</a></li>
            <li><a href="Consejos.jsp"><i class="material-icons right">help</i>Consejos</a></li>
            <li><a href="badges.html"><i class="material-icons right">power_settings_new</i>Cerrar Sesión</a></li>
        </ul>
        <div class="row">
            <div class="col s4">
                <div class="card z-depth-5 blue lighten-4">
                    <div class="card-image waves-effect waves-block waves-light">
                        <img class="activator" src="imagenes/NarizLimpiaB.jpg">
                    </div>
                    <div class="card-content">
                        <span class="card-title activator grey-text text-darken-4">¿Cómo limpiar los orificios nasales, los ojos, los oidos, etc?<i class="material-icons right">more_vert</i></span>
                        <p><a href="https://www.youtube.com/watch?v=_mKutq4RaVg">Video Tutorial</a></p>
                    </div>
                    <div class="card-reveal blue lighten-4">
                        <span class="card-title grey-text text-darken-4">¿Cómo limpiar los orificios nasales, los ojos, los oidos, etc?<i class="material-icons right">close</i></span>
                        <p>Puedes limpiar estas partes de la cara con un algodón y con un poco de agua o de suero fisiológico, siempre desde la parte más 
                            limpia hasta la más sucia, y sólo debes pasar una vez con el algodón.<br>
                            En el caso de los oídos, evita el uso de cotonetes o bastoncillos, utiliza en su lugar algún aparato especial y sólo la parte superficial<br>
                            <a href="http://amzn.to/2jhPFPE">Puedes utilizar este producto para los oidos</a><br>
                            <a href="http://amzn.to/2i0btTm">Y puedes conseguir el suero fisiológico aquí</a></p>
                    </div>
                </div>
            </div>
            <div class="col s4">
                <div class="card z-depth-5 blue lighten-4">
                    <div class="card-image waves-effect waves-block waves-light">
                        <img class="activator" src="imagenes/BebeMano.jpg">
                    </div>
                    <div class="card-content">
                        <span class="card-title activator grey-text text-darken-4">¿Cómo reducir o cortar las uñas de los bebés?<i class="material-icons right">more_vert</i></span>
                        <p><a href="https://www.youtube.com/watch?v=-IGOcbozEK4">Video Tutorial</a></p>
                    </div>
                    <div class="card-reveal blue lighten-4">
                        <span class="card-title grey-text text-darken-4">¿Cómo reducir o cortar las uñas de los bebés?<i class="material-icons right">close</i></span>
                        <p>Hay múltiples formas para reducir las uñas de los bebés, una manera algo sencilla es limandolas cuidadosamente con una lima para bebés,
                            o si prefieres cortarlas puedes hacerlo con unas tijeras especiales de punta redonda o con corta uñas especiales para bebés.<br>
                            Si preferiste utilizar las tijeras, procura utilizarlas de forma paralela a la hora de cortar la uña con mucho cuidado de no dañar al bebé.<br>
                            Puedes aprovechar cuando el bebé está recién bañado para cortar sus uñas pues hay más posibilidades de  que se encuentre más relajado y las uñas más blandas.
                            Si el niño es muy inquieto, puedes aprovechar cuando está dormido, para evitar que se mueva.<br>
                            Procura cortar las uñas de las manos una vez por semana y las de los pies una vez al mes.<br>
                            <a href="http://amzn.to/2iL5TRN">Puedes conseguir la lima especial aquí</a><br>
                            <a href="http://amzn.to/2i0ABJP">Puedes conseguir el set corta uñas aquí</a></p>
                    </div>
                </div>
            </div>
            <div class="col s4">
                <div class="card z-depth-5 blue lighten-4">
                    <div class="card-image waves-effect waves-block waves-light">
                        <img class="activator" src="imagenes/BebeAlCien.jpg">
                    </div>
                    <div class="card-content">
                        <span class="card-title activator grey-text text-darken-4">¿Cómo se debe bañar correctamente a los bebés?<i class="material-icons right">more_vert</i></span>
                        <p><a href="https://espanol.babycenter.com/v6100022/c%C3%B3mo-ba%C3%B1ar-a-tu-reci%C3%A9n-nacido-video">Video Tutorial</a></p>
                    </div>
                    <div class="card-reveal blue lighten-4">
                        <span class="card-title grey-text text-darken-4">¿Cómo se debe bañar correctamente a los bebés?<i class="material-icons right">close</i></span>
                        <p>1. Reúne todo los artículos que necesites para el baño, toalla extendida, ropa, jabón, un pañal limpio. Asegúrate de que la temperatura de la habitación es adecuada para que no pase frio. 
                            <br><br>2. Llena la bañera con 2 ó 3 pulgadas (5 ó 7 centímetros) de agua templada, pero no caliente, a una temperatura aproximada de 90 grados Fahrenheit (32 grados centígrados).
                            <br><br>3. Trae al bebé al lugar donde vayas a bañarlo y desvístelo por completo.
                            <br><br>4. Sumerge poco a poco al bebé en el agua, usando una de tus manos para sostener su cuello y cabecita. A ratos, vierte un poco de agua con un vaso o taza de plástico sobre su cuerpo para que no se enfríe. Ten en cuenta que el cuerpecito enjabonado de un bebé es muy resbaladizo, o sea que procura sujetarlo firmemente.
                            <br><br>5. Usa muy poco jabón (ya que puede resecarle la piel) y lávale el cuerpo con tu propia mano o una toallita, rociándolo de arriba a abajo y de adelante hacia atrás. Lávale el cuero cabelludo con una toallita mojada y enjabonada. Usa una bolita de algodón mojada para limpiarle los ojitos y la cara. Lava normalmente el área genital del bebé, no requiere un lavado más a fondo que el resto. Si en las comisuras de los ojos o en la nariz se ha acumulado algún moquito o alguna secreción reseca, mójalo varias veces con la punta de una toalla para que se ablande antes de limpiarlo.
                            <br><br>6. Enjuaga completamente al bebé ayudándote con una toallita limpia.
                            <br><br>7. Envuelve a tu pequeñín en una toalla con capucha y sécalo con suavidad, sin frotarle la piel. Si tiene la piel reseca o un poquito de irritación en la zona del pañal, puedes untarle una loción hidratante para bebés.</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col s4">
                <div class="card z-depth-5 blue lighten-4">
                    <div class="card-image waves-effect waves-block waves-light">
                        <img class="activator" src="imagenes/AbrigarBB.jpg">
                    </div>
                    <div class="card-content">
                        <span class="card-title activator grey-text text-darken-4">Cómo decidir la ropa indicada en los primeros meses<i class="material-icons right">more_vert</i></span>
                    </div>
                    <div class="card-reveal blue lighten-4">
                        <span class="card-title grey-text text-darken-4">La Ropa en los Primeros Días<i class="material-icons right">close</i></span>
                        <p>Durante los primeros días es interesante tener al bebé relativamente abrigado, 
                            pues viene del útero materno donde estaba a una temperatura alta en comparación con el exterior. 
                            No pasarse, pero no ponerlo exactamente como vamos nosotros, o si va igual, tener claro que estamos en un ambiente donde no 
                            puede pasar frío. Una vez pasan los primeros días, se suele decir que hay que vestirles con una manga más que nosotros. 
                            Es una manera de explicar que tendrían que ir igual que los adultos, pero con una capita fina más, pues ellos no regulan la temperatura como nosotros y, además, 
                            no tienen la cantidad de grasa que nosotros sí tenemos y que en cierto modo nos protege (y no hablo de sobrepeso ni nada por el estilo, sino de que ellos tienen una piel muy finita y nosotros, aun delgados, no tanto).
                            Lo ideal en este sentido es tocarles la zona del cuello y la espalda. Así sabremos si están confortables o si tienen frío o calor.</p>
                    </div>
                </div>
            </div>
            <div class="col s4">
                <div class="card z-depth-5 blue lighten-4">
                    <div class="card-image waves-effect waves-block waves-light">
                        <img class="activator" src="imagenes/CarteraYDinero.jpg">
                    </div>
                    <div class="card-content">
                        <span class="card-title activator grey-text text-darken-4">Evita gastar dinero en cosas que no se necesitan<i class="material-icons right">more_vert</i></span>
                    </div>
                    <div class="card-reveal blue lighten-4">
                        <span class="card-title grey-text text-darken-4">Evita gastar dinero en cosas que no se necesitan<i class="material-icons right">close</i></span>
                        <p> Aunque no nos guste admitirlo, muchas de las cosas que compramos para un recién 
                            nacido son más caprichos de los padres que necesidades del bebé. 
                            Este necesita poco más que unos padres que le quieran y un lugar donde dormir, 
                            así que no hace falta quedarse en números rojos con tal de tenerlo todo a punto para 
                            el nacimiento. Compra las cosas que necesitas, pidelas prestadas o pedir que 
                            te las regalen, pero no llenes la casa de cachivaches que no estás seguro de 
                            que vas a utilizar o necesitar, en unos meses no te servirán para nada y no 
                            sabrás qué hacer con ellos.</p>
                    </div>
                </div>
            </div>
            <div class="col s4">
                <div class="card z-depth-5 blue lighten-4">
                    <div class="card-image waves-effect waves-block waves-light">
                        <img class="activator" src="imagenes/BebeComiendo.jpg">
                    </div>
                    <div class="card-content">
                        <span class="card-title activator grey-text text-darken-4">¿Qué alimentos le puedes dar a tu bebé?<i class="material-icons right">more_vert</i></span>
                    </div>
                    <div class="card-reveal blue lighten-4">
                        <span class="card-title grey-text text-darken-4">¿Qué alimentos le puedes dar a tu bebé?<i class="material-icons right">close</i></span>
                        <p>Leche materna: alrededor de 4 a 6 veces al día. 
                            O bien leche de fórmula: alrededor de 4 a 5 biberones de 6 a 8 onzas (178 a 237 ml) de 
                            fórmula al día. Además de: Cereales fortificados con hierro 
                            (de arroz, cebada o avena).<br>Frutas en papillas o trituradas como banana, pera, 
                            durazno (melocotón) o puré de manzana. Verduras en papillas o trituradas como 
                            aguacate, zanahorias bien cocidas, calabaza o camote (boniato).<br>
                            Carne en puré (pollo, puerco o carne de res).Pequeñas cantidades de yogur sin endulzar (pero no le des leche de vaca hasta 
                            que tenga un año) o requesón. Si te preguntas por qué estos productos lácteos se le pueden dar a 
                            un niño mucho antes que la leche de vaca (la cual no debería introducirse a la dieta del bebé hasta 
                            los 12 meses de edad), es porque los procesos de cultivo que se utilizan para fabricarlos hacen la proteína 
                            láctea más fácil de digerir y reducen las cantidades de lactosa.<br>Queso de soya 
                            (tofu).<br>Legumbres en puré como chícharos (guisantes) y lentejas. 
                            También distintos tipos de frijoles como los negros, rojos, de ojo negro y faba.</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col s4">
                    <div class="card z-depth-5 blue lighten-4">
                        <div class="card-image waves-effect waves-block waves-light">
                            <img class="activator" src="imagenes/BebeRozado.jpg">
                        </div>
                        <div class="card-content">
                            <span class="card-title activator grey-text text-darken-4">¿Qué hacer si el bebé tiene rozamiento?<i class="material-icons right">more_vert</i></span>
                            <p><a href="https://www.youtube.com/watch?v=pXQl_57CDIk">Video Tutorial</a></p>
                        </div>
                        <div class="card-reveal blue lighten-4">
                            <span class="card-title grey-text text-darken-4">¿Qué hacer si el bebé tiene rozamiento?<i class="material-icons right">close</i></span>
                            <p>Para calmarlo es muy importante limpiar y secar bien la zona. 
                                Cuanto menos productos químicos apliquemos al bebé, mejor. 
                                Se recomienda limpiar la zona con una esponja suave y jabón ph neutro, 
                                que podemos encontrar fácilmente en supermercados o farmacias. 
                                Las toallitas son un buen recurso, sobre todo fuera de casa, pero no dejan de contener muchos productos químicos.
                                Si tienes tiempo y paciencia, otra opción es elaborar nuestras propias toallitas caseras a base de agua hervida, 
                                jabón neutro, aceite de oliva virgen y vinagre de manzana (puedes encontrar en internet diferentes fórmulas de 
                                elaboración).<br>
                                Después de usar la toallita, aplica una crema protectora a base de petrolato (vaselina) y de óxido blanco de 
                                zinc (esta es más pastosa pero muy eficaz). Asimismo, igual de importante es cambiar regularmente el pañal 
                                al bebé (entre 7 y 8 veces al día). Si es posible, intenta que estas partes del cuerpo estén al aire libre 
                                el mayor tiempo posible, sin pañal.
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col s4">
                    <div class="card z-depth-5 blue lighten-4">
                        <div class="card-image waves-effect waves-block waves-light">
                            <img class="activator" src="imagenes/BebePediatra.jpg">
                        </div>
                        <div class="card-content">
                            <span class="card-title activator grey-text text-darken-4">¿Cómo elegir un buen pediatra para tu bebé?<i class="material-icons right">more_vert</i></span><br>
                        </div>
                        <div class="card-reveal blue lighten-4">
                            <span class="card-title grey-text text-darken-4">¿Cómo elegir un buen pediatra para tu bebé?<i class="material-icons right">close</i></span>
                            <p>
                                Los pediatras tienen una capacitación especial en la salud y las enfermedades de los niños 
                                hasta la adolescencia y la adultez joven, y la mayoría de ellos están certificados por el 
                                Consejo Estadounidense de Pediatría (American Board of Pediatrics), luego de aprobar un examen 
                                integral que cubre todas las áreas de la salud relacionadas con los bebés, los niños y los 
                                adultos jóvenes.<br>
                                La American Academy of Pediatrics y HealthyChildren.org pueden 
                                proporcionarle nombres de pediatras certificados por el consejo en su comunidad a través 
                                de la herramienta: Encuentre un pediatra.<br>
                                <a href="https://www.aap.org/en-us/Pages/Default.aspx">Visita la página de La American Academy of Pediatrics</a>
                                <a href="https://www.healthychildren.org/Spanish/Paginas/default.aspx">Visita HealthyChildren.org</a>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col s4">
                    <div class="card z-depth-5 blue lighten-4">
                        <div class="card-image waves-effect waves-block waves-light">
                            <img class="activator" src="imagenes/BebeMusica.jpg">
                        </div>
                        <div class="card-content">
                            <span class="card-title activator grey-text text-darken-4">¿Qué música puedes ponerle a tu bebé?<i class="material-icons right">more_vert</i></span><br>
                        </div>
                        <div class="card-reveal blue lighten-4">
                            <span class="card-title grey-text text-darken-4">¿Qué música puedes ponerle a tu bebé?<i class="material-icons right">close</i></span>
                            <p>
                                Gestación a 3 meses de vida: debe ser con la que la madre se sienta bien. Se sugiere una música suave y armónica. 
                                Las más recomendadas son la clásica y barroca, las cuales ayudan a organizar el pensamiento. 3-6 meses: música 
                                instrumental y suave en las diferentes actividades que haga el niño; excepto cuando duerme, por higiene del sueño.
                                6 a 12 meses: deben escuchar todos los géneros musicales: Desde la infantil hasta el rock. 
                                Los padres deben estar siempre  pendientes de las reacciones del bebé. 
                                Por ejemplo, si  llora cuando escucha un género, hay que cambiarlo.  18 a 36 meses: cuando el niño 
                                aprenda a seguir instrucciones se le debe poner música clásica intensa, con movimiento. Se debe jugar, 
                                saltar y bailar con él. Lo importante es que él vea que la música despierta sentimientos.36 en adelante: 
                                desde esta edad se pueden hacer cosas más complejas como cambiar la letra de las canciones. Es una buena 
                                diversión y una fortaleza para ellos, ya que les fomenta las habilidades cognitivas y emotivas.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col s4">
                    <div class="card z-depth-5 blue lighten-4">
                        <div class="card-image waves-effect waves-block waves-light">
                            <img class="activator" src="imagenes/BebeResfriado.jpg">
                        </div>
                        <div class="card-content">
                            <span class="card-title activator grey-text text-darken-4">¿Qué debes hacer si tu bebé tiene un resfriado?<i class="material-icons right">more_vert</i></span><br>
                        </div>
                        <div class="card-reveal blue lighten-4">
                            <span class="card-title grey-text text-darken-4">¿Qué debes hacer si tu bebé tiene un resfriado?<i class="material-icons right">close</i></span>
                            <p>
                                Si bien ningún medicamento logra que un virus se vaya más rápido, puedes ayudar a que tu bebé se sienta mejor 
                                e impedir que la infección empeore haciendo que descanse lo suficiente y beba líquidos en abundancia.<br>
                                Si tu bebé es menor de 6 meses, eso significa que deberá recibir suficiente leche materna o de fórmula. 
                                A los 6 meses puede además tomar un poco de agua.<br>
                                Dado que la mayoría de los niños no aprenden a sonarse la nariz hasta alrededor de los 4 años, 
                                a continuación te aconsejamos algunos métodos para aliviar la congestión nasal de tu bebé:<br>
                                <b>Usa gotas salinas y succiona. </b>Inclina hacia atrás su cabeza e introduce en los orificios nasales gotas salinas de venta sin receta médica 
                                (agua con sal) para aflojar la mucosidad. Unos minutos después, extrae el líquido y la mucosidad con un 
                                aspirador nasal (pera de goma).<br>
                                <b>Aplícale vaselina. </b>Ponle un poco de vaselina en la parte exterior de los orificios nasales para disminuir 
                                la irritación. No uses aerosoles nasales salvo que el médico esté de acuerdo. 
                                Puede que momentáneamente den resultado, pero el uso continuado también puede empeorar la congestión.<br>
                                <b> Humedece el aire.</b> Usa un humidificador o vaporizador de aire frío para humedecer el aire en su habitación. O llévalo al baño, abre el agua caliente, 
                                cierra la puerta, y permanece sentada con él por unos 15 minutos en ese ambiente lleno de vapor. Un baño tibio puede dar el mismo resultado.
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col s4">
                    <div class="card z-depth-5 blue lighten-4">
                        <div class="card-image waves-effect waves-block waves-light">
                            <img class="activator" src="imagenes/BebeEstreñido.jpg">
                        </div>
                        <div class="card-content">
                            <span class="card-title activator grey-text text-darken-4">¿Cómo saber si el bebé está estreñido?<i class="material-icons right">more_vert</i></span><br>
                        </div>
                        <div class="card-reveal blue lighten-4">
                            <span class="card-title grey-text text-darken-4">¿Cómo saber si el bebé está estreñido?<i class="material-icons right">close</i></span>
                            <p>
                                Primero que todo, considera qué es normal para tu bebé. Puede ser que tu pequeño tenga una deposición 
                                después de cada comida, o que deje pasar un día o más entre cada evacuación. El patrón individual de tu 
                                bebé dependerá de los alimentos que coma y beba, lo activo que sea, y lo rápido que digiera el alimento.<br>
                                <b>Si tu bebé toma leche de fórmula</b> o ya está comiendo alimentos sólidos, es posible que evacúe de manera regular por lo menos una vez al día.<br>
                                <b>Si tu bebé toma pecho</b>, no hay un número "normal" de evacuaciones ni un horario determinado, solo lo que es típico para él. Ten en cuenta que 
                                algunos bebés que son amamantados pueden hacer popó una vez a la semana.<br>
                                Después de un tiempo, te pondrás en sintonía con los hábitos propios de tu bebé. 
                                Si piensas que tu bebé padece de estreñimiento, hay un par de indicios que te ayudarán a confirmarlo. 
                                Entre estos se incluyen los siguientes:<br>
                            <ul><li>Sus deposiciones son menos frecuentes de lo normal, especialmente si no ha hecho caquita en tres días o más, y es obvio que tiene dificultad al evacuar. </li><br>
                                <li>Sus caquitas son duras y secas, sea cual sea la frecuencia.</li></ul>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col s4">
                    <div class="card z-depth-5 blue lighten-4">
                        <div class="card-image waves-effect waves-block waves-light">
                            <img class="activator" src="imagenes/BebeEstreñido2.jpg">
                        </div>
                        <div class="card-content">
                            <span class="card-title activator grey-text text-darken-4">¿Qué hacer si el bebé está estreñido?<i class="material-icons right">more_vert</i></span><br>
                        </div>
                        <div class="card-reveal blue lighten-4">
                            <span class="card-title grey-text text-darken-4">¿Qué hacer si el bebé está estreñido?<i class="material-icons right">close</i></span>
                            <p>
                                Primero que todo, considera qué es normal para tu bebé. Puede ser que tu pequeño tenga una deposición 
                                después de cada comida, o que deje pasar un día o más entre cada evacuación. El patrón individual de tu 
                                bebé dependerá de los alimentos que coma y beba, lo activo que sea, y lo rápido que digiera el alimento.<br>
                                <b>Si tu bebé toma leche de fórmula</b> o ya está comiendo alimentos sólidos, es posible que evacúe de manera regular por lo menos una vez al día.<br>
                                <b>Si tu bebé toma pecho</b>, no hay un número "normal" de evacuaciones ni un horario determinado, solo lo que es típico para él. Ten en cuenta que 
                                algunos bebés que son amamantados pueden hacer popó una vez a la semana.<br>
                                Después de un tiempo, te pondrás en sintonía con los hábitos propios de tu bebé. 
                                Si piensas que tu bebé padece de estreñimiento, hay un par de indicios que te ayudarán a confirmarlo. 
                                Entre estos se incluyen los siguientes:<br>
                            <ul><li>Sus deposiciones son menos frecuentes de lo normal, especialmente si no ha hecho caquita en tres días o más, y es obvio que tiene dificultad al evacuar. </li><br>
                                <li>Sus caquitas son duras y secas, sea cual sea la frecuencia.</li></ul>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col s4">
                    <div class="card z-depth-5 blue lighten-4">
                        <div class="card-image waves-effect waves-block waves-light">
                            <img class="activator" src="imagenes/BebeEnCuna.jpg">
                        </div>
                        <div class="card-content">
                            <span class="card-title activator grey-text text-darken-4">¿Cómo elegir la cuna ideal para el bebé?<i class="material-icons right">more_vert</i></span><br>
                        </div>
                        <div class="card-reveal blue lighten-4">
                            <span class="card-title grey-text text-darken-4">¿Cómo elegir la cuna ideal para el bebé?<i class="material-icons right">close</i></span>
                            <p>
                                Elegir la cuna adecuada para nuestro bebé no es tarea fácil, pues consiste en hallar el perfecto equilibrio entre la comodidad, la estética y la seguridad del niño. 
                                Veamos las pautas para saber acertar en tan importante elección y el correcto uso que se debe hacer de este mueble infantil.<br>
                                A la hora de elegir la cuna ideal, lo primero que hay que tener en cuenta es que el mueble debe cumplir con la normativa de la UE que vela por la seguridad de los muebles de ámbito infantil. 
                                Las cunas ajustadas a dicha normativa han pasado una serie de pruebas dinámicas y estáticas que testan la resistencia del mueble. 
                                La normativa vigente de la Unión Europea exige una serie de medidas para velar por la seguridad del niño.<br>
                                Así, la distancia entre barrotes debe medir entre 45 y 65 centímetros para permitir al bebé sacar su bracito pero no el torso, pues se quedaría enganchado. 
                                También está regulada la altura de los laterales y de los cabezales y la medida de las lamas del somier. 
                                La norma además recomienda poco espacio entre el colchón y los laterales y frontales de la cuna para impedir que el niño 
                                pueda meter la mano o el pie y se quede atrapado, aunque ello dificulte meter las sábanas cuando se cambia la cuna.
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col s4">
                    <div class="card z-depth-5 blue lighten-4">
                        <div class="card-image waves-effect waves-block waves-light">
                            <img class="activator" src="imagenes/BebeMuebles.jpg">
                        </div>
                        <div class="card-content">
                            <span class="card-title activator grey-text text-darken-4">Procura que los “cantos” de los muebles sean redondeados<i class="material-icons right">more_vert</i></span><br>
                        </div>
                        <div class="card-reveal blue lighten-4">
                            <span class="card-title grey-text text-darken-4">Procura que los “cantos” de los muebles sean redondeados<i class="material-icons right">close</i></span>
                            <p>
                                Para que el bebé no se pegue contra ellos, también los tornillos y piezas de sujeción deben ser 
                                imposibles de manipular por él, así como la pintura no debe ser tóxica.
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col s4">
                    <div class="card z-depth-5 blue lighten-4">
                        <div class="card-image waves-effect waves-block waves-light">
                            <img class="activator" src="imagenes/BebeChupon.jpg">
                        </div>
                        <div class="card-content">
                            <span class="card-title activator grey-text text-darken-4">¿Hasta cuando dejarle el chupete o chupón?<i class="material-icons right">more_vert</i></span><br>
                        </div>
                        <div class="card-reveal blue lighten-4">
                            <span class="card-title grey-text text-darken-4">¿Hasta cuando dejarle el chupete o chupón?<i class="material-icons right">close</i></span>
                            <p>
                                Todos los niños tienen la necesidad natural de succionar desde que nacen hasta los dos o tres años, y cada uno busca la forma de cubrir esa necesidad. 
                                Unos lo harán aún con el pecho de la madre, otros con el dedo, otros con el chupete. Si tu hijo cuenta con el chupete, a estas alturas se habrá convertido 
                                en un importante objeto de consuelo. Succionar no tiene una mera función alimenticia. La presión sobre el paladar específica de la succión ayuda al niño a 
                                calmarse y regularse frente a las dificultades que encuentra diariamente, cuando aún no tiene otras herramientas para hacerlo. Esto se ve reforzado porque 
                                el niño relaciona la succión con el cálido bienestar de los primeros contactos con mamá.<br>
                                Llega un momento en el que esta necesidad de succionar empieza a desaparecer de forma natural. A los dos años. Entre los 24 y los 36 meses. 
                                Pero no siempre es así. Algunos niños continuarán haciendo uso del chupete más allá de los 36 meses sin que ello revele un problema 
                                de fondo o tenga que suponer un futuro problema.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col s12">
                    <center>
                        <h1>
                            <b><u>Directorio</u></b>
                        </h1>
                    </center>
                </div>
            </div>
            <div class="row">
                <div class="col s12">
                    <ul class="collapsible z-depth-5">
                        <li>
                            <div class="collapsible-header blue lighten-4">Dr. Juan Miguel Quiroz González<br>Pediatra<br>Especialista en: Neonatología, Inmuno Alergología Pediátrica</div>
                            <div class="collapsible-body"><span>Av Patriotismo 671 (San Juan Mixcoac). 03730 Ciudad de México.<br>
                                    (55) 8526 6020<br>
                                    (55) 8526 6020</span></div>
                        </li>
                        <li>
                            <div class="collapsible-header blue lighten-4">Isis Adriana Moctezuma Rebollo<br>Pediatra<br></div>
                            <div class="collapsible-body"><span>Star Médica Hospital Infantil Privado - HIP (Napoles - Benito Juarez). 07300 Ciudad de México<br>
                                    0445570485208<br>
                                    11078020</span></div>
                        </li>
                        <li>
                            <div class="collapsible-header blue lighten-4">Dr. Tomás Felipe Gil Villa<br>Cirujano Pediátrico, Pediatra<br>Especialista en: Aparato Digestivo, Aparato Respiratorio, Aparato Urinario, Cirugía Endoscópica, Cirugía del Recién Nacido, Cirugía Pediátrica, Gastroenterología Pediátrica, Neonatología, Urgencias Pediátricas</div>
                            <div class="collapsible-body"><span>(Hospital Angeles Lindavista consultorio 145) Rio Bamba 639 (Magdalena de las Salinas). 07760 Ciudad de México
                                    <br>01 55 5909 9785<br>
                                        01 55 5752 9394</span></div>
                        </li>
                        <li>
                            <div class="collapsible-header blue lighten-4">Dra. Mara Nuñez Toscano<br>Hematóloga, Pediatra<br>Especialista en: Hematología Pediátrica</div>
                            <div class="collapsible-body"><span>Camino a Santa Teresa 1055 (Heroes De Padierna). 10700 Ciudad de México
                                    <br>55 5449 5500<br>
                                        55 5652 6987<br>
                                        (Urgencias)</span></div>
                        </li>
                    </ul>
                </div>
            </div>
    </body>
</html>
