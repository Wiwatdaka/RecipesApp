package com.checking;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;

import com.dao.RecipeDaoImpl;
import com.entity.Recipe;

public class CheckImage {
	//private static RecipeDaoImpl recipe;
	//RecipeDaoImpl recipe = new RecipeDaoImpl();
	
	public static void main(String args[]) {
		/*File file = new File("C:\\Users\\Asus\\Downloads\\kakslauttanenNorthernLights.jpg"); //windows
	//	File file = new File("src\\main\\resources\\images\\kakslauttanenNorthernLightsn.png"); //windows
		System.out.println("bfile"+file);
		
		//File file = new File("images/extjsfirstlook.jpg");
        byte[] bFile = new byte[(int) file.length()];
        
        System.out.println("bfile"+bFile);
 
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
        Recipe r = new Recipe();
        r.setName("testRecipe");
        r.setCookingTime("2");
        r.setListOfItems("testlist");
        r.setSteps("teststeps");
        r.setTasteDescription("testDesc");
        r.setPicture(bFile);*/
        
        RecipeDaoImpl recipe = new RecipeDaoImpl();
        
        //recipe.createRecipe(r);
        
        
        Recipe rr = recipe.fetchRecipeById(1);
         
        try{
            FileOutputStream fos = new FileOutputStream("src\\main\\resources\\images\\output\\out.jpg");  //windows
            //FileOutputStream fos = new FileOutputStream("images/output.jpg");
            fos.write(rr.getPicture());
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
 
        
	}

}
