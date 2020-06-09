# Tec_Emergentes_II_Practica5
Patrón de diseño DAO
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
        <title>Patron de DAO</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body background="imag1.jpg">
          <center>
        <h1>PRACTICA N° 5</h1>
        <h1>Patron de disenio DAO</h1>
        <table border="5">
            <tr>
                <th>Carrera:</th>
                <td>Ingenieria de Sistemas</td>
                <td rowspan="20"><h1>H.</h1></td>
            </tr>
            <tr>
                <th>Materia:</th>
                <td>Tecnologías Emergentes II</td>
            </tr>
            <tr>
                <th>Apellidos y nombres:</th>
                <td>Huaylliri Ajata Eva Carmen</td>
            </tr>
            <tr>
                <th>C.I:</th>
                <td>9125413 L.P.</td>
            </tr>
            <tr>
                <th>Lugar y Fecha:</th>
                <td>El Alto, 2 de Junio del 2020</td>
            </tr>
        </table>
        </center>
           <h2>PRODUCTOS</h2>
    <p><a href="Inicio?accion=nuevo">Nuevo Producto</a></p>
        <table border="10">
            <tr>
                <th>Id</th>
                <th>Descripcion</th>
                <th>Stock</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${productos}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.descripcion}</td>
                    <td>${item.stock}</td>
                    <td><a href="Inicio?accion=editar&id=${item.id}">Editar</a></td>
                    <td><a href="Inicio?accion=eliminar&id=${item.id}"  onclick="return(confirm('Esta Seguro?'))">Eliminar</a></td>
                    
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
