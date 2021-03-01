/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static utils.Constants.*;

/**
 * Servlet Rooter that first will check if the session exists without creating a new session
 * If it exist we check if the user is not null and if it is not null too we redirect the tutor 
 * to the homepage servlet. If there is a session and no user or no session at all we redirect the tutor
 * to the Auth servlet
 * @author Tristan CLEMENCEAU
 */
@WebServlet(name = NAME_ROOTER, urlPatterns = {URLPATTERN_ROOTER})
public class Rooter extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * Check if the session exists without creating a new session
     * If it exist we check if the user is not null and if it is not null too we redirect the tutor 
     * to the homepage servlet. If there is a session and no user or no session at all we redirect the tutor
     * to the Auth servlet
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               /*CHECK IF SESSION EXIST WITHOUT CREATING A NEW SESSION*/
        HttpSession session = request.getSession(false);
        
        /*CHECK IF SESSION EXIST*/
        if (session == null) {
            /*SESSION DOES NOT EXIST*/
            /*REDIRECT TO AUTH*/
            request.getRequestDispatcher(SERVLET_PATH_AUTH).forward(request, response);
        } else {
            /*SESSION EXIST*/
            /*CHECK IF SESSION AS USER NOT NULL*/
            if(session.getAttribute(SESSION_USER) != null){
                /*SESSION WITH USER NOT NULL*/
                /*REDIRECT TO HOMEPAGE*/
                request.getRequestDispatcher(SERVLET_PATH_HOMEPAGE).forward(request, response);
            }else{
                /*SESSION WITHOUT USER*/
                /*REDIRECT TO AUTH*/
                 request.getRequestDispatcher(SERVLET_PATH_AUTH).forward(request, response);
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
        System.out.println(MSG_ERROR_GET);
        /*CHECK IF SESSION EXIST WITHOUT CREATING A NEW SESSION*/
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            /*SESSION EXIST*/
            /*INVALIDATE SESSION*/
            session.invalidate();
            /*REDIRECT TO AUTH*/
            request.getRequestDispatcher(JSP_PATH_AUTHPAGE).forward(request, response);
            return;
        }
        /*REDIRECT TO AUTH*/
        request.getRequestDispatcher(JSP_PATH_AUTHPAGE).forward(request, response);
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
