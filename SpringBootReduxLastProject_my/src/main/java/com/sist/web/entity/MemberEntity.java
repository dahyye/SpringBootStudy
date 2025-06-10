package com.sist.web.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity(name="member2")
@Data
public class MemberEntity {
	@Id
	@Column(name="id", length=20)
	private String id;
	@Column(name="pwd", nullable=false, length=10)
	private String pwd;
	@Column(name="name", length=10)
	private String name;
	@Column(name="sex", length=6)
	private String sex;
	@Column(name="email", length=100)
	private String email;
	@Column(name="birthday", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date birthday;
	@Column(name="address", nullable=false, length=100)
	private String address;
	@Column(name="regdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date regdate = new Date();
}
