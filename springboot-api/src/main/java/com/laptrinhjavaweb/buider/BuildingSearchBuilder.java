package com.laptrinhjavaweb.buider;

import java.util.ArrayList;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class BuildingSearchBuilder {
	private String name;
	private Integer numberOfBasement;
	private Integer floorArea;
	private String district;
	private String ward;
	private String srteet;
	private String direction;
	private String level;
	private ArrayList<String> types = new ArrayList<String>();
	private Integer rentAreaFrom;
	private Integer rentAreaTo;
	private Integer rentPriceFrom;
	private Integer rentPriceTo;
	private String manager;
	private String managerMobile;
	private String staffUserName;
}
