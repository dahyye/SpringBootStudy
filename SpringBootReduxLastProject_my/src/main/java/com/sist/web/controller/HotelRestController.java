package com.sist.web.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.HotelRepository;
import com.sist.web.entity.HotelEntity;
import com.sist.web.service.FoodService;
import com.sist.web.service.HotelService;
import com.sist.web.vo.FoodVO;
import com.sist.web.vo.HotelVO;

@RestController
@CrossOrigin(origins="*")
public class HotelRestController {
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private FoodService foodService;
	
	@GetMapping("/main_react")
	public Map main_data()
	{
		Map map = new HashMap<>();
		FoodVO fvo = foodService.findRandomFood();
		List<HotelVO> h1List = hotelService.findRandom3Hotel1();
		List<HotelVO> h2List = hotelService.findRandom3Hotel1();
		List<FoodVO> fList = foodService.findBest5FoodList();
		List<HotelVO> hList = hotelService.findRandom4Hotel();
		map.put("fvo", fvo);
		map.put("h1List", h1List);
		map.put("h2List", h2List);
		map.put("fList", fList);
		map.put("hList", hList);
		return map;
	}
	
	@GetMapping("/hotel/list_react")
	public Map hotel_list(@RequestParam("page") int page)
	{
		Map map = new HashMap<>();
		
		int rowSize=6;
		int start = (page-1)*rowSize;
		List<HotelVO> list = hotelService.hotelListData(start);
		
		int totalpage=hotelService.hotelTotalPage();
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("list", list);
		return map;
	}
	
	@GetMapping("/hotel/detail_react")
	public HotelEntity hotel_detail(@RequestParam("content_id") int content_id)
	{
		System.out.println("디테일");
		HotelEntity vo = hotelService.findByContent_id(content_id);
		return vo;
	}
	
}
