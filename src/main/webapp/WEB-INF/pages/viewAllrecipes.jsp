<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ViewAll</title>
</head>
<body style="text-align:center;background-color: #0099cc;">
<jsp:include page="header.jsp" />

<h1>All Recipe List</h1>  
<table style="margin-left: auto;margin-right: auto;" border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Recipe Name</th><th>View</th></tr>  
   <c:forEach var="recipe" items="${list}">   
   <tr>  
   <td>${recipe.id}</td>  
   <td>${recipe.name}</td>   
   <td><a href="viewEachRecipe/${recipe.id}">View</a></td>  
   </tr>  
   </c:forEach>  
   </table>

</body>
</html>