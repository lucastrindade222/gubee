package br.com.lucas.gudee.connection;
import java.util.List;

import br.com.lucas.gudee.model.Product;
import br.com.lucas.gudee.model.Stack;
import br.com.lucas.gudee.model.Stack_product;
import br.com.lucas.gudee.model.Targe_product;
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

		String sql = "SELECT productId,productName, description  FROM product;";
 
		return sql;
	}
	

	public static String findByNameProduct(String name) {

		String sql = "SELECT productId,productName , description  FROM product WHERE productName LIKE '%" + name
				+ " %'";

		return sql;
	}

	public static String findAllFullByStackId(List<Integer> ids) {
		
		
		String sql ="SELECT  DISTINCT productId, productName, description  from product pr JOIN stack_product sp WHERE pr.productId = sp.productIdFK and ";
		
		String complement = " ";
		Integer counter =0;
		
 
		for (Integer id : ids) {
			
		
			if(counter == 0) {
				complement += "sp.stackIdFk = "+id;
				counter++;
			    continue;
			}
			
			complement += "or sp.stackIdFk = "+id;
			counter++;
		}
		
		
		return sql+complement;
		
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
	
	public static String findStackByProductID(Integer id) {

		String sql = "SELECT DISTINCT stackId, name from stack st JOIN stack_product sp  WHERE sp.productIdFK = "+id+" and sp.productIdFK = st.stackId";

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
	
	public static String findTargetMarketByProductID(Integer id ) {
		String sql = "SELECT DISTINCT tar.targetid, tar.name from targetMarket tar JOIN targe_product tp WHERE tp.PRODUCTIDFK= "+id+" and tar.targetId = tp.TARGEIDFK ";

		return sql;
	}

	public static String createTarge_product(Targe_product targe_product) {

		String variable = "";
		String values = "";
		if (targe_product != null) {

			if (!targe_product.getProductIdFK().equals("") && targe_product.getProductIdFK() != null) {
				variable += "productIdFK";
				values += "'" + targe_product.getProductIdFK() + "'";
			}
			if (!targe_product.getTargeIdFk().equals("") && targe_product.getTargeIdFk() != null) {

				variable += ",targeIdFk";
				values += ",'" + targe_product.getTargeIdFk() + "'";

			}

		}
		String sql = "INSERT INTO targe_product (" + variable + ") VALUES (" + values + ")";

		return sql;
	}

	public static String findAllTarge_product() {

		String sql = "SELECT  targe_product,targeIdFk, productIdFK, from targe_product";

		return sql;
	}

	public static String createStack_product(Stack_product stack_product) {

		String variable = "";
		String values = "";
		if (stack_product != null) {

			if (stack_product.getProductIdFK() != null) {
				variable += "productIdFK";
				values += "" + stack_product.getProductIdFK() + "";
			}
			if (stack_product.getStackIdFk() != null) {

				variable += ",stackIdFk";
				values += "," + stack_product.getStackIdFk() + "";

			}

		}
		String sql = "INSERT INTO stack_product (" + variable + ") VALUES (" + values + ")";

		return sql;
	}

	
//	private void teste() {
		
		
//		public static String findStackByProductId(Integer id) {
//
//			String sql = "SELECT DISTINCT stackId, name from stack st JOIN stack_product sp  WHERE sp.productIdFK = "+id+" and sp.productIdFK = st.stackId";
//
//			return sql;
//		}
//		public static String findTargetMarketByProductId(Integer id) {
//
//			String sql = "SELECT targetId, name from targetMarket WHERE targetId =" + id;
//
//			return sql;
//		}
//	}
	
}
