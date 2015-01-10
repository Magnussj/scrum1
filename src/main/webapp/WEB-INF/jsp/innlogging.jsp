<%-- 
    Document   : innlogging
    Created on : 07.jan.2015, 11:21:47
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
        <title>Innlogging</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1> Innlogging </h1>
                </div>
            </div>
        </section>
        
        <div class="container">
            <form:form action="logginn" method="POST" modelAttribute="bruker">
                <div class="form-group">
                    <b> Epost: </b>
                    <form:input class="form-control" path="epost" placeholder="Skriv epost" />
                    <br>
                    <b> Passord: </b>
                    <form:password class="form-control" path="passord" placeholder="Skriv passord" />
                    <br><br>
                    <form:button type="submit" class="btn btn-success">Logg inn</form:button>
                </div>
            </form:form>
        </div>
        
        <div class="container">
            <br><br><br><br><br><br>
            <form:form method="POST" action="regny">
                <p><center><button type="submit" class="btn btn-default">Registrer ny bruker</button></center></p>
            </form:form>
        </div>
    </body>
</html>
