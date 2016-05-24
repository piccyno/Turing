/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modello.Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        
    }
    
    /* Metodi */
    
    /**
     * Metodo che restituisce il disco dato un id disco
     * @param id
     * @return Disco
     */
    public Disco getDiscoById(int id){
        try{
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "simone", "amm");
            // Query
            String query = "select * from disco "
            + "where id = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
             // ciclo sulle righe restituite
            if(res.next()){
                Disco current = new Disco();
                current.setId(res.getInt("id"));
                current.setTitolo(res.getString("titolo"));
                current.setDescrizione(res.getString("descrizione"));
                current.setCopertina(res.getString("copertina"));
                current.setDisponibilita(res.getInt("disponibilità"));
                current.setPrezzo(res.getFloat("prezzo"));
                current.setIdVenditore(res.getInt("venditore_id"));
                stmt.close();
                conn.close();
                return current;
            }   
            stmt.close();
            conn.close();
        } 
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Metodo che restituisce l'intera lista di dischi
     * @return 
     */
    public ArrayList<Disco> getDischiList(){
        ArrayList<Disco> listaDischi = new ArrayList<Disco>();
        try{
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "simone", "amm");
            Statement stmt = conn.createStatement();
            String query = "select * from "
            + "disco";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()){
                Disco current = new Disco();
                current.setId(set.getInt("id"));
                current.setTitolo(set.getString("titolo"));
                current.setDescrizione(set.getString("descrizione"));
                current.setCopertina(set.getString("copertina"));
                current.setDisponibilita(set.getInt("disponibilità"));
                current.setPrezzo(set.getFloat("prezzo"));
                current.setIdVenditore(set.getInt("venditore_id"));
                listaDischi.add(current);
            } 
            stmt.close();
            conn.close();
        } 
        catch (SQLException e){
            e.printStackTrace();
        }
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