/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modello.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modello.Classi.DischiFactory;
import modello.Classi.Disco;

/**
 *
 * @author Simone
 */
@WebServlet(name = "Venditore", urlPatterns = {"/venditore.html"})
public class VenditoreServ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        /**
         * Se l'utente non è loggato visualizziamo un messaggio di errore
         */
        HttpSession session = request.getSession(false);
        if ((session.getAttribute("loggedIn")!="true")||(session.getAttribute("userType") == "cliente")){
                request.getRequestDispatcher("errore.jsp").forward(request, response);
            }
        
        /**
         * Inizializzo le variabili utili alla servlet
         */
        DischiFactory dischi = DischiFactory.getInstance();
        int idUtente = (int) session.getAttribute("idUtente");
        ArrayList<Disco> listaDischi;
        int numDischi;
        Disco disco;
        
        
        
        
        
        /**
         * Se abbiamo premuto il tasto elimina di un disco
         */
        int idDiscoToDelete;
        if(request.getParameter("idDiscoToDelete") != null 
                && !(request.getParameter("idDiscoToDelete").isEmpty())){
            idDiscoToDelete = Integer.parseInt(request.getParameter("idDiscoToDelete"));
            //Se ho schiacciato Elimina dalla pagina eliminazione
            if("true".equals(request.getParameter("Elimina"))){
                    dischi.eliminaDisco(idDiscoToDelete);
                    request.setAttribute("eliminato", true);
                    request.getRequestDispatcher("eliminazione.jsp").forward(request, response);
            }else{
                //Se ho schiacciato No dalla pagina eliminazione ritorno alla pagina venditore
                if("false".equals(request.getParameter("Elimina"))){
                    listaDischi = dischi.getDischiByUserList(idUtente);
                    numDischi = listaDischi.size();
                    session.setAttribute("dischi", listaDischi);
                    request.setAttribute("dischi", listaDischi);
                    request.setAttribute("numDischi", numDischi);
                    request.setAttribute("idDiscoToDelete", null);
                    request.setAttribute("idDiscoToChange", null);
                    request.setAttribute("Elimina", null);
                    request.getRequestDispatcher("venditore.jsp").forward(request, response);
                }else{
                    /**
                    * Alla richiesta di eliminazione di un disco si viene reindirizzati
                    * ad un riepilogo eliminazione.jsp
                    */
                    disco = dischi.getDiscoById(idDiscoToDelete);
                    request.setAttribute("disco", disco);
                    request.setAttribute("eliminato", false);
                    request.getRequestDispatcher("eliminazione.jsp").forward(request, response);
                }
            }
        }
        
        
        
        
        /**
         * Se abbiamo premuto il tasto modifica di un disco
         */
        int idDiscoToChange;
        if(request.getParameter("idDiscoToChange") != null 
                && !(request.getParameter("idDiscoToChange").isEmpty())){
            idDiscoToChange = Integer.parseInt(request.getParameter("idDiscoToChange"));
            disco = dischi.getDiscoById(idDiscoToChange);
            request.setAttribute("disco", disco);
            request.setAttribute("modificato", false);
            request.getRequestDispatcher("modifica.jsp").forward(request, response);
        }
        /**
         * Se abbiamo confermato le modifiche di un disco
         */
        if(request.getParameter("Change") != null){
            disco = new Disco();
            disco.setId(Integer.parseInt(request.getParameter("idDiscoChange")));
            disco.setTitolo(request.getParameter("Titolo"));
            disco.setCopertina(request.getParameter("UrlCopertina"));
            disco.setDescrizione(request.getParameter("Descrizione"));
            disco.setDisponibilita(Integer.parseInt(request.getParameter("Quantita")));
            disco.setPrezzo(Double.parseDouble(request.getParameter("Prezzo")));
            dischi.modificaDisco(disco);
            request.setAttribute("modificato", true);
            request.getRequestDispatcher("modifica.jsp").forward(request, response);
        }
        
        
        
        
        
        /**
         * Se abbiamo premuto il tasto insert
         * Ricaviamo i valori inseriti nella form per poi scriverli nel riepilogo
         */
        if(request.getParameter("Insert") != null){
            request.setAttribute("titolo", request.getParameter("Titolo"));
            request.setAttribute("urlcopertina", request.getParameter("UrlCopertina"));
            request.setAttribute("descrizione", request.getParameter("Descrizione"));
            request.setAttribute("prezzo", request.getParameter("Prezzo"));
            request.setAttribute("quantita", request.getParameter("Quantita"));
            request.setAttribute("inserito", false);
            request.getRequestDispatcher("riepilogo.jsp").forward(request, response);
        }
        /**
         * Se abbiamo premuto il tasto di conferma inserimento
         * Ricaviamo i valori da inserire e creiamo il nuovo oggetto
         */
        if(request.getParameter("Inserisci") != null){
            if("true".equals(request.getParameter("Inserisci"))){
                disco = new Disco();
                disco.setTitolo(request.getParameter("Titolo"));
                disco.setCopertina(request.getParameter("UrlCopertina"));
                disco.setDescrizione(request.getParameter("Descrizione"));
                disco.setPrezzo(Integer.parseInt(request.getParameter("Prezzo")));
                disco.setDisponibilita(Integer.parseInt(request.getParameter("Quantita")));
                disco.setIdVenditore(idUtente);
                dischi.inserisciDisco(disco);
                request.setAttribute("inserito", true);
                request.getRequestDispatcher("riepilogo.jsp").forward(request, response);
            }else 
                //Se ho schiacciato No dalla pagina di riepilogo ritorno alla pagina venditore
                if("false".equals(request.getParameter("Inserisci"))){
                    listaDischi = dischi.getDischiByUserList(idUtente);
                    numDischi = listaDischi.size();
                    session.setAttribute("dischi", listaDischi);
                    request.setAttribute("dischi", listaDischi);
                    request.setAttribute("numDischi", numDischi);
                    request.setAttribute("idDiscoToDelete", null);
                    request.setAttribute("idDiscoToChange", null);
                    request.setAttribute("Elimina", null);
                    request.getRequestDispatcher("venditore.jsp").forward(request, response);
                }
        }
        
        
        
        
        
        /** Imposto gli attributi **/
        
        listaDischi = dischi.getDischiByUserList(idUtente);
        numDischi = listaDischi.size();
        session.setAttribute("dischi", listaDischi);
        request.setAttribute("dischi", listaDischi);
        request.setAttribute("numDischi", numDischi);
        request.setAttribute("idDiscoToDelete", null);
        request.setAttribute("idDiscoToChange", null);
        request.setAttribute("Elimina", null);
        request.getRequestDispatcher("venditore.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
