package com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dao.RecipeDaoImpl;
import com.entity.Recipe;


@Controller
public class HomeController {
	//private static final String UPLOAD_DIRECTORY ="/images"; 
	RecipeDaoImpl r = new RecipeDaoImpl();
	
	@RequestMapping(value ="/recipeForm", method = {RequestMethod.GET,RequestMethod.PUT})
	public ModelAndView showForm() {
		ModelAndView mv = new ModelAndView("addRecipeForm");
		return mv;
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)    
    public ModelAndView save(@ModelAttribute("add") Recipe recipe,
    		//HttpSession session,
    		@RequestParam("file") CommonsMultipartFile file){
		
//		ServletContext context = session.getServletContext();  
//	    String path = context.getRealPath(UPLOAD_DIRECTORY);
		
		if(file.isEmpty()) {
			System.out.println("file is empty");
		}
		
		try {
			byte[] b = file.getBytes();
			//ServletContext context = session.getServletContext();F:\eclipse-jee-2020-12-R-win32-x86_64\eclipse C:\Program Files\Apache Software Foundation\Tomcat8.5\webapps\ROOT
//			Path path = Paths.get("C:\\Users\\Asus\\Desktop\\mvcCrudWorkspace\\localServer"+"\\"+file.getOriginalFilename());
//			Path path = Paths.get("F:\\eclipse-jee-2020-12-R-win32-x86_64\\eclipse\\localServer"+"\\"+file.getOriginalFilename());
//			Path path = Paths.get("C:\\Program Files\\Apache Software Foundation\\Tomcat8.5\\webapps\\ROOT"+"\\"+file.getOriginalFilename());
			

			Path path = Paths.get("C:\\Users\\Asus\\Desktop\\mvcCrudWorkspace\\localServer"+"\\"+file.getOriginalFilename());

//			Path path = Paths.get("C:\\Users\\Asus\\Desktop\\mvcCrudWorkspace\\RecipesApp\\src\\main\\webapp\\WEB-INF\\images"+"\\"+file.getOriginalFilename());



			Files.write(path, b);
			System.out.println("File path or name is: "+file.getOriginalFilename());
			//System.out.println(System.getProperty("user.dir"));
			System.out.println(path.toString());
			
			
//			 String filename = file.getOriginalFilename();  
//			  
//			 System.out.println(path+" "+filename);
//			 
//			 BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
//			         new File(path + File.separator + filename)));
//			    stream.write(b);  
//			    stream.flush();  
//			    stream.close();  
			
			recipe.setUrl(file.getOriginalFilename());
			
			
			//to set the path and store in database
			
		}
		 catch (IOException e) {
		        e.printStackTrace();
		    }
		
		
		//recipe.setPicture(b);		
		
//		String fileName=file.getOriginalFilename();
//		System.out.println("File path or name is: "+fileName);
//		String fileUrl="";
//		recipe.setUrl(fileUrl);
//    	System.out.println(recipe);
    	r.createRecipe(recipe); 
    	
    	System.out.println("File stored in DB"+recipe.getUrl());
    	
    	ModelAndView mv = new ModelAndView("redirect:/view");
        return mv;//will redirect to view request mapping    
    }
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView viewAllRecipe() {
		List<Recipe> list = r.fetchAllRecipes();
		ModelAndView mv = new ModelAndView("viewAllrecipes");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping(value="/viewEachRecipe/{id}", method = { RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})    
    public ModelAndView viewEachrecipe(@PathVariable int id){   
    	ModelAndView mv = new ModelAndView("view_each_recipe");
    	Recipe recipe=r.fetchRecipeById(id);  
        mv.addObject("recipe",recipe);  
        return mv;
    }
	
	@RequestMapping(value="/editRecipe/{id}", method = { RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})    
    public ModelAndView edit(@PathVariable int id){   
    	ModelAndView mv = new ModelAndView("edit_recipe");
    	Recipe recipe=r.fetchRecipeById(id);   
        mv.addObject("u",recipe);  
        return mv;
    }
	
	@RequestMapping(value = "/deleteRecipe/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
    public ModelAndView delete(@PathVariable("id") int id) {
		r.deleteRecipe(id);
    	ModelAndView mv = new ModelAndView("redirect:/view");
    	return mv;
  }
	
	@ModelAttribute("add")
	 public Recipe populateUser() {
		 Recipe b = new Recipe();
		 return b;
	 }

}
