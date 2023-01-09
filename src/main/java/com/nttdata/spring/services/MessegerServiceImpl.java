package com.nttdata.spring.services;

import org.springframework.stereotype.Service;

/**
 * Servicio de gestion de mensajes
 * 
 * @author Eva
 *
 */
@Service
public class MessegerServiceImpl implements MessengerServiceI {

	@Override
	public void createOrder() {
		System.out.println("Creando pedido...");
	}

	@Override
	public void addProductToAnOrder() {
		System.out.println("Producto añadido al pedido...");
	}

}
