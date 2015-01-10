<%-- 
    Document   : flervalg
    Created on : 08.jan.2015, 13:36:42
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
        <title>JSP Page</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1> Flervalgs </h1>
                </div>
            </div>
        </section>
        <div class="container">
        ${spillobjekt.gjeldendeOppgave.oppgavetekst}
        <form:form method="POST" modelAttribute="spillobjekt" action="spill">
            <table>
                <tr>
                    <td> 
                        <c:forEach items="${spillobjekt.gjeldendeOppgave.alternativer}" var="gjeldende">
                            <form:radiobutton path="gjeldendeOppgave.svar" value="${gjeldende}" /> ${gjeldende} <br>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td> <br><input type='submit' class="btn btn-default" value="SEND"> </td>
                </tr>
            </table>
        </form:form>
        </div>
    </body>
</html>
