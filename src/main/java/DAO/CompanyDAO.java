/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static utils.Constants.*;

/**
 * <b> The CompanyDAO class implements the class DAO. This class implements all the functionality required to find, create, update or delete a Company object</b>
 * <p>
 * As a reminder, a Company is caracterized by these informations :
 * <ul>
 * <li>A unique id</li>
 * <li>The name of the company, can be modified.</li>
 * <li>The address of the company, can be modified</li>
 * <li>The supervisor of the internship who works in the company, can be modified</li>
 * </ul>
 * <p>
 * @author Tristan CLEMENCEAU
 */
public class CompanyDAO extends DAO<Company> {

    /**
     * Overriding of the DAO constructor
     * @param conn connection
     */
    public CompanyDAO(Connection conn) {
        super(conn);
    }

    /**
     * Updating the object Company taken in parameter
     * @param obj object company to update
     * @return a boolean true when the object is updated
     */
    @Override
    public boolean update(Company obj) {
         String sqlQuery = QUERY_COMPANY_UPDATE;
        
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(sqlQuery);
            pst.setString(1, obj.getName());
            pst.setString(2, obj.getAddress());
            pst.setString(3, obj.getSupervisor());
            pst.setInt(4, obj.getId());
            
            pst.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    /**
     * Finding an Company object from the id in parameter
     * @param id id of the Company wanted
     * @return an object company with the specific id
     */
    @Override
    public Company find(int id) {
        String sqlQuery = QUERY_COMPANY_FINDBYID;

        Company company = null;
        
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(sqlQuery);
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                company = new Company(rs.getInt(COMPANY_ID), rs.getString(COMPANY_NAME), rs.getString(COMPANY_ADDRESS), rs.getString(COMPANY_SUPERVISORNAME)); 
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return company;
    }

    /**
     * Finding with credentials (not supported yet)
     * @param login login of the tutor
     * @param password password of the tutor
     * @return a company
     */
    @Override
    public Company findWithCredentials(String login, String password) {
        throw new UnsupportedOperationException(MSG_NOT_SUPPORTED_YET); //To change body of generated methods, choose Tools | Templates.
    }

}
