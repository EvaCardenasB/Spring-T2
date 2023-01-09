package com.nttdata.spring.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entidad tabla pedidos
 * 
 * @author Eva
 *
 */
@Entity
@Table(name = "pedidos")
public class Order {

	/** ID (PK) */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	/** ADDRESSES */
	@Column(name = "ADDRESSES")
	private String addresses;

	/** ADDRESS */
	@Column(name = "ADDRESS")
	private String address;

	/**
	 * LOCATION (como indicador de si el pedido es de Ceuta, Melilla, Canarias o
	 * Peninsula)
	 */
	@Column(name = "location")
	private String location;
	
	/** ADDRESS */
	 @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<Product> product;

	/**
	 * @param id
	 * @param addressee
	 * @param address
	 * @param location
	 * @param product
	 */
	public Order(Long id, String addresses, String address, String location, List<Product> product) {
		super();
		this.id = id;
		this.addresses = addresses;
		this.address = address;
		this.location = location;
		this.product = product;
	}

	/**
	 * @param addresses
	 * @param address
	 * @param location
	 * @param product
	 */
	public Order(String addresses, String address, String location, List<Product> product) {
		super();
		this.addresses = addresses;
		this.address = address;
		this.location = location;
		this.product = product;
	}

	/**
	 * 
	 */
	public Order() {
		super();
	}

	/**
	 * @param province
	 */
	public Order(String postal_code) {
		this.location = postal_code;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the addressee
	 */
	public String getAddresses() {
		return addresses;
	}

	/**
	 * @param addressee the addressee to set
	 */
	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the product
	 */
	public List<Product> getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(List<Product> product) {
		this.product = product;
	}

}
