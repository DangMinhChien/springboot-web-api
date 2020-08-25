package com.laptrinhjavaweb.emun;

public enum Transaction {
	QUA_TRINH_CSKH("QUA_TRINH_CSKH", "Quá trình CSKH"),
	DAN_DI_XEM("DAN_DI_XEM",  "Dẫn đi xem");
	private String name;
	private String value;

	private Transaction(String name, String value) {
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
