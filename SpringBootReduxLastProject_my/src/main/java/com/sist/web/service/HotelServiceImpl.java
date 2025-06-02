package com.sist.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.HotelRepository;
import com.sist.web.entity.HotelEntity;
import com.sist.web.vo.FoodVO;
import com.sist.web.vo.HotelVO;

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelRepository hDao;

	@Override
	public List<HotelVO> findRandom3Hotel1() {
		List<HotelVO> h1List = hDao.findRandom3Hotel1();
		return h1List;
	}

	@Override
	public List<HotelVO> findRandom4Hotel() {
		List<HotelVO> h1List = hDao.findRandom4Hotel();
		return h1List;
	}

	@Override
	public List<HotelVO> hotelListData(int start) {
		List<HotelVO> list = hDao.hotelListData(start);
		return list;
	}

	@Override
	public int hotelTotalPage() {
		int totalpage=hDao.hotelTotalPage();
		return totalpage;
	}

	@Override
	public HotelEntity findByContent_id(int content_id) {
		HotelEntity vo = hDao.findByContentId(content_id);
		return vo;
	}
	
	
}
