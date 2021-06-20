package io.spring.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountModel implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@NotBlank(message = "Khong duoc de trong")
	@Length(min = 5, max = 50, message = "Phai co tu 5 - 50 ky tu")
	private String username;
	
	@NotBlank(message = "Khong duoc de trong")
	private String password;
	
	private String fullname;
	
	@NotBlank(message = "Khong duoc de trong")
	private String email;
	
	private MultipartFile photo;
	
	private Boolean activated;
	
	private Boolean admin;



}
