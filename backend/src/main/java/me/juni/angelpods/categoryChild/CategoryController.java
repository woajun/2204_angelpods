package me.juni.angelpods.categoryChild;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.juni.angelpods.categoryParent.CategoryParent;
import me.juni.angelpods.categoryParent.CategoryParentRepository;

@CrossOrigin
@Controller
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired 
	CategoryParentRepository categoryParentRepository;
	
	@GetMapping
	public ResponseEntity<?> getAllCategory(){
		List<CategoryParent> parents = categoryParentRepository.findAll(Sort.by(Sort.Direction.ASC, "index"));
		List<CategoryDTO> dtos = makeCategoryDTOS(parents);
		return ResponseEntity.ok(dtos);
	}

	private List<CategoryDTO> makeCategoryDTOS(List<CategoryParent> parents) {
		List<CategoryDTO> dtos = new ArrayList<>();
		parents.stream()
		  .map((parent)-> {
			  CategoryDTO dto = new CategoryDTO(parent.getParentID());
			  List<String> sCategory = dto.getsCategory();
			  parent.getChildren().forEach((child)->{
				  sCategory.add(child.getCategoryChildID());
			  });
			  return dto;
		  	})
		  .forEach(dto-> dtos.add(dto));
		return dtos;
	}
}
