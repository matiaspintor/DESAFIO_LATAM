# DESAFIO_LATAM
Proyecto de desarrollo test para latam

- Version de spring boot 2.2.4
- Java Open SDK 13
- Motor de base de datos: SQL Server 2017 Standard (GCP)
- IDE: Spring Tool Suite v4.5
- Endpoint lista de usuarios: (GET) http://localhost:8080/usuarios/listar?numeroPagina=0
- Endpoint ingreso de usuarios: (POST) http://localhost:8080/usuarios/ingresar

* Nota 1: Si bien el el endpoint para listar los usuarios no se solicito paginacion, decidi incluir un numero de pagina como parametro, para listar de forma mas ordenada los resultados, y para que desde el frontend se pueda formular la tabla sin sobre cargar el navegador cuando supere los 2.000 registros.

* Nota 2: El endpoint para ingreso de usuarios acepta un objeto JSON como parametro, por ejemplo:

```
{
	"primerNombre": "Matias",
	"segundoNombre": "Alberto",
	"appPaterno": "Pinto",
	"appMaterno": "Ramirez",
	"fechaNacimiento": "01/12/1995"
}
```

