/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import static utils.Constants.*;

/**
 * <b> Intern is the class representing the Intern. This class extends from the class Person</b>
 * <p>
 * An Intern is caracterized by these informations :
 * <ul>
 * <li>A unique id</li>
 * <li>The first name of the intern, can be modified</li>
 * <li>The last name of the intern, can be modified</li>
 * <li>The linkedin of the intern, can be modified</li>
 * <li>The group of the intern, can be modified</li>
 * </ul>
 * <p>
 * @author Alexandre GOMEZ
 */

public class Intern extends Person{
    
    private int id;
    private Group group;
    private String linkedin;
    private ArrayList<Internship> internships = new ArrayList<Internship>();

    /**
     * Constructor Intern with all the parameters
     * @param id id of the Intern
     * @param group group of the Intern
     * @param linkedin linkedin of the Intern
     * @param lastname lastname of the Intern
     * @param firstname firstname of the Intern
     */

    public Intern(int id, Group group, String linkedin, String lastname, String firstname) {
        super(lastname, firstname);
        this.id = id;
        this.group = group;
        this.linkedin = linkedin;
    }
    
    /**
     * Constructor Intern without group
     * @param id id of the Intern
     * @param linkedin linkedin of the Intern
     * @param lastname lastname of the Intern
     * @param firstname firstname of the Intern
     */

    public Intern(int id, String linkedin, String lastname, String firstname) {
        super(lastname, firstname);
        this.id = id;
        this.linkedin = linkedin;
        group = new Group();
    }
    
    /**
     * Constructor Intern without parameters
     */

    public Intern(){
        super(DEFAULT_VALUE, DEFAULT_VALUE);
        id = 0;
        group = new Group();
        linkedin = DEFAULT_VALUE;
    }
    
    /**
     * This is a getter which get the Lastname
     * @return current Lastname from intern
     */

    @Override
    public String getLastname(){
        return super.getLastname();
    }
    
    /**
     * This is a setter which sets the Lastname
     * @param Lastname the id to be set
     */

    @Override
    public void setLastname(String Lastname){
        super.setLastname(Lastname);
    }
    
    /**
     * This is a getter which get the Firstname
     * @return current Firstname from intern
     */

    @Override
    public String getFirstname(){
        return super.getFirstname();
    }
    
    /**
     * This is a setter which sets the firstname
     * @param Firstname the id to be set
     */

    @Override
    public void setFirstname(String Firstname){
        super.setFirstname(Firstname);
    }
    
    /**
     * This is a getter which get the id
     * @return current id from intern
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
     * This is a getter which get the group
     * @return current group from intern
     */

    public Group getGroup() {
        return group;
    }

    /**
     * This is a setter which sets the group
     * @param group the group to be set
     */

    public void setGroup(Group group) {
        this.group = group;
    }

    /**
     * This is a getter which get the Linkedin
     * @return current Linkedin from intern
     */

    public String getLinkedin() {
        return linkedin;
    }

    /**
     * This is a setter which sets the linkedin
     * @param linkedin the linkedin to be set
     */

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    /**
     * This is a getter which get the arraylist of Internships of the intern
     * @return current arraylist Internships from intern
     */

    public ArrayList<Internship> getInternships() {
        return internships;
    }

    /**
     * This is a setter which sets the arrayList Internships
     * @param internships the internships of the intern
     */
    public void setListInternship(ArrayList<Internship> internships) {
        this.internships = internships;
    }
    
    /**
     * This method returns the internship with the id put in parameters
     * @param id id of the internship
     * @return an object internship with the id wanted
     */
    public Internship getInternshipById(int id){
        Internship tempInternship = new Internship();
        for(Internship internship : internships){
            if(internship.getId() == id){
                tempInternship = internship;
            }
        }
        return tempInternship;
    }

    @Override
    public String toString() {
        return String.format("(%s)-[Id : %d, Lastname : %s, Firstname : %s, Group : %s, Linkedin : %s, Internship nb : %d]", this.getClass().getSimpleName().toUpperCase(),id,this.getLastname(),this.getFirstname(),group.getName(),linkedin,internships.size());
    }
    
    
            
}
