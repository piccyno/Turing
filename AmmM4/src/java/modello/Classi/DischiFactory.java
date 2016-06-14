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
                current.setIdVenditore(res.getInt("id_venditore"));
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
                current.setIdVenditore(set.getInt("id_venditore"));
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
     * Metodo che restituisce la lista di dischi filtrata secondo il parametro filtro
     * @param filtro
     * @return 
    */
    public ArrayList<Disco> getDischiListFiltro(String filtro){
        ArrayList<Disco> listaDischi = new ArrayList<Disco>();
        try{
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "simone", "amm");
            //query
            String query = "select * from disco where titolo LIKE ? OR descrizione LIKE ?"
                    + " OR LOWER(titolo) LIKE ? OR LOWER(descrizione) LIKE ?"; 
            //prepared statement
            PreparedStatement stmt = conn.prepareStatement(query);
            filtro = "%" + filtro + "%";
            stmt.setString(1, filtro);            
            stmt.setString(2, filtro);
            stmt.setString(3, filtro);            
            stmt.setString(4, filtro);
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
                current.setIdVenditore(set.getInt("id_venditore"));
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
        try{
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "simone", "amm");
            //query
            String query = "select * from disco "
            + "where id_venditore = ?";
            // Prepared Statement
            PreparedStatement stmt = conn.prepareStatement(query);
            // Si associano i valori
            stmt.setInt(1, id);
            // Esecuzione query
            ResultSet set = stmt.executeQuery();
            // ciclo sulle righe restituite
            while(set.next()){
                Disco current = new Disco();
                current.setId(set.getInt("id"));
                current.setTitolo(set.getString("titolo"));
                current.setDescrizione(set.getString("descrizione"));
                current.setCopertina(set.getString("copertina"));
                current.setDisponibilita(set.getInt("disponibilità"));
                current.setPrezzo(set.getFloat("prezzo"));
                current.setIdVenditore(set.getInt("id_venditore"));
                listaDischiByUser.add(current);
            } 
            stmt.close();
            conn.close();
        } 
        catch (SQLException e){
            e.printStackTrace();
        }
        return listaDischiByUser;
    }
    
    /**
     * Metodo che inserisce un nuovo oggetto
     * @param disco
     * @return 
     */
    public Boolean inserisciDisco(Disco disco){
        try{
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "simone", "amm");
            // creo lo statement
            Statement stmt = conn.createStatement();
            //definisco la query
            String query = "insert into disco (id, titolo, descrizione, "
                    + "copertina, disponibilità, prezzo, id_venditore) "
                    + "values (default, '" 
                    + disco.getTitolo() +"' , '"
                    + disco.getDescrizione() + "' , '"
                    + disco.getCopertina() + "' , "
                    + disco.getDisponibilita() + " , "
                    + disco.getPrezzo() + " , "
                    + disco.getIdVenditore() + ")";
            int rows = stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } 
        catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
    
    /**
     * Metodo che modifica un oggetto
     * @param disco
     * @return 
     */
    public Boolean modificaDisco(Disco disco){
        try{
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "simone", "amm");
            // creo lo statement
            Statement stmt = conn.createStatement();
            //definisco la query
            String query = "update disco set "
                    + "titolo = '" + disco.getTitolo() 
                    + "' , descrizione = '" + disco.getDescrizione()
                    + "' , copertina = '" + disco.getCopertina()
                    + "' , disponibilità = " + disco.getDisponibilita()
                    + " , prezzo = " + disco.getPrezzo()
                    + " where id = "+ disco.getId();
            int rows = stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } 
        catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
    
    /**
     * Metodo che cancella un oggetto
     * @param id
     * @return 
     */
    public Boolean eliminaDisco(int id){
        try{
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "simone", "amm");
            // creo lo statement
            Statement stmt = conn.createStatement();
            //definisco la query
            String query = "delete from disco where id = " + id;
            int rows = stmt.executeUpdate(query);
            stmt.close();
            conn.close();
        } 
        catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
    
    /**
     * Funzione acquisto di un disco
     * @param disco
     * @return 
     */
    public Boolean transazione(int idDisco, int idCliente, int idVenditore, double importo) {
        try{
            // path, username, password
            Connection conn = DriverManager.getConnection(connectionString, "simone", "amm");

            PreparedStatement aggiornaDisco = null;
            PreparedStatement aggiornaCliente = null;
            PreparedStatement aggiornaVenditore = null;

            String queryAggiornaDisco = "update disco set disponibilità = disponibilità - 1 where id = ?";
            String queryAggiornaCliente = "update cliente set saldo = saldo - ? where id = ?";
            String queryAggiornaVenditore = "update venditore set saldo = saldo + ? where id = ?";

            try{
                conn.setAutoCommit(false);
                aggiornaDisco = conn.prepareStatement(queryAggiornaDisco);
                aggiornaCliente = conn.prepareStatement(queryAggiornaCliente);
                aggiornaVenditore = conn.prepareStatement(queryAggiornaVenditore);

                aggiornaDisco.setInt(1, idDisco);
                aggiornaDisco.executeUpdate();

                aggiornaCliente.setDouble(1, importo);
                aggiornaCliente.setInt(2, idCliente);
                aggiornaCliente.executeUpdate();

                aggiornaVenditore.setDouble(1, importo);
                aggiornaVenditore.setInt(2, idVenditore);
                aggiornaVenditore.executeUpdate();
                conn.commit();            
            } catch (SQLException e ){
                e.printStackTrace();
                if (conn != null) {
                    try{
                        conn.rollback();
                        return false;
                    }catch (SQLException excep ){
                        excep.printStackTrace();
                    }
                }
            }finally{
                if (aggiornaDisco != null){
                    aggiornaDisco.close();
                }
                if (aggiornaCliente != null){
                    aggiornaCliente.close();
                }
                if (aggiornaVenditore != null){
                    aggiornaVenditore.close();
                }
                conn.setAutoCommit(true);
            }
            conn.close();        
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
    
    
    // ConnectionString
    public void setConnectionString(String s){
	this.connectionString = s;
    }
    public String getConnectionString(){
	return this.connectionString;
    }
    
}