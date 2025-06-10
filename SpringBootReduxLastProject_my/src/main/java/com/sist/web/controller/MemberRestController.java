package com.sist.web.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.MemberRepository;
import com.sist.web.entity.MemberEntity;
import com.sist.web.service.MemberService;
import com.sist.web.vo.MemberDTO;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3002", allowCredentials = "true")
public class MemberRestController {
	@Autowired
	private MemberService service;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody MemberDTO dto, HttpSession session)
	{
		String id = dto.getId();
		String pwd = dto.getPwd();
		System.out.println("아이디는 "+id+" ,비밀번호는 "+pwd);
		
		Optional<MemberEntity> optionalUser = service.findById(id);
		
		if(optionalUser.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("존재하지 않는 아이디입니다");
		}
		//회원이 있는 경우 get()으로 받아와
		MemberEntity dbuser = optionalUser.get();
		
		if(!dbuser.getPwd().equals(pwd))
		{
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("비밀번호가 일치하지 않습니다");
		}
		
		session.setAttribute("loginUser", dbuser.getId());
		
		return ResponseEntity.ok("로그인 성공");
	}
	
	@GetMapping("/checkLogin")
	public String checkLogin(HttpSession session)
	{
		String id = (String) session.getAttribute("loginUser");
		if(id!=null)
		{
			return "현재 로그인 중: "+ id;
		}
		else
		{
			return "로그인하지 않았습니다";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate(); // 세션 초기화
		return "로그아웃 되었습니다.";
	}
	
	
	
}
