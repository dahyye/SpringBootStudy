package com.sist.web.service;

import java.util.Optional;

import com.sist.web.entity.MemberEntity;

public interface MemberService {
	public MemberEntity findByIdAndPwd(String id, String pwd);
	public Optional<MemberEntity> findById(String id);
}
