<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Riepilogo inserimento - Dischi&Vinili</title>
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
                    <p>Riepilogo inserimento</p>
                </div>
            </header>
        
            <div id="sidebar">
                <!-- menù di navigazione -->
                <nav>
                    <ul>
                        <li><a href="descrizione.jsp">Descrizione del sito</a></li>
                        <li><a href="venditore.html">Venditore</a></li>
                        <li><a href="login.html">Esegui l'accesso</a></li>
                    </ul>
                </nav>
            </div>
            <div id="content">
                <c:if test="${error==true}">
                        <p>Il disco non è stato inserito perché non hai inserito un titolo!</p>
                        <a href="venditore.html">Torna alla pagina venditore</a>
                </c:if>
                <c:if test="${inserito==true}">
                        <p>Il disco è stato inserito!</p>
                        <a href="venditore.html">Torna alla pagina venditore</a>
                </c:if>
                <c:if test="${inserito==false}">
                    <div id="form">
                        <form method="POST" action="venditore.html">
                            <h1>Riepilogo informazioni:</h1>
                            <p>
                                <h2>Titolo:</h2> ${titolo}
                                <h2>Url copertina:</h2> ${urlcopertina}
                                <h2>Descrizione:</h2> ${descrizione}
                                <h2>Prezzo:</h2> ${prezzo}
                                <h2>Quantità:</h2> ${quantita}
                                <h3>Vuoi procedere?</h3>
                                <div id="inserisci">
                                    <input type="hidden" name="Titolo" value="${titolo}">
                                    <input type="hidden" name="UrlCopertina" value="${urlcopertina}">
                                    <input type="hidden" name="Descrizione" value="${descrizione}">
                                    <input type="hidden" name="Prezzo" value="${prezzo}">
                                    <input type="hidden" name="Quantita" value="${quantita}">
                                    <button type="submit" name="Inserisci" value=true>Conferma</button>
                                    <button type="submit" name="Inserisci" value=false>No</button>
                                </div>
                            </p>
                        </form>
                    </div>
                </c:if>
            </div>
            <jsp:include page="footer.jsp" /> 
        </div>
    </body>
</html>
