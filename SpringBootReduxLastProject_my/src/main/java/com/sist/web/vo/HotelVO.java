package com.sist.web.vo;


public interface HotelVO {
	public String getTitle();
	public String getAddress();
	public String getOverview();
	public int getContent_id();
	public String getCheck_in_time();
	public String getCheck_tut_time();
	public String getAccom_count();
	public String getChkcooking();
	public String getInfo_center();
	public String getParking();
	public String getRoom_count();
	public String getSubfacility();
	public String getImage();  // 추가된 대표 이미지 컬럼
}
