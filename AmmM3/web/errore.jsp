<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Errore - Dischi&Vinili</title>
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
                    <p>Errore</p>
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
                <div id="form">
                        <p>Errore!!!</p>
                        <p>Non puoi accedere a quest'area!!!</p>
                </div>
            </div>
            <jsp:include page="footer.jsp" /> 
        </div>
    </body>
</html>
