package com.kata.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.kata.model.RomanArabicCombinationBean;

public interface RomanArabicCombinationRepository extends PagingAndSortingRepository<RomanArabicCombinationBean, Long> {
	
	//Get all the combinations, and order them by arabic value descending
	List<RomanArabicCombinationBean> findAllByOrderByArabicValueDesc();
	
}
