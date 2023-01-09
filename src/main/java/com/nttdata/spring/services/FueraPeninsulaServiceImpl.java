package com.nttdata.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nttdata.spring.entity.Product;

/**
 * Servicio para calcular el pvp de los productos donde el envío sea fuera de la peninsula
 * 
 * @author Eva
 *
 */
@Service("fueraPeninsulaService")
public class FueraPeninsulaServiceImpl implements ProductServiceI {

	/**
	 * Retorna una lista de productos con el pvp calculado
	 */
	@Override
	public List<Product> calcularPvp(List<Product> productosVendidos) {
		for (int i =0;i<productosVendidos.size();i++) {

			double pvp = productosVendidos.get(i).getPvp();
			pvp = (pvp * .04) + pvp;
			productosVendidos.get(i).setPvp(pvp);
		}

		return productosVendidos;
	}

}
