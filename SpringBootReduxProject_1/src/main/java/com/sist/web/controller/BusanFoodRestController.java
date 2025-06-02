package com.sist.web.controller;
import java.util.*;
import com.sist.web.vo.*;
import com.sist.web.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*") // 모든 포트 허용
@RestController
public class BusanFoodRestController {
	@Autowired
	private BusanFoodRepository bDao;
	
	@GetMapping("/food/list_react")
	public Map food_list(@RequestParam("page") int page)
	{
		int rowSize=10;
		int start = (page*rowSize)-rowSize; 
		//LIMIT은 번호가 0부터 시작
		List<BusanFoodVO> list = bDao.busanListData(start);
		int count=(int)bDao.count();
		int totalpage=(int)(Math.ceil(count/12.0));
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
				
		Map map = new HashMap<>();
		
		map.put("list", list);
		map.put("curpage", page);
		map.put("count", count);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		return map;
	}
	
}
