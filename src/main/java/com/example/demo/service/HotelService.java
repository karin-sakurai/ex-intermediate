package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Hotel;
import com.example.demo.repository.HotelRepository;

@Service
@Transactional
public class HotelService {

	@Autowired
	private HotelRepository repository;

//	ホテルの料金検索をする処理
	public List<Hotel> findByPrice(Integer price) {
		if (price == null) {
			return repository.findAll();
		} else if (price == ' ') {
			return repository.findAll();
		} else {
		return repository.findByPrice(price);
		}
	}

}
