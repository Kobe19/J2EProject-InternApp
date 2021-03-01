package Models;

import static utils.Constants.*;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * <b> Company is the class representing the Company where an intern can do his internship</b>
 * <p>
 * A Company is caracterized by these informations :
 * <ul>
 * <li>A unique id</li>
 * <li>The name of the company, can be modified</li>
 * <li>The address of the company, can be modified</li>
 * <li>The supervisor of the internship who works in the company, can be modified</li>
 * </ul>
 * <p>
 * @author Alexandre GOMEZ
 */

public class Company {

    private int id;
    private String name;
    private String address;
    private String supervisor;

    /**
     * Constructor Company with all the parameters
     * @param id id of the company
     * @param name name of the company
     * @param address address of the company
     * @param supervisor supervisor that supervise the intern in the company
     */

    public Company(int id, String name, String address, String supervisor) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.supervisor = supervisor.toUpperCase();
    }
    
    /**
     * Constructor Company without the supervisor. A Company does not need to have a supervisor
     * @param id id of the company
     * @param name name of the company
     * @param address address of the company
     */

    public Company(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.supervisor = DEFAULT_VALUE.toUpperCase();
    }
    
    /**
     * Constructor Company without any parameters.
     */

    public Company(){
        this.id = 0;
        this.name = DEFAULT_VALUE;
        this.address = DEFAULT_VALUE;
        this.supervisor = DEFAULT_VALUE.toUpperCase();
    }

    /**
     * This is a getter which get the id
     * @return current id from company
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
     * @return current name from company
     */

    public String getName() {
        return name;
    }


    /**
     * This is a setter which sets the name
     * @param name the name to be set
     */

    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * This is a getter which get the address
     * @return current address from company
     */

    public String getAddress() {
        return address;
    }
    
    /**
     * This is a setter which sets the address
     * @param address the address to be set
     */

    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * This is a getter which get the supervisor
     * @return current supervisor from company
     */

    public String getSupervisor() {
        return supervisor;
    }

    /**
     * This is a setter which sets the address
     * @param supervisor the supervisor to be set
     */

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor.toUpperCase();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Company other = (Company) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.supervisor, other.supervisor)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.address);
        hash = 71 * hash + Objects.hashCode(this.supervisor);
        return hash;
    }
    
    @Override
    public String toString() {
        return String.format("(%s)-[Id : %d, Name : %s, Address : %s, Supervisor : %s]", this.getClass().getSimpleName().toUpperCase(),id,name,address,supervisor);
    }

}
