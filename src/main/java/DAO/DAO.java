/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import static utils.Constants.*;

/**
 * <b> The DAO abtract class is used to create, delete and update any DAO object. </b>
 * <p>
 * The DAO class does only have a parameter :
 * <ul>
 * <li>The connection conn which is instantied as null at first</li>
 * </ul>
 * <p>
 * @author Tristan CLEMENCEAU
 * @param <T> is an object
 */
public abstract class DAO<T> {

    protected Connection conn = null;

    /**
     * Constructor of DAOFactory with all the parameters
     * @param conn Connection who is instantiated as null
     */
    public DAO(Connection conn) {
        this.conn = conn;
    }

    /*CRUD*/

    public abstract boolean update(T obj);

    /**
     * Abstract method that will be used to find an object of type T with help of the id
     * @param id id of the object wanted
     * @return the object with the id wanted
     */
    public abstract T find(int id);
    
    /**
     * Abstract method that will fetch all the objects of type T
     * @return an ArrayList of type T
     */

    public abstract T findWithCredentials(String login,String password);
    
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
