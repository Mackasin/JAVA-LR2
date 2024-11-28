<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Обчислення за допомогою ряду</title>
</head>
<body>
<h2>Обчислення ряду</h2>
<form method="post" action="calculate">
    <label for="x">Введіть x (|x| < 1):</label>
    <input type="text" id="x" name="x" required>
    <br><br>

    <label for="n">Введіть кількість доданків n:</label>
    <input type="text" id="n" name="n" required>
    <br><br>

    <label for="e1">Введіть перший поріг e1:</label>
    <input type="text" id="e1" name="e1" required>
    <br><br>

    <label for="e2">Введіть другий поріг e2:</label>
    <input type="text" id="e2" name="e2" required>
    <br><br>

    <button type="submit">Обчислити</button>
</form>

<c:if test="${not empty error}">
    <p style="color:red;">${error}</p>
</c:if>

<c:if test="${not empty sumN}">
    <h3>Результати:</h3>
    <p>Сума перших n доданків: ${sumN}</p>
    <p>Сума доданків, більших за ${e1}: ${sumE1}</p>
    <p>Сума доданків, більших за ${e2}: ${sumE2}</p>
    <p>Точне значення: ${exact}</p>
</c:if>
</body>
</html>
