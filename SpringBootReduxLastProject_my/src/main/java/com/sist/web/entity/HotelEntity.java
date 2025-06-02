package com.sist.web.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity(name="hotel")
@Data
public class HotelEntity {
	@Id
	@Column(name = "content_id")
	private int contentId;

    private String check_in_time;
    private String check_out_time;
    private String accom_count;
    private String chkcooking;
    private String info_center;
    private String parking;
    private String room_count;
    private String subfacility;

    private int barbecue;
    private int beauty;
    private int beverage;
    private int bicycle;
    private int campfire;
    private int karaoke;
    private int fitness;
    private int publicbath;
    private int sauna;
    private int seminar;
    private int sports;

    private String refund_regulation;
    private String image;
}
