<%--
  Created by IntelliJ IDEA.
  User: faruk
  Date: 25.04.2019
  Time: 00:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Start your development with a Design System for Bootstrap 4.">
    <meta name="author" content="Creative Tim">
    <title>
        <spring:message code="profilePageTitle"></spring:message>
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
            <a class="navbar-brand mr-lg-5" href="/organization">
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
                <ul class="navbar-nav align-items-lg-center ml-lg-auto">
                    <c:if test="${empty organization}">
                        <li class="nav-item d-none d-lg-block ">
                            <a href="/organization/search" class="btn btn-neutral btn-icon">
                            <span class="btn-inner--icon">
                                    <i class="fas fa-search"></i>
                                </span>
                                <span class="nav-link-inner--text"><spring:message code="organizationSearchButtonHeader"></spring:message></span>
                            </a>
                        </li>
                    </c:if>

                    <c:if test="${empty user and not empty organization}">

                        <li class="nav-item d-none d-lg-block">
                            <a href="/organization/update/${organizationInformation.id}"

                               class="btn btn-success btn-icon">
                            <span class="btn-inner--icon">
                                    <i class="fas fa-user"></i>
                                </span>
                                <span class="nav-link-inner--text"><spring:message code="editProfileButton"></spring:message></span>
                            </a>
                        </li>

                    </c:if>

                    <c:if test="${not empty user or not empty organization}">

                        <li class="nav-item d-none d-lg-block ml-lg-4">
                            <a href=
                                       "<c:if test="${not empty user}">/user/profile</c:if>
                                        <c:if test="${not empty organization}">/organization/profile</c:if>   "

                               class="btn btn-neutral btn-icon">
                            <span class="btn-inner--icon">
                                    <i class="fas fa-user"></i>
                                </span>
                                <span class="nav-link-inner--text"><spring:message code="myAccount"></spring:message></span>
                            </a>
                        </li>

                        <li class="nav-item d-none d-lg-block">
                            <a href="/logout" class="btn btn-default btn-icon">
                            <span class="btn-inner--icon">
                                    <i class="fas fa-sign-out-alt"></i>
                                </span>
                                <span class="nav-link-inner--text"><spring:message code="logout"></spring:message></span>
                            </a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
</header>

<main class="profile-page">
    <section class="section-profile-cover section-shaped my-0">
        <!-- Circles background -->
        <div class="shape shape-style-1 shape-primary alpha-4">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
        </div>
    </section>
    <section class="section">
        <div class="container">
            <div class="card card-profile shadow mt--300">
                <div class="px-4">
                    <div class="row mt-5">

                        <div class="col-12 col-md-4">
                            <div class="card">
                                <div class="text-center mt-2">
                                    <figure>
                                        <img src="/org-images/${organizationInformation.username}/logo.png"
                                             alt="" class="your_picture_image" width="200px" height="200px">
                                    </figure>
                                </div>
                            </div>

                        </div>

                        <div class="col-12 col-md-8">
                            <div class="row">
                                <div class="col-12 col-md-12 text-center">
                                    <h2 class="d-inline">${organizationInformation.name}</h2>
                                    <a class="btn btn-info btn-sm ml-2 mb-3"
                                       href="/tag/${organizationInformation.category.name}">${organizationInformation.category.name}</a>
                                    <p class="font-weight-300 ml-2"><i>( @${organizationInformation.username} )</i></p>
                                </div>

                                <div class="col-12 col-md-12">
                                    <i class="fas fa-user-tie"></i>
                                    <b><spring:message code="profileAuthorizedPerson"></spring:message> </b> ${organizationInformation.authorizedPerson}
                                </div>

                                <div class="col-12 col-md-6">
                                    <i class="fas fa-phone"></i>
                                    <b><spring:message code="profileOrganizationPhone1"></spring:message> </b> ${organizationInformation.contact.phoneNumber1}
                                </div>

                                <c:if test="${not empty organizationInformation.contact.phoneNumber2}">
                                    <div class="col-12 col-md-6">
                                        <i class="fas fa-phone"></i>
                                        <b><spring:message code="profileOrganizationPhone2"></spring:message> </b> ${organizationInformation.contact.phoneNumber2}
                                    </div>
                                </c:if>

                                <div class="col-12 col-md-12">
                                    <i class="fas fa-map-marked-alt"></i> <b><spring:message code="profileOrganizationAddress"></spring:message> </b>
                                    ${organizationInformation.addressDescription}, ${organizationInformation.district}, ${organizationInformation.city}, ${organizationInformation.country}
                                </div>

                                <div class="col-12 col-md-12">
                                    <i class="far fa-envelope"></i>
                                    <b><spring:message code="profileEmail"></spring:message> </b> ${organizationInformation.email}
                                </div>

                                <div class="col-12 col-md-12">
                                    <i class="fas fa-globe"></i>
                                    <b><spring:message code="profileWeb"></spring:message> </b> <a
                                        href="${organizationInformation.contact.websiteLink}"
                                        target="_blank">${organizationInformation.contact.websiteLink}</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12 col-md-4">

                            <div class="text-center">

                                <a target="_blank"
                                   href="https://fb.com/${organizationInformation.contact.facebookUsername}"
                                   class="btn btn-neutral btn-icon-only btn-facebook btn-round btn-lg">
                                    <i class="fab fa-facebook-f"></i>
                                </a>

                                <a target="_blank"
                                   href="https://twitter.com/${organizationInformation.contact.twitterUsername}"
                                   class="btn btn-neutral btn-icon-only btn-twitter btn-round btn-lg">
                                    <i class="fab fa-twitter"></i>
                                </a>

                                <a target="_blank"
                                   href="https://instagram.com/${organizationInformation.contact.instagramUsername}"
                                   class="btn btn-neutral btn-icon-only btn-instagram btn-lg btn-round">
                                    <i class="fab fa-instagram"></i>
                                </a>
                                <a target="_blank"
                                   href="https://youtube.com/${organizationInformation.contact.youtubeUsername}"
                                   class="btn btn-neutral btn-icon-only btn-youtube btn-round btn-lg">
                                    <i class="fab fa-youtube"></i>
                                </a>

                            </div>

                        </div>
                    </div>

                    <div class="mt-5 py-3 border-top text-center">

                        <div class="row justify-content-center">
                            <div class="col-lg-9">
                                <p class="display-4"><spring:message code="aboutOrganization"></spring:message></p>
                                <p>${organizationInformation.about}</p>
                            </div>
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
<script src="/assets/vendor/jquery/jquery.steps.min.js"></script>
<script src="/assets/vendor/popper/popper.min.js"></script>
<script src="/assets/vendor/bootstrap/bootstrap.min.js"></script>
<!-- Argon JS -->
<script src="/assets/js/argon.js?v=1.0.1"></script>
<script src="/assets/js/index.js"></script>

</body>

</html>