<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<meta charset="ISO-8859-1">
<title>RecipeAppHome</title>
</head>
<body style="background-color: #0099cc">
<jsp:include page="WEB-INF/pages/header.jsp" />

<div style="text-align:center">
<p>Welcome!</p>
<p>Make note of your Favorite Recipe</p>
<p>And they will come handy anytime!</p>

<!-- <a href="/RecipesApp/recipeForm">View Vehicle</a> --> 

<button style="background-color: #0066ff" onclick="document.location='/RecipesApp/recipeForm'">ADD a New Recipe</button>
</div>
 
</body>
</html>
