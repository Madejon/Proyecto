<!--Html en el que se elegirá que opción del menú selecciona el usuario -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- Botón que nos llevará al .java que servirá para que el usuario introduzca los datos -->
<form action="rellenar.jsp"><button>Rellenar</button></form>

<!-- Botón que nos llevará al .java que servirá para que el usuario busque por los datos que decida -->
<form action="Buscar"><button>Buscar</button></form>

<!-- Botón que nos llevará al .java que servirá para que el usuario introduzca los datos qu desea modificar-->
<form action="actualizar.jsp"><button>Actualizar</button></form>

<!-- Botón que nos llevará al .java que servirá para que el usuario introduce el producto que desea eliminar -->
<form action="borrar.jsp"><button>Borrar</button></form>

<!-- Botón que nos llevará al .java que servirá para que el usuario vea los datos  que estan por encima del stock mínimo-->
<form action="Resumen"><button>Resumen</button></form>

</body>
</html>