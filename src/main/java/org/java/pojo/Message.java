package org.java.pojo;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	
	@Column
	@Length(min = 3, max = 65535, message ="Il testo deve avere un minimo di 3 caratteri")
	private String text;
	
	@Column
	@Length(min = 3, max = 255, message = "La mail deve avere un minimo di 3 caratteri")
	@NotNull
	private String email;
	
	public Message() {}
	public Message(String email, String text) {
		
		setText(text);
		setEmail(email);
	}
	
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
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
