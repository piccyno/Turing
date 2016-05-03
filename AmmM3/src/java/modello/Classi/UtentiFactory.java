/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modello.Classi;

import java.util.ArrayList;
import modello.Classi.DischiFactory;

/**
 *
 * @author Simone
 */
public class UtentiFactory {
    /* Attributi */
    private static UtentiFactory singleton;
    public static UtentiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiFactory();
        }
        return singleton;
    }
    
       
    // Lista Venditori
    private ArrayList<Utente> listaVenditori = new ArrayList<Utente>();
    // Lista Clienti
    private ArrayList<Utente> listaClienti = new ArrayList<Utente>();
    
    /* Costruttore */
    private UtentiFactory() {
        
        /**
         * Creazione di una lista di utenti
         */
        // Venditori
        //Vendit_1
        Venditore vendit_1 = new Venditore();
        vendit_1.setNome("Simone");
        vendit_1.setCognome("Picciau");
        vendit_1.setId(0001);
        vendit_1.setUsername("Spicc");
        vendit_1.setPassword("123456");
        vendit_1.saldo.setSaldo(15.30);
        listaVenditori.add(vendit_1);
        //Vendit_2
        Venditore vendit_2 = new Venditore();
        vendit_2.setNome("Antonello");
        vendit_2.setCognome("Lai");
        vendit_2.setId(0002);
        vendit_2.setUsername("Tcs");
        vendit_2.setPassword("123456");
        vendit_2.saldo.setSaldo(19.30);
        listaVenditori.add(vendit_2);
        
        //Clienti
        //Client_1
        Cliente client_1 = new Cliente();
        client_1.setNome("Laura");
        client_1.setCognome("Puddu");
        client_1.setId(0003);
        client_1.setUsername("Laupud");
        client_1.setPassword("123456");
        client_1.saldo.setSaldo(15.30);
        listaClienti.add(client_1);
        //Client_2
        Cliente client_2 = new Cliente();
        client_2.setNome("Claudia");
        client_2.setCognome("Puddu");
        client_2.setId(0003);
        client_2.setUsername("cla");
        client_2.setPassword("123456");
        client_2.saldo.setSaldo(1.30);
        listaClienti.add(client_2);
    }
    
    
    /* Metodi */
    
    /**
     * Metodo che restituisce il venditore dato l'id
     * @param id
     * @return 
     */
    public Utente getVenditore(int id){
        for(Utente u : listaVenditori){
            if(u.id == id)
                return u;
        }
        return null;
    }
    
    /**
     * Metodo che restituisce il cliente dato l'id
     * @param id
     * @return 
     */
    public Utente getCliente(int id){
        for(Utente u : listaClienti){
            if(u.id == id)
                return u;
        }
        return null;
    }
    
    /**
     * Metodo che restituisce la lista dei venditori
     * @return 
     */
    public ArrayList<Utente> getVenditoriList(){
        return listaVenditori;
    }
    
    /**
     * Metodo che restituisce la lista dei clienti
     * @return 
     */
    public ArrayList<Utente> getClientiList(){
        return listaClienti;
    }
    
    /**
     * Metodo che restituisce la lista di tutti gli utenti
     * @return 
     */
    public ArrayList<Utente> getUtentiList(){
        ArrayList<Utente> listaUtenti = new ArrayList<Utente>();
        listaUtenti.addAll(listaVenditori);
        listaUtenti.addAll(listaClienti);
        return listaUtenti;
    }
    
}
