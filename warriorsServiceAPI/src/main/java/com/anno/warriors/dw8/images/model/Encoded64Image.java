package com.anno.warriors.dw8.images.model;

public class Encoded64Image {

	private Byte[] bytes;
	private String encodedBase64;
	/**
	 * @param bytes
	 * @param toConvert
	 */
	public Encoded64Image(String encodedBase64, boolean toConvert) {
		super();
		this.encodedBase64 = encodedBase64;
		if(toConvert) {
			convert64ToByte(this.encodedBase64);
		}
	}

	public void convert64ToByte(String encodedBase64) {
		byte[] temp = encodedBase64.getBytes();
		bytes = new Byte[temp.length];
		int i = 0;
		for (byte b : temp) {
			bytes[i] = b;
			i++;
		}
	}

	public Byte[] getImageBytes() {
		return bytes;
	}
	
	public String getBase64Encoded() {
		return encodedBase64;
	}

}
