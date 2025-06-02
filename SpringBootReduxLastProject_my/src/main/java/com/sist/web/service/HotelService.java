package com.sist.web.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.HotelEntity;
import com.sist.web.vo.FoodVO;
import com.sist.web.vo.HotelVO;

public interface HotelService {
	public List<HotelVO> findRandom3Hotel1();
	public List<HotelVO> findRandom4Hotel();
	public List<HotelVO> hotelListData(@Param("start") int start);
	public int hotelTotalPage();
	public HotelEntity findByContent_id(@Param("content_id") int content_id);
}
