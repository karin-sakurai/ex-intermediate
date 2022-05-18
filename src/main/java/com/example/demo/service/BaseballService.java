package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Baseballteam;
import com.example.demo.repository.BaseballRepository;

@Service
@Transactional
public class BaseballService {

	@Autowired
	private BaseballRepository repository;

//	repositoryのloadメソッドを呼ぶ処理
	public Baseballteam load(Integer id) {
		return repository.load(id);
	}

//	repositoryのfindAllメソッドを呼ぶ処理
	public List<Baseballteam> findAll() {
		return repository.findAll();
	}

}
