/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import static utils.Constants.*;


/**
 * <b> The DAO Factory is used to construct various types of concrete DAO factories (Group, Internship, Company, Tutor, Intern)</b>
 * <p>
 * The DAO Factory let us create DAO objects like :
 * <ul>
 * <li>A group</li>
 * <li>A internship</li>
 * <li>A company</li>
 * <li>A tutor</li>
 * <li>A intern</li>
 * </ul>
 * <p>
 * @author Tristan CLEMENCEAU
 */
public class DAOFactory {

    private static Connection conn = null;

    /**
     * Constructor of DAOFactory with all the parameters
     * @param conn Connection who is instantiated as null
     */
    public DAOFactory(Connection conn) {
        this.conn = conn;
    }
    
    /*DAO Object*/

    /**
     * This is a getter which create and get a new Group
     * @return a GroupDAO
     */

    public  DAO getGroup(){
        return new GroupDAO(conn);
    }

    /**
     * This is a getter which create and get a new Internship
     * @return a InternshipDAO
     */
    public  DAO getIntership(){
        return new InternshipDAO(conn);
    }

    /**
     * This is a getter which create and get a new Company
     * @return a CompanyDAO
     */ 
    public  DAO getCompany(){
        return new CompanyDAO(conn);
    }

    /**
     * This is a getter which create and get a new Tutor
     * @return a TutorDAO
     */
    public  DAO getTutor(){
        return new TutorDAO(conn);
    }

    /**
     * This is a getter which create and get a new Interns
     * @return a InternDAO
     */
    public  DAO getIntern(){
        return new InternDAO(conn);
    }
    
    /**
     * This is a getter which get the connection
     * @return current connection
     */
    public Connection getConnection(){
        return conn;
    }
    
    /**
     * This is a setter which set the connection
     * @param conn the connection to be set
     */
    public void setConnect(Connection conn) {
		this.conn = conn;
    }
    
    /**
     * Method that will close the connection
     */
    public void closeConnect() {
        try {
            this.conn.close();
            System.out.println(MSG_CONNEXION_CLOSED);
        } catch (SQLException e) {
            System.out.println(CLOSE_CONNEXION_ERROR +e.getMessage());
        }
    }
}
