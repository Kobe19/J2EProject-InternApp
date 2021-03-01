/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author trist
 */
public class Constants {
    
    /*SETTINGS*/

    /**
     *
     */

    public static final String PROPERTIES_PATH = "/WEB-INF/dbproperties.properties";

    /**
     *
     */
    public static final String PROPERTIES_DB_URL = "DB_URL";

    /**
     *
     */
    public static final String PROPERTIES_DB_USER = "DB_USER";

    /**
     *
     */
    public static final String PROPERTIES_DB_PASSWORD = "DB_PASSWORD";

    public static final String PROPERTIES_DB_SALT = "SALT";

    public static final String PROPERTIES_DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    
    /*DEFAULT*/

    /**
     *
     */

    public static final String DEFAULT_VALUE = "UNDEFINED";
    
    /*SESSION ATTRIBUTE USER*/

    /**
     *
     */

    public static final String SESSION_USER = "user";

    /**
     *
     */
    public static final String SESSION_DATASERVICES = "dataService";

    /**
     *
     */
    public static final String SESSION_STATUS = "status";

    /**
     *
     */
    public static final String SESSION_STATUS_PASSWORD = "statusPassword";

    /**
     *
     */
    public static final String SESSION_STATUS_LOGIN = "statusLogin";
    
    /*SERVLET*/
    
        /*PATH TO SERVLETS*/

    /**
     *
     */

        public static final String SERVLET_PATH_AUTH = "/Auth";

    /**
     *
     */
    public static final String SERVLET_PATH_ROOTER = "/Rooter";

    /**
     *
     */
    public static final String SERVLET_PATH_HOMEPAGE = "/HomePage";

        /*PATH TO JSP*/

    /**
     *
     */

        public static final String JSP_PATH_AUTHPAGE = "/WEB-INF/JSP/authPage.jsp";

    /**
     *
     */
    public static final String JSP_PATH_HOMEPAGE = "/WEB-INF/JSP/homePage.jsp";

    /**
     *
     */
    public static final String JSP_PATH_INTERNDETAIL = "/WEB-INF/JSP/InternDetail.jsp";

    /**
     *
     */
    public static final String JSP_PATH_INTERNLIST = "/WEB-INF/JSP/InterList.jsp";

    /**
     *
     */
    public static final String JSP_PATH_INDEX = "/WEB-INF/index.jsp";
    
        /*URLPATTERN*/

    /**
     *
     */

        public static final String URLPATTERN_ROOTER = "/Rooter_1";
        
        /*WEBSERVLETS NAMES*/

    /**
     *
     */

        public static final String NAME_ROOTER = "Rooter_1";

    /**
     *
     */
    public static final String NAME_HOMEPAGE = "HomePage";
        
        
    /*ATTRIBUTE*/

    /**
     *
     */

    public static final String ATTRIBUTE_INTERN = "intern";

    /**
     *
     */
    public static final String ATTRIBUTE_INTERNSHIP = "internship";
    
    /*PARAMETERS*/

    /**
     *
     */

    public static final String PARAM_LOGINFORM = "loginForm";

    /**
     *
     */
    public static final String PARAM_PASSFORM = "passForm";

    /**
     *
     */
    public static final String PARAM_IDINTERN = "idIntern";

    /**
     *
     */
    public static final String PARAM_IDINTERNSHIP = "idInternship";

    /**
     *
     */
    public static final String PARAM_IDCOMPANY = "idCompany";
    
    /*PARAMETERS INTERNSHIP*/
    
        /*INPUTS*/

    /**
     *
     */

        public static final String PARAM_INPUTCOMPANYADDRESS = "InputCompanyAddress";

    /**
     *
     */
    public static final String PARAM_INPUTCOMPANYNAME = "InputCompanyName";

    /**
     *
     */
    public static final String PARAM_INPUTCOMPANYSUPERVISOR = "InputCompanySupervisor";

    /**
     *
     */
    public static final String PARAM_INPUTCOMMUNICATIONGRADE = "InputCommunicationGrade";

    /**
     *
     */
    public static final String PARAM_INPUTTECHNICALGRADE = "InputTechnicalGrade";

    /**
     *
     */
    public static final String PARAM_COMMENTS = "comments";

    /**
     *
     */
    public static final String PARAM_MISSIONDESCRIPTION = "missionDescription";
    
        /*CHECKBOX VALUES*/

    /**
     *
     */

        public static final String CHECKBOX_VALUE_VISITDONE = "checkVisitDone";

    /**
     *
     */
    public static final String CHECKBOX_VALUE_SPECIFICATION = "checkSpecification";

    /**
     *
     */
    public static final String CHECKBOX_VALUE_WEBSURVEY = "checkWebSurvey";

    /**
     *
     */
    public static final String CHECKBOX_VALUE_VISITSHEET = "checkVisitSheet";

    /**
     *
     */
    public static final String CHECKBOX_VALUE_EVALSHEET = "checkEvalSheet";

    /**
     *
     */
    public static final String CHECKBOX_VALUE_REPORT = "checkReport";

    /**
     *
     */
    public static final String CHECKBOX_VALUE_DEFENSE = "checkDefense";

    /**
     *
     */
    public static final String CHECKBOX_VALUE_VISITPLANIFIED = "checkVisitPlanified";
    
    
    /*MESSAGES*/
        /*[ERROR] MSG*/

    /**
     *
     */

        public static final String DB_MSG_ERROR_CO = "[ERROR] : Impossible de joindre la base de donnée";

    /**
     *
     */
    public static final String NO_PARAMETERS_LOGIN_INPUT = "[ERROR] : Please fill the fields";

    /**
     *
     */
    public static final String CLOSE_CONNEXION_ERROR = "[ERROR] : Connexion can't be closed";

    /**
     *
     */
    public static final String DB_MSG_ERROR_DRIVER = "[ERROR] : Cannot find the driver in the classpath!";

    /**
     *
     */
    public static final String PROPERTIES_MSG_ERROR = "[ERROR] : Can't load data from properties";

    /**
     *
     */
    public static final String STATUS_MSG_ERROR_PASSWORD = "[ERROR] : Invalid credential try again";

    /**
     *
     */
    public static final String STATUS_MSG_ERROR_LOGIN = "[ERROR] : Invalid Login try again";

    /**
     *
     */
    public static final String MSG_ERROR_GET = "[ERROR] : GET request are not allowed on this servlet";
        /*[SUCCESS] MSG*/

    /**
     *
     */

        public static final String DB_MSG_SUCCESS_CO = "[SUCCESS] : Connecté à la base de donnée";

    /**
     *
     */
    public static final String DB_MSG_SUCCESS_DECO = "[SUCCESS] : Déconnecté de la base de donnée";

    /**
     *
     */
    public static final String DB_MSG_SUCCESS_DRIVER_LOADED = "[SUCCESS] : Driver loaded";

    /**
     *
     */
    public static final String DAO_MSG_SUCCESS_UPDATE_COMPANY = "[SUCCESS] : Company updated";

    /**
     *
     */
    public static final String DAO_MSG_SUCCESS_UPDATE_INTERNSHIP = "[SUCCESS] : Internship updated";

    /**
     *
     */
    public static final String MSG_SUCCESS_DECONNECTION = "[SUCCESS] : User deconnected";
        /*[OTHER] MSG*/

    /**
     *
     */

        public static final String MSG_CONNEXION_CLOSED = "connexion closed";

    /**
     *
     */
    public static final String MSG_NOT_SUPPORTED_YET = "Not supported yet.";
    /*DATASERVICES*/

    /**
     *
     */

        public static final String QUERY_VALID_PASSWORD ="SELECT * FROM tutor where login_Tutor = ? and password_Tutor = ? ;";

    /**
     *
     */
    public static final String QUERY_VALID_LOGIN ="SELECT * FROM tutor where login_Tutor = ? ;";
    /*DAO*/
        
        /*CompanyDAO*/

    /**
     *
     */

        public static final String QUERY_COMPANY_UPDATE = "UPDATE company SET name_Company =?, address_Company =?, supervisorName_Company =? WHERE id_Company =?;";

    /**
     *
     */
    public static final String QUERY_COMPANY_FINDBYID = "SELECT * FROM company WHERE id_Company = ?;";

    /**
     *
     */
    public static final String COMPANY_ID = "id_Company";

    /**
     *
     */
    public static final String COMPANY_NAME = "name_Company";

    /**
     *
     */
    public static final String COMPANY_ADDRESS = "address_Company";

    /**
     *
     */
    public static final String COMPANY_SUPERVISORNAME = "supervisorname_Company";
        
        /*GroupDAO*/

    /**
     *
     */

        public static final String QUERY_GROUP_FINDBYID = "SELECT * FROM groupefrei WHERE id_Group = ?;";

    /**
     *
     */
    public static final String GROUP_ID = "id_Group";

    /**
     *
     */
    public static final String GROUP_NAME = "name_Group";
        
        /*TutorDAO*/

    /**
     *
     */

        public static final String QUERY_TUTOR_FINDBYID = "SELECT * FROM tutor WHERE id_Tutor = ?;";

    /**
     *
     */
    public static final String QUERY_TUTOR_FINDASSIGNEDINTERN = "SELECT * FROM assignedintern WHERE id_Tutor = ?;";

    /**
     *
     */
    public static final String QUERY_TUTOR_FINDBYCREDENTIALS = "select id_Tutor from tutor where login_Tutor = ? and password_Tutor = ? ;";

    /**
     *
     */
    public static final String TUTOR_ID = "id_Tutor";

    /**
     *
     */
    public static final String TUTOR_LOGIN = "login_Tutor";

    /**
     *
     */
    public static final String TUTOR_PASSWORD = "password_Tutor";

    /**
     *
     */
    public static final String TUTOR_LASTNAME = "lastname_Tutor";

    /**
     *
     */
    public static final String TUTOR_FIRSTNAME = "firstname_Tutor";
        
        /*InternDAO*/

    /**
     *
     */

        public static final String QUERY_INTERN_FINDBYID = "SELECT * FROM intern WHERE id_Intern = ?;";

    /**
     *
     */
    public static final String QUERY_INTERN_FINDALLBYID = "SELECT ain.id_Tutor , aip.id_Company, i.id_Internship , i.dateStart_Internship,i.dateEnd_Internship,i.missionDescription_Internship,i.comment_Internship,i.techGrade_Internship,i.comGrade_Internship,i.specification_Internship,i.visitSheet_Internship,i.evalEntrSheet_Internship,i.webSurvey_Internship,i.report_Internship,i.defense_Internship,i.visitPlanified_Internship,i.visitDone_Internship,tu.login_Tutor,tu.password_Tutor,tu.firstname_Tutor,tu.lastname_Tutor\n"
                + "FROM assignedinternship aip, assignedintern ain, internship i, tutor tu\n"
                + "WHERE ain.id_intern = aip.id_intern\n"
                + "AND aip.id_Internship = i.id_Internship\n"
                + "AND tu.id_Tutor = ain.id_Tutor\n"
                + "AND i.id_Internship = ? ";

    /**
     *
     */
    public static final String INTERN_ID = "id_Intern";

    /**
     *
     */
    public static final String INTERN_LINKEDIN = "linkedin_Intern";

    /**
     *
     */
    public static final String INTERN_LASTNAME = "lastname_Intern";

    /**
     *
     */
    public static final String INTERN_FIRSTNAME = "firstname_Intern";

    /**
     *
     */
    public static final String INTERN_GROUP = "group_Intern";
        
        /*InternshipDAO*/

    /**
     *
     */

        public static final String QUERY_INTERNSHIP_FINDBYID = "SELECT * FROM internship where id_Internship = ?;";

    /**
     *
     */
    public static final String QUERY_INTERNSHIP_FINDALLBYID = "SELECT aip.id_Intern,aip.id_Company,ain.id_Tutor FROM assignedinternship aip, assignedintern ain WHERE aip.id_intern = ain.id_intern AND aip.id_Internship = ?;";

    /**
     *
     */
    public static final String QUERY_INTERNSHIP_UPDATE = "UPDATE internship SET dateStart_Internship =?, dateEnd_Internship =?, missionDescription_Internship=?, comment_Internship=?, techGrade_Internship=?, comGrade_Internship=?, specification_Internship=?, visitSheet_Internship =?, evalEntrsheet_Internship=?, webSurvey_Internship=?, report_Internship=?, defense_Internship=?, visitPlanified_Internship=?, visitDone_Internship=? WHERE id_Internship = ?;";

    /**
     *
     */
    public static final String INTERNSHIP_ID = "id_Internship";

    /**
     *
     */
    public static final String INTERNSHIP_DATESTART = "dateStart_Internship";

    /**
     *
     */
    public static final String INTERNSHIP_DATEEND = "dateEnd_Internship";

    /**
     *
     */
    public static final String INTERNSHIP_MISSIONDESCRIPTION = "missionDescription_Internship";

    /**
     *
     */
    public static final String INTERNSHIP_COMMENT = "comment_Internship";

    /**
     *
     */
    public static final String INTERNSHIP_TECHGRADE = "techGrade_Internship";

    /**
     *
     */
    public static final String INTERNSHIP_COMGRADE = "comGrade_Internship";

    /**
     *
     */
    public static final String INTERNSHIP_SPECIFICATION = "specification_Internship";

    /**
     *
     */
    public static final String INTERNSHIP_VISITSHEET = "visitSheet_Internship";

    /**
     *
     */
    public static final String INTERNSHIP_EVALENTRESHEET = "evalEntrSheet_Internship";

    /**
     *
     */
    public static final String INTERNSHIP_WEBSURVEY = "webSurvey_Internship";

    /**
     *
     */
    public static final String INTERNSHIP_REPORT = "report_Internship";

    /**
     *
     */
    public static final String INTERNSHIP_DEFENSE = "defense_Internship";

    /**
     *
     */
    public static final String INTERNSHIP_VISITPLANIFIED = "visitPlanified_Internship";
 
    /**
     *
     */
    public static final String INTERNSHIP_VISITDONE = "visitDone_Internship"; 
        
        
        
        
}
