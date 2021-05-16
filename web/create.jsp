<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset = "utf-8">
    <title>Создание записи</title>
    <link href = "styles.css" rel = "stylesheet" type = "text/css">
</head>

<body class = "body">

<div class = "header">
    <h1 style="text-align: center;
    /*color: rgba(43,45,48,0.95);*/
    font-family: 'Courier New';
    color: DarkSlateGray">Веб-приложение по учёту уплаты налогов в Республике Беларусь</h1>
    <p style="font-size: 16px; font-family: cursive; color: firebrick; position: absolute; top: 160px">Вы находитесь на странице создания записи. </br>
        Введите категории налогоплательщиков - физ. лица ("citizens"), </br>
        юр. лица ("ie"), месяц, суммы выплат. Запись будет сохранена </br>
        в системе.</p>
</div>

<div class = "sidebar">
    <h3 class="sidetextCreate">Заполните информацию о налоговых сборах:</h3> <!-- вниз -->
    <div class = "create"> <!-- вниз -->
        <form class = "forma" action="/createrecord" method="post">
            <select name = "category">
                <option select = "selected" >Выберите категорию налогоплательщиков: </option>
                <option>Citizens</option>
                <option>ie</option>
            </select> </br>
            </br>
            <select name = "month">
                <option select = "selected">Выберите месяц учёта: </option>
                <option>January</option>
                <option>February</option>
                <option>March</option>
                <option>April</option>
                <option>May</option>
                <option>June</option>
                <option>July</option>
                <option>August</option>
                <option>September</option>
                <option>October</option>
                <option>November</option>
                <option>December</option>
            </select> </br>
            </br>
            <input class = "income" type = "number" name = "income" value = "" placeholder = "Сумма сборов (подоходный налог)" size="60" required> </br>
            <input class = "single" type = "number" name = "single" value = "" placeholder = "Сумма сборов (единый налог)" size="60" required>  </br>
            <input class = "ease" type = "number" name = "eased" value = "" placeholder = "Сумма сборов (упрощённая система)" size="60" required>  </br>
            <input class = "btn" type = "submit" name = "zSubmit" id = "zSubmit" value = "Записать данные">
        </form>
    </div>
</div>
<div class = "footer">
    <h3 class = "foottext"> Copyright 2021 © Все права защищены </h3>
</div>
</body>

</html>