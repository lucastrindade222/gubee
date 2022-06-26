package br.com.lucas.gudee.model;

public class Stack {

	private Integer stackId;
	private String name;

	public Stack() {
	}
	public Stack(String name) {
		this.name = name;
	}

	public Stack(Integer stackId, String name) {
		super();
		this.stackId = stackId;
		this.name = name;
	}

	public Integer getStackId() {
		return stackId;
	}

	public void setStackId(Integer stackId) {
		this.stackId = stackId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
