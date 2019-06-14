<%-- 
    Document   : listar-responsaveis
    Created on : 13/06/2019, 21:25:13
    Author     : priscyla.poliveira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Prova PI3-B</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1>Gerenciamento de responsáveis</h1><br>
        <table class="table table-hover">
            <thead class="thead-dark">
                <tr>
                    <th>Id</th>
                    <th>Nome</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaResponsaveis}" var="responsavel">
                    <tr>
                        <td><c:out value="${responsavel.id}"/></td>
                        <td><c:out value="${responsavel.nome}"/></td>
                    </tr>
                </c:forEach> 
            </tbody>
        </table>
        <a href="/pi3b-prova2/incluir-responsaveis.jsp"><h4>Incluir novo responsavel</h4></a>
    </body>
</html>
