<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Статистика плательщиков по категориям</title>
    <link href = "styles.css" rel = "stylesheet" type = "text/css">
</head>
<body>
    <div class = "header">
        <h1 style="text-align: center;
    /*color: rgba(43,45,48,0.95);*/
    font-family: 'Courier New';
    color: DarkSlateGray">Веб-приложение по учёту уплаты налогов в Республике Беларусь</h1>
        <p style="font-size: 16px; font-family: cursive; color: firebrick; position: absolute; top: 200px">На данной странице Вы можете просмотреть. </br>
            информацию о сумме выплат физических и юридических лиц. </br>
            Все виды налогов за все периоды извлекаются из базы, </br>
            после чего происходит расчёт.</p>
    </div>

    <div class = "sidebar">
        <form action="/catstat" method="get">
             <div class="catBlock">
                <h3 style = "font-style: italic; color: darkgoldenrod"> Суммы выплат по категориям плательщиков: </h3> </br>
                <h3 style = "color: firebrick; font-style: italic"> Выплачено физическими лицами: <%= request.getAttribute("citizens") %> BYN </h3> </br>
                <h3 style = "color: firebrick; font-style: italic"> Выплачено юридическими лицами: <%= request.getAttribute("ie") %> BYN </h3> </br>
             </div>
        </form>
    </div>
</body>
<div class = "footer">
    <h3 class = "foottext"> Copyright 2021 © Все права защищены </h3>
</div>
</html>