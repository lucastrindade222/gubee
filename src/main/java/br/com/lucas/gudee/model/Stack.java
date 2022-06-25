package br.com.lucas.gudee.model;

public class Stack {

	private Integer stackId;
	private String nome;

	public Stack() {
	}
	public Stack(String nome) {
		this.nome = nome;
	}

	public Stack(Integer stackId, String nome) {
		super();
		this.stackId = stackId;
		this.nome = nome;
	}

	public Integer getStackId() {
		return stackId;
	}

	public void setStackId(Integer stackId) {
		this.stackId = stackId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
