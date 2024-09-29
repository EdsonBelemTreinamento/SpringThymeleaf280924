package br.com.arq.model;

import java.security.MessageDigest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Users {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
     
     private String name;
     @Column(unique=true)
     private String email;
     
     private String password;
     
     
     public Users() {
		 
	}
     
     

	public Users(Long id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}



	public Users(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}



	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
     // MD5
	 //transformo a string para byte
     // StringBuilder
     //byte vou armazenar no formato hexadecimal
	//saída ele converte em texto
	public String criptografarSenha(String senha) throws Exception {
	  MessageDigest md5 = MessageDigest.getInstance("MD5");
	  byte[] messageDigest = md5.digest(senha.getBytes());
	  StringBuilder sb = new StringBuilder();
	  for (byte b :messageDigest) {
		  sb.append(String.format("%02x", b));
	  }
		return sb.toString();
	}
     
     
     
     
 
}