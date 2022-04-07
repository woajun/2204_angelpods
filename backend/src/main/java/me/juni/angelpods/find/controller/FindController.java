package me.juni.angelpods.find.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.util.ArrayBuilders.BooleanBuilder;

import me.juni.angelpods.find.dto.FindCreateDto;
import me.juni.angelpods.find.dto.FindSerachConditionDto;
import me.juni.angelpods.find.entity.Find;
import me.juni.angelpods.find.repository.FindRepository;
import me.juni.angelpods.find.service.FindService;

@CrossOrigin
@Controller
@RequestMapping("/api/find")
public class FindController {

	@Autowired FindRepository findRepository;
	@Autowired FindService findService;
	
	// 1. 이미지 등록
	@PostMapping("/upload")
	public String saveImage(
			@RequestPart("json") FindCreateDto dto,
			@RequestParam("data") List<MultipartFile> files) {
		System.out.println(dto);
		for (MultipartFile file : files) {
			System.out.println(file.getOriginalFilename());
		}
		return "success";
	}
	

	// 2. 게시물 등록
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody FindCreateDto dto, Errors errors){
		if (errors.hasErrors()) {
			return ResponseEntity.badRequest().body(null);
		}
		Find newFind = dto.createFind();
		Find savedFind = findRepository.save(newFind);
		
		return ResponseEntity.created(null).body(savedFind); 
	}
	
	// 3. 목록 전체 조회
	@GetMapping
	public ResponseEntity<?> getFindAll(){
		List<Find> finded = findRepository.findAll();
		return ResponseEntity.ok(finded);
	}
	
	// 4. 목록 상세 조회
	@GetMapping("/{id}")
	public ResponseEntity<?> getDetail(@PathVariable Long id){
		Find find = findRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(find);
	}
	
	// 5. 목록 검색
	@GetMapping("/search")
	public ResponseEntity<?> serachList(@ModelAttribute FindSerachConditionDto condition ){
			BooleanBuilder predicate = findService.createSearchPredicate(condition);
		return null;
	}
}
