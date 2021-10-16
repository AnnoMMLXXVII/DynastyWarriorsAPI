package com.anno.warriors.dw8.images.model;

public class CharacterImage extends DynastyWarriors8Image {

	/**
	 * @param name
	 * @param images
	 */
	public CharacterImage(String name, String image) {
		super(name, image);
		this.imageType = "Character";
	}

	@Override
	public String getImageType() {
		return imageType;
	}

	@Override
	public String toString() {
		return "CharacterImage [ " + super.toString() + "imageType=" + imageType + "]";
	}

}
