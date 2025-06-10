package com.sist.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;

import com.sist.web.entity.RecipeDetailEntity;
import com.sist.web.entity.RecipeEntity;
import com.sist.web.entity.RecipeVO;
// cookie / session 
public interface RecipeService {
	public Map recipeListData(int page);
    //public RecipeEntity recipeDetailData(int no);
    public int recipeTotalPage();
    public Map recipeDetailData(int no);
    public Map recipeFindData(int start, String title);
    public int recipeFindTotalPage(String title);
}