<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Acquisto - Dischi&Vinili</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Simone Picciau">
        <meta name="keywords" content="login, musica, dischi, cd, vinili">
        <meta name="description" content="Pagina di acquisto">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <div id="pagina">
            <header>
                <div id="header">
                    <div id="logo"></div>
                    <h1>Dischi&Vinili</h1>
                    <p>Acquisto</p>
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
                    <c:if test="${esito==true}">
                        <p>Il tuo acquisto del disco "${disco.getTitolo()}" è stato confermato</p>
                    </c:if>
                    <c:if test="${esito==false}">
                        <p>Il tuo acquisto di "${disco.getTitolo()}" non è stato confermato</p>
                        <p>Verifica il tuo credito oppure riprova più tardi.</p>
                    </c:if>    
                    <a href="cliente.html">Torna alla lista dei dischi</a>    
                </div>
            </div>
            <jsp:include page="footer.jsp" /> 
        </div>
    </body>
</html>