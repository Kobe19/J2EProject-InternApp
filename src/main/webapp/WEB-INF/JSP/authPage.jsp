<%-- 
    Document   : authPage
    Created on : 18-Nov-2020, 17:00:54
    Author     : trist
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Index</title>
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
                        <li class="nav-item pr-5">
                            <a class="nav-link" data-toggle="modal" data-target="#modalConnexion"><i
                                    class="fa fa-sign-in"></i>&nbsp; Log In</a>
                        </li>
                    </ul>
                </div>

            </div>
        </nav>

        <!-- [MODAL-CONNEXION] -->
        <div class="modal fade" id="modalConnexion" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered " role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Logging in</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true"><i class="fa fa-times text-white" aria-hidden="true"></i></span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="Auth" method="POST">
                            <div class="form-group">
                                <!-- USERNAME -->
                                <label for="connexionInputUsername"><i class="fa fa-user"></i>&nbsp; Username :</label>
                                <c:choose>
                                    <c:when test="${requestScope.statusLogin != null}">
                                        <input type="text" class="form-control is-invalid" id="connexionInputUsername" placeholder="Username" name="loginForm"
                                               required>
                                    </c:when>
                                    <c:otherwise>
                                        <input type="text" class="form-control" id="connexionInputUsername" placeholder="Username" name="loginForm"
                                               required>
                                    </c:otherwise>
                                </c:choose>
                                <!-- PASSWORD -->
                                <label for="connexionInputPassword" class="mt-2"><i class="fa fa-lock"></i>&nbsp; Password :</label>
                                <div class="input-group mb-3">
                                    <c:choose>
                                        <c:when test="${requestScope.statusPassword != null}">
                                            <input type="password" class="form-control is-invalid" id="connexionInputPassword"
                                                   placeholder="Password" name="passForm" required>
                                        </c:when>
                                        <c:otherwise>
                                            <input type="password" class="form-control" id="connexionInputPassword"
                                                   placeholder="Password" name="passForm" required>
                                        </c:otherwise>
                                    </c:choose>
                                    <div class="input-group-append">
                                        <button class="btn btn-outline-secondary" type="button"
                                                id="button-addon2"><i class="fa fa-eye"></i></button>
                                    </div>
                                </div>
                            </div>
                            <!-- ALERT BOX -->
                            <c:choose>
                                <c:when test="${requestScope.statusPassword != null or requestScope.statusLogin != null or requestScope.status != null }">
                                    <div id="alert_connexion" class="alert alert-danger fade show" role="alert">
                                        <p id="alert_connexion_message" class="text-center">
                                            <c:out value="${requestScope.statusPassword}" />
                                            <c:out value="${requestScope.statusLogin}" />
                                            <c:out value="${requestScope.status}" />
                                        </p>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <div id="alert_connexion" class="alert alert-primary fade show" role="alert">
                                        <p id="alert_connexion_message" class="text-center">
                                            Please fill the fields above.
                                        </p>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                            <input type="submit" class="btn btn-primary float-right" id="btn_logIn" value="Log In">
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