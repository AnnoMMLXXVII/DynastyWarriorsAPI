package com.anno.warriors.dw8.images.model;

public class NoImage extends DynastyWarriors8Image {

	public NoImage() {
		super("", "");
	}

	public NoImage(String name, String image) {
		super(name, image);
	}

	@Override
	public String getImageType() {
		return "";
	}

}
