/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Objects;
import static utils.Constants.*;

/**
 * <b> Tutor is the class representing the Internship.</b>
 * <p>
 * An Internship is caracterized by these informations :
 * <ul>
 * <li>A unique id</li>
 * <li>The start date of the internship, can be modified</li>
 * <li>The end date of the internship, can be modified</li>
 * <li>The tutor assigned to the intern doing the internship, can be modified</li>
 * <li>The company where the intern is doing the internship, can be modified</li>
 * <li>The intern doing the internship, can be modified</li>
 * <li>The mission's description of the internship, can be modified</li>
 * <li>The comments about the internship, can be modified</li>
 * <li>The technical grade of the internship, can be modified</li>
 * <li>The communication grade of the internship, can be modified</li>
 * <li>If there is specification about the internship, can be modified</li>
 * <li>If the visit sheet about the internship is done, can be modified</li>
 * <li>If the evaluation of the entry sheet about the internship is done, can be modified</li>
 * <li>If the web survey about the internship is done, can be modified</li>
 * <li>If the report about the internship is done, can be modified</li>
 * <li>If the defense about the internship is done, can be modified</li>
 * <li>If the visit about the internship is already planified, can be modified</li>
 * <li>If the visit about the internship is done, can be modified</li>
 * </ul>
 * <p>
 * @author Alexandre GOMEZ
 */

public class Internship {
    private int id;
    private String dateStart;
    private String dateEnd;
    private Tutor tutor;
    private Company company;
    private Intern intern;
    private String missionDesc;
    private String comment;
    private float techGrade;
    private float comGrade;
    private boolean specification;
    private boolean visitSheet;
    private boolean evalEntSheet;
    private boolean webSurvey;
    private boolean report;
    private boolean defense;
    private boolean visitPlanified;
    private boolean visitDone;

    /**
     * Constructor Internship with all the parameters
     * @param id id of the internship
     * @param dateStart start date of the internship
     * @param dateEnd end date of the internship
     * @param tutor tutor assigned to the intern doing the internship
     * @param company company where the intern is doing the internship
     * @param intern intern doing the internship
     * @param missionDesc description of the mission of the internship
     * @param comment comment about the internship
     * @param techGrade technical grade of the internship 
     * @param comGrade communication grade of the internship
     * @param specification any specification about the internship
     * @param visitSheet boolean if the visit sheet is done
     * @param evalEntSheet boolean if the evaluation entry sheet is done
     * @param webSurvey boolean if the web survey about the internship is done
     * @param report boolean if the report about the internship is done
     * @param defense boolean if the defense about the internship is done
     * @param visitPlanified boolean if the visit is already planified
     * @param visitDone boolean if the visit is already done
     */

    public Internship(int id, String dateStart, String dateEnd, Tutor tutor, Company company, Intern intern, String missionDesc,String comment, float techGrade, float comGrade, boolean specification, boolean visitSheet, boolean evalEntSheet, boolean webSurvey, boolean report, boolean defense, boolean visitPlanified, boolean visitDone) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.tutor = tutor;
        this.company = company;
        this.intern = intern;
        this.missionDesc = missionDesc;
        this.comment = comment;
        this.techGrade = techGrade;
        this.comGrade = comGrade;
        this.specification = specification;
        this.visitSheet = visitSheet;
        this.evalEntSheet = evalEntSheet;
        this.webSurvey = webSurvey;
        this.report = report;
        this.defense = defense;
        this.visitPlanified = visitPlanified;
        this.visitDone = visitDone;
    }
    
    /**
     * Constructor Internship without tutor, company and intern
     * @param id id of the internship
     * @param dateStart start date of the internship
     * @param dateEnd end date of the internship
     * @param missionDesc description of the mission of the internship
     * @param comment comment about the internship
     * @param techGrade technical grade of the internship 
     * @param comGrade communication grade of the internship
     * @param specification any specification about the internship
     * @param visitSheet boolean if the visit sheet is done
     * @param evalEntSheet boolean if the evaluation entry sheet is done
     * @param webSurvey boolean if the web survey about the internship is done
     * @param report boolean if the report about the internship is done
     * @param defense boolean if the defense about the internship is done
     * @param visitPlanified boolean if the visit is already planified
     * @param visitDone boolean if the visit is already done
     */

    public Internship(int id, String dateStart, String dateEnd, String missionDesc,String comment, float techGrade, float comGrade, boolean specification, boolean visitSheet, boolean evalEntSheet, boolean webSurvey, boolean report, boolean defense, boolean visitPlanified, boolean visitDone) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.missionDesc = missionDesc;
        this.comment = comment;
        this.techGrade = techGrade;
        this.comGrade = comGrade;
        this.specification = specification;
        this.visitSheet = visitSheet;
        this.evalEntSheet = evalEntSheet;
        this.webSurvey = webSurvey;
        this.report = report;
        this.defense = defense;
        this.visitPlanified = visitPlanified;
        this.visitDone = visitDone;
    }
    
    /**
     * Constructor Internship with only the id and the mission description
     * @param id id of the internship
     * @param missionDesc description of the mission of the internship
     */

    public Internship(int id, String missionDesc) {
        this.id = id;
        this.dateStart = DEFAULT_VALUE;
        this.dateEnd = DEFAULT_VALUE;
        this.tutor = new Tutor();
        this.company = new Company();
        this.intern = new Intern();
        this.missionDesc = missionDesc;
        this.techGrade = 0f;
        this.comGrade = 0f;
        this.specification = false;
        this.visitSheet = false;
        this.evalEntSheet = false;
        this.webSurvey = false;
        this.report = false;
        this.defense = false;
        this.visitPlanified = false;
        this.visitDone = false;
        this.comment = DEFAULT_VALUE;
    }
    
    /**
     * Constructor Internship without parameters
     */
    public Internship() {
        this.id = 0;
        this.dateStart = DEFAULT_VALUE;
        this.dateEnd = DEFAULT_VALUE;
        this.tutor = new Tutor();
        this.company = new Company();
        this.intern = new Intern();
        this.missionDesc = DEFAULT_VALUE;
        this.techGrade = 0f;
        this.comGrade = 0f;
        this.specification = false;
        this.visitSheet = false;
        this.evalEntSheet = false;
        this.webSurvey = false;
        this.report = false;
        this.defense = false;
        this.visitPlanified = false;
        this.visitDone = false;
        this.comment = DEFAULT_VALUE;
    }

/**
     * This is a getter which get the id
     * @return current id from internship
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
     * This is a getter which get the dateStart
     * @return current dateStart from internship
     */
    public String getDateStart() {
        return dateStart;
    }

    /**
     * This is a setter which sets the dateStart
     * @param dateStart the dateStart to be set
     */
    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    /**
     * This is a getter which get the dateEnd
     * @return current dateEnd from internship
     */
    public String getDateEnd() {
        return dateEnd;
    }

    /**
     * This is a setter which sets the dateEnd
     * @param dateEnd the dateStart to be set
     */
    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     * This is a getter which get the tutor
     * @return current tutor from internship
     */
    public Tutor getTutor() {
        return tutor;
    }

    /**
     * This is a setter which sets the tutor
     * @param tutor the dateStart to be set
     */
    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    /**
     * This is a getter which get the company
     * @return current company from internship
     */
    public Company getCompany() {
        return company;
    }

    /**
     * This is a setter which sets the company
     * @param company the dateStart to be set
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * This is a getter which get the intern
     * @return current intern from internship
     */
    public Intern getIntern() {
        return intern;
    }

    /**
     * This is a setter which sets the intern
     * @param intern the dateStart to be set
     */
    public void setIntern(Intern intern) {
        this.intern = intern;
    }

    /**
     * This is a getter which get the missionDesc
     * @return missionDesc intern from internship
     */
    public String getMissionDesc() {
        return missionDesc;
    }

    /**
     * This is a setter which sets the missionDescss
     * @param missionDesc the dateStart to be set
     */
    public void setMissionDesc(String missionDesc) {
        this.missionDesc = missionDesc;
    }

    /**
     * This is a getter which get the techGrade
     * @return techGrade intern from internship
     */
    public float getTechGrade() {
        return techGrade;
    }

    /**
     * This is a setter which sets the techGrade
     * @param techGrade the dateStart to be set
     */
    public void setTechGrade(float techGrade) {
        this.techGrade = techGrade;
    }

    /**
     * This is a getter which get the comGrade
     * @return comGrade intern from internship
     */
    public float getComGrade() {
        return comGrade;
    }

    /**
     * This is a setter which sets the comGrade
     * @param comGrade the dateStart to be set
     */
    public void setComGrade(float comGrade) {
        this.comGrade = comGrade;
    }

    /**
     * This is a getter which get the specification
     * @return specification intern from internship
     */
    public boolean isSpecification() {
        return specification;
    }

    /**
     * This is a setter which sets the specification
     * @param specification the dateStart to be set
     */
    public void setSpecification(boolean specification) {
        this.specification = specification;
    }

    /**
     * This is a getter which get the visitSheet
     * @return visitSheet intern from internship
     */
    public boolean isVisitSheet() {
        return visitSheet;
    }

    /**
     * This is a setter which sets the visitSheet
     * @param visitSheet the dateStart to be set
     */
    public void setVisitSheet(boolean visitSheet) {
        this.visitSheet = visitSheet;
    }

    /**
     * This is a getter which get the evalEntSheet
     * @return evalEntSheet intern from internship
     */
    public boolean isEvalEntSheet() {
        return evalEntSheet;
    }

    /**
     * This is a setter which sets the evalEntSheet
     * @param evalEntSheet the dateStart to be set
     */
    public void setEvalEntSheet(boolean evalEntSheet) {
        this.evalEntSheet = evalEntSheet;
    }

    /**
     * This is a getter which get the webSurvey
     * @return webSurvey intern from internship
     */
    public boolean isWebSurvey() {
        return webSurvey;
    }

    /**
     * This is a setter which sets the webSurvey
     * @param webSurvey the dateStart to be set
     */
    public void setWebSurvey(boolean webSurvey) {
        this.webSurvey = webSurvey;
    }

    /**
     * This is a getter which get the report
     * @return report intern from internship
     */
    public boolean isReport() {
        return report;
    }

    /**
     * This is a setter which sets the report
     * @param report the dateStart to be set
     */
    public void setReport(boolean report) {
        this.report = report;
    }

    /**
     * This is a getter which get the defense
     * @return defense intern from internship
     */
    public boolean isDefense() {
        return defense;
    }

    /**
     * This is a setter which sets the defense
     * @param defense the dateStart to be set
     */
    public void setDefense(boolean defense) {
        this.defense = defense;
    }

    /**
     * This is a getter which get the visitPlanified
     * @return visitPlanified intern from internship
     */
    public boolean isVisitPlanified() {
        return visitPlanified;
    }

    /**
     * This is a setter which sets the visitPlanified
     * @param visitPlanified the dateStart to be set
     */
    public void setVisitPlanified(boolean visitPlanified) {
        this.visitPlanified = visitPlanified;
    }

    /**
     * This is a getter which get the visitDone
     * @return visitDone intern from internship
     */
    public boolean isVisitDone() {
        return visitDone;
    }

    /**
     * This is a setter which sets the visitDone
     * @param visitDone the dateStart to be set
     */
    public void setVisitDone(boolean visitDone) {
        this.visitDone = visitDone;
    }

    /**
     * This is a getter which get the comment
     * @return comment intern from internship
     */
    public String getComment() {
        return comment;
    }

    /**
     * This is a setter which sets the comment
     * @param comment the dateStart to be set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.company);
        hash = 97 * hash + Objects.hashCode(this.missionDesc);
        hash = 97 * hash + Objects.hashCode(this.comment);
        hash = 97 * hash + Float.floatToIntBits(this.techGrade);
        hash = 97 * hash + Float.floatToIntBits(this.comGrade);
        hash = 97 * hash + (this.specification ? 1 : 0);
        hash = 97 * hash + (this.visitSheet ? 1 : 0);
        hash = 97 * hash + (this.evalEntSheet ? 1 : 0);
        hash = 97 * hash + (this.webSurvey ? 1 : 0);
        hash = 97 * hash + (this.report ? 1 : 0);
        hash = 97 * hash + (this.defense ? 1 : 0);
        hash = 97 * hash + (this.visitPlanified ? 1 : 0);
        hash = 97 * hash + (this.visitDone ? 1 : 0);
        return hash;
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
        final Internship other = (Internship) obj;
        if (Float.floatToIntBits(this.techGrade) != Float.floatToIntBits(other.techGrade)) {
            return false;
        }
        if (Float.floatToIntBits(this.comGrade) != Float.floatToIntBits(other.comGrade)) {
            return false;
        }
        if (this.specification != other.specification) {
            return false;
        }
        if (this.visitSheet != other.visitSheet) {
            return false;
        }
        if (this.evalEntSheet != other.evalEntSheet) {
            return false;
        }
        if (this.webSurvey != other.webSurvey) {
            return false;
        }
        if (this.report != other.report) {
            return false;
        }
        if (this.defense != other.defense) {
            return false;
        }
        if (this.visitPlanified != other.visitPlanified) {
            return false;
        }
        if (this.visitDone != other.visitDone) {
            return false;
        }
        if (!Objects.equals(this.missionDesc, other.missionDesc)) {
            return false;
        }
        if (!Objects.equals(this.comment, other.comment)) {
            return false;
        }
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return String.format("(%s)-[Id : %d, Start : %s, End : %s, Tutor : %s, Company : %s, Intern : %s, Description : %s]", this.getClass().getSimpleName().toUpperCase(),id,dateStart,dateEnd,tutor.getLastname()+","+tutor.getFirstname(),company.getName(),intern.getLastname()+","+intern.getFirstname(),missionDesc);
    }
    
    
}
