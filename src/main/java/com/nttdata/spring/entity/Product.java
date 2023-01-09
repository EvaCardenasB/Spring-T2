package com.nttdata.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidad tabla products
 * 
 * @author Eva
 *
 */
@Entity
@Table(name = "product")
public class Product {

	/** ID (PK) */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	/** NAME */
	@Column(name = "NAME")
	private String name;

	/** PVP */
	@Column(name = "PVP")
	private double pvp;

	/** IPSI */
	@Column(name = "IPSI")
	private double ipsi;

	@ManyToOne
	@JoinColumn
	private Order order;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the pvp
	 */
	public double getPvp() {
		return pvp;
	}

	/**
	 * @param pvp the pvp to set
	 */
	public void setPvp(double pvp) {
		this.pvp = pvp;
	}

	/**
	 * @return the ipsi
	 */
	public double getIpsi() {
		return ipsi;
	}

	/**
	 * @param ipsi the ipsi to set
	 */
	public void setIpsi(double ipsi) {
		this.ipsi = ipsi;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
	
	@Override
	public String toString() {
		return "Producto [ " + name + " IPSI: "+ ipsi+" PVP: " + pvp  + "]";
	}

}
