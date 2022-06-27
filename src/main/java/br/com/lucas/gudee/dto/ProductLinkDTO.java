package br.com.lucas.gudee.dto;

import java.util.List;

public class ProductLinkDTO {

	private Integer produto;
	private List<Integer> stack;
	private List<Integer> TargetMarket;

	public ProductLinkDTO() {

	}

	public ProductLinkDTO(Integer produto, List<Integer> stack, List<Integer> targetMarket) {
		super();
		this.produto = produto;
		this.stack = stack;
		this.TargetMarket = targetMarket;
	}

	public Integer getProduto() {
		return produto;
	}

	public void setProduto(Integer produto) {
		this.produto = produto;
	}

	public List<Integer> getStack() {
		return stack;
	}

	public void setStack(List<Integer> stack) {
		this.stack = stack;
	}

	public List<Integer> getTargetMarket() {
		return TargetMarket;
	}

	public void setTargetMarket(List<Integer> targetMarket) {
		TargetMarket = targetMarket;
	}

}
