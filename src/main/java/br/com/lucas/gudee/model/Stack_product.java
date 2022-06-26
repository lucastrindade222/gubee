package br.com.lucas.gudee.model;

public class Stack_product {

	private Integer stack_product;
	private Integer productIdFK;
	private Integer stackIdFk;

	public Stack_product() {

	}

	public Stack_product(Integer productIdFK, Integer stackIdFk) {
		super();

		this.productIdFK = productIdFK;
		this.stackIdFk = stackIdFk;
	}

	public Stack_product(Integer stack_product, Integer productIdFK, Integer stackIdFk) {
		super();
		this.stack_product = stack_product;
		this.productIdFK = productIdFK;
		this.stackIdFk = stackIdFk;
	}

	public Integer getStack_product() {
		return stack_product;
	}

	public void setStack_product(Integer stack_product) {
		this.stack_product = stack_product;
	}

	public Integer getProductIdFK() {
		return productIdFK;
	}

	public void setProductIdFK(Integer productIdFK) {
		this.productIdFK = productIdFK;
	}

	public Integer getStackIdFk() {
		return stackIdFk;
	}

	public void setStackIdFk(Integer stackIdFk) {
		this.stackIdFk = stackIdFk;
	}

}
