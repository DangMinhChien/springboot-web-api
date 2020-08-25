package com.laptrinhjavaweb.emun;

public enum TypeBuilding {
	TANG_TRET("TANG_TRET", "Tầng trệt"), 
    NGUYEN_CAN("NGUYEN_CAN",  "Nguyên căn"), 
    NOI_THAT("NOI_THAT", "Nội thất");
	private String name;
	private String value;

	private TypeBuilding(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
