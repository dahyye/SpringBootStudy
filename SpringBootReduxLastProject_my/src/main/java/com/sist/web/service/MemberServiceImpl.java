package com.sist.web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.MemberRepository;
import com.sist.web.entity.MemberEntity;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberRepository mDao; 
	
	@Override
	public MemberEntity findByIdAndPwd(String id, String pwd) {
		// TODO Auto-generated method stub
		return mDao.findByIdAndPwd(id, pwd);
	}

	@Override
	public Optional<MemberEntity> findById(String id) {
		// TODO Auto-generated method stub
		return mDao.findById(id);
	}

}
