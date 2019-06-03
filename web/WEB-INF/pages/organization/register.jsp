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
        <spring:message code="organizationRegisterPageTitle"></spring:message>
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
    <div class="position-relative">
        <section class="section section-lg section-shaped pb-300">

            <div class="shape shape-style-1 shape-default">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
                <span></span>
            </div>
            <div class="container">
                <div class="card bg-gradient-white shadow-lg border-0 mt-5">
                    <!-- Dıştaki kart-->
                    <div class="card">
                        <div class="card-body">
                            <!-- içerideki kart -->

                            <div class="card">
                                <div class="card-body">

                                    <form:form id="regForm" modelAttribute="registerOrganization" method="post"
                                               enctype="multipart/form-data">

                                        <!-- ******* Step 1 Başlangıcı ******* -->
                                        <div>

                                            <div class="row">
                                                <div class="col-12 col-md-12">
                                                    <h1 class="text-center mb-4 display-4">
                                                        <i class="fa fa-user mr-2"></i>
                                                    <spring:message code="organizationInformation"></spring:message>
                                                    </h1>
                                                </div>
                                            </div>


                                            <div class="form-row">
                                                <div class="form-group col-12 col-md-4">

                                                    <div class="card">
                                                        <div class="card-body text-center">
                                                            <div class="form-file">
                                                                <input type="file" class="inputfile"
                                                                       name="your_picture" id="your_picture"
                                                                       onchange="readURL(this);"
                                                                       data-multiple-caption="{count} dosya seçildi"
                                                                       multiple/>
                                                                <label for="your_picture">
                                                                    <figure>
                                                                        <img src="/assets/img/icons/common/cloud-upload.svg"
                                                                             alt="" class="your_picture_image">
                                                                    </figure>
                                                                    <span class="file-button">
                                                                        <spring:message code="uploadLogo"></spring:message>
                                                                    </span>
                                                                </label>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </div>

                                                <div class="form-group col-12 col-md-8">

                                                    <div class="form-row">
                                                        <div class="form-group col-12 col-md-6 text-center">
                                                            <div class="input-group">
                                                                <div class="input-group-prepend">
                                                                        <span class="input-group-text"><i
                                                                                class="far fa-address-card"></i></span>
                                                                </div>
                                                                <spring:message code="organizationName" var="organizationName"></spring:message>
                                                                <spring:message code="organizationNameTitle" var="organizationNameTitle"></spring:message>
                                                                <form:input type="text" path="name"
                                                                            placeholder='${organizationName}'
                                                                            class="form-control"
                                                                            title='${organizationNameTitle}'/>
                                                            </div>
                                                            <form:errors path="name" cssClass="text-danger"></form:errors>
                                                        </div>

                                                        <div class="form-group col-12 col-md-6 text-center">
                                                            <div class="input-group">
                                                                <div class="input-group-prepend">
                                                                        <span class="input-group-text"><i
                                                                                class="far fa-envelope"></i></span>
                                                                </div>
                                                                <spring:message code="organizationEmail" var="organizationEmail"></spring:message>
                                                                <spring:message code="organizationEmailTitle" var="organizationEmailTitle"></spring:message>
                                                                <form:input type="email" placeholder='${organizationEmail}'
                                                                            path="email"
                                                                            class="form-control"
                                                                            title='${organizationEmailTitle}'/>
                                                            </div>
                                                            <form:errors path="email" cssClass="text-danger"></form:errors>
                                                        </div>

                                                        <div class="form-group col-12 col-md-6 text-center">
                                                            <div class="input-group">
                                                                <div class="input-group-prepend">
                                                                        <span class="input-group-text"><i
                                                                                class="far fa-user"></i></span>
                                                                </div>
                                                                <spring:message code="organizationUsername" var="organizationUsername"></spring:message>
                                                                <spring:message code="organizationUsernameTitle" var="organizationUsernameTitle"></spring:message>
                                                                <form:input type="text"
                                                                            placeholder='${organizationUsername}'
                                                                            path="username"
                                                                            class="form-control"
                                                                            title='${organizationUsernameTitle}'/>
                                                            </div>
                                                            <form:errors path="username" cssClass="text-danger"></form:errors>
                                                        </div>

                                                        <div class="form-group col-12 col-md-6 text-center">
                                                            <div class="input-group">
                                                                <div class="input-group-prepend">
                                                                        <span class="input-group-text"><i
                                                                                class="fas fa-key"></i></span>
                                                                </div>
                                                                <spring:message code="organizationPassword" var="organizationPassword"></spring:message>
                                                                <spring:message code="organizationPasswordTitle" var="organizationPasswordTitle"></spring:message>
                                                                <form:password placeholder='${organizationPassword}'
                                                                               path="password"
                                                                               class="form-control"
                                                                               title='${organizationPasswordTitle}'/>
                                                            </div>
                                                            <form:errors path="password" cssClass="text-danger"></form:errors>
                                                        </div>


                                                        <div class="form-group col-12 col-md-6 text-center">
                                                            <div class="input-group">
                                                                <div class="input-group-prepend">
                                                                        <span class="input-group-text"><i
                                                                                class="fas fa-user-tie"></i></span>
                                                                </div>
                                                                <spring:message code="organizationAuthorizedPerson" var="organizationAuthorizedPerson"></spring:message>
                                                                <spring:message code="organizationAuthorizedPersonTitle" var="organizationAuthorizedPersonTitle"></spring:message>
                                                                <form:input type="text"
                                                                            placeholder='${organizationAuthorizedPerson}'
                                                                            path="authorizedPerson"
                                                                            class="form-control"
                                                                            title='${organizationAuthorizedPersonTitle}'/>
                                                            </div>
                                                            <form:errors path="authorizedPerson" cssClass="text-danger"></form:errors>
                                                        </div>

                                                        <div class="form-group col-12 col-md-6 text-center">
                                                            <div class="input-group">
                                                                <div class="input-group-prepend">
                                                                                <span class="input-group-text"><i
                                                                                        class="fas fa-tag"></i></span>
                                                                </div>
                                                                <spring:message code="organizationCategory" var="chooseCategory"></spring:message>
                                                                <form:select path="category.name" cssClass="form-control">
                                                                    <form:option value="">${chooseCategory}</form:option>
                                                                    <form:options items="${categoryList}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </div>


                                                        <div class="form-group col-12 col-md-6">
                                                            <div class="input-group">
                                                                <div class="input-group-prepend">
                                                                    <span class="input-group-text"><i
                                                                            class="fab fa-facebook-f"></i></span>
                                                                </div>
                                                                <spring:message code="organizationFacebookUsername" var="organizationFacebookUsername"></spring:message>
                                                                <form:input type="text"
                                                                            placeholder='${organizationFacebookUsername}'
                                                                            path="contact.facebookUsername"
                                                                            class="form-control"
                                                                            title='${organizationFacebookUsername}'/>
                                                            </div>
                                                        </div>

                                                       <div class="form-group col-12 col-md-6">
                                                            <div class="input-group">
                                                                <div class="input-group-prepend">
                                                                    <span class="input-group-text"><i
                                                                            class="fab fa-twitter"></i></span>
                                                                </div>
                                                                <spring:message code="organizationTwitterUsername" var="organizationTwitterUsername"></spring:message>
                                                                <form:input type="text"
                                                                            placeholder='${organizationTwitterUsername}'
                                                                            path="contact.twitterUsername"
                                                                            class="form-control"
                                                                            title='${organizationTwitterUsername}'/>
                                                            </div>
                                                        </div>

                                                        <div class="form-group col-12 col-md-6">
                                                            <div class="input-group">
                                                                <div class="input-group-prepend">
                                                                    <span class="input-group-text"><i
                                                                            class="fab fa-instagram"></i></span>
                                                                </div>
                                                                <spring:message code="organizationInstagramUsername" var="organizationInstagramUsername"></spring:message>
                                                                <form:input type="text"
                                                                            placeholder='${organizationInstagramUsername}'
                                                                            path="contact.instagramUsername"
                                                                            class="form-control"
                                                                            title='${organizationInstagramUsername}'/>
                                                            </div>
                                                        </div>

                                                        <div class="form-group col-12 col-md-6">
                                                            <div class="input-group">
                                                                <div class="input-group-prepend">
                                                                    <span class="input-group-text"><i
                                                                            class="fab fa-youtube"></i></span>
                                                                </div>
                                                                <spring:message code="organizationYoutubeUsername" var="organizationYoutubeUsername"></spring:message>
                                                                <form:input type="text"
                                                                            placeholder='${organizationYoutubeUsername}'
                                                                            path="contact.youtubeUsername"
                                                                            class="form-control"
                                                                            title='${organizationYoutubeUsername}'/>
                                                            </div>
                                                        </div>

                                                        <div class="form-group col-12 col-md-12">
                                                            <div class="input-group">
                                                                <div class="input-group-prepend">
                                                                    <span class="input-group-text"><i
                                                                            class="fas fa-globe"></i></span>
                                                                </div>
                                                                <spring:message code="organizationWebsite" var="organizationWebsite"></spring:message>
                                                                <form:input type="text"
                                                                            placeholder='${organizationWebsite}'
                                                                            path="contact.websiteLink"
                                                                            class="form-control"
                                                                            title='${organizationWebsite}'/>
                                                            </div>
                                                        </div>

                                                        <div class="form-group col-12 col-md-6 text-center">
                                                            <div class="input-group">
                                                                <div class="input-group-prepend">
                                                                        <span class="input-group-text"><i
                                                                                class="fas fa-phone"></i></span>
                                                                </div>
                                                                <spring:message code="organizationPhone1" var="organizationPhone1"></spring:message>
                                                                <form:input type="text"
                                                                            placeholder='${organizationPhone1}'
                                                                            path="contact.phoneNumber1"
                                                                            class="form-control"
                                                                            title='${organizationPhone1}'/>
                                                            </div>
                                                        </div>

                                                        <div class="form-group col-12 col-md-6">
                                                            <div class="input-group">
                                                                <div class="input-group-prepend">
                                                                        <span class="input-group-text"><i
                                                                                class="fas fa-phone"></i></span>
                                                                </div>
                                                                <spring:message code="organizationPhone2" var="organizationPhone2"></spring:message>
                                                                <form:input type="text"
                                                                            placeholder='${organizationPhone2}'
                                                                            path="contact.phoneNumber2"
                                                                            class="form-control"
                                                                            title='${organizationPhone2}'/>
                                                            </div>
                                                        </div>

                                                        <div class="form-group col-12 col-md-12 text-center">
                                                            <div class="input-group">
                                                                <div class="input-group-prepend">
                                                                        <span class="input-group-text"><i
                                                                                class="fas fa-map-marked-alt"></i></span>
                                                                </div>
                                                                <spring:message code="organizationAddressLine" var="organizationAddressLine"></spring:message>
                                                                <spring:message code="organizationAddressLineTitle" var="organizationAddressLineTitle"></spring:message>
                                                                <form:input type="text" placeholder='${organizationAddressLine}'
                                                                            path="addressDescription"
                                                                            class="form-control"
                                                                            title='${organizationAddressLineTitle}'/>
                                                            </div>
                                                            <form:errors path="addressDescription" cssClass="text-danger"></form:errors>
                                                        </div>

                                                        <div class="form-group col-12 col-md-4 text-center">
                                                            <div class="input-group">
                                                                <div class="input-group-prepend">
                                                                                <span class="input-group-text"><i
                                                                                        class="fas fa-globe-europe"></i></span>
                                                                </div>
                                                                <spring:message code="chooseCountry" var="chooseCountry"></spring:message>
                                                                <form:select path="country" cssClass="form-control"
                                                                             id="country">
                                                                    <form:option value='${chooseCountry}'></form:option>
                                                                </form:select>


                                                            </div>
                                                            <form:errors path="country" cssClass="text-danger"></form:errors>
                                                        </div>

                                                        <div class="form-group col-12 col-md-4 text-center">
                                                            <div class="input-group">
                                                                <div class="input-group-prepend">
                                                                                <span class="input-group-text"><i
                                                                                        class="fas fa-city"></i></span>
                                                                </div>
                                                                <spring:message code="chooseCity" var="chooseCity"></spring:message>
                                                                <form:select path="city" cssClass="form-control"
                                                                             id="city" disabled="true">
                                                                    <form:option value='${chooseCity}'></form:option>
                                                                </form:select>
                                                            </div>
                                                            <form:errors path="city" cssClass="text-danger"></form:errors>
                                                        </div>

                                                        <div class="form-group col-12 col-md-4 text-center">
                                                            <div class="input-group">
                                                                <div class="input-group-prepend">
                                                                                <span class="input-group-text"><i
                                                                                        class="fas fa-map-marker-alt"></i></span>
                                                                </div>
                                                                <spring:message code="chooseDistrict" var="chooseDistrict"></spring:message>
                                                                <form:select path="district" cssClass="form-control"
                                                                             id="district" disabled="true">
                                                                    <form:option value='${chooseDistrict}'></form:option>
                                                                </form:select>
                                                            </div>
                                                            <form:errors path="district" cssClass="text-danger"></form:errors>
                                                        </div>

                                                    </div>
                                                </div>

                                            </div>
                                        </div>

                                        <hr>

                                        <div class="row">

                                            <div class="col-12 col-md-12">
                                                <p class="display-4">
                                                    <u> <spring:message code="aboutOrganization"></spring:message> </u>
                                                </p>
                                            </div>

                                            <div class="form-group col-12 col-md-12 text-center">
                                                <div class="form-group input-group">
                                                    <spring:message code="aboutOrganizationTextarea" var="aboutOrganizationTextarea"></spring:message>
                                                    <form:textarea
                                                            placeholder='${aboutOrganizationTextarea}'
                                                            path="about"
                                                            class="form-control" rows="3"
                                                            title='${aboutOrganizationTextarea}'/>
                                                </div>
                                                <form:errors path="about" cssClass="text-danger"></form:errors>
                                            </div>
                                        </div>

                                        <hr>

                                        <!-- ******* Step 1 Sonu ******* -->

                                        <div class="float-right">
                                            <button type="submit" class="btn btn-info"> <spring:message code="submitButton"></spring:message> </button>
                                        </div>

                                    </form:form>
                                </div>
                            </div>
                            <!-- içerideki kart -->
                        </div>
                    </div>
                    <!-- Dıştaki kart -->
                </div>
            </div>

        </section>
    </div>

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

<script>
    $.getJSON("/assets/json/countries.json", function (sonuc) {
        $.each(sonuc, function (index, value) {
            var row = "";
            row += '<option data-id="' + value.id + '" value="' + value.name + '">' + value.name + '</option>';
            $("#country").append(row);
        })
    });

    $("#country").on("change", function () {
        $("#city").attr("disabled", false).html("<option value=''>Seçiniz</option>");
        var countryId = $(this).find(':selected').data('id');
        $.getJSON("/assets/json/states.json", function (sonuc2) {
            $.each(sonuc2, function (index, value) {
                var row2 = "";
                if (value.country_id == countryId) {
                    row2 += '<option data-id="' + value.id + '" value="' + value.name + '">' + value.name + '</option>';
                    $("#city").append(row2);
                }
            });
        });
    });

    $("#city").on("change", function () {
        $("#district").attr("disabled", false).html("<option value=''>Seçiniz</option>");
        var cityId = $(this).find(':selected').data('id');
        $.getJSON("/assets/json/cities.json", function (sonuc3) {
            $.each(sonuc3, function (index, value) {
                var row2 = "";
                if (value.state_id == cityId) {
                    row2 += '<option data-id="' + value.id + '" value="' + value.name + '">' + value.name + '</option>';
                    $("#district").append(row2);
                }
            });
        });
    });


</script>

</body>

</html>