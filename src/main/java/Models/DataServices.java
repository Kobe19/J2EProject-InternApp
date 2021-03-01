package Models;

import DAO.DAO;
import DAO.DAOFactory;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static utils.Constants.*;

/**
 * <b> Data Services is the class representing the Data Services where we make the connexion to the database</b>
 * <p>
 * The class Data Services is caracterized by these informations :
 * <ul>
 * <li>A Connection</li>
 * <li>A Statement</li>
 * <li>A ResultSet</li>
 * <li>A Username</li>
 * <li>A Password</li>
 * <li>A Url</li>
 * </ul>
 * <p>
 * @author Tristan CLEMENCEAU
 */

public class DataServices {

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private String username, password, url,salt;

    /**
     * Constructor DataServices with a parameter
     * @param servlet http servlet
     */
    public DataServices(HttpServlet servlet) {
        /*LOADING FROM PORPERTIES*/
        InputStream input = servlet.getServletContext().getResourceAsStream(PROPERTIES_PATH);
        Properties properties = new Properties();

        try {
            properties.load(input);
            url = properties.getProperty(PROPERTIES_DB_URL);
            username = properties.getProperty(PROPERTIES_DB_USER);
            password = properties.getProperty(PROPERTIES_DB_PASSWORD);
            salt = properties.getProperty(PROPERTIES_DB_SALT);
        } catch (IOException ex) {
            System.out.println(PROPERTIES_MSG_ERROR+ex.getMessage());
        }
    }

    /**
     * This is a method where we get the connexion
     * We load the driver then we connect to the database with the url, username and password
     * If the three are good, it is going to connect to the database if not,
     * the connection is not successful and the method will trhow an exception 
     */

    public void connect() {
        /*LOADING DRIVER*/
        try {
            Class.forName(PROPERTIES_DB_DRIVER);
            System.out.println(DB_MSG_SUCCESS_DRIVER_LOADED);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(DB_MSG_ERROR_DRIVER, e);
        }
        /*CONNECTING TO DB*/
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println(DB_MSG_SUCCESS_CO);
        } catch (SQLException e) {
            throw new IllegalStateException(DB_MSG_ERROR_CO, e);
        }
    }

    /**
     * This is a method that close the connection to the database
     * If either the connection, the statement or the resultset is not null, we can close them.
     * 
     */
    public void disconect() {
        try {
            if (conn != null) {
                conn.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            if (rs != null) {
                rs.close();
            }

            System.out.println(DB_MSG_SUCCESS_DECO);
        } catch (SQLException e) {
            System.out.println(CLOSE_CONNEXION_ERROR + e.getMessage());
        }

    }

    /**
     * This is a method that will update the data that was updated by the tutor
     * @param internship internship that got updated by the tutor
     * @param company company that got updated by the tutor
     * @param session session of the tutor
     */
    public void updateData(Internship internship, Company company, HttpSession session) {

        /*CONNEXION*/
        if (conn == null) {
            this.connect();
        }

        Tutor tutor = (Tutor) session.getAttribute(SESSION_USER);
        int idTutor = tutor.getId();


        /*DAO*/
        DAOFactory daoFactory = new DAOFactory(conn);

        DAO<Internship> daoInternship = daoFactory.getIntership();
        DAO<Company> daoCompany = daoFactory.getCompany();
        DAO<Tutor> daoTutor = daoFactory.getTutor();

        /*VERIFICATION*/
        if (daoCompany.update(company)) {
            System.out.println(DAO_MSG_SUCCESS_UPDATE_COMPANY);
        }

        if (daoInternship.update(internship)) {
            System.out.println(DAO_MSG_SUCCESS_UPDATE_INTERNSHIP);
        }

        /*UPDATING USER FROM SESSION*/
        session.removeAttribute(SESSION_USER);
        tutor = daoTutor.find(idTutor);

        session.setAttribute(SESSION_USER, tutor);

        this.disconect();
    }

    /**
     * This method load all the data needed when the tutor is logging in
     * @param session session of the tutor
     */
    public void loadData(HttpSession session) {

        /*CONNEXION*/
        if (conn == null) {
            this.connect();
        }

        /*FACTORY*/
        DAOFactory daoFactory = new DAOFactory(conn);

        /*DAO*/
        DAO<Tutor> daoTutor = daoFactory.getTutor();

        Tutor tutor = (Tutor) session.getAttribute(SESSION_USER);

        tutor = daoTutor.findWithCredentials(tutor.getLogin(), tutor.getPassword());
        tutor = daoTutor.find(tutor.getId());

        session.setAttribute(SESSION_USER, tutor);

        this.disconect();
    }

    /**
     * This method check the credentials(login and password) of the tutor trying to log in
     * @param request request http
     * @return a boolean true if credential are good false if not good
     */
    public boolean checkCredential(HttpServletRequest request) {

        boolean passCheck = false;
        boolean logiCheck = false;

        /*CONNEXION*/
        if (conn == null) {
            this.connect();
        }

        try {
            /*CHECK LOGIN*/
            logiCheck = isLoginValid(request.getParameter(PARAM_LOGINFORM));
            if (logiCheck) {
                /*LOGIN IS CORRECT*/
                passCheck = isPasswordValid(getHash(request.getParameter(PARAM_PASSFORM)), request.getParameter(PARAM_LOGINFORM));
                /*CHECK PASSWORD*/
                if (!passCheck) {
                    /*ADDING ERROR IN REQUEST*/
                    request.setAttribute(SESSION_STATUS_PASSWORD, STATUS_MSG_ERROR_PASSWORD);
                }
            } else {
                /*LOGIN IS INCORRECT*/
                /*ADDING ERROR IN REQUEST*/
                request.setAttribute(SESSION_STATUS_LOGIN, STATUS_MSG_ERROR_LOGIN);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        this.disconect();

        /*RETURNING THE STATE OF PASSWORD AND LOGIN*/
        return (passCheck && logiCheck);
    }

    /**
     * This method check if the password input by the tutor is in the database, also check if the login matches with the password
     * @param password password input by the tutor
     * @param login login input by the tutor
     * @return a boolean true if password is in the database or false if not
    */
    private boolean isPasswordValid(String password, String login) throws SQLException {
        String sqlQuery = QUERY_VALID_PASSWORD;
        boolean valid = false;

        /*CONNEXION*/
        if (conn == null) {
            this.connect();
        }

        try {
            int cpt = 0;
            PreparedStatement pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, login);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            /*COUNT NUMBER OF ROWS*/
            while (rs.next()) {
                cpt++;
            }

            if (cpt == 1) {
                valid = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return valid;
    }
    
    /**
     * This method check if the login input by the tutor is in the database
     * @param login login input by the tutor
     * @return a boolean true if login is in the database or false if not
    */
    private boolean isLoginValid(String login) throws SQLException {

        String sqlQuery = QUERY_VALID_LOGIN;
        boolean valid = false;

        /*CONNEXION*/
        if (conn == null) {
            this.connect();
        }

        try {
            int cpt = 0;
            PreparedStatement pst = conn.prepareStatement(sqlQuery);
            pst.setString(1, login);

            ResultSet rs = pst.executeQuery();

            /*COUNT NUMBER OF ROWS*/
            while (rs.next()) {
                cpt++;
            }

            if (cpt == 1) {
                valid = true;
            }

        } catch (SQLException e) {
            System.out.println(DB_MSG_ERROR_CO+e.getMessage());
        }

        return valid;
    }
    
    public String getHash(String password){
        
        password+=salt;
        
        try {
            
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[]hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            
            //bytes to hex
            StringBuilder sb = new StringBuilder();
            
            for (byte b : hashInBytes) {
                sb.append(String.format("%02x", b));
            }
            
            password = sb.toString();
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DataServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return password;
    }

}
