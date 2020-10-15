package com.laptrinhjavaweb.emun;

public enum TypeBuilding {
	TANG_TRET("Tầng trệt"), NGUYEN_CAN("Nguyên căn"), NOI_THAT("Nội thất");

	private String name;

	private TypeBuilding(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
