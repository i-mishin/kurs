<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.mysql.cj.protocol.Resultset" %>
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
    <p style="font-size: 16px; font-family: cursive; color: firebrick; position: absolute; top: 140px">Здесь Вы можете просмотреть все декларации. Для просмотра деклараций после операций отклонения, перезагрузите страницу.</br>
    </p>
</div>

<div class = "sidebar">
    <!--<h3 style = "font-style: italic; color: firebrick; position: absolute; top: 250px; left: 650px"> Список записей в виде таблицы</h3>-->
    <table style = "position: absolute; top: 200px; left: 150px">
        <tr>
            <th>ID</th>
            <th>УНП</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Название</th>
            <th>Система налогообложения</th>
            <th>Валовая выручка</th>
            <th>Совокупные издержки</th>
            <th>Сумма налогов</th>
            <th>Вывод по декларации</th>
        </tr>
        <c:forEach items="${list}" var="declares">
            <tr>
                <td><c:out value="${declares.declareID}" default="empty" /> </td>
                <td><c:out value="${declares.number}" default="empty" /> </td>
                <td><c:out value="${declares.name}" default="empty" /> </td>
                <td><c:out value="${declares.surname}" default="empty" /></td>
                <td><c:out value="${declares.title}" default="empty" /></td>
                <td><c:out value="${declares.nalog}" default="empty" /></td>
                <td><c:out value="${declares.incomeD}" default="empty" /></td>
                <td><c:out value="${declares.costsD}" default="empty" /></td>
                <td><c:out value="${declares.fiscalD}" default="empty" /></td>
                <td>
                    <form action = "/accept">
                        <input class = "knopka" type = "submit" name = "" value = "Принять">
                    </form>
                    <form action = "/decline">
                        <input class = "knopka" type = "submit" name = "" value = "Отклонить">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<div class = "footer">
    <h3 class = "foottext"> Copyright 2021 © Все права защищены </h3>
</div>
</body>

</html>

