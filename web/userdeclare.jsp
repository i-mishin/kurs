<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset = "utf-8">
    <title>Просмотр декларации</title>
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
    <table style = "position: absolute; top: 200px; left: 150px">
        <tr>
            <th>ID</th>
            <th>УНП</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Название фирмы</th>
            <th>Система налогообложения</th>
            <th>Валовый доход</th>
            <th>Совокупные издержки</th>
            <th>Сумма налогов</th>
        </tr>

        <tr>
            <td> <%= request.getAttribute("1") %> </td>
            <td> <%= request.getAttribute("2") %> </td>
            <td> <%= request.getAttribute("3") %> </td>
            <td> <%= request.getAttribute("4") %> </td>
            <td> <%= request.getAttribute("5") %> </td>
            <td> <%= request.getAttribute("6") %> </td>
            <td> <%= request.getAttribute("7") %> </td>
            <td> <%= request.getAttribute("8") %> </td>
            <td> <%= request.getAttribute("9") %> </td>
        </tr>
    </table>
</div>

<div class = "footer">
    <h3 class = "foottext"> Copyright 2021 © Все права защищены </h3>
</div>
</body>

</html>
