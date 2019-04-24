package com.neu.edu.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Supplier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supplierID;
	
	@Column
	private String supplierName;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
	        name = "product_has_Supplier", 
	        joinColumns =  @JoinColumn(name = "supplierID") , 
	        inverseJoinColumns =  @JoinColumn(name = "id") 
	    )
	List<Product> product;

}
