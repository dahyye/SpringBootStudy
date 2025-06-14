package com.sist.web.dao;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.BusanFoodEntity;
import com.sist.web.vo.BusanFoodVO;
@Repository
public interface BusanFoodRepository extends JpaRepository<BusanFoodEntity,Integer>{
	/*
	 * @Query(value="SELECT fno, name,poster FROM busan_food " + "ORDER BY fno ASC "
	 * + "LIMIT : ?1,12",nativeQuery=true) public List<BusanFoodVO>
	 * busanListData(@Param("start") Integer start);
	 */
	@Query(value = "SELECT fno, name, poster FROM busan_food ORDER BY fno ASC LIMIT 1, 12", nativeQuery = true)
	List<BusanFoodVO> busanListData(Integer start);
	//SELECT * FROM busan_food WHERE fno=?
	public BusanFoodEntity findByFno(int fno);
	
}
