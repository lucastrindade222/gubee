package br.com.lucas.gudee.connection;

import static br.com.lucas.gudee.connection.ConnectionJDBC.connectionNow;
import static br.com.lucas.gudee.connection.Sql.createTarge_product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.lucas.gudee.model.Targe_product;

public class Targe_productConnection {

	public static void savE(Targe_product targe_product) throws SQLException {
		ConnectionJDBC.request(createTarge_product(targe_product));
		
	}

	public static List<Targe_product> findALL() throws SQLException {
		List<Targe_product> list = new ArrayList<Targe_product>();
		 
			Connection connection = connectionNow();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(Sql.findAllTarge_product());

			while (rs.next()) {
				System.out.println(rs.getInt("targe_product")+"|"+rs.getInt("targeIdFk")+"|"+ rs.getInt("productIdFK"));
				Targe_product targe_product = new Targe_product(rs.getInt("targe_product"),rs.getInt("targeIdFk"), rs.getInt("productIdFK"));
				list.add(targe_product);
			}
		 
		return list;
 
	}

}
