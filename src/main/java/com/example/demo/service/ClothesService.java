package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Clothes;
import com.example.demo.repository.ClothesRepository;

@Service
@Transactional
public class ClothesService {

	@Autowired
	private ClothesRepository repository;

//	衣服検索を行う処理
	public List<Clothes> findClothes(Integer gender, String color) {
		return repository.findClothes(gender, color);
	}

}
