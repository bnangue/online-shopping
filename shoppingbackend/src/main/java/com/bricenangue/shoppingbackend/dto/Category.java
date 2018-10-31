package com.bricenangue.shoppingbackend.dto;

public class Category {

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(final String imageURL) {
		this.imageURL = imageURL;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(final boolean active) {
		this.active = active;
	}

	/*
	 * Private Fields
	 */
	private int id;
	private String name;
	private String description;
	private String imageURL;
	private boolean active = true;
}
