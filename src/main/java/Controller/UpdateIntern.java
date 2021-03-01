/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Company;
import Models.DataServices;
import Models.Intern;
import Models.Internship;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static utils.Constants.*;

/**
 * Servlet UpdateIntern that first will check if the session exist. If it exist we check if the user exists and we
 * load the data from the form in internDetail.jsp. Then we check if the update relate to a internship, a company or both
 * and then we update the values in the database
 * If the session does not exist or the user is null, we redirect to the rooter servlet
 * @author Tristan CLEMENCEAU
 */
public class UpdateIntern extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * heck if the session exist. If it exist we check if the user exists then we
     * load the data from the form in internDetail.jsp. Then we check if the update relate to a internship, a company or both
     * and then we update the values in the database. Finally once the update is done, we redirect the tutor to his interns list
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
                /*LOADING DATA FROM FORM*/
                Company formCompany = new Company();
                Internship formInternship = new Internship();

                formCompany.setId(Integer.parseInt(request.getParameter(PARAM_IDCOMPANY)));
                formCompany.setAddress(request.getParameter(PARAM_INPUTCOMPANYADDRESS));
                formCompany.setName(request.getParameter(PARAM_INPUTCOMPANYNAME));
                formCompany.setSupervisor(request.getParameter(PARAM_INPUTCOMPANYSUPERVISOR));

                formInternship.setComGrade(Float.parseFloat(request.getParameter(PARAM_INPUTCOMMUNICATIONGRADE)));
                formInternship.setTechGrade(Float.parseFloat(request.getParameter(PARAM_INPUTTECHNICALGRADE)));
                formInternship.setComment(request.getParameter(PARAM_COMMENTS));
                formInternship.setMissionDesc(request.getParameter(PARAM_MISSIONDESCRIPTION));
                formInternship.setVisitDone(checkBoxValue(CHECKBOX_VALUE_VISITDONE, request));
                formInternship.setSpecification(checkBoxValue(CHECKBOX_VALUE_SPECIFICATION, request));
                formInternship.setWebSurvey(checkBoxValue(CHECKBOX_VALUE_WEBSURVEY, request));
                formInternship.setVisitSheet(checkBoxValue(CHECKBOX_VALUE_VISITSHEET, request));
                formInternship.setEvalEntSheet(checkBoxValue(CHECKBOX_VALUE_EVALSHEET, request));
                formInternship.setReport(checkBoxValue(CHECKBOX_VALUE_REPORT, request));
                formInternship.setDefense(checkBoxValue(CHECKBOX_VALUE_DEFENSE, request));
                formInternship.setVisitPlanified(checkBoxValue(CHECKBOX_VALUE_VISITPLANIFIED, request));
                formInternship.setCompany(formCompany);

                /*LOADING DATA FROM SESSION*/
                Intern internSession = (Intern) session.getAttribute(ATTRIBUTE_INTERN);
                Internship internshipSession = internSession.getInternshipById(Integer.parseInt(request.getParameter(PARAM_IDINTERNSHIP)));


                /*INTERNSHIP OR COMPANY != de session*/
                /*UPDATE DES DEUX*/
                if (!internshipSession.equals(formInternship)) {
                    /*CHANGING VALUE BEFORE UPDATING*/
                    internshipSession.setCompany(formCompany);

                    internshipSession.setComGrade(formInternship.getComGrade());
                    internshipSession.setTechGrade(formInternship.getTechGrade());
                    internshipSession.setComment(formInternship.getComment());
                    internshipSession.setMissionDesc(formInternship.getMissionDesc());
                    internshipSession.setVisitDone(formInternship.isVisitDone());
                    internshipSession.setSpecification(formInternship.isSpecification());
                    internshipSession.setWebSurvey(formInternship.isWebSurvey());
                    internshipSession.setVisitSheet(formInternship.isVisitSheet());
                    internshipSession.setEvalEntSheet(formInternship.isEvalEntSheet());
                    internshipSession.setReport(formInternship.isReport());
                    internshipSession.setDefense(formInternship.isDefense());
                    internshipSession.setVisitPlanified(formInternship.isVisitPlanified());
                    
                    /*DATA SERVICES*/
                    DataServices dServices;

                    if (session.getAttribute(SESSION_DATASERVICES) == null) {
                        dServices = new DataServices(this);
                        session.setAttribute(SESSION_DATASERVICES, dServices);
                        dServices.connect();
                    } else {
                        dServices = (DataServices) session.getAttribute(SESSION_DATASERVICES);
                        dServices.connect();
                    }

                    /*UPDATING VALUE*/
                    dServices.updateData(internshipSession, formCompany, session);
                }

                /*REDIRECT TO Interns JSP*/
                request.getRequestDispatcher(JSP_PATH_INTERNLIST).forward(request, response);
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

    private boolean checkBoxValue(String nameInput, HttpServletRequest request) {
        if (request.getParameter(nameInput) == null) {
            return false;
        } else {
            return true;
        }
    }
}
