 
 Instrucciones Descarga y Ejecucion del Programa en MAVEN
 
 1. Abrir GirBash
 2. Ubicarse en el directoro donde desea descargar el proyecto
 3. Descargar el proyecto cine lsigueinte comando
 git clone https://github.com/wario8a/ECOS.git PSP1
 4. Al descargar el proyecto correctaente debe salir algo como est:
 Cloning into 'PSP1'...
remote: Counting objects: 29, done.
remote: Compressing objects: 100% (12/12), done.
remote: Total 29 (delta 0), reused 29 (delta 0), pack-reused 0
Unpacking objects: 100% (29/29), done.
Checking connectivity... done.
5. cambiar a la carpeta donde descarg el proyecto 
cd PSP1/
6. Contruir el programa usando MAVEN
mvn package
7. ubicarse el el directorio target\classes
cd target/
cd classes
8. Correr el programa desde MAVEN
java edu.uniandes.ecos.ASE.app.App