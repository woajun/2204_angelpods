package me.juni.angelpods.categoryChild;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CategoryChildID.class)
public class CategoryChild {
	
	@Id
	private String categoryParentID;
	@Id
	private String categoryChildID;
	private int index;
	
	public String getCategoryParentID() {
		return categoryParentID;
	}
	public void setCategoryParentID(String categoryParentID) {
		this.categoryParentID = categoryParentID;
	}
	public String getCategoryChildID() {
		return categoryChildID;
	}
	public void setCategoryChildID(String categoryChildID) {
		this.categoryChildID = categoryChildID;
	}
	public int getIndex() {
		return index;
	}
}
