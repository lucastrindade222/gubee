package br.com.lucas.gudee.dto;

import java.util.List;

import br.com.lucas.gudee.model.Product;
import br.com.lucas.gudee.model.Stack;
import br.com.lucas.gudee.model.TargetMarket;

public class ProductDTO {

	private String productName;
	private String description;
	private List<TargetMarket> targetMarket;
	private List<Stack> stack;

	public ProductDTO() {

	}

	public ProductDTO(Product product) {

		this.productName = product.getProductName();
		this.description = product.getDescription();
		this.targetMarket = product.getTargetMarket();
		this.stack = product.getStack();

	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<TargetMarket> getTargetMarket() {
		return targetMarket;
	}

	public void setTargetMarket(List<TargetMarket> targetMarket) {
		this.targetMarket = targetMarket;
	}

	public List<Stack> getStack() {
		return stack;
	}

	public void setStack(List<Stack> stack) {
		this.stack = stack;
	}

}
