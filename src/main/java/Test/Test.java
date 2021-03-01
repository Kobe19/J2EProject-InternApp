/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DAO.DAO;
import DAO.DAOFactory;
import Models.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author trist
 */
public class Test {


    public static void main(String[] args) {
        //normalTest();
        daoTest();
    }
    
    /**
     *
     */
    public static void normalTest(){
        /*OBJECT*/
        Intern intern = new Intern(0, "LINKEDIN LINK", "Gomez", "Alexandre");
        Tutor tutor = new Tutor(0, "loginLOL", "*******", "AUGUSTIN", "Jacque");
        Group group = new Group(0, "m1se");
        Internship internship = new Internship(0, "Création de site");
        Company company = new Company(0, "EDF", "3 rue petit marron", "gerard keaofdaj");
        
         /*DISPLAY BEFORE*/
        System.out.println(intern);
        System.out.println(tutor);
        System.out.println(group);
        System.out.println(internship);
        System.out.println(company);
        
        /*TEST*/
        tutor.getInterns().add(intern);
        internship.setCompany(company);
        intern.setGroup(group);
        intern.getInternships().add(internship);
        
        /*DISPLAY AFTER*/
        System.out.println(intern);
        System.out.println(tutor);
        System.out.println(group);
        System.out.println(internship);
        System.out.println(company);
        
    }
    
    /**
     *
     */
    public static void daoTest(){
        Connection conn = null;
        
        String url = "jdbc:mysql://localhost:3310/st2eedb";
        String username = "root";
        String password = "PsCtYRzR9HPA3MiC";
        
        /*CONNEXION DB*/
         try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
         
        /*FACTORY*/
        DAOFactory daoFactory = new DAOFactory(conn);
        
        /*DAO OBJECT*/
        DAO<Intern> daoIntern = daoFactory.getIntern();
        DAO<Internship> daoInternship = daoFactory.getIntership();
        DAO<Tutor> daoTutor = daoFactory.getTutor();
        DAO<Group> daoGroup = daoFactory.getGroup();
        DAO<Company> daoCompany = daoFactory.getCompany();
        
        /*OBJECT*/
        Intern intern = daoIntern.find(1);
        Tutor tutor = daoTutor.findWithCredentials("jsoma","password");
        Group group = daoGroup.find(1);
        Internship internship = daoInternship.find(1);
        Company company = daoCompany.find(1);
        
        internship.setMissionDesc("Create a website");
        company.setName("ORANGE");
        
        System.out.println("Test.Test.daoTest() update Intern"+daoInternship.update(internship));
        System.out.println("Test.Test.daoTest() update Intern"+daoCompany.update(company));
        
        /*DISPLAY*/
        System.out.println(intern);
        System.out.println(tutor);
        System.out.println("Test.Test.daoTest() intern"+tutor.getInterns().get(0).getInternships());
        System.out.println(group);
        System.out.println(internship);
        System.out.println(company);
        
        tutor = daoTutor.findWithCredentials("jsoma","password");
        System.out.println("Test.Test.daoTest() intern"+tutor.getInterns().get(0).getInternships());
        /*CLOSE*/
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
