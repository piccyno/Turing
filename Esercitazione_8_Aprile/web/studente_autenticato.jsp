<%-- 
    Document   : professore_autenticato
    Created on : 15-apr-2016, 11.53.29
    Author     : Simone
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jst1/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>esAMMi - studente autenticato</title>
        <meta name="keywords" content="AMM esami docente">
        <meta name="description" content="Una pagina per gestire le funzioni dei docenti">
        <link rel="shortcut icon" type="image/x-icon" href="http://spano.sc.unica.it/amm2014/davide/esami14/images/favicon.ico">
        <link href="css/responsive.css" rel="stylesheet" type="text/css" media="screen">
        <style type="text/css"></style></head>
    <body>
        <div id="page">
            <header>
                <div class="social">
                    <p>Accesso al sistema</p>
                    <ul>
                        <li id="facebook"><a href="http://www.facebook.com">facebook</a></li>
                        <li id="twitter"><a href="https://twitter.com/">twitter</a></li>
                        <li id="linkedin"><a href="http://www.linkedin.com/">linkedin</a></li>
                    </ul>
                </div>
                <!--  header -->
                <div id="header">
                    <div id="logo">
                        <h1>EsAMMi</h1>
                    </div>

                    <!-- select per la versione del menu mobile -->
                    <select class="menu">
                        <option>Menu</option>
                    </select>
                    <!-- tabs -->
                    <div id="menu">
                        <ul>
                            <li><a class="current_page_item" href="#">Home</a></li>
                        </ul>                   
                    </div>
                </div>
            </header>
            <!-- start page -->
            <!--  sidebar 1 -->
            <div id="sidebar1">
                <ul>
                    <li id="categories">
                        <h2 class="icon-title">Navigazione</h2>
                        <ul>
                            <li><a href="#˙">Home</a></li>
                        </ul>
                    </li>
                    <li id="external">
                        <h2 class="icon-title">Link esterni</h2>
                        <ul>
                            <li><a href="http://www.unica.it/">Università di Cagliari</a></li>
                            <li><a href="http://www.unica.it/">Facoltà</a></li>

                        </ul>
                    </li>

                </ul>
            </div>

            <div id="sidebar2">
                <h2 class="icon-title" id="help">Istruzioni</h2>
                <p>
                    Pagina per l'accesso al sistema.
                </p>
            </div>

            <!-- contenuto -->
            <div id="content">
                <div class="input-form">
                    <h3>Bentornato/a ${studente.nome} ${studente.cognome}</h3>
                    <div>
                        Id: ${studente.id}
                    </div>
                    <div>
                        Esami sostenuti:
                        <ul>
                            <c:forEach var="esame" items="${studente.esamiSuperati}">
                                <li>${esame.materia.nome} - ${esame.voto}</li>
                            </c:forEach>
                        </ul>
                    </div>

                    
                </div>
            </div>

            <div class="clear">
            </div>
            <!--  footer -->
            <footer>
                <div id="footer">
                    <p>
                        Applicazione d'esempio per l'esame di Amministrazione di Sistema
                    </p>


                </div>
                <div class="validator">
                    <p>
                        <a href="http://validator.w3.org/check/referer" class="xhtml" title="Questa pagina contiene HTML valido">
                            <abbr title="eXtensible HyperText Markup Language">HTML</abbr> Valido</a>
                        <a href="http://jigsaw.w3.org/css-validator/check/referer" class="css" title="Questa pagina ha CSS validi">
                            <abbr title="Cascading Style Sheets">CSS</abbr> Valido</a>
                    </p>
                </div>
            </footer>
        </div>
    </body>
</html>
