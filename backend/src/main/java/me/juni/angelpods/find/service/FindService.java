package me.juni.angelpods.find.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.util.ArrayBuilders.BooleanBuilder;

import me.juni.angelpods.find.dto.FindSerachConditionDto;

@Service
public class FindService {
	
	

	public BooleanBuilder createSearchPredicate(FindSerachConditionDto condition) {
		return null;
	}


}
