/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Intern;
import Models.Tutor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static utils.Constants.*;

/**
 * <b> The TutorDAO class implements the class DAO. This class implements all the functionality required to find, create, update or delete a Tutor object</b>
 * <p>
 * As a reminder, a Tutor is caracterized by these informations :
 * <ul>
 * <li>A unique id</li>
 * <li>The first name of the tutor, can be modified</li>
 * <li>The last name of the tutor, can be modified</li>
 * <li>The login of the tutor, can be modified</li>
 * <li>The password of the tutor, can be modified</li>
 * <li>An arrayList of the intern assigned to the tutor, can be modified</li>
 * </ul>
 * <p>
 * @author Tristan CLEMENCEAU
 */
public class TutorDAO extends DAO<Tutor>{

    /**
     * Overriding of the DAO constructor
     * @param conn Connection
     */
    public TutorDAO(Connection conn) {
        super(conn);
    }


    /**
     * Updating the object Tutor taken in parameter
     * @param obj object Tutor to update
     * @return a boolean update when the object is updated
     */
    @Override
    public boolean update(Tutor obj) {
        return true;
    }

     /**
     * Finding a Tutor object from the id in parameter
     * @param id id of the Tutor wanted 
     * @return an object Tutor with the specific id
     */
    @Override
    public Tutor find(int id) {
        String sqlQuery = QUERY_TUTOR_FINDBYID;
        String sqlQuery2 = QUERY_TUTOR_FINDASSIGNEDINTERN;

        Tutor tutor = null;
        InternDAO internDAO = new InternDAO(this.getConnection());
        
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(sqlQuery);
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                tutor = new Tutor(rs.getInt(TUTOR_ID), rs.getString(TUTOR_LOGIN), rs.getString(TUTOR_PASSWORD) , rs.getString(TUTOR_LASTNAME), rs.getString(TUTOR_FIRSTNAME));
            }
            
            pst.clearBatch();
            
            pst = this.getConnection().prepareStatement(sqlQuery2);
            pst.setInt(1, id);
            
            rs = pst.executeQuery();
            while (rs.next()) {
               tutor.getInterns().add(internDAO.find(rs.getInt(INTERN_ID)));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tutor;
    }
    
    /**
     * Finding with credentials (not supported yet)
     * @param login login of the tutor
     * @param password password of the tutor
     * @return a tutor
     */
    @Override
    public Tutor findWithCredentials(String login,String password){
        String sqlQuery = QUERY_TUTOR_FINDBYCREDENTIALS;
        
        Tutor tutor = null;
        int tutorId = 0;
        
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(sqlQuery);
            pst.setString(1, login);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                tutorId = rs.getInt(TUTOR_ID);
            }
            
            tutor = this.find(tutorId);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        
        return tutor;
    }

    
}
