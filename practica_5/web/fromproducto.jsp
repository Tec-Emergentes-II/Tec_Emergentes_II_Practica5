<%-- 
    Document   : index

    Author     : Eva Carmen Huaylliri Ajata
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DAO</title>
     <link rel="stylesheet" href="css/style.css">
    </head>
           <h2><c:if test="${producto.id == 0}">NUEVO REGISTRO</c:if></h2>
        <h2><c:if test="${producto.id != 0}">EDITAR REGISTRO</c:if></h2>
    <body>
       
        
        <form action="Inicio" method="POST">
            <input type="hidden" name="id" value="${producto.id}" />
            <label>Descripcion</label>
            <textarea name="descripcion">${producto.descripcion}</textarea>
            <br><br>
            <label>Stock</label>
            <input type="text" name="stock" value="${producto.stock}"/>
            <br><br>
            <input type="submit" value="Enviar Registro">      
        </form>
            
    </body>
</html>
