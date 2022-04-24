package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TodoEntity;
import com.example.demo.persistence.TodoRepository;

@Service
public class TodoService {
	@Autowired TodoRepository repository;
	
	public String testService() {
		// TodoEntity ����
		TodoEntity entity = TodoEntity.builder().title("My first todo item").build();
		// TodoEntity ����
		repository.save(entity);
		// TodoEntity ID(�⺻Ű)�� �˻�
		TodoEntity savedEntity = repository.findById(entity.getId()).get();
		// Ÿ��Ʋ ����
		return savedEntity.getTitle();
	}
}
