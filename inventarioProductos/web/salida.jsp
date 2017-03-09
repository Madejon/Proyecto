<%-- 
    Document   : salida
    Created on : 03-mar-2017, 9:14:12
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sesion iniciada</title>
        
    </head>
    <body>
        <b><%out.println("Bienvenido: "+session.getId()); %></b><form action="cerrarSession" method="post"><input type="submit" value="Cerrar Sesion"></form>
   </body>
</html>
