<%-- 
    Document   : nybruker
    Created on : 07.jan.2015, 11:29:45
    Author     : magnussj
--%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <title>Registrer ny bruker</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1> Registrer ny bruker </h1>
                </div>
            </div>
        </section>
        <div class="container">
        <form:form action="reg" method="POST" modelAttribute="bruker" >
            <div class="form-groupl">
                <b>Fornavn:</b>
                <form:input class="form-control" path="fornavn" placeholder="Fornavn" />
                <br>
                <b>Etternavn:</b>
                <form:input class="form-control" path="etternavn" placeholder="Etternavn" /> 
            <br>
                <b>Epost:</b>
                <form:input class="form-control" path="epost" placeholder="Epost" />
            <br><br>
            <form:button type="submit" class="btn btn-default">Registrer</form:button>
            </div>
        </form:form>
        </div>
        <div class="container">
            <br><br><br><br>
            <form:form method="POST" action="tilbake">
                <center><button class="btn btn-default" type="submit">Tilbake</button></center>
            </form:form>
        </div>
    </body>
</html>
