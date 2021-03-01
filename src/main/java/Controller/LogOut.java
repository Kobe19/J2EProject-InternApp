/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static utils.Constants.*;

/**
 * Servlet LogOut that first will check if the session is null. If it's null then we redirect to the rooter servlet
 * If it's not null, we invalidate the session and redirect to the rooter servlet
 * @author Tristan CLEMENCEAU
 */
public class LogOut extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * Method that will let the tutor disconnect.
     * We check if the session is null. If it's null then we redirect to the rooter servlet
     * If it's not null, we invalidate the session and redirect to the rooter servlet
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*VERRIFICATION*/
        HttpSession session = request.getSession(false);

        if (session == null) {
            /*REDIRECT TO ROOTER*/
            request.getRequestDispatcher(SERVLET_PATH_ROOTER).forward(request, response);
        }else{
            /*DESTRUCTION SESSION*/
            session.invalidate();
            System.out.println(MSG_SUCCESS_DECONNECTION);
            /*REDIRECT TO ROOTER*/
            request.getRequestDispatcher(SERVLET_PATH_ROOTER).forward(request, response);
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
