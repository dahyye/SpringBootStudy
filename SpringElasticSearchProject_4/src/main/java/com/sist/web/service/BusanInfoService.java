package com.sist.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.sist.web.vo.BusanInfoEntity;

public interface BusanInfoService {
	public List<BusanInfoEntity> busanAllData(int page);
	// findAll
	public List<BusanInfoEntity> findBytitleContaining(@Param("title") String title);
	public List<BusanInfoEntity> busanFindData(@Param("title") String title);
	
	public List<BusanInfoEntity> findByCno(@Param("cno") Integer cno);
	public List<BusanInfoEntity> busanCndata(@Param("cno") Integer cno);
	
	public Optional<BusanInfoEntity> findByID(@Param("id") Integer id);
	public BusanInfoEntity busanDetailData(@Param("id") Integer id);
}
