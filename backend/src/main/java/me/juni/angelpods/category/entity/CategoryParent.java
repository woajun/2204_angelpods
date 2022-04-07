package me.juni.angelpods.category.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class CategoryParent {
	@Id
	private String parentID;	
	private int index;
		
	@OneToMany(mappedBy="categoryParentID")
	@OrderBy("index ASC")
	private Set<CategoryChild> children = new HashSet<>();

	public String getParentID() {
		return parentID;
	}

	public Set<CategoryChild> getChildren() {
		return children;
	}

	public int getIndex() {
		return index;
	}
	
	
}


