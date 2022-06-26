package br.com.lucas.gudee.model;

import java.util.List;
import java.util.Objects;

public class Product {

	private Integer productId;
	private String productName;
	private String description;
	private List<Stack> stack;
	private List<TargetMarket> targetMarket;

	public Product() {

	}

	public Product(String productName, String description) {
		super();
		this.productName = productName;
		this.description = description;
	}

	public Product(Integer productId, String productName, String description) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
	}
	
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getId() {
		return productId;
	}

	public void setId(Integer productId) {
		this.productId = productId;
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
	
	



	public List<Stack> getStack() {
		return stack;
	}

	public void setStack(List<Stack> stack) {
		this.stack = stack;
	}

	public List<TargetMarket> getTargetMarket() {
		return targetMarket;
	}

	public void setTargetMarket(List<TargetMarket> targetMarket) {
		this.targetMarket = targetMarket;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, productId, productName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(description, other.description) && Objects.equals(productId, other.productId)
				&& Objects.equals(productName, other.productName);
	}

}
