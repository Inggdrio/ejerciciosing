# Parte Teórica

Taller de nivelación PI a PII — Institución Universitaria Antonio José Camacho (UNIAJC)

---

## ¿Qué es Markdown?

Markdown es un **lenguaje de marcado ligero** que permite dar formato a texto plano
de forma sencilla y legible usando caracteres simples (`#`, `*`, `-`, `[]`, etc.),
y que se convierte fácilmente a HTML. Los documentos son archivos de texto plano con
extensión `.md`. Es muy usado en GitHub, documentación técnica, blogs y notas.
Hoy el estándar de referencia para el Markdown básico es **CommonMark**.

> Referencia: [Guía rápida de Markdown — mouredev](https://mouredev.pro/recursos) ·
> [CommonMark](https://commonmark.org) · [Escribir en GitHub](https://docs.github.com/es/get-started/writing-on-github)

---

## Git

**1. ¿Qué es un repositorio en Git y cómo se diferencia de un proyecto "normal"?**
Un repositorio es una carpeta de proyecto que, además de los archivos, contiene una
carpeta oculta `.git` donde Git guarda **todo el historial de cambios** (versiones,
ramas, autores). Un proyecto "normal" solo tiene los archivos en su estado actual; un
repositorio, en cambio, rastrea cada versión y permite volver a estados anteriores.

**2. Las tres áreas principales de Git**

- **Working directory (directorio de trabajo):** los archivos reales que estás editando.
- **Staging area / index (área de preparación):** una zona intermedia donde marcas qué
  cambios entrarán en el próximo commit.
- **Repository (.git):** donde quedan guardados de forma permanente los commits confirmados.

El flujo normal es: editas (working) → `git add` (staging) → `git commit` (repository).

**3. ¿Cómo representa Git los cambios internamente? (blob, tree, commit y tag)**
Git guarda **snapshots** (fotos completas), no diferencias. Lo hace con cuatro tipos de objeto:

- **blob:** el contenido de un archivo.
- **tree:** un directorio; lista blobs y otros trees con sus nombres.
- **commit:** apunta a un tree (la foto del proyecto) más el/los commit(s) padre, autor,
  fecha y mensaje.
- **tag:** una etiqueta que apunta a un commit (por ejemplo una versión `v1.0`).

Cada objeto se identifica por un hash. *(Ref: Pro Git – Git Objects, git-scm.com)*

**4. ¿Cómo se crea un commit y qué información almacena?**
Se crea con `git add` (preparar cambios) y luego `git commit -m "mensaje"`. Un objeto commit
almacena: el puntero al **tree** (snapshot del proyecto), el/los **commit(s) padre**, el
**autor** y la **fecha**, quién lo confirmó, el **mensaje** y su **hash** identificador.

**5. Diferencia entre `git pull` y `git fetch`**
`git fetch` **descarga** los cambios del repositorio remoto pero no los mezcla con tu trabajo.
`git pull` hace **`fetch` + `merge`**: descarga los cambios y además los fusiona en tu rama actual.

**6. ¿Qué es un branch (rama) y cómo gestiona Git los punteros a commits?**
Una rama es un **puntero móvil** que apunta a un commit. Crear una rama es crear un nuevo
puntero. Cada vez que haces un commit, el puntero de la rama avanza automáticamente al nuevo
commit. `HEAD` es un puntero especial que indica en qué rama estás trabajando.

**7. ¿Cómo se realiza un merge y qué conflictos pueden surgir?**
Un `git merge` **une** el trabajo de dos ramas. Surge un **conflicto** cuando ambas ramas
modificaron la **misma parte del mismo archivo**. Git marca las zonas en conflicto con
`<<<<<<<`, `=======`, `>>>>>>>`; se resuelve **editando el archivo** para dejar la versión
correcta y luego `git add` y `git commit`.

**8. ¿Cómo funciona el área de staging (`git add`) y qué pasa si lo omito?**
`git add` selecciona qué cambios entrarán en el próximo commit (los mueve al staging).
Si lo omites, esos cambios **no se incluyen** en el commit: quedan solo en tu directorio de
trabajo sin confirmar.

**9. ¿Qué es `.gitignore` y cómo influye en el seguimiento de archivos?**
Es un archivo de texto que lista **patrones de archivos que Git debe ignorar**, es decir, no
rastrear ni subir (por ejemplo binarios compilados, `node_modules/`, `*.class`, o archivos
con credenciales). Evita que basura o información sensible entre al repositorio.

**10. Diferencia entre `commit --amend` y un nuevo commit**
`git commit --amend` **modifica el último commit** (cambia su contenido o su mensaje) y genera
un nuevo hash en su lugar. Un commit nuevo, en cambio, **agrega** otro commit al historial sin
tocar el anterior.

**11. ¿Qué es `git stash` y en qué escenarios es útil?**
`git stash` **guarda temporalmente** los cambios sin confirmar y deja el directorio de trabajo
limpio. Es útil cuando necesitas cambiar de rama o traer cambios sin perder lo que llevas a
medias; luego los recuperas con `git stash pop`.

**12. ¿Qué mecanismos ofrece Git para deshacer cambios?**

- **`git checkout` / `git restore`:** descarta cambios locales y vuelve a la última versión guardada.
- **`git reset`:** mueve el puntero de la rama / saca cambios del staging (`--soft`, `--mixed`, `--hard`).
- **`git revert`:** crea un **commit nuevo que deshace** otro anterior; es seguro para historial ya compartido.

**13. ¿Cómo funciona la configuración de remotos (origin, upstream) y forks?**

- **`origin`:** nombre por defecto de **tu** repositorio remoto (tu copia / fork en GitHub).
- **`upstream`:** el repositorio **original** del que hiciste el fork.

Comandos típicos: `git remote add <nombre> <url>`, `git remote -v` (ver remotos),
`git fetch upstream` (traer cambios del original) y `git push origin <rama>` (subir a tu repo).

**14. ¿Cómo inspecciono el historial de commits?**

- **`git log`:** lista el historial de commits (autor, fecha, mensaje, hash).
- **`git diff`:** muestra las diferencias entre versiones o entre áreas (working/staging).
- **`git show <commit>`:** muestra el detalle y los cambios de un commit concreto.

> Referencia general de Git: [Pro Git Book (git-scm.com)](https://git-scm.com/book/es/v2) ·
> [Git Internals – Git Objects](https://git-scm.com/book/en/v2/Git-Internals-Git-Objects)

---

## Programación (Java)

**15. ¿Cuáles son los tipos de datos primitivos en Java?**
Son ocho: `byte`, `short`, `int`, `long` (enteros), `float`, `double` (decimales),
`char` (un carácter) y `boolean` (`true`/`false`).

**16. ¿Cómo funcionan las estructuras de control de flujo (if, else, switch y bucles)?**

- **`if` / `else`:** ejecutan un bloque u otro según una condición booleana.
- **`switch`:** elige un bloque entre varios según el valor de una variable.
- **Bucles (`for`, `while`, `do-while`):** repiten un bloque mientras se cumpla una condición.

**17. ¿Por qué es importante usar nombres significativos para variables y métodos?**
Porque el código se **lee** muchas más veces de las que se escribe. Nombres claros
(`sumaTotal` en vez de `x`) hacen el programa más **legible, mantenible** y fácil de entender
para ti y para otros, y reducen errores.

**18. ¿Qué es la Programación Orientada a Objetos (POO)?**
Es un paradigma que organiza el software en **objetos**, que combinan **datos** (atributos) y
**comportamiento** (métodos). Los objetos se crean a partir de **clases**, que actúan como plantillas.

**19. ¿Cuáles son los cuatro pilares de la POO?**
**Encapsulamiento** (ocultar el estado interno y exponer solo lo necesario),
**Abstracción** (modelar lo esencial y ocultar detalles), **Herencia** (reutilizar y
extender clases) y **Polimorfismo** (un mismo método se comporta distinto según el objeto).

**20. ¿Qué es la herencia en POO y cómo se utiliza en Java?**
Es el mecanismo por el cual una clase (**subclase/hija**) **hereda** atributos y métodos de
otra (**superclase/padre**). En Java se usa la palabra clave **`extends`**. Permite reutilizar
código y especializar comportamientos. Ejemplo: `class Perro extends Animal { }`.

**21. ¿Qué son los modificadores de acceso y cuáles son los más comunes en Java?**
Controlan la **visibilidad** de clases, atributos y métodos:

- **`public`:** accesible desde cualquier lugar.
- **`private`:** accesible solo dentro de la misma clase.
- **`protected`:** accesible en la misma clase, subclases y mismo paquete.
- **default** (sin modificador): accesible solo dentro del mismo paquete.

**22. ¿Qué es una variable de entorno y por qué es importante para Java?**
Es un valor guardado por el **sistema operativo** al que pueden acceder los programas
(por ejemplo `PATH` o `JAVA_HOME`). En Java son importantes porque `JAVA_HOME` y `PATH`
permiten localizar el JDK y ejecutar `java` y `javac` desde cualquier carpeta de la terminal.

> Referencia general de Java: [Documentación oficial de Java – Oracle](https://docs.oracle.com/javase/tutorial/java/index.html)

---

### Referencias

- Guía rápida de Markdown, *mouredev* — https://mouredev.pro/recursos
- CommonMark (estándar de Markdown) — https://commonmark.org
- Escribir en GitHub — https://docs.github.com/es/get-started/writing-on-github
- Pro Git Book (git-scm.com) — https://git-scm.com/book/es/v2
- Git Internals – Git Objects — https://git-scm.com/book/en/v2/Git-Internals-Git-Objects
- Documentación oficial de Java, Oracle — https://docs.oracle.com/javase/tutorial/java/index.html
