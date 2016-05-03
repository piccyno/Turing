/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modello.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modello.Classi.DischiFactory;
import modello.Classi.Disco;
import modello.Classi.Utente;
import modello.Classi.Venditore;
import modello.Classi.UtentiFactory;

/**
 *
 * @author Simone
 */
@WebServlet(name = "Login", urlPatterns = {"/login.html"})
public class Login extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        
        /**
         * Se l'utente già loggato clicca nuovamente Login viene riportato
         * nella pagina di sua competenza.
         */
        if (session.getAttribute("loggedId")=="true"){
            if (session.getAttribute("userType") == "venditore"){
                request.getRequestDispatcher("venditore.jsp").forward(request, response);
            }else{
                DischiFactory factory = DischiFactory.getInstance();
                ArrayList<Disco> listaDischi = factory.getDischiList();
                request.setAttribute("dischi", listaDischi);
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
            }
        }
        
        /**
         * Vengono controllati il nome utente e password, se non sono nulli e se
         * sono validi per aprire una sessione. In tal caso viene aperta una
         * sessione e l'utente viene riportato nella pagina di sua competenza.
         */
        if(request.getParameter("Login") != null){
            String username = request.getParameter("Username");
            String password = request.getParameter("Password");
            
            ArrayList<Utente> listaUtenti = UtentiFactory.getInstance().getUtentiList();
            if (username != null && password != null)
                for(Utente u : listaUtenti)
                    if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                        session.setAttribute("loggedId", "true");
                        session.setAttribute("id", u.getId());
                        if(u instanceof Venditore){
                            request.setAttribute("venditore", u);
                            session.setAttribute("venditore", u);
                            session.setAttribute("userType", "venditore");
                            request.getRequestDispatcher("venditore.html").forward(request, response);
                        }else{
                            request.setAttribute("cliente", u);
                            session.setAttribute("cliente", u);
                            session.setAttribute("userType", "cliente");
                            request.getRequestDispatcher("cliente.html").forward(request, response);
                        }
                    }
            request.setAttribute("loggedId", "false");
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
