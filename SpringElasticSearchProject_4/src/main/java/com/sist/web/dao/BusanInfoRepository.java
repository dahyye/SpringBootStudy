package com.sist.web.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.BusanInfoEntity;

@Repository
public interface BusanInfoRepository extends ElasticsearchRepository<BusanInfoEntity, Integer> {
	public List<BusanInfoEntity> findBytitleContaining(@Param("title") String title);
	
	@Query("{\"match\":{\"title\":\"*?0*\"}}")
	public List<BusanInfoEntity> busanFindData(@Param("title") String title);
	
	public List<BusanInfoEntity> findByCno(@Param("cno") Integer cno);
	
	@Query("{\"match\":{\"cno\":?0}}")
	public List<BusanInfoEntity> busanCndata(@Param("cno") Integer cno);
	
	public Optional<BusanInfoEntity> findByID(@Param("id") Integer id);
	
	@Query("{\"match\":{\"cno\":?0}}")
	public BusanInfoEntity busanDetailData(@Param("id") Integer id);	
	
}
