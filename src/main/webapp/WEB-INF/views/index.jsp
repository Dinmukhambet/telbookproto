
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Тел.книжка</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js">

        $.ajax({
            url: '/phonebook/json',
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(data){

                var table = '<table><thead><th>Name</th><th>Tel.number</th><th>email</th></thead><tbody>';
                var object = JSON.parse(data);
                $.each(object, function () {
                    table += '<tr><td>' + this['name'] + '</td><td>' + this['telNumber'] + '</td><td>'
                    this['email'] + '</td><tr>';
                });
                table += '</tbody><table>';
                document.getElementById("inf").innerHTML = table;
            }

        })

    </script>
</head>
<!-- <script type="text/javascript" src="webjars/jquery"></script> -->
<body>

<h2>Телефонная книжка</h2>


<h2>Records</h2>

<table class="table table-bordered">
    <tr>
        <td>Name</td>
        <td>telefon number</td>
        <td>email</td>
        <td>X</td>
    </tr>
    <tr>
        <c:forEach items="${records}" var="record">
    <tr>
        <td>${record.name}</td>
        <td>${record.telNumber}</td>
        <td>${record.email}</td>
        <td><a href="<c:url value='phonebook/delete-${record.telNumber}'/>">delete</a></td>
    </tr>
    </c:forEach>
    </tr>
</table>

<h2>Json OBject</h2>
<div id="inf"></div>
</body>
</html>
