package model;

public class Process {
	
	private Integer id;
	private String name;
	private Integer returnsAmount;
	
	public Process() {
		super();
	}

	public Process(Integer id, String name, Integer returnsAmount) {
		this.id = id;
		this.name = name;
		this.returnsAmount = returnsAmount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getReturnsAmount() {
		return returnsAmount;
	}

	public void setReturnsAmount(Integer returnsAmount) {
		this.returnsAmount = returnsAmount;
	}

	@Override
	public String toString() {
		return "ID " + id + ": " + name + ", Returns amount = " + returnsAmount;
	}

}
