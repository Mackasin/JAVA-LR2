<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="uk">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Табулювання функції</title>
</head>
<body>
<h2>Табулювання функції f(x) = cot(ln(x))</h2>
<form method="post" action="tabulate">
  <label for="a">Введіть a:</label>
  <input type="text" id="a" name="a" required>
  <br><br>

  <label for="b">Введіть b:</label>
  <input type="text" id="b" name="b" required>
  <br><br>

  <label for="h">Введіть крок h:</label>
  <input type="text" id="h" name="h" required>
  <br><br>

  <button type="submit">Табулювати</button>
</form>

<c:if test="${not empty error}">
  <p style="color:red;">${error}</p>
</c:if>

<c:if test="${not empty table}">
  <h3>Таблиця значень:</h3>
  <div>${table}</div>
</c:if>
</body>
</html>
