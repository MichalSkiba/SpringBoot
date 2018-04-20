<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.0.0-2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/styles.min.css">
</head>
<body>
<div class="register-photo">
    <div class="form-container">
        <div class="image-holder">
            <img src="${pageContext.request.contextPath}/resources/img/meeting.jpg">&nbsp;
        </div>
        <form id="usersForm" action="adduser" modelAttribute="user"
              enctype="multipart/form-data" method="POST">
            <h2 class="text-center"><strong>Create</strong> an account.</h2>
            <div class="form-group"><input class="form-control" type="login" name="login" placeholder="Login"></div>
            <div class="form-group"><input class="form-control" type="email" name="email" placeholder="Email"></div>
            <div class="form-group"><input class="form-control" type="name" name="name" placeholder="Name"></div>
            <div class="form-group"><input class="form-control" type="password" name="password" placeholder="Password"></div>
            <div class="form-group"><input class="form-control" type="password" name="password-repeat" placeholder="Password (repeat)"></div>
            <div class="form-group"><button class="btn btn-primary btn-block" type="submit">Sign Up</button><br/>
                <a href="/login">Logowanie</a>
            </div>
        </form>
    </div>
    <script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.0.0-2/js/bootstrap.bundle.min.js"></script>
</div>
</body>
</html>