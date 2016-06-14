<%-- 
    Document   : modifica
    Created on : 4-giu-2016, 13.36.04
    Author     : Simone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Modifica Disco - Dischi&Vinili</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Simone Picciau">
        <meta name="keywords" content="venditore, musica, dischi, cd, vinili">
        <meta name="description" content="Aggiungi un prodotto in vendita">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <div id="pagina">
            <header>
                <div id="header">
                    <div id="logo"></div>
                    <h1>Dischi&Vinili</h1>
                    <p>Modifica Disco</p>
                </div>
            </header>

            
            <div id="sidebar">
                <!-- Navigazione -->
                <nav>
                    <ul>
                        <li><a href="descrizione.jsp">Descrizione del sito</a></li>
                        <li><a href="login.html">Esegui l'accesso</a></li>
                    </ul>
                </nav>
            </div>
            
            <div id="content">
                <h2>Modifica Disco</h2>
                <!-- Form di inserimento prodotto -->
                <c:if test="${modificato==true}">
                        <p>Il disco è stato modificato!</p>
                        <a href="venditore.html">Torna alla pagina venditore</a>
                </c:if>
                <c:if test="${modificato==false}">
                    <div id="form">
                        <form method="POST" action="venditore.html">
                            <ul>
                                <li>
                                    <input type="hidden" name="idDiscoChange" value="${disco.getId()}">
                                    <label for="Titolo">Titolo del disco: </label>
                                    <input type="text" name="Titolo" 
                                           id="Titolo" value="${disco.getTitolo()}"/>
                                </li>
                                <li>
                                    <label for="UrlCopertina">Url della copertina: </label>
                                    <input type="text" name="UrlCopertina" 
                                           id="UrlCopertina" value="${disco.getCopertina()}"/>
                                </li>
                                <li>
                                    <label for="Descrizione">Descrizione del disco: </label>
                                    <textarea rows="4" cols="20" name="Descrizione"
                                              id="Descrizione">${disco.getDescrizione()}</textarea>
                                </li>
                                <li>
                                    <label for="Prezzo">Prezzo del disco: </label>
                                    <input type="number" name="Prezzo" 
                                           id="Prezzo" value="${disco.getPrezzo()}">
                                </li>
                                <li>
                                    <label for="Quantita">Numero di dischi disponibili: </label>
                                    <input type="number" name="Quantita" 
                                           id="Quantita" value="${disco.getDisponibilita()}">
                                </li>
                                <li>
                                    <input type="submit" name="Change" value="ChangeDisco" />
                                </li>                            
                            </ul>
                        </form>
                    </div>
                </c:if>
            </div>
            <jsp:include page="footer.jsp" /> 
        </div>
    </body>
</html>
