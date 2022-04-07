package me.juni.angelpods.find.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Find {

	@Id @GeneratedValue
	private Long id;
	private String mCategory;
	private String sCategory;
	private String lat;
	private String lng;
	private String title;
	private String description;
	private String iName;
	private LocalDateTime getTime;
	private String getLoc;
	private String phone;
	private LocalDateTime createdAt;
	private LocalDateTime lastUpdatedAt;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getLastUpdatedAt() {
		return lastUpdatedAt;
	}
	public void setLastUpdatedAt(LocalDateTime lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}
	
	private Find(Builder builder) {
		this.mCategory = builder.mCategory;
		this.sCategory = builder.sCategory;
		this.lat = builder.lat;
		this.lng = builder.lng;
		this.title = builder.title;
		this.description = builder.description;
		this.iName = builder.iName;
		this.getTime = builder.getTime;
		this.getLoc = builder.getLoc;
		this.phone = builder.phone;
		this.createdAt = builder.createdAt;
		this.lastUpdatedAt = builder.lastUpdatedAt;
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder {
		private String mCategory;
		private String sCategory;
		private String lat;
		private String lng;
		private String title;
		private String description;
		private String iName;
		private LocalDateTime getTime;
		private String getLoc;
		private String phone;
		private LocalDateTime createdAt;
		private LocalDateTime lastUpdatedAt;
		
		public Builder() {}
		public Builder mCategory(String val) {mCategory = val;return this;}
		public Builder sCategory(String val) {sCategory = val;return this;}
		public Builder lat(String val) {lat = val;return this;}
		public Builder lng(String val) {lng = val;return this;}
		public Builder title(String val) {title = val;return this;}
		public Builder description(String val) {description = val;return this;}
		public Builder iName(String val) {iName = val;return this;}
		public Builder getTime(LocalDateTime val) {getTime = val;return this;}
		public Builder getLoc(String val) {getLoc = val;return this;}
		public Builder phone(String val) {phone = val;return this;}
		public Builder createdAt(LocalDateTime val) {createdAt = val;return this;}
		public Builder lastUpdatedAt(LocalDateTime val) {lastUpdatedAt = val;return this;}
		
		public Find build() { return new Find(this);}
	}
	
	
}

