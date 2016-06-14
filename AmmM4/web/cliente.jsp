<%-- 
    Document   : cliente
    Created on : 1-mag-2016, 23.11.57
    Author     : Simone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Pagina Cliente - Dischi&Vinili</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Simone Picciau">
        <meta name="keywords" content="cliente,  musica, dischi, cd, vinili">
        <meta name="description" content="Prodotti in vendita">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        <script type="text/javascript" src="js/jquery-2.2.4.js"></script>
        <script type="text/javascript" src="js/filtraDischi.js"></script>
        
        
        
    </head>
    <body>
        <div id="pagina">
            <header>
                <div id="header">
                    <div id="logo"></div>
                    <h1>Dischi&Vinili</h1>
                    <p>Pagina cliente</p>
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
                <h1>Benvenuto ${cliente.getNome()} ${cliente.getCognome()}</h1> 
                <h2>Cliente Id:${cliente.getId()} - Nickname: ${cliente.getUsername()}</h2>
                <h3>Saldo: ${cliente.getSaldo()}</h3>
                <h2>Dischi in vendita:</h2>
            <!-- Oggetti in vendita -->
                <label for="filtra" id="filtra_label">Cerca</label>
                <input type="text" id="filtra" name="filtra">
                <table class="tabellaVendite">
                    <tr class="intestazioneTabella">
                        <th>Titolo</th>
                        <th>Copertina</th>
                        <th>Disponibilità</th>
                        <th>Prezzo</th>
                        <th>Carrello</th>
                    </tr>
                    <c:forEach var="disco" items="${dischi}">
                        <tr class="rigaDispari">
                            <td class="titolo">${disco.getTitolo()}</td>
                            <td class="copertina"><img src="${disco.getCopertina()}" title="${disco.getTitolo()}" 
                                     alt="${disco.getTitolo()}" width="180" height="180"></td>
                            <td class="disponibilità">${disco.getDisponibilita()}</td>
                            <td class="prezzo">${disco.getPrezzo()}</td>
                            <td class="carrello"><a href="cliente.html?idDisco=${disco.getId()}">Acquista</a></td>                    
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <jsp:include page="footer.jsp" /> 
        </div>
    </body>
</html>