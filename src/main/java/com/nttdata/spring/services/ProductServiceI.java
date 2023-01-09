package com.nttdata.spring.services;

import java.util.List;

import com.nttdata.spring.entity.Product;


/**
 * @author Eva
 *
 */
public interface ProductServiceI {

	/**
	 * Método que devuelve el producto con el pvp calculado.
	 */

	public List<Product> calcularPvp(List<Product> productosPedidos);

}
