<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset = "utf-8">
    <title>Запись инфорамции о фирме</title>
    <link href = "styles.css" rel = "stylesheet" type = "text/css">
</head>

<body class = "body">

<div class = "header">
    <h1 style="text-align: center;
    /*color: rgba(43,45,48,0.95);*/
    font-family: 'Courier New';
    color: DarkSlateGray">Веб-приложение по учёту уплаты налогов в Республике Беларусь</h1>
    <p style="font-size: 16px; font-family: cursive; color: firebrick; position: absolute; top: 160px"> На данной странице Вы можете ввести информацию о своей фирме, </br>
        существующей или планируемой. Система укажет, какие налоги необходимо будет </br>
        платить, а также какую систему налогообложения можно использовать.
    </p>
</div>

<div class = "sidebar">
    <div class = "create"> <!-- вниз -->
        <form class = "forma" action="/taxcheck" method="get">
            <select name = "form" required>
                <option select = "selected">Выберите организационно-правовую форму: </option>
                <option>ИП</option>
                <option>ООО</option>
                <option>УП</option>
                <option>АО</option>
                <option>ОДО</option>
                <option>ПК</option>
            </select> </br>
            </br>
            <input class = "income" type = "number" name = "workers" value = "" placeholder = "Введите количество сотрудников: " size="60" required> </br>
            <input class = "single" type = "number" name = "vv" value = "" placeholder = "Введите размер валовой выручки (BYN): " size="60" required>  </br>
            <input class = "btn" type = "submit" name = "zSubmit" id = "zSubmit" value = "Отправить данные">
        </form>
    </div>
</div>
<div class = "footer">
    <h3 class = "foottext"> Copyright 2021 © Все права защищены </h3>
</div>
</body>

</html>
