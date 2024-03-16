package com.anno.warriors.dw8.images.model;

public abstract class DynastyWarriors8Image {
	private String name;
	private String image;
	protected String imageType;

	public DynastyWarriors8Image() {
		/*
		 * Empty for POJO related Reasons
		 */
	}

	/**
	 * @param name
	 * @param images
	 */
	public DynastyWarriors8Image(String name, String image) {
		super();
		this.name = name;
		this.image = image;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	public abstract String getImageType();

}
