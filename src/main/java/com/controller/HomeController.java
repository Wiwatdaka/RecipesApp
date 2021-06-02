package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="/create")    
    public ModelAndView save(@ModelAttribute("add") Recipe recipe){
    	System.out.println(recipe);
    	r.createRecipe(recipe); 
    	
    	ModelAndView mv = new ModelAndView("redirect:/view");
        return mv;//will redirect to viewbookingcab request mapping    
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
