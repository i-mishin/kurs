<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.mysql.cj.protocol.Resultset" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset = "utf-8">
    <title>Налоги фирмы</title>
    <link href = "styles.css" rel = "stylesheet" type = "text/css">
</head>

<body class = "body">

<div class = "header">
    <h1 style="text-align: center;
    /*color: rgba(43,45,48,0.95);*/
    font-family: 'Courier New';
    color: DarkSlateGray">Веб-приложение по учёту уплаты налогов в Республике Беларусь</h1>
    <p style="font-size: 16px; font-family: cursive; color: firebrick; position: absolute; top: 160px">Здесь Вы можете просмотреть </br>
        информацию о налогах, исходя из введённых </br>
        данных о фирме.
    </p>
</div>

<div class = "sidebar">
    <!--<h3 style = "font-style: italic; color: firebrick; position: absolute; top: 250px; left: 650px"> Список записей в виде таблицы</h3>-->
    <table style = "position: absolute; top: 200px; left: 500px">
        <tr>
            <th>Налог</th>
            <th>Статус налога</th>
        </tr>
        <c:forEach items="${list}" var="taxes">
            <tr>
                <td>Единый налог </td>
                <td><c:out value="${taxes.singleTax}" default="empty" /> </td>
            </tr>
            <tr>
                <td>Общая система налогообложения</td>
                <td><c:out value="${taxes.commonTax}" default="empty" /> </td>
            </tr>
            <tr>
                <td>Упрощённая система налогообложения</td>
                <td><c:out value="${taxes.simplyfiedTax}" default="empty" /> </td>
            </tr>
            <tr>
                <td>Налог на прибыль</td>
                <td><c:out value="${taxes.profitTax}" default="empty" /></td>
            </tr>
            <tr>
                <td>Налог на добавленную стоимость (НДС)</td>
                <td><c:out value="${taxes.vat}" default="empty" /></td>
            </tr>
            <tr>
                <td>Страховые взносы </td>
                <td><c:out value="${taxes.insuranceTax}" default="empty" /></td>
            </tr>
            <tr>
                <td>Взнос в ФСЗН</td>
                <td><c:out value="${taxes.swf}" default="empty" /></td>
            </tr>
            <tr>
                <td>Подоходный налог</td>
                <td><c:out value="${taxes.incomeTax}" default="empty" /></td>
            </tr>

        </c:forEach>
    </table>
</div>

<div class = "footer">
    <h3 class = "foottext"> Copyright 2021 © Все права защищены </h3>
</div>
</body>

</html>
