/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import static utils.Constants.*;
/**
 * <b> Group is the class representing the Group where an intern is</b>
 * <p>
 * A Group is caracterized by these informations :
 * <ul>
 * <li>A unique id</li>
 * <li>The name of the group, can be modified</li>
 * </ul>
 * <p>
 * @author Alexandre GOMEZ
 */

public class Group {
    private int id;
    private String name;
    
    /**
     * Constructor Group without parameters
     */

    public Group(){
        id = 0;
        name = DEFAULT_VALUE;
    }

    /**
     * Constructor Group with all the parameters
     * @param id id of the group 
     * @param name name of the group
     */

    public Group(int id, String name) {
        this.id = id;
        this.name = name.toUpperCase();
    }

    /**
     * This is a getter which get the id
     * @return current id from group
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
     * This is a getter which get the name
     * @return current name from group
     */

    public String getName() {
        return name;
    }

    /**
     * This is a setter which sets the name
     * @param name the name to be set
     */

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    @Override
    public String toString() {
        return String.format("(%s)-[Id : %d, Name : %s]", this.getClass().getSimpleName().toUpperCase(),id,name);
    }
    
    
}
