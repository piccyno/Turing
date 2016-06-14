/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modello.servlet;

import modello.Classi.Disco;
import modello.Classi.DischiFactory;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.TreeSet;

/**
 *
 * @author Simone
 */

@WebServlet(name = "Filter", urlPatterns = {"/filter.json"})
public class Filter extends HttpServlet {

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
        
        String datiDigitati = request.getParameter("datiDigitati");
        if (datiDigitati != null){ 
            if (datiDigitati.equals("q")){
                ArrayList<Disco> listaDischi;
                String testoDigitato;
                testoDigitato = ((String)request.getParameter("value"));
                if (!testoDigitato.equals("")){
                    //System.out.println(testoDigitato);
                    listaDischi = DischiFactory.getInstance().getDischiListFiltro(testoDigitato);
                }else
                    listaDischi = DischiFactory.getInstance().getDischiList();
                request.setAttribute("listaDischi", listaDischi);
                //request.setAttribute("idUtente", session.getAttribute("idUtente"));

                // Json
                response.setContentType("application/json");
                response.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
                response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");

                // Genero il json con una jsp
                request.getRequestDispatcher("filtro.jsp").forward(request, response);
            }
        }
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