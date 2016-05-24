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
import modello.Classi.Cliente;
import modello.Classi.DischiFactory;
import modello.Classi.Disco;

/**
 *
 * @author Simone
 */
@WebServlet(name = "ClienteServ", urlPatterns = {"/cliente.html"})
public class ClienteServ extends HttpServlet {

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
        if ((session.getAttribute("loggedIn")!="true")||(session.getAttribute("userType") == "venditore")){
                request.getRequestDispatcher("errore.jsp").forward(request, response);
            }
        
        /** Creo i dischi con la classe factory **/
        DischiFactory dischi = DischiFactory.getInstance();
        ArrayList<Disco> listaDischi = dischi.getDischiList();
        
        /**
         * In caso di acquisto di un disco
         */
        Integer idDisco;
        if (request.getParameter("idDisco")!=null && !(request.getParameter("idDisco").isEmpty())){
            idDisco = Integer.parseInt(request.getParameter("idDisco"));
            if (idDisco>0){
                request.setAttribute("disco", dischi.getDiscoById(idDisco));
                request.getRequestDispatcher("riepilogoAcq.jsp").forward(request, response);
            }
        }else
            idDisco=0;
       
        
        
        
        /**
         * In caso di conferma di acquisto di un disco verifico la presenza
         * di sufficiente denaro nel conto del cliente e procedo alla visualizzazione
         * della pagina di conferma
         */
        
        if(request.getParameter("Acquisto") != null){
            Cliente cliente = (Cliente)session.getAttribute("cliente");
            request.setAttribute("cliente", cliente);
            Integer idDiscoAcq;
            idDiscoAcq = Integer.parseInt(request.getParameter("idDiscoAcq"));
            double saldoCliente;
            saldoCliente = cliente.saldo.getSaldo();
            Disco disco = dischi.getDiscoById(idDiscoAcq);
            if  (saldoCliente >= disco.getPrezzo()){
                request.setAttribute("esito", true);
                request.setAttribute("disco", dischi.getDiscoById(idDiscoAcq));
                request.getRequestDispatcher("esitoAcq.jsp").forward(request, response);
            }else{
                request.setAttribute("esito", false);
                request.setAttribute("disco", dischi.getDiscoById(idDiscoAcq));
                request.getRequestDispatcher("esitoAcq.jsp").forward(request, response);
            }
        }
        
        
        
        /** Imposto gli attributi **/
        session.setAttribute("dischi", listaDischi);
        request.setAttribute("dischi", listaDischi);
        request.setAttribute("idDisco", 0);
        request.getRequestDispatcher("cliente.jsp").forward(request, response);
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
