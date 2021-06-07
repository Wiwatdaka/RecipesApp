package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Recipe;
import com.util.HibernateUtility;

public class RecipeDaoImpl implements RecipeDao {
	
	static SessionFactory sessionFactory = null;

	public Integer createRecipe(Recipe recipe) {
		System.out.println("Creating Recipe in DB");
		Session session = HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(recipe);
		
		session.getTransaction().commit();
		session.close();
		System.out.println("Recipe saved to database");
		return recipe.getId();
	}

	public Recipe updateRecipe(Recipe recipe) {
		System.out.println("Updating Recipe in DB");
		Session session = HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();
		Recipe r = (Recipe) session.get(Recipe.class, recipe.getId());
		r.setName(recipe.getName());
		r.setCookingTime(recipe.getCookingTime());
		r.setListOfItems(recipe.getCookingTime());
		r.setSteps(recipe.getSteps());
		r.setTasteDescription(recipe.getTasteDescription());
		r.setUrl(recipe.getUrl());
		
		session.getTransaction().commit();
		session.close();
		System.out.println("Recipe updated to database");
		return r;
	}

	public void deleteRecipe(int id) {
		System.out.println("Deleting Recipe in DB");
		Session session = HibernateUtility.getSessionFactory().openSession();
		session.beginTransaction();
		
		Recipe r = fetchRecipeById(id);
		session.delete(r);
		
		session.getTransaction().commit();
		session.close();
		System.out.println("Recipe deleted from database");
		
	}

	public Recipe fetchRecipeById(int id) {
		System.out.println("Fetching Recipe by ID in DB");
		Session session = HibernateUtility.getSessionFactory().openSession();
		
		Recipe r = (Recipe) session.load(Recipe.class, id);
		System.out.println(r.toString());
		
		session.close();

		return r;
	}
	
	public List<Recipe> fetchAllRecipes(){
		System.out.println("Fetching all Recipes");
		Session session = HibernateUtility.getSessionFactory().openSession();
		
		List<Recipe> r = session.createQuery("FROM Recipe").list();
		
		session.close();
		System.out.println("All Recipes database");
		
		return r;
	}

}
