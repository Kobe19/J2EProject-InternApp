/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Internship;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static utils.Constants.*;

/**
 * <b> The InternshipDAO class implements the class DAO. This class implements all the functionality required to find, create, update or delete an Intership object</b>
 * <p>
 * As a reminder, an Intership is caracterized by these informations :
 * <ul>
 * <li>A unique id</li>
 * <li>The start date of the internship, can be modified</li>
 * <li>The end date of the internship, can be modified</li>
 * <li>The tutor assigned to the intern doing the internship, can be modified</li>
 * <li>The company where the intern is doing the internship, can be modified</li>
 * <li>The intern doing the internship, can be modified</li>
 * <li>The mission's description of the internship, can be modified</li>
 * <li>The comments about the internship, can be modified</li>
 * <li>The technical grade of the internship, can be modified</li>
 * <li>The communication grade of the internship, can be modified</li>
 * <li>If there is specification about the internship, can be modified</li>
 * <li>If the visit sheet about the internship is done, can be modified</li>
 * <li>If the evaluation of the entry sheet about the internship is done, can be modified</li>
 * <li>If the web survey about the internship is done, can be modified</li>
 * <li>If the report about the internship is done, can be modified</li>
 * <li>If the defense about the internship is done, can be modified</li>
 * <li>If the visit about the internship is already planified, can be modified</li>
 * <li>If the visit about the internship is done, can be modified</li>
 * </ul>
 * <p>
 * @author Tristan CLEMENCEAU
 */
public class InternshipDAO extends DAO<Internship>{

    /**
     * Overriding of the DAO constructor
     * @param conn Connection
     */
    public InternshipDAO(Connection conn) {
        super(conn);
    }

    /**
     * Updating the object Internship taken in parameter
     * @param obj object Internship to update
     * @return a boolean update when the object is updated
     */
    @Override
    public boolean update(Internship obj) {
        String sqlQuery = QUERY_INTERNSHIP_UPDATE;
        
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(sqlQuery);
            pst.setString(1, obj.getDateStart());
            pst.setString(2, obj.getDateEnd());
            pst.setString(3, obj.getMissionDesc());
            pst.setString(4, obj.getComment());
            pst.setFloat(5, obj.getTechGrade());
            pst.setFloat(6, obj.getComGrade());
            pst.setBoolean(7, obj.isSpecification());
            pst.setBoolean(8, obj.isVisitSheet());
            pst.setBoolean(9, obj.isEvalEntSheet());
            pst.setBoolean(10, obj.isWebSurvey());
            pst.setBoolean(11, obj.isReport());
            pst.setBoolean(12, obj.isDefense());
            pst.setBoolean(13, obj.isVisitPlanified());
            pst.setBoolean(14, obj.isVisitDone());
            pst.setInt(15, obj.getId());
            
            pst.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    /**
     * Finding an Internship object from the id in parameter
     * @param id id of the Internship wanted 
     * @return an object Internship with the specific id
     */
    @Override
    public Internship find(int id) {
        String sqlQuery = QUERY_INTERNSHIP_FINDBYID;
        String sqlQuery2 = QUERY_INTERNSHIP_FINDALLBYID;

        Internship internship = null;
        InternDAO internDAO = new InternDAO(this.getConnection());
        CompanyDAO companyDAO = new CompanyDAO(this.getConnection());
        TutorDAO tutorDAO = new TutorDAO(this.getConnection());
        
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(sqlQuery);
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                internship = new Internship(rs.getInt(INTERNSHIP_ID) , rs.getString(INTERNSHIP_DATESTART) , rs.getString(INTERNSHIP_DATEEND), rs.getString(INTERNSHIP_MISSIONDESCRIPTION),rs.getString(INTERNSHIP_COMMENT) ,rs.getFloat(INTERNSHIP_TECHGRADE) , rs.getFloat(INTERNSHIP_COMGRADE) , rs.getBoolean(INTERNSHIP_SPECIFICATION) , rs.getBoolean(INTERNSHIP_VISITSHEET) , rs.getBoolean(INTERNSHIP_EVALENTRESHEET) , rs.getBoolean(INTERNSHIP_WEBSURVEY), rs.getBoolean(INTERNSHIP_REPORT) , rs.getBoolean(INTERNSHIP_DEFENSE) , rs.getBoolean(INTERNSHIP_VISITPLANIFIED) , rs.getBoolean(INTERNSHIP_VISITDONE));

            }
            
            pst.clearBatch();
            
            pst = this.getConnection().prepareStatement(sqlQuery2);
            pst.setInt(1, id);
            
            rs = pst.executeQuery();
            while (rs.next()) {
                /*TUTOR*/
                internship.setTutor(tutorDAO.find(rs.getInt(TUTOR_ID)));
                /*INTERN*/
                internship.setIntern(internDAO.find(rs.getInt(INTERN_ID)));
                /*COMPANY*/
                internship.setCompany(companyDAO.find(rs.getInt(COMPANY_ID)));
            }
     
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return internship;
    }

    /**
     * Finding with credentials (not supported yet)
     * @param login login of the tutor
     * @param password password of the tutor
     * @return an Internship
     */
    @Override
    public Internship findWithCredentials(String login, String password) {
        throw new UnsupportedOperationException(MSG_NOT_SUPPORTED_YET); //To change body of generated methods, choose Tools | Templates.
    }
    
}
