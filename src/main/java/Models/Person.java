/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 * <b> Person is the class representing the Person. This class is an abstract class that will be used by the class Intern and Tutor which has the same parameters last name and first name</b>
 * <p>
 * A Person is caracterized by these informations :
 * <ul>
 * <li>The first name of the person, can be modified</li>
 * <li>The last name of the person, can be modified</li>
 * </ul>
 * <p>
 * @author Alexandre GOMEZ
 */

public abstract class Person {
    
    private String lastname;
    private String firstname;

    /**
     * Constructor Person with all the parameters
     * <p> 
     * In the constructor we modify the parameter lastname to have it in upper case;
     * We also modify the parameter firstname to have the first letter in upper case and the rest of the parameter in lower case
     * </p>
     * @param lastname lastname of the Person
     * @param firstname firstname of the Person
     */

    public Person(String lastname, String firstname) {
        this.lastname = lastname.toUpperCase();
        this.firstname = firstname.substring(0, 1).toUpperCase() + firstname.substring(1).toLowerCase();
    }

    /**
     * This is a getter which get the lastname
     * @return current lastname from person
     */

    public String getLastname() {
        return lastname;
    }

    /**
     * This is a setter which sets the lastname
     * @param lastname the id to be set
     */

    public void setLastname(String lastname) {
        this.lastname = lastname.toUpperCase();
    }

    /**
     * This is a getter which get the firstname
     * @return current firstname from person
     */

    public String getFirstname() {
        return firstname;
    }

   /**
     * This is a setter which sets the firstname
     * @param firstname the Firstname to be set
     */

    public void setFirstname(String firstname) {
        this.firstname = firstname.substring(0, 1).toUpperCase() + firstname.substring(1).toLowerCase();
    }

    @Override
    public String toString() {
        return String.format("(%s)", this.getClass().getSimpleName().toUpperCase());
    }

    
   
}
