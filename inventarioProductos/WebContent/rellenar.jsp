<!-- Html en el cual el usuario introducirá los datos que posteriormente iran a la base de datos-->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- Formulario que llamará a Inventario.java para que guarde los datos introducidos en la BBDD-->

<form method="GET" action="Inventario">
		<input type="text" name="producto" value="producto"><br> 
		<input type="text" name="cantidad" value="cantidad"><br> 
		<input type="text" name="precio" value="precio"><br> 
		<input type="text" name="categoria" value="categoria"><br> 
		<input type="text" name="stockmin" value="stockmin"><br> 
		<input type="submit">	
	</form>


</body>
</html>