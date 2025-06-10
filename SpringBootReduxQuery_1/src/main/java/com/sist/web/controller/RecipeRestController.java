package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.entity.*;
import com.sist.web.service.*;
@CrossOrigin(origins="*")
@RestController
public class RecipeRestController {
  @Autowired
  private RecipeService rService;
  // const {isLoading,error,data}=useQuery() => 3 => tanStack-Query : 기능 추가 
  //                                                 오픈 소스 그룹 
  // 일반 => 권장 : JavaScript / TypeScript (가독성) 
  // Redux => TanStack-Query => ThymeLeaf (Git Actions , Docker) => CI/CD 
  // 본인 PR 
  
  @GetMapping("/recipe/list/{page}")
  public ResponseEntity<Map> food_list(@PathVariable("page") int page)
  {
	  Map map=new HashMap();
	  try
	  {
		  map = rService.recipeListData(page);
		  
	  }catch(Exception ex)
	  {
		  return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	  return new ResponseEntity<>(map,HttpStatus.OK); // 정상 수행 => 200
  }
  
  @GetMapping("/recipe/detail/{no}")
  public ResponseEntity<Map> recipe_detail(@PathVariable("no") int no)
  {
	  Map map=new HashMap();
	  
	  try {
		map = rService.recipeDetailData(no);
	  } catch (Exception e) {
		// TODO: handle exception
		  return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	  
	  return new ResponseEntity<Map>(map,HttpStatus.OK);
  }
  
  @GetMapping("/recipe/find/{page}/{title}")
  public ResponseEntity<Map> recipe_find(@PathVariable("page") int page, @PathVariable("title") String title)
  {
	  Map map =new HashMap();
	  
	  try {
		map = rService.recipeFindData(page, title);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return new ResponseEntity<Map>(map, HttpStatus.OK);
  }
}