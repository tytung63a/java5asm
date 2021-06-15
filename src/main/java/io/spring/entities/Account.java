package io.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the account database table.
 * 
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String username;

	@Column
	private String password;
	
	@Column
	private String fullname;
	
	@Column
	private String email;
	
	@Column
	private String photo;
	
	@Column
	private Boolean activated;
	
	@Column
	private Boolean admin;
	
	@OneToMany(mappedBy = "account")
	List<Order> orders;

}