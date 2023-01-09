package com.nttdata.spring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;

import com.nttdata.spring.entity.Order;
import com.nttdata.spring.entity.Product;
import com.nttdata.spring.repository.ProductRepository;
import com.nttdata.spring.services.MessengerServiceI;
import com.nttdata.spring.services.ProductServiceI;

/**
 * 
 * Clase principal
 * 
 * @author Eva
 *
 */
@SpringBootApplication()
public class NTTDataMain implements CommandLineRunner {

	/** Servicio peninsula */
	@Autowired
	@Qualifier("peninsulaService")
	private ProductServiceI peninsulaService;

	/** Servicio fuera de la peninsula */
	@Autowired
	@Qualifier("fueraPeninsulaService")
	private ProductServiceI fueraPeninsulaService;

	/** Repositorio de productos */
	@Autowired
	private ProductRepository productRepository;
	
	/** Repositorio de productos */
	@Autowired
	private MessengerServiceI message;

	/**
	 * Método principal.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NTTDataMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Ejemplo de acoplamiento y solución por Spring.

		// Visualización del gasto mensual.
		final String month = "12";
		// systemService.checkMonthlyExpenditure(month);

		// System.out.println("Hay añadidos: " + exampleRepo.count() + " registros.");

		// Crear productos

		final Product product1 = new Product();
		product1.setName("Proteina");
		product1.setPvp(40);
		product1.setIpsi(40);

		final Product product2 = new Product();
		product2.setName("L-Carnitina");
		product2.setPvp(15);
		product2.setIpsi(15);

		final Product product3 = new Product();
		product3.setName("Creatina");
		product3.setPvp(20.00);
		product3.setIpsi(20.00);

		final Product product4 = new Product();
		product4.setName("Cafeina");
		product4.setPvp(6.00);
		product4.setIpsi(6.00);

		final Product product5 = new Product();
		product5.setName("Proteina");
		product5.setPvp(65);
		product5.setIpsi(65);

		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		productRepository.save(product4);
		productRepository.save(product5);

		// Hacer pedido para dentro de la peninsula haciendo uso del servicio
		final Order order = new Order();
		order.setAddresses("Eva Cardenas Bermudez");
		order.setAddress("Calle Asturias, 2");
		order.setLocation("Peninsula");

		message.createOrder();
		
		List<Product> productList = new ArrayList();
		productList.add(product1);
		message.addProductToAnOrder();
		productList.add(product2);
		message.addProductToAnOrder();

		List<Product> productOrder = peninsulaService.calcularPvp(productList);
		order.setProduct(productOrder);
		for (int i =0;i<productOrder.size();i++) {
			System.out.println(productOrder.get(i).toString());
			
		}
			

	}

}
