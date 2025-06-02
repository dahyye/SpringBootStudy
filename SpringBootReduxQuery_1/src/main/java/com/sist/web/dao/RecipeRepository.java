package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.RecipeEntity;
import com.sist.web.entity.RecipeVO;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Integer>{
	
	@Query(value="")
	public List<RecipeVO> recipeListData(@Param("start") Integer start, @Param("end") Integer end);

	public RecipeEntity findByNo(int no);
	
	@Query(value="")
	public int recipeTotalPage();
}
