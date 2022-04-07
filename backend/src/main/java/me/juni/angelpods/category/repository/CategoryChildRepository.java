package me.juni.angelpods.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.juni.angelpods.category.entity.CategoryChild;
import me.juni.angelpods.category.entity.CategoryChildID;

public interface CategoryChildRepository extends JpaRepository<CategoryChild, CategoryChildID> {

}
