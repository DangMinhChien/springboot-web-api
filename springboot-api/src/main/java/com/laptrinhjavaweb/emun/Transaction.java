package com.laptrinhjavaweb.emun;

public enum Transaction {
	QUA_TRINH_CSKH("Quá trình CSKH"), DAN_DI_XEM("Dẫn đi xem");

	private String name;

	private Transaction(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
