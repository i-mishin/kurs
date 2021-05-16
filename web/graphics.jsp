<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Диаграммы</title>
    <link href = "styles.css" rel = "stylesheet" type = "text/css">
    <script src="https://www.google.com/jsapi"></script>
    <script>
        google.load("visualization", "1", {packages:["corechart"]});
        google.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Вид налога', 'Доля налога'],
                ['Подоходный налог', <%=request.getAttribute("income") %>],
                ['Единый налог', <%=request.getAttribute("single") %>],
                ['Упрощённая система', <%=request.getAttribute("simplyfied") %>],
            ]);
            var options = {
                title: 'Диаграмма налоговой структуры и поступлений',
                is3D: true,
                pieResidueSliceLabel: 'Остальное'
            };
            var chart = new google.visualization.PieChart(document.getElementById('air'));
            chart.draw(data, options);
        }
    </script>

    <script>
        google.load("visualization", "1", {packages:["corechart"]});
        google.setOnLoadCallback(drawChart);
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Год', 'Физические лица', 'Юридические лица'],

                ['2021', <%= request.getAttribute("citizens") %>,  <%= request.getAttribute("ie") %>]
            ]);
            var options = {
                title: 'Категории налогоплательщиков',
                hAxis: {title: 'Год'},
                vAxis: {title: 'BYN'}
            };
            var chart = new google.visualization.ColumnChart(document.getElementById('oil'));
            chart.draw(data, options);
        }
    </script>
</head>
<body>
<div class = "header">
    <h1 style="text-align: center;
    /*color: rgba(43,45,48,0.95);*/
    font-family: 'Courier New';
    color: DarkSlateGray">Веб-приложение по учёту уплаты налогов в Республике Беларусь</h1>
    <p></p>
</div>
<div class = "sidebarGr">
    <div id="air" style = "position:absolute; width: 650px; height: 500px; top: 180px; left: 140px;"></div>
    <div id="oil" style = "position: absolute; width: 500px; height: 400px; top: 180px; right: 250px;"></div>
</div>
<div class = "footer">
    <h3 class = "foottext"> Copyright 2021 © Все права защищены </h3>
</div>
</body>
</html>
