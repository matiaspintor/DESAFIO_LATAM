# DESAFIO_LATAM_APIREST
Proyecto de desarrollo test para latam api rest desarrollada con Spring Boot

- Version de spring boot 2.2.4
- Java Open SDK 13
- Motor de base de datos: SQL Server 2017 Standard (GCP)
- IDE: Spring Tool Suite v4.5
- Endpoint lista de usuarios: (GET) http://localhost:8080/usuarios/listar?numeroPagina=0
- Endpoint ingreso de usuarios: (POST) http://localhost:8080/usuarios/ingresar

# Deployment con Docker for windows
Para ejecutar la aplicacion con docker es necesario tener instalado docker

- Ejecutar Docker
- Abrir la linea de comandos y situarse a la carpeta del proyecto donde se encuentra el Dockerfile y el docker-compose.yml
- Para crear la imagen de openjdk y del proyecto, ejecutar
```
docker-compose up
```
- Ejecutar el comando para crear el contenedor y agregar el volumen apuntando a la ruta donde se encuentra el proyecto (remplazar RUTA_PROYECTO, mantener comillas dobles)
```
docker run -ti --rm -v "RUTA_PROYECTO":/usr/src/app -p 8080:8080 desafio_latam_apirest bash
```
- Ahora con el contenedor inicializado ejecutar el .jar generado con maven build que se encuentra dentro del contenedor para inciar la aplicacion Spring Boot que estara escuchando en el puerto 8080
```
java -jar target/DesafioLatam-0.0.1-SNAPSHOT.jar
```
- La aplicacion se encontrara escuchando en el puerto 8080
- URL de la aplicacion http://localhost:8080/
- Endpoint lista de usuarios: (GET) http://localhost:8080/usuarios/listar?numeroPagina=0
- Endpoint ingreso de usuarios: (POST) http://localhost:8080/usuarios/ingresar


# Deployment sin Docker

- Instalar el opensdk version 13
- Agregar la variable de entorno con la ruta del sdk (\JDK13\bin) a la variable PATH
- Instalar y ejecutar el Spring Tool Suite v4.5
- Abrir el proyecto en STS
- Ejecutar DesafioLatamApplication.java como SpringBoot Aplication
- Endpoint lista de usuarios: (GET) http://localhost:8080/usuarios/listar?numeroPagina=0
- Endpoint ingreso de usuarios: (POST) http://localhost:8080/usuarios/ingresar
* Nota 1: Si bien el el endpoint para listar los usuarios no se solicito paginacion, decidi incluir un numero de pagina como parametro, para listar de forma mas ordenada los resultados, y para que desde el frontend se pueda formular la tabla sin sobre cargar el navegador cuando supere los 2.000 registros. *

* Nota 2: El endpoint para ingreso de usuarios acepta un objeto JSON como parametro, por ejemplo: *

```
{
	"primerNombre": "Matias",
	"segundoNombre": "Alberto",
	"appPaterno": "Pinto",
	"appMaterno": "Ramirez",
	"fechaNacimiento": "01/12/1995"
}
```