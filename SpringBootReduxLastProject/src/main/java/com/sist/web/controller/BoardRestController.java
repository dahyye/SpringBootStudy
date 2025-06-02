package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sist.web.entity.*;
import com.sist.web.dao.*;

import java.text.SimpleDateFormat;
import java.util.*;
@RestController
// => RestFul => GET(읽기), POST(쓰기), PUT(수정하기), DELETE(삭제)
@CrossOrigin(origins="*") //모든 port 허용
// 1521 / 8080 => AWS는 0~1023까지는 port를 접근거부시킨다
public class BoardRestController {
	@Autowired
	private BoardRepository bDao;
	
	@GetMapping("/board/list_react/{page}")
	public Map board_list(@PathVariable("page") int page)
	{
		Map map = new HashMap<>();
		int rowSize=10;
		int start=(page-1)*rowSize;
		
		List<BoardEntity> list = bDao.boardListData(start);
		for(BoardEntity vo : list)
		{
			String day = vo.getRegdate();
			day=day.substring(0,day.indexOf(" "));
			vo.setRegdate(day.trim());
		}
		int count=(int)bDao.count();
		int totalpage=(int)(Math.ceil(count/(double)rowSize));
		String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		map.put("list", list);
		map.put("today", today);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		return map;
	}
	
	@PostMapping("/board/insert_react")
	public Map board_insert(@RequestBody BoardEntity vo)
	{
		Map map = new HashMap<>();
		try {
			vo.setHit(0);
			BoardEntity _vo = bDao.save(vo);
			
			map.put("vo", _vo);
			map.put("msg", "yes");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("msg", e.getMessage());
		}
		
		return map;
	}
	
	/*
	 	JPA => DataSet => VO를 가지고 데이터베이스 제어
	 
	 
	 */
	@GetMapping("/board/detail_react/{no}")
	public BoardEntity board_detail(@PathVariable("no") int no) 
	{
		BoardEntity vo = bDao.findByNo(no);
		vo.setHit(vo.getHit()+1);
		bDao.save(vo);
		vo=bDao.findByNo(no);
		return vo;
	}
	
	@DeleteMapping("/board/delete_react/{no}/{pwd}")
	public Map board_delete(@PathVariable("no") int no, @PathVariable("pwd") String pwd)
	{
		Map map=new HashMap();
		String result="";
		BoardEntity vo = bDao.findByNo(no);
		System.out.println(vo);
		if(pwd.equals(vo.getPwd()))
		{
			bDao.delete(vo);
			result="yes";
		}
		else
		{
			result="no";
		}
		map.put("msg", result);
		return map;
	}
	
	@GetMapping("/board/update_react/{no}")
	public BoardEntity board_update(@PathVariable("no") int no)
	{
		BoardEntity vo = bDao.findByNo(no);
		
		return vo;
	}
	
	@PutMapping("/board/update_react_ok/{no}")
	public Map board_update_ok(@PathVariable("no") int no, @RequestBody BoardEntity vo)
	{
		Map map = new HashMap<>();
		BoardEntity db = bDao.findByNo(no);
		if(vo.getPwd().equals(db.getPwd()))
		{
			vo.setNo(no);
			vo.setHit(db.getHit());
			bDao.save(vo);
			map.put("msg", "yes");
		}
		else
		{
			map.put("msg", "no");
		}
		
		return map;
	}
	
}
