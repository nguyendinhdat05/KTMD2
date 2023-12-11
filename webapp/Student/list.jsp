<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/11/2023
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
<center><h1>Danh Sach Hoc Sinh</h1></center>
<div>
    <table border="1">
        <tr>
            <th>MSV</th>
            <th>Tên</th>
            <th>Tuổi</th>
            <th>Sex</th>
            <th>Address</th>
            <th>Medium Score</th>
            <th><a href="/student?action=creat">Add</a></th>
        </tr>
        <c:forEach items='${student}' var="Student">
            <tr>
                <td>${Student.msv}</td>
                <td>${Student.name}</td>
                <td>${Student.age}</td>
                <td>${Student.sex}</td>
                <td>${Student.address}</td>
                <td>${Student.mediumScore}</td>
                <td><a href="/student?action=delete&msv=${Student.msv}">Delete</a></td>
                <td><a href="/student?action=edit&msv=${Student.msv}">Update</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
