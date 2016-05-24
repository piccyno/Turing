/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modello.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        if ((session.getAttribute("loggedId")!="true")||(session.getAttribute("userType") == "cliente")){
                request.getRequestDispatcher("errore.jsp").forward(request, response);
            }
        
        /**
         * Ricaviamo i valori inseriti nella form per poi scriverli nel riepilogo
         */
        if(request.getParameter("Insert") != null){
            request.setAttribute("titolo", (String)(request.getParameter("Titolo")));
            request.setAttribute("urlcopertina", (String)(request.getParameter("UrlCopertina")));
            request.setAttribute("descrizione", (String)(request.getParameter("Descrizione")));
            request.setAttribute("prezzo", (String)(request.getParameter("Prezzo")));
            request.setAttribute("quantita", (String)(request.getParameter("Quantita")));
            request.getRequestDispatcher("riepilogo.jsp").forward(request, response);
        }
        
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
