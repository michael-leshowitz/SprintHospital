<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html5/loose/dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert Title Here</title>
</head>
<body>
Welcome ${patient.firstName}. I love gold. Your DOB is ${patient.dob}.

<form action="addPatient">
    <input type="text" name="firstName"><br>
    <input type="text" name="dob"><br>
    <input type="sumit">
</form>
</body>
</html>