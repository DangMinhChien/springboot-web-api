package com.laptrinhjavaweb.emun;

public enum District {
	QUAN_1("Quận 1"),
	QUAN_2("Quận 2"),
	QUAN_3("Quận 3"),
	QUAN_4("Quận 4"),
	QUAN5("Quận 5"),
	QUAN_6("Quận 6"),
	QUAN_7("Quận 7"),
	QUAN_8("Quận 8"),
	QUAN_9("Quận 9"),
	QUAN_10("Quận 10"),
	QUAN_11("Quận 11"),
	QUAN_12("Quận 12"),
	QUAN_BINH_THANH("Quận Bình Thạnh"),
	QUAN_THU_DUC("Quận Thủ Đức"),
	HUYEN_GO_VAP("Huyện Gò Vấp"),
	QUAN_PHU_NHUAN("Quận Phú Nhuận"), 
	HUYEN_HOC_MON("Huyện Hóc Môn"), 
	HUYEN_BINH_CHANH("Huyện Bình Chánh"),
	HUYEN_CHU_CHI("Huyện Củ Chi"), 
	QUAN_CAN_GIO("Quận Cần Giờ"), 
	QUAN_TAN_BINH("Quận Tân Bình"),
	QUAN_TAN_PHU("Quận Tân Phú"),
	QUAN_BINH_TAN("Quận Bình Tân"),
	QUAN_NHA_BE("Quận Nhà Bè"),;

	private String name;

	private District(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

}
