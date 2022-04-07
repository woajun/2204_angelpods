package me.juni.angelpods.posting.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Posting {

	@Id @GeneratedValue
	private Long id;
	//TODO Enum TYPE lost or find
	private String type; // 분실물, 습득물
	private String prntCate;
	private String cildCate;
	private double lat;
	private double lng;
	private String title;
	private String description;
	private String iName;
	private Instant OccurAt; // 분실시간, 습득시간
	private String OccurRocation;
	private String phone;
	private Instant createdAt;
	private Instant updatedAt;
	
	
}
