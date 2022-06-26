package br.com.lucas.gudee.model;

public class Targe_product {

	private Integer targe_product;
	private Integer targeIdFk;
	private Integer productIdFK;

	public Targe_product() {

	}

	public Targe_product(Integer targeIdFk, Integer productIdFK) {
		super();

		this.targeIdFk = targeIdFk;
		this.productIdFK = productIdFK;
	}

	public Targe_product(Integer targe_product, Integer targeIdFk, Integer productIdFK) {
		super();
		this.targe_product = targe_product;
		this.targeIdFk = targeIdFk;
		this.productIdFK = productIdFK;
	}

	public Integer getTarge_product() {
		return targe_product;
	}

	public void setTarge_product(Integer targe_product) {
		this.targe_product = targe_product;
	}

	public Integer getTargeIdFk() {
		return targeIdFk;
	}

	public void setTargeIdFk(Integer targeIdFk) {
		this.targeIdFk = targeIdFk;
	}

	public Integer getProductIdFK() {
		return productIdFK;
	}

	public void setProductIdFK(Integer productIdFK) {
		this.productIdFK = productIdFK;
	}

}
