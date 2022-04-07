package me.juni.angelpods.find.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import me.juni.angelpods.find.entity.Find;


public class FindCreateDto {

	@NotBlank
	private String userId;
	@NotBlank
	private String mCategory;
	private String sCategory;
	@NotBlank
	private String lat;
	@NotBlank
	private String lng;
	@NotBlank
	private String title;
	private String desc;
	private String iName;
	private LocalDateTime getTime;
	private String getLoc;
	private String phone;
	
	
	public Find createFind() {
		Find find = Find.builder()
		   .mCategory(mCategory)
		   .sCategory(sCategory)
		   .lat(lat)
		   .lng(lng)
		   .title(title)
		   .description(desc)
		   .iName(iName)
		   .getTime(getTime)
		   .getLoc(getLoc)
		   .phone(phone)
		   .createdAt(LocalDateTime.now())
		   .lastUpdatedAt(LocalDateTime.now())
		   .build();
		return find;
	}
	
	
	public FindCreateDto() {
	}
	
	public FindCreateDto(String userId, String mCategory, String sCategory, String lat, String lng, String title,
			String desc, String iName, LocalDateTime getTime, String getLoc, String phone) {
		this.userId = userId;
		this.mCategory = mCategory;
		this.sCategory = sCategory;
		this.lat = lat;
		this.lng = lng;
		this.title = title;
		this.desc = desc;
		this.iName = iName;
		this.getTime = getTime;
		this.getLoc = getLoc;
		this.phone = phone;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getmCategory() {
		return mCategory;
	}
	public void setmCategory(String mCategory) {
		this.mCategory = mCategory;
	}
	public String getsCategory() {
		return sCategory;
	}
	public void setsCategory(String sCategory) {
		this.sCategory = sCategory;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getiName() {
		return iName;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	public LocalDateTime getGetTime() {
		return getTime;
	}
	public void setGetTime(LocalDateTime getTime) {
		this.getTime = getTime;
	}
	public String getGetLoc() {
		return getLoc;
	}
	public void setGetLoc(String getLoc) {
		this.getLoc = getLoc;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
