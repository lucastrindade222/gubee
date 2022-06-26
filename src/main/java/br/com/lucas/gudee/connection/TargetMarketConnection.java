package br.com.lucas.gudee.connection;

import static br.com.lucas.gudee.connection.ConnectionJDBC.connectionNow;
import static br.com.lucas.gudee.connection.ConnectionJDBC.request;
import static br.com.lucas.gudee.connection.Sql.createTargetMarket;
import static br.com.lucas.gudee.connection.Sql.findAllTargetMarket;
import static br.com.lucas.gudee.connection.Sql.findTargetMarketByProductID;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.lucas.gudee.model.TargetMarket;

public class TargetMarketConnection {

	public static void savE(TargetMarket targetMarket) {
		request(createTargetMarket(targetMarket));

	}

	public static List<TargetMarket> findALL() {
		List<TargetMarket> list = new ArrayList<TargetMarket>();
		try {
			Connection connection = connectionNow();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(findAllTargetMarket());

			while (rs.next()) {

				TargetMarket targetMarket = new TargetMarket(rs.getInt("targetId"), rs.getString("name"));
				list.add(targetMarket);
			}
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		}
		return list;
	}

	public static TargetMarket findByID(Integer id) {
		TargetMarket targetMarket = new TargetMarket();

		try {
			Connection connection = connectionNow();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(Sql.findByIdTargetMarket(id));

			while (rs.next()) {

				targetMarket = new TargetMarket(rs.getInt("targetId"), rs.getString("name"));

			}
		} catch (SQLException e) {
			targetMarket = null;
			e.printStackTrace();
		}
		return targetMarket;

	}

	public static List<TargetMarket> findTargetMarketByProductId(Integer productId) {
		List<TargetMarket> list = new ArrayList<TargetMarket>();
		try {
			Connection connection = connectionNow();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(findTargetMarketByProductID(productId));

			while (rs.next()) {

				TargetMarket targetMarket = new TargetMarket(rs.getInt("targetId"), rs.getString("name"));
				list.add(targetMarket);
			}
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		}
		return list;
	}

}
