package com.nttdata.spring.services;

public interface MessengerServiceI {
	/**
	 * Crear pedido
	 * 
	 */
	public void createOrder();

	/**
	 * Añadir producto a un pedido
	 * 
	 */
	public void addProductToAnOrder();
}
