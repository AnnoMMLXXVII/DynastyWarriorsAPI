package com.anno.warriors.dw8.images.model;

import java.util.List;

public class CharacterImage extends DynastyWarriors8Image {

	/**
	 * @param name
	 * @param images
	 */
	public CharacterImage(String name, List<?> images) {
		super(name, images);
		this.imageType = "Character";
	}
	
	@Override
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	@Override
	public String getImageType() {
		return imageType;
	}

}
