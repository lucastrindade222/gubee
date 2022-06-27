package br.com.lucas.gudee.service;

import static br.com.lucas.gudee.connection.TargetMarketConnection.savE;

import java.sql.SQLException;
import java.util.List;

import br.com.lucas.gudee.connection.TargetMarketConnection;
import br.com.lucas.gudee.model.TargetMarket;

public class TargetMarketService {

	public void save(TargetMarket targetMarket) throws SQLException {

		savE(targetMarket);
	}

	public List<TargetMarket> findAll() throws SQLException {
		List<TargetMarket> list = TargetMarketConnection.findALL();
		return list;
	}

	public TargetMarket findById(Integer id) throws SQLException {
		TargetMarket targetMarket =	TargetMarketConnection.findByID(id);
		return targetMarket;
	}

}
