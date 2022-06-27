package br.com.lucas.gudee.dto;

public class ProductLinkStringDTO {

	private String stack;
	private String maket;
	private Integer product;

	public ProductLinkStringDTO() {

	}

	public ProductLinkStringDTO(String stack, String maket, Integer product) {
		super();
		this.stack = stack;
		this.maket = maket;
		this.product = product;
	}

	public String getMaket() {
		return maket;
	}

	public void setMaket(String maket) {
		this.maket = maket;
	}

	public Integer getProduct() {
		return product;
	}

	public void setProduct(Integer product) {
		this.product = product;
	}

	public String getStack() {
		return stack;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}

	@Override
	public String toString() {
		return "ProductLinkStringDTO [stack=" + stack + ", maket=" + maket + ", product=" + product + "]";
	}
	
	

}
