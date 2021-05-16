<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Выплаты по видам налогов</title>
    <link href = "styles.css" rel = "stylesheet" type = "text/css">
</head>
<body>
    <div class = "header">
        <h1 style="text-align: center;
    /*color: rgba(43,45,48,0.95);*/
    font-family: 'Courier New';
    color: DarkSlateGray"> Веб-приложение по учёту уплаты налогов в Республике Беларусь</h1>
        <p style="font-size: 16px; font-family: cursive; color: firebrick; position: absolute; top: 160px">На данной странице Вы можете просмотреть </br>
            информацию о сумме выплат по каждому виду налогов. </br>
            Все виды налогов за все периоды извлекаются из базы, </br>
            после чего происходит расчёт.
            </p>
    </div>

    <div class = "sidebar">
        <form class = "fiscalForm" action="/fstat" method="get">
            <div class = "fiscalBlock">
            <h3 style = "font-style: italic; color: darkgoldenrod"> Выплаты по видам налогов: </h3> </br>
            <h3 style = "color: firebrick; font-style: italic"> Сумма поступлений от подоходного налога = <%= request.getAttribute("income") %> BYN </h3> </br>
            <h3 style = "color: firebrick; font-style: italic"> Сумма поступлений от единого налога = <%= request.getAttribute("single") %> BYN </h3> </br>
            <h3 style = "color: firebrick; font-style: italic"> Сумма поступлений по упрощённой системе = <%= request.getAttribute("simplyfied") %> BYN </h3>
            </div>
        </form>
    </div>
</body>
<div class = "footer">
    <h3 class = "foottext"> Copyright 2021 © Все права защищены </h3>
</div>
</html>
