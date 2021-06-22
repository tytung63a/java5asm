package io.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the product database table.
 * 
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private Integer available;

	@Temporal(TemporalType.DATE)
	@Column(name="createdate")
	private Date createDate;

	@Column
	private String image;

	@Column
	private String name;

	@Column
	private Double price;


	@Column
	private Integer quantity;

	@ManyToOne
	private Category category;
	
	@OneToMany(mappedBy = "product")
	private List<OrderDetail> orderDetails;


}