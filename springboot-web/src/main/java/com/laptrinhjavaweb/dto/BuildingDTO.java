package com.laptrinhjavaweb.dto;

import java.util.ArrayList;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BuildingDTO  extends AbstractDTO<BuildingDTO>{
	
private String name ;
private Integer numberOfBasement;
private Integer floorArea;
private String ward;
private String district;
private String srteet;
private String direction;
private String level;
private Integer rentPrice;
private String rentPriceDescription;
private String serviceFee;
private Integer carFee;
private String motoFee;
private String overtimeFee;
private String waterFee;
private String electricityFee;
private String deposit;
private String payment;
private String rentTime;
private String decorationTime;
private Float brokerageFee;
private ArrayList<String> types ;
private String note;
private String linkBuilding;
private String map;
private String avatar;
private String rentArea;
private Integer rentAreaFrom;
private Integer rentAreaTo;
private Integer rentPriceFrom;
private Integer rentPriceTo;
private ArrayList<String> rentAreas ;
private String manager;
private String managerMobile;
private String staffUserName;

}
