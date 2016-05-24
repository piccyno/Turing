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
public class UtentiFactory {
    /* Attributi */
    private static UtentiFactory singleton;
    String connectionString; 
    
    // E' l'unico metodo che restituisce il singleton. Provvede a inizializzarlo alla prima chiamata.
    // Nelle successive chiamate lo restituisce e basta.
    public static UtentiFactory getInstance() {
        if (singleton == null) {
            singleton = new UtentiFactory();
        }
        return singleton;
    }

    /* Costruttore */
    private UtentiFactory() {
       
    }
    
    /* Metodi */
    public Utente getUtente(String username, String password)
    {
        try
        {
            Connection conn = DriverManager
                    .getConnection(connectionString, 
                            "simone",
                            "amm");
            //Venditore
            // sql command
            String query = "select * from venditore where "
                    + "password = ? and username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            // dati
            stmt.setString(1, password);
            stmt.setString(2, username);
            //
            ResultSet set = stmt.executeQuery();
            
            if(set.next())
            {
                Venditore venditore = new Venditore();
                venditore.setId(set.getInt("id"));
                venditore.setNome(set.getString("nome"));
                venditore.setCognome(set.getString("cognome"));
                venditore.setUsername(set.getString("username"));
                venditore.setPassword(set.getString("password"));
                venditore.setSaldo(set.getFloat("saldo"));
                venditore.setFeedback(set.getInt("feedback"));
                
                stmt.close();
                conn.close();
                
                return venditore;
            }
            
            // Cliente
            // sql command
            query = "select * from cliente where "
                    + "password = ? and username = ?";
            stmt = conn.prepareStatement(query);
            // dati
            stmt.setString(1, password);
            stmt.setString(2, username);
            //
            set = stmt.executeQuery();
            
            if(set.next()){
                Cliente cliente = new Cliente();
                cliente.setId(set.getInt("id"));
                cliente.setNome(set.getString("nome"));
                cliente.setCognome(set.getString("cognome"));
                cliente.setUsername(set.getString("username"));
                cliente.setPassword(set.getString("password"));
                cliente.setSaldo(set.getFloat("saldo"));
                stmt.close();
                conn.close();
                return cliente;
            }
            stmt.close();
            conn.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
    /**
     * Metodo che restituisce il venditore dato l'id
     * @param id
     * @return 
     */
    public Utente getVenditore(int id){
        try{
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "simone", "amm");
            // Query
            String query = "select * from venditore "
            + "where id = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
            
             // ciclo sulle righe restituite
            if(res.next()){
                Venditore current = new Venditore();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setSaldo(res.getFloat("saldo"));
                current.setFeedback(res.getInt("feedback"));
                stmt.close();
                conn.close();
                return current;
            }   
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
    
    /**
     * Metodo che restituisce il cliente dato l'id
     * @param id
     * @return 
     */
    public Utente getCliente(int id){
        try{
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "simone", "amm");
            String query = "select * from studente "
            + "where id = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet res = stmt.executeQuery();
           
             // ciclo sulle righe restituite
            if(res.next()){
                Cliente current = new Cliente();
                current.setId(res.getInt("id"));
                current.setNome(res.getString("nome"));
                current.setCognome(res.getString("cognome"));
                current.setUsername(res.getString("username"));
                current.setPassword(res.getString("password"));
                current.setSaldo(res.getFloat("saldo"));
                stmt.close();
                conn.close();
                return current;
            }
            stmt.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Metodo che restituisce la lista dei venditori
     * @return 
     */
    public ArrayList<Venditore> getVenditori(){
        ArrayList<Venditore> listaVenditori = new ArrayList<Venditore>();
        try{
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "simone", "amm");
            Statement stmt = conn.createStatement();
            String query = "select * from "
            + "venditore";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()){
                Venditore current = new Venditore();
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                current.setCognome(set.getString("cognome"));
                current.setUsername(set.getString("username"));
                current.setPassword(set.getString("password"));
                current.setSaldo(set.getFloat("saldo"));
                current.setFeedback(set.getInt("feedback"));
                listaVenditori.add(current);
            } 
            stmt.close();
            conn.close();
        } 
        catch (SQLException e){
            e.printStackTrace();
        }
        return listaVenditori;
    }
    
    /**
     * Metodo che restituisce la lista dei clienti
     * @return 
     */
    public ArrayList<Cliente> getClienti(){
        ArrayList<Cliente> listaClienti = new ArrayList<Cliente>();
        try{
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "simone", "amm");
            Statement stmt = conn.createStatement();
            String query = "select * from "
            + "cliente";
            ResultSet set = stmt.executeQuery(query);
            
             // ciclo sulle righe restituite
            while(set.next()){
                Cliente current = new Cliente();
                current.setId(set.getInt("id"));
                current.setNome(set.getString("nome"));
                current.setCognome(set.getString("cognome"));
                current.setUsername(set.getString("username"));
                current.setPassword(set.getString("password"));
                current.setSaldo(set.getFloat("saldo"));
                listaClienti.add(current);
            } 
            stmt.close();
            conn.close();
        } 
        catch (SQLException e){
            e.printStackTrace();
        }
        return listaClienti;
    }
    
    /**
     * Metodo che restituisce la lista di tutti gli utenti
     * @return 
     */

    
    
    // ConnectionString
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
    
}
