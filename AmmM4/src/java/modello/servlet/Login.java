/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modello.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "Login", urlPatterns = {"/login.html"}, loadOnStartup = 0)
public class Login extends HttpServlet {

    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    
    @Override 
    public void init(){
        String dbConnection = "jdbc:derby:" + this.getServletContext().getRealPath("/") + DB_BUILD_PATH;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        UtentiFactory.getInstance().setConnectionString(dbConnection);
        DischiFactory.getInstance().setConnectionString(dbConnection);
    }
    
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
        if (session.getAttribute("loggedIn")=="true"){
            if (session.getAttribute("userType") == "venditore"){
                request.getRequestDispatcher("venditore.html").forward(request, response);
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
            if (username != null && password != null){
                Utente u = UtentiFactory.getInstance().getUtente(username, password);
                if(u != null){
                    session.setAttribute("loggedIn", "true");
                    session.setAttribute("idUtente", u.getId());
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
            } 
            request.setAttribute("loggedIn", "false");
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
