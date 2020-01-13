<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 
  <%@taglib prefix="n" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@taglib prefix="myt" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="styles.css">
<title>Result</title>
</head>
<body>

<h1>Cube info using JSP 2.0</h1>
<h3> Side's of Cube: ${side} and Volume is: ${volume}</h3>

<h1>Cube info from TAG</h1>

<myt:customTag/>

<h1>Cube info using JSTL</h1>

<n:choose>

<n:when test="${volume >= 10 }" >



<h3>Side's of Cube: ${side} and Volume is:
<Strong style="color:red"><n:out value="${volume}"></n:out>
</Strong></h3>



</n:when>

<n:when test="${volume < 10 }">

 <h3>Side's of Cube: ${side} and Volume is:
<n:out value="${volume}"></n:out>
</h3>

</n:when>

</n:choose>



</body>
</html>