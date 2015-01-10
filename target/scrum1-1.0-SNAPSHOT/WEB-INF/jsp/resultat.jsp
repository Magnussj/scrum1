<%-- 
    Document   : resultat
    Created on : 09.jan.2015, 10:30:26
    Author     : Nikolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <title>Resultat</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1> Resultat </h1>
                </div>
            </div>
        </section>
        <div class="container">
        <h2>Du fikk ${spillobjekt.totalPoeng} poeng!</h2>
        
        <form:form method="POST" modelAttribute="spillobjekt" action="redirect">
            <table>
                <tr>
                <br>
                   <td> <input type='submit' class="btn btn-default" value="Ferdig"> </td>
                </tr>
            </table>
        </form:form>
        </div>
    </body>
</html>
