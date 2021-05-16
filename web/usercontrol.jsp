<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset = "utf-8">
    <title>Управление пользователями</title>
    <link href = "styles.css" rel = "stylesheet" type = "text/css">
</head>

<body class = "body">

<div class = "header">
    <h1 style="text-align: center;
    /*color: rgba(43,45,48,0.95);*/
    font-family: 'Courier New';
    color: DarkSlateGray">Веб-приложение по учёту уплаты налогов в Республике Беларусь</h1>
    <!--<p>Данное приложение предназначено для учёта уплаты налогов физическими и юридическими лицами в Республике Беларусь</p>-->
</div>

<div class = "sidebar">
    <h2 class = "sidetext3">На данной странице Вы можете добавить или удалить пользователя:</h2>
    <h3 class = "addtext">Добавить пользователя:</h3>
    <h3 class = "dsidetext">Введите логин удаляемого пользователя:</h3>
    <div class = "adduser">
        <form action="/adduser" method="post">
            <input type = "text" name = "newLogin" value = "" placeholder = "Придумайте логин" size="60" required> </br>
            <input type = "text" name = "newPassword" id = "newPassword" value = "" placeholder = "Придумайте пароль" size="60" required>  </br>
            <input class = "btn" type = "submit" name = "" value = "Добавить пользователя">
        </form>
    </div>
    <div class = "userdel">
        <form action = "/deluser" method="post">
            <input class = "id" type = "text" name = "delLogin" value = "" placeholder = "Логин пользователя" size="60" required>  </br>
            <input class = "btn" type = "submit" value = "Удалить пользователя">
        </form>
    </div>
</div>
<div class = "footer">
    <h3 class = "foottext"> Copyright 2021 © Все права защищены </h3>
</div>
</body>

</html>
