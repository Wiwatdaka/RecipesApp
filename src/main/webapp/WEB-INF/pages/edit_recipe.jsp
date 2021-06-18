<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Recipe</title>
</head>
<body style="background-color: #0099cc;">
<jsp:include page="header.jsp" />

 <h1 style="text-align:center">Edit Your Recipe</h1>  
       <form:form  modelAttribute="add" action="/RecipesApp/editSaveRecipe" method="post" enctype="multipart/form-data" style="margin-left: 25%; width:50%;">    
        <table >   
        <tr>  
        <td></td>    
         <td><form:hidden  path="id" value="${recipe.id}"/></td>  
         </tr> 
         <tr>    
          <td><form:label path="name">Recipe Name : </form:label></td>  
          
          <td><form:input path="name"  value="${recipe.name}"/></td>  
         </tr>    
         <tr>    
          <td><form:label path="name">Cooking Time : </form:label></td>  
            
          <td><form:input path="cookingTime" value="${recipe.cookingTime}"/></td>  
         </tr>   
         <tr>    
          <td><form:label path="name">List of Items : </form:label></td>   
           
          <td><form:input path="listOfItems" value="${recipe.listOfItems}"/></td>  
         </tr>
         <tr>    
          <td><form:label path="name">Steps : </form:label></td>   
           
          <td><form:input path="steps" value="${recipe.steps}"/></td>  
         </tr>  
         <tr>    
          <td><form:label path="name">Describe the taste : </form:label></td>   
           
          <td><form:input path="tasteDescription" value="${recipe.tasteDescription}"/></td>  
         </tr>
         <tr>
         <td><input name="file" type="file" id="FILE" value="${recipe.url}"/></td>
         </tr>
        
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>  

</body>
</html>