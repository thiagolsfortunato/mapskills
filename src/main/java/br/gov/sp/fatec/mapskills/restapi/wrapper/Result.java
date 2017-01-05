package br.gov.sp.fatec.mapskills.restapi.wrapper;

public class Result {
	
	private final String type;
	private final String description;
	private final long value;
	
	public Result(final String type, final String description, final long value) {
		this.type = type;
		this.description = description;
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public long getValue() {
		return value;
	}

}
