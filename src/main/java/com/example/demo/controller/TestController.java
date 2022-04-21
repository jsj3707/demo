package com.example.demo.controller;


import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test") // ���ҽ�
public class TestController {
//	@GetMapping
//	public String testController() {
//		return "Hello world!";
//	}

/*  �Ʒ� ������̼��� ������ 4.3���� �����ǽ� ������.
    @PostMapping
	@PutMapping
	@DeletMapping 	*/
	@GetMapping("/testGetMapping")
	public String testControllerWithPath() {
		return "Hello world! testGetMapping";
	}
	
	// pathVariable�� Ȱ���� GetMapping 
	// localhost:8080/test/123
	  
	@GetMapping("{id}") public String
	testControllerWithPathVariable(@PathVariable(required = false) int id) {
	    return "Hello world! ID : " + id; // result = Hello world! ID : 123 }
	} 
	// requestParam�� Ȱ���� GetMapping
	// localhost:8080/test/testRequestParam?id=999
	  
	@GetMapping("/testRequestParam") public String
	testControllerWithRequestParam(@RequestParam(required = false) int id){
	    return "Hello world! ID : " + id; //result = Hello world! ID : 999 
	}
	
	// requestBody�� Ȱ���� GetMapping
	@GetMapping("/testRequestBody")
	public String testControllerWithRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
		return "Hello world! ID : " + testRequestBodyDTO.getId() + " Message : " + testRequestBodyDTO.getMessage();
	}
}