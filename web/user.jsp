<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset = "utf-8">
    <title>Меню пользователя</title>
    <link href = "adminstyle.css" rel = "stylesheet" type = "text/css">
</head>

<body class = "body">
<div class = "header">
    <h1 style="text-align: center;
    /*color: rgba(43,45,48,0.95);*/
    font-family: 'Courier New';
    color: DarkSlateGray">Веб-приложение по учёту уплаты налогов в Республике Беларусь</h1>
    <p style="font-size: 16px; font-family: cursive; color: firebrick; position: absolute; top: 160px">Меню пользователя. </br>
        Выберите интересующую Вас операцию. </br>
    </p>
    <!--<form class = "crform1" action = "/booldeclare" method="get">
    <input style = "background-color: #949494;
    color: bisque;
    padding: 5px;
    text-decoration: none;
    font-weight: bold;
    border-left: 5px solid #33ADFF;
    display: block;
    width: 460px;
    height: 36px;
    text-align: center;
    font-size: 17px;
    " type = "submit" name = "graphics" value = "Проверьте необходимость подачи декларации!">
    </form>-->
    <h3 style = "position: absolute;
        top: 230px;
        left: 10px;
        font-family: cursive;
        color: firebrick;"> Необходимо прислать налоговую декларацию за квартал!</h3>
</div>

<div class = "sidebar">
    <h2 class= "sidetext">Меню пользователя</h2> <!-- поднять -->
    <div class = "menu">
        <ol id = "list">
            <li><a href = "declare.jsp">Подать налоговую декларацию</a></li>
            <li><a href = "create.jsp">Создать новую запись</a></li>
            <li><a href = "redact.jsp">Редактировать запись</a></li>
            <li><a href = "delete.jsp">Удалить запись</a></li>
            <li><a href = "search.jsp">Поиск записи</a></li>
            <li><a href = "info.jsp">Информация о налогах</a></li>
            <li><a href = "taxes.jsp">Проверить виды налогов</a></li>
        </ol>

        <form class = "crform1" action = "/viewrecord" method="get">
            <input class = "crbtn1" type = "submit" name = "aSubmit" value = "Вывести все записи">
        </form>

        <form class = "crform2" action="/fstat" method="get">
            <input class = "crbtn2" type = "submit" name = "fiscalbtn" value = "Данные о суммах налогов ">
        </form>

        <form class = "crform3" action="/catstat" method="get">
            <input class = "crbtn3" type = "submit" name = "catbtn" value = "Данные о плательщиках ">
        </form>

        <form class = "crform1" action = "/graphics" method="get">
            <input class = "crbtn1" type = "submit" name = "graphics" value = "Графическая функция">
        </form>
    </div>
    <form class = "crform1" action = "/numpage" method="get">
        <input style = "background-color: #949494;
    color: bisque;
    padding: 5px;
    text-decoration: none;
    font-weight: bold;
    border-left: 5px solid #33ADFF;
    display: block;
    width: 267px;
    height: 36px;
    text-align: center;
    font-size: 17px;
    position: absolute;
    top:560px;
    right: 8px;" type = "submit" name = "" value = "Просмотреть декларации">
    </form>
    <form class = "crform1" action = "/logout" method="post">
        <input style = "background-color: #949494;
    color: bisque;
    padding: 5px;
    text-decoration: none;
    font-weight: bold;
    border-left: 5px solid #33ADFF;
    display: block;
    width: 267px;
    height: 36px;
    text-align: center;
    font-size: 17px;
    position: absolute;
    top:600px;
    right: 8px;" type = "submit" name = "exit" value = "Выход из аккаунта">
    </form>
</div>

<div class = "footer">
    <h3 class = "foottext"> Copyright 2021 © Все права защищены </h3>
</div>
</body>
</html>


