package me.juni.angelpods.category.entity;

import java.io.Serializable;
import java.util.Objects;

public class CategoryChildID implements Serializable{
	// 직렬화를 할 때 선언하길 권장
	private static final long serialVersionUID = 1L;
	
	private String categoryParentID;
	private String categoryChildID;
	
	public CategoryChildID() {
	}

	public CategoryChildID(String categoryParentID, String categoryChildID) {
		this.categoryParentID = categoryParentID;
		this.categoryChildID = categoryChildID;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(categoryChildID, categoryParentID);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryChildID other = (CategoryChildID) obj;
		return Objects.equals(categoryChildID, other.categoryChildID)
				&& Objects.equals(categoryParentID, other.categoryParentID);
	}
	
}
