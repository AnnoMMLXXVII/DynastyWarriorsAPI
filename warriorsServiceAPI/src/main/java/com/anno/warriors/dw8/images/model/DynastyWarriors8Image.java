package com.anno.warriors.dw8.images.model;

import java.util.List;

public abstract class DynastyWarriors8Image {
	private String name;
	private List<?> images;
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
	public DynastyWarriors8Image(String name, List<?> images) {
		super();
		this.name = name;
		this.images = images;
	}
	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the images
	 */
	public List<?> getImages() {
		return images;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param images the images to set
	 */
	public void setImages(List<?> images) {
		this.images = images;
	}

	public abstract void setImageType(String imageType);

	public abstract String getImageType();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imageType == null) ? 0 : imageType.hashCode());
		result = prime * result + ((images == null) ? 0 : images.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DynastyWarriors8Image other = (DynastyWarriors8Image) obj;
		if (imageType == null) {
			if (other.imageType != null)
				return false;
		} else if (!imageType.equals(other.imageType))
			return false;
		if (images == null) {
			if (other.images != null)
				return false;
		} else if (!images.equals(other.images))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DynastyWarriors8Image [name=" + name + ", images=[BASE64]"+ ", imageType=" + imageType
				+ "]";
	}

}
