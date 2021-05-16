<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset = "utf-8">
    <title>Главная</title>
    <link href = "main.css" rel = "stylesheet" type = "text/css">
</head>

<body class = "body">
<div class = "header">
    <h1 style="text-align: center;
    /*color: rgba(43,45,48,0.95);*/
    font-family: 'Courier New';
    color: DarkSlateGray">Веб-приложение по учёту уплаты налогов в Республике Беларусь</h1>
    <p style="font-size: 18px; font-family: cursive; color: firebrick">Добро пожаловать! Данное приложение предназначено для учёта уплаты налогов физическими и юридическими лицами в Республике Беларусь. Здесь Вы можете автоматизировать процессы по работе со всей информацией о налогах и сборах. Перед началом работы Вам необходимо создать аккаунт или авторизоваться в системе.</p>
</div>
<div class = "sidebar">
    <h2 class= "sidetext">Главное меню, войдите или зарегистрируйтесь</h2>
    <div class = "adminenter">
        <h3 style = "color: firebrick">Войти в аккаунт администратора</h3>
        <form action = "${pageContext.request.contextPath}/adminenter" method = "post">
            <input class = "field" type = "text" name = "aLog" value = "" placeholder = "Логин администратора" size="35" required> </br>
            <input class = "field" type = "password" name = "aPass" value = "" placeholder = "Пароль администратора" size="35" required>  </br>
            <input class = "btn" type = "submit" name = "aSubmit" value = "Войти как администратор">
        </form>
    </div>

    <div class = "userenter">
        <h3 style = "color: firebrick">Войти в аккаунт пользователя</h3>
        <form action = "${pageContext.request.contextPath}/userenter" method = "get">
            <input class = "field" type = "text" name = "uLog"  value = "" placeholder = "Логин пользователя" size="35" required> </br>
            <input class = "field" type = "password" name = "uPass"  value = "" placeholder = "Пароль пользователя" size="35" required>  </br>
            <input class = "btn" type = "submit" name = "uSubmit"  value = "Войти как пользователь">
        </form>
    </div>

    <div class = "userreg">
        <h3 style = "color: firebrick">Зарегистрировать пользователя</h3>
        <form action = "${pageContext.request.contextPath}/registration" method="post">
            <input class="field" type="text" name="reglog" value="" placeholder="Придумайте логин" size="35"
                   required> </br>
            <input class="field" type="password" name="regpass" value="" placeholder="Придумайте пароль" size="35"
                   required>  </br>
            <input class="btn" type="submit" name="regsubmit" value="Зарегистрировать аккаунт">
        </form>
    </div>
    <div style = "position: absolute; top: 580px; right: 60px">
    <h3><a href = "http://nalog.gov.by/ru/" > Министерство по налогам и сборам РБ</a></h3>
    </div>
</div>
<div class="footer">
    <h3 style="text-align: center;
    /*color: rgba(43,45,48,0.95);*/
    font-family: 'Courier New';
    color: DarkSlateGray"> Copyright 2021 © Все права защищены. </h3>
</div>
</body>
</html>
