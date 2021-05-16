<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset = "utf-8">
    <title>Проверка авторизации</title>
    <link href = "adminstyle.css" rel = "stylesheet" type = "text/css">
</head>

<body class = "body">
<div class = "header">
    <h1 style="text-align: center;
    /*color: rgba(43,45,48,0.95);*/
    font-family: 'Courier New';
    color: DarkSlateGray">Веб-приложение по учёту уплаты налогов в Республике Беларусь</h1>
    <p style="font-size: 16px; font-family: cursive; color: firebrick; position: absolute; top: 160px">Проверка авторизации</p>
</div>

<div class = "sidebar">
   <h1 style = "position: absolute; top: 200px; left: 220px" style="text-align: center;
    /*color: rgba(43,45,48,0.95);*/
    font-family: 'Courier New';
    color: DarkSlateGray">Ошибка авторизации: неверный логин или (и) пароль. Попробуйте ещё раз</h1>
    <a style = "position: absolute; top: 300px; left: 680px" href = "main.jsp">НА ГЛАВНУЮ</a>
</div>

<div class = "footer">
    <h3 class = "foottext"> Copyright 2021 © Все права защищены </h3>
</div>
</body>
</html>



