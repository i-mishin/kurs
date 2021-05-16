<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset = "utf-8">
    <title>Подача декларации</title>
    <link href = "styles.css" rel = "stylesheet" type = "text/css">
</head>

<body class = "body">

<div class = "header">
    <h1 style="text-align: center;
    /*color: rgba(43,45,48,0.95);*/
    font-family: 'Courier New';
    color: DarkSlateGray">Веб-приложение по учёту уплаты налогов в Республике Беларусь</h1>
    <p style="font-size: 16px; font-family: cursive; color: firebrick; position: absolute; top: 160px"></p>
</div>

<div class = "sidebar">
    <h3 class="sidetextCreate">Заполните информацию для налоговой декларации: </h3> <!-- вниз -->
    <!--<div class = "create"> вниз -->
        <form class = "forma" action="/declare" method="get">
            <div style = "position: absolute; left: 430px; top: 250px;">
            <input class = "income" type = "number" name = "number" value = "" placeholder = "Введите учётный номер плательщика" size="60" required> </br>
            <input class = "ease" type = "text" name = "name" value = "" placeholder = "Имя представителя" size="60" required>  </br>
            <input class = "ease" type = "text" name = "surname" value = "" placeholder = "Фамилия представителя" size="60" required>  </br>
            <input class = "ease" type = "text" name = "title" value = "" placeholder = "Название фирмы" size="60" required>  </br>
            <select name = "system" required>
                <option select = "selected" >Выберите систему налогообложения: </option>
                <option>Упрощённая система (УСН)</option>
                <option>Общая система (ОСН)</option>
            </select> </br>
            </br>
            </div>
            <div style = "position: absolute; right: 500px; top: 250px;">
                <input class = "ease" type = "number" name = "income" value = "" placeholder = "Валовая выручка: " size="60" required>  </br>
                <input class = "ease" type = "number" name = "costs" value = "" placeholder = "Совокупные издержки: " size="60" required>  </br>
                <input class = "ease" type = "number" name = "vat" value = "0" placeholder = "Налогооблагаемая база для НДС (если есть): " size="60">  </br>
                <select name = "reg" required>
                    <option select = "selected" >Выберите тип регистрации: </option>
                    <option>Физическое лицо</option>
                    <option>Юридическое лицо</option>
                </select> </br>
                <input style = "background-color: #4CAF50; /* Green */
                                border: none;
                                color: white;
                                padding: 15px 25px;
                                text-align: center;
                                text-decoration: none;
                                display: inline-block;
                                font-size: 16px;
                                margin-left: 14px;
                                margin-top: 10px;" type = "submit" name = "zSubmit" id = "zSubmit" value = "Подать декларацию">
            </div>
        </form>
</div>
<div class = "footer">
    <h3 class = "foottext"> Copyright 2021 © Все права защищены </h3>
</div>
</body>

</html>
