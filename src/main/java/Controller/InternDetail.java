/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Intern;
import Models.Internship;
import Models.Tutor;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static utils.Constants.*;

/**
 * Servlet InternDetail that first will check if the session exist. If it exist we check if the user exists and 
 * then we load the data of the selected internship
 * so the tutor can see and edit the selected internship
 * If the session does not exist or the user is null, we redirect to the rooter servlet
 * @author Tristan CLEMENCEAU
 */
public class InternDetail extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * We check if the session exist. If it exist we check if the user exists and then we load the data 
     * so the tutor can see and edit the selected internship
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
                /*CLEAR ID INTERN*/
                if(session.getAttribute(ATTRIBUTE_INTERN)!= null){
                    /*THERE IS AN ATTRIBUTE INTERN*/
                    /*REMOVING THE ATTRIBUTE*/
                    session.removeAttribute(ATTRIBUTE_INTERN);
                }
                
                if(session.getAttribute(ATTRIBUTE_INTERNSHIP)!= null){
                    /*THERE IS AN ATTRIBUTE INTERNSHIP*/
                    /*REMOVING THE ATTRIBUTE*/
                    session.removeAttribute(ATTRIBUTE_INTERNSHIP);
                }
                
                Tutor tutor = (Tutor) session.getAttribute(SESSION_USER);
                Intern intern = tutor.getInternById(Integer.parseInt(request.getParameter(PARAM_IDINTERN)));
                Internship internship = intern.getInternshipById(Integer.parseInt(request.getParameter(PARAM_IDINTERNSHIP)));
                
                session.setAttribute(ATTRIBUTE_INTERN, intern);
                session.setAttribute(ATTRIBUTE_INTERNSHIP, internship);
                
                /*REDIRECT TO HOMEPAGE JSP*/
                request.getRequestDispatcher(JSP_PATH_INTERNDETAIL).forward(request, response);
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
