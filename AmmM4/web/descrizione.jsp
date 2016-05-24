<%-- 
    Document   : descrizione
    Created on : 1-mag-2016, 23.10.06
    Author     : Simone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Descrizione Shop On-Line</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Simone Picciau">
        <meta name="keywords" content="descrizione, musica, dischi, cd, vinili">
        <meta name="description" content="Descrizione del sito">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    <body>
        <div id="pagina">
            <header>
                <div id="header">
                    <div id="logo"></div>
                    <h1>Dischi&Vinili</h1>
                    <p>Benvenuti nel nostro e-Shop di compravendita</p>
                </div>
            </header>
        
            <div id="sidebar">
                <!-- Navigazione -->
                <nav>
                    <ul>
                        <li>
                            <a href="#prodotti">Cosa si può vendere</a>
                            <ul class="sottolista">
                                <li><a href="#Pop">Pop</a></li>
                                <li><a href="#Rock">Rock</a></li>
                                <li><a href="#Elettronica">Elettronica</a></li>
                                <li><a href="#Jazz">Jazz</a></li>
                                <li><a href="#Country">Country</a></li>
                                <li><a href="#Classica">Classica</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#funzioni">Funzionalità</a>
                            <ul class="sottolista">
                                <li><a href="#Vendita">Vendita</a></li>
                                <li><a href="#Acqusito">Acquisto</a></li>
                                <li><a href="#Pagamenti">Pagamenti</a></li>
                                <li><a href="#RaccoltaPunti">Raccolta Punti</a></li>
                            </ul>
                        </li>

                        <li><a href="login.html">Login</a></li>
                    </ul>
                </nav>
            </div>
        
            <div id="content">
                <!-- Prodotti -->
                <h2 id="prodotti">Cosa si può vendere</h2>
                <p>Compact Disc e Vinili di ogni genere musicale</p>
                    <h3 id="Pop">Pop</h3>
                    <p>La musica pop, traduzione del termine inglese pop music, è un 
                        genere appartenente all'insieme della popular music, che trova
                        origine nella sua forma moderna negli anni '50 come derivazione
                        del rock and roll</p>

                    <h3 id="Rock">Rock</h3>
                    <p>Il rock, o musica rock, è un genere della popular music 
                        sviluppatosi negli Stati Uniti e nel Regno Unito nel corso 
                        degli anni cinquanta e sessanta del Novecento. È 
                        un'evoluzione del rock and roll, ma trae le sue origini 
                        anche da numerose altre forme di musica dei decenni precedenti, 
                        come il rhythm and blues e il country, con eventuali richiami 
                        anche alla musica folk. Musicalmente, il rock è incentrato 
                        sull'uso della chitarra elettrica, solitamente accompagnata, 
                        in un gruppo rock, dal basso elettrico e dalla batteria.</p>

                    <h3 id="Elettronica">Elettronica</h3>
                    <p>Per musica elettronica si intende tutta quella musica prodotta 
                        o modificata da apparecchiature elettroniche. È un genere che
                        nel corso degli anni ha influito in pressoché tutti gli ambiti
                        musicali, ramificandosi inoltre in moltissimi altri generi che
                        spaziano dai più commerciali ai più "estremi", e quindi 
                        underground.</p>

                    <h3 id="Jazz">Jazz</h3>
                    <p>Il jazz è attualmente una forma musicale, ma nacque tra la 
                        fine del 1800 e inizio del 1900 come fenomeno sociale dagli
                        schiavi afroamericani che trovavano conforto e speranza nelle
                        loro anime improvvisando collettivamente ed individualmente 
                        canti. Il jazz viene riconosciuto come fenomeno musicale solo
                        tra Ottocento e Novecento e piacque molto anche ai «bianchi».
                    </p>

                    <h3 id="Country">Country</h3>
                    <p>Il country, anche detto country music, country and western 
                        music o country-western, è il risultato dell'unione di forme
                        popolari della musica americana sviluppatasi nel sud degli 
                        Stati Uniti. Si sviluppa grazie agli influssi della musica 
                        tradizionale del sud (caratterizzata da violino e banjo, 
                        anche chiamata Old Time Music), dei tradizionali duos, gruppi
                        musicali formati da fratelli (e caratterizzati dalla presenza 
                        di chitarra, mandolino e di una affascinante affinità vocale
                        ) e della musica folk degli immigrati anglo-irlandesi.</p>

                    <h3 id="Classica">Classica</h3>
                    <p>Col termine musica classica ci si riferisce alla musica colta,
                        sacra e profana, composta o avente radici nel contesto della
                        cultura occidentale.</p>

                <!-- Funzionalità del sito -->
                <h2 id="funzioni">Funzionalità</h2>
                    <h3 id="Vendita">Vendita</h3>
                    <p>Inserisci il tuo annuncio con i dischi che vuoi vendere</p>

                    <h3 id="Acquisto">Acquisto</h3>
                    <p>Acquista i dischi dagli altri venditori</p>

                    <h3 id="Pagamenti">Pagamenti</h3>
                    <p>Disponiamo della possibilità di usare strumenti di pagamento
                        online sicuro</p>

                    <h3 id="RaccoltaPunti">Raccolta Punti</h3>
                    <p>Più transazioni di vendita e acquisto produci, più punti
                        guadagni</p>
            </div>
            <jsp:include page="footer.jsp" /> 
        </div>
    </body>
</html>