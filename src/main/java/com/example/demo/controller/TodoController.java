package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.TodoDTO;
import com.example.demo.service.TodoService;
import com.example.demo.dto.ResponseDTO;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
	
	@Autowired TodoService todoService;
	
	@GetMapping("/test")
	public ResponseEntity<?> testTodo(){
		String str = todoService.testService();
		List<String> list = new ArrayList<String>();
		list.add(str);
		
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		
		return ResponseEntity.ok().body(response);
	}
	
	/* todoController 내가 스스로 구현해야됨.*/
	// RequestMapping
	public ResponseEntity<?> todoController(@RequestBody TodoDTO todoDTO) {
		
		// 메소드에 따른 리스폰스 변수 선언
		ResponseEntity<?> response;
		
		if(todoDTO.getId().equals(null)
		|| todoDTO.getTitle().equals(null)) {
			response = TodoControllerBadRequest();
		}
		else
		{
			response = TodoControllerResponseEntity(todoDTO);
		}
		
		return response;
	}
	
	// responseEntity return
    @GetMapping("/ResponseEntity")
    public ResponseEntity<?> TodoControllerResponseEntity(@RequestBody TodoDTO todoDTO){
    	List<String> list = new ArrayList<String>();
    	
		list.add("id    : " + todoDTO.getId()   );
		list.add("title : " + todoDTO.getTitle());
		list.add("done  : " + todoDTO.getDone() );
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		
	    // data object 리턴
		return ResponseEntity.ok().body(response);
    }
    
    // error return
    @GetMapping("/BadRequest")
    public ResponseEntity<?> TodoControllerBadRequest(){
    	List<String> list  = new ArrayList<String>();
    	list.add("you got BadRequest!");
    	ResponseDTO<String> badResponse  = ResponseDTO.<String>builder().data(list).build();
    	badResponse.setError("404");
		// http stauts를 400으로 리턴
    	return ResponseEntity.badRequest().body(badResponse);
    }
}