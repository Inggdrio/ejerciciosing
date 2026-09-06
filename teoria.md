# Parte Teórica

Taller de nivelación PI a PII - UNIAJC

## ¿Qué es Markdown?

Markdown es un lenguaje de marcado ligero que sirve para dar formato a texto plano de forma sencilla usando caracteres simples como #, *, - o []. Después ese texto se puede convertir fácilmente a HTML. Los archivos usan la extensión .md y se usa mucho en GitHub, documentación y notas. Hoy en día el estándar más usado es CommonMark.

Fuente: https://commonmark.org

## Git

### 1. ¿Qué es un repositorio en Git y cómo se diferencia de un proyecto "normal"?

Un repositorio es la carpeta del proyecto pero con una carpeta oculta llamada .git, donde Git guarda todo el historial de cambios (versiones, ramas, autores). Un proyecto normal solo tiene los archivos como están en ese momento; en cambio un repositorio guarda cada versión y permite volver a un estado anterior.

Fuente: https://git-scm.com/book/es/v2/Inicio---Sobre-el-Control-de-Versiones-Fundamentos-de-Git

### 2. ¿Cuáles son las tres áreas principales de Git?

Son el directorio de trabajo (working directory), que son los archivos que estás editando; el área de preparación (staging area o index), donde marcas qué cambios van a entrar en el próximo commit; y el repositorio (.git), donde quedan guardados los commits ya confirmados. El flujo es: editar, hacer git add y luego git commit.

Fuente: https://git-scm.com/book/es/v2/Inicio---Sobre-el-Control-de-Versiones-Fundamentos-de-Git

### 3. ¿Cómo representa Git los cambios internamente? (blob, tree, commit y tag)

Git no guarda diferencias, guarda fotos completas del proyecto (snapshots) usando cuatro tipos de objeto: el blob guarda el contenido de un archivo, el tree representa un directorio y lista los blobs con sus nombres, el commit apunta a un tree más el commit anterior, autor, fecha y mensaje, y el tag es una etiqueta que apunta a un commit (por ejemplo una versión v1.0). Cada objeto tiene un hash que lo identifica.

Fuente: https://git-scm.com/book/en/v2/Git-Internals-Git-Objects

### 4. ¿Cómo se crea un commit y qué información almacena?

Primero se preparan los cambios con git add y luego se hace git commit -m "mensaje". El commit guarda el puntero al tree (la foto del proyecto), el commit o commits padre, el autor y la fecha, quién lo confirmó, el mensaje y su hash.

Fuente: https://git-scm.com/book/en/v2/Git-Internals-Git-Objects

### 5. ¿Cuál es la diferencia entre git pull y git fetch?

git fetch descarga los cambios del repositorio remoto pero no los mezcla con tu trabajo. git pull hace las dos cosas: descarga los cambios y además los fusiona en tu rama (sería como un fetch más un merge).

Fuente: https://git-scm.com/docs/git-pull

### 6. ¿Qué es un branch (rama) y cómo gestiona Git los punteros a commits?

Una rama es un puntero que apunta a un commit. Cuando creas una rama estás creando un puntero nuevo, y cada vez que haces un commit ese puntero avanza solo al último commit. Además está HEAD, que es otro puntero que indica en qué rama estás parado.

Fuente: https://git-scm.com/book/es/v2/Ramificaciones-en-Git-%C2%BFQu%C3%A9-es-una-rama%3F

### 7. ¿Cómo se realiza un merge y qué conflictos pueden surgir? ¿Cómo se resuelven?

Con git merge se unen dos ramas. El conflicto aparece cuando las dos ramas cambiaron la misma parte del mismo archivo, entonces Git no sabe cuál dejar y marca la zona con <<<<<<<, ======= y >>>>>>>. Para resolverlo hay que editar el archivo a mano dejando la versión correcta, y después git add y git commit.

Fuente: https://git-scm.com/book/es/v2/Ramificaciones-en-Git-Procedimientos-B%C3%A1sicos-para-Ramificar-y-Fusionar

### 8. ¿Cómo funciona el área de staging (git add) y qué pasa si omito este paso?

git add sirve para elegir qué cambios entran al próximo commit, moviéndolos al staging. Si no lo haces, esos cambios no se incluyen en el commit y se quedan solo en tu directorio de trabajo sin confirmar.

Fuente: https://git-scm.com/docs/git-add

### 9. ¿Qué es el archivo .gitignore y cómo influye en el seguimiento de archivos?

Es un archivo de texto donde escribes los archivos o carpetas que quieres que Git ignore, o sea que no les haga seguimiento ni los suba. Se usa para cosas como los archivos compilados (.class), node_modules o archivos con contraseñas.

Fuente: https://git-scm.com/docs/gitignore

### 10. ¿Cuál es la diferencia entre un "commit amend" (--amend) y un nuevo commit?

git commit --amend modifica el último commit, ya sea su contenido o su mensaje, y le genera un hash nuevo. Un commit normal en cambio agrega uno más al historial sin tocar el anterior.

Fuente: https://git-scm.com/docs/git-commit

### 11. ¿Qué es git stash y en qué escenarios es útil?

git stash guarda de forma temporal los cambios que no has confirmado y deja limpio el directorio de trabajo. Sirve cuando tienes algo a medias pero necesitas cambiar de rama o traer otros cambios sin perder lo tuyo. Después los recuperas con git stash pop.

Fuente: https://git-scm.com/docs/git-stash

### 12. ¿Qué mecanismos ofrece Git para deshacer cambios? (git reset, git revert, git checkout)

git checkout (o git restore) descarta los cambios locales y vuelve a la última versión guardada. git reset mueve el puntero de la rama o saca cosas del staging, y tiene las opciones --soft, --mixed y --hard. git revert crea un commit nuevo que deshace otro anterior, y es el más seguro cuando el historial ya está compartido.

Fuente: https://git-scm.com/book/es/v2/Fundamentos-de-Git-Deshacer-Cosas

### 13. ¿Cómo funciona la configuración de remotos (origin, upstream) y qué comandos uso para forks?

origin es el nombre que se le da por defecto a tu propio repositorio remoto (tu copia o fork en GitHub), y upstream es el repositorio original del que hiciste el fork. Los comandos comunes son git remote add para agregar un remoto, git remote -v para verlos, git fetch upstream para traer cambios del original y git push origin para subir a tu repo.

Fuente: https://git-scm.com/book/es/v2/Fundamentos-de-Git-Trabajar-con-Remotos

### 14. ¿Cómo puedo inspeccionar el historial de commits? (git log, git diff, git show)

git log muestra la lista de commits con su autor, fecha, mensaje y hash. git diff muestra las diferencias entre versiones o entre el directorio de trabajo y el staging. git show con el hash de un commit muestra el detalle y los cambios de ese commit en específico.

Fuente: https://git-scm.com/book/es/v2/Fundamentos-de-Git-Ver-el-Historial-de-Confirmaciones

## Programación (Java)

### 15. ¿Cuáles son los tipos de datos primitivos en Java?

En Java hay ocho tipos primitivos: byte, short, int y long para números enteros, float y double para decimales, char para un solo carácter y boolean para valores de true o false.

Fuente: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

### 16. ¿Cómo funcionan las estructuras de control de flujo como if, else, switch y bucles en Java?

El if evalúa una condición y ejecuta un bloque si es verdadera, y con else se ejecuta otra cosa si es falsa. El switch elige entre varios bloques según el valor de una variable. Los bucles (for, while y do-while) repiten un bloque mientras se cumpla una condición; el do-while además se ejecuta al menos una vez.

Fuente: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/flow.html

### 17. ¿Por qué es importante usar nombres significativos para variables y métodos?

Porque el código se lee muchas más veces de las que se escribe, entonces un nombre claro como sumaTotal en vez de x hace que el programa sea más fácil de entender y de mantener, tanto para uno mismo como para los demás, y ayuda a cometer menos errores.

Fuente: https://dev.java/learn/language-basics/variables/

### 18. ¿Qué es la Programación Orientada a Objetos (POO)?

Es una forma de programar que organiza el código en objetos, que juntan los datos (atributos) y las acciones (métodos) de una misma cosa. Los objetos se crean a partir de clases, que funcionan como una plantilla o molde.

Fuente: https://docs.oracle.com/javase/tutorial/java/concepts/index.html

### 19. ¿Cuáles son los cuatro pilares de la POO?

Son el encapsulamiento (ocultar el estado interno y mostrar solo lo necesario), la abstracción (quedarse con lo importante y esconder los detalles), la herencia (reutilizar y extender clases) y el polimorfismo (que un mismo método actúe distinto según el objeto).

Fuente: https://docs.oracle.com/javase/tutorial/java/concepts/index.html

### 20. ¿Qué es la herencia en POO y cómo se utiliza en Java?

La herencia es cuando una clase (la hija o subclase) recibe los atributos y métodos de otra (la padre o superclase). En Java se hace con la palabra clave extends, por ejemplo class Perro extends Animal. Sirve para reutilizar código y no tener que repetirlo.

Fuente: https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html

### 21. ¿Qué son los modificadores de acceso y cuáles son los más comunes en Java?

Son palabras que controlan desde dónde se puede acceder a una clase, atributo o método. Los más comunes son public (se accede desde cualquier lado), private (solo dentro de la misma clase), protected (misma clase, subclases y mismo paquete) y el default, que es cuando no pones nada y solo se accede dentro del mismo paquete.

Fuente: https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html

### 22. ¿Qué es una variable de entorno y por qué son importantes para Java?

Es un valor que guarda el sistema operativo y que los programas pueden leer, como PATH o JAVA_HOME. En Java son importantes porque JAVA_HOME y PATH permiten que la terminal encuentre el JDK y pueda ejecutar java y javac desde cualquier carpeta, y también sirven para guardar configuración (como rutas o credenciales) fuera del código.

Fuente: https://docs.oracle.com/javase/tutorial/essential/environment/env.html
