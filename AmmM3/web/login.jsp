<%-- 
    Document   : login
    Created on : 1-mag-2016, 22.51.11
    Author     : Simone
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Log-In su Dischi&Vinili</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Simone Picciau">
        <meta name="keywords" content="login, musica, dischi, cd, vinili">
        <meta name="description" content="Pagina di autenticazione">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <div id="pagina">
            <header>
                <div id="header">
                    <div id="logo"></div>
                    <h1>Dischi&Vinili</h1>
                    <p>Login</p>
                </div>
            </header>
        
            <div id="sidebar">
                <!-- menù di navigazione -->
                <nav>
                    <ul>
                        <li><a href="descrizione.jsp">Descrizione del sito</a></li>
                        <li><a href="cliente.html">Cliente</a></li>
                        <li><a href="venditore.html">Venditore</a></li>
                        <li><a href="login.html">Esegui l'accesso</a></li>
                    </ul>
                </nav>
            </div>

            <div id="content">
                <!-- Form di autenticazione -->
                <div id="form">
                    <form method="POST" action="login.html">
                        <ul>
                            <li>
                                <label for="Username">Nome Utente: </label>
                                <input type="text" name="Username" id="Username" />
                            </li>
                            <li>
                                <label for="Password">Password: </label>
                                <input type="password" name="Password" id="Password"
                                       value="password" />
                            </li>
                            <li>
                                <input type="submit" name="Login" value="Login" />
                            </li>
                        </ul>
                    </form>
                    <c:if test="${loggedId==false}">
                        <p>Credici!!!</p>
                    </c:if>
                </div>
            </div>
            <jsp:include page="footer.jsp" /> 
        </div>
    </body>
</html>
