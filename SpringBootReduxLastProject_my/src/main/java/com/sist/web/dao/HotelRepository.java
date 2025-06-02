package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.HotelEntity;
import com.sist.web.vo.FoodVO;
import com.sist.web.vo.HotelVO;

import java.util.*;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Integer>{
	@Query(value = "SELECT title,address,overview,content_id, check_in_time, check_out_time, accom_count, chkcooking, info_center, parking, room_count, subfacility, image FROM hotel ORDER BY RAND() LIMIT 3", nativeQuery = true)
	public List<HotelVO> findRandom3Hotel1();
	
	@Query(value = "SELECT title, address, overview, content_id, check_in_time, check_out_time, " +
            "accom_count, chkcooking, info_center, parking, room_count, subfacility, image " +
            "FROM hotel WHERE title LIKE '%호텔%' ORDER BY RAND() LIMIT 0,4", nativeQuery = true)
	public List<HotelVO> findRandom4Hotel();
	
	@Query(value = "SELECT title, address, overview, content_id, check_in_time, check_out_time, " +
            "accom_count, chkcooking, info_center, parking, room_count, subfacility, image " +
            "FROM hotel ORDER BY content_id ASC LIMIT :start,6", nativeQuery = true)
	public List<HotelVO> hotelListData(@Param("start") int start);
	
	@Query(value= "SELECT CEIL(COUNT(*)/6) FROM hotel")
	public int hotelTotalPage();
	
	public HotelEntity findByContentId(@Param("content_id") int content_id);
	
}

