<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset = "utf-8">
    <title>Просмотр записей</title>
    <link href = "styles.css" rel = "stylesheet" type = "text/css">
</head>

<body class = "body">

<div class = "header">
    <h1 style="text-align: center;
    /*color: rgba(43,45,48,0.95);*/
    font-family: 'Courier New';
    color: DarkSlateGray">Веб-приложение по учёту уплаты налогов в Республике Беларусь</h1>
</div>

<div class = "sidebar">
    <!--<h3 style = "font-style: italic; color: firebrick; position: absolute; top: 500px; left: 500px"> Искомая запись: </h3>-->
    <table>
        <tr>
            <th>ID</th>
            <th>Категория</th>
            <th>Месяц</th>
            <th>Подоходный налог</th>
            <th>Единый налог</th>
            <th>Упрощённая система</th>
        </tr>

        <tr>
            <td> <%= request.getAttribute("1") %> </td>
            <td> <%= request.getAttribute("2") %> </td>
            <td> <%= request.getAttribute("3") %> </td>
            <td> <%= request.getAttribute("4") %> </td>
            <td> <%= request.getAttribute("5") %> </td>
            <td> <%= request.getAttribute("6") %> </td>
        </tr>
    </table>
</div>

<div class = "footer">
    <h3 class = "foottext"> Copyright 2021 © Все права защищены </h3>
</div>
</body>

</html>