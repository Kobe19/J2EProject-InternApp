/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static utils.Constants.*;

/**
 * <b> The GroupDAO class implements the class DAO. This class implements all the functionality required to find, create, update or delete a Group object</b>
 * <p>
 * As a reminder, a Group is caracterized by these informations :
 * <ul>
 * <li>A unique id</li>
 * <li>The name of the group, can be modified.</li>
 * </ul>
 * <p>
 * @author Tristan CLEMENCEAU
 */
public class GroupDAO extends DAO<Group>{

    /**
     * Overriding of the DAO constructor
     * @param conn Connection
     */
    public GroupDAO(Connection conn) {
        super(conn);
    }

    /**
     * Updating the object Group taken in parameter
     * @param obj object Group to update
     * @return a boolean update when the object is updated
     */
    @Override
    public boolean update(Group obj) {
        return true;
    }

    /**
     * Finding an Group object from the id in parameter
     * @param id id of the Group wanted 
     * @return an object group with the specific id
     */
    @Override
    public Group find(int id) {
        String sqlQuery = QUERY_GROUP_FINDBYID;

        Group group = null;
        
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(sqlQuery);
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                group = new Group(rs.getInt(GROUP_ID), rs.getString(GROUP_NAME));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return group;
    }

    /**
     * Finding with credentials (not supported yet)
     * @param login login of the tutor
     * @param password password of the tutor
     * @return a group
     */
    @Override
    public Group findWithCredentials(String login, String password) {
        throw new UnsupportedOperationException(MSG_NOT_SUPPORTED_YET); //To change body of generated methods, choose Tools | Templates.
    }
    
}
