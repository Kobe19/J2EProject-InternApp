<%-- 
    Document   : InternDetail
    Created on : 24-Nov-2020, 10:09:41
    Author     : trist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Models.Tutor" %>
<%@page import="Models.Intern" %>
<%@page import="Models.Internship" %>

<jsp:useBean id="user" scope="session" class="Models.Tutor" />
<jsp:useBean id="intern" scope="session" class="Models.Intern" />
<jsp:useBean id="internship" scope="session" class="Models.Internship" />
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
              integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

        <!-- FontAwesome -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
              integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

        <!-- Custom CSS -->
        <link rel="stylesheet" type="text/css" href="CSS/default.css">
        <title>Home</title>
    </head>

    <body>

        <!-- [NAVBAR] -->
        <nav class="navbar navbar-expand-lg">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img src="Images/logo.png" height="50" class="d-inline-block align-top" alt="">
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="text-white"><i class="fa fa-bars fa-2x"></i></span>
                </button>
                <div class="collapse navbar-collapse text-center" id="navbarSupportedContent">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active pr-5">
                            <a class="nav-link" href="Interns"><i class="fa fa-users"></i>&nbsp; Interns list</a>
                        </li>
                        <li class="nav-item active pr-5">
                            <a class="nav-link" href="#mdo"><i class="fa fa-user"></i>&nbsp; <jsp:getProperty name="user" property="lastname" />, <jsp:getProperty name="user" property="firstname" /></a>
                        </li>
                        <li class="nav-item pr-5">
                            <a class="nav-link" data-toggle="modal" data-target="#modalLogOut"><i
                                    class="fa fa-power-off"></i>&nbsp; Log Out</a>
                        </li>
                    </ul>
                </div>

            </div>
        </nav>
        <!-- [MODAL-LOGOUT] -->
        <div class="modal fade" id="modalLogOut" tabindex="-1" role="dialog" aria-labelledby="modalLogOutTitle"
             aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered " role="document">
                <div class="modal-content ">
                    <div class="modal-header">
                        <h5 class="modal-title">Logging out</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p>You are going to log out, are you sure ?</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Back</button>
                        <form action="LogOut" method="POST">
                            <input type="submit" class="btn btn-primary" name="btn_Send" value ="Log out"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- CONTENT -->
        <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12">
                    <form action ="UpdateIntern" method="POST">
                        <div class="card text-center m-5 ">
                            <div class="card-header">
                                <h1 class=" font-weight-bold text-center"><jsp:getProperty name="intern" property="lastname" /> <jsp:getProperty name="intern" property="firstname" /></h1>
                            </div>
                            <div class="card-body">
                                <div class="panel panel-primary">
                                    <div class="panel-heading">
                                    </div>
                                    <div class="panel-body">
                                        <div class="card text-center">
                                            <div class="card-header">
                                                <h4 class=" font-weight-bold text-center"><span class="titleContent">Intern
                                                        infos</span></h4>
                                            </div>
                                            <div class="card-body">
                                                <div class="table-responsive">
                                                    <table class="table table-hover table-bordered">
                                                        <thead class="thead-light">
                                                            <tr>
                                                                <th scope="col" class="text-center">Group</th>
                                                                <th scope="col">Visit Sheet</th>
                                                                <th scope="col">Eval sheet</th>
                                                                <th scope="col">Web Survey</th>
                                                                <th scope="col">Report</th>
                                                                <th scope="col">Defense</th>
                                                                <th scope="col">Specification</th>
                                                                <th scope="col">Visit planified</th>
                                                                <th scope="col">Visit done</th>
                                                            </tr>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr class="table-light">
                                                                <td class="text-center"><c:out value="${intern.getGroup().name}" /></td>
                                                                <td>

                                                                    <div class="custom-control custom-checkbox">
                                                                        <c:choose>
                                                                            <c:when test="${internship.isVisitSheet() != false}">
                                                                                <input type="checkbox" class="custom-control-input" id="checkVisitSheet" name="checkVisitSheet" checked>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <input type="checkbox" class="custom-control-input" id="checkVisitSheet" name="checkVisitSheet" >
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                        <label class="custom-control-label"
                                                                               for="checkVisitSheet"></label>
                                                                    </div>
                                                                </td>
                                                                <td>
                                                                    <div class="custom-control custom-checkbox">
                                                                        <c:choose>
                                                                            <c:when test="${internship.isEvalEntSheet() != false}">
                                                                                <input type="checkbox" class="custom-control-input"
                                                                                       id="checkEvalSheet" name="checkEvalSheet" checked>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <input type="checkbox" class="custom-control-input"
                                                                                       id="checkEvalSheet" name="checkEvalSheet" >
                                                                            </c:otherwise>
                                                                        </c:choose>                                            
                                                                        <label class="custom-control-label"
                                                                               for="checkEvalSheet"></label>
                                                                    </div>
                                                                </td>
                                                                <td>
                                                                    <div class="custom-control custom-checkbox">
                                                                        <c:choose>
                                                                            <c:when test="${internship.isWebSurvey() != false}">
                                                                                <input type="checkbox" class="custom-control-input"
                                                                                       id="checkWebSurvey" name="checkWebSurvey" checked>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <input type="checkbox" class="custom-control-input"
                                                                                       id="checkWebSurvey" name="checkWebSurvey">
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                        <label class="custom-control-label"
                                                                               for="checkWebSurvey"></label>
                                                                    </div>
                                                                </td>
                                                                <td>                                                                    
                                                                    <div class="custom-control custom-checkbox">
                                                                        <c:choose>
                                                                            <c:when test="${internship.isReport() != false}">
                                                                                <input type="checkbox" class="custom-control-input"
                                                                                       id="checkReport" name="checkReport" checked>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <input type="checkbox" class="custom-control-input"
                                                                                       id="checkReport" name="checkReport" >
                                                                            </c:otherwise>
                                                                        </c:choose>                                                                        
                                                                        <label class="custom-control-label"
                                                                               for="checkReport"></label>
                                                                    </div>
                                                                </td>
                                                                <td>                                                                   
                                                                    <div class="custom-control custom-checkbox">
                                                                        <c:choose>
                                                                            <c:when test="${internship.isDefense() != false}">
                                                                                <input type="checkbox" class="custom-control-input"
                                                                                       id="checkDefense" name="checkDefense" checked>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <input type="checkbox" class="custom-control-input"
                                                                                       id="checkDefense" name="checkDefense" >
                                                                            </c:otherwise>
                                                                        </c:choose>                                                                        
                                                                        <label class="custom-control-label"
                                                                               for="checkDefense"></label>
                                                                    </div>
                                                                </td>
                                                                <td>                                                                    
                                                                    <div class="custom-control custom-checkbox">
                                                                        <c:choose>
                                                                            <c:when test="${internship.isSpecification() != false}">
                                                                                <input type="checkbox" class="custom-control-input"
                                                                                       id="checkSpecification" name="checkSpecification" checked>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <input type="checkbox" class="custom-control-input"
                                                                                       id="checkSpecification" name="checkSpecification">
                                                                            </c:otherwise>
                                                                        </c:choose>                                                                        
                                                                        <label class="custom-control-label"
                                                                               for="checkSpecification"></label>
                                                                    </div>
                                                                </td>
                                                                <td>                                                                    
                                                                    <div class="custom-control custom-checkbox">
                                                                        <c:choose>
                                                                            <c:when test="${internship.isVisitPlanified() != false}">
                                                                                <input type="checkbox" class="custom-control-input"
                                                                                       id="checkVisitPlanified" name="checkVisitPlanified" checked>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <input type="checkbox" class="custom-control-input"
                                                                                       id="checkVisitPlanified" name="checkVisitPlanified" >
                                                                            </c:otherwise>
                                                                        </c:choose>                                                                        
                                                                        <label class="custom-control-label"
                                                                               for="checkVisitPlanified"></label>
                                                                    </div>
                                                                </td>
                                                                <td>                                                                    
                                                                    <div class="custom-control custom-checkbox">
                                                                        <c:choose>
                                                                            <c:when test="${internship.isVisitDone() != false}">
                                                                                <input type="checkbox" class="custom-control-input"
                                                                                       id="checkVisitDone" name="checkVisitDone" checked>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <input type="checkbox" class="custom-control-input"
                                                                                       id="checkVisitDone" name="checkVisitDone" >
                                                                            </c:otherwise>
                                                                        </c:choose>                                                                        
                                                                        <label class="custom-control-label"
                                                                               for="checkVisitDone"></label>
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div class="form-row">
                                                    <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6">
                                                        <label for="missionDescription">Mission description</label>
                                                        <textarea class="form-control" id="missionDescription" name ="missionDescription" rows="3"><c:out value="${internship.getMissionDesc()}" /></textarea>
                                                    </div>
                                                    <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6">
                                                        <label for="comments">Comments</label>
                                                        <textarea class="form-control" id="comments" name ="comments" rows="3"><c:out value="${internship.getComment()}" /></textarea>
                                                    </div>
                                                </div>
                                                   <div class="form-row mt-2">
                                                    <div class="col-sm-12 col-md-12 col-lg-2 col-xl-2">
                                                        <label for="communicationGrade">Communication grade</label>
                                                        <input type="number" class="form-control" id="CommunicationGrade" min="0" max="20" name="InputCommunicationGrade"
                                                               value="<c:out value="${internship.getComGrade()}" />">
                                                    </div>
                                                    <div class="col-sm-12 col-md-12 col-lg- col-xl-2">
                                                        <label for="technicalGrade">Technical grade</label>
                                                        <input type="number" class="form-control" id="technicalGrade" min="0" max="20" name="InputTechnicalGrade"
                                                               value="<c:out value="${internship.getTechGrade()}" />">
                                                    </div>
                                                </div> 
                                            </div>
                                            <div class="card-footer text-muted">
                                            </div>

                                        </div>


                                        <div class="card text-center mt-5">
                                            <div class="card-header">
                                                <h4 class=" font-weight-bold text-center"><span class="titleContent">Company
                                                        infos</span></h4>
                                            </div>
                                            <div class="card-body text-left">
                                                <div class="form-group w-25">
                                                    <label for="InputCompanyName">Company Name</label>
                                                    <input type="text" class="form-control" id="InputCompanyName" name="InputCompanyName"
                                                           aria-describedby="emailHelp" value="<c:out value="${internship.getCompany().getName()}" />">
                                                </div>
                                                <div class="form-group w-25">
                                                    <label for="InputCompanyAddress">Company address</label>
                                                    <input type="text" class="form-control" id="InputCompanyAddress" name="InputCompanyAddress"
                                                           aria-describedby="emailHelp" value="<c:out value="${internship.getCompany().getAddress()}" />">
                                                </div>
                                                <div class="form-group w-25">
                                                    <label for="InputCompanySupervisor">Supervisor</label>
                                                    <input type="text" class="form-control" id="InputCompanySupervisor" name="InputCompanySupervisor"
                                                           aria-describedby="emailHelp" value="<c:out value="${internship.getCompany().getSupervisor()}" />">
                                                </div>
                                            </div>
                                        </div>

                                        <div class="col text-center mt-3">
                                            <input type="submit" class="btn btn-primary" name="btn_Send" value ="Update"/>
                                            <input type="hidden" name="idInternship" value="<c:out value="${internship.getId()}" />">
                                            <input type="hidden" name="idIntern" value="<c:out value="${intern.getId()}" />">
                                            <input type="hidden" name="idCompany" value="<c:out value="${internship.getCompany().getId()}" />">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="card-footer">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- jQuery and Bootstrap -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
                integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>

        <!-- Custom JS -->
        <script src="JS/default.js"></script>

    </body>
</html>
