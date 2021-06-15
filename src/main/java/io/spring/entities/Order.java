package io.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// khoa chinh tudong genarate
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String address;
	
	@Temporal(TemporalType.DATE)
	@Column
	private Date createdate = new Date();
	
	@ManyToOne
	@JoinColumn(name = "username")
	private Account account;
	
	@OneToMany(mappedBy = "order")
	private List<OrderDetail> orderDetails;
}