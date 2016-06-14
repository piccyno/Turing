/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modello.Classi;

/**
 *
 * @author Simone
 */
public class Disco {
    /* Attributi */
    int id;
    private int idVenditore;
    private double prezzo;
    private int disponibilita;
    private String titolo;
    private String descrizione;
    private String copertina;
    
    
    /* Metodi */

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the prezzo
     */
    public double getPrezzo() {
        return prezzo;
    }

    /**
     * @param prezzo the prezzo to set
     */
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * @return the disponibilita
     */
    public int getDisponibilita() {
        return disponibilita;
    }

    /**
     * @param disponibilita the disponibilita to set
     */
    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
    }
    
    /**
     * @param disponibilita the disponibilita to increase
     * @return 
     */
    public boolean aumentaDisponibilita(int disponibilita) {
        if (disponibilita > 0) {
            this.disponibilita = this.disponibilita + disponibilita;
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * @param disponibilita the disponibilita to decrease
     * @return 
     */
    public boolean diminuisciDisponibilita(int disponibilita) {
        if ((disponibilita > 0)&&(disponibilita<=this.disponibilita)) {
            this.disponibilita = this.disponibilita - disponibilita;
            return true;
        }else{
            return false;
        }
    }

    /**
     * @return the titolo
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * @param titolo the titolo to set
     */
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    /**
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @param descrizione the descrizione to set
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * @return the copertina
     */
    public String getCopertina() {
        return copertina;
    }

    /**
     * @param copertina the copertina to set
     */
    public void setCopertina(String copertina) {
        this.copertina = copertina;
    }

    /**
     * @return the idVenditore
     */
    public int getIdVenditore() {
        return idVenditore;
    }

    /**
     * @param idVenditore the idVenditore to set
     */
    public void setIdVenditore(int idVenditore) {
        this.idVenditore = idVenditore;
    }
    
    

}
