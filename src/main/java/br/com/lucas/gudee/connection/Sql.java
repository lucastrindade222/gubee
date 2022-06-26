package br.com.lucas.gudee.connection;

import br.com.lucas.gudee.model.Product;
import br.com.lucas.gudee.model.Stack;
import br.com.lucas.gudee.model.TargetMarket;

public class Sql {

	public static String databaseCreation() {

		return "create table product(productId int NOT NULL AUTO_INCREMENT,"
				+ "productName CHAR(255),description CHAR(255),PRIMARY KEY (productId)" + ");create table targetMarket("
				+ "targetId int NOT NULL AUTO_INCREMENT,name CHAR(255),PRIMARY KEY (targetId)"
				+ ");create table stack(stackId int NOT NULL AUTO_INCREMENT," + "name CHAR(255),PRIMARY KEY (stackId));"
				+ "create table stack_product(stack_product int NOT NULL AUTO_INCREMENT,"
				+ "productIdFK int,stackIdFk int,PRIMARY KEY (stack_product),"
				+ "FOREIGN KEY (productIdFK) REFERENCES product (productId) ON DELETE CASCADE ON UPDATE RESTRICT,"
				+ "FOREIGN KEY (stackIdFk) REFERENCES stack (stackId) ON DELETE CASCADE ON UPDATE RESTRICT );"
				+ "create table targe_product(targe_product int NOT NULL AUTO_INCREMENT,"
				+ "productIdFK int,targeIdFk int,PRIMARY KEY (targe_product),"
				+ "CONSTRAINT `fk_product_stack` FOREIGN KEY (productIdFK) REFERENCES product (productId) ON DELETE CASCADE ON UPDATE RESTRICT,"
				+ "CONSTRAINT `fk_targetId_produto` FOREIGN KEY (targeIdFk) REFERENCES targetMarket (targetId) ON DELETE CASCADE ON UPDATE RESTRICT"
				+ ");";
	}

	public static String createProduct(Product product) {

		String variable = "";
		String values = "";
		if (product != null) {

			if (!product.getProductName().equals("") && product.getProductName() != null) {
				variable += "productName";
				values += "'" + product.getProductName() + "'";
			}
			if (!product.getDescription().equals("") && product.getDescription() != null) {

				variable += ",description";
				values += ",'" + product.getDescription() + "'";

			}

		}
		String sql = "INSERT INTO product (" + variable + ") VALUES (" + values + ")";

		return sql;
	}

	public static String findAllProduct() {

		String sql = "SELECT productId,productName, description  FROM product";

		return sql;
	}

	public static String findByNameProduct(String name) {

		String sql = "SELECT productId,productName , description  FROM product WHERE productName LIKE '%" + name
				+ " %'";

		return sql;
	}

	public static String findByIdProduct(Integer id) {

		String sql = "SELECT productId,productName , description  FROM product WHERE productId =" + id;

		return sql;
	}

	public static String createStack(Stack stack) {

		String variable = "";
		String values = "";
		if (stack != null) {

			if (!stack.getName().equals("") && stack.getName() != null) {
				variable += "name";
				values += "'" + stack.getName() + "'";
			}

		}
		String sql = "INSERT INTO stack (" + variable + ") VALUES (" + values + ")";

		return sql;
	}

	public static String findAllStack() {

		String sql = "SELECT stackId, name from stack";

		return sql;
	}

	public static String findByIdStack(Integer id) {

		String sql = "SELECT stackId, name from stack WHERE stackId =" + id;

		return sql;
	}
	
	
	public static String createTargetMarket(TargetMarket targetMarket) {

		String variable = "";
		String values = "";
		if (targetMarket != null) {

			if (!targetMarket.getName().equals("") && targetMarket.getName() != null) {
				variable += "name";
				values += "'" + targetMarket.getName() + "'";
			}

		}
		String sql = "INSERT INTO targetMarket (" + variable + ") VALUES (" + values + ")";

		return sql;
	}
	public static String findAllTargetMarket() {

		String sql = "SELECT targetId, name from targetMarket";

		return sql;
	}
	
	public static String findByIdTargetMarket(Integer id) {

		String sql = "SELECT targetId, name from targetMarket WHERE targetId =" + id;

		return sql;
	}

}
