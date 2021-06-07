<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Recipe</title>
</head>
<body>

 <h1>Add Your New Recipe</h1>  
       <form:form  modelAttribute="add" action="/RecipesApp/create" method="post" enctype="multipart/form-data">    
        <table >    
         <tr>    
          <td><form:label path="name">Recipe Name : </form:label></td>  
          
          <td><form:input path="name"  /></td>  
         </tr>    
         <tr>    
          <td><form:label path="name">Cooking Time : </form:label></td>  
            
          <td><form:input path="cookingTime" /></td>  
         </tr>   
         <tr>    
          <td><form:label path="name">List of Items : </form:label></td>   
           
          <td><form:input path="listOfItems" /></td>  
         </tr>
         <tr>    
          <td><form:label path="name">Steps : </form:label></td>   
           
          <td><form:input path="steps" /></td>  
         </tr>  
         <tr>    
          <td><form:label path="name">Describe the taste : </form:label></td>   
           
          <td><form:input path="tasteDescription" /></td>  
         </tr>
         <tr>
         <td><form:input name="picture" type="file" id="FILE" path="picture"/></td>
         </tr>
        
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>  

</body>
</html>