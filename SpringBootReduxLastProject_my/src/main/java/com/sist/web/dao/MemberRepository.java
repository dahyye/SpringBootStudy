package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.MemberEntity;

//JPA에서는 Spring이 JpaRepository를 상속한 인터페이스로 자동 인식을 한다 => Spring Data JPA의 자동 스캔 기능 덕분에 
//명확하게 의도 표현을 하고 싶으면 붙이는 것도 좋은 습관
@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, String>{
	MemberEntity findByIdAndPwd(String id, String pwd);
	//SELECT * FROM member WHERE id = ? AND pwd = ?
}


