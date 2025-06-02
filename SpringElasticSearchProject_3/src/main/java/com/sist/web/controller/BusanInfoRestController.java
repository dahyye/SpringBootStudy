package com.sist.web.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.*;
import com.sist.web.entity.*;

@RestController
@CrossOrigin(origins = "*")
public class BusanInfoRestController {
	@Autowired
	private BusanInfoService bService;
	
	@GetMapping("/main_react")
	public Map main_react() {
		List<BusanInfoEntity> list1 = bService.getBusanInfoData(1);
		List<BusanInfoEntity> list2 = bService.getBusanInfoData(2);
		List<BusanInfoEntity> list3 = bService.getBusanInfoData(3);

		
		Map map = new HashMap<>();
		map.put("list1", list1);
		map.put("list2", list2);
		map.put("lis t3", list3);
		
		return map; 
	}
}
