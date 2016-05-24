/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modello.Classi;

import java.util.ArrayList;

/**
 *
 * @author Simone
 */
public class DischiFactory {
    /* Attributi */
    private static DischiFactory istanza = null;
    
    String connectionString; 
    
    
    synchronized public static DischiFactory getInstance () {
        if (istanza == null) {
            istanza = new DischiFactory();
        }
        return istanza;
    }    
    
    
    // Lista Dischi
    public ArrayList<Disco> listaDischi = new ArrayList<Disco>();
    
    
    /* Costruttore */
    private DischiFactory() {
        /**
         * Creo una lista di dischi in vendita
         */
        //Dischi
        //Disco_1
        Disco disco_1 = new Disco();
        disco_1.setTitolo("Queen - Gratest Hits II");
        disco_1.setId(001);
        disco_1.setDescrizione("Compact Disc - Ottimo stato");
        disco_1.setDisponibilita(4);
        disco_1.setCopertina("img/copertina001.jpg");
        disco_1.setPrezzo(10);
        disco_1.setIdVenditore(0001);
        listaDischi.add(disco_1);
        
        //Disco_2
        Disco disco_2 = new Disco();
        disco_2.setTitolo("Rolling Stones - Grrr");
        disco_2.setId(002);
        disco_2.setDescrizione("Compact Disc - Ottimo stato");
        disco_2.setDisponibilita(2);
        disco_2.setCopertina("img/copertina002.jpg");
        disco_2.setPrezzo(5);
        disco_2.setIdVenditore(0001);
        listaDischi.add(disco_2);
        
        //Disco_3
        Disco disco_3 = new Disco();
        disco_3.setTitolo("Vasco Rossi - Sono Innocente");
        disco_3.setId(003);
        disco_3.setDescrizione("Compact Disc - Ottimo stato");
        disco_3.setDisponibilita(5);
        disco_3.setCopertina("img/copertina003.jpg");
        disco_3.setPrezzo(10);
        disco_3.setIdVenditore(0001);
        listaDischi.add(disco_3);
        
        //Disco_4
        Disco disco_4 = new Disco();
        disco_4.setTitolo("Daft Punk - Discovery");
        disco_4.setId(004);
        disco_4.setDescrizione("Compact Disc - Ottimo stato");
        disco_4.setDisponibilita(1);
        disco_4.setCopertina("img/copertina004.jpg");
        disco_4.setPrezzo(8);
        disco_4.setIdVenditore(0001);
        listaDischi.add(disco_4);
        
        //Disco_5
        Disco disco_5 = new Disco();
        disco_5.setTitolo("Depeche Mode - Delta Machine");
        disco_5.setId(005);
        disco_5.setDescrizione("Compact Disc - Ottimo stato");
        disco_5.setDisponibilita(3);
        disco_5.setCopertina("img/copertina005.jpg");
        disco_5.setPrezzo(8);
        disco_5.setIdVenditore(0001);
        listaDischi.add(disco_5);
    }
    
    /* Metodi */
    
    /**
     * Metodo che restituisce il disco dato un id disco
     * @param id
     * @return Disco
     */
    public Disco getDiscoById(int id){
        for(Disco d : listaDischi){
            if(d.id == id)
                return d;
        }
        return null;
    }
    
    /**
     * Metodo che restituisce l'intera lista di dischi
     * @return 
     */
    public ArrayList<Disco> getDischiList(){
        return listaDischi;
    }
    
    /**
     * Metodo che restituisce la lista dei dischi inseriti dal venditore avente
     * l'id passato come parametro.
     * @param id
     * @return 
     */
    public ArrayList<Disco> getDischiByUserList(int id){
        ArrayList<Disco> listaDischiByUser = new ArrayList<Disco>();
        boolean found = false;
        for(Disco d : listaDischi){
            if(d.getIdVenditore() == id){
                listaDischiByUser.add(d);
                found = true;
            }
        }
        if (found)
            return listaDischiByUser;
        else
            return null;
    }
    
    // ConnectionString
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
    
    
}