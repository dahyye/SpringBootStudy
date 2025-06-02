package com.sist.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.sist.web.dao.BusanInfoRepository;
import com.sist.web.vo.BusanInfoEntity;

@Service
public class BusanInfoServiceImpl implements BusanInfoService{
	@Autowired
	private BusanInfoRepository bDao;

	@Override
	public List<BusanInfoEntity> busanAllData(int page) {
		// TODO Auto-generated method stub
		int rowSize=12;
		Pageable pg=PageRequest.of(page-1, rowSize, Sort.by(Sort.Direction.ASC,"id"));
		Page<BusanInfoEntity> pList = bDao.findAll(pg);
		List<BusanInfoEntity> list = new ArrayList<BusanInfoEntity>();
		
		return list;
	}

	@Override
	public List<BusanInfoEntity> findBytitleContaining(String title) {
		// TODO Auto-generated method stub
		return bDao.findBytitleContaining(title);
	}

	@Override
	public List<BusanInfoEntity> busanFindData(String title) {
		// TODO Auto-generated method stub
		return bDao.busanFindData(title);
	}

	@Override
	public List<BusanInfoEntity> findByCno(Integer cno) {
		// TODO Auto-generated method stub
		return bDao.findByCno(cno);
	}

	@Override
	public List<BusanInfoEntity> busanCndata(Integer cno) {
		// TODO Auto-generated method stub
		return bDao.busanCndata(cno);
	}

	@Override
	public Optional<BusanInfoEntity> findByID(Integer id) {
		// TODO Auto-generated method stub
		BusanInfoEntity b = bDao.findByID(id).orElse(new BusanInfoEntity());
		return bDao.findByID(id);
	}

	@Override
	public BusanInfoEntity busanDetailData(Integer id) {
		// TODO Auto-generated method stub
		return bDao.busanDetailData(id);
	}

}
