<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recipe</title>
</head>
<body style="text-align:center;background-color: #0099cc;">

<h1>${recipe.name}</h1>
<div>${recipe.url}</div>
<img src="../images/${recipe.url}" width="100" height="100"/>
<div>${recipe.cookingTime}</div>
<div>${recipe.listOfItems}</div>
<div>${recipe.steps}</div>
<div>${recipe.tasteDescription}</div>

</body>
</html>