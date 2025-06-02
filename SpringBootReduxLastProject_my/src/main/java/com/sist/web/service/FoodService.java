package com.sist.web.service;

import java.util.List;

import com.sist.web.vo.FoodVO;

public interface FoodService {
	public FoodVO findRandomFood();
	public List<FoodVO> findBest5FoodList();

}
