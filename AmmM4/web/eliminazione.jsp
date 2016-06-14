<%-- 
    Document   : eliminazione
    Created on : 3-giu-2016, 21.53.38
    Author     : Simone
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Eliminazione - Dischi&Vinili</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Simone Picciau">
        <meta name="keywords" content="login, musica, dischi, cd, vinili">
        <meta name="description" content="Pagina di eliminazione">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <div id="pagina">
            <header>
                <div id="header">
                    <div id="logo"></div>
                    <h1>Dischi&Vinili</h1>
                    <p>Eliminazione</p>
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
                <c:if test="${eliminato==true}">
                        <p>Il disco è stato eliminato!</p>
                        <a href="venditore.html">Torna alla pagina venditore</a>
                </c:if>
                <c:if test="${eliminato==false}">
                    <div id="form">
                        <h1>Sei sicuro di voler rimuovere questo disco?</h1>
                        <p>
                            <h2>Titolo:</h2> ${disco.getTitolo()}
                            <h2>Descrizione:</h2> ${disco.getDescrizione()}
                            <img src="${disco.getCopertina()}" title="${disco.getTitolo()}" 
                                         alt="${disco.getTitolo()}" width="180" height="180">
                            <h2>Prezzo:</h2> ${disco.getPrezzo()}
                            <form method="post" action="venditore.html">
                                <input type="hidden" name="idDiscoToDelete" value="${disco.getId()}">
                                <!--<input type="hidden" name="idDisco" value="0">-->
                                <div id="elimina">
                                    <button type="submit" name="Elimina" value=true>Elimina</button>
                                    <button type="submit" name="Elimina" value=false>No</button>
                                </div>
                            </form>
                        </p>    
                    </div>
                </c:if> 
            </div>
            <jsp:include page="footer.jsp" /> 
        </div>
    </body>
</html>
