package models;

import javafx.scene.image.ImageView;

public class Contact {
	
	private String name;
	private String email;
	private String phoneNumber;
	private ImageView photo;
	
	public Contact (String name, String email, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setPhoto(ImageView photo) {
		this.photo = photo;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public ImageView getPhoto() {
		return this.photo;
	}
}
