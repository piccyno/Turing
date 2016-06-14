$(document).ready(function () {
    $("#filtra").keyup(function () {
        var testoDigitato = $("#filtra").val();
        $.ajax({
            url: "filter.json",
            data:{
                datiDigitati: "q",
                value: testoDigitato
            },
            dataType: 'json',
            success: function(data, state){
                filtraDischi(data);
            },
            error : function(data, state){
                alert("Error!!!");
            }
        });
    });
        
    function filtraDischi(listaDischi){
        $("#tabellaVendite").show();
        $("#nessunDisco").remove();
        //Se non ci sono risultati nascondo la tabella e visualizzo messaggio
        if (listaDischi.length===0){ 
            $('#tabellaVendite').hide();
            var noDischi = document.createElement("p");
            noDischi.setAttribute("id", "nessunDisco");
            var testo = document.createTextNode("Nessun disco trovato");
            noDischi.appendChild(testo);
            noDischi.className = "error";
            $('#page').append(noDischi);                
        }
        $('#tabellaVendite tr').slice(1).remove();
        for(var i=0; i<listaDischi.length; i++) {
            //Inizializzo la riga con l'elemento tr
            var riga = document.createElement("tr");
            //Recupero i dati
            var titolo = listaDischi[i].titolo;
            var copertina = listaDischi[i].copertina;
            var quantita = listaDischi[i].quantita;
            var prezzo = listaDischi[i].prezzo;
            var id = listaDischi[i].id;
            //Titolo
            colonnaTitolo = document.createElement("td");
            colonnaTitolo.appendChild(document.createTextNode(titolo));
            riga.appendChild(colonnaTitolo);
            //Copertina
            colonnaCopertina = document.createElement("td");
            riga.appendChild(colonnaCopertina);
            var urlCopertina = document.createElement("img");
            urlCopertina.setAttribute("src", copertina);
            urlCopertina.setAttribute("alt", titolo);
            colonnaCopertina.appendChild(urlCopertina);
            //Quantità
            colonnaQuantita = document.createElement("td");
            colonnaQuantita.appendChild(document.createTextNode(quantita));
            riga.appendChild(colonnaQuantita);
            //Prezzo
            colonnaPrezzo = document.createElement("td");
            colonnaPrezzo.appendChild(document.createTextNode(prezzo));
            riga.appendChild(colonnaPrezzo);
            //Acquista
            colonnaCarrello = document.createElement("td");
            var aggiungiCarrello = document.createElement("a");
            aggiungiCarrello.setAttribute("href", "./cliente.html?objId=" + id);
            aggiungiCarrello.appendChild(document.createTextNode("acquista"));
            colonnaCarrello.appendChild(aggiungiCarrello);
            riga.appendChild(colonnaCarrello);
            //Aggiunta della riga
            $('#tabellaVendite').append(riga);
        }
    }
});