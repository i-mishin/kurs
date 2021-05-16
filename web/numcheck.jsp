<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset = "utf-8">
    <title>Ввод УНП</title>
    <link href = "styles.css" rel = "stylesheet" type = "text/css">
</head>

<body class = "body">

<div class = "header">
    <h1 style="text-align: center;
    /*color: rgba(43,45,48,0.95);*/
    font-family: 'Courier New';
    color: DarkSlateGray">Веб-приложение по учёту уплаты налогов в Республике Беларусь</h1>
    <p style="font-size: 16px; font-family: cursive; color: firebrick; position: absolute; top: 160px"></br>
    </p>
</div>

<div class = "sidebar">
    <h3 style = "position: absolute;
    color: darkgoldenrod;
    left: 620px;
    top: 210px;
    font-size: 25px;">Введите УНП для запроса:</h3>
    <div class = "redform"> <!-- вправо -->
        <form action = "/numconfirm" method = "get">
            <input class = "id" type = "number" name = "unp" placeholder = "Введите УНП" size="60" required>  </br>
            <input class = "btn" type = "submit" name = "redSubmit" value = "Подтвердить">
        </form>
    </div>
</div>
<div class = "footer">
    <h3 class = "foottext"> Copyright 2021 © Все права защищены </h3>
</div>
</body>

</html>

