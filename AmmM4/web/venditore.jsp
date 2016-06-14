<%-- 
    Document   : venditore
    Created on : 1-mag-2016, 23.12.25
    Author     : Simone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Pagina Venditore - Dischi&Vinili</title>
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
                    <p>Pagina venditore</p>
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
                <h1>Benvenuto ${venditore.getNome()} ${venditore.getCognome()}</h1> 
                <h2>Vendor Id:${venditore.getId()} - Nickname: ${venditore.getUsername()}</h2>
                <h3>Feedback: ${venditore.getFeedback()}</h3>
                <h3>Saldo: ${venditore.getSaldo()}</h3>
                <h2>Inserisci un nuovo disco in vendita</h2>
                <!-- Form di inserimento prodotto -->
                <div id="form">
                    <form method="POST" action="venditore.html">
                        <ul>
                            <li>
                                <label for="Titolo">Titolo del disco: </label>
                                <input type="text" name="Titolo" id="Titolo" />
                            </li>
                            <li>
                                <label for="UrlCopertina">Url della copertina: </label>
                                <input type="text" name="UrlCopertina" id="UrlCopertina"/>
                            </li>
                            <li>
                                <label for="Descrizione">Descrizione del disco: </label>
                                <textarea rows="4" cols="20" name="Descrizione"
                                          id="Descrizione">Inserisci la descrizione</textarea>
                            </li>
                            <li>
                                <label for="Prezzo">Prezzo del disco: </label>
                                <input type="number" name="Prezzo" id="Prezzo">
                            </li>
                            <li>
                                <label for="Quantita">Numero di dischi disponibili: </label>
                                <input type="number" name="Quantita" id="Quantita">
                            </li>
                            <li>
                                <input type="submit" name="Insert" value="Inserisci prodotto" />
                                <input type="reset" value="Reset"/>
                            </li>                            
                        </ul>
                    </form>
                </div>
                <h2>Oggetti in vendita</h2>
                    <c:if test="${numDischi == 0}">
                        <h2>Non hai dischi in vendita!</h2>
                    </c:if>
                    <c:if test="${numDischi > 0}">
                        <table class="tabellaVendite">
                            <tr class="intestazioneTabella">
                                <th>Titolo</th>
                                <th>Copertina</th>
                                <th>Disponibilità</th>
                                <th>Prezzo</th>
                                <th>Modifica</th>
                            </tr>
                            <c:forEach var="disco" items="${dischi}">
                                <tr class="rigaDispari">
                                    <td class="titolo">${disco.getTitolo()}</td>
                                    <td class="copertina"><img src="${disco.getCopertina()}" title="${disco.getTitolo()}" 
                                             alt="${disco.getTitolo()}" width="180" height="180"></td>
                                    <td class="disponibilità">${disco.getDisponibilita()}</td>
                                    <td class="prezzo">${disco.getPrezzo()}</td>
                                    <td class="elimina"><a href="venditore.html?idDiscoToDelete=${disco.getId()}">Elimina</a>
                                     / <a href="venditore.html?idDiscoToChange=${disco.getId()}">Modifica</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
            </div>
            <jsp:include page="footer.jsp" /> 
        </div>
    </body>
</html>