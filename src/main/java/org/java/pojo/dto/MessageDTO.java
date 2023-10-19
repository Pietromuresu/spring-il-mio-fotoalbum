package org.java.pojo.dto;


public class MessageDTO {
	
	
	private String text;
	private String email;
	
	public MessageDTO() {}
	public MessageDTO(String email, String text) {
		
		setText(text);
		setEmail(email);
	}
	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		
		return "Sender: " + getEmail() +"\n"
			 + "Message: " + getText() + "\n";
	}
	
	
	// TODO : ADD SERVICE AND REPO
	
	
}
