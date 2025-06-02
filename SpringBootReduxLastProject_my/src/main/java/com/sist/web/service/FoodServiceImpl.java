package com.sist.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.FoodRepository;
import com.sist.web.vo.FoodVO;

@Service
public class FoodServiceImpl implements FoodService{
	@Autowired
	private FoodRepository fDao;
	
	@Override
	public FoodVO findRandomFood() {
		// TODO Auto-generated method stub
		FoodVO fvo = fDao.findRandomFood();
		return fvo;
	}

	@Override
	public List<FoodVO> findBest5FoodList() {
		// TODO Auto-generated method stub
		return fDao.findBest5FoodList();
	}

}
