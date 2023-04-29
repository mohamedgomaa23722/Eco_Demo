<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <spring:url value="/resources/css/login.css" var="mainCss" />
    <spring:url value="https://fonts.googleapis.com/css?family=Karla:400,700&display=swap" var="karlaFont" />
    <spring:url value="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css" var="materialdesignicons" />
    <spring:url value="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" var="bootstrap" />

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>

    <link rel="stylesheet" href="${karlaFont}">
    <link rel="stylesheet" href="${materialdesignicons}">
    <link rel="stylesheet" href="${bootstrap}">
    <link rel="stylesheet" href="${mainCss}">

</head>
<body>
<spring:url value="/resources/images/login.jpg" var="image1" />
<spring:url value="/resources/images/logo.svg" var="image2" />

<main class="d-flex align-items-center min-vh-100 py-3 py-md-0">
    <div class="container">
        <div class="card login-card">
            <div class="row no-gutters">
                <div class="col-md-5">
                    <img src="${image1}" alt="login" class="login-card-img">
                </div>
                <div class="col-md-7">
                    <div class="card-body">
                        <div class="brand-wrapper">
                            <img src="${image2}" alt="logo" class="logo">
                        </div>
                        <p class="login-card-description">Sign into your account</p>
                        <form:form modelAttribute="login" >
                            <div class="form-group">
                                <form:label path="email" cssClass="sr-only" for="email">Email</form:label>
                                <form:input path="email" type="email" cssClass="form-control" id="email" placeholder="Email"/>
                            </div>
                            <div class="form-group mb-4">
                                <form:label path="password" cssClass="sr-only" for="password">Password</form:label>
                                <form:input path="password" type="password" cssClass="form-control" id="password" placeholder="Password"/>
                            </div>
                            <input name="login" id="login" class="btn btn-block login-btn mb-4" type="submit" value="Login">
                        </form:form>
                        <a href="#!" class="forgot-password-link">Forgot password?</a>
                        <p class="login-card-footer-text">Don't have an account? <a href="#!" class="text-reset">Register here</a></p>
                        <nav class="login-card-footer-nav">
                            <a href="#!">Terms of use.</a>
                            <a href="#!">Privacy policy</a>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</body>
</html>
