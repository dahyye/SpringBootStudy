
package com.sist.web.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.entity.RecipeDetailEntity;
import com.sist.web.entity.RecipeEntity;
import com.sist.web.entity.RecipeVO;
import com.sist.web.dao.*;

@Service
public class RecipeServiceImpl implements RecipeService{
    @Autowired
    private RecipeRepository rDao;
    
    @Autowired
    private RecipeDetailRepository rdDao;
    
    
	@Override
	public Map recipeListData(int page) {
		// TODO Auto-generated method stub
		 /*
		   *    javascript 
		   *    
		   *    => JSON
		   *    List => []
		   *    Map => {} => 데이터를 여러개 모아서 전송 
		   *    VO => {}
		   */
		Map map=new HashMap();
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		List<RecipeVO> list=rDao.recipeListData(start, end);
		int totalpage=rDao.recipeTotalPage();
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		
		if (endPage>totalpage)
		  endPage=totalpage;
		 
		map.put("fList", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		return map;
	}

	@Override
	public Map recipeDetailData(int no) {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		RecipeDetailEntity vo = new RecipeDetailEntity();
		vo= rdDao.findByNo(no);
		
		String[] datas=vo.getFoodmake().split("\n");
		
		List<String> mList = new ArrayList<>();
		List<String> iList = new ArrayList<>();
		
		for(String d:datas)
		{
			StringTokenizer st = new StringTokenizer(d,"^");
			mList.add(st.nextToken());
			iList.add(st.nextToken());
		}
		
		String s=vo.getData();
		s=s.replaceAll("[구매]", "");
		vo.setData(s);
		String[] arr=s.split(",");
		List<String> dList=Arrays.asList(arr);
		
		map.put("mList", mList);
		map.put("iList", iList);
		map.put("dList", dList);
		map.put("vo", vo);
		return map;
	}

	@Override
	public int recipeTotalPage() {
		// TODO Auto-generated method stub
		return rDao.recipeTotalPage();
	}
	
	@Override
	public Map recipeFindData(int page, String title) {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		List<RecipeVO> list=rDao.recipeFindData(start, end, title);
		int totalpage=rDao.recipeFindTotalPage(title);
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
		
		if (endPage>totalpage)
		  endPage=totalpage;
		 
		map.put("rList", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		
		return map;
	}

	@Override
	public int recipeFindTotalPage(String title) {
		// TODO Auto-generated method stub
		return rDao.recipeFindTotalPage(title);
	}

}
