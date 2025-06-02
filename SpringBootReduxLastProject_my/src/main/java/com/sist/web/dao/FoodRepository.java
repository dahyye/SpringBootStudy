package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.FoodEntity;
import com.sist.web.vo.FoodVO;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Integer>{
	@Query(value = "SELECT fno, poster, name, type, score, content, address "
			+ "FROM food ORDER BY RAND() LIMIT 1", nativeQuery = true)
	public FoodVO findRandomFood();
	
	@Query(value = "SELECT fno, poster, name, type, score, content, address "
			+ "FROM food ORDER BY score DESC LIMIT 0,5", nativeQuery = true)
	public List<FoodVO> findBest5FoodList();
	
}
