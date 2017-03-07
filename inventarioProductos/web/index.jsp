<%-- 
    Document   : index
    Created on : 03-mar-2017, 8:50:15
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <body>
        <form action="servletSalida" method="post">
            <br><label>Nombre&nbsp&nbsp</label><input type="text" name="Nombre">   <label>Email&nbsp&nbsp</label><input type="text" name="Email">   <label>Contraseña&nbsp&nbsp</label><input type="password" name="Pass">  <input name="iniciar" type="submit" value="iniciar"> 
            <a href="recuperarContrasena.html">Recuperar contraseña</a>
            <a href="entrada.html">Usuario nuevo</a>
        </form>
        <script src="js/sha1.js"></script>
	<script>
		function cifrar(){
			var input_pass = document.getElementById("Pass");
			input_pass.value = sha1(input_pass.value);
		}
	</script>
    </body>
</html>
