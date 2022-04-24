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
@RequestMapping("test") // 리소스
public class TestController {
//	@GetMapping
//	public String testController() {
//		return "Hello world!";
//	}

/*  아래 어노테이션은 스프링 4.3부터 지원되식 시작함.
    @PostMapping
	@PutMapping
	@DeletMapping 	*/
	@GetMapping("/testGetMapping")
	public String testControllerWithPath() {
		return "Hello world! testGetMapping";
	}

	// pathVariable를 활용한 GetMapping
	// localhost:8080/test/123

	@GetMapping("{id}") public String
	testControllerWithPathVariable(@PathVariable(required = false) int id) {
	    return "Hello world! ID : " + id; // result = Hello world! ID : 123 }
	}
	// requestParam을 활용한 GetMapping
	// localhost:8080/test/testRequestParam?id=999

	@GetMapping("/testRequestParam") public String
	testControllerWithRequestParam(@RequestParam(required = false) int id){
	    return "Hello world! ID : " + id; //result = Hello world! ID : 999
	}

	//requestBody를 활용한 GetMapping
	@GetMapping("/testRequestBody")
	public String testControllerWithRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
		return "Hello world! ID : " + testRequestBodyDTO.getId() + " Message : " + testRequestBodyDTO.getMessage();
	}
	//responsebody control
	@GetMapping("/testResponseBody")
	public ResponseDTO<String> testControllerResponseBody() {
		// ArrayList 생성
		List<String> list = new ArrayList();
		// list변수에 데이터 적재
		list.add("Hello world! I'm ResponseDTO");
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();

		return response;
	}
	// responseEntity control
	@GetMapping("/testResponseEntity")
	public ResponseEntity<?> testControllerResponseEntity() {
		List<String> list = new ArrayList();
		list.add("Hello world! I'm ResponseEntity. And you got 400!");
		ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
		// http stauts를 400으로 리턴
		return ResponseEntity.badRequest().body(response);
	}
}
