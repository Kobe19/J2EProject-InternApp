<%-- 
    Document   : homePage
    Created on : 14-Nov-2020, 22:58:14
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
