<%-- 
    Document   : form_registra
    Created on : 22-apr-2016, 11.34.35
    Author     : Simone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>esAMMi - login</title>
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
                    <h3>Registrazione Esame</h3>
                    <form action="Registra" method="GET">
                        <!-- Nome, Cognome e Matricola Studente -->
                        <div>
                            <label>${alunno.nome} ${alunno.cognome} 
                                Matricola: ${alunno.id}
                            </label>
                            
                            <input type="hidden" name="Matricola" id="Matricola"
                                   value="${alunno.id}"/>
                        </div>

                        <!-- Lista esami e voto -->
                        <div>
                            <label for="ListaEsami">Lista Esami</label>
                            <select size="3" name="ListaEsami" id="ListaEsami">
                                <c:forEach var="materia" items="${professore.corsiAssegnati}">
                                    <option value="${materia.nome}">
                                    </option>
                                </c:forEach>
                                <option value="PR1">Programmazione 1</option>
                                <option value="PR2">Programmazione 2</option>
                                <option value="AMM">Amministrazione di Sistema</option>
                                <option value="EAI">Elaborazione di Immagini</option>
                                <option value="FS">Fondamenti di Sistema</option>
                                <option value="ARE2">Are 2</option>
                            </select>

                            <label for="voto">Voto</label>
                            <input type="range" min="18" max="31"
                                   name="voto" id="voto">
                        </div>

                        <!-- Descrizione -->
                        <div>
                            <label for="Descrizione">Descrizione</label>
                            <textarea name="Descrizione" id="Descrizione"
                                      cols="40" rows="10" >Descrizione Esame</textarea>
                        </div>

                        <!-- Pulsanti submit e reset -->
                        <div>
                            <input type="submit" name="submit" value="Invia">
                            <input type="reset" name="reset" value="Cancella">
                        </div>           
                    </form>
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
