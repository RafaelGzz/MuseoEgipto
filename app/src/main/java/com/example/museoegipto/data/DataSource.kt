package com.example.museoegipto.data

import com.example.museoegipto.R
import com.example.museoegipto.model.AgeGroup
import com.example.museoegipto.model.Article
import com.example.museoegipto.model.MediaItem
import com.example.museoegipto.model.MediaType
import com.example.museoegipto.model.Section

object DataSource {
    fun getArticlesBySection(section: Section): List<Article> {
        return when (section) {
            Section.DAILY_LIFE -> getDailyLifeArticles(AgeGroup.ADULT)
            Section.ARCHITECTURE -> getArchitectureArticles(AgeGroup.ADULT)
            Section.ART -> getArtArticles(AgeGroup.ADULT)
        }
    }

    fun getArticlesBySection(section: Section, ageGroup: AgeGroup): List<Article> {
        return when (section) {
            Section.DAILY_LIFE -> getDailyLifeArticles(ageGroup)
            Section.ARCHITECTURE -> getArchitectureArticles(ageGroup)
            Section.ART -> getArtArticles(ageGroup)
        }
    }

    private fun getDailyLifeArticles(ageGroup: AgeGroup): List<Article> {
        return when (ageGroup) {
            AgeGroup.CHILDREN -> listOf(
                // Artículos para niños
                Article(
                    id = "daily_life_children_1",
                    title = "Todos con su Trabajo",
                    content = "En el antiguo Egipto, las personas tenían trabajos diferentes según el lugar donde vivían y qué tan importantes eran. Los faraones eran los más poderosos, porque eran los jefes del país y se pensaba que eran dioses. Los sacerdotes eran muy importantes porque cuidaban de los templos y rezaban a los dioses. Los escribas sabían escribir y leer, por lo que ayudaban a llevar las cuentas y escribir historias. Los soldados protegían al país, y los campesinos eran los que cultivaban la tierra para que todos tuvieran comida. Los esclavos, aunque no tenían mucha libertad, ayudaban a hacer trabajos muy duros. Aunque todos tenían trabajos diferentes, todos eran importantes para que el país funcione bien." +
                            "/" +
                            "Aunque las personas no podían cambiar de trabajo fácilmente, a veces podían mejorar su vida. Si un campesino aprendía a escribir, podía convertirse en escriba y tener un trabajo más importante. Cada persona sabía lo que tenía que hacer para que todo en Egipto funcione. El faraón, como el jefe del país, ayudaba a que todos siguieran las reglas para que todo estuviera en orden y en paz. Así, el país funcionaba como una gran familia, donde todos tenían un papel que hacer." +
                            "/" +
                            "La vida de las personas cambiaba según su trabajo y el lugar donde vivían. Las personas ricas vivían en grandes casas, mientras que los campesinos vivían en casas más simples. Los esclavos no podían decidir qué hacer con sus vidas y trabajaban todo el tiempo, pero también tenían que seguir las reglas del faraón y del gobierno para que todo estuviera en su lugar.",
                    images = listOf(
                        MediaItem(R.drawable.trabajos1, "", "Egipcios trabajando", MediaType.IMAGE),
                        MediaItem(R.drawable.trabajos2, "", "Egipcios trabajando", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.clase_social, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.oficios, "Los oficios en Egipto", "¿En qué trabajaban los egipcios? ¿A qué se dedicaban? En este vídeo se realiza una pequeño resumen de algunos de los trabajos que se realizaban es la época en función del estatus social.", MediaType.VIDEO),
                    ageGroup = AgeGroup.CHILDREN,
                    audioDescription = "Diferentes trabajos en el antiguo Egipto"
                ),
                Article(
                    id = "daily_life_children_2",
                    title = "El Gran Río Nilo",
                    content = "El río Nilo era el corazón de Egipto. Cada año, el Nilo se desbordaba y cubría las orillas con agua, lo que hacía que la tierra fuera muy fértil y buena para sembrar. Las personas sabían que si el Nilo se desbordaba, podían plantar semillas y obtener comida suficiente para todo el año. Las crecidas del río eran tan importantes que los egipcios organizaban su vida dependiendo de cuándo ocurrían. Sabían que si el Nilo se desbordaba mucho, las cosechas serían buenas, pero si no se desbordaba lo suficiente, podían tener problemas para conseguir comida." +
                            "/" +
                            "Además de hacer que la tierra fuera fértil, el Nilo también ayudaba a las personas a viajar. Las personas se subían a grandes barcas para ir de un lugar a otro, llevando cosas como comida, herramientas y otros productos que necesitaban. El Nilo no solo traía agua y comida, sino que también conectaba a todos los pueblos de Egipto, permitiendo que las personas intercambiaran cosas entre ellos." +
                            "/" +
                            "El Nilo era tan importante para los egipcios que pensaban que era un regalo de los dioses. Creían que Hapi, el dios de las inundaciones, era el responsable de hacer que el Nilo creciera cada año. Por eso, los egipcios celebraban grandes fiestas y hacían rituales para agradecerle a los dioses por las crecidas del río, porque sabían que gracias a eso podían tener comida durante todo el año.",
                    images = listOf(MediaItem(R.drawable.nilo, "", "Rio nilo", MediaType.IMAGE),
                        MediaItem(R.drawable.nilo2, "", "Rio nilo", MediaType.IMAGE),
                        MediaItem(R.drawable.nilo3, "", "Rio nilo", MediaType.IMAGE),
                        ),
                    audio = MediaItem(R.raw.rio, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.rio_nilo, "El Antiguo Egipto", "El Antiguo Egipto es una civilización milenaria llena de riquezas y misterios. En este vídeo, descubriremos cómo nació Egipto alrededor del río Nilo, y por qué fue tan importante este río.", MediaType.VIDEO),
                    ageGroup = AgeGroup.CHILDREN,
                    audioDescription = "El río Nilo y su importancia"
                ),
                Article(
                    id = "daily_life_children_3",
                    title = "Muchos Dioses",
                    content = "La religión era muy importante para los egipcios. Creían en muchos dioses, y cada uno de esos dioses tenía un poder especial. Por ejemplo, Ra era el dios del sol, y Osiris era el dios de la vida después de la muerte. Los egipcios pensaban que si hacían oraciones y ofrecían regalos a los dioses, estos les ayudarían a vivir mejor. Por eso, cada casa tenía un altar para rezar y dar ofrendas a los dioses. Además, había grandes templos donde los sacerdotes cuidaban de las estatuas de los dioses y hacían ceremonias." +
                            "/" +
                            "Los egipcios pensaban que los dioses podían ayudarlos a tener buena salud, buena cosecha y una vida feliz. Cada día, las personas empezaban su jornada rezando y pidiendo protección. También, cuando algo importante sucedía, como una victoria en la guerra o el nacimiento de un niño, celebraban con grandes fiestas y ofrecían comida a los dioses. Los sacerdotes eran los encargados de dirigir estas celebraciones y de asegurarse de que todo se hiciera correctamente." +
                            "/" +
                            "Los egipcios también creían que, cuando morían, sus almas iban a un lugar especial llamado el \"más allá\". Allí, debían pasar por pruebas para demostrar que habían vivido bien. Para asegurarse de que sus almas llegaran bien al más allá, las personas construían tumbas y les ponían cosas que necesitarían después de morir, como comida, ropa y joyas. Todo esto era parte de cómo los egipcios mantenían su relación con los dioses y cómo se preparaban para la vida después de la muerte.",
                    images = listOf(
                        MediaItem(R.drawable.religion, "", "Dioses egipcios", MediaType.IMAGE),
                        MediaItem(R.drawable.religion2, "", "Dioses egipcios", MediaType.IMAGE),
                        MediaItem(R.drawable.religion3, "", "Dioses egipcios", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.religiosa, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.dioses,  "Los dioses egipcios", "Draw My Life de sus principales dioses.", MediaType.VIDEO),
                    ageGroup = AgeGroup.CHILDREN,
                    audioDescription = "Los dioses egipcios y los amuletos"
                ),
                Article(
                    id = "daily_life_children_4",
                    title = "Mujeres Importantes",
                    content = "Aunque Egipto era un país donde los hombres tenían más poder, las mujeres podían hacer muchas cosas. Por ejemplo, algunas mujeres podían ser dueñas de negocios, y otras heredaban tierras de sus padres. Aunque no tenían tanto poder como los hombres, las mujeres eran muy importantes en la casa y en la familia. Tenían muchas responsabilidades, como cuidar de los niños, preparar la comida y asegurarse de que la casa estuviera ordenada. También, algunas mujeres de familias ricas o poderosas llegaban a ser faraonas, como Hatshepsut, quien gobernó Egipto y fue muy respetada." +
                            "/" +
                            "Las mujeres también podían casarse, y cuando lo hacían, tenían derecho a escoger con quién querían estar. En Egipto, el matrimonio no solo era para tener hijos, sino también para crear una familia feliz. Aunque la vida de las mujeres estaba más centrada en la casa, ellas eran muy importantes para mantener el equilibrio de la familia y la sociedad. Además, las mujeres podían ser muy sabias y tener conocimientos en medicina, agricultura o incluso en escribir y leer, aunque eso era menos común." +
                            "/" +
                            "Las mujeres egipcias, aunque no eran consideradas tan poderosas como los hombres, tenían una vida más libre y con más derechos que en otros lugares del mundo antiguo. Se les permitía tener tierras, trabajar y tomar decisiones importantes dentro de la familia. De esta manera, las mujeres desempeñaban un papel fundamental en la vida cotidiana y en el bienestar de Egipto.",
                    images = listOf(
                        MediaItem(R.drawable.mujeres1, "", "Mujeres egipcias", MediaType.IMAGE),
                        MediaItem(R.drawable.mujeres2, "", "Mujeres egipcias", MediaType.IMAGE),
                        ),
                    audio = MediaItem(R.raw.mujer, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.mujeres,  "Mujeres en Antiguo Egipto", "Cómo vivían las MUJERES en el ANTIGUO EGIPTO", MediaType.VIDEO),
                    ageGroup = AgeGroup.CHILDREN,
                    audioDescription = "El papel de las mujeres en el antiguo Egipto"
                ),
                Article(
                    id = "daily_life_children_5",
                    title = "Fiestas y Diversión",
                    content = "Cuando los egipcios no estaban trabajando, les gustaba divertirse. A los niños les encantaba jugar a juegos de mesa, y uno de los más populares era el senet. Este juego era muy parecido a un juego de carrera, y se pensaba que representaba el viaje de las almas al más allá. Además de los juegos, la gente disfrutaba mucho de la música y el baile. Los egipcios tocaban instrumentos como el laúd, el tambor y la flauta. A menudo, las mujeres bailaban durante las fiestas y las celebraciones, haciendo que todo fuera más divertido." +
                            "/" +
                            "Las fiestas eran una gran parte de la vida en Egipto. Estas celebraciones no solo eran para divertirse, sino también para agradecer a los dioses. Durante las fiestas, las personas comían, bebían y cantaban canciones en honor a los dioses. A veces, las fiestas también marcaban eventos importantes, como el nacimiento de un hijo o el éxito en una batalla. Las ciudades se llenaban de música, baile y risas, y todos se unían para compartir la alegría." +
                            "/" +
                            "Las grandes fiestas religiosas eran una de las ocasiones más esperadas del año. Durante estos eventos, el pueblo entero se reunía para celebrar y mostrar su agradecimiento a los dioses. Había comida deliciosa, música en vivo y mucha diversión. Estas festividades también ayudaban a las personas a sentirse unidas y a recordar lo importante que era vivir en armonía con los dioses y entre ellos mismos.",
                    images = listOf(MediaItem(R.drawable.fiesta1, "", "Fiesta egipcia", MediaType.IMAGE),
                        MediaItem(R.drawable.fiesta2, "", "Fiesta egipcia", MediaType.IMAGE),
                        MediaItem(R.drawable.fiesta3, "", "Fiesta egipcia", MediaType.IMAGE),),
                    audio = MediaItem(R.raw.fiesta, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.fiestas,  "Fiestas y celebraciones en Antiguo Egipto", "Narramos las fiestas y celebraciones del Antiguo Egipto, donde grandiosos festivales, procesiones y rituales formaban parte esencial de la vida diaria.", MediaType.VIDEO),
                    ageGroup = AgeGroup.CHILDREN,
                    audioDescription = "Entretenimientos y festividades egipcias"
                ))

            AgeGroup.TEEN -> listOf(
                // Artículos para adolescentes
                Article(
                    id = "daily_life_teen_1",
                    title = "Clases Sociales",
                    content = "En el antiguo Egipto, la sociedad estaba estrictamente jerarquizada. En la cúspide de esta estructura social se encontraba el faraón, el líder absoluto del país, quien además era considerado un dios viviente. Junto a él, los sacerdotes y nobles desempeñaban roles administrativos y religiosos, controlando los templos y las riquezas del país. Los escribas eran altamente respetados debido a su habilidad para leer y escribir, una destreza indispensable para la administración del gobierno. En el siguiente nivel se encontraban los soldados, que protegían las fronteras y mantenían el orden. En la base de la pirámide social estaban los campesinos, quienes trabajaban la tierra para producir alimentos, y los esclavos, que realizaban las tareas más duras. Aunque sus roles variaban, todos desempeñaban un papel esencial para el funcionamiento de Egipto, y el orden social era visto como un reflejo del orden divino." +
                            "/" +
                            "El sistema social egipcio era rígido, pero permitía cierta movilidad. Por ejemplo, un campesino podía ascender a escriba si demostraba talento en la escritura y la lectura. Sin embargo, las diferencias entre las clases eran evidentes, y cada persona nacía con un destino determinado por su posición en esta jerarquía. El faraón era considerado el intermediario entre los dioses y los humanos, lo que le otorgaba un poder absoluto. Esta organización ayudaba a mantener el equilibrio y la estabilidad, que eran esenciales para la prosperidad del reino. La estructura social también se reflejaba en las costumbres, las leyes y la educación, que estaban diseñadas para asegurar que todos cumpliera con su rol y respetara el orden establecido." +
                            "/" +
                            "A lo largo de la vida diaria, las divisiones sociales influían en las interacciones entre las personas. Por ejemplo, los ricos y los nobles vivían en grandes casas con jardines y tenían acceso a comida y bienes lujosos. Los campesinos vivían en viviendas más sencillas, a menudo hechas de adobe, y su dieta se basaba principalmente en pan, cebada y vegetales. Los esclavos, por su parte, no tenían ningún derecho personal y trabajaban en las mansiones de los ricos o en los grandes proyectos de construcción, como templos y pirámides. Esta estructura jerárquica mantenía el orden en la sociedad egipcia, pero también garantizaba que cada clase tuviera un rol importante en la economía y la vida cotidiana.",
                    images = listOf(
                        MediaItem(R.drawable.trabajos1, "", "Egipcios trabajando", MediaType.IMAGE),
                        MediaItem(R.drawable.trabajos2, "", "Egipcios trabajando", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.clase_social, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.clases_sociales, "Clases sociales del antiguo egipto", "Clases sociales del antiguo egipto", MediaType.VIDEO),
                    ageGroup = AgeGroup.TEEN,
                    audioDescription = "Estructura social egipcia"
                ),
                Article(
                    id = "daily_life_teen_2",
                    title = "El Nilo y la Agricultura",
                    content = "El río Nilo era la columna vertebral de la civilización egipcia. Sin él, Egipto no hubiera podido prosperar. Cada año, el Nilo inundaba sus orillas, un fenómeno conocido como la \"inundación del Nilo\". Estas crecidas depositaban una capa de limo rico en nutrientes que hacía que la tierra fuera extremadamente fértil. La agricultura, por lo tanto, dependía directamente de este ciclo, y las personas organizaban su vida en torno a las estaciones del río. La siembra y la cosecha se alineaban con las crecidas, y las familias campesinas vivían de lo que el Nilo les proporcionaba. Este fenómeno no solo aseguraba la producción de alimentos para el pueblo, sino que también permitía que Egipto fuera autosuficiente, un factor clave para su estabilidad." +
                            "/" +
                            "El río Nilo no solo era esencial para la agricultura, sino que también era el principal medio de transporte. Las personas se desplazaban en barcas para llevar los productos de la tierra hasta las ciudades y mercados. Los egipcios construyeron impresionantes embarcaciones que les permitían viajar por todo el valle del Nilo, conectando las diferentes regiones del país. Las crecidas del río también marcaban el calendario egipcio, dividiendo el año en tres estaciones: la inundación, la siembra y la cosecha. Durante la inundación, los campesinos no podían trabajar la tierra, por lo que se dedicaban a la construcción de templos, pirámides o a realizar tareas administrativas y de organización." +
                            "/" +
                            "El Nilo también tenía una dimensión espiritual para los egipcios. Lo consideraban un regalo de los dioses, y su crecida era vista como un símbolo de la fertilidad y la renovación. Los egipcios celebraban el ciclo del Nilo con rituales y festivales en honor a Hapi, el dios de las inundaciones, para asegurarse de que las crecidas fueran lo suficientemente fuertes como para fertilizar la tierra. Además, el río era esencial para el comercio, permitiendo a Egipto establecer intercambios con otras civilizaciones del Mediterráneo y del África subsahariana. Sin el Nilo, Egipto no habría sido capaz de mantener su poder y su estabilidad a lo largo de los siglos.",
                    images = listOf(MediaItem(R.drawable.nilo, "", "Rio nilo", MediaType.IMAGE),
                        MediaItem(R.drawable.nilo2, "", "Rio nilo", MediaType.IMAGE),
                        MediaItem(R.drawable.nilo3, "", "Rio nilo", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.rio, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.rio_nilo_2, "Importancia del rio nilo", "Una estrecha franja verde en medio del interminable desierto: El Nilo, la arteria vital de Egipto. Sus aguas transforman suelo sediento en productivas tierras de cultivo y las casas emergen de su lodo. ¿Cómo comenzó la importancia de este gran río?", MediaType.VIDEO),
                    ageGroup = AgeGroup.TEEN,
                    audioDescription = "El ciclo del Nilo y la agricultura"
                ),
                Article(
                    id = "daily_life_teen_3",
                    title = "Vida Religiosa",
                    content = "La religión egipcia estaba profundamente integrada en cada aspecto de la vida. Los egipcios eran politeístas, es decir, creían en muchos dioses, cada uno responsable de diferentes aspectos del mundo natural y humano. Estos dioses no solo representaban conceptos abstractos, como la justicia o el sol, sino que también se manifestaban en fenómenos naturales como el río Nilo, las estrellas y las cosechas. La vida diaria de los egipcios giraba en torno a la devoción a sus deidades, y cada hogar tenía pequeños altares donde realizaban rituales y ofrendas. Además, los templos, que eran considerados las casas de los dioses en la tierra, eran lugares sagrados donde se realizaban oraciones y sacrificios para asegurar la protección divina." +
                            "/" +
                            "Los egipcios creían que los dioses influían directamente en todos los aspectos de su existencia, desde la salud hasta la prosperidad. Los rituales y las oraciones eran una forma de mantener el equilibrio entre el mundo humano y el divino. Cada día comenzaba con oraciones y ofrendas a los dioses, y en ocasiones especiales se realizaban grandes festivales en su honor. Estos rituales eran dirigidos por los sacerdotes, quienes ocupaban una posición muy respetada en la sociedad. Ellos no solo cuidaban de los templos y realizaban ceremonias, sino que también actuaban como consejeros del faraón, guiando sus decisiones políticas y religiosas." +
                            "/" +
                            "La creencia en la vida después de la muerte también era central para la religión egipcia. Los egipcios pensaban que la vida no terminaba con la muerte, sino que continuaba en un \"más allá\", donde las almas debían pasar una serie de pruebas antes de alcanzar la inmortalidad. Por esta razón, la preparación para la muerte era una parte importante de la vida cotidiana, y muchas personas, especialmente los ricos, construían tumbas y mausoleos adornados con rituales y ofrendas para asegurar su bienestar en la vida después de la muerte. El culto a los dioses y los rituales funerarios ayudaban a mantener el orden cósmico y a garantizar que la sociedad continuara prosperando.",
                    images = listOf(
                        MediaItem(R.drawable.religion, "", "Dioses egipcios", MediaType.IMAGE),
                        MediaItem(R.drawable.religion2, "", "Dioses egipcios", MediaType.IMAGE),
                        MediaItem(R.drawable.religion3, "", "Dioses egipcios", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.religiosa, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.religion, "Religion egipcia", "Draw my life de la religion egipcia", MediaType.VIDEO),
                    ageGroup = AgeGroup.TEEN,
                    audioDescription = "Prácticas religiosas cotidianas"
                ),
                Article(
                    id = "daily_life_teen_4",
                    title = "El Rol de la Mujer",
                    content = "A pesar de que la sociedad egipcia era patriarcal, las mujeres gozaban de más derechos y libertades que en otras culturas de la misma época. Aunque las mujeres no tenían el mismo poder que los hombres, podían poseer propiedades, heredar tierras y participar activamente en la vida económica del hogar. Muchas mujeres trabajaban como comerciantes, administradoras de fincas o artesanas, y algunas incluso desempeñaban roles de liderazgo en el ámbito religioso o político. Por ejemplo, algunas mujeres de la nobleza llegaron a ser faraonas, como Hatshepsut, quien gobernó Egipto con gran éxito y dejó un legado importante en la historia egipcia." +
                            "/" +
                            "Además, las mujeres egipcias eran responsables de la gestión del hogar, incluyendo la crianza de los hijos, la preparación de alimentos y la administración de los bienes familiares. Aunque las tareas domésticas eran consideradas \"propias\" de las mujeres, también jugaban un papel crucial en la estabilidad económica de la familia. Las mujeres tenían la libertad de casarse cuando lo desearan, y aunque generalmente se casaban jóvenes, el matrimonio en Egipto se basaba en la elección personal y la compatibilidad. El amor y el respeto mutuo entre esposos era un valor muy importante, y las mujeres gozaban de un estatus relativamente alto en comparación con otras civilizaciones contemporáneas." +
                            "/" +
                            "El matrimonio y la maternidad eran vistos como responsabilidades divinas, y las mujeres jugaban un papel fundamental en la transmisión de la cultura y las tradiciones familiares. A menudo se les atribuía el poder de mantener la armonía en el hogar, y su influencia en la vida social y religiosa era significativa. Sin embargo, aunque las mujeres podían gozar de una cierta independencia, la mayoría de las decisiones importantes, especialmente las políticas y militares, recaían en los hombres. A pesar de ello, las mujeres egipcias tuvieron un impacto duradero en la historia, especialmente aquellas que lograron destacarse en áreas como la política, la religión y la administración.",
                    images = listOf(
                        MediaItem(R.drawable.mujeres1, "", "Mujeres egipcias", MediaType.IMAGE),
                        MediaItem(R.drawable.mujeres2, "", "Mujeres egipcias", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.mujer, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.mujeres,  "Mujeres en Antiguo Egipto", "Cómo vivían las MUJERES en el ANTIGUO EGIPTO", MediaType.VIDEO),
                    ageGroup = AgeGroup.TEEN,
                    audioDescription = "Derechos y roles de las mujeres"
                ),
                Article(
                    id = "daily_life_teen_5",
                    title = "Ocio y Entretenimiento",
                    content = "El entretenimiento y el ocio eran una parte importante de la vida en el antiguo Egipto, especialmente después de las largas jornadas de trabajo en el campo o en la construcción. A los egipcios les gustaba jugar a juegos de mesa, y uno de los más populares era el senet, un juego de estrategia que simbolizaba el viaje del alma en la vida después de la muerte. Los egipcios también disfrutaban de actividades al aire libre, como las competiciones deportivas, que incluían carreras, luchas y juegos con pelota. Estas actividades no solo servían como forma de recreación, sino que también eran vistas como una forma de mantener el cuerpo en forma y la mente aguda." +
                            "/" +
                            "Además de los juegos, la música y la danza eran elementos esenciales de la vida social egipcia. Las fiestas eran comunes en las casas de los ricos, y a menudo se realizaban en honor a los dioses o para celebrar eventos importantes, como los nacimientos o las victorias militares. Durante estas festividades, los egipcios disfrutaban de comida, vino, música y danza. La música en Egipto era muy variada, y los músicos tocaban instrumentos como el laúd, el arpa, los tambores y las flautas. La danza era igualmente popular, y las mujeres solían bailar en las fiestas, mientras que los hombres competían en danzas más energéticas durante las celebraciones." +
                            "/" +
                            "Las grandes fiestas religiosas también eran ocasiones para reunirse y celebrar en comunidad. Durante los festivales, las ciudades se llenaban de música, danzas y ofrendas, y el pueblo se unía para rendir homenaje a los dioses. Estos festivales no solo eran momentos de recreación, sino también de reafirmación de la fe y la unidad social. Las fiestas religiosas estaban ligadas a las estaciones del Nilo, y las personas celebraban la abundancia del río con comidas, cantos y danzas. El entretenimiento, por tanto, no solo era una forma de relajación, sino también una forma de conectar con la espiritualidad y las tradiciones de la cultura egipcia.",
                    images = listOf(MediaItem(R.drawable.fiesta1, "", "Fiesta egipcia", MediaType.IMAGE),
                        MediaItem(R.drawable.fiesta2, "", "Fiesta egipcia", MediaType.IMAGE),
                        MediaItem(R.drawable.fiesta3, "", "Fiesta egipcia", MediaType.IMAGE),),
                    audio = MediaItem(R.raw.fiesta, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.fiestas,  "Fiestas y celebraciones en Antiguo Egipto", "Narramos las fiestas y celebraciones del Antiguo Egipto, donde grandiosos festivales, procesiones y rituales formaban parte esencial de la vida diaria.", MediaType.VIDEO),
                    ageGroup = AgeGroup.TEEN,
                    audioDescription = "Actividades recreativas y festivales"
                ))

            AgeGroup.ADULT -> listOf(
                // Artículos para adultos
                Article(
                    id = "daily_life_adult_1",
                    title = "Jerarquía Social",
                    content = "El sistema social egipcio era rígido y profundamente estructurado. En la cúspide se encontraba el faraón, considerado no solo un monarca, sino una encarnación viviente del dios Horus. Su rol era mantener el \"maat\", el equilibrio cósmico, y su autoridad se extendía sobre la religión, la ley, el ejército y la economía. Por debajo de él, una clase dominante de nobles y altos funcionarios aseguraba la administración del país." +
                            "/" +
                            "Los sacerdotes tenían un papel crítico en la conexión con lo divino. Administraban templos, realizaban rituales complejos y poseían grandes extensiones de tierra y recursos. A su lado, los escribas eran esenciales: dominaban la escritura jeroglífica y jerática, y llevaban los registros administrativos, fiscales y legales. Ser escriba era una posición codiciada, generalmente reservada para varones que pasaban años en escuelas especializadas." +
                            "/" +
                            "La mayoría de la población eran campesinos y trabajadores que sustentaban la economía agrícola. Cultivaban el trigo, la cebada y el lino a lo largo del Nilo, y sus labores estaban profundamente marcadas por el calendario de inundaciones. Por debajo de ellos estaban los esclavos, que eran prisioneros de guerra o personas en servidumbre. Aunque su situación era dura, algunos podían ascender socialmente si eran liberados o lograban educarse.",
                    images = listOf(
                        MediaItem(R.drawable.trabajos1, "", "Egipcios trabajando", MediaType.IMAGE),
                        MediaItem(R.drawable.trabajos2, "", "Egipcios trabajando", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.clase_social, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.clases_sociales, "Clases sociales del antiguo egipto", "Clases sociales del antiguo egipto", MediaType.VIDEO),
                    ageGroup = AgeGroup.ADULT,
                    audioDescription = "Sistema jerárquico social y sus implicaciones"
                ),
                Article(
                    id = "daily_life_adult_2",
                    title = "El Nilo y la Economía",
                    content = "El Nilo no era solo una fuente de agua; era la arteria vital de todo Egipto. Su comportamiento anual, con inundaciones regulares entre julio y octubre, fertilizaba la tierra con un limo rico que permitía múltiples cosechas al año. Los egipcios aprendieron a adaptar su calendario civil a este ciclo natural, y su economía entera giraba en torno a la previsibilidad del río." +
                            "/" +
                            "Gracias al Nilo, los egipcios desarrollaron una compleja red de canales, diques y norias para distribuir el agua a los campos. Las técnicas de riego y la observación astronómica estaban íntimamente ligadas, y permitían planificar con precisión los tiempos de siembra y recolección. Los graneros del Estado almacenaban excedentes que luego eran usados para alimentar al ejército, pagar salarios en especie y sostener el aparato administrativo." +
                            "/" +
                            "Además de su función agrícola, el Nilo era una autopista fluvial. Barcos de juncos o madera transportaban personas, materiales y bienes desde el Alto Egipto hasta el Delta. El comercio interno y externo floreció gracias a esta vía, facilitando el intercambio de oro, papiro, lino, vino, resina, y piedras preciosas. Incluso el transporte funerario de momias y estatuas sagradas dependía del flujo del río, reforzando su valor ritual y económico.",
                    images = listOf(MediaItem(R.drawable.nilo, "", "Rio nilo", MediaType.IMAGE),
                        MediaItem(R.drawable.nilo2, "", "Rio nilo", MediaType.IMAGE),
                        MediaItem(R.drawable.nilo3, "", "Rio nilo", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.rio, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.rio_nilo_2, "El Río Nilo: La Cuna de la Civilización Egipcia", "El Río Nilo: La Cuna de la Civilización Egipcia", MediaType.VIDEO),
                    ageGroup = AgeGroup.ADULT,
                    audioDescription = "Impacto económico y agrícola del Nilo"
                ),
                Article(
                    id = "daily_life_adult_3",
                    title = "Religiosidad Cotidiana",
                    content = "La cosmovisión egipcia integraba lo divino en cada faceta de la existencia. Desde el momento del nacimiento hasta la muerte, la religión guiaba las decisiones, comportamientos y expectativas de las personas. Los hogares contaban con altares domésticos donde se rendía culto a deidades protectoras como Bes o Taweret. Incluso las tareas cotidianas como cocinar o bañarse estaban acompañadas de gestos rituales o plegarias breves." +
                            "/" +
                            "En el plano público, los templos eran centros de poder tanto espiritual como económico. Los sacerdotes no solo oficiaban rituales, sino que administraban tierras, organizaban festivales y conservaban conocimientos científicos y médicos. Los dioses egipcios, como Ra, Osiris, Isis o Anubis, no eran abstractos ni lejanos; se creía que influían activamente en el día a día, y había un dios o diosa para casi cada necesidad, profesión o enfermedad." +
                            "/" +
                            "Los amuletos, las ofrendas y las fórmulas mágicas eran utilizados por todos los estratos sociales. Incluso los más pobres intentaban acceder a servicios religiosos básicos para asegurar protección y fortuna. Este entrelazamiento entre lo espiritual y lo práctico cimentó una cultura donde lo visible y lo invisible coexistían como una sola realidad.",
                    images = listOf(
                        MediaItem(R.drawable.religion, "", "Dioses egipcios", MediaType.IMAGE),
                        MediaItem(R.drawable.religion2, "", "Dioses egipcios", MediaType.IMAGE),
                        MediaItem(R.drawable.religion3, "", "Dioses egipcios", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.religiosa, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.religion, "Religion egipcia", "Draw my life de la religion egipcia", MediaType.VIDEO),
                    ageGroup = AgeGroup.ADULT,
                    audioDescription = "Impacto de la religión en la vida diaria"
                ),
                Article(
                    id = "daily_life_adult_4",
                    title = "Derechos de la Mujer",
                    content = "A diferencia de muchas civilizaciones contemporáneas, las mujeres egipcias tenían una sorprendente autonomía legal. Podían poseer propiedades, heredar tierras, redactar testamentos y participar en litigios. En los registros se conservan contratos firmados por mujeres en los que venden, compran o alquilan bienes. Esta libertad no era exclusiva de la élite, aunque evidentemente las clases altas tenían mayores posibilidades de ejercerla." +
                            "/" +
                            "Socialmente, las mujeres desempeñaban roles cruciales en la vida doméstica y en la economía local. Muchas eran comerciantes, tejedoras, parteras o músicas. También podían trabajar como sacerdotisas en templos femeninos o participar en rituales sagrados. La maternidad era altamente valorada, y la figura de la madre estaba estrechamente ligada al concepto de fertilidad y protección espiritual, como lo ejemplifica la diosa Isis." +
                            "/" +
                            "Sin embargo, la igualdad no era absoluta. Las funciones políticas, militares y religiosas de alto rango estaban reservadas casi exclusivamente a los hombres, aunque hubo excepciones notables como la faraona Hatshepsut. En la vida cotidiana, las mujeres eran respetadas por su papel en la transmisión cultural y espiritual, y su representación en el arte demuestra tanto su importancia como su dignidad.",
                    images = listOf(
                        MediaItem(R.drawable.mujeres1, "", "Mujeres egipcias", MediaType.IMAGE),
                        MediaItem(R.drawable.mujeres2, "", "Mujeres egipcias", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.mujer, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.mujeres, "Mujeres en Antiguo Egipto", "Cómo vivían las MUJERES en el ANTIGUO EGIPTO", MediaType.VIDEO),
                    ageGroup = AgeGroup.ADULT,
                    audioDescription = "Posición social y legal de las mujeres"
                ),
                Article(
                    id = "daily_life_adult_5",
                    title = "Ocio y Vida Social",
                    content = "La vida egipcia no era únicamente trabajo y religión. El entretenimiento era una parte esencial del equilibrio emocional y social. La música tenía un papel protagónico: se utilizaban arpas, laúdes, flautas y sistros en fiestas, ceremonias y momentos privados. La danza, ejecutada por profesionales o incluso por miembros de la familia, acompañaba muchos eventos importantes, desde nacimientos hasta funerales." +
                            "/" +
                            "Los juegos de mesa eran especialmente populares, siendo el senet el más famoso. Este juego simbólico representaba el viaje del alma al más allá, pero también servía para el ocio familiar. Los niños jugaban con muñecos articulados, pelotas y figuras de animales, mientras que los adultos disfrutaban de competencias de fuerza, festividades locales y obras teatrales rituales." +
                            "/" +
                            "Las celebraciones religiosas eran ocasiones de unión comunitaria. Durante festivales como el de Opet o el Valle Hermoso, la población participaba en procesiones, banquetes públicos y representaciones rituales. La cerveza y el vino fluían en abundancia, y el ambiente se llenaba de música y alegría. Estas actividades no solo servían para descansar, sino también para reforzar la cohesión social y espiritual.",
                    images = listOf(MediaItem(R.drawable.fiesta1, "", "Fiesta egipcia", MediaType.IMAGE),
                        MediaItem(R.drawable.fiesta2, "", "Fiesta egipcia", MediaType.IMAGE),
                        MediaItem(R.drawable.fiesta3, "", "Fiesta egipcia", MediaType.IMAGE),),
                    audio = MediaItem(R.raw.fiesta, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.fiestas, "Fiestas y celebraciones en Antiguo Egipto", "Narramos las fiestas y celebraciones del Antiguo Egipto, donde grandiosos festivales, procesiones y rituales formaban parte esencial de la vida diaria.", MediaType.VIDEO),
                    ageGroup = AgeGroup.ADULT,
                    audioDescription = "Entretenimiento y cohesión social"
                ))
        }
    }

    private fun getArchitectureArticles(ageGroup: AgeGroup): List<Article> {
        return when (ageGroup) {
            AgeGroup.CHILDREN -> listOf(
                // Artículos para niños
                Article(
                    id = "architecture_children_1",
                    title = "Construcciones para Dioses y Reyes",
                    content = "Los egipcios querían que sus dioses y faraones tuvieran casas impresionantes, por eso construían templos y tumbas enormes. Pensaban que cuanto más grande fuera el edificio, más cerca estarían del cielo. ¡Algunos eran tan altos que parecían tocar las nubes!/" +
                            "/" +
                            "Estas construcciones no solo eran grandes, también eran muy especiales. Tenían formas únicas y estaban llenas de símbolos que contaban historias. Para ellos, construir algo hermoso era una forma de mostrar respeto y amor a sus dioses y reyes." +
                            "/" +
                            "Además, creían que los edificios podían ayudar a los faraones a subir al cielo después de morir. Por eso, no solo los hacían fuertes y duraderos, sino también mágicos. Pensaban que eran como puentes entre el mundo de los vivos y el de los dioses.",
                    images = listOf(
                        MediaItem(R.drawable.arq, "", "Arquitectura egipcia", MediaType.IMAGE),
                        MediaItem(R.drawable.arq2, "", "Arquitectura egipcia", MediaType.IMAGE),
                        MediaItem(R.drawable.arq3, "", "Arquitectura egipcia", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.arquitecturas, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.arquitectura, "Arquitectura egipcia", "LA ARQUITECTURA DE EGIPTO, su historia, pirámides, tumbras, casas y caracteristias", MediaType.VIDEO),
                    ageGroup = AgeGroup.CHILDREN,
                    audioDescription = "Propósito de las grandes construcciones egipcias"
                ),
                Article(
                    id = "architecture_children_2",
                    title = "Pirámides Triangulares",
                    content = "Las pirámides eran unas construcciones enormes con forma de triángulo que servían como tumbas para los faraones. Por dentro tenían pasillos secretos y salas escondidas donde guardaban el cuerpo del rey y sus tesoros." +
                            "/" +
                            "La forma de triángulo no era casualidad. Los egipcios creían que el sol subía al cielo en forma de rayo, así que hacer una pirámide era como construir una escalera para que el faraón pudiera subir al cielo junto al sol después de morir." +
                            "/" +
                            "Estas tumbas eran muy importantes porque los egipcios pensaban que el faraón seguiría viviendo en otro mundo. Por eso, ponían dentro todo lo que pudiera necesitar: comida, ropa, muebles y hasta juguetes. Querían que estuviera feliz allá arriba.",
                    images = listOf(
                        MediaItem(R.drawable.piramides, "", "Piramides egipcias", MediaType.IMAGE),
                                MediaItem(R.drawable.arq2, "", "Piramides egipcias", MediaType.IMAGE)
                    ),
                    audio = MediaItem(R.raw.piramides, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.piramide, "La gran pirámide de Giza", "Esta es la estructura más famosa de la tierra, con 147 metros de altura, 2.3 millones de piedras y un peso de 6 millones de toneladas ¿Cuál era el propósito de esta pirámide? ¿Cómo se construyo?", MediaType.VIDEO),
                    ageGroup = AgeGroup.CHILDREN,
                    audioDescription = "Las pirámides y su simbolismo"
                ),
                Article(
                    id = "architecture_children_3",
                    title = "Casas para los Dioses",
                    content = "Los templos egipcios eran lugares sagrados donde la gente iba a rezar y a dejar regalos para los dioses. Los sacerdotes cuidaban estos templos y hacían ceremonias todos los días. Decían oraciones, cantaban y les ofrecían comida a las estatuas de los dioses." +
                            "/" +
                            "Por dentro, los templos estaban llenos de columnas gigantes, pasillos oscuros y salas muy misteriosas. En las paredes pintaban escenas de dioses, animales mágicos y personas haciendo ofrendas. ¡Era como un cuento dibujado en piedra!/" +
                            "/" +
                            "También escribían jeroglíficos, que eran símbolos especiales que contaban historias o pedían ayuda a los dioses. Así, cada templo era como un libro mágico donde se guardaban secretos sagrados y deseos del pueblo.",
                    images = listOf(
                        MediaItem(R.drawable.templo, "", "Templo egipcio", MediaType.IMAGE),
                        MediaItem(R.drawable.templos2, "", "Templo egipcio", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.templo, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.templos, "EL COMPLEJO DE TEMPLOS DE KARNAK", "EL COMPLEJO DE TEMPLOS DE KARNAK", MediaType.VIDEO),
                    ageGroup = AgeGroup.CHILDREN,
                    audioDescription = "Los templos egipcios"
                ),
                Article(
                    id = "architecture_children_4",
                    title = "Piedras que Duran Mucho",
                    content = "Para construir sus templos y pirámides, los egipcios usaban piedras enormes y muy duras. Eran tan fuertes que todavía hoy, miles de años después, muchas de esas construcciones siguen de pie. Querían que duraran para siempre." +
                            "/" +
                            "Las piedras se sacaban de canteras, que eran lugares especiales donde cortaban las rocas. Luego las transportaban hasta el sitio de construcción usando trineos, cuerdas y mucha fuerza. No tenían máquinas, pero sabían organizarse muy bien." +
                            "/" +
                            "Miles de personas trabajaban juntas: algunos eran albañiles, otros cortaban piedra, y había quienes llevaban agua y comida. Todo estaba muy bien organizado, como un gran equipo. Gracias a eso podían construir cosas increíbles.",
                    images = listOf(
                        MediaItem(R.drawable.materiales, "", "Materiales egipcios", MediaType.IMAGE),
                        MediaItem(R.drawable.materiales2, "", "Materiales egipcios", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.material, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.materiales, "PONIENDO A PRUEBA EL MATERIAL EGIPCIO", "PONIENDO A PRUEBA EL MATERIAL EGIPCIO", MediaType.VIDEO),
                    ageGroup = AgeGroup.CHILDREN,
                    audioDescription = "Materiales de construcción duraderos"
                ),
                Article(
                    id = "architecture_children_5",
                    title = "Construir sin Máquinas",
                    content = "Los egipcios no tenían grúas ni camiones como los de ahora, pero igual lograban mover piedras que pesaban toneladas. ¿Cómo lo hacían? Usaban rampas de tierra y madera que les ayudaban a subir las piedras poco a poco." +
                            "/" +
                            "A veces usaban trineos para empujar las piedras sobre la arena mojada. También ponían troncos debajo de las rocas para hacerlas rodar. ¡Todo con la fuerza de muchas personas y con mucha paciencia!/" +
                            "/" +
                            "Lo más sorprendente es que muchas de sus ideas siguen siendo útiles hoy. Ingenieros modernos todavía estudian cómo lo hacían para aprender de ellos. Aunque no tenían tecnología, usaban su inteligencia para resolver grandes problemas.",
                    images = listOf(
                        MediaItem(R.drawable.piedras, "", "Ingenieria egipcia", MediaType.IMAGE),
                        MediaItem(R.drawable.piedras2, "", "Ingenieria egipcia", MediaType.IMAGE),
                        ),
                    audio = MediaItem(R.raw.ingenierias, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.ingenieria, "¿CÓMO CONSTRUYERON LAS PIRÁMIDES?", "¿CÓMO CONSTRUYERON LAS PIRÁMIDES?", MediaType.VIDEO),
                    ageGroup = AgeGroup.CHILDREN,
                    audioDescription = "Técnicas de construcción egipcias"
                ))

            AgeGroup.TEEN -> listOf(
                // Artículos para adolescentes
                Article(
                    id = "architecture_teen_1",
                    title = "Edificios con Significado",
                    content = "Los antiguos egipcios consideraban que sus templos y tumbas no solo eran construcciones físicas, sino espacios sagrados donde se conectaban con lo divino. Los edificios monumentales, como templos y pirámides, eran concebidos como lugares de poder y espiritualidad. Por eso, invertían una enorme cantidad de tiempo y recursos en hacerlos tan majestuosos y duraderos como fuera posible." +
                            "/" +
                            "Estas estructuras no estaban hechas al azar. Cada parte del edificio, desde su orientación hasta sus proporciones, seguía principios simbólicos y religiosos. Por ejemplo, muchos templos estaban alineados con el sol naciente o con ciertas estrellas, reflejando su relación con los dioses solares y el ciclo eterno de la vida y la muerte. Así, los edificios funcionaban como símbolos físicos del orden del universo." +
                            "/" +
                            "Además de su función espiritual, estas construcciones también servían para mostrar la grandeza del faraón. Al levantar obras gigantescas, los gobernantes demostraban su poder ante el pueblo y los dioses. Eran una forma de dejar huella en la historia, de asegurar que su nombre viviera para siempre a través de la piedra.",
                    images = listOf(
                        MediaItem(R.drawable.arq, "", "Arquitectura egipcia", MediaType.IMAGE),
                        MediaItem(R.drawable.arq2, "", "Arquitectura egipcia", MediaType.IMAGE),
                        MediaItem(R.drawable.arq3, "", "Arquitectura egipcia", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.arquitecturas, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.arquitectura, "Arquitectura egipcia", "LA ARQUITECTURA DE EGIPTO, su historia, pirámides, tumbras, casas y caracteristias", MediaType.VIDEO),
                    ageGroup = AgeGroup.TEEN,
                    audioDescription = "Simbolismo en la arquitectura egipcia"
                ),
                Article(
                    id = "architecture_teen_2",
                    title = "Las Pirámides",
                    content = "Para los egipcios, la forma de las pirámides no era casual. Su estructura triangular apuntando hacia el cielo simbolizaba el camino del faraón hacia los dioses, especialmente hacia Ra, el dios del sol. Se creía que, al morir, el faraón ascendía por los cielos y se unía a las estrellas eternas. Así, la pirámide funcionaba como una especie de \"escalera\" espiritual." +
                            "/" +
                            "Esta idea está relacionada con el culto a la vida después de la muerte, que era fundamental en la cultura egipcia. Los arquitectos diseñaban las pirámides como espacios mágicos que protegían el cuerpo del faraón y lo preparaban para su viaje al más allá. Por eso incluían pasadizos secretos, cámaras ocultas y objetos funerarios destinados a acompañarlo en la otra vida." +
                            "/" +
                            "Aunque hoy las veamos como ruinas antiguas, en su momento estas pirámides estaban recubiertas de piedra caliza blanca y brillaban con la luz del sol. Eran impresionantes y visibles desde muchos kilómetros a la redonda, reforzando la idea de que el faraón era un ser divino destinado a alcanzar los cielos.",
                    images = listOf(
                        MediaItem(R.drawable.piramides, "", "Piramides egipcias", MediaType.IMAGE),
                        MediaItem(R.drawable.arq2, "", "Piramides egipcias", MediaType.IMAGE)
                    ),
                    audio = MediaItem(R.raw.piramides, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.piramide, "La gran pirámide de Giza", "Esta es la estructura más famosa de la tierra, con 147 metros de altura, 2.3 millones de piedras y un peso de 6 millones de toneladas ¿Cuál era el propósito de esta pirámide? ¿Cómo se construyo?", MediaType.VIDEO),
                    ageGroup = AgeGroup.TEEN,
                    audioDescription = "Significado y propósito de las pirámides"
                ),
                Article(
                    id = "architecture_teen_3",
                    title = "Templos Multipropósito",
                    content = "Los templos egipcios eran mucho más que simples centros religiosos. Aunque su función principal era honrar a los dioses mediante rituales y ofrendas, también cumplían roles fundamentales en la organización política, económica y cultural del país. Eran como pequeñas ciudades donde se concentraba una gran cantidad de actividad." +
                            "/" +
                            "En muchos casos, los templos eran dueños de tierras, animales y esclavos. Administraban cosechas, almacenaban granos y organizaban festividades a gran escala. Esto los convertía en centros económicos con gran poder, y los sacerdotes que los dirigían eran figuras muy influyentes, cercanas al faraón. Incluso algunas decisiones políticas se tomaban en estos espacios sagrados." +
                            "/" +
                            "Además, los templos eran bibliotecas del saber. Albergaban textos sagrados, conocimientos médicos, matemáticos y astronómicos. Los muros de los templos estaban decorados con jeroglíficos y escenas simbólicas que no solo transmitían mitología, sino también mensajes políticos y sociales. Era una forma de educar y controlar al pueblo a través de lo sagrado.",
                    images = listOf(
                        MediaItem(R.drawable.templo, "", "Templo egipcio", MediaType.IMAGE),
                        MediaItem(R.drawable.templos2, "", "Templo egipcio", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.templo, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.templos, "EL COMPLEJO DE TEMPLOS DE KARNAK", "EL COMPLEJO DE TEMPLOS DE KARNAK", MediaType.VIDEO),
                    ageGroup = AgeGroup.TEEN,
                    audioDescription = "Funciones de los templos egipcios"
                ),
                Article(
                    id = "architecture_teen_4",
                    title = "Materiales Duraderos",
                    content = "La durabilidad era una prioridad en la arquitectura egipcia. Los egipcios querían que sus templos y tumbas duraran eternamente, así que utilizaban materiales como granito, basalto y piedra caliza. Estas piedras eran difíciles de trabajar, pero ofrecían una resistencia al paso del tiempo y a los desastres naturales impresionante." +
                            "/" +
                            "La construcción de estas enormes obras requería el esfuerzo de miles de trabajadores. Aunque a menudo se piensa que eran esclavos, muchas investigaciones muestran que eran obreros organizados en equipos especializados, dirigidos por arquitectos y técnicos muy capacitados. Recibían comida, alojamiento y, en algunos casos, hasta reconocimiento social." +
                            "/" +
                            "Para transportar las piedras desde las canteras, a veces ubicadas a cientos de kilómetros, usaban barcos por el Nilo o grandes trineos que deslizaban sobre caminos húmedos. Todo este esfuerzo demuestra el compromiso de los egipcios por dejar un legado arquitectónico que sobreviviera no solo a su propia generación, sino a la historia misma.",
                    images = listOf(
                        MediaItem(R.drawable.materiales, "", "Materiales egipcios", MediaType.IMAGE),
                        MediaItem(R.drawable.materiales2, "", "Materiales egipcios", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.material, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.materiales, "PONIENDO A PRUEBA EL MATERIAL EGIPCIO", "PONIENDO A PRUEBA EL MATERIAL EGIPCIO", MediaType.VIDEO),
                    ageGroup = AgeGroup.TEEN,
                    audioDescription = "Materiales y organización del trabajo"
                ),
                Article(
                    id = "architecture_teen_5",
                    title = "Técnicas Avanzadas",
                    content = "Una de las cosas que más sorprende de la arquitectura egipcia es cómo lograron mover y colocar bloques de piedra que pesaban varias toneladas sin grúas ni maquinaria moderna. Lo hacían con ingenio, herramientas simples y una comprensión avanzada de la física básica. Utilizaban rampas, rodillos de madera y palancas, y organizaban a los trabajadores de manera precisa." +
                            "/" +
                            "La logística detrás de estas construcciones era tan compleja que implicaba planificación a largo plazo. Era necesario coordinar recursos humanos, transporte, alimentación y seguridad para mantener a miles de personas trabajando durante años. Todo esto se hacía bajo la dirección de expertos que supervisaban cada etapa del proyecto." +
                            "/" +
                            "Este conocimiento técnico fue tan avanzado para su época que inspiró a otras civilizaciones posteriores. Los griegos y romanos aprendieron mucho de los métodos constructivos egipcios. Incluso hoy en día, ingenieros y arquitectos estudian estas técnicas para entender cómo lograron tanto con tan poco.",
                    images = listOf(
                        MediaItem(R.drawable.piedras, "", "Ingenieria egipcia", MediaType.IMAGE),
                        MediaItem(R.drawable.piedras2, "", "Ingenieria egipcia", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.ingenierias, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.ingenieria, "La ingeniería en el antiguo Egipto para la construcción de barcos", "La ingeniería en el antiguo Egipto para la construcción de barcos", MediaType.VIDEO),
                    ageGroup = AgeGroup.TEEN,
                    audioDescription = "Ingeniería y legado arquitectónico"
                ))

            AgeGroup.ADULT -> listOf(
                // Artículos para adultos
                Article(
                    id = "architecture_adult_1",
                    title = "Arquitectura Monumental y Simbólica",
                    content = "La arquitectura del Antiguo Egipto no era meramente funcional ni decorativa; constituía una expresión integral de la ideología religiosa, social y cósmica del pueblo egipcio. Cada elemento arquitectónico tenía un propósito espiritual y simbólico. Los egipcios creían firmemente en la vida después de la muerte, y sus edificaciones –especialmente templos y tumbas– se diseñaban para facilitar ese tránsito y honrar a los dioses que garantizaban el orden del universo, el llamado \"maat\"." +
                            "Los edificios estaban cuidadosamente alineados según los puntos cardinales, con orientaciones que reflejaban fenómenos astronómicos clave como el solsticio o la salida heliaca de Sirio, eventos esenciales para su calendario agrícola y religioso. Esta alineación no era accidental: representaba la intención de integrar los espacios construidos con el orden celestial, lo que reforzaba la legitimidad del faraón como intermediario entre los dioses y los hombres. El uso de simetría y monumentalidad era una representación visual de este equilibrio cósmico." +
                            "Además, los espacios arquitectónicos tenían jerarquías internas: desde patios abiertos para los fieles hasta santuarios inaccesibles donde solo los sacerdotes y el faraón podían ingresar. Esta disposición reforzaba la estructura jerárquica de la sociedad egipcia, donde el acceso al poder –y a lo divino– era progresivamente restringido. En suma, la arquitectura egipcia no solo organizaba el espacio físico, sino también la experiencia espiritual y social de sus habitantes.",
                    images = listOf(
                        MediaItem(R.drawable.arq, "", "Arquitectura egipcia", MediaType.IMAGE),
                        MediaItem(R.drawable.arq2, "", "Arquitectura egipcia", MediaType.IMAGE),
                        MediaItem(R.drawable.arq3, "", "Arquitectura egipcia", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.arquitecturas, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.arquitectura, "Arquitectura egipcia", "LA ARQUITECTURA DE EGIPTO, su historia, pirámides, tumbras, casas y caracteristias", MediaType.VIDEO),
                    ageGroup = AgeGroup.ADULT,
                    audioDescription = "Significado cosmológico y religioso de la arquitectura"
                ),
                Article(
                    id = "architecture_adult_2",
                    title = "Las Pirámides: Perfección Geométrica",
                    content = "Las pirámides, emblemas por excelencia del Antiguo Egipto, no solo funcionaban como tumbas reales, sino como complejos funerarios concebidos para asegurar la inmortalidad del faraón. Su forma triangular –simbolizando los rayos del sol– estaba estrechamente asociada con el dios Ra, el principal dios solar. Así, las pirámides actuaban como un puente simbólico entre el mundo terrenal y el celestial, facilitando la ascensión del alma del faraón a los cielos." +
                            "/" +
                            "La construcción de estas estructuras requirió una planificación meticulosa y un conocimiento avanzado de matemáticas, geometría y astronomía. Por ejemplo, la Gran Pirámide de Giza está alineada casi perfectamente con el norte verdadero, un logro que no se pudo replicar con esa precisión hasta la era moderna. Los arquitectos egipcios sabían cómo nivelar terrenos, calcular inclinaciones exactas y mover bloques de varias toneladas utilizando rampas, trineos y lubricación con agua, según recientes descubrimientos arqueológicos." +
                            "/" +
                            "Además del cuerpo principal de la pirámide, los complejos incluían templos funerarios, calzadas procesionales y pequeñas pirámides subsidiarias. Todo el conjunto estaba rodeado por un muro y decorado con inscripciones religiosas, como los Textos de las Pirámides, los más antiguos del mundo. La pirámide, entonces, era mucho más que una tumba: era un portal sagrado, un eje del mundo y una obra maestra de ingeniería simbólica.",
                    images = listOf(
                        MediaItem(R.drawable.piramides, "", "Piramides egipcias", MediaType.IMAGE),
                        MediaItem(R.drawable.arq2, "", "Piramides egipcias", MediaType.IMAGE)
                    ),
                    audio = MediaItem(R.raw.piramides, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.piramide, "La gran pirámide de Giza", "Esta es la estructura más famosa de la tierra, con 147 metros de altura, 2.3 millones de piedras y un peso de 6 millones de toneladas ¿Cuál era el propósito de esta pirámide? ¿Cómo se construyo?", MediaType.VIDEO),
                    ageGroup = AgeGroup.ADULT,
                    audioDescription = "Precisión y simbolismo en las pirámides"
                ),
                Article(
                    id = "architecture_adult_3",
                    title = "Templos: Centros de Poder",
                    content = "A diferencia de las pirámides, que estaban destinadas a un solo individuo, los templos egipcios servían como casas para los dioses y eran utilizados regularmente por los sacerdotes y la población. Un templo no era solo un lugar de culto: funcionaba también como archivo, granero, banco, centro educativo y sede de poder local. En muchos casos, los templos eran los mayores empleadores de su región, albergando desde sacerdotes hasta artesanos, escribas y trabajadores agrícolas." +
                            "/" +
                            "La arquitectura de los templos seguía una lógica de sacralización progresiva. Desde la entrada monumental (el pilono) hasta el sanctasanctórum (naos), cada sección del templo tenía un grado creciente de santidad. Este recorrido simbolizaba el camino desde el mundo profano hacia la presencia divina. Las columnas talladas, techos estrellados y relieves pintados reforzaban esta experiencia sensorial y espiritual, envolviendo al visitante en un universo simbólico." +
                            "/" +
                            "Templos como Karnak, Luxor, Edfu y Philae evolucionaron durante siglos, siendo ampliados por distintos faraones. Esta expansión demostraba no solo devoción religiosa, sino también poder político. Las inscripciones y relieves narraban las hazañas del faraón, su vínculo con los dioses y los rituales diarios que aseguraban la estabilidad de Egipto. De este modo, el templo era a la vez un escenario cósmico, un archivo histórico y una maquinaria económica sostenida por el Estado teocrático.",
                    images = listOf(
                        MediaItem(R.drawable.templo, "", "Templo egipcio", MediaType.IMAGE),
                        MediaItem(R.drawable.templos2, "", "Templo egipcio", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.templo, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.templos, "EL COMPLEJO DE TEMPLOS DE KARNAK", "EL COMPLEJO DE TEMPLOS DE KARNAK", MediaType.VIDEO),
                    ageGroup = AgeGroup.ADULT,
                    audioDescription = "Evolución y funcionamiento de los templos"
                ),
                Article(
                    id = "architecture_adult_4",
                    title = "Materiales y Fuerza Laboral",
                    content = "A diferencia de otras civilizaciones contemporáneas que dependían principalmente del barro cocido o madera, los egipcios emplearon masivamente piedra tallada para sus estructuras monumentales. Este material no solo tenía una connotación de eternidad, sino que también representaba un recurso abundante en regiones como Asuán (granito) y Tura (caliza). La elección de estos materiales garantizaba la durabilidad física del edificio y su permanencia simbólica en el tiempo." +
                            "/" +
                            "El proceso de extracción y transporte de bloques de piedra era extremadamente complejo. Implicaba cortar las piedras con herramientas de cobre, moverlas en balsas por el Nilo y luego arrastrarlas mediante sistemas de trineos sobre rampas. Las losas más pesadas, de hasta 70 toneladas, eran colocadas con una precisión milimétrica, como puede observarse en los techos de los templos y en los sarcófagos reales." +
                            "/" +
                            "Gracias a esta inversión en materiales duraderos y técnicas cuidadosas, muchas de estas estructuras han resistido siglos de erosión, saqueo y desastres naturales. Los templos de Luxor, las pirámides de Giza y las tumbas del Valle de los Reyes aún conservan inscripciones y colores originales. Esto ha permitido a los arqueólogos y arquitectos modernos estudiar con detalle no solo el arte, sino la ingeniería y la logística detrás de la arquitectura egipcia.",
                    images = listOf(
                        MediaItem(R.drawable.materiales, "", "Materiales egipcios", MediaType.IMAGE),
                        MediaItem(R.drawable.materiales2, "", "Materiales egipcios", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.material, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.materiales, "PONIENDO A PRUEBA EL MATERIAL EGIPCIO", "PONIENDO A PRUEBA EL MATERIAL EGIPCIO", MediaType.VIDEO),
                    ageGroup = AgeGroup.ADULT,
                    audioDescription = "Materiales y organización de trabajo constructivo"
                ),
                Article(
                    id = "architecture_adult_5",
                    title = "Ingeniería y Legado",
                    content = "Uno de los aspectos más fascinantes de la arquitectura egipcia es su precisión sin el uso de tecnología moderna. Los egipcios utilizaban herramientas como el “merjet” (instrumento de alineación con plomada), reglas de madera, cuerdas tensadas y cuadrantes solares para lograr exactitud en orientación y nivelación. Muchos templos y pirámides están alineados con fenómenos astronómicos clave, lo cual refleja una estrecha colaboración entre arquitectos, sacerdotes y astrónomos." +
                            "/" +
                            "La planificación comenzaba con maquetas de barro y planos dibujados en papiros o sobre tablillas. Luego se trazaban los perímetros con cuerdas anudadas y se utilizaban marcadores para definir la ubicación exacta de los muros y columnas. Los arquitectos reales eran figuras altamente respetadas, y algunos, como Imhotep (diseñador de la pirámide escalonada de Saqqara), fueron posteriormente deificados por sus logros." +
                            "/" +
                            "El diseño modular, el uso repetido de proporciones áureas y simetrías constantes muestran que los egipcios no trabajaban al azar, sino con una teoría estructural sofisticada, aunque no escrita como en tiempos modernos. Su legado arquitectónico ha influenciado a civilizaciones posteriores como Grecia y Roma, y sus técnicas aún se estudian en contextos de restauración y conservación. La arquitectura egipcia no solo construía templos: edificaba la memoria y la eternidad.",
                    images = listOf(
                        MediaItem(R.drawable.piedras, "", "Ingenieria egipcia", MediaType.IMAGE),
                        MediaItem(R.drawable.piedras2, "", "Ingenieria egipcia", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.ingenierias, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.ingenieria, "La ingeniería en el antiguo Egipto para la construcción de barcos", "La ingeniería en el antiguo Egipto para la construcción de barcos", MediaType.VIDEO),
                    ageGroup = AgeGroup.ADULT,
                    audioDescription = "Tecnología constructiva e influencia histórica"
                ))
        }
    }

    private fun getArtArticles(ageGroup: AgeGroup): List<Article> {
        return when (ageGroup) {
            AgeGroup.CHILDREN -> listOf(
                // Artículos para niños
                Article(
                    id = "art_children_1",
                    title = "Arte con Reglas Especiales",
                    content = "Era para enseñar cosas importantes, como quién era el rey, qué hacían los dioses o cómo era la vida después de morir. Cada dibujo tenía un mensaje especial." +
                            "/" +
                            "Por eso, los artistas egipcios seguían reglas muy estrictas al pintar o esculpir. No podían dibujar como querían, sino como se les enseñaba. Cada parte del cuerpo, cada color y cada símbolo tenía un significado." +
                            "/" +
                            "Así, cuando alguien veía una pintura, podía entender lo que pasaba, aunque no fuera realista. Era como un idioma visual que todos los egipcios sabían leer, incluso los que no sabían leer palabras.",
                    images = listOf(
                        MediaItem(R.drawable.funeral, "", "Arte egipcio", MediaType.IMAGE),
                        MediaItem(R.drawable.jeroglificos2, "", "Arte egipcio", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.artes, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.arte, "Arte antiguo egipto", "Arte antiguo egipto", MediaType.VIDEO),
                    ageGroup = AgeGroup.CHILDREN,
                    audioDescription = "Propósito y estilo del arte egipcio"
                ),
                Article(
                    id = "art_children_2",
                    title = "Formas de Dibujar Personas",
                    content = "Cuando los egipcios dibujaban personas, no las hacían como nosotros las vemos. Ponían el cuerpo de lado, los ojos y el pecho de frente, y los pies también de lado. Esto parecía raro, pero tenía una razón." +
                            "/" +
                            "Ellos querían que cada parte del cuerpo se viera lo más claro posible. Si ponían todo de lado, no se vería bien el ojo o el pecho. Si ponían todo de frente, no se verían bien los brazos o las piernas. Por eso mezclaban las vistas." +
                            "/" +
                            "De esta forma, quien miraba el dibujo sabía exactamente qué estaba haciendo la persona y qué partes del cuerpo tenía. Era como un truco visual para que todo se entendiera mejor.",
                    images = listOf(
                        MediaItem(R.drawable.perfil, "", "Egipcios de perfil", MediaType.IMAGE),
                        MediaItem(R.drawable.perfil2, "", "Egipcios de perfil", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.perfiles, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.perfil, "¿Porqué los egipcios pintaban las cabezas de perfil y los ojos de frente?", "¿Porqué los egipcios pintaban las cabezas de perfil y los ojos de frente?", MediaType.VIDEO),
                    ageGroup = AgeGroup.CHILDREN,
                    audioDescription = "Convenciones para representar figuras humanas"
                ),
                Article(
                    id = "art_children_3",
                    title = "Dibujitos que Hablan",
                    content = "Los egipcios no escribían con letras como nosotros, usaban jeroglíficos. Eran dibujos pequeños que significaban sonidos, palabras o ideas. Algunos eran de animales, otros de personas o cosas como casas, ojos o soles." +
                            "/" +
                            "Con estos jeroglíficos podían escribir nombres, historias o plegarias. Estaban en paredes de templos, tumbas y hasta en papeles especiales hechos con una planta llamada papiro." +
                            "/" +
                            "Además, muchos pensaban que los jeroglíficos tenían poder mágico. Escribir el nombre de alguien en una tumba, por ejemplo, ayudaba a que esa persona no fuera olvidada y pudiera vivir para siempre en el otro mundo.",
                    images = listOf(
                        MediaItem(R.drawable.jeroglificos, "", "Jeroglificos", MediaType.IMAGE),
                        MediaItem(R.drawable.jeroglificos2, "", "Jeroglificos", MediaType.IMAGE),
                        MediaItem(R.drawable.jeroglificos3, "", "Jeroglificos", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.jeroglifico, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.jeroglificos, "¿Qué representan los jeroglíficos egipcios?", "¿Qué representan los jeroglíficos egipcios?", MediaType.VIDEO),
                    ageGroup = AgeGroup.CHILDREN,
                    audioDescription = "Los jeroglíficos egipcios"
                ),
                Article(
                    id = "art_children_4",
                    title = "Arte para Ayudar a los Muertos",
                    content = "Cuando alguien importante moría en Egipto, decoraban su tumba con pinturas muy coloridas. No eran solo para adornar: las escenas ayudaban al muerto a tener una buena vida en el otro mundo, como una guía mágica." +
                            "/" +
                            "Pintaban a los dioses dándole la bienvenida, o al muerto cruzando un río especial que lo llevaba al cielo. También mostraban mesas llenas de comida, flores, música y baile, para que tuviera todo eso para siempre." +
                            "/" +
                            "Estas imágenes eran como deseos. Si alguien pintaba una fiesta, significaba que quería que el muerto tuviera alegría en el más allá. Si pintaban pan y agua, era para que nunca le faltara nada.",
                    images = listOf(
                        MediaItem(R.drawable.funeral, "", "Funerales egipcios", MediaType.IMAGE),
                        MediaItem(R.drawable.funeral2, "", "Funerales egipcios", MediaType.IMAGE),
                        ),
                    audio = MediaItem(R.raw.funeral, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.funerario, "Arte funerario egipcio", "En este video, te invitamos a adentrarte en el fascinante mundo del arte funerario egipcio y explorar su cultura y creencias religiosas.", MediaType.VIDEO),
                    ageGroup = AgeGroup.CHILDREN,
                    audioDescription = "Arte funerario egipcio"
                ),
                Article(
                    id = "art_children_5",
                    title = "Estatuas de Dioses y Reyes",
                    content = "Los egipcios también hacían muchas estatuas. Algunas eran pequeñitas y otras tan grandes como una casa. Podían ser de piedra, madera o metal, y casi siempre representaban a dioses o faraones." +
                            "/" +
                            "Las ponían en templos, tumbas o plazas para que la gente pudiera rezarles o recordar lo importantes que eran. Pensaban que algunas estatuas podían tener el espíritu del dios o del rey adentro, así que las trataban con mucho respeto." +
                            "/" +
                            "Las más especiales estaban decoradas con oro, piedras brillantes y colores muy vivos. Eran tan bonitas que todavía hoy, cuando las vemos en museos, nos sorprenden por lo bien hechas que están. ¡Parecen mágicas!",
                    images = listOf(
                        MediaItem(R.drawable.escultura, "", "Esculturas egipcias", MediaType.IMAGE),
                        MediaItem(R.drawable.escultura2, "", "Esculturas egipcias", MediaType.IMAGE),
                        MediaItem(R.drawable.escultura3, "", "Esculturas egipcias", MediaType.IMAGE),
                        ),
                    audio = MediaItem(R.raw.escultura, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.esculturas, "La ESCULTURA EGIPCIA en 2 MINUTOS", "La historia de los FARAONES y la sociedad egipcia a través del arte. ", MediaType.VIDEO),
                    ageGroup = AgeGroup.CHILDREN,
                    audioDescription = "Esculturas egipcias"
                ))

            AgeGroup.TEEN -> listOf(
                // Artículos para adolescentes
                Article(
                    id = "art_teen_1",
                    title = "Arte con Significado",
                    content = "A diferencia del arte moderno, donde se busca capturar la realidad tal como se ve, el arte egipcio tenía una función simbólica y espiritual. Cada imagen debía transmitir conceptos profundos, como el equilibrio del universo, el poder del faraón o la esperanza en la vida después de la muerte. Por eso, la precisión estética estaba subordinada a las reglas religiosas y sociales." +
                            "/" +
                            "Estas reglas eran muy estrictas y debían seguirse al pie de la letra. Por ejemplo, no se podía dibujar una figura humana desde una sola perspectiva; debía combinar varios ángulos para que cada parte del cuerpo fuera reconocible. El objetivo no era la belleza por sí misma, sino la claridad del mensaje que se quería transmitir." +
                            "/" +
                            "Esta manera de representar las cosas ayudaba a mantener un orden visual que reflejaba el orden del universo, algo muy importante para los egipcios. Al repetir ciertas formas y estilos a lo largo del tiempo, se aseguraban de que las ideas sagradas permanecieran intactas y fueran comprendidas por todos, generación tras generación.",
                    images = listOf(
                        MediaItem(R.drawable.funeral, "", "Arte egipcio", MediaType.IMAGE),
                        MediaItem(R.drawable.jeroglificos2, "", "Arte egipcio", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.artes, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.arte, "Arte antiguo egipto", "Arte antiguo egipto", MediaType.VIDEO),
                    ageGroup = AgeGroup.TEEN,
                    audioDescription = "Propósito simbólico del arte egipcio"
                ),
                Article(
                    id = "art_teen_2",
                    title = "Forma de Representar el Cuerpo",
                    content = "Una de las características más reconocibles del arte egipcio es su forma de representar el cuerpo humano. Las figuras se dibujaban con la cabeza y las piernas de perfil, pero el torso y el ojo de frente. Esto puede parecer extraño hoy, pero tenía una lógica simbólica muy fuerte para ellos." +
                            "/" +
                            "Esta convención visual permitía mostrar cada parte del cuerpo desde su ángulo más \"claro\". El perfil mostraba bien el contorno de la cabeza, mientras que el torso de frente dejaba ver los brazos y el pecho. De esa manera, el espectador comprendía fácilmente qué parte era cuál, sin confusión. Era una técnica para hacer el mensaje visual más directo y entendible." +
                            "/" +
                            "Este estilo se aplicaba no solo en dibujos, sino también en relieves, esculturas y papiros. Aunque no variaba mucho con el tiempo, cada artista podía aportar detalles únicos según el contexto de la escena o la importancia del personaje representado.",
                    images = listOf(
                        MediaItem(R.drawable.perfil, "", "Egipcios de perfil", MediaType.IMAGE),
                        MediaItem(R.drawable.perfil2, "", "Egipcios de perfil", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.perfiles, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.perfil, "Pintura en el Antiguo Egipto", "Pintura en el Antiguo Egipto", MediaType.VIDEO),
                    ageGroup = AgeGroup.TEEN,
                    audioDescription = "Canon egipcio para representar figuras"
                ),
                Article(
                    id = "art_teen_3",
                    title = "Jeroglíficos: Arte y Escritura",
                    content = "Los jeroglíficos egipcios eran mucho más que simples decoraciones; formaban un sistema completo de escritura que combinaba imágenes con sonidos y significados. Cada símbolo podía representar una letra, una sílaba o incluso una idea entera, dependiendo de cómo se usara en el texto." +
                            "/" +
                            "Este sistema se usaba tanto para cosas prácticas —como registros de impuestos o contratos— como para textos sagrados. En los templos y tumbas, los jeroglíficos tenían un poder especial: se creía que al escribir una oración o un nombre, se le daba vida en el más allá. Por eso era tan importante que los nombres de los difuntos estuvieran bien escritos en sus tumbas." +
                            "/" +
                            "Aprender a escribir jeroglíficos era una tarea difícil que tomaba años de estudio. Solo los escribas y sacerdotes podían hacerlo correctamente, y su rol era muy respetado. Su conocimiento no solo los volvía indispensables, sino que también les daba un estatus social privilegiado.",
                    images = listOf(
                        MediaItem(R.drawable.jeroglificos, "", "Jeroglificos", MediaType.IMAGE),
                        MediaItem(R.drawable.jeroglificos2, "", "Jeroglificos", MediaType.IMAGE),
                        MediaItem(R.drawable.jeroglificos3, "", "Jeroglificos", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.jeroglifico, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.jeroglificos, "¿Qué representan los jeroglíficos egipcios?", "¿Qué representan los jeroglíficos egipcios?", MediaType.VIDEO),
                    ageGroup = AgeGroup.TEEN,
                    audioDescription = "Sistema de escritura jeroglífica"
                ),
                Article(
                    id = "art_teen_4",
                    title = "Arte Funerario",
                    content = "En el Antiguo Egipto, la muerte no se veía como un final, sino como un viaje hacia otra vida. Por eso decoraban las tumbas y templos con imágenes del mundo espiritual. Estas pinturas mostraban lo que el difunto encontraría en el más allá, desde ríos mágicos y dioses guardianes hasta el juicio final que decidiría su destino eterno." +
                            "/" +
                            "Muchos murales representaban rituales religiosos que se hacían para proteger el alma del fallecido. También se pintaban escenas de la vida diaria: cosechas, banquetes, juegos, e incluso músicos. Esto no era solo decoración, sino una forma de asegurar que el muerto tendría todo lo que necesitaba en su nueva vida. Las imágenes funcionaban como “reales” en el más allá, según su creencia." +
                            "/" +
                            "Cada dibujo tenía un propósito simbólico. Los colores, las posiciones de las figuras y los objetos tenían significados específicos. No pintaban por gusto, sino como parte de un sistema mágico y religioso. Era una mezcla de arte, fe y poder que le daba sentido a la muerte y a lo que venía después.",
                    images = listOf(
                        MediaItem(R.drawable.funeral, "", "Funerales egipcios", MediaType.IMAGE),
                        MediaItem(R.drawable.funeral2, "", "Funerales egipcios", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.funeral, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.funerario, "Arte funerario egipcio", "En este video, te invitamos a adentrarte en el fascinante mundo del arte funerario egipcio y explorar su cultura y creencias religiosas.", MediaType.VIDEO),
                    ageGroup = AgeGroup.TEEN,
                    audioDescription = "Escenas de la vida después de la muerte"
                ),
                Article(
                    id = "art_teen_5",
                    title = "Escultura Idealizada",
                    content = "El arte egipcio tenía reglas muy claras, y eso se notaba especialmente en sus esculturas. Las estatuas no intentaban parecerse exactamente a la persona real, sino que mostraban una versión idealizada. Un faraón, por ejemplo, siempre se veía joven, fuerte y sereno, sin importar su edad o apariencia verdadera. Era una forma de representar su poder eterno." +
                            "/" +
                            "Estas esculturas podían estar hechas de piedra como el granito, de madera o incluso de metales preciosos como el oro. Cuanto más importante era la figura, más costosos eran los materiales usados. También usaban pigmentos para pintar las estatuas, y a veces incluso las adornaban con joyas. Eran objetos de culto, no solo decoraciones." +
                            "/" +
                            "Las estatuas cumplían una función espiritual: servían como “hogares” para que el alma del difunto, o el espíritu de un dios, pudiera visitarlas. Se colocaban en tumbas, templos o espacios públicos para conectar el mundo humano con el mundo divino. Así, el arte egipcio no solo era estético, sino profundamente sagrado.",
                    images = listOf(
                        MediaItem(R.drawable.escultura, "", "Esculturas egipcias", MediaType.IMAGE),
                        MediaItem(R.drawable.escultura2, "", "Esculturas egipcias", MediaType.IMAGE),
                        MediaItem(R.drawable.escultura3, "", "Esculturas egipcias", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.escultura, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.esculturas, "La ESCULTURA EGIPCIA en 2 MINUTOS", "La historia de los FARAONES y la sociedad egipcia a través del arte. ", MediaType.VIDEO),
                    ageGroup = AgeGroup.TEEN,
                    audioDescription = "Materiales y técnicas escultóricas"
                ))

            AgeGroup.ADULT -> listOf(
                // Artículos para adultos
                Article(
                    id = "art_adult_1",
                    title = "Función y Simbolismo",
                    content = "El arte egipcio no surgió como una forma de expresión individual ni estética en el sentido moderno. Desde sus inicios, fue una herramienta al servicio de la religión, del poder político y del orden cósmico (el \"maat\"). Todo lo que se representaba tenía una función: asegurar la estabilidad del universo, mantener la armonía con los dioses o permitir la continuidad de la vida tras la muerte. En ese sentido, el arte egipcio era utilitario y altamente codificado." +
                            "/" +
                            "Las representaciones artísticas se ejecutaban siguiendo convenciones inalterables durante siglos. Estas normas no eran arbitrarias, sino que respondían a una lógica espiritual: lo importante no era cómo se veía algo, sino qué significaba y cómo podía funcionar mágicamente en el mundo más allá. Así, por ejemplo, una figura de Osiris no variaba entre templos ni entre periodos porque su imagen tenía un valor operativo en los rituales." +
                            "/" +
                            "El respeto a estas reglas aseguraba que las imágenes conservaran su poder. Cambiar la forma de representar a un dios o a un faraón podía anular su eficacia simbólica. Por eso, incluso con miles de años de diferencia, los estilos cambiaron mínimamente. Esta continuidad no denota estancamiento, sino fidelidad a un sistema visual cuya función era trascender lo humano para garantizar la eternidad.",
                    images = listOf(
                        MediaItem(R.drawable.funeral, "", "Arte egipcio", MediaType.IMAGE),
                        MediaItem(R.drawable.jeroglificos2, "", "Arte egipcio", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.artes, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.arte, "Arte antiguo egipto", "Arte antiguo egipto", MediaType.VIDEO),
                    ageGroup = AgeGroup.ADULT,
                    audioDescription = "Propósito y concepción del arte egipcio"
                ),
                Article(
                    id = "art_adult_2",
                    title = "Canon Artístico",
                    content = "El llamado “canon egipcio” para la figura humana era una construcción ideal. No pretendía capturar cómo se veía realmente una persona, sino cómo se debía representar para que fuera reconocible y eficaz mágicamente. La cabeza se mostraba de perfil porque es su ángulo más característico; el ojo se mostraba de frente, grande y abierto, símbolo de percepción y conciencia; el torso de frente, porque es donde se muestra la fuerza vital; las piernas de perfil, para sugerir movimiento." +
                            "/" +
                            "Este estilo también facilitaba la lectura narrativa de las escenas, especialmente en relieves y pinturas murales. Al ser una escritura visual jerárquica y no perspectivista, la coherencia en la forma era más importante que la ilusión espacial. Cada figura era dibujada por partes, no como un cuerpo en unidad anatómica, sino como una colección de símbolos que juntos componían una identidad funcional." +
                            "/" +
                            "La proporción entre las partes del cuerpo también se regulaba con precisión matemática. Durante el Imperio Nuevo, se usaba una cuadrícula de 18 módulos desde la planta del pie hasta la línea del cabello. Esta rejilla ayudaba a mantener la consistencia, especialmente cuando varios artistas trabajaban sobre un mismo muro. Era una técnica más cercana a la ingeniería que a la improvisación: precisión y repetición eran claves del sistema.",
                    images = listOf(
                        MediaItem(R.drawable.perfil, "", "Egipcios de perfil", MediaType.IMAGE),
                        MediaItem(R.drawable.perfil2, "", "Egipcios de perfil", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.perfiles, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.perfil, "Pintura en el Antiguo Egipto", "Pintura en el Antiguo Egipto", MediaType.VIDEO),
                    ageGroup = AgeGroup.ADULT,
                    audioDescription = "Sistema de representación figurativa"
                ),
                Article(
                    id = "art_adult_3",
                    title = "Jeroglíficos: Arte y Comunicación",
                    content = "El sistema jeroglífico egipcio fue una de las formas más refinadas de escritura pictográfica de la antigüedad. Cada signo podía tener múltiples funciones: representar un sonido (fonograma), una idea (ideograma), o un valor gramatical (determinativo). Esto hacía del jeroglífico una escritura visual rica en capas, donde forma y significado estaban profundamente entrelazados." +
                            "/" +
                            "Muchos jeroglíficos eran figuras reconocibles: aves, ojos, brazos, herramientas, partes del cuerpo, animales. Su estilo estaba alineado con el arte decorativo de su tiempo, y por eso podían integrarse fluidamente en relieves y pinturas. En las tumbas, los textos jeroglíficos acompañaban las imágenes de forma estética y armoniosa, creando paneles visuales coherentes y poderosos. No eran bloques de texto separados, sino parte integral de la escena." +
                            "/" +
                            "Los escribas eran figuras centrales en la sociedad egipcia. No solo sabían leer y escribir, sino que también entendían la estructura religiosa, legal y administrativa del reino. Para formarse, debían memorizar miles de signos, fórmulas rituales y técnicas caligráficas. Sus funciones abarcaban desde redactar documentos hasta tallar inscripciones sagradas. En una civilización donde lo escrito tenía valor mágico y eterno, el escriba era intermediario entre lo humano y lo divino.",
                    images = listOf(
                        MediaItem(R.drawable.jeroglificos, "", "Jeroglificos", MediaType.IMAGE),
                        MediaItem(R.drawable.jeroglificos2, "", "Jeroglificos", MediaType.IMAGE),
                        MediaItem(R.drawable.jeroglificos3, "", "Jeroglificos", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.jeroglifico, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.jeroglificos, "¿Qué representan los jeroglíficos egipcios?", "¿Qué representan los jeroglíficos egipcios?", MediaType.VIDEO),
                    ageGroup = AgeGroup.ADULT,
                    audioDescription = "El sistema jeroglífico y su valoración social"
                ),
                Article(
                    id = "art_adult_4",
                    title = "Arte Funerario y Cosmológico",
                    content = "En el pensamiento egipcio, la muerte no era un final, sino una transición hacia una existencia espiritual que podía ser tan rica como la vida terrenal. Para que el alma (ba) pudiera disfrutar de esa vida, necesitaba un entorno simbólico que replicara lo que había conocido. Por eso, las tumbas no solo contenían el cuerpo momificado, sino que eran verdaderos microcosmos decorados con escenas agrícolas, banquetes, música, danza y ofrendas." +
                            "/" +
                            "Estas imágenes no eran simples adornos ni homenajes nostálgicos. Eran hechizos visuales: se creía que al representar a un sirviente cosechando trigo, por ejemplo, ese sirviente realizaría esa labor eternamente en el más allá para el difunto. Lo mismo ocurría con las escenas de pesca, caza en los pantanos, o elaboración de pan y cerveza. Todo formaba parte de un programa funerario cuidadosamente planeado." +
                            "/" +
                            "En los templos, las decoraciones tenían un carácter más litúrgico. Se mostraban procesiones, sacrificios, oraciones y actos del faraón ante los dioses. Estas escenas estaban distribuidas con orden teológico: no eran puestas al azar, sino en lugares donde reforzaban el poder sagrado del edificio. En conjunto, estas imágenes sostenían el equilibrio entre lo humano y lo divino, tanto en este mundo como en el otro.",
                    images = listOf(
                        MediaItem(R.drawable.funeral, "", "Funerales egipcios", MediaType.IMAGE),
                        MediaItem(R.drawable.funeral2, "", "Funerales egipcios", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.funeral, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.funerario, "Arte funerario egipcio", "En este video, te invitamos a adentrarte en el fascinante mundo del arte funerario egipcio y explorar su cultura y creencias religiosas.", MediaType.VIDEO),
                    ageGroup = AgeGroup.ADULT,
                    audioDescription = "Propósito del arte en contextos funerarios"
                ),
                Article(
                    id = "art_adult_5",
                    title = "Escultura y Materialidad",
                    content = "Las esculturas egipcias, sobre todo las de gran formato, eran elaboradas bajo un estricto idealismo formal. Su objetivo no era captar el carácter individual del retratado, sino mostrarlo de forma majestuosa, eterna y reconocible para el mundo espiritual. Por eso, incluso cuando se trataba de retratos funerarios de particulares, los rasgos eran armoniosos, simétricos y sin signos de vejez o sufrimiento." +
                            "/" +
                            "Los materiales usados reflejaban tanto la función como el estatus del sujeto. Para los dioses y el faraón, se usaban piedras duras como el granito, el diorita o el basalto, que resistían el paso del tiempo y reforzaban la idea de eternidad. Para esculturas más pequeñas o privadas, se recurría a madera, alabastro, marfil o incluso fayenza vidriada. El color también era esencial: las pieles masculinas se pintaban rojizas, las femeninas más claras; los ojos se incrustaban con cristal o piedras semipreciosas." +
                            "/" +
                            "En el contexto religioso, una estatua podía contener el ka (espíritu vital) del retratado. Así, debía ser reconocible y funcional. Se colocaban en capillas o santuarios, donde se les ofrecía comida, incienso y plegarias. Su presencia física permitía mantener viva la memoria, pero también activaba la interacción con lo sagrado. Estas esculturas eran objetos de culto, puentes entre lo visible y lo invisible.",
                    images = listOf(
                        MediaItem(R.drawable.escultura, "", "Esculturas egipcias", MediaType.IMAGE),
                        MediaItem(R.drawable.escultura2, "", "Esculturas egipcias", MediaType.IMAGE),
                        MediaItem(R.drawable.escultura3, "", "Esculturas egipcias", MediaType.IMAGE),
                    ),
                    audio = MediaItem(R.raw.escultura, "", "", MediaType.AUDIO),
                    video = MediaItem(R.raw.esculturas, "La ESCULTURA EGIPCIA en 2 MINUTOS", "La historia de los FARAONES y la sociedad egipcia a través del arte. ", MediaType.VIDEO),
                    ageGroup = AgeGroup.ADULT,
                    audioDescription = "Técnicas escultóricas y materiales"
                ))
        }
    }
} 