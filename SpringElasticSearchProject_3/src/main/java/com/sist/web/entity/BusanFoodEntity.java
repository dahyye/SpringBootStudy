package com.sist.web.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Document(indexName = "busanfood")
@Setter
@Getter
public class BusanFoodEntity {
	@Id
	private int id;
	private int hit,jjimcount, replycount;
	private String name,type,phone,address,theme,poster,images,time,parking,content,price;
	private double score;
}
