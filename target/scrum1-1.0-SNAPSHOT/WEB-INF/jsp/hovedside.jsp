<%-- 
    Document   : spill
    Created on : 08.jan.2015, 11:39:40
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
        <title>Hovedside</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <center><h1> Helt etter boka - The Game! </h1></center>
                </div>
            </div>
        </section>
        <div class="container">
        <form:form method="post" action="spill">
            <br><br><br><br><br><br>
            <center><input type='submit' class="btn btn-success btn-lg" value="Start nytt spill"></center>
        </form:form>
        </div>
    </body>
</html>
