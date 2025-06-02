package com.sist.web.vo;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/*
id int 
NAME text 
TYPE text 
PHONE text 
ADDRESS text 
SCORE double 
THEME text 
POSTER text 
IMAGES text 
TIME text 
PARKING text 
CONTENT text 
HIT int 
PRICE text 
JJIMCOUNT int 
LIKECOUNT int 
REPLYCOUNT int
 */
@Entity(name="busan_food") // 테이블명
@Data
@DynamicUpdate // 원하는 데이터만 가지고 들어올 때
public class BusanFoodEntity {
	@Id
	private int fno;
	private String name,type,phone,address,poster,images,time,parking,content,price;
	private int hit, jjimcount,likecount,replycount;
}
