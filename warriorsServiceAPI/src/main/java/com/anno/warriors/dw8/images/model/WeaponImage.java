package com.anno.warriors.dw8.images.model;

import java.util.List;

public class WeaponImage extends DynastyWarriors8Image {
	
	public WeaponImage(String name, List<?> images) {
		super(name, images);
		this.imageType = "Weapon";
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
