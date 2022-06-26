package br.com.lucas.gudee.model;

public class TargetMarket {

	private Integer targetId;
	private String name;

	public TargetMarket() {

	}

	public TargetMarket(String name) {
		super();

		this.name = name;
	}

	public TargetMarket(Integer targetId, String name) {
		super();
		this.targetId = targetId;
		this.name = name;
	}

	public Integer getTargetId() {
		return targetId;
	}

	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
