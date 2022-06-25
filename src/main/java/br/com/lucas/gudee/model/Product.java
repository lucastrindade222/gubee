package br.com.lucas.gudee.model;

public class Product {

	private Integer productId;
	private String productName;
	private String description;

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

}
