<!DOCTYPE html>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>

<h2>Simple Calculator</h2>

<form action="CalculatorServlet" method="post">
    Number 1: <input type="number" name="number1" required><br><br>
    Number 2: <input type="number" name="number2" required><br><br>

    <select name="operation">
        <option value="add">Addition</option>
        <option value="sub">Subtraction</option>
        <option value="mul">Multiplication</option>
        <option value="div">Division</option>
    </select>

    <br><br>
    <input type="submit" value="Calculate">
</form>

</body>
</html>
