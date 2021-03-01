<%-- 
    Document   : InterList
    Created on : 24-Nov-2020, 10:07:59
    Author     : trist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Models.Tutor" %>

<jsp:useBean id="user" scope="session" class="Models.Tutor" />


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
        <title>Intern list</title>
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
                    <div class="card text-center m-5 ">
                        <div class="card-header">
                            <h1 class=" font-weight-bold text-center"><span class="titleContent">Interns</span></h1>
                        </div>
                        <div class="card-body">
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-hover table-bordered">
                                            <c:choose>
                                                <c:when test="${user.interns.size() > 0}">
                                                    <!-- INTERN  -->
                                                    <thead class="thead-light">
                                                        <tr>
                                                            <th scope="col" class="text-center">Date</th>
                                                            <th scope="col" class="text-center">Group</th>
                                                            <th scope="col" class="text-center">Last name</th>
                                                            <th scope="col" class="text-center">First name</th>
                                                            <th scope="col" class="text-center">LinkedIn</th>
                                                            <th scope="col" class="text-center">Detail</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <c:forEach var="intern" items="${user.interns}">
                                                            <c:choose>
                                                                <c:when test="${intern.getInternships().size() > 0}">
                                                                    <!-- INTERN HAVE INTERNSHIPS -->
                                                                    <!-- display stage avec date -->
                                                                    <c:forEach var="internship" items="${intern.getInternships()}">
                                                                        <tr class="table-light">
                                                                            <td class="text-center">START&nbsp;:&nbsp;<c:out value="${internship.getDateStart()}" />&nbsp;-&nbsp;END&nbsp;:&nbsp;<c:out value="${internship.getDateEnd()}" /></td>
                                                                            <td class="text-center"><c:out value="${intern.getGroup().getName()}" /></td>
                                                                            <td class="text-center"><c:out value="${intern.getLastname()}" /></td>
                                                                            <td class="text-center"><c:out value="${intern.getFirstname()}" /></td>
                                                                            <td>
                                                                                <a href="<c:out value="${intern.getLinkedin()}" />" class="text-dark"><i class="fa fa-linkedin fa-2x"></i></a>
                                                                            </td>
                                                                            <td>
                                                                                <!-- FORM Detail INTERN -->
                                                                                <form action="InternDetail" method="POST">
                                                                                    <input type="hidden" name="idInternship" value="<c:out value="${internship.getId()}" />">
                                                                                    <input type="hidden" name="idIntern" value="<c:out value="${intern.getId()}" />">
                                                                                    <input type="submit" class="btn btn-secondary" name="btn_Send" value ="Detail"/>
                                                                                </form>
                                                                            </td>
                                                                        </tr>
                                                                    </c:forEach> 
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <!-- INTERN HAVE NOT INTERNSHIP -->
                                                                    <!-- display intern  -->
                                                                    <tr class="table-light">
                                                                        <td class="text-center">UNKNOW</td>
                                                                        <td class="text-center"><c:out value="${intern.getGroup().getName()}" /></td>
                                                                        <td class="text-center"><c:out value="${intern.getLastname()}" /></td>
                                                                        <td class="text-center"><c:out value="${intern.getFirstname()}" /></td>
                                                                        <td>
                                                                            <a href="<c:out value="${intern.getLinkedin()}" />" class="text-dark"><i class="fa fa-linkedin fa-2x"></i></a>
                                                                        </td>
                                                                        <td>
                                                                            <!-- FORM Detail INTERN -->
                                                                            <form action="InternDetail" method="POST">
                                                                                <input type="hidden" name="idInternship" value="0">
                                                                                <input type="hidden" name="idIntern" value="<c:out value="${intern.getId()}" />">
                                                                                <input type="submit" class="btn btn-secondary" name="btn_Send" value ="Detail"/>
                                                                            </form>
                                                                        </td>
                                                                    </tr>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:forEach> 
                                                    </tbody>                               
                                                </c:when>
                                                <c:otherwise>
                                                    <!-- WARNING NO INTERN  -->
                                                    <div class="alert alert-warning alert-dismissible fade show" role="alert">
                                                        <strong>Information : </strong> You don't have interns yet.
                                                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                </c:otherwise>
                                            </c:choose>
                                        </table>
                                    </div>
                                    <!-- Don't need it currently 
                                    <div class="col text-center">
                                        <button type="button" class="btn btn-primary">Add intern</button>
                                    </div>-->
                                </div>
                            </div>
                        </div>
                        <div class="card-footer text-muted">
                        </div>
                    </div>
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
        <script type="text/javascript" src="JS/default.js" />

    </body>
</html>
