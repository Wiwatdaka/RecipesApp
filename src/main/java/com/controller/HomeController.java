package com.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	RecipeDaoImpl r = new RecipeDaoImpl();
	
	@RequestMapping(value ="/recipeForm", method = {RequestMethod.GET,RequestMethod.PUT})
	public ModelAndView showForm() {
		ModelAndView mv = new ModelAndView("addRecipeForm");
		return mv;
	}
	
	@RequestMapping(value="/create", method = RequestMethod.POST)    
    public ModelAndView save(@ModelAttribute("add") Recipe recipe,
    		@RequestParam("file") CommonsMultipartFile file){
		
		if(file.isEmpty()) {
			System.out.println("file is empty");
		}
		
		try {
			byte[] b = file.getBytes();
			//ServletContext context = session.getServletContext();F:\eclipse-jee-2020-12-R-win32-x86_64\eclipse
//			Path path = Paths.get("C:\\Users\\Asus\\Desktop\\mvcCrudWorkspace\\localServer"+"\\"+file.getOriginalFilename());
			Path path = Paths.get("F:\\eclipse-jee-2020-12-R-win32-x86_64\\eclipse\\localServer"+"\\"+file.getOriginalFilename());

			Files.write(path, b);
			System.out.println("File path or name is: "+file.getOriginalFilename());
			System.out.println(System.getProperty("user.dir"));
			System.out.println(path.toString());
			
			recipe.setUrl(path.toString());
			
			
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
	
	@ModelAttribute("add")
	 public Recipe populateUser() {
		 Recipe b = new Recipe();
		 return b;
	 }

}
