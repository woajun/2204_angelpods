package me.juni.angelpods.category.dto;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO {
	private String mCategory;
	private List<String> sCategory = new ArrayList<>();
	
	public CategoryDTO(String mCategory) {
		this.mCategory = mCategory;
	}
	
	public String getmCategory() {
		return mCategory;
	}
	public void setmCategory(String mCategory) {
		this.mCategory = mCategory;
	}
	public List<String> getsCategory() {
		return sCategory;
	}
}
