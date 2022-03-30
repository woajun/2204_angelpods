package me.juni.angelpods.categoryParent;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import me.juni.angelpods.categoryChild.CategoryChild;

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


