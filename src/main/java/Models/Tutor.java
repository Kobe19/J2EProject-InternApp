/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import static utils.Constants.*;

/**
 * <b> Tutor is the class representing the tutor. This class extends from the class Person</b>
 * <p>
 * A Tutor is caracterized by these informations :
 * <ul>
 * <li>A unique id</li>
 * <li>The first name of the tutor, can be modified</li>
 * <li>The last name of the tutor, can be modified</li>
 * <li>The login of the tutor, can be modified</li>
 * <li>The password of the tutor, can be modified</li>
 * <li>An arrayList of the intern assigned to the tutor, can be modified</li>
 * </ul>
 * <p>
 * @author Alexandre GOMEZ
 */

public class Tutor extends Person{
    
    private int id;
    private String login;
    private String password;/*OPTIONAL ?*/
    private ArrayList<Intern> interns = new ArrayList<Intern>();

    /**
     * Constructor Tutor with all the parameters
     * @param id id of the tutor
     * @param login login of the tutor
     * @param password password of the tutor
     * @param lastname lastname of the tutor
     * @param firstname firstname of the tutor
     */

    public Tutor(int id, String login, String password, String lastname, String firstname) {
        super(lastname, firstname);
        this.id = id;
        this.login = login;
        this.password = password;
    }
    
    /**
     * Constructor Tutor without parameters
     */

    public Tutor(){
        super(DEFAULT_VALUE, DEFAULT_VALUE);
        this.id = 0;
        this.login = DEFAULT_VALUE;
        this.password = DEFAULT_VALUE;
    }
    
    /**
     * This is a getter which get the lastname
     * @return current lastname from tutor
     */

    @Override
    public String getLastname(){
        return super.getLastname();
    }
    
    /**
     * This is a setter which sets the lastname
     * @param Lastname the id to be set
     */

    @Override
    public void setLastname(String Lastname){
        super.setLastname(Lastname);
    }
    
    /**
     * This is a getter which get the firstname
     * @return current firstname from tutor
     */

    @Override
    public String getFirstname(){
        return super.getFirstname();
    }
    
    /**
     * This is a setter which sets the Firstname
     * @param Firstname the Firstname to be set
     */

    @Override
    public void setFirstname(String Firstname){
        super.setFirstname(Firstname);
    }
    
    /**
     * This is a getter which get the id
     * @return current id from tutor
     */

    public int getId() {
        return id;
    }

    /**
     * This is a setter which sets the id
     * @param id the id to be set
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     * This is a getter which get the login
     * @return current login from tutor
     */

    public String getLogin() {
        return login;
    }

    /**
     * This is a setter which sets the login
     * @param login the id to be set
     */

    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * This is a getter which get the password
     * @return current password from tutor
     */

    public String getPassword() {
        return password;
    }

    /**
     * This is a setter which sets the password
     * @param password the id to be set
     */

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This is a getter which get the arrayList of interns assigned to the tutor
     * @return current Interns from tutor
     */

    public ArrayList<Intern> getInterns() {
        return interns;
    }

    /**
     * This is a setter which sets the arrayList of interns assigned to the tutor
     * @param interns the arrayList Interns to be set
     */

    public void setListeIntern(ArrayList<Intern> interns) {
        this.interns = interns;
    }
    
    /**
     * This method returns an object intern with the id put in parameters
     * @param id id of the intern wanted
     * @return an object intern with the id wanted
     */
    public Intern getInternById(int id){
        Intern tempIntern = new Intern();
        for(Intern intern : interns){
            if(intern.getId() == id){
                tempIntern = intern;
            }
        }
        return tempIntern;
    }

    @Override
    public String toString() {
        return String.format("(%s)-[Id : %d, Lastname : %s, Firstname : %s, Login : %s, Interns nb : %d]", this.getClass().getSimpleName().toUpperCase(),id,super.getLastname(),super.getFirstname(),login,this.getInterns().size());
    }

    
}
