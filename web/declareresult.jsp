<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.mysql.cj.protocol.Resultset" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset = "utf-8">
    <title>Результаты подачи декларации</title>
    <link href = "styles.css" rel = "stylesheet" type = "text/css">
</head>

<body class = "body">

<div class = "header">
    <h1 style="text-align: center;
    /*color: rgba(43,45,48,0.95);*/
    font-family: 'Courier New';
    color: DarkSlateGray">Веб-приложение по учёту уплаты налогов в Республике Беларусь</h1>
    <p style="font-size: 16px; font-family: cursive; color: firebrick; position: absolute; top: 160px">Здесь Вы можете просмотреть результаты </br>
        подачи декларации. </br>
    </p>
</div>

<div class = "sidebar">
    <!--<h3 style = "font-style: italic; color: firebrick; position: absolute; top: 250px; left: 650px"> Список записей в виде таблицы</h3>-->
        <div style = "position: absolute; top: 280px; left: 640px;" >
        <c:forEach items="${list}" var="declarelist">
            <h3 style = "font-style: italic; color: darkgoldenrod"><c:out value="${declarelist}" default="empty" /></h3> </br>
        </c:forEach>
        </div>
</div>

<div class = "footer">
    <h3 class = "foottext"> Copyright 2021 © Все права защищены </h3>
</div>
</body>

</html>
