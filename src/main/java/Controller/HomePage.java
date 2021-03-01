/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.DataServices;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static utils.Constants.*;

/**
 * Servlet HomePage that first will check if the session exist. If it exist we check if the user exists and then we load the data 
 * If the session does not exist or the user is null, we redirect to the rooter servlet
 * @author Tristan CLEMENCEAU
 */
@WebServlet(name = NAME_HOMEPAGE, urlPatterns = {SERVLET_PATH_HOMEPAGE})
public class HomePage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * We check if the session exist. If it exist we check if the user exists and then we load the data 
     * If the session does not exist or the user is null, we redirect to the rooter servlet
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*CHECK IF SESSION EXIST WITHOUT CREATING A NEW SESSION*/
        HttpSession session = request.getSession(false);

        /*CHECK IF THERE IS A SESSION*/
        if (session == null) {
            /*SESSION DOESN'T EXIST*/

            /*REDIRECT TO ROOTER*/
            request.getRequestDispatcher(SERVLET_PATH_ROOTER).forward(request, response);
        } else {
            /*SESSION EXIST*/
            /*CHECK IF USER IS NULL*/
            if (session.getAttribute(SESSION_USER) == null) {

                /*SESSION WITHOUT USER*/
                /*DELETE SESSION*/
                session.invalidate();
                /*REDIRECT TO ROOTER*/
                request.getRequestDispatcher(SERVLET_PATH_ROOTER).forward(request, response);
            } else {
                /*SESSION WITH USER*/
                DataServices dServices;

                if (session.getAttribute(SESSION_DATASERVICES) == null) {
                    dServices = new DataServices(this);
                    session.setAttribute(SESSION_DATASERVICES, dServices);
                    dServices.connect();
                } else {
                    dServices = (DataServices) session.getAttribute(SESSION_DATASERVICES);
                    dServices.connect();
                }

                /*LOAD DATA*/
                dServices.loadData(session);

                /*REDIRECT TO HOMEPAGE JSP*/
                request.getRequestDispatcher(JSP_PATH_HOMEPAGE).forward(request, response);
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
