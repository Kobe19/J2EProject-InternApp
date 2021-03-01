/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Company;
import Models.Group;
import Models.Intern;
import Models.Internship;
import Models.Tutor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static utils.Constants.*;

/**
 * <b> The InternDAO class implements the class DAO. This class implements all the functionality required to find, create, update or delete an Intern object</b>
 * <p>
 * As a reminder, an Intern is caracterized by these informations :
 * <ul>
 * <li>A unique id</li>
 * <li>The first name of the intern, can be modified</li>
 * <li>The last name of the intern, can be modified</li>
 * <li>The linkedin of the intern, can be modified</li>
 * <li>The group of the intern, can be modified</li>
 * </ul>
 * <p>
 * @author Tristan CLEMENCEAU
 */
public class InternDAO extends DAO<Intern> {

    /**
     * Overriding of the DAO constructor
     * @param conn Connection
     */
    public InternDAO(Connection conn) {
        super(conn);
    }

    /**
     * Updating the object Intern taken in parameter
     * @param obj object Intern to update
     * @return a boolean update when the object is updated
     */
    @Override
    public boolean update(Intern obj) {
        return true;
    }

    /**
     * Finding an Intern object from the id in parameter
     * @param id id of the Intern wanted 
     * @return an object Intern with the specific id
     */
    @Override
    public Intern find(int id) {
        String sqlQuery = QUERY_INTERN_FINDBYID;
        String sqlQuery2 = QUERY_INTERN_FINDALLBYID;

        Intern intern = null;
        GroupDAO groupDAO = new GroupDAO(this.getConnection());
        CompanyDAO companyDAO = new CompanyDAO(this.getConnection());
        Group group = null;
        Internship internship = null;
        Company company = null;
        Tutor tutor = null;

        try {
            PreparedStatement pst = this.getConnection().prepareStatement(sqlQuery);
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                intern = new Intern(rs.getInt(INTERN_ID), rs.getString(INTERN_LINKEDIN), rs.getString(INTERN_LASTNAME), rs.getString(INTERN_FIRSTNAME));
                group = groupDAO.find(rs.getInt(INTERN_GROUP));
            }

            intern.setGroup(group);

            pst.clearBatch();

            pst = this.getConnection().prepareStatement(sqlQuery2);
            pst.setInt(1, id);

            rs = pst.executeQuery();
            while (rs.next()) {
                /*COMPANY*/
                company = companyDAO.find(rs.getInt(COMPANY_ID));
                /*TUTOR*/
                tutor = new Tutor(rs.getInt(TUTOR_ID), rs.getString(TUTOR_LOGIN), rs.getString(TUTOR_PASSWORD), rs.getString(TUTOR_LASTNAME), rs.getString(TUTOR_FIRSTNAME));
                /*INTERNSHIP*/
                internship = new Internship(rs.getInt(INTERNSHIP_ID), rs.getString(INTERNSHIP_DATESTART), rs.getString(INTERNSHIP_DATEEND), tutor, company, intern, rs.getString(INTERNSHIP_MISSIONDESCRIPTION), rs.getString(INTERNSHIP_COMMENT), rs.getFloat(INTERNSHIP_TECHGRADE), rs.getFloat(INTERNSHIP_COMGRADE), rs.getBoolean(INTERNSHIP_SPECIFICATION), rs.getBoolean(INTERNSHIP_VISITSHEET), rs.getBoolean(INTERNSHIP_EVALENTRESHEET), rs.getBoolean(INTERNSHIP_WEBSURVEY), rs.getBoolean(INTERNSHIP_REPORT), rs.getBoolean(INTERNSHIP_DEFENSE), rs.getBoolean(INTERNSHIP_VISITPLANIFIED), rs.getBoolean(INTERNSHIP_VISITDONE));
                /*INTERN*/
                intern.getInternships().add(internship);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return intern;
    }

    /**
     * Finding with credentials (not supported yet)
     * @param login login of the tutor
     * @param password password of the tutor
     * @return an Intern
     */
    @Override
    public Intern findWithCredentials(String login, String password) {
        throw new UnsupportedOperationException(MSG_NOT_SUPPORTED_YET); //To change body of generated methods, choose Tools | Templates.
    }

}
