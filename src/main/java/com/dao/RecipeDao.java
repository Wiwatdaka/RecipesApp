package com.dao;

import com.entity.Recipe;

public interface RecipeDao {

	public Integer createRecipe(Recipe recipe);
	public Recipe updateRecipe(Recipe recipe);
	public void deleteRecipe(int id);
	public Recipe fetchRecipeById(int id);

}
