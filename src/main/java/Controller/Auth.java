/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.DataServices;
import Models.Tutor;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static utils.Constants.*;


/**
 * Servlet Auth that will let us authenticate as a tutor. If the credentials input by the tutor is found in the database
 * it will redirect the tutor to the HomePage. If the credentials input are not found in the database, it will redirect the tutor
 * the the AuthPage with an error message.
 * @author Tristan CLEMENCEAU
 */
public class Auth extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * We first check if the session exist or not, if it does not exist we redirect the user to the AuthPage
     * Once there is a sessions, we check if there are parameters sended and check the credentials
     * If the credentials input by the tutor is found in the database, it will redirect the tutor to the HomePage.
     * If the credentials input are not found in the database, it will redirect the tutor
     * to the AuthPage with an error message.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*CHECK IF SESSION EXIST WITHOUT CREATING A NEW SESSION*/
        HttpSession session = request.getSession(false);

        /*CHECK IF THERE IS NO EXISTING SESSION*/
        if (session == null) {
            /*SESSION DOES NOT EXIST*/
            /*CREATE SESSION*/
            session = request.getSession();
            /*REDIRECT TO AUTH*/
            request.getRequestDispatcher(JSP_PATH_AUTHPAGE).forward(request, response);
            return;
        }

        
        /*CHECK IF THERE ARE ANY PARAMETERS SENDED*/
        if (isThereAnyArgs(request)) {
            /*THERE ARE PARAMETERS*/
            
            if(session.getAttribute(SESSION_DATASERVICES) != null){
                session.removeAttribute(SESSION_DATASERVICES);
            }
            
            DataServices dServices = new DataServices(this);
            dServices.connect();
            
            /*CHECK IF THE GIVEN PARAMETERS ARE VALID CREDENTIALS*/
            if (dServices.checkCredential(request)) {
                /*CREDENTIALS ARE VALID*/
                /*CHECK IF THERE IS ALREADY AN ATTRIBUTE USER IN THE SESSION*/
                if(session.getAttribute(SESSION_USER)!= null){
                    /*THERE IS AN ATTRIBUTE USER*/
                    /*REMOVING THE ATTRIBUTE*/
                    session.removeAttribute(SESSION_USER);
                }
                
                /*STORING USER IN SESSION WITH PASSWORD AND LOGIN */
                Tutor tutortest = new Tutor();
                tutortest.setLogin(request.getParameter(PARAM_LOGINFORM));
                tutortest.setPassword(dServices.getHash(request.getParameter(PARAM_PASSFORM)));
                
                session.setAttribute(SESSION_USER, tutortest);
                session.setAttribute(SESSION_DATASERVICES, dServices);

                
                /*REDIRECT TO HOME PAGE*/
                request.getRequestDispatcher(SERVLET_PATH_HOMEPAGE).forward(request, response);
            } else {
                /*CREDENTIALS ARE INVALID*/
                /*REDIRECT TO AUTH WITH ERROR*/
                request.getRequestDispatcher(JSP_PATH_AUTHPAGE).forward(request, response);
            }
        } else {
            /*THERE ARE NO PARAMETERS*/
            /*SET ERROR MESSAGE*/
            request.setAttribute(SESSION_STATUS, NO_PARAMETERS_LOGIN_INPUT);
            /*REDIRECT TO AUTH WITH ERROR*/
            request.getRequestDispatcher(JSP_PATH_AUTHPAGE).forward(request, response);
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

    /*RETURN TRUE IF ALL THE ARGS ARE NOT NULL OTHERWISE IT RETURN FALSE */
    private boolean isThereAnyArgs(HttpServletRequest request) {
        boolean answer = false;
        boolean login = (request.getParameter(PARAM_LOGINFORM) != null && !request.getParameter(PARAM_LOGINFORM).isEmpty());
        boolean pass = (request.getParameter(PARAM_PASSFORM) != null && !request.getParameter(PARAM_PASSFORM).isEmpty());

        if (login && pass) {
            answer = true;
        }

        return answer;
    }

}
