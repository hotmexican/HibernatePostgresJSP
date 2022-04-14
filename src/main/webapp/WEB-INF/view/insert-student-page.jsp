<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add student</title>
</head>
<body>
<div id="add">
    <h1> Add Student </h1>
    <form action="AddStudentServlet" method="GET">
        <table>
            <tr>
                <td> Student Name: </td>
                <td><input type="text" name="name" value='${requestScope["name"]}'></td>

            </tr>
            <tr>
                <td> Student Surname: </td>
                <td><input type="text" name="surname" value='${requestScope["surname"]}'></td>
            </tr>
            <tr>
                <td><input type="submit" name="addStudent" value="Add"></td>
            </tr>
        </table>
    </form>
</div>
<form action="EditStudentServlet" method="POST">
    <input type="submit" value="Show"> &nbsp; &nbsp;<br>
<%--    <td><input type="text" name="name" value="<%=request.getAttribute("name")%>"></td>--%>
</form>
</body>
</html>