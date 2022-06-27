package br.com.lucas.gudee.connection;

import static br.com.lucas.gudee.connection.ConnectionJDBC.request;
import static br.com.lucas.gudee.connection.Sql.databaseCreation;
import static java.util.Arrays.asList;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import br.com.lucas.gudee.dto.ProductLinkDTO;
import br.com.lucas.gudee.model.Product;
import br.com.lucas.gudee.model.Stack;
import br.com.lucas.gudee.model.TargetMarket;
import br.com.lucas.gudee.service.ProductService;
import br.com.lucas.gudee.service.StackService;
import br.com.lucas.gudee.service.TargetMarketService;

public class DatabaseCreation {

	public static void creation() throws SQLException {

		request(databaseCreation());

	}

	public static void bankCreationTest() {

		//try {
	//		creation();
		//	saveProduto();
	//		saveStacks();
			linkProduct();

	//	} catch (SQLException e) {

	//		e.printStackTrace();
	//	}

	}

	public static void saveProduto() {
		ProductService productService = new ProductService();
		List<Product> productsList = asList(
				new Product("Gubee Integrador", "Ferramenta de integração para marketplaces"),
				new Product("Gubee Fretes", "Ferramenta para gestão e calculo de fretes"),
				new Product("Gubee Fretes", "Ferramenta para gestão e calculo de fretes"),
				new Product("Gubee AntiFraude", "Ferramenta especialistas em detecção e prevenção à fraude"));

		productsList.forEach(e -> {

			try {
				productService.save(e);
			} catch (SQLException err) {
				System.out.println(err);

			}
		});

	}

	public static void saveStacks() {
		StackService stackService = new StackService();
		List<Stack> stacksList = asList(new Stack("Java 10"), new Stack("Java 10"), new Stack("Kotlin"),
				new Stack("Kafka"), new Stack("Kotlin"), new Stack("Event Stream"), new Stack("Redis"),
				new Stack("MongoDB"), new Stack("NodeJS"), new Stack("Big Data Analytics"), new Stack("Hadoop"),
				new Stack("Pig"), new Stack("Cassandra"));

		stacksList.forEach(e -> {
			try {
				stackService.save(e);
			} catch (SQLException err) {
				System.out.println(err);

			}
		});
	}

	public static void saveTargetMarket() {
		TargetMarketService targetMarketService = new TargetMarketService();

		List<TargetMarket> markets = asList(new TargetMarket("Ecommerce"), new TargetMarket("ERP"),
				new TargetMarket("Lojista que não desejam possuir ecommerce"), new TargetMarket("Loja fisica"),
				new TargetMarket("Telecom"), new TargetMarket("Venda direta"), new TargetMarket("Mobile First"),
				new TargetMarket("Digital Onboarding"));

		markets.forEach(e -> {
			try {
				targetMarketService.save(e);
			} catch (SQLException err) {
				System.out.println(err);

			}
		});
	}

	public static void linkProduct() {
		ProductService productService = new ProductService();
		List<ProductLinkDTO> linkDTOs = asList(new ProductLinkDTO(1, asList(1, 2, 3, 4, 5, 6), asList(1, 2, 3)),
				new ProductLinkDTO(2, asList(6, 7), asList(1, 2, 4)),
				new ProductLinkDTO(3, asList(6, 7), asList(1, 2, 4)),
				new ProductLinkDTO(4, asList(8, 9, 10, 11, 12), asList(1, 5, 6, 7, 8)));

		linkDTOs.forEach(e -> {
			try {
				productService.ProductLink(e);
			} catch (SQLException err) {
				System.out.println(err);

			}
		});
	}

}
