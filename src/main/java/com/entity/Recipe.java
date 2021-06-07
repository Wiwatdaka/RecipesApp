package com.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
//@Table(name = "RECIPELIST")
//@Table(name = "RECIPE")
@Table(name = "RECIPELISTNEW")
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="cookingtime")
	private String cookingTime;
	
	@Column(name="listofitems")
	private String listOfItems;
	
	@Column(name="steps")
	private String steps;
	
	@Column(name="taste")
	private String tasteDescription;
	
//	@Lob
//	@Column(name="picture")
//	private byte[] picture;
	
	@Column(name="url")
	private String url;
	
	public Recipe() {
		
	}

	public Recipe(int id, String name, String cookingTime, String listOfItems, String steps, String tasteDescription
			,String url
			) {
		super();
		this.id = id;
		this.name = name;
		this.cookingTime = cookingTime;
		this.listOfItems = listOfItems;
		this.steps = steps;
		this.tasteDescription = tasteDescription;
		//this.picture = picture;
		this.url = url;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCookingTime() {
		return cookingTime;
	}

	public void setCookingTime(String cookingTime) {
		this.cookingTime = cookingTime;
	}

	public String getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(String listOfItems) {
		this.listOfItems = listOfItems;
	}

	public String getSteps() {
		return steps;
	}

	public void setSteps(String steps) {
		this.steps = steps;
	}

	public String getTasteDescription() {
		return tasteDescription;
	}

	public void setTasteDescription(String tasteDescription) {
		this.tasteDescription = tasteDescription;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", cookingTime=" + cookingTime + ", listOfItems=" + listOfItems
				+ ", steps=" + steps + ", tasteDescription=" + tasteDescription + ", url=" + url + "]";
	}
	
	

//	public byte[] getPicture() {
//		return picture;
//	}
//
//	public void setPicture(byte[] picture) {
//		this.picture = picture;
//	}

//	@Override
//	public String toString() {
//		return "Recipe [id=" + id + ", name=" + name + ", cookingTime=" + cookingTime + ", listOfItems=" + listOfItems
//				+ ", steps=" + steps + ", tasteDescription=" + tasteDescription + ", picture="
//				+ Arrays.toString(picture)
//				+ "]";
//	}
	

}
