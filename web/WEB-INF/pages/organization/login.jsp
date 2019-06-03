<%--
  Created by IntelliJ IDEA.
  User: faruk
  Date: 25.04.2019
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Start your development with a Design System for Bootstrap 4.">
    <meta name="author" content="Creative Tim">
    <title>
        <spring:message code="loginPageTitle"></spring:message>
    </title>
    <!-- Favicon -->
    <link href="/assets/img/brand/favicon.png" rel="icon" type="image/png">
    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
    <!-- Icons -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <!-- Argon CSS -->
    <link type="text/css" href="/assets/css/argon.css?v=1.0.1" rel="stylesheet">
    <link type="text/css" href="/assets/css/style.css" rel="stylesheet">
</head>

<body>
<header class="header-global">
    <nav id="navbar-main" class="navbar navbar-main navbar-expand-lg navbar-transparent navbar-light">
        <div class="container">
            <a class="navbar-brand mr-lg-5" href="/index.html">
                <img src="/assets/img/brand/white.png">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar_global"
                    aria-controls="navbar_global" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="navbar-collapse collapse" id="navbar_global">
                <div class="navbar-collapse-header">
                    <div class="row">
                        <div class="col-6 collapse-brand">
                            <a href="/index.html">
                                <img src="/assets/img/brand/blue.png">
                            </a>
                        </div>
                        <div class="col-6 collapse-close">
                            <button type="button" class="navbar-toggler" data-toggle="collapse"
                                    data-target="#navbar_global" aria-controls="navbar_global" aria-expanded="false"
                                    aria-label="Toggle navigation">
                                <span></span>
                                <span></span>
                            </button>
                        </div>
                    </div>
                </div>
                <ul class="navbar-nav navbar-nav-hover align-items-lg-center mr-5">

                    <li class="nav-item">
                        <a class="nav-link" href="<spring:message code="aboutPage"></spring:message>">
                            <span class="nav-link-inner--text"><spring:message code="about"></spring:message></span>
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="<spring:message code="contactPage"></spring:message>">
                            <span class="nav-link-inner--text"><spring:message code="contact"></spring:message></span>
                        </a>
                    </li>

                </ul>
                <ul class="navbar-nav align-items-lg-center">
                    <li class="nav-item">
                        <a class="nav-link nav-link-icon" href=" <spring:message code="facebookLink"></spring:message> "
                           target="_blank" title="Like us on Facebook">
                            <i class="fab fa-facebook-square"></i>
                            <span class="nav-link-inner--text d-lg-none">Facebook</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-link-icon" href="<spring:message code="instagramLink"></spring:message>"
                           target="_blank" title="Follow us on Instagram">
                            <i class="fab fa-instagram"></i>
                            <span class="nav-link-inner--text d-lg-none">Instagram</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-link-icon" href="<spring:message code="twitterLink"></spring:message>"
                           target="_blank" title="Follow us on Twitter">
                            <i class="fab fa-twitter-square"></i>
                            <span class="nav-link-inner--text d-lg-none">Twitter</span>
                        </a>
                    </li>
                    <li class="nav-item nav-link-icon d-lg-block">
                        <a href="/user/login" class="btn btn-info btn-icon mb-3 mb-sm-0">
                            <span class="btn-inner--icon"><i class="fas fa-arrow-right"></i></span>
                            <span class="btn-inner--text"><spring:message code="userLogin"></spring:message> </span>
                        </a>
                    </li>

                    <li class="nav-item nav-link-icon d-lg-block">
                        <a href="/organization/login" class="btn btn-success btn-icon mb-3 mb-sm-0">
                            <span class="btn-inner--icon"><i class="fas fa-arrow-right"></i></span>
                            <span class="btn-inner--text"><spring:message
                                    code="organizationLogin"></spring:message> </span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<main>
    <section class="section section-shaped section-lg">
        <div class="shape shape-style-1 bg-gradient-default">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
        </div>
        <div class="container pt-lg-md">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="card bg-secondary shadow border-0">
                        <div class="card-body px-lg-6 py-lg-6">
                            <div class="text-center text-muted mb-4">
                                <h5> <spring:message code="organizationLoginLeadText"></spring:message> </h5>
                                <c:if test="${not empty errorLogin}">
                                    <h6 class="text-danger"> ${errorLogin} </h6>
                                </c:if>
                            </div>
                            <form:form modelAttribute="organization" method="post">
                                <div class="form-group mb-3">
                                    <div class="input-group input-group-alternative">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"><i class="fas fa-user-circle"></i></span>
                                        </div>
                                        <spring:message code="username" var="username"></spring:message>
                                <form:input path="username" cssClass="form-control" placeholder='${username}' type="text"></form:input>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="input-group input-group-alternative">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text"><i class="fas fa-unlock-alt"></i></span>
                                        </div>
                                        <spring:message code="password" var="password"></spring:message>
                                <form:password path="password" cssClass="form-control" placeholder='${password}'></form:password>
                                </div>
                                </div>
                                <div class="text-center">
                                    <button type="submit" class="btn btn-primary my-4"><spring:message code="login"></spring:message> </button>
                                </div>
                            </form:form>
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-6">
                            <a href="#" class="text-light">
                                <small><spring:message code="forgetPassword"></spring:message> </small>
                            </a>
                        </div>
                        <div class="col-6 text-right">
                            <a href="/organization/register" class="text-light">
                                <small><spring:message code="createNewAccount"></spring:message> </small>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
<footer class="footer">
    <div class="container">
        <div class="row row-grid align-items-center my-md">
            <div class="col-lg-8">
                <h3 class="text-primary font-weight-light mb-2"><spring:message code="footerSupportingMessage"></spring:message> </h3>
                <h4 class="mb-0 font-weight-light"><spring:message code="footerTouchMessage"></spring:message> </h4>
            </div>
            <div class="col-lg-4 text-lg-center btn-wrapper">
                <a target="_blank" href="<spring:message code="facebookLink"></spring:message>"
                   class="btn btn-neutral btn-icon-only btn-facebook btn-round btn-lg">
                    <i class="fab fa-facebook-f"></i>
                </a>
                <a target="_blank" href="<spring:message code="twitterLink"></spring:message>"
                   class="btn btn-neutral btn-icon-only btn-twitter btn-round btn-lg">
                    <i class="fab fa-twitter"></i>
                </a>
                <a target="_blank" href="<spring:message code="instagramLink"></spring:message>"
                   class="btn btn-neutral btn-icon-only btn-instagram btn-lg btn-round">
                    <i class="fab fa-instagram"></i>
                </a>
            </div>
        </div>
        <hr>
        <div class="row align-items-center justify-content-md-between">
            <div class="col-md-6">
                <div class="copyright">
                    <a href="#"><spring:message code="footerCopyright"></spring:message> </a>

                    <a href="?language=tr" >
                        <img src="/assets/img/flags/TR.png" />
                    </a>
                    |
                    <a href="?language=en">
                        <img src="/assets/img/flags/EN.png" />
                    </a>
                </div>
            </div>
            <div class="col-md-6">
                <ul class="nav nav-footer justify-content-end">
                    <li class="nav-item">
                        <a href="#" class="nav-link"><spring:message code="homeTitle"></spring:message> </a>
                    </li>
                    <li class="nav-item">
                        <a href="<spring:message code="aboutPage"></spring:message>" class="nav-link"><spring:message
                                code="about"></spring:message> </a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link"><spring:message code="blog"></spring:message> </a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link"><spring:message code="userAgreement"></spring:message> </a>
                    </li>
                    <li class="nav-item">
                        <a href="<spring:message code="contactPage"></spring:message>" class="nav-link"><spring:message code="contact"></spring:message> </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</footer>
<!-- Core -->
<script src="/assets/vendor/jquery/jquery.min.js"></script>
<script src="/assets/vendor/popper/popper.min.js"></script>
<script src="/assets/vendor/bootstrap/bootstrap.min.js"></script>
<!-- Argon JS -->
<script src="/assets/js/argon.js?v=1.0.1"></script>
</body>

</html>
