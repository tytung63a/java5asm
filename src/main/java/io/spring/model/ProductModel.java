package io.spring.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import io.spring.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	//Blank = Empty + Null
	@NotBlank(message = "Khong duoc de trong")
	@Length(min = 5, max = 50, message = "Phai co tu 5 - 50 ky tu")
	private String name;
	
	private String description;
	
	private Double price;
	
	private MultipartFile image;
	
	private Integer available;

	private Integer quantity;

	private String createDate;

	//bi-directional many-to-one association to Category
	private Category category;

}