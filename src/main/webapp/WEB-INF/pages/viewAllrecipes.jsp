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
<body>

<h1>All Recipe List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Recipe Name</th><th>Cooking Time</th><th>List of Items</th><th>Steps</th><th>Taste Description</th><th>Picture</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="recipe" items="${list}">   
   <tr>  
   <td>${recipe.id}</td>  
   <td>${recipe.name}</td>  
   <td>${recipe.cookingTime}</td>  
   <td>${recipe.listOfItems}</td>  
   <td>${recipe.steps}</td>  
   <td>${recipe.tasteDescription}</td>  
   
   
   <td><img src="images/${recipe.url}" width="100" height="100"/></td>
   <td><a href="editbook/${book.id}">Edit</a></td>  
   <td><a href="deletebook/${book.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>

</body>
</html>